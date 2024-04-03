/***************************************************************************** 
    *  @file     : FeeCancelMapper.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:20
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEECANCELMAPPER_H__
#define __FEECANCELMAPPER_H__

#include "Mapper.h"
#include "../../domain/do/feecancel/FeeCancelDO.h"

class FeeCancelMapper : public Mapper<FeeCancelDO> {
public:
	FeeCancelDO mapper(ResultSet* resultSet) override
	{
		FeeCancelDO data;
		data.setBatchId(resultSet->getUInt64(1));
		data.setCreateUserName(resultSet->getString(2));
		data.setCreateUserId(resultSet->getUInt64(3));
		data.setCreateTime(resultSet->getString(4));
		data.setReason(resultSet->getString(5));
		data.setStateName(resultSet->getString(6));
		data.setMsg(resultSet->getString(7));
		return data;
	}
};
#endif //__FEECANCELMAPPER_H__
