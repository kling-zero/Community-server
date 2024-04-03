#pragma once
#ifndef _OWNER_ACCOUNT_DETAIL_MAPPER_
#define _OWNER_ACCOUNT_DETAIL_MAPPER_

#include "Mapper.h"
#include "../../domain/do/OwnerAccount/OwnerAccountDetailDO.h"

class OwnerAccountDetailMapper: public Mapper<OwnerAccountDetailDO>
{
public:
	OwnerAccountDetailDO mapper(ResultSet* resultSet) override
	{
		OwnerAccountDetailDO data;
		data.setDetailId(resultSet->getString(1));
		data.setAcctId(resultSet->getString(2));
		data.setDetailType(resultSet->getString(3));
		data.setAmount(resultSet->getInt(5));
		data.setObjType(resultSet->getString(6));
		data.setObjId(resultSet->getString(7));
		data.setOrderId(resultSet->getString(8));
		data.setBId(resultSet->getString(9));
		data.setRemark(resultSet->getString(10));
		data.setTransactionTime(resultSet->getString(11));
		data.setStatusCd(resultSet->getString(12));
		
		return data;
	}
};

#endif //__OWNERACCOUNTDETAILMAPPER_H__