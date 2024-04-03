#ifndef __FEEFORMULADTO_H__
#define __FEEFORMULADTO_H__

#include "../../GlobalInclude.h"

/**
 ���ù�̯��ʽ���DTO
*/
class FeeFormulaDTO {
	// ��ʽID
	CC_SYNTHESIZE(uint64_t, formulaId, FormulaId);
	// ��ʽ
	CC_SYNTHESIZE(string, formulaValue, FormulaValue);
	// ��ʽ����
	CC_SYNTHESIZE(string, formulaDesc, FormulaDesc);
	// ����
	CC_SYNTHESIZE(double, price, Price);
public:
	//��JSONת������
	friend void from_json(const json& j, FeeFormulaDTO& t);
	BIND_TO_JSON(FeeFormulaDTO, formulaId, formulaValue, formulaDesc, price);
};
#endif //__FEEFORMULADTO_H__