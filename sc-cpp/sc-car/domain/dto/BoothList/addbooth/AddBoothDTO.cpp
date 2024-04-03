#include "stdafx.h"
#include "AddBoothDTO.h"
void from_json(const json& j, AddBoothDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, blueCarIn);
	BIND_FROM_TO_NORMAL(j, t, boxName);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, fee);
	/*BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_OBJ(j, t, parkingAreasDTO, std::list<ParkingAreasDTO>);*/
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, tempCarIn);
	BIND_FROM_TO_NORMAL(j, t, yelowCarIn);
}
