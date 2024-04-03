#include "stdafx.h"
#include "AddUnitDTO.h"

/*
	@author:niuniu
	@Date:2022/11/4
	@Ìí¼Óµ¥Ôª
*/

void from_json(const json& j, AddUnitDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, unit_num);
	BIND_FROM_TO_I(j, t, layer_count);
	BIND_FROM_TO_D(j, t, unit_area);
	BIND_FROM_TO_NORMAL(j, t, lift);
	BIND_FROM_TO_NORMAL(j, t, remark);
}