#include "stdafx.h"
#include "FeeConfigsDTO.h"

void from_json(const json& j, FeeConfigsDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, additionalAmount);
	BIND_FROM_TO_NORMAL(j, t, billType);
	BIND_FROM_TO_NORMAL(j, t, billTypeName);
	BIND_FROM_TO_NORMAL(j, t, computingFormula);
	BIND_FROM_TO_NORMAL(j, t, computingFormulaName);
	BIND_FROM_TO_NORMAL(j, t, computingFormulaText);
	BIND_FROM_TO_NORMAL(j, t, configId);
	BIND_FROM_TO_NORMAL(j, t, deductFrom);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, feeFlag);
	BIND_FROM_TO_NORMAL(j, t, feeFlagName);
	BIND_FROM_TO_NORMAL(j, t, feeName);
	BIND_FROM_TO_NORMAL(j, t, feeTypeCd);
	BIND_FROM_TO_NORMAL(j, t, feeTypeCdName);
	BIND_FROM_TO_NORMAL(j, t, isDefault);
	BIND_FROM_TO_NORMAL(j, t, paymentCd);
	BIND_FROM_TO_NORMAL(j, t, paymentCycle);
	BIND_FROM_TO_NORMAL(j, t, squarePrice);
	BIND_FROM_TO_NORMAL(j, t, startTime);
}
