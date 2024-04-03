#include "stdafx.h"
#include "SampleDTO.h"
void from_json(const json& j, SampleDTO& t) {
	BIND_FROM_TO_L(j, t, id);
	BIND_FROM_TO_NORMAL(j, t, name);
	BIND_FROM_TO_I(j, t, age);
	BIND_FROM_TO_NORMAL(j, t, sex);
}