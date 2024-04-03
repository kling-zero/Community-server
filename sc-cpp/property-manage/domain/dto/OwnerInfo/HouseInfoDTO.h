#pragma once
#ifndef _HOUSE_INFO_DTO_
#define _HOUSE_INFO_DTO_


#include "../../GlobalInclude.h"
/*
* ������ϢDTO
*/
class HouseInfoDTO
{
	CC_SYNTHESIZE(std::string, houseSerial, HouseSerial);
	CC_SYNTHESIZE(std::string, houseId, HouseId);
public:
	//��JSONת������
	friend void from_json(const json& j, HouseInfoDTO& t) {
		BIND_FROM_TO_NORMAL(j, t, houseSerial);
		BIND_FROM_TO_NORMAL(j, t, houseId);
	}
};
#endif // OwnerInfoDTO
