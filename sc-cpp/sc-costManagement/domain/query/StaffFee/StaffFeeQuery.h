#pragma once
#pragma once
#ifndef _STAFFFEEQUERY_H_
#define _STAFFFEEQUERY_H_
#include "../PageQuery.h"

/*
* 车辆收费查询对象
*/

class StaffFeeQuery : public PageQuery
{
public:
	friend void from_json(const json& j, StaffFeeQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, userId);
		BIND_FROM_TO_NORMAL(j, t, startTime);
		BIND_FROM_TO_NORMAL(j, t, endTime);
	}
private:
	CC_SYNTHESIZE(string, userId, UserId);
	CC_SYNTHESIZE(string, startTime, StartTime);
	CC_SYNTHESIZE(string, endTime, EndTime);
};
#endif // !_STAFFFEEQUERY_H_