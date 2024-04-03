#ifndef __FEECANCELAUDITDTO_H__
#define __FEECANCELAUDITDTO_H__

#include "../../GlobalInclude.h"

class FeeCancelAuditDTO {
	// 批次号
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// 审核状态
	CC_SYNTHESIZE(string, stateName, StateName);
	// 审核意见
	CC_SYNTHESIZE(string, msg, Msg);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, FeeCancelAuditDTO& t);
	BIND_TO_JSON(FeeCancelAuditDTO, batchId, stateName, msg);
};
#endif //__FEECANCELAUDITDTO_H__
