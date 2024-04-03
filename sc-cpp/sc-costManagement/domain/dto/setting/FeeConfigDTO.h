#pragma once
#ifndef _FEECONFIGDTO_H_
#define _FEECONFIGDTO_H_
#include"../../GlobalInclude.h"

class FeeConfigDTO {
	CC_SYNTHESIZE(string, feeTypeCds,FeeTypeCds);	
	CC_SYNTHESIZE(string, feeName, FeeName);
	CC_SYNTHESIZE(string, feeFlags,FeeFlags);
	CC_SYNTHESIZE(string, paymentCds,PaymentCds);
	CC_SYNTHESIZE(int, paymentCycle, PaymentCycle);
	CC_SYNTHESIZE(string, billTypes, BillTypes);
	CC_SYNTHESIZE(string, startTime, StartTime);
	CC_SYNTHESIZE(string, endTime,EndTime);	
	CC_SYNTHESIZE(string, computingFormulas, ComputinFormulas);
	CC_SYNTHESIZE(double, squarePrice,SquareTime);
	CC_SYNTHESIZE(double, additionalAmount,AdditionalAmount);
	CC_SYNTHESIZE(string, deductFrom,DeductFrom);
public:
	friend void from_json(const json& j, FeeConfigDTO& t);
	BIND_TO_JSON(FeeConfigDTO, feeTypeCds, feeName,feeFlags,paymentCds, paymentCycle,billTypes, startTime, endTime,computingFormulas, squarePrice, additionalAmount, deductFrom);

};

#endif