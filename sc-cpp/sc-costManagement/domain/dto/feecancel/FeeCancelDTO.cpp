#include "stdafx.h"
#include "FeeCancelDTO.h"

void from_json(const json& j, FeeCancelDTO& t)
{
	BIND_FROM_TO_UL(j, t, batchId);
	BIND_FROM_TO_NORMAL(j, t, createTime);
	BIND_FROM_TO_NORMAL(j, t, createUserName);
	BIND_FROM_TO_NORMAL(j, t, reason);

}
