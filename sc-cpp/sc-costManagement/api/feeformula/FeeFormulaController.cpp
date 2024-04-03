#include "stdafx.h"
#include "FeeFormulaController.h"
#include "../../service/feeformula/FeeFormulaService.h"

JsonVO<PageVO<FeeFormulaVO>> FeeFormulaController::execQueryFeeFormula(FeeFormulaQuery query)
{
	//����һ��Service
	FeeFormulaService service;
	//��ѯ����
	PageVO<FeeFormulaVO> result = service.listAll(query);
	//��Ӧ���
	return JsonVO<PageVO<FeeFormulaVO>>(result, RS_SUCCESS);
}

JsonVO<uint64_t> FeeFormulaController::execAddFeeFormula(FeeFormulaDTO dto)
{
	//����һ��Service
	FeeFormulaService service;
	JsonVO<uint64_t> res;
	uint64_t id = service.saveData(dto);
	
	if (id > 0)
	{
		res.success(id);
	}
	else
	{
		res.fail(id);
	}

	return res;
}

JsonVO<uint64_t> FeeFormulaController::execUpdateFeeFormula(FeeFormulaDTO dto)
{
	//����һ��Service
	FeeFormulaService service;
	JsonVO<uint64_t> res;
	if (service.updateData(dto)) {
		res.success(dto.getFormulaId());
	}
	else {
		res.fail(dto.getFormulaId());
	}

	return res;
}

JsonVO<long> FeeFormulaController::execRemoveFeeFormula(FeeFormulaDTO dto)
{
	//����һ��Service
	FeeFormulaService service;
	JsonVO<long> res;
	if (service.removeData(dto.getFormulaId()))
	{
		res.success(dto.getFormulaId());
	} 
	else
	{
		res.fail(dto.getFormulaId());
	}

	return res;
}
