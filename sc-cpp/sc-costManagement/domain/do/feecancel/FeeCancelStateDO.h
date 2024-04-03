/***************************************************************************** 
    *  @file     : FeeCancelStateDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 16:31
    *  @brief    : ����ȡ����DO
*****************************************************************************/  
#ifndef __FEECANCELSTATEDO_H__
#define __FEECANCELSTATEDO_H__

#include "../DoInclude.h"

class FeeCancelStateDO {
	// ���״̬ID
	CC_SYNTHESIZE(uint64_t, stateId, StateId);
	// ���״̬����
	CC_SYNTHESIZE(string, stateName, StateName);

public:
	FeeCancelStateDO() {
		stateId = -1;
		stateName = "";
	}
};
#endif //__FEECANCELSTATEDO_H__
