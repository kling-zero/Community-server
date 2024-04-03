#pragma once
#define __CARFEECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/PageVO.h"
#include "domain/vo/DiscountRequest/RequestListVO.h"
#include "domain/vo/DiscountRequest/RequestStateVO.h"
#include "domain/vo/DiscountRequest/RequestTypeVO.h"
#include "domain/query/DiscountRequest/DiscountRequestQuery.h"
#include "api/ApiHelper.h"


class DiscountRequestController
{
public:
	CREATE_API_FUN_QUERY3(queryRequestState, executeQueryRequestState);
	CREATE_API_FUN_QUERY(queryRequestList, executeQueryRequestList, DiscountRequestQuery);
	CREATE_API_FUN_QUERY3(queryRequestType, executeQueryRequestType);
private:
	JsonVO<PageVO<RequestListVO>> executeQueryRequestList(DiscountRequestQuery query);
	JsonVO<std::list<RequestStateVO>> executeQueryRequestState();
	JsonVO<std::list<RequestTypeVO>> executeQueryRequestType();
};


