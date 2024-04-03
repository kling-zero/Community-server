#pragma once
#ifndef _PRE_STORAGE_DTO_
#define _PRE_STORAGE_DTO_


#include "../../GlobalInclude.h"
/*
* 预存账户DTO
*/
class PreStorageDTO
{
	CC_SYNTHESIZE(std::string, ownerPhone, OwnerPhone);
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(long, preStorageAmount, PreStorageAmount);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, PreStorageDTO& t) {
		BIND_FROM_TO_NORMAL(j, t, ownerPhone);
		BIND_FROM_TO_NORMAL(j, t, ownerName);
		BIND_FROM_TO_L(j, t, preStorageAmount);
		BIND_FROM_TO_NORMAL(j, t, acctType);
		BIND_FROM_TO_NORMAL(j, t, remark);
	}
};
#endif // !_PRE_STORAGE_DTO_

