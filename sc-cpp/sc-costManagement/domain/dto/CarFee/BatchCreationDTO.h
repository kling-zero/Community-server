#pragma once
#ifndef _BATCHCREATIONDTO_H_
#define _BATCHCREATIONDTO_H_
#include "../../GlobalInclude.h"

/**
 * ��������
 */

class BatchCreationDTO
{
private:
	// �շѷ�Χ
	CC_SYNTHESIZE(string, id, ID);
	// ��������
	CC_SYNTHESIZE(string, feeType, FeeType);
	// �շ���Ŀ
	CC_SYNTHESIZE(string, chargingItem, ChargingItem);
	// ͣ����
	CC_SYNTHESIZE(string, parking, Parking);
	// ��λ״̬
	CC_SYNTHESIZE(string, state, State);
	// �Ʒ���ʼʱ��
	CC_SYNTHESIZE(string, startTime, StartTime);
	// �Ʒѽ���ʱ��
	CC_SYNTHESIZE(string, endTime, EndTime);
public:
	//��JSONת������
	friend void from_json(const json& j, BatchCreationDTO& t);
	BatchCreationDTO() {
		id = u8"1";
		parking = u8"11";
		feeType = u8"Ѻ��";
		chargingItem = u8"װ��Ѻ��";
		state = u8"�ѳ���";
		startTime = u8"2022-10-12";
		endTime = u8"2022-10-27";
	}
};

#endif // !_BATCHCREATIONDTO_H_
