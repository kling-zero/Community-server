#ifndef _FEE_SUM_VO_
#define _FEE_SUM_VO_

#include "../../GlobalInclude.h"

/**
* ���û���VO
*/
class FeeSumVO {
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
	// ��JSONת������
	BIND_TO_JSON(FeeSumVO, createTime, configId, feeName, receivableAmounts, receivedAmounts);
};

#endif