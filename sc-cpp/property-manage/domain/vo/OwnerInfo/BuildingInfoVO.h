#pragma once
#ifndef _BUILDING_INFO_VO_
#define _BUILDING_INFO_VO_

#include "../../GlobalInclude.h"

//楼房信息（入住）
class BuildingInfoVO
{
	CC_SYNTHESIZE(std::string, buildingId, BuildingId);
	CC_SYNTHESIZE(std::string, buildingName, BuildingName);
	CC_SYNTHESIZE(int, buildingNum, BuildingNum);
	CC_SYNTHESIZE(int, buildingArea, BuildingArea);
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(BuildingInfoVO,
		buildingId,
		buildingName,
		buildingNum,
		buildingArea,
		remark);
};

#endif
