#pragma once
#ifndef _CARINFOADDDTO_H_
#define _CARINFOADDDTO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 10:51:29
* 业主车辆-添加车辆信息
*/
class CarInfoAddDTO
{
	//CC_SYNTHESIZE(, attrs, attrs);
	CC_SYNTHESIZE(std::string, carAttrs, carAttrs);
	CC_SYNTHESIZE(std::string, carBrand, carBrand);
	CC_SYNTHESIZE(std::string, carColor, carColor);
	CC_SYNTHESIZE(std::string, carNum, carNum);
	CC_SYNTHESIZE(std::string, carNumType, carNumType);
	CC_SYNTHESIZE(std::string, carType, carType);
	CC_SYNTHESIZE(std::string, communityId, communityId);
	CC_SYNTHESIZE(std::string, endTime, endTime);
	CC_SYNTHESIZE(std::string, flowComponent, flowComponent);
	CC_SYNTHESIZE(std::string, index, index);
	CC_SYNTHESIZE(std::string, ownerId, ownerId);
	CC_SYNTHESIZE(std::string, psId, psId);
	CC_SYNTHESIZE(std::string, remark, remark);
	CC_SYNTHESIZE(std::string, startTime, startTime);
	CC_SYNTHESIZE(std::string, value, value);

public:
	//绑定JSON转换方法
	friend void from_json(const json& j, CarInfoAddDTO& t) {
		//BIND_FROM_TO_NORMAL(j, t, attrs);
		BIND_FROM_TO_NORMAL(j, t, carAttrs);
		BIND_FROM_TO_NORMAL(j, t, carBrand);
		BIND_FROM_TO_NORMAL(j, t, carNum);
		BIND_FROM_TO_NORMAL(j, t, carNumType);
		BIND_FROM_TO_NORMAL(j, t, carType);
		BIND_FROM_TO_NORMAL(j, t, communityId);
		BIND_FROM_TO_NORMAL(j, t, endTime);
		BIND_FROM_TO_NORMAL(j, t, flowComponent);
		BIND_FROM_TO_NORMAL(j, t, index);
		BIND_FROM_TO_NORMAL(j, t, ownerId);
		BIND_FROM_TO_NORMAL(j, t, psId);
		BIND_FROM_TO_NORMAL(j, t, remark);
		BIND_FROM_TO_NORMAL(j, t, startTime);
		BIND_FROM_TO_NORMAL(j, t, value);
	}
};

#endif //_CARINFOADDDTO_H_