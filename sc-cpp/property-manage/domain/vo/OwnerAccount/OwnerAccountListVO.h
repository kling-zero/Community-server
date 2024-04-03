#pragma once
#ifndef _OWNER_ACCOUNT_LIST_VO_
#define _OWNER_ACCOUNT_LIST_VO_

#include "../../GlobalInclude.h"
#include "../PageVO.h"
/*
* 业主账户列表VO
*/
class OwnerAccountListVO//: public PageVO<OwnerAccountListVO>
{
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	CC_SYNTHESIZE(std::string, acctTypeName, AcctTypeName);
	CC_SYNTHESIZE(long, amount, Amount);
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	CC_SYNTHESIZE(std::string, objId, ObjId);
	CC_SYNTHESIZE(std::string, objType, ObjType);
	CC_SYNTHESIZE(std::string, partId, PartId);
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);

public:
	BIND_TO_JSON(OwnerAccountListVO, 
		acctId, 
		acctName, 
		acctType,
		acctTypeName, 
		amount, 
		createTime, 
		objId, 
		objType, 
		partId, 
		statusCd);

};


#endif // !_OWNER_ACCOUNT_LIST_VO_
