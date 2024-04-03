#pragma once
#ifndef _OWNERCARDAO_H_
#define _OWNERCARDAO_H_

#include "BaseDAO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/AddOwnerCarDO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/EditOwnerCarDO.h"

class OwnerCarDAO : public BaseDAO
{
public:
	uint64_t insert(AddOwnerCarDO iObj);
	int update(EditOwnerCarDO uObj);
	int deleteById(std::string Id);
};

#endif //_ADDOWNERCARDAO_H_
