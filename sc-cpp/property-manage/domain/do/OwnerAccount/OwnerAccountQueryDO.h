#pragma once
#ifndef _OWNER_ACCOUNT_QUERY_DO_
#define _OWNER_ACCOUNT_QUERY_DO_

#include "../DoInclude.h"
class OwnerAccountQueryDO
{
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, acctIdCard, AcctIdCard);
	CC_SYNTHESIZE(std::string, acctLink, AcctLink);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
public:
	OwnerAccountQueryDO()
	{
		acctName = "";
		acctIdCard = "";
		acctLink = "";
		acctType = "";
	}
};

#endif //__OWNERACCOUNTQUERYDO_H__
