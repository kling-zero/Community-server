#pragma once
#ifndef _QWNER_INFO_QUERY_
#define _OWNER_INFO_QUERY_

#include "../PageQuery.h"
/*
*查询业主信息QUERY
*/

class OwnerInfoQuery: public PageQuery
{
public:
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(std::string, roomNum, RoomNum);
	CC_SYNTHESIZE(std::string, phoneNum, PhoneNum);
	CC_SYNTHESIZE(std::string, peopleId, PeopleId);
	CC_SYNTHESIZE(std::string, idCard, IdCard);
public:
	friend void from_json(const json& j, OwnerInfoQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, ownerName);
		BIND_FROM_TO_NORMAL(j, t, roomNum);
		BIND_FROM_TO_NORMAL(j, t, phoneNum);
		BIND_FROM_TO_NORMAL(j, t, peopleId);
		BIND_FROM_TO_NORMAL(j, t, idCard);
	}
};

#endif // _OWNER_INFO_QUERY_