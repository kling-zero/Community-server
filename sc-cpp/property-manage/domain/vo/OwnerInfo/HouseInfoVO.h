#pragma once
#ifndef _HOUSE_INFO_VO_
#define _HOUSE_INFO_VO_

#include "../../GlobalInclude.h"

//房屋信息（入住房屋、业主详细信息）
class HouseInfoVO
{
	CC_SYNTHESIZE(std::string, houseId, HouseId);
	CC_SYNTHESIZE(std::string, houseName, HouseName);
	CC_SYNTHESIZE(std::string, houseSerial, HouseSerial);
	CC_SYNTHESIZE(std::string, houseUnit, HouseUnit);
	CC_SYNTHESIZE(std::string, floor, Floor);
	CC_SYNTHESIZE(int, roomNum, RoomNum);
	CC_SYNTHESIZE(std::string, houseType, HouseType);
	CC_SYNTHESIZE(int, houseArea, HouseArea);
	CC_SYNTHESIZE(int, unitPrice, UnitPrice);
	CC_SYNTHESIZE(std::string, createStaff, CreateStaff);
	CC_SYNTHESIZE(std::string, refinedDecoration, RefinedDecoration);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(HouseInfoVO,
		houseId,
		houseName,
		houseSerial,
		houseUnit,
		floor,
		roomNum,
		houseType,
		houseArea,
		unitPrice,
		createStaff,
		refinedDecoration);
};

#endif