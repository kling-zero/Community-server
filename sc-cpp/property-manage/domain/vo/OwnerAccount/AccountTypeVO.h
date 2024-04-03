#pragma once
#ifndef _ACCOUNT_TYPE_VO_
#define _ACCOUNT_TYPE_VO_

#include "../../GlobalInclude.h"
#include "../PageVO.h"
/*
* 业主账户类型VO
*/
class AccountTypeVO
{
	CC_SYNTHESIZE(int, typeId, TypeId);
	CC_SYNTHESIZE(std::string, typeName, TypeName);

private:
	BIND_TO_JSON(AccountTypeVO, typeId, typeName);
public:
	AccountTypeVO(int typeId, std::string typeName) :typeId(typeId), typeName(typeName) {};
};


#endif