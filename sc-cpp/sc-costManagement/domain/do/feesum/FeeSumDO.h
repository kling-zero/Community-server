/***************************************************************************** 
    *  @file     : FeeSumDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 13:26
    *  @brief    : ���û���DO
*****************************************************************************/  
#ifndef __FEESUMDO_H__
#define __FEESUMDO_H__

#include "../DoInclude.h"

class FeeSumDO {
	// ����ʱ��
	CC_SYNTHESIZE(string, createTime, CreateTime);
	// ������ID
	CC_SYNTHESIZE(uint64_t, configId, ConfigId);
	// ����������
	CC_SYNTHESIZE(string, feeName, FeeName);
	// Ӧ�ս��
	CC_SYNTHESIZE(double, receivableAmounts, ReceivableAmounts);
	// ʵ�ս��
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
