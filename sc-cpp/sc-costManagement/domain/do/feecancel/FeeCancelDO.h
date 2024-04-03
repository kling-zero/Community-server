/***************************************************************************** 
    *  @file     : FeeCancelDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:11
    *  @brief    : 取消费用DO
*****************************************************************************/  
#ifndef __FEECANCELDO_H__
#define __FEECANCELDO_H__

#include "../DoInclude.h"

class FeeCancelDO {
	// 批次号
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// 员工姓名
	CC_SYNTHESIZE(string, createUserName, CreateUserName);
	// 员工ID
	CC_SYNTHESIZE(uint64_t, createUserId, CreateUserId);
	// 创建时间
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// 取消原因
	CC_SYNTHESIZE(string, reason, Reason);
	// 审核状态
	CC_SYNTHESIZE(string, stateName, StateName);
	// 审核意见
	CC_SYNTHESIZE(string, msg, Msg);

public:
	FeeCancelDO() {
		batchId = -1;
		createUserName = "";
		createUserId = -1;
		createTime = "";
		reason = "";
		stateName = "";
		msg = "";
	}

};

#endif //__FEECANCELDO_H__
