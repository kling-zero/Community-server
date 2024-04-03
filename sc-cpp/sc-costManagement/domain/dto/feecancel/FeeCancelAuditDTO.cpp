#include "stdafx.h"
#include "FeeCancelAuditDTO.h"

void from_json(const json& j, FeeCancelAuditDTO& t)
{
	BIND_FROM_TO_L(j, t, batchId);
	BIND_FROM_TO_NORMAL(j, t, stateName);
	BIND_FROM_TO_NORMAL(j, t, msg);
}
