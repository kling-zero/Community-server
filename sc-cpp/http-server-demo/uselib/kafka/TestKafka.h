#ifndef _TESTKAFKA_H_
#define _TESTKAFKA_H_
#include "KafkaClient.h"
#include <memory>

class TestKafka : public KafkaClient::ConsumerMessageListener {
private:
	std::shared_ptr<KafkaClient> client;
public:
	TestKafka();
	~TestKafka();
	void testKafka();
	void receiveMessage(std::string payload) override;
};
#endif // _TESTKAFKA_H_