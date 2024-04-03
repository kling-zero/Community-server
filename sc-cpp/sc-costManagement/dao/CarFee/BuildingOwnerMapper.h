#pragma once
#ifndef _BUILDINGOWNERMAPPER_H_
#define _BUILDINGOWNERMAPPER_H_
#include "Mapper.h"
#include "domain/do/CarFee/BuildingOwnerDO.h"

class BuildingOwnerMapper : public Mapper<BuildingOwnerDO>
{
public:
	BuildingOwnerDO mapper(ResultSet* resultSet) override
	{
		BuildingOwnerDO data;
		data.setName(resultSet->getString(5));
		data.setLink(resultSet->getString(6));
		return data;
	}
};

#endif // !_BUILDINGOWNERMAPPER_H_
