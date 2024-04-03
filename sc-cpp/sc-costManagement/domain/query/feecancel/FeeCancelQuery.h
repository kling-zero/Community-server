#ifndef _FEE_CANCEL_QUERY_
#define _FEE_CANCEL_QUERY_

#include "../PageQuery.h"
#include "../../GlobalInclude.h"

/**
 费用取消查询Query
*/
class FeeCancelQuery : public PageQuery
{
	// 批次号
	CC_SYNTHESIZE(uint64_t, batchId, BatchId); 
	// 创建员工名
	CC_SYNTHESIZE(string, createUserName, CreateUserName); 
	// 审核状态ID
	CC_SYNTHESIZE(uint64_t, stateId, StateId);
public:
	friend void from_json(const json& j, FeeCancelQuery& t);
};
#endif