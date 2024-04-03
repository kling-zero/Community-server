#pragma once
#ifndef _CARINFOSERVICE_H_
#define _CARINFOSERVICE_H_

#include "../../../domain/vo/OwnerVehicle/CarInfoVO.h"
#include "../../../domain/vo/PageVO.h"
#include "../../../domain/query/OwnerVehicle/CarInfoQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/31 18:28:06
*/
class CarInfoService
{

public:
	PageVO<CarInfoVO> listAll(CarInfoQuery query);
};

#endif //_CARINFOSERVICE_H_