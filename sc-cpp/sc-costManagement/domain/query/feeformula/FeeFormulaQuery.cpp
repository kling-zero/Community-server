#include "stdafx.h"
#include "FeeFormulaQuery.h"

void from_json(const json& j, FeeFormulaQuery& t)
{
	BIND_FROM_TO_L(j, t, pageIndex);
	BIND_FROM_TO_L(j, t, pageSize);
}
