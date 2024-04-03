#ifndef _FEE_CANCEL_VO_
#define _FEE_CANCEL_VO_

#include "../../GlobalInclude.h"

/**
* ȡ������VO
*/
class FeeCancelVO {
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
	// ��JSONת������
	BIND_TO_JSON(FeeCancelVO, batchId, createUserName, createUserId, createTime, reason, stateName, msg);
};

#endif
