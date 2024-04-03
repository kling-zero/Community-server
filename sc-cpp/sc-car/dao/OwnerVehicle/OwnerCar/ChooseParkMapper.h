#pragma once
#ifndef _CHOOSEPARKMAPPER_H_
#define _CHOOSEPARKMAPPER_H_
#include "Mapper.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseParkDO.h"

class ChooseParkMapper : public Mapper<ChooseParkDO>
{
public:
	ChooseParkDO mapper(ResultSet* resultSet) override
	{
		ChooseParkDO data;
		data.setArea(resultSet->getString(7));
		//data.setAreaNum(resultSet->getString(2));
		data.setCommunityId(resultSet->getString(3));
		data.setCreateTime(resultSet->getString(9));
		data.setNum(resultSet->getString(4));
		data.setPaId(resultSet->getString(5));
		data.setParkingType(resultSet->getString(11));
		//data.setParkingTypeName(resultSet->getString(2));
		data.setPsId(resultSet->getString(1));
		data.setRemark(resultSet->getString(8));
		data.setState(resultSet->getString(6));
		//data.setStateName(resultSet->getString(2));
		//data.setTypeCd(resultSet->getString(2));
		return data;
	}
};

#endif // !_CARINFO_MAPPER_