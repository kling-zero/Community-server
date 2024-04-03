#pragma once
#ifndef _CARINFODAO_H_
#define _CARINFODAO_H_

#include "BaseDAO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/CarInfoDO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/CarInfoQueryDO.h"

class CarInfoDAO : public BaseDAO
{
public:
	uint64_t count(CarInfoQueryDO iObj);
	list<CarInfoDO> selectWithPage(CarInfoQueryDO obj, long pageIndex, long pageSize);
};
#endif //_CARINFODAO_H_