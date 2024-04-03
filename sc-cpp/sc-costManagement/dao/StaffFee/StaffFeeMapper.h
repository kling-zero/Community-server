#pragma once
#ifndef _STAFFFEEMAPPER_H_
#define _STAFFFEEMAPPER_H_

#include "Mapper.h"
#include "domain/do/StaffFee/StaffFeeDO.h"

class StaffFeeMapper:public Mapper<StaffFeeDO>
{
public:
	StaffFeeDO mapper(ResultSet* resultSet) override
	{
		StaffFeeDO data;
		data.setUserId(resultSet->getString(1));
		data.setUserName(resultSet->getString(2));
		data.setReceivableAmount(resultSet->getDouble(3));
		data.setReceivedAmount(resultSet->getDouble(4));
		return data;
	}
};

#endif // !_STAFFFEEMAPPER_H_
