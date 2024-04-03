#ifndef _CARSTATEMAPPER_H_
#define _CARSTATEMAPPER_H_
#include "Mapper.h"
#include "domain/do/CarFee/CarStateDO.h"

class CarStateMapper:public Mapper<CarStateDO>
{
public:
	CarStateDO mapper(ResultSet* resultSet) override
	{
		CarStateDO data;
		data.setId(resultSet->getInt64(1));
		data.setCarState(resultSet->getString(2));
		return data;
	}
};

#endif // !_CARSTATEMAPPER_H_

#pragma once
