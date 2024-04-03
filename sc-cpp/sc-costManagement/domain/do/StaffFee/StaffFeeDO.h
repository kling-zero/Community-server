#ifndef _STAFFFEEDO_H_
#define _STAFFFEEDO_H_
#include "../DoInclude.h"

class StaffFeeDO
{

private:
	CC_SYNTHESIZE(double, receivableAmount, ReceivableAmount);
	CC_SYNTHESIZE(double, receivedAmount, ReceivedAmount);
	CC_SYNTHESIZE(std::string, userId, UserId);
	CC_SYNTHESIZE(std::string, userName, UserName);
	//StaffFeeDO() {
	//	receivableAmount = 2705613.89;
	//	receivedAmount = 2781162.27;
	//	userId = u8"302022102475704277";
	//	userName = u8"wuxw";
	//}
};

#endif // !_STAFFFEEDO_H_
#pragma once
