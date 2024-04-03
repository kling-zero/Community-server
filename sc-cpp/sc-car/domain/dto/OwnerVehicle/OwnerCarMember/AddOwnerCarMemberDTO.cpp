#include "stdafx.h"
#include "AddOwnerCarMemberDTO.h"

void from_json(const json& j, AddOwnerCarMemberDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, carBrand);
	BIND_FROM_TO_NORMAL(j, t, carColor);
	BIND_FROM_TO_NORMAL(j, t, carId);
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, carType);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, flowComponent);
	BIND_FROM_TO_NORMAL(j, t, remark);

}