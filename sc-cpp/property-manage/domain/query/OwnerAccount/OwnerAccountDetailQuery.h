#pragma once
#ifndef _OWNER_ACCOUNT_DETAIL_QUERY_
#define _OWNER_ACCOUNT_DETAIL_QUERY_

#include "../PageQuery.h"
/*
* 查询业主账户明细QUERY
*/
class OwnerAccountDetailQuery : public PageQuery
{
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, acctId, AcctId);
public:
	friend void from_json(const json& j, OwnerAccountDetailQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, acctName);
		BIND_FROM_TO_NORMAL(j, t, acctId);
	}

};

#endif // _ACCOUNT_QUERY