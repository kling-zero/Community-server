#ifndef _FEE_SUM_VO_
#define _FEE_SUM_VO_

#include "../../GlobalInclude.h"

/**
* 费用汇总VO
*/
class FeeSumVO {
	// 创建时间
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// 费用项ID
	CC_SYNTHESIZE(uint64_t, configId, ConfigId);
	// 费用项名称
	CC_SYNTHESIZE(string, feeName, FeeName);
	// 应收金额
	CC_SYNTHESIZE(double, receivableAmounts, ReceivableAmounts);
	// 实收金额
	CC_SYNTHESIZE(double, receivedAmounts, ReceivedAmounts);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(FeeSumVO, createTime, configId, feeName, receivableAmounts, receivedAmounts);
};

#endif