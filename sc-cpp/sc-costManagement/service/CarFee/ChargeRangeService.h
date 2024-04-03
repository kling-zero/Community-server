#ifndef _CHARGERANGESERVICE_H_
#define _CHARGERANGESERVICE_H_
#include "domain/vo/CarFee/ChargeRangeVO.h"

class ChargeRangeService
{
public:
	std::list<ChargeRangeVO> listAll();
};

#endif // !_CHARGERANGESERVICE_H_
#pragma once
