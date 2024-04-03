#pragma once
#ifndef _OWNERCARSERVICE_H_
#define _OWNERCARSERVICE_H_

#include "../../../domain/vo/UniversalVO.h"
#include "../../../domain/vo/PageVO.h"
#include "../../../domain/dto/OwnerVehicle/OwnerCar/AddOwnerCarDTO.h"
#include "../../../domain/dto/OwnerVehicle/OwnerCar/EditOwnerCarDTO.h"

class OwnerCarService
{
public:
	uint64_t saveData(AddOwnerCarDTO dto);
	bool updateData(EditOwnerCarDTO dto);
	bool removeData(std::string id);

};

#endif //_OWNERCARSERVICE_H_