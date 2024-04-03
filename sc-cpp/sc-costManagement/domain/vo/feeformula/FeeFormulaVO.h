#ifndef _FEEFORMULA_VO_
#define _FEEFORMULA_VO_

#include "../../GlobalInclude.h"

/**
* ���ù�̯��ʽVO
*/
class FeeFormulaVO {
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
	// ��JSONת������
	BIND_TO_JSON(FeeFormulaVO, formulaId, formulaType, formulaValue, formulaDesc, price);
};

#endif