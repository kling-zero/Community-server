#pragma once
#ifndef _CREATEFEEDTO_H_
#define _CREATEFEEDTO_H_
#include "../../GlobalInclude.h"
/**
 * ��������
 */

class CreateFeeDTO
{
	// ����
	CC_SYNTHESIZE(string, carNum, CarNum);
	// ��������
	CC_SYNTHESIZE(string, feeTypeCdName, feeTypeCdName);
	// �շ���Ŀ
	CC_SYNTHESIZE(string, feeName, feeName);
	// �Ʒѿ�ʼʱ��
	CC_SYNTHESIZE(string, endTime, endTime);
	// �Ʒѽ���ʱ��
	CC_SYNTHESIZE(string, deadlineTime, deadlineTime);
public:
	//��JSONת������
	friend void from_json(const json& j, CreateFeeDTO& t);
	BIND_TO_JSON(CreateFeeDTO, carNum, feeTypeCdName, feeName, endTime, deadlineTime);
	CreateFeeDTO() {
		carNum = u8"1331";
		feeTypeCdName = u8"Ѻ��";
		feeName = u8"װ��Ѻ��";
		endTime = u8"2022-10-18 00:00:00";
		deadlineTime = u8"2022-10-18 22:03:39";
	}
};

#endif // !_CREATEFEEDTO_H_
