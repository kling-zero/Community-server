#include "stdafx.h"
#include "FeeCancelQuery.h"

void from_json(const json& j, FeeCancelQuery& t)
{
	BIND_FROM_TO_L(j, t, pageIndex);
	BIND_FROM_TO_L(j, t, pageSize);
	BIND_FROM_TO_UL(j, t, batchId);
	BIND_FROM_TO_NORMAL(j, t, createUserName);
	BIND_FROM_TO_UL(j, t, stateId);
}
