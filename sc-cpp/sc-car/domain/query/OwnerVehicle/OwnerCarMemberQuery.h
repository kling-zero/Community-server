#pragma once
#ifndef _OWNERCARMEMBERQUERY_H_
#define _OWNERCARMEMBERQUERY_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/23 11:00:51
* 业主车辆-子母车辆-查询
*/
class OwnerCarMemberQuery : public PageQuery
{
	//社区Id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
public:
	friend void from_json(const json& j, OwnerCarMemberQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, communityId);
		BIND_FROM_TO_NORMAL(j, t, carId);
		BIND_FROM_TO_NORMAL(j, t, carTypeCd);
	}
};

#endif //_OWNERCARMEMBERQUERY_H_