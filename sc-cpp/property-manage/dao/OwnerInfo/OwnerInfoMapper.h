#pragma once
#ifndef _OWNER_INFO_MAPPER_
#define _OWNER_INFO_MAPPER_


#include "Mapper.h"
#include "../../domain/do/OwnerInfo/OwnerInfoDO.h"

class OwnerInfoMapper : public Mapper<OwnerInfoDO>
{
public:
	OwnerInfoDO mapper(ResultSet* resultSet) override
	{
		OwnerInfoDO data;
		data.setPeopleId(resultSet->getString(1));
		data.setOwnerName(resultSet->getString(9));
		data.setOwnerGender(resultSet->getInt(11));
		data.setOwnerAge(resultSet->getInt(3));
		data.setIdCard(resultSet->getString(5));
		data.setPhoneNum(resultSet->getString(6));
		data.setCreatStaff(resultSet->getString(12));
		return data;
	}
};

#endif //__OWNERINFOMAPPER_H__