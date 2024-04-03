#include "stdafx.h"
#include "FeeFormulaDTO.h"

void from_json(const json& j, FeeFormulaDTO& t)
{
	BIND_FROM_TO_L(j, t, formulaId);
	BIND_FROM_TO_NORMAL(j, t, formulaValue);
	BIND_FROM_TO_D(j, t, price);
	BIND_FROM_TO_NORMAL(j, t, formulaDesc);
}