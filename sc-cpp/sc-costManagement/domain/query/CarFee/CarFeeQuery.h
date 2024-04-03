#pragma once
#ifndef _CARFEEQUERY_H_
#define _CARFEEQUERY_H_
#include "../PageQuery.h"

/*
* 车辆收费查询对象
*/

class CarFeeQuery : public PageQuery
{
public:
	friend void from_json(const json& j, CarFeeQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, ownerName);
		BIND_FROM_TO_NORMAL(j, t, carNum);
		BIND_FROM_TO_NORMAL(j, t, allNum);
		BIND_FROM_TO_NORMAL(j, t, state);
	}
private:
	CC_SYNTHESIZE(string, ownerName, OwnerName);
	CC_SYNTHESIZE(string, carNum,CarNum);
	CC_SYNTHESIZE(string, allNum, AllNum);
	CC_SYNTHESIZE(string, state, State);
};
#endif // !_CARFEEQUERY_H_