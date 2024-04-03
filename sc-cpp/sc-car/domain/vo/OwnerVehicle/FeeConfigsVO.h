#pragma once
#ifndef _FEECONFIGSVO_H_
#define _FEECONFIGSVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 14:14:30
* ҵ������-����-��ʷ-����������
* ��Ӧ owner.listFeeConfigs
*/
class FeeConfigsVO
{
	//����/�̶�����
	CC_SYNTHESIZE(std::string, additionalAmount, AdditionalAmount);
	//�߽����ͱ��
	CC_SYNTHESIZE(std::string, billType, BillType);
	//�߽���������
	CC_SYNTHESIZE(std::string, billTypeName, BillTypeName);
	//��ʽ���	
	CC_SYNTHESIZE(std::string, computingFormula, BomputingFormula);
	//��ʽ����
	CC_SYNTHESIZE(std::string, computingFormulaName, ComputingFormulaName);
	//δ֪
	CC_SYNTHESIZE(std::string, computingFormulaText, ComputingFormulaText);
	//������ID
	CC_SYNTHESIZE(std::string, configId, ConfigId);
	//δ֪
	CC_SYNTHESIZE(std::string, deductFrom, DeductFrom);
	//�Ʒ���ֹʱ��
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//���ñ�ʶ���
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	//���ñ�ʶ����
	CC_SYNTHESIZE(std::string, feeFlagName, FeeFlagName);
	//�շ���Ŀ
	CC_SYNTHESIZE(std::string, feeName, FeeName);
	//�������ͱ��
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	//������������
	CC_SYNTHESIZE(std::string, feeTypeCdName, FeeTypeCdName);
	//δ֪
	CC_SYNTHESIZE(std::string, isDefault, IsDefault);
	//δ֪
	CC_SYNTHESIZE(std::string, paymentCd, PaymentCd);
	//�ɷ�����
	CC_SYNTHESIZE(std::string, paymentCycle, PaymentCycle);
	//�Ʒѵ���
	CC_SYNTHESIZE(std::string, squarePrice, SquarePrice);
	//�Ʒ���ʼʱ��
	CC_SYNTHESIZE(std::string, startTime, StartTime);

public:
	BIND_TO_JSON(FeeConfigsVO, additionalAmount, billType, billTypeName, computingFormula, computingFormulaName, computingFormulaText, configId, deductFrom, endTime, feeFlag, feeFlagName, feeName ,feeTypeCd, feeTypeCdName, isDefault, paymentCd, paymentCycle, squarePrice, startTime);
};

#endif //_LISTFEECONFIGSVO_H_