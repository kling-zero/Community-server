#include "stdafx.h"
#include "AddDepartDTO.h"
void from_json(const json& j, AddDepartDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, departName);
	BIND_FROM_TO_NORMAL(j, t, phone);
	BIND_FROM_TO_NORMAL(j, t, mail);
}

