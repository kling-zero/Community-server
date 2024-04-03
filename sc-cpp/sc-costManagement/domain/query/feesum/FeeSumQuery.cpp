#include "stdafx.h"
#include "FeeSumQuery.h"

void from_json(const json& j, FeeSumQuery& t)
{
	BIND_FROM_TO_L(j, t, pageIndex);
	BIND_FROM_TO_L(j, t, pageSize);
}
