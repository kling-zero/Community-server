#ifndef _CHARGERANGEDAO_H_
#define _CHARGERANGEDAO_H_
#include "domain/do/CarFee/ChargeRangeDO.h"
#include "BaseDAO.h"


class ChargeRangeDAO :public BaseDAO
{
public:
	std::list<ChargeRangeDO> selectRange(ChargeRangeDO obj);
};

#endif // !_CHARGERANGEDAO_H_
#pragma once
