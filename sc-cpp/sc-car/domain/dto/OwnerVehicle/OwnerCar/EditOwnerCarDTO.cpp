#include "stdafx.h"
#include "EditOwnerCarDTO.h"

void from_json(const json& j, EditOwnerCarDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, carBrand);
	BIND_FROM_TO_NORMAL(j, t, carColor);
	BIND_FROM_TO_NORMAL(j, t, carId);
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, carNumType);
	BIND_FROM_TO_NORMAL(j, t, carType);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, memberId);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, startTime);
}