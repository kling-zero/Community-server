#include "stdafx.h"
#include "ParkingAreasDTO.h"

void from_json(const json& j, ParkingAreasDTO& t) 
{
	BIND_FROM_TO_OBJ(j, t, attrs, std::list<AttrsDTO>);
	BIND_FROM_TO_NORMAL(j, t, createTime);
	BIND_FROM_TO_NORMAL(j, t, num);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, typeCd);
}