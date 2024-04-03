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
	// 缴费ID
	CC_SYNTHESIZE(long, id, ID);
	// 周期
	CC_SYNTHESIZE(string, cycle, Cycle);
	// 应收金额
	CC_SYNTHESIZE(double, amountReceivable, AmountReceivable);
	// 实收金额
	CC_SYNTHESIZE(double, paidInAmount, PaidInAmount);
	// 缴费时间
	CC_SYNTHESIZE(string, timing, Timing);
	// 缴费起始时间
	CC_SYNTHESIZE(string, startTime, startTime);
	// 缴费结束时间
	CC_SYNTHESIZE(string, endTime, EndTime);
	// 状态
	CC_SYNTHESIZE(string, state, State);
	// 备注
	CC_SYNTHESIZE(string, remarks, Remarks);
};

#endif // !_PAYMENTHISTORYVO_H_

