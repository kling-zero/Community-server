#pragma once
#ifndef _FEECOMBOMEMBERLISTVO_H_
#define _FEECOMBOMEMBERLISTVO_H_
#include"../../GlobalInclude.h"

class FeeComboMemberListVO {
	CC_SYNTHESIZE(double, additionalAmount, AdditionalAmount);
	CC_SYNTHESIZE(int, amount, Amount);
	CC_SYNTHESIZE(string, billType, BillType);
	CC_SYNTHESIZE(string, billTypeName, BillTypeName);
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, computingFormula, ComputingFormula);
	CC_SYNTHESIZE(string, computingFormulaText, ComputingFormulaText);
	CC_SYNTHESIZE(string, configId, ConfigId);
	CC_SYNTHESIZE(string, endTime, EndTime);
	CC_SYNTHESIZE(string, feeFlag, FeeFlag);
	CC_SYNTHESIZE(string, feeFlagName, FeeFlagName);
	CC_SYNTHESIZE(string, feeName, FeeName);
	CC_SYNTHESIZE(string, feeTypeCd, FeeTypeCd);
	CC_SYNTHESIZE(string, feeTypeCdName, FeeTypeCdName);
	CC_SYNTHESIZE(string, isDefault, IsDefault);
	CC_SYNTHESIZE(string, memberId, MemberId);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, paymentCd, PaymentCd);
	CC_SYNTHESIZE(int, paymentCycle, PaymentCycle);
	CC_SYNTHESIZE(int, records, Records);
	CC_SYNTHESIZE(int, row, Row);
	CC_SYNTHESIZE(double, squarePrice, SquarePrice);
	CC_SYNTHESIZE(string, startTime, StartTime);
	CC_SYNTHESIZE(int, statusCd, StatusCd);
	CC_SYNTHESIZE(int, total, Total);

public:
	FeeComboMemberListVO() {
		additionalAmount = 100.00;
		amount = 0;
		billType = u8"001";
		billTypeName = u8"每年1月1日";
		communityId = u8"2022090665021542";
		computingFormula = u8"1001";
		computingFormulaText = u8"无";
		configId = u8"922022101892319489";
		endTime = u8"2050-01-01 00:00:00";
		feeFlag = u8"1003006";
		feeFlagName = u8"周期性费用";
		feeName = u8"押金";
		feeTypeCd = u8"888800010001";
		feeTypeCdName = u8"物业费";
		isDefault = u8"F";
		memberId = u8"1020221020558110253";
		page = -1;
		paymentCd = 1200;
		paymentCycle = 1;
		records = 0;
		row = 0;
		squarePrice = 1.00;
		startTime = u8"2010-01-01 00:00:00";
		statusCd = 0;
		total = 0;
	}

	BIND_TO_JSON(FeeComboMemberListVO, additionalAmount, amount, billType, billTypeName, communityId, computingFormula, computingFormulaText, configId, endTime, feeFlag, feeFlagName, feeName, feeTypeCd, feeTypeCdName, isDefault, memberId, page, paymentCd, paymentCycle, records, row, squarePrice, startTime, statusCd, total);
};

#endif