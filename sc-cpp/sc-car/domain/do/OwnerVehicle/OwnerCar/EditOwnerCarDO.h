#pragma once
#ifndef _EDITOWNERCARDO_H_
#define _EDITOWNERCARDO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/11/02 14:42:14
*/
class EditOwnerCarDO
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
	EditOwnerCarDO() {
		std::string carBrand = "";
		std::string carColor = "";
		std::string carId = "";
		std::string carNum = "";
		std::string carNumType = "";
		std::string carType = "";
		std::string communityId = "";
		std::string endTime = "";
		std::string memberId = "";
		std::string remark = "";
		std::string startTime = "";
	}
};

#endif //_EDITOWNERCARDO_H_