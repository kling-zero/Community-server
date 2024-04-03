#include "pch.h"
#include "../include/KafkaClient.h"
#include <thread>

KafkaClient::DeliveryReportCb::DeliveryReportCb(std::function<void(RdKafka::Message&)> cf)
{
	this->cf = cf;
}

void KafkaClient::DeliveryReportCb::dr_cb(RdKafka::Message& message)
{
#ifdef _DEBUG
	if (message.err())
		std::cout << "% Message delivery failed: " << message.errstr() << std::endl;
	else
		std::cout << "% Message delivered to topic "
		<< message.topic_name()
		<< " [" << message.partition() << "] at offset "
		<< message.offset() << std::endl;
#endif
	// ���лص�
	cf(message);
}

void KafkaClient::ConsumerEventCb::event_cb(RdKafka::Event& event)
{
	switch (event.type())
	{
	case RdKafka::Event::EVENT_ERROR:
		if (event.fatal()) {
			std::cerr << "FATAL ";
		}
		std::cerr << "ERROR (" << RdKafka::err2str(event.err()) << "): " << event.str() << std::endl;
		break;
	case RdKafka::Event::EVENT_STATS:
		std::cerr << "\"STATS\": " << event.str() << std::endl;
		break;
	case RdKafka::Event::EVENT_LOG:
		fprintf(stderr, "LOG-%i-%s: %s\n", event.severity(), event.fac().c_str(), event.str().c_str());
		break;
	case RdKafka::Event::EVENT_THROTTLE:
		std::cerr << "THROTTLED: " << event.throttle_time()
			<< "ms by " << event.broker_name()
			<< " id " << (int)event.broker_id()
			<< std::endl;
		break;
	default:
		std::cerr << "EVENT " << event.type()
			<< " (" << RdKafka::err2str(event.err()) << "): "
			<< event.str() << std::endl;
		break;
	}
}

void KafkaClient::msg_consume(RdKafka::Message* message)
{
	switch (message->err()) {
	case RdKafka::ERR__TIMED_OUT:
		break;
	case RdKafka::ERR_NO_ERROR:
#ifdef _DEBUG
		std::cerr << "Read msg at offset " << message->offset() << std::endl;
		RdKafka::MessageTimestamp ts;
		ts = message->timestamp();
		if (ts.type != RdKafka::MessageTimestamp::MSG_TIMESTAMP_NOT_AVAILABLE) {
			std::string tsname = "?";
			if (ts.type == RdKafka::MessageTimestamp::MSG_TIMESTAMP_CREATE_TIME)
				tsname = "create time";
			else if (ts.type == RdKafka::MessageTimestamp::MSG_TIMESTAMP_LOG_APPEND_TIME)
				tsname = "log append time";
			std::cout << "Timestamp: " << tsname << " " << ts.timestamp << std::endl;
		}
#endif
		// ���ü�����������Ϣ
		lock.lock();
		for (auto listener : m_listeners)
		{
			if (message->topic_name() == listener->topic)
			{
				listener->receiveMessage(static_cast<const char*>(message->payload()));
			}
		}
		lock.unlock();
		break;
	case RdKafka::ERR__PARTITION_EOF:
		break;
	case RdKafka::ERR__UNKNOWN_TOPIC:
	case RdKafka::ERR__UNKNOWN_PARTITION:
		std::cerr << "Consume failed: " << message->errstr() << std::endl;
		break;
	}
}

KafkaClient::KafkaClient(const std::string& brokers, const std::string& groupId /*= "cpp-kafka"*/)
{
	this->m_brokers = brokers;
	this->m_groupId = groupId;
	this->m_topic = "";
	this->m_consumer = nullptr;
	this->m_producer = nullptr;
	this->isRevMessage = true;
}

KafkaClient::~KafkaClient()
{
	if (m_producer) delete m_producer;
}

bool KafkaClient::productMsg(const std::string& topic, const std::string& message, DeliveryReportCb* cb /*= nullptr*/)
{
	// ����һ�����մ�����Ϣ���ַ���
	std::string errstr;
	// ����������
	if (!m_producer || this->m_topic != topic)
	{
		// ���µ�ǰ������Ϣ����
		this->m_topic = topic;
		// ɾ��ԭ����������
		if (m_producer) {
			delete m_producer;
			m_producer = nullptr;
		}
		// �������ö���
		RdKafka::Conf* conf = RdKafka::Conf::create(RdKafka::Conf::CONF_GLOBAL);
		do
		{
			// ���÷���ڵ�
			if (conf->set("bootstrap.servers", m_brokers, errstr) != RdKafka::Conf::CONF_OK) {
				std::cerr << errstr << std::endl;
				break;
			}
			// ���ý����ص�
			if (cb)
			{
				if (conf->set("dr_cb", cb, errstr) != RdKafka::Conf::CONF_OK) {
					std::cerr << errstr << std::endl;
					break;
				}
			}
			// ����������
			m_producer = RdKafka::Producer::create(conf, errstr);
		} while (false);

		// �ͷ����ö���
		delete conf;

		// ����������ʧ��
		if (!m_producer) {
			std::cerr << "Failed to create producer: " << errstr << std::endl;
			return false;
		}
	}
	// ������Ϣ
retry:
	RdKafka::ErrorCode err = m_producer->produce(
		/* Topic name */
		topic,
		/* Any Partition: the builtin partitioner will be
		 * used to assign the message to a topic based
		 * on the message key, or random partition if
		 * the key is not set.
		 */
		RdKafka::Topic::PARTITION_UA,
		/* Make a copy of the value */
		RdKafka::Producer::RK_MSG_COPY,
		/* Value */
		const_cast<char*>(message.c_str()), message.size(),
		/* Key */
		nullptr, 0,
		/* Timestamp (defaults to current time) */
		0,
		/* Message headers, if any */
		nullptr,
		/* Per-message opaque value passed to
		 * delivery report
		 */
		nullptr);
	if (err != RdKafka::ERR_NO_ERROR) {
		std::cerr << "% Failed to produce to topic " << topic << ": " << RdKafka::err2str(err) << std::endl;
		/* If the internal queue is full, wait for
		 * messages to be delivered and then retry.
		 * The internal queue represents both
		 * messages to be sent and messages that have
		 * been sent or failed, awaiting their
		 * delivery report callback to be called.
		 *
		 * The internal queue is limited by the
		 * configuration property
		 * queue.buffering.max.messages
		 */
		if (err == RdKafka::ERR__QUEUE_FULL) {
			/* block for max 1000ms */
			m_producer->poll(1000);
			goto retry;
		}
		// ����Ϊ������
		m_producer->poll(0);
		return false;
	}
	else {
		std::cerr << "% Enqueued message (" << message.size() << " bytes) " << "for topic " << topic << std::endl;
		// ����Ϊ������
		m_producer->poll(0);
		/*
		 * Wait for final messages to be delivered or fail.
		 * flush() is an abstraction over poll() which
		 * waits for all messages to be delivered.
		 */
		m_producer->flush(10 * 1000 /* wait for max 10 seconds */);
		if (m_producer->outq_len() > 0) {
			std::cerr << "% " << m_producer->outq_len() << " message(s) were not delivered" << std::endl;
			return false;
		}
		return true;
	}
}

bool KafkaClient::subscribe(const std::vector<std::string>& topics)
{
	// �ж��Ƿ��Ѿ����й�����
	if (m_consumer)
	{
		std::cerr << "already subscribed, no need to subscribe again." << std::endl;
		return true;
	}

	// ����һ�����մ�����Ϣ���ַ���
	std::string errstr;
	// �������ö���
	RdKafka::Conf* conf = RdKafka::Conf::create(RdKafka::Conf::CONF_GLOBAL);
	do
	{
		// ���÷���ڵ�
		if (conf->set("metadata.broker.list", m_brokers, errstr) != RdKafka::Conf::CONF_OK) {
			std::cerr << errstr << std::endl;
			break;
		}
		// ���÷���ID
		if (conf->set("group.id", m_groupId, errstr) != RdKafka::Conf::CONF_OK) {
			std::cerr << errstr << std::endl;
			break;
		}
		// ���ú�̨�¼��ص�
		if (conf->set("event_cb", &m_ex_event_cb, errstr) != RdKafka::Conf::CONF_OK) {
			std::cerr << errstr << std::endl;
			break;
		}
		// ����������
		m_consumer = RdKafka::KafkaConsumer::create(conf, errstr);
	} while (false);

	// �ͷ����ö���
	delete conf;

	// ����������ʧ��
	if (!m_consumer) {
		std::cerr << "Failed to create consumer: " << errstr << std::endl;
		return false;
	}

	// ���������б�
	RdKafka::ErrorCode err = m_consumer->subscribe(topics);
	if (err) {
		std::cerr << "Failed to subscribe to " << topics.size() << " topics: " << RdKafka::err2str(err) << std::endl;
		delete m_consumer;
		m_consumer = nullptr;
		return false;
	}

	// ������Ϣ����
	std::thread revThread([=]()
		{
			// ѭ��������Ϣ
			while (isRevMessage) {
				RdKafka::Message* msg = m_consumer->consume(1000);
				msg_consume(msg);
				delete msg;
			}
			// ֹͣconsumer
			m_consumer->close();
			delete m_consumer;
			m_consumer = nullptr;
		});
	revThread.detach();
	return true;
}

void KafkaClient::unsubscribe()
{
	isRevMessage = false;
	RdKafka::wait_destroyed(5000);
}

void KafkaClient::addListener(ConsumerMessageListener* listener)
{
	lock.lock();
	m_listeners.push_back(listener);
	lock.unlock();
}

void KafkaClient::removeListener(ConsumerMessageListener* listener)
{
	lock.lock();
	auto iter = std::find(m_listeners.begin(), m_listeners.end(), listener);
	if (iter != m_listeners.end())
	{
		m_listeners.erase(iter);
	}
	lock.unlock();
}
