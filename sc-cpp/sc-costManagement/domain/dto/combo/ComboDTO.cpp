#include "stdafx.h"
#include "ComboDTO.h"

void from_json(const json& j, ComboDTO& c)
{
	BIND_FROM_TO_NORMAL(j, c, comboName);
	BIND_FROM_TO_NORMAL(j, c,remark);
	BIND_FROM_TO_NORMAL(j, c, communityId);
}
