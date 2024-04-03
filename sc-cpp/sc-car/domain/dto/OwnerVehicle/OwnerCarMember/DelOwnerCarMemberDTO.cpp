#include "stdafx.h"
#include "DelOwnerCarMemberDTO.h"


void from_json(const json& j, DelOwnerCarMemberDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, carNumLike);
	BIND_FROM_TO_NORMAL(j, t, num);
	BIND_FROM_TO_NORMAL(j, t, valid);
	BIND_FROM_TO_NORMAL(j, t, carTypeCd);
}