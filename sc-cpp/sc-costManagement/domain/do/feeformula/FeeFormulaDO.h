/***************************************************************************** 
    *  @file     : FeeFormulaDO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 9:15
    *  @brief    : ��̯��ʽDO 
*****************************************************************************/  
#ifndef __FEEFORMULADO_H__
#define __FEEFORMULADO_H__

#include "../DoInclude.h"

class FeeFormulaDO {
	// ��ʽID
	CC_SYNTHESIZE(uint64_t, formulaId, FormulaId);
	// ��ʽ����
	CC_SYNTHESIZE(int, formulaType, FormulaType);
	// ��ʽ
	CC_SYNTHESIZE(string, formulaValue, FormulaValue);
	// ��ʽ����
	CC_SYNTHESIZE(string, formulaDesc, FormulaDesc);
	// ����
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
