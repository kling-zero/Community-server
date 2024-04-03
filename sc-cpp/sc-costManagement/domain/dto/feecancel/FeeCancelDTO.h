#ifndef __FEECANCELDTO_H__
#define __FEECANCELDTO_H__

#include "../../GlobalInclude.h"

class FeeCancelDTO {
	// ���κ�
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// Ա������
	CC_SYNTHESIZE(string, createUserName, CreateUserName);
	// ����ʱ��
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// ȡ��ԭ��
	CC_SYNTHESIZE(string, reason, Reason);
public:
	//��JSONת������
	friend void from_json(const json& j, FeeCancelDTO& t);
	BIND_TO_JSON(FeeCancelDTO, batchId, createUserName, createTime, reason);

};
#endif //__FEECANCELDTO_H__
