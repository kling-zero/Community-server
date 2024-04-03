/***************************************************************************** 
    *  @file     : FeeSumDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 13:26
    *  @brief    : 费用汇总DO
*****************************************************************************/  
#ifndef __FEESUMDO_H__
#define __FEESUMDO_H__

#include "../DoInclude.h"

class FeeSumDO {
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
	FeeSumDO() {
		createTime = "";
		configId = -1;
		feeName = "";
		receivableAmounts = -1;
		receivedAmounts = -1;
	}
};
#endif //__FEESUMDO_H__
