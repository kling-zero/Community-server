#pragma once
#ifndef _OWNER_ACCOUNT_DETAIL_DO_
#define _OWNER_ACCOUNT_DETAIL_DO_

#include "../DoInclude.h"

class OwnerAccountDetailDO
{
	CC_SYNTHESIZE(std::string, detailId, DetailId);
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	CC_SYNTHESIZE(std::string, detailType, DetailType);
	CC_SYNTHESIZE(long, amount, Amount);
	CC_SYNTHESIZE(std::string, objType, ObjType);
	CC_SYNTHESIZE(std::string, objId, ObjId);
	CC_SYNTHESIZE(std::string, orderId, OrderId);
	CC_SYNTHESIZE(std::string, bId, BId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, transactionTime, TransactionTime);
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);	
public:
	OwnerAccountDetailDO() {
		detailId = "";
		acctId = "";
		detailType = "";
		amount = 0;
		objType = "2003";
		objId = "";
		orderId = "";
		bId = "";
		remark = "";
		transactionTime = "";
		statusCd = "";
	}
};
#endif //__PRESTORAGEDO_H__