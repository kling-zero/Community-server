#pragma once
#ifndef _FEEFORMULAVO_H_
#define _FEEFORMULAVO_H_
#include"../../GlobalInclude.h"
class FeeFormulVO {
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, formulaDesc, FormulaDesc);
	CC_SYNTHESIZE(string, formulaId, FromulaId);
	CC_SYNTHESIZE(string, formulaType, FormulaType);
	CC_SYNTHESIZE(string, formulaValue, FormulaValue);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(double, price, Price);
	CC_SYNTHESIZE(int, records, Records);
	CC_SYNTHESIZE(int, row, Row);
	CC_SYNTHESIZE(string, statusCd, StatusCd);
	CC_SYNTHESIZE(int, total, Total);
public:
	FeeFormulVO() {
		communityId = u8"2022090665021542";
		formulaDesc = u8"1";
		formulaId = u8"792022101727878314";
		formulaType = u8"6006";
		formulaValue = u8"1";
		page = -1;
		price = 1.00;
		records = 0;
		row = 0;
		statusCd = u8"0";
		total = 0;
	}
	BIND_TO_JSON(FeeFormulVO, communityId, formulaDesc, formulaId, formulaType, formulaValue, page, price, records, row, statusCd, total);
};

#endif