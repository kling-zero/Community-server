#pragma once
#ifndef _OWNERACCOUNTVO_H_
#define _OWNERACCOUNTVO_H_

#include "../../GlobalInclude.h"
#include "../PageVO.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 13:47:15
* 业主车辆-费用-缴费 下面的账户信息
*/
class OwnerAccountVO
{
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	CC_SYNTHESIZE(std::string, acctTypeName, AcctTypeName);
	CC_SYNTHESIZE(std::string, amount, Amount);
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	CC_SYNTHESIZE(std::string, objId, ObjId);
	CC_SYNTHESIZE(std::string, objType, ObjType);
	CC_SYNTHESIZE(std::string, partId, PartId);
	CC_SYNTHESIZE(std::string, statusCd, StatusCd); 
public:
	BIND_TO_JSON(OwnerAccountVO, acctId, acctName, acctType, acctTypeName, amount, createTime, objId, partId, partId, statusCd);
};

#endif //_OWNERACCOUNTVO_H_