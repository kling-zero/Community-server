#include "stdafx.h"
#include "DeleteShareBoothDTO.h"
void from_json(const json& j, DeleteShareBoothDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, baId);
	BIND_FROM_TO_NORMAL(j, t, boxId);
	BIND_FROM_TO_NORMAL(j, t, defaultArea);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, createTime);
	BIND_FROM_TO_NORMAL(j, t, paNum);
	BIND_FROM_TO_I(j, t, page);
	BIND_FROM_TO_I(j, t, records);
	BIND_FROM_TO_I(j, t, row);
	BIND_FROM_TO_I(j, t, statusCd);
	BIND_FROM_TO_I(j, t, total);
}