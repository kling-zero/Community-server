#pragma once
#ifndef _STAFFFEELISTVO_H_
#define _STAFFFEELISTVO_H_
#include "../../GlobalInclude.h"

/*
* 员工费用
* @Author:chifan
* @Date: 2022/10/17 21:18
*/

class StaffFeeListVO
{
public:
	BIND_TO_JSON(StaffFeeListVO, receivableAmount, receivedAmount, userId, userName);
private:
	CC_SYNTHESIZE(double, receivableAmount, ReceivableAmount);
	CC_SYNTHESIZE(double, receivedAmount, ReceivedAmount);
	CC_SYNTHESIZE(string, userId, UserId);
	CC_SYNTHESIZE(string, userName, UserName);
	//StaffFeeListVO() {
	//	receivableAmount = 2705613.89;
	//	receivedAmount = 2781162.27;
	//	userId = u8"302022090667451419";
	//	userName = u8"wuxw";
	//}
};

#endif // !_STAFFFEELISTVO_H