#pragma once
#ifndef _CHARGINGITEMVO_H_
#define _CHARGINGITEMVO_H_
#include "../../GlobalInclude.h"

/**
 * 收费项目
 */
class ChargingItemVO
{
public:
	friend void from_json(const json& j, ChargingItemVO& t);
	BIND_TO_JSON(ChargingItemVO, id, description);

	ChargingItemVO(string description = u8"物业费", long id = 0) {
		
	}
private:
	// ID 
	CC_SYNTHESIZE(long, id, ID);
	// 描述
	CC_SYNTHESIZE(string, description, Description);
};

#endif // !_CHARGINGITEMVO_H_
