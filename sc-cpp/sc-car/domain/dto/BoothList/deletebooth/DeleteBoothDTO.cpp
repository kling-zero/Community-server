#include "stdafx.h"
#include "DeleteBoothDTO.h"
void from_json(const json& j, DeleteBoothDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, boxId);
	/*BIND_FROM_TO_NORMAL(j, t, blueCarIn);
	BIND_FROM_TO_NORMAL(j, t, boxName);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, fee);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_NORMAL(j, t, paNum);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, tempCarIn);
	BIND_FROM_TO_NORMAL(j, t, yelowCarIn);
	BIND_FROM_TO_NORMAL(j, t, statusCd);
	BIND_FROM_TO_I(j, t, page);
	BIND_FROM_TO_I(j, t, records);
	BIND_FROM_TO_I(j, t, row);
	BIND_FROM_TO_I(j, t, total);*/
}