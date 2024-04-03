#pragma once
#ifndef _SELECT_OWNER_MAPPER_
#define _SELECT_OWNER_MAPPER_

#include "Mapper.h"
#include "../../domain/do/OwnerAccount/SelectOwnerDO.h"

class SelectOwnerMapper: public Mapper<SelectOwnerDO>
{
public:
	SelectOwnerDO mapper(ResultSet* resultSet) override
	{
		SelectOwnerDO data;
		data.setMemberId(resultSet->getString(1));
		data.setOwnerId(resultSet->getString(2));
		data.setName(resultSet->getString(4));
		data.setSex(resultSet->getString(5));
		data.setAge(resultSet->getInt(6));
		data.setLink(resultSet->getString(7));
		data.setUserName(resultSet->getString(8));
		data.setRemark(resultSet->getString(9));
		data.setCreateTime(resultSet->getString(10));
		data.setOwnerTypeCd(resultSet->getString(12));
		data.setIdCard(resultSet->getString(14));
		return data;
	}
};

#endif //__SELECTOWNERMAPPER_H__
