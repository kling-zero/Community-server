#pragma once
#ifndef _EDITOWNERCARDTO_H_
#define _EDITOWNERCARDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/22 21:57:19
* 业主车辆-修改 / 业主车辆-子母车辆-修改
*/
class EditOwnerCarDTO
{
	//
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	//
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//
	CC_SYNTHESIZE(std::string, carNumType, CarNumType);
	//
	CC_SYNTHESIZE(std::string, carType, CarType);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//
	CC_SYNTHESIZE(std::string, remark, Remark);
	//
	CC_SYNTHESIZE(std::string, startTime, StartTime);
public:
	friend void from_json(const json& j, EditOwnerCarDTO& t);
	BIND_TO_JSON(EditOwnerCarDTO, carBrand, carColor, carId, carNum, carNumType, carType, communityId, endTime, memberId, remark, startTime);
};

#endif //_EDITOWNERCARDTO_H_