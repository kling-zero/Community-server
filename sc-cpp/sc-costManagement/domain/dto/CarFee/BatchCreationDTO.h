#pragma once
#ifndef _BATCHCREATIONDTO_H_
#define _BATCHCREATIONDTO_H_
#include "../../GlobalInclude.h"

/**
 * 批量创建
 */

class BatchCreationDTO
{
private:
	// 收费范围
	CC_SYNTHESIZE(string, id, ID);
	// 费用类型
	CC_SYNTHESIZE(string, feeType, FeeType);
	// 收费项目
	CC_SYNTHESIZE(string, chargingItem, ChargingItem);
	// 停车场
	CC_SYNTHESIZE(string, parking, Parking);
	// 车位状态
	CC_SYNTHESIZE(string, state, State);
	// 计费起始时间
	CC_SYNTHESIZE(string, startTime, StartTime);
	// 计费结束时间
	CC_SYNTHESIZE(string, endTime, EndTime);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, BatchCreationDTO& t);
	BatchCreationDTO() {
		id = u8"1";
		parking = u8"11";
		feeType = u8"押金";
		chargingItem = u8"装修押金";
		state = u8"已出售";
		startTime = u8"2022-10-12";
		endTime = u8"2022-10-27";
	}
};

#endif // !_BATCHCREATIONDTO_H_
