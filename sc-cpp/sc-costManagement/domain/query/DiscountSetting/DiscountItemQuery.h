#pragma once
#ifndef _DISCOUNTITEMQUERY_H_
#define _DISCOUNTITEMQUERY_H_
#include "../PageQuery.h"



class DiscountItemQuery : public PageQuery
{
public:
	friend void from_json(const json& j, DiscountItemQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, discountId);
		BIND_FROM_TO_NORMAL(j, t, discountName);
		BIND_FROM_TO_NORMAL(j, t, discountType);
		BIND_FROM_TO_NORMAL(j, t, ruleName);
	}
private:
	CC_SYNTHESIZE(string, discountId, DiscountId);
	CC_SYNTHESIZE(string, discountName, DiscountName);
	CC_SYNTHESIZE(string, discountType, DiscountType);
	CC_SYNTHESIZE(string, ruleName, RuleName);
};
#endif // !_DISCOUNTITEMQUERY_H_