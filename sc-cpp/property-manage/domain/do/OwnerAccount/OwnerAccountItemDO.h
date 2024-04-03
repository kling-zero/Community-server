#pragma once
#ifndef _OWNER_ACCOUNT_ITEM_DO_
#define _OWNER_ACCOUNT_ITEM_DO_

#include "../DoInclude.h"

class OwnerAccountItemDO
{
	//账户ID
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	//账户名称
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	//账户类型
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	//账户金额
	CC_SYNTHESIZE(long, amount, Amount);
	//对象类型
	CC_SYNTHESIZE(std::string, objType, ObjType);
	//对象ID
	CC_SYNTHESIZE(std::string, objId, ObjId);
	//业务ID
	CC_SYNTHESIZE(std::string, bId, BId);
	//创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//数据状态
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//局部ID
	CC_SYNTHESIZE(std::string, partId, PartId);
public:
	OwnerAccountItemDO() 
	{
		acctId = "";
		acctName = "";
		acctType = "";
		amount = 0;
		objType = "";
		objId = "";
		bId = "";
		createTime = "";
		statusCd = "";
		partId = "";
	}
};

#endif //__OWNERACCOUNTITEMDO_H__