#ifndef _FEE_FORMULA_CONTROLLER_
#define _FEE_FORMULA_CONTROLLER_

#include "../../domain/dto/IDDTO.h"
#include "../../domain/vo/feeformula/FeeFormulaVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/JsonVO.h"
#include "../../domain/dto/feeformula/FeeFormulaDTO.h"
#include "../../domain/query/feeformula/FeeFormulaQuery.h"
#include "api/ApiHelper.h"

class FeeFormulaController {
public:
	CREATE_API_FUN_QUERY(queryFeeFormula, execQueryFeeFormula, FeeFormulaQuery);
	CREATE_API_FUN_BODY(addFeeFormula, execAddFeeFormula, FeeFormulaDTO);
	CREATE_API_FUN_BODY(updateFeeFormula, execUpdateFeeFormula, FeeFormulaDTO);
	CREATE_API_FUN_BODY(removeFeeFormula, execRemoveFeeFormula, FeeFormulaDTO);
private:
	// ��ѯ��ʽ
	JsonVO<PageVO<FeeFormulaVO>> execQueryFeeFormula(FeeFormulaQuery query);
	// ���ӹ�ʽ
	JsonVO<uint64_t> execAddFeeFormula(FeeFormulaDTO dto);
	// ���Ĺ�ʽ
	JsonVO<uint64_t> execUpdateFeeFormula(FeeFormulaDTO dto);
	// ɾ����ʽ
	JsonVO<long> execRemoveFeeFormula(FeeFormulaDTO dto);
};
#endif
