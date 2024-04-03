#pragma once
#ifndef _BUILDING_INFO_QUERY_
#define _BUILDING_INFO_QUERY_

#include "../PageQuery.h"
/*
*²éÑ¯Â¥¶°ÐÅÏ¢QUERY
*/

class BuildingInfoQuery : public PageQuery
{
public:
	CC_SYNTHESIZE(std::string, buildingName, BuildingName);
	CC_SYNTHESIZE(std::string, buildingId, BuildingId);
public:
	friend void from_json(const json& j, BuildingInfoQuery& t) {
		BIND_FROM_TO_NORMAL(j, t, buildingName);
		BIND_FROM_TO_NORMAL(j, t, buildingId);
	}
};

#endif // _BUILDING_INFO_QUERY_