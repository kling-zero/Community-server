#ifndef _OWNERCARDO_H_
#define _OWNERCARDO_H_
#include "../DoInclude.h"

class OwnerCarDO
{
private:
	// 车牌号
	CC_SYNTHESIZE(string, car_num, Car_num);
	// 车位
	CC_SYNTHESIZE(string, ps_id, Ps_id);
	// 车位状态
	CC_SYNTHESIZE(string, state, State);
	// 业务id
	CC_SYNTHESIZE(string, b_id, B_id);
	//小区id 
	CC_SYNTHESIZE(string, community_id, Community_id);

	// 业主ID
	CC_SYNTHESIZE(string, owner_id, Owner_ID);
};

#endif // !_OWNERCARDO_H_
#pragma once
