#pragma once
#ifndef _CARINFO_MAPPER_
#define _CARINFO_MAPPER_

#include "Mapper.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseOwnerDO.h"

class ChooseOwnerMapper : public Mapper<ChooseOwnerDO>
{
public:
	ChooseOwnerDO mapper(ResultSet* resultSet) override
	{
		ChooseOwnerDO data;
		data.setAge(resultSet->getInt(6));
		data.setCreateTime(resultSet->getString(10));
		data.setIdCard(resultSet->getString(14));
		data.setLink(resultSet->getString(7));
		data.setMemberId(resultSet->getString(1));
		data.setName(resultSet->getString(4));
		//data.setOwnerAttrDtos(resultSet->getString(2));
		data.setOwnerId(resultSet->getString(2));
		data.setOwnerTypeCd(resultSet->getString(12));
		//data.setOwnerTypeName(resultSet->getString(6));
		data.setRemark(resultSet->getString(9));
		data.setSex(resultSet->getInt(5));
		data.setUserName(resultSet->getString(18));
		return data;
	}
};

#endif // !_CARINFO_MAPPER_