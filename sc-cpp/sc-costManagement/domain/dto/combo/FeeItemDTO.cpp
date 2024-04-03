#include "stdafx.h"
#include "FeeItemDTO.h"

void from_json(const json& j, FeeItemDTO& f)
{
	BIND_FROM_TO_NORMAL(j, f, communityId);
	BIND_FROM_TO_NORMAL(j, f, createTime);
	BIND_FROM_TO_NORMAL(j, f, feeTypeCd);
	BIND_FROM_TO_NORMAL(j, f, feeTypeCdName);
	BIND_FROM_TO_NORMAL(j, f, importFeeId);
	BIND_FROM_TO_I(j, f, page);
	BIND_FROM_TO_I(j, f, records);
	BIND_FROM_TO_I(j, f, row);
	BIND_FROM_TO_I(j, f, statusCd);
	BIND_FROM_TO_I(j, f, total);
}
