#ifndef __FEECANCELDTO_H__
#define __FEECANCELDTO_H__

#include "../../GlobalInclude.h"

class FeeCancelDTO {
	// 批次号
	CC_SYNTHESIZE(uint64_t, batchId, BatchId);
	// 员工姓名
	CC_SYNTHESIZE(string, createUserName, CreateUserName);
	// 创建时间
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// 取消原因
	CC_SYNTHESIZE(string, reason, Reason);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, FeeCancelDTO& t);
	BIND_TO_JSON(FeeCancelDTO, batchId, createUserName, createTime, reason);

};
#endif //__FEECANCELDTO_H__
