#include "stdafx.h"
#include "DelFeeListDTO.h"

void from_json(const json& j, DelFeeListDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, feeId);
}