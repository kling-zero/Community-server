#ifndef _CARFEESERVICE
#define _CARFEESERVICE

#include "domain/vo/CarFee/CarFeeListVO.h"
#include "domain/vo/PageVO.h"
#include "domain/query/CarFee/CarFeeQuery.h"
#include "domain/vo/CarFee/CarStateVO.h"

class CarFeeService
{
public:
	PageVO<CarFeeListVO> listAll(CarFeeQuery query);
	//CarStateVO listState();
};

#endif // !_CARFEESERVICE
#pragma once
