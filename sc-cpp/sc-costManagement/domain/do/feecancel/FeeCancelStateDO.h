/***************************************************************************** 
    *  @file     : FeeCancelStateDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 16:31
    *  @brief    : 费用取消项DO
*****************************************************************************/  
#ifndef __FEECANCELSTATEDO_H__
#define __FEECANCELSTATEDO_H__

#include "../DoInclude.h"

class FeeCancelStateDO {
	// 审核状态ID
	CC_SYNTHESIZE(uint64_t, stateId, StateId);
	// 审核状态名称
	CC_SYNTHESIZE(string, stateName, StateName);

public:
	FeeCancelStateDO() {
		stateId = -1;
		stateName = "";
	}
};
#endif //__FEECANCELSTATEDO_H__
