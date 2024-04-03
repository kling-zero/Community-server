#include "stdafx.h"
#include "EditFeeListDTO.h"

void from_json(const json& j, EditFeeListDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, computingFormula);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, feeFlag);
	BIND_FROM_TO_NORMAL(j, t, feeId);
	BIND_FROM_TO_NORMAL(j, t, maxEndTime);
	BIND_FROM_TO_NORMAL(j, t, rate);
	BIND_FROM_TO_NORMAL(j, t, rateCycle);
	BIND_FROM_TO_NORMAL(j, t, rateStartTime);
	BIND_FROM_TO_NORMAL(j, t, startTime);
}