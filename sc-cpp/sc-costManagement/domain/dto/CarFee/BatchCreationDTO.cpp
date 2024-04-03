#include "stdafx.h"
#include "BatchCreationDTO.h"

void from_json(const json& j, BatchCreationDTO& t) {
	BIND_FROM_TO_I(j, t, id);
	BIND_FROM_TO_NORMAL(j, t, feeType);
	BIND_FROM_TO_NORMAL(j, t, chargingItem);
	BIND_FROM_TO_NORMAL(j, t, parking);
	BIND_FROM_TO_NORMAL(j, t, state);
	BIND_FROM_TO_NORMAL(j, t, startTime);
	BIND_FROM_TO_NORMAL(j, t, endTime);
}