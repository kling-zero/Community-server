#pragma once
#ifndef _PAYMENTHISTORYVO_H_
#define _PAYMENTHISTORYVO_H_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

class PaymentHistoryVO : public PageQuery
{
public:
	BIND_TO_JSON(PaymentHistoryVO, id, cycle, amountReceivable, paidInAmount, timing, startTime, endTime, state, remarks);
	PaymentHistoryVO() {
		id = 132412343;
		cycle = u8"";
		amountReceivable = 3421.34;
		paidInAmount = 3421.34;
		timing = u8"2022-10-17 00:00:00";
		startTime = u8"2022-10-10 00:00:00";
		endTime = u8"2022-10-18 19:42:30";
		remarks = u8"";
		pageIndex = 1;
		pageSize = 10;
	}
private:
	// �ɷ�ID
	CC_SYNTHESIZE(long, id, ID);
	// ����
	CC_SYNTHESIZE(string, cycle, Cycle);
	// Ӧ�ս��
	CC_SYNTHESIZE(double, amountReceivable, AmountReceivable);
	// ʵ�ս��
	CC_SYNTHESIZE(double, paidInAmount, PaidInAmount);
	// �ɷ�ʱ��
	CC_SYNTHESIZE(string, timing, Timing);
	// �ɷ���ʼʱ��
	CC_SYNTHESIZE(string, startTime, startTime);
	// �ɷѽ���ʱ��
	CC_SYNTHESIZE(string, endTime, EndTime);
	// ״̬
	CC_SYNTHESIZE(string, state, State);
	// ��ע
	CC_SYNTHESIZE(string, remarks, Remarks);
};

#endif // !_PAYMENTHISTORYVO_H_

