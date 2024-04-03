#pragma once
#ifndef _OWNER_ACCOUNT_ITEM_MAPPER_
#define _OWNER_ACCOUNT_ITEM_MAPPER_


#include "Mapper.h"
#include "../../domain/do/OwnerAccount/OwnerAccountItemDO.h"

class OwnerAccountItemMapper: public Mapper<OwnerAccountItemDO>
{
public:
	OwnerAccountItemDO mapper(ResultSet* resultSet) override
	{
		OwnerAccountItemDO data;
		data.setAcctId(resultSet->getString(1));
		data.setAcctName(resultSet->getString(2));
		data.setAcctType(resultSet->getString(3));
		data.setAmount(resultSet->getInt(4));
		data.setObjType(resultSet->getString(5));
		data.setObjId(resultSet->getString(6));
		data.setBId(resultSet->getString(7));
		data.setCreateTime(resultSet->getString(8));
		data.setStatusCd(resultSet->getString(9));
		data.setPartId(resultSet->getString(10));
		return data;
	}
};

#endif //__OWNERACCOUNTITEMMAPPER_H__
