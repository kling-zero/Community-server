#ifndef _REQUESTLIST_H_
#define _REQUESTLIST_H_

#include "../../GlobalInclude.h"

class RequestListVO
{
	// ����
	CC_SYNTHESIZE(std::string, house, House);
	// �ۿ�ID
	CC_SYNTHESIZE(std::string, discountId, DiscountId);
	// �ۿ�����
	CC_SYNTHESIZE(std::string, discountName, DiscountName);
	// ��������
	CC_SYNTHESIZE(std::string, requestType, RequestType);
	// ������
	CC_SYNTHESIZE(std::string, applicant, Applicant);
	// ����绰
	CC_SYNTHESIZE(std::string, requestPhone, RequestPhone);
	// ��ʼʱ��
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	// ����ʱ��
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	// ״̬
	CC_SYNTHESIZE(std::string, state, State);
	// ����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	// ʹ��״̬
	CC_SYNTHESIZE(std::string, useState, UseState);
	// ��������
	CC_SYNTHESIZE(std::string, returnType, ReturnType);
	// �������
	CC_SYNTHESIZE(double, returnAmount, ReturnAmount);
public:
	// ��JSONת������
	BIND_TO_JSON(RequestListVO, house, discountId, discountName, requestType, applicant,
		requestPhone, startTime, endTime, state, createTime, useState, returnType, returnAmount);
	RequestListVO() {
		house = u8"1-9-1232	";
		discountId = u8"001";
		discountName = u8"�����Ż�";
		requestType = u8"����Ż�";
		applicant = u8"xxl";
		requestPhone = u8"18909711443";
		startTime = u8"2022-09-20 00:00:00";
		endTime = u8"2022-09-27 23:59:59";
		state = u8"�鷿ͨ��";
		createTime = u8"2022-09-29 15:52:05";
		useState = u8"δʹ��";
		returnType = u8"΢��";
		returnAmount = 273.89;

	}
};

#endif // !_REQUESTLIST_H_

