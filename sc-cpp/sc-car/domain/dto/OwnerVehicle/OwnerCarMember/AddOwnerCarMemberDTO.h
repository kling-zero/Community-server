#pragma once
#ifndef _ADDOWNERCARMEMBERDTO_H_
#define _ADDOWNERCARMEMBERDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/23 13:47:19
* 业主车辆-子母车辆-添加
*/
class AddOwnerCarMemberDTO
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
	CC_SYNTHESIZE(std::string, carType, CarType);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, flowComponent, FlowComponent);
	//
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	friend void from_json(const json& j, AddOwnerCarMemberDTO& t);
	BIND_TO_JSON(AddOwnerCarMemberDTO, carBrand, carColor, carId, carNum, carType, communityId, flowComponent, remark)
};

#endif //_ADDOWNERCARMEMBERDTO_H_