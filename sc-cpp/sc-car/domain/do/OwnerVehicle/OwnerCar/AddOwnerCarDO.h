#pragma once
#ifndef _ADDOWNERCARDO_H_
#define _ADDOWNERCARDO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/11/01 9:03:41
*/
class AddOwnerCarDO
{
	//CC_SYNTHESIZE(std::list<AttrsDTO>, attrs, Attrs);
	CC_SYNTHESIZE(std::string, carAttrs, CarAttrs);
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	CC_SYNTHESIZE(std::string, carNumType, CarNumType);
	CC_SYNTHESIZE(std::string, carType, CarType);
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	CC_SYNTHESIZE(std::string, flowComponent, FlowComponent);
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	CC_SYNTHESIZE(std::string, psId, PsId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	CC_SYNTHESIZE(std::string, value, Value);
public:
	AddOwnerCarDO() {
		//std::string Attrs = "";
		std::string carAttrs = "";
		std::string carBrand = "";
		std::string carColor = "";
		std::string carNum = "";
		std::string carNumType = "";
		std::string carType = "";
		std::string communityId = "";
		std::string endTime = "";
		std::string flowComponent = "";
		std::string ownerId = "";
		std::string psId = "";
		std::string remark = "";
		std::string startTime = "";
		std::string value = "";
	}
};

#endif //_ADDOWNERCARDO_H_