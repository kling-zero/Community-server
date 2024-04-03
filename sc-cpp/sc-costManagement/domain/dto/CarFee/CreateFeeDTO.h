#pragma once
#ifndef _CREATEFEEDTO_H_
#define _CREATEFEEDTO_H_
#include "../../GlobalInclude.h"
/**
 * 创建费用
 */

class CreateFeeDTO
{
	// 车辆
	CC_SYNTHESIZE(string, carNum, CarNum);
	// 费用类型
	CC_SYNTHESIZE(string, feeTypeCdName, feeTypeCdName);
	// 收费项目
	CC_SYNTHESIZE(string, feeName, feeName);
	// 计费开始时间
	CC_SYNTHESIZE(string, endTime, endTime);
	// 计费结束时间
	CC_SYNTHESIZE(string, deadlineTime, deadlineTime);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, CreateFeeDTO& t);
	BIND_TO_JSON(CreateFeeDTO, carNum, feeTypeCdName, feeName, endTime, deadlineTime);
	CreateFeeDTO() {
		carNum = u8"1331";
		feeTypeCdName = u8"押金";
		feeName = u8"装修押金";
		endTime = u8"2022-10-18 00:00:00";
		deadlineTime = u8"2022-10-18 22:03:39";
	}
};

#endif // !_CREATEFEEDTO_H_
