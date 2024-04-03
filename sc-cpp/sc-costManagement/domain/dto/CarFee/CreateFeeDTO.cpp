#include "stdafx.h"
#include "CreateFeeDTO.h"

void from_json(const json& j, CreateFeeDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, feeTypeCdName);
	BIND_FROM_TO_NORMAL(j, t, feeName);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, deadlineTime);
}