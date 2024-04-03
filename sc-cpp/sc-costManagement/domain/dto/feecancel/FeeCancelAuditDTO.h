#ifndef __FEECANCELAUDITDTO_H__
#define __FEECANCELAUDITDTO_H__

#include "../../GlobalInclude.h"

class FeeCancelAuditDTO {
	// ���κ�
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// ���״̬
	CC_SYNTHESIZE(string, stateName, StateName);
	// ������
	CC_SYNTHESIZE(string, msg, Msg);
public:
	//��JSONת������
	friend void from_json(const json& j, FeeCancelAuditDTO& t);
	BIND_TO_JSON(FeeCancelAuditDTO, batchId, stateName, msg);
};
#endif //__FEECANCELAUDITDTO_H__
