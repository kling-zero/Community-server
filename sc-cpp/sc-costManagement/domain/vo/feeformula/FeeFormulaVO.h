#ifndef _FEEFORMULA_VO_
#define _FEEFORMULA_VO_

#include "../../GlobalInclude.h"

/**
* 费用公摊公式VO
*/
class FeeFormulaVO {
	// 公式ID
	CC_SYNTHESIZE(uint64_t, formulaId, FormulaId);
	// 公式类型
	CC_SYNTHESIZE(int, formulaType, FormulaType);
	// 公式
	CC_SYNTHESIZE(string, formulaValue, FormulaValue);
	// 公式描述
	CC_SYNTHESIZE(string, formulaDesc, FormulaDesc);
	// 单价
	CC_SYNTHESIZE(double, price, Price);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(FeeFormulaVO, formulaId, formulaType, formulaValue, formulaDesc, price);
};

#endif