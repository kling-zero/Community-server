#pragma once
#ifndef _CHOOSEOWNERDAO_H_
#define _CHOOSEOWNERDAO_H_

#include "BaseDAO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseOwnerDO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseOwnerQueryDO.h"

class ChooseOwnerDAO : public BaseDAO
{
public:
	uint64_t count(ChooseOwnerQueryDO iObj);
	list<ChooseOwnerDO> selectWithPage(ChooseOwnerQueryDO obj, long pageIndex, long pageSize);
};

#endif //_CHOOSEOWNERDAO_H_