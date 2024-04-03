#pragma once
#ifndef _OWNER_ITEM_QUERY_
#define _OWNER_ITEM_QUERY_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

class OwnerItemQuery: public PageQuery
{
	CC_SYNTHESIZE(string, roomId, RoomId);
	CC_SYNTHESIZE(string, ownerName, OwnerName);
public:
	friend void from_json(const json& j, OwnerItemQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, roomId);
		BIND_FROM_TO_NORMAL(j, t, ownerName);
	}
};

#endif

