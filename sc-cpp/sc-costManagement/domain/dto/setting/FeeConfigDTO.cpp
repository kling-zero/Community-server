#include "stdafx.h"
#include "FeeConfigDTO.h"

void from_json(const json& j, FeeConfigDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, feeTypeCds);
	BIND_FROM_TO_NORMAL(j, t, feeName);
	BIND_FROM_TO_NORMAL(j, t, feeFlags);
	BIND_FROM_TO_NORMAL (j, t, paymentCds);
	BIND_FROM_TO_I(j, t, paymentCycle);
	BIND_FROM_TO_NORMAL(j, t, billTypes);
	BIND_FROM_TO_NORMAL(j, t, startTime);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, computingFormulas);
	BIND_FROM_TO_D(j, t, squarePrice);
	BIND_FROM_TO_D(j, t, additionalAmount);
	BIND_FROM_TO_NORMAL(j, t, deductFrom);
}

