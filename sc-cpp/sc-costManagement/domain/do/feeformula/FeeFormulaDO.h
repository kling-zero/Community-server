/***************************************************************************** 
    *  @file     : FeeFormulaDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 9:15
    *  @brief    : 公摊公式DO 
*****************************************************************************/  
#ifndef __FEEFORMULADO_H__
#define __FEEFORMULADO_H__

#include "../DoInclude.h"

class FeeFormulaDO {
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
	FeeFormulaDO() {
		formulaId = -1;
		formulaType = -1;
		formulaValue = "";
		formulaDesc = "";
		price = -1;
	}
};
#endif //__FEEFORMULADO_H__
