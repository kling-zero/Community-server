#ifndef _CHARGERANGEMAPPER_H
#define _CHARGERANGEMAPPER_H
#include "Mapper.h"
#include "domain/do/CarFee/ChargeRangeDO.h"

class ChargeRangeMapper :public Mapper<ChargeRangeDO>
{
public:
	ChargeRangeDO mapper(ResultSet* resultSet) override
	{
		ChargeRangeDO data;
		data.setId(resultSet->getInt64(1));
		data.setDescription(resultSet->getString(2));
		return data;
	}
};

#endif // !_CHARGERANGEMAPPER_H

#pragma once
