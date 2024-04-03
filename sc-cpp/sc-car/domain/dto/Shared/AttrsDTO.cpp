#include "stdafx.h"
#include "AttrsDTO.h"

void from_json(const json& j, AttrsDTO& t) 
{
	BIND_FROM_TO_NORMAL(j, t, attrId);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, listShow);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_NORMAL(j, t, page);
	BIND_FROM_TO_NORMAL(j, t, records);
	BIND_FROM_TO_NORMAL(j, t, row);
	BIND_FROM_TO_NORMAL(j, t, specCd);
	BIND_FROM_TO_NORMAL(j, t, specName);
	BIND_FROM_TO_NORMAL(j, t, specType);
	BIND_FROM_TO_NORMAL(j, t, statusCd);
	BIND_FROM_TO_NORMAL(j, t, total);
	BIND_FROM_TO_NORMAL(j, t, value);
}
