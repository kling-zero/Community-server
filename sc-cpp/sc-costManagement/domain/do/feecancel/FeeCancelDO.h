/***************************************************************************** 
    *  @file     : FeeCancelDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:11
    *  @brief    : ȡ������DO
*****************************************************************************/  
#ifndef __FEECANCELDO_H__
#define __FEECANCELDO_H__

#include "../DoInclude.h"

class FeeCancelDO {
	// ���κ�
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// Ա������
	CC_SYNTHESIZE(string, createUserName, CreateUserName);
	// Ա��ID
	CC_SYNTHESIZE(uint64_t, createUserId, CreateUserId);
	// ����ʱ��
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// ȡ��ԭ��
	CC_SYNTHESIZE(string, reason, Reason);
	// ���״̬
	CC_SYNTHESIZE(string, stateName, StateName);
	// ������
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
