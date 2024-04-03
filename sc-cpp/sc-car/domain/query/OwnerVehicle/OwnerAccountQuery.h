#pragma once
#ifndef _OWNERACCOUNTQUERY_H_
#define _OWNERACCOUNTQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 12:58:13
* 业主车辆-费用-缴费 下面的账户信息
*/
class OwnerAccountQuery : public PageQuery
{
	CC_SYNTHESIZE(std::string, feeId, AeeId);
	CC_SYNTHESIZE(std::string, communityId, CommunityId);

public:
	friend void from_json(const json& j, OwnerAccountQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, feeId);
		BIND_FROM_TO_NORMAL(j, t, communityId);
	}
};

#endif //_OWNERACCOUNTQUERY_H_