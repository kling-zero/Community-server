#pragma once
#ifndef _PAYMENTHISTORYQUERY_H_
#define _PAYMENTHISTORYQUERY_H_
#include "../PageQuery.h"

/**
 * �ɷ���ʷ��ѯ
 */
class PaymentHistoryQuery : public PageQuery
{
public:
	friend void from_json(const json& j, PaymentHistoryQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, startTime);
		BIND_FROM_TO_NORMAL(j, t, endTime);
	}
private:
	// ��ʼʱ��
	CC_SYNTHESIZE(string, startTime, startTime);
	// ����ʱ��
	CC_SYNTHESIZE(string, endTime, EndTime);
};

#endif // !_PAYMENTHISTORYQUERY_H_
