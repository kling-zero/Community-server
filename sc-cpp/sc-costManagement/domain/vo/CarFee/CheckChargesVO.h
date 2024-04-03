#pragma once
#ifndef _CHECKCHARGES_H_
#define _CHECKCHARGES_H_
#include "CarFeeListVO.h"
#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

/**
 * �鿴�շ�
 */

class CheckChargesVO:public CarFeeListVO
{
public:
	// ��JSONת������
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
		feeFlagName = u8"һ���Է���";
		feeTypeCdName = u8"Ѻ��";
		feeName = u8"װ��Ѻ��";
		state = u8"�շ���״̬";
		startTime = u8"2022-09-23 00:00:00";
		endTime = u8"2022-10-14 00:00:00";
		deadlineTime = u8"";
		batchId = u8"2022-10-18 16:06:31";
		maxEndTime = u8"2022-10-07 00:00:00";
		ownerName = u8"����";
		link = u8"19934517986";
		ownerId = u8"772022101726638968";
		payerObjName = u8"00111(1331)";
	}
private:
	// ����ID
	CC_SYNTHESIZE(string, feeId, feeId);
	// ���ñ�ʶ
	CC_SYNTHESIZE(string, feeFlagName, feeFlagName);
	// ��������
	CC_SYNTHESIZE(string, feeTypeCdName, feeTypeCdName);
	// ������
	CC_SYNTHESIZE(string, feeName, feeName);
	// ����ʱ��
	CC_SYNTHESIZE(string, startTime, startTime);
	// �Ʒѿ�ʼʱ��
	CC_SYNTHESIZE(string, endTime, endTime);
	// �Ʒѽ���ʱ��
	CC_SYNTHESIZE(string, deadlineTime, deadlineTime);
	// ˵��
	CC_SYNTHESIZE(string, explaination, Explaination);
	// ״̬
	CC_SYNTHESIZE(string, state, State);
	// ����
	CC_SYNTHESIZE(string, batchId, batchId);
	// �Ʒѽ�ֹʱ��
	CC_SYNTHESIZE(string, maxEndTime, maxEndTime);
	// ���Ѷ���
	CC_SYNTHESIZE(string, payerObjName, payerObjName);
};

#endif // !_CHECKCHARGES_H_