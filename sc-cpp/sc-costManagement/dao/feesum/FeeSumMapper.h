/***************************************************************************** 
    *  @file     : FeeSumMapper.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 14:03
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEESUMMAPPER_H__
#define __FEESUMMAPPER_H__

#include "Mapper.h"
#include "../../domain/do/feesum/FeeSumDO.h"

class FeeSumMapper : public Mapper<FeeSumDO>
{
public:
	FeeSumDO mapper(ResultSet* resultSet) override
	{
		FeeSumDO data;
		data.setCreateTime(resultSet->getString(1));
		data.setConfigId(resultSet->getUInt64(2));
		data.setFeeName(resultSet->getString(3));
		data.setReceivableAmounts(resultSet->getDouble(4));
		data.setReceivedAmounts(resultSet->getDouble(5));
		return data;
	}
};
#endif //__FEESUMMAPPER_H__
