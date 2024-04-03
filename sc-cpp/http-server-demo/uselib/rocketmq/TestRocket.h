#ifndef _TESTROCKET_H_
#define _TESTROCKET_H_
#include "RocketClient.h"
#include <memory>
class TestRocket : public RocketClient::RConsumerListener
{
private:
	std::shared_ptr<RocketClient> client;
	std::shared_ptr<RocketClient::RSendCallback> cb;
public:
	TestRocket();
	~TestRocket();
	void testRocket();
	void receiveMessage(std::string payload) override;
};
#endif // _TESTROCKET_H_
