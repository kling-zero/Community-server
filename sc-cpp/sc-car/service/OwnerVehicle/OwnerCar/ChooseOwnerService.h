#pragma once
#ifndef _CHOOSEOWNERSERVICE_H_
#define _CHOOSEOWNERSERVICE_H_

#include "../../../domain/vo/OwnerVehicle/ChooseOwnerVO.h"
#include "../../../domain/vo/PageVO.h"
#include "../../../domain/query/OwnerVehicle/ChooseOwnerQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/31 15:59:51
*/
class ChooseOwnerService
{

public:
	PageVO<ChooseOwnerVO> listAll(ChooseOwnerQuery query);
};

#endif //_CHOOSEOWNERSERVICE_H_