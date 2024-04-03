#pragma once
#ifndef _CHECKCHARGES_H_
#define _CHECKCHARGES_H_
#include "CarFeeListVO.h"
#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

/**
 * 查看收费
 */

class CheckChargesVO:public CarFeeListVO
{
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(CheckChargesVO,
		feeId,
		feeFlagName,
		feeTypeCdName,
		feeName,
		startTime,
		endTime,
		deadlineTime,
		batchId,
		maxEndTime,
		payerObjName,
		ownerName,
		link,
		ownerId, explaination, state);
	CheckChargesVO() {
		feeId = u8"902022101866698765";
		feeFlagName = u8"一次性费用";
		feeTypeCdName = u8"押金";
		feeName = u8"装修押金";
		state = u8"收费中状态";
		startTime = u8"2022-09-23 00:00:00";
		endTime = u8"2022-10-14 00:00:00";
		deadlineTime = u8"";
		batchId = u8"2022-10-18 16:06:31";
		maxEndTime = u8"2022-10-07 00:00:00";
		ownerName = u8"厕所";
		link = u8"19934517986";
		ownerId = u8"772022101726638968";
		payerObjName = u8"00111(1331)";
	}
private:
	// 费用ID
	CC_SYNTHESIZE(string, feeId, feeId);
	// 费用标识
	CC_SYNTHESIZE(string, feeFlagName, feeFlagName);
	// 费用类型
	CC_SYNTHESIZE(string, feeTypeCdName, feeTypeCdName);
	// 费用项
	CC_SYNTHESIZE(string, feeName, feeName);
	// 建账时间
	CC_SYNTHESIZE(string, startTime, startTime);
	// 计费开始时间
	CC_SYNTHESIZE(string, endTime, endTime);
	// 计费结束时间
	CC_SYNTHESIZE(string, deadlineTime, deadlineTime);
	// 说明
	CC_SYNTHESIZE(string, explaination, Explaination);
	// 状态
	CC_SYNTHESIZE(string, state, State);
	// 批次
	CC_SYNTHESIZE(string, batchId, batchId);
	// 计费截止时间
	CC_SYNTHESIZE(string, maxEndTime, maxEndTime);
	// 付费对象
	CC_SYNTHESIZE(string, payerObjName, payerObjName);
};

#endif // !_CHECKCHARGES_H_