#ifndef _FEE_CANCEL_VO_
#define _FEE_CANCEL_VO_

#include "../../GlobalInclude.h"

/**
* 取消费用VO
*/
class FeeCancelVO {
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
	// 绑定JSON转换方法
	BIND_TO_JSON(FeeCancelVO, batchId, createUserName, createUserId, createTime, reason, stateName, msg);
};

#endif
