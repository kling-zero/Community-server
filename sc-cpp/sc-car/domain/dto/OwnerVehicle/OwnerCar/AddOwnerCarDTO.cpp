#include "stdafx.h"
#include "AddOwnerCarDTO.h"

void from_json(const json& j, AddOwnerCarDTO& t) {
	BIND_FROM_TO_OBJ(j, t, attrs, std::list<AttrsDTO>);
	BIND_FROM_TO_NORMAL(j, t, carAttrs);
	BIND_FROM_TO_NORMAL(j, t, carBrand);
	BIND_FROM_TO_NORMAL(j, t, carColor);
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, carNumType);
	BIND_FROM_TO_NORMAL(j, t, carType);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, flowComponent);
	BIND_FROM_TO_NORMAL(j, t, ownerId);
	BIND_FROM_TO_NORMAL(j, t, psId);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, startTime);
	BIND_FROM_TO_NORMAL(j, t, value);
}