#pragma once
#ifndef _PARKINGAREAMAPPER_H_
#define _PARKINGAREAMAPPER_H_
#include "Mapper.h"
#include "domain/do/CarFee/ParkingAreaDO.h"

class ParkingAreaMapper : public Mapper<ParkingAreaDO>
{
public:
	ParkingAreaDO mapper(ResultSet* resultSet) override
	{
		ParkingAreaDO data;
		data.setNum(resultSet->getString(4));
		return data;
	}
};

#endif // !_PARKINGAREAMAPPER_H_
