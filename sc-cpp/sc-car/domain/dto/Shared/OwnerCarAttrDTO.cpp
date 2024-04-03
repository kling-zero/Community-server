#include "stdafx.h"
#include "OwnerCarAttrDTO.h"

void from_json(const json& j, OwnerCarAttrDTO& t) 
{
	BIND_FROM_TO_NORMAL(j, t, attrId);
	BIND_FROM_TO_NORMAL(j, t, carId);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, createTime);
	BIND_FROM_TO_NORMAL(j, t, listShow);
	BIND_FROM_TO_NORMAL(j, t, specCd);
	BIND_FROM_TO_NORMAL(j, t, specName);
	BIND_FROM_TO_NORMAL(j, t, statusCd);
	BIND_FROM_TO_NORMAL(j, t, value);
	BIND_FROM_TO_NORMAL(j, t, valueName);
}