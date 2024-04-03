#include "stdafx.h"
#include "TestKafka.h"
#include "domain/dto/sample/SampleDTO.h"

TestKafka::TestKafka()
{
	this->client = nullptr;
}

TestKafka::~TestKafka()
{
	if (client)
	{
		client->unsubscribe();
	}
}

void TestKafka::testKafka()
{
	//设置key和主题
	this->topic = "hello";
	
	//创建客户端
	client = make_shared<KafkaClient>("192.168.220.128:9092");

	//测试订阅主题
	client->subscribe({ this->topic });
	client->addListener(this);

	//测试发布消息
	KafkaClient::DeliveryReportCb cb([](RdKafka::Message& msg)
		{
			cout << "call back:" << msg.topic_name() << ", payload = " << static_cast<const char*>(msg.payload()) << endl;
		});
	//定义消息对象
	SampleDTO dto;
	dto.setId(1);
	dto.setName("cat");
	dto.setSex("man");
	dto.setAge(10);
	KC_PUBLISH_OBJ_MSG(res, client, this->topic, dto, &cb);
	cout << "product res:" << res << endl;
}

void TestKafka::receiveMessage(std::string payload)
{
	cout << "payload: " << payload << endl;
	KC_RECEIVER_MSG_CONVERT(dto, SampleDTO, payload);
	cout << dto.getName() << "," << dto.getSex() << "," << dto.getAge() << endl;
}
