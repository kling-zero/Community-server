#pragma once
#ifndef _FEELISTVO_H_
#define _FEELISTVO_H_
#include"../../GlobalInclude.h"
/**
*费用项列表
*/
class FeeListVO {
		 CC_SYNTHESIZE(double, additionalAmount, AdditionalAmount);
		 CC_SYNTHESIZE(std::string, billType, BillType);
		 CC_SYNTHESIZE(std::string, billTypeName, BillTypeName);
		 CC_SYNTHESIZE(std::string, computingFormula, ComputingFormula);
		 CC_SYNTHESIZE(std::string, computingFormulaName, ComputingFormulaName);
		 CC_SYNTHESIZE(string, computingFormulaText,ComputingFormulaText);
		 CC_SYNTHESIZE(std::string, configId, ConfigId);
		 CC_SYNTHESIZE(std::string, deductFrom, DeductFrom);
		 CC_SYNTHESIZE(std::string, endTime, EndTime);
		 CC_SYNTHESIZE(std::string, feeFlag,FeeFlag);
		 CC_SYNTHESIZE(std::string, feeFlagName, FeeFlagName);
		 CC_SYNTHESIZE(std::string, feeName, FeeName)
		 CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
		 CC_SYNTHESIZE(std::string, feeTypeCdName, FeeTypeCdName);
		 CC_SYNTHESIZE(std::string, isDefault, IsDefault);
		 CC_SYNTHESIZE(int, paymentCd, PaymentCd);
		 CC_SYNTHESIZE(int, paymentCycle, PaymentCycle);
		 CC_SYNTHESIZE(double, squarePrice, SquarePrice);
		 CC_SYNTHESIZE(std::string, startTime, StartTime);

public:
	FeeListVO() {
		additionalAmount = 0.00;
		billType = u8"002";
		billTypeName = u8"每月1日";
		computingFormula = u8"4004";
		computingFormulaName = u8"动态费用";
		computingFormulaText = u8"无";
		configId = u8"922022101887658884";
		deductFrom = u8"N";
		endTime = u8"2038-01-01 00:00:00";
		feeFlag = u8"2006012";
		feeFlagName = u8"一次性费用";
		feeName = u8"测试物业周期费用";
		feeTypeCd = u8"888800010001";
		feeTypeCdName = u8"物业费";
		isDefault = u8"F";
		paymentCd = 2100;
		paymentCycle = 1;
		squarePrice = 0.00;
		startTime = u8"2022-10-18 12:38:42";
	}

	BIND_TO_JSON(FeeListVO,additionalAmount,billType,billTypeName,computingFormula,computingFormulaName,computingFormulaText,configId,deductFrom,endTime,feeFlag,feeFlagName,
		feeName,feeTypeCd,feeTypeCdName,isDefault,paymentCd,paymentCycle,squarePrice,startTime);
};

#endif