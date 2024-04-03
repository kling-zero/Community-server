#ifndef __FEEFORMULADTO_H__
#define __FEEFORMULADTO_H__

#include "../../GlobalInclude.h"

/**
 费用公摊公式添加DTO
*/
class FeeFormulaDTO {
	// 公式ID
	CC_SYNTHESIZE(uint64_t, formulaId, FormulaId);
	// 公式
	CC_SYNTHESIZE(string, formulaValue, FormulaValue);
	// 公式描述
	CC_SYNTHESIZE(string, formulaDesc, FormulaDesc);
	// 单价
	CC_SYNTHESIZE(double, price, Price);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, FeeFormulaDTO& t);
	BIND_TO_JSON(FeeFormulaDTO, formulaId, formulaValue, formulaDesc, price);
};
#endif //__FEEFORMULADTO_H__