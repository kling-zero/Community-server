#pragma once
#ifndef _DISCOUNTREQUESTQUERY_H_
#define _DISCOUNTREQUESTQUERY_H_
#include "../PageQuery.h"



class DiscountRequestQuery : public PageQuery
{
public:
	friend void from_json(const json& j, DiscountRequestQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, house);
		BIND_FROM_TO_NORMAL(j, t, requestType);
		BIND_FROM_TO_NORMAL(j, t, state);
	}
private:
	CC_SYNTHESIZE(string, house, House);
	CC_SYNTHESIZE(string, requestType, RequestType);
	CC_SYNTHESIZE(string, state, State);
};
#endif // !_DISCOUNTREQUESTQUERY_H_