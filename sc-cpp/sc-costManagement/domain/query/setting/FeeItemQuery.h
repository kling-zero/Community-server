#pragma once
#ifndef _FEEITEMQUERY_H_
#define _FEEITEMQUERY_H_
#include"../PageQuery.h"

class FeeItemQuery : public PageQuery{
	CC_SYNTHESIZE(std::string,configId , ConfigId);
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	CC_SYNTHESIZE(std::string, billType, BillType);
	CC_SYNTHESIZE(std::string, feeName, FeeName);
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	CC_SYNTHESIZE(std::string, isDefault, IsDefault);
	CC_SYNTHESIZE(int, paymentCd, PaymentCd);
public:
	friend void from_json(const json& j, FeeItemQuery& f) {
		BIND_FROM_TO_L(j, f, pageIndex);
		BIND_FROM_TO_L(j, f, pageSize);
		BIND_FROM_TO_NORMAL(j, f, configId);
		BIND_FROM_TO_NORMAL(j, f, feeFlag);
		BIND_FROM_TO_NORMAL(j, f, billType);
		BIND_FROM_TO_NORMAL(j, f, feeName);
		BIND_FROM_TO_NORMAL(j, f, feeTypeCd);
		BIND_FROM_TO_NORMAL(j, f, isDefault);
		BIND_FROM_TO_I(j, f, paymentCd);
	}
};


#endif