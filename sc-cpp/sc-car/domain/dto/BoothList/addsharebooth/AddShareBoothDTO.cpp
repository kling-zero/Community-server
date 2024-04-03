#include "stdafx.h"
#include "AddShareBoothDTO.h"
void from_json(const json& j, AddShareBoothDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, boxId);
	BIND_FROM_TO_NORMAL(j, t, defaultArea);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_OBJ(j, t, parkingAreasDTO, std::list<ParkingAreasDTO>);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, boxName);
	BIND_FROM_TO_NORMAL(j, t, communityId);
}