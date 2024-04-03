#pragma once
#ifndef _OWNERCARMAPPER_H_
#define _OWNERCARMAPPER_H_
#include "Mapper.h"
#include "domain/do/CarFee/OwnerCarDO.h"

class OwnerCarMapper : public Mapper<OwnerCarDO>
{
public:
	OwnerCarDO mapper(ResultSet* resultSet) override
	{
		OwnerCarDO data;
		data.setCar_num(resultSet->getString(1));
		data.setPs_id(resultSet->getString(2));
		data.setState(resultSet->getString(3));
		return data;
	}
};

#endif // !_OWNERCARMAPPER_H_
