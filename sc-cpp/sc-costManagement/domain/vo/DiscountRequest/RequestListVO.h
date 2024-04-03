#ifndef _REQUESTLIST_H_
#define _REQUESTLIST_H_

#include "../../GlobalInclude.h"

class RequestListVO
{
	// 房屋
	CC_SYNTHESIZE(std::string, house, House);
	// 折扣ID
	CC_SYNTHESIZE(std::string, discountId, DiscountId);
	// 折扣名称
	CC_SYNTHESIZE(std::string, discountName, DiscountName);
	// 申请类型
	CC_SYNTHESIZE(std::string, requestType, RequestType);
	// 申请人
	CC_SYNTHESIZE(std::string, applicant, Applicant);
	// 申请电话
	CC_SYNTHESIZE(std::string, requestPhone, RequestPhone);
	// 开始时间
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	// 结束时间
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	// 状态
	CC_SYNTHESIZE(std::string, state, State);
	// 创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	// 使用状态
	CC_SYNTHESIZE(std::string, useState, UseState);
	// 返还类型
	CC_SYNTHESIZE(std::string, returnType, ReturnType);
	// 返还金额
	CC_SYNTHESIZE(double, returnAmount, ReturnAmount);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(RequestListVO, house, discountId, discountName, requestType, applicant,
		requestPhone, startTime, endTime, state, createTime, useState, returnType, returnAmount);
	RequestListVO() {
		house = u8"1-9-1232	";
		discountId = u8"001";
		discountName = u8"九折优惠";
		requestType = u8"租金优惠";
		applicant = u8"xxl";
		requestPhone = u8"18909711443";
		startTime = u8"2022-09-20 00:00:00";
		endTime = u8"2022-09-27 23:59:59";
		state = u8"验房通过";
		createTime = u8"2022-09-29 15:52:05";
		useState = u8"未使用";
		returnType = u8"微信";
		returnAmount = 273.89;

	}
};

#endif // !_REQUESTLIST_H_

