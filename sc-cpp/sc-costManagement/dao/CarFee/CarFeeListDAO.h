#pragma once
#ifndef _CARFEELISTDAO_H
#define _CARFEELISTDAO_H
#include "BaseDAO.h"
#include "domain/do/CarFee/BuildingOwnerDO.h"
#include "domain/do/CarFee/OwnerCarDO.h"
#include "domain/do/CarFee/ParkingAreaDO.h"

class CarFeeListDAO:public BaseDAO
{
public:
	uint64_t count(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres);
	std::list<OwnerCarDO> selectOwnerCarWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize);
	std::list<BuildingOwnerDO> selectBuildingOwnerWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize);
	std::list<ParkingAreaDO> selectParkingAreaWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize);
};

#endif // !_CARFEELISTDAO_H
