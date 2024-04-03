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
	// 查询公式
	JsonVO<PageVO<FeeFormulaVO>> execQueryFeeFormula(FeeFormulaQuery query);
	// 增加公式
	JsonVO<uint64_t> execAddFeeFormula(FeeFormulaDTO dto);
	// 更改公式
	JsonVO<uint64_t> execUpdateFeeFormula(FeeFormulaDTO dto);
	// 删除公式
	JsonVO<long> execRemoveFeeFormula(FeeFormulaDTO dto);
};
#endif
