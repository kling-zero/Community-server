#include "stdafx.h"
#include "FeeSumController.h"
#include "../../service/feesum/FeeSumService.h"

JsonVO<PageVO<FeeSumVO>> FeeSumController::execQueryFeeSum(FeeSumQuery query)
{
	// ����service�뷵�ض���
	FeeSumService service;
	PageVO<FeeSumVO> data = service.listAll(query);

	JsonVO<PageVO<FeeSumVO>> res;
	res.success(data);

	return res;
}