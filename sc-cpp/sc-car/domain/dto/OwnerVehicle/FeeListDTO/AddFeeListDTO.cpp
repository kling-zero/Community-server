#include "stdafx.h"
#include "AddFeeListDTO.h"

void from_json(const json& j, AddFeeListDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, carId);
	BIND_FROM_TO_OBJ(j, t, carState, list<std::string>);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, configId);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_OBJ(j, t, feeConfigs, std::list<FeeConfigsDTO>);
	BIND_FROM_TO_NORMAL(j, t, feeFlag);
	BIND_FROM_TO_NORMAL(j, t, feeTypeCd);
	BIND_FROM_TO_OBJ(j, t, feeTypeCds, std::list<FeeTypeCdsDTO>);
	BIND_FROM_TO_NORMAL(j, t, isMore);
	BIND_FROM_TO_NORMAL(j, t, locationObjId);
	BIND_FROM_TO_NORMAL(j, t, locationTypeCd);
	BIND_FROM_TO_NORMAL(j, t, locationTypeCdName);
	BIND_FROM_TO_NORMAL(j, t, paId);
	BIND_FROM_TO_OBJ(j, t, parkingAreas, std::list<ParkingAreasDTO>);
	BIND_FROM_TO_NORMAL(j, t, startTime);
}