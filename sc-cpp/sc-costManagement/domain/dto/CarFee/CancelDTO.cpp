#include "stdafx.h"
#include "CancelDTO.h"

void from_json(const json& j, CancelDTO& t) {
	BIND_FROM_TO_L(j, t, id);
}

