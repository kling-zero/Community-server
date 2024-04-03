#pragma once
#ifndef _FEETYPEVO_H_
#define _FEETYPEVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/22 11:15:34
*/
class FeeTypeVO
{
	//
	CC_SYNTHESIZE(std::string, additionalAmount, AdditionalAmount);
	//
	CC_SYNTHESIZE(std::string, billType, BillType);
	//
	CC_SYNTHESIZE(std::string, billTypeName, BillTypeName);
	//
	CC_SYNTHESIZE(std::string, computingFormula, ComputingFormula);
	//
	CC_SYNTHESIZE(std::string, computingFormulaName, ComputingFormulaName);
	//
	CC_SYNTHESIZE(std::string, computingFormulaText, ComputingFormulaText);
	//
	CC_SYNTHESIZE(std::string, configId, ConfigId);
	//
	CC_SYNTHESIZE(std::string, deductFrom, DeductFrom);
	//
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	//
	CC_SYNTHESIZE(std::string, feeFlagName, FeeFlagName);
	//
	CC_SYNTHESIZE(std::string, feeName, FeeName);
	//
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	//
	CC_SYNTHESIZE(std::string, feeTypeCdName, FeeTypeCdName);
	//
	CC_SYNTHESIZE(std::string, isDefault, IsDefault);
	//
	CC_SYNTHESIZE(std::string, paymentCd, PaymentCd);
	//
	CC_SYNTHESIZE(std::string, paymentCycle, PaymentCycle);
	//
	CC_SYNTHESIZE(std::string, squarePrice, SquarePrice);
	//
	CC_SYNTHESIZE(std::string, startTime, StartTime);
public:
	BIND_TO_JSON(FeeTypeVO, additionalAmount, billType, billTypeName, computingFormula, computingFormulaName, computingFormulaText, configId, deductFrom, endTime, feeFlag, feeFlagName, feeName, feeTypeCd, feeTypeCdName, isDefault, paymentCd, paymentCycle, squarePrice, startTime);
};

#endif //_TYPETYPEVO_H_