#include "stdafx.h"
#include "FeeCancelController.h"
#include "../../service/feecancel/FeeCancelService.h"

JsonVO<list<FeeCancelStateVO>> FeeCancelController::execQueryFeeCancelState() {
	FeeCancelService service;
	list<FeeCancelStateVO> data = service.listState();

	JsonVO<list<FeeCancelStateVO>> res;
	res.success(data);

	return res;
}

JsonVO<PageVO<FeeCancelVO>> FeeCancelController::execQueryFeeCancel(FeeCancelQuery query)
{
	FeeCancelService service;
	PageVO<FeeCancelVO> data = service.listAll(query);
	
	JsonVO<PageVO<FeeCancelVO>> res;
	res.success(data);

	return res;
}

JsonVO<long> FeeCancelController::execUpdateFeeCancel(FeeCancelDTO dto)
{
	FeeCancelService service;
	JsonVO<long> res;
	long n = service.updateCancel(dto);
	if (n > 0) {
		res.success(n);
	}
	else
	{
		res.fail(n);
	}

	return res;
}

JsonVO<long> FeeCancelController::execUpdateFeeCancelAudit(FeeCancelAuditDTO dto)
{
	FeeCancelService service;
	JsonVO<long> res;
	long n = service.updateAudit(dto);
	if (n > 0) {
		res.success(n);
	}
	else
	{
		res.fail(n);
	}

	return res;
}
