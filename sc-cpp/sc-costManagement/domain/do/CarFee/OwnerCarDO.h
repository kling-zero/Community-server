#ifndef _OWNERCARDO_H_
#define _OWNERCARDO_H_
#include "../DoInclude.h"

class OwnerCarDO
{
private:
	// ���ƺ�
	CC_SYNTHESIZE(string, car_num, Car_num);
	// ��λ
	CC_SYNTHESIZE(string, ps_id, Ps_id);
	// ��λ״̬
	CC_SYNTHESIZE(string, state, State);
	// ҵ��id
	CC_SYNTHESIZE(string, b_id, B_id);
	//С��id 
	CC_SYNTHESIZE(string, community_id, Community_id);

	// ҵ��ID
	CC_SYNTHESIZE(string, owner_id, Owner_ID);
};

#endif // !_OWNERCARDO_H_
#pragma once
