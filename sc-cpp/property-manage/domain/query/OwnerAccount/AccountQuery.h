#pragma once
#ifndef _ACCOUNT_QUERY
#define _ACCOUNT_QUERY

#include "../PageQuery.h"
/*
* 查询业主账户QUERY
*/
class AccountQuery: public PageQuery
{
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, acctIdCard, AcctIdCard);
	CC_SYNTHESIZE(std::string, acctLink, AcctLink);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
public:
	friend void from_json(const json& j, AccountQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, acctName);
		BIND_FROM_TO_NORMAL(j, t, acctIdCard);
		BIND_FROM_TO_NORMAL(j, t, acctLink);
		BIND_FROM_TO_NORMAL(j, t, acctType);
	}

};

#endif // _ACCOUNT_QUERY

