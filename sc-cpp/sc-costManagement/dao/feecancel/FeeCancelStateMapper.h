/***************************************************************************** 
    *  @file     : FeeCancelStateMapper.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:16
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEECANCELSTATEMAPPER_H__
#define __FEECANCELSTATEMAPPER_H__

#include "Mapper.h"
#include "../../domain/do/feecancel/FeeCancelStateDO.h"

class FeeCancelStateMapper : public Mapper<FeeCancelStateDO> {
public:
	FeeCancelStateDO mapper(ResultSet* resultSet) override
	{
		FeeCancelStateDO data;
		data.setStateId(resultSet->getUInt64(1));
		data.setStateName(resultSet->getString(2));
		return data;
	}
};

#endif //__FEECANCELSTATEMAPPER_H__
