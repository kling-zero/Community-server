#pragma once
#ifndef _OWNER_ACCOUNT_DETAIL_VO_
#define _OWNER_ACCOUNT_DETAIL_VO_
#include "../../GlobalInclude.h"
#include "../PageVO.h"
/*
* 业主账户明细VO
*/
class OwnerAccountDetailVO//: public PageVO<OwnerAccountDetailVO>
{
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	CC_SYNTHESIZE(std::string, orderId, OrderId);
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	CC_SYNTHESIZE(std::string, detailId, DetailId);
	CC_SYNTHESIZE(std::string, detailType, DetailType);
	CC_SYNTHESIZE(long, amount, Amount);
	CC_SYNTHESIZE(std::string, transactionTime, TransactionTime);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, objId, ObjId);
	CC_SYNTHESIZE(std::string, objType, ObjType);	
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
public:
	BIND_TO_JSON(OwnerAccountDetailVO,
		acctId,
		orderId,
		acctName,
		detailId,
		detailType,
		amount,
		transactionTime,
		remark,
		objId,
		objType,	
		statusCd);

};

#endif // _OWNER_ACCOUNT_DETAIL_
