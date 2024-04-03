#include "stdafx.h"
#include "ModifyCarFeeDTO.h"

void from_json(const json& j, ModifyCarFeeDTO& t) {
	BIND_FROM_TO_L(j, t, id);
}