#include "stdafx.h"
#include "DelOwnerCarDTO.h"

void from_json(const json& j, DelOwnerCarDTO& t) {
	BIND_FROM_TO_NORMAL(j, t, areaNum);
	BIND_FROM_TO_NORMAL(j, t, bId);
	BIND_FROM_TO_NORMAL(j, t, carBrand);
	BIND_FROM_TO_NORMAL(j, t, carColor);
	BIND_FROM_TO_NORMAL(j, t, carId);
	BIND_FROM_TO_NORMAL(j, t, carNum);
	BIND_FROM_TO_NORMAL(j, t, carType);
	BIND_FROM_TO_NORMAL(j, t, carTypeCd);
	BIND_FROM_TO_NORMAL(j, t, carTypeName);
	BIND_FROM_TO_NORMAL(j, t, communityId);
	BIND_FROM_TO_NORMAL(j, t, createTime);
	BIND_FROM_TO_NORMAL(j, t, endTime);
	BIND_FROM_TO_NORMAL(j, t, idCard);
	BIND_FROM_TO_NORMAL(j, t, link);
	//BIND_FROM_TO_OBJ(j, t, listValues,std::list<std::string>);
	BIND_FROM_TO_NORMAL(j, t, memberId);
	BIND_FROM_TO_NORMAL(j, t, num);
	//BIND_FROM_TO_OBJ(j, t, ownerCarAttrDto, std::list<OwnerCarAttrDTO>);
	BIND_FROM_TO_NORMAL(j, t, ownerId);
	BIND_FROM_TO_NORMAL(j, t, ownerName);
	BIND_FROM_TO_NORMAL(j, t, parkingType);
	BIND_FROM_TO_NORMAL(j, t, psId);
	BIND_FROM_TO_NORMAL(j, t, remark);
	BIND_FROM_TO_NORMAL(j, t, roomName);
	BIND_FROM_TO_NORMAL(j, t, startTime);
	BIND_FROM_TO_NORMAL(j, t, state);
	BIND_FROM_TO_NORMAL(j, t, stateName);
	BIND_FROM_TO_NORMAL(j, t, statusCd);
	BIND_FROM_TO_NORMAL(j, t, userId);
}