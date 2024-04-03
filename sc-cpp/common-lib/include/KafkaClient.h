#ifndef _KAFKACLIENT_H_
#define _KAFKACLIENT_H_
#include <string>
#include <iostream>
#include <mutex>
#include "librdkafka/rdkafkacpp.h"

#if LINUX
#include <unistd.h>
#include <functional>
#endif

/**
 * ����һ��Kafka�ͻ��ˣ�����װ���ò�����
 * �ο����ӣ�
 * https://github.com/edenhill/librdkafka/tree/v1.8.2/examples
 * https://docs.confluent.io/kafka-clients/librdkafka/current/overview.html
 */
class KafkaClient
{
public:
	/**
	 * ��Ϣ�����ص�
	 */
	class DeliveryReportCb : public RdKafka::DeliveryReportCb {
	private:
		std::function<void(RdKafka::Message&)> cf;
	public:
		DeliveryReportCb(std::function<void(RdKafka::Message&)> cf);
		void dr_cb(RdKafka::Message& message) override;
	};

	/**
	 * ���Ѻ�̨�¼�����
	 */
	class ConsumerEventCb : public RdKafka::EventCb {
	public:
		void event_cb(RdKafka::Event& event) override;
	};

	/**
	 * ������Ϣ������
	 */
	class ConsumerMessageListener {
	public:
		// ������������
		std::string topic;
		// ������Ϣ
		virtual void receiveMessage(std::string payload) = 0;
	};
private:
	// �������ڵ�
	std::string m_brokers;
	// ����ID
	std::string m_groupId;
	// ��ǰ������Ϣ������
	std::string m_topic;
	// �����߶���
	RdKafka::Producer* m_producer;
	// �����߶���
	RdKafka::KafkaConsumer* m_consumer;
	// ������Ϣ�¼�֪ͨ����
	std::vector<ConsumerMessageListener*> m_listeners;
	// ����һ���¼��ص�����
	ConsumerEventCb m_ex_event_cb;
	// �Ƿ������Ϣ
	bool isRevMessage;
	// ����һ���߳���
	std::mutex lock;
	// ����������Ϣ״̬
	void msg_consume(RdKafka::Message* message);
public:
	//************************************
	// Method:    KafkaClient
	// FullName:  KafkaClient::KafkaClient
	// Access:    public 
	// Returns:   
	// Qualifier: �����ʼ��
	// Parameter: const std::string & brokers �������ڵ㣬��ʽ�磺host1:port,host2:prot2
	// Parameter: const std::string & groupId ���������ƣ�Ĭ��ֵcpp-kafka
	//************************************
	KafkaClient(const std::string& brokers, const std::string& groupId = "cpp-kafka");
	// �����ͷ���Դ
	~KafkaClient();
	//************************************
	// Method:    productMsg
	// FullName:  KafkaClient::productMsg
	// Access:    public 
	// Returns:   bool �����ɹ�����true
	// Qualifier: ������Ϣ
	// Parameter: const std::string & topic ����
	// Parameter: const std::string & message ��Ϣ����
	// Parameter: DeliveryReportCb * cb ��Ϣ�����ص�����,Ĭ��ֵΪnullptr
	//************************************
	bool productMsg(const std::string& topic, const std::string& message, DeliveryReportCb* cb = nullptr);
	//************************************
	// Method:    subscribe
	// FullName:  KafkaClient::subscribe
	// Access:    public 
	// Returns:   bool ���ĳɹ�����true
	// Qualifier: �������⣬ע�⣺ͬһ��KafkaClient����ֻ�ܶ���һ�Σ��������Ľ���Ч
	// Parameter: const std::vector<std::string> & topics �����б�
	//************************************
	bool subscribe(const std::vector<std::string>& topics);
	//************************************
	// Method:    unsubscribe
	// FullName:  KafkaClient::unsubscribe
	// Access:    public 
	// Returns:   void
	// Qualifier: ȡ������
	//************************************
	void unsubscribe();
	//************************************
	// Method:    addListener
	// FullName:  KafkaClient::addListener
	// Access:    public 
	// Returns:   void
	// Qualifier: ��Ӷ�����Ϣ���������
	// Parameter: ConsumerMessageListener * listener �����߶���
	//************************************
	void addListener(ConsumerMessageListener* listener);
	//************************************
	// Method:    removeListener
	// FullName:  KafkaClient::removeListener
	// Access:    public 
	// Returns:   void
	// Qualifier: �Ƴ�������Ϣ���������
	// Parameter: ConsumerMessageListener * listener �����߶���
	//************************************
	void removeListener(ConsumerMessageListener* listener);
};

// ����������Ϣ������Ὣ����ת����Json�ַ���
#define KC_PUBLISH_OBJ_MSG(__VAR_RES__, __KAFKA_CLIENT__, __TOPIC__, __DATA_OBJ__, __CB_OBJ__) \
nlohmann::json jobj(__DATA_OBJ__); \
bool __VAR_RES__ = __KAFKA_CLIENT__->productMsg(__TOPIC__, jobj.dump(), __CB_OBJ__);

// ������Ϣ����Json�ַ���ת���ɶ���
#define KC_RECEIVER_MSG_CONVERT(__VAR_OBJ__, __TYPE__, __PAYLOAD__) \
nlohmann::json jobj = nlohmann::json::parse(__PAYLOAD__); \
__TYPE__ __VAR_OBJ__ = jobj.get<__TYPE__>();

#endif // _KAFKACLIENT_H_
