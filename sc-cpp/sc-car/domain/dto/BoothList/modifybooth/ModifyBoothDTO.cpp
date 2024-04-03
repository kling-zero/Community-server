#include "stdafx.h"
#include "ModifyBoothDTO.h"
void from_json(const json& j, ModifyBoothDTO& t)
{
	BIND_FROM_TO_NORMAL(j, t, blueCarIn);
	BIND_FROM_TO_NORMAL(j, t, boxName);
	BIND_FROM_TO_NORMAL(j, t, boxId);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, fee);
	/*BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_OBJ(j, t, parkingAreasDTO,std::list<ParkingAreasDTO>);*/
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, tempCarIn);
	BIND_FROM_TO_NORMAL(j, t, yelowCarIn);
}
