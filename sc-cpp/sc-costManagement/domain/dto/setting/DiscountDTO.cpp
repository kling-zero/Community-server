#include "stdafx.h"
#include "DiscountDTO.h"

void from_json(const json& j, DiscountDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, discountTypeName);
	BIND_FROM_TO_NORMAL(j, t, discountName);
	BIND_FROM_TO_NORMAL(j, t, startTime);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, payMaxEndTime);
}
