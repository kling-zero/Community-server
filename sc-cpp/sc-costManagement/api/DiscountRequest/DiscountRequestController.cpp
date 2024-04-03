#include "stdafx.h"
#include "DiscountRequestController.h"

JsonVO<PageVO<RequestListVO>> DiscountRequestController::executeQueryRequestList(DiscountRequestQuery query)
{
	PageVO<RequestListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { RequestListVO() });
	JsonVO<PageVO<RequestListVO>> res;
	res.success(data);
	return res;
}
JsonVO<std::list<RequestStateVO>> DiscountRequestController::executeQueryRequestState()
{
	std::list<RequestStateVO> data({ RequestStateVO() });
	JsonVO<std::list<RequestStateVO>> res;
	res.success(data);
	return res;
}
JsonVO<std::list<RequestTypeVO>> DiscountRequestController::executeQueryRequestType()
{
	std::list<RequestTypeVO> data({ RequestTypeVO() });
	JsonVO<std::list<RequestTypeVO>> res;
	res.success(data);
	return res;
}