/***************************************************************************** 
    *  @file     : FeeFormulaMapper.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 9:41
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEEFORMULAMAPPER_H__
#define __FEEFORMULAMAPPER_H__

#include "Mapper.h"
#include "../../domain/do/feeformula/FeeFormulaDO.h"

class FeeFormulaMapper : public Mapper<FeeFormulaDO>
{
public:
	FeeFormulaDO mapper(ResultSet* resultSet) override
	{
		FeeFormulaDO data;
		data.setFormulaId(resultSet->getUInt64(1));
		data.setFormulaType(resultSet->getInt(2));
		data.setFormulaValue(resultSet->getString(3));
		data.setFormulaDesc(resultSet->getString(4));
		data.setPrice(resultSet->getDouble(5));
		return data;
	}
};

#endif //__FEEFORMULAMAPPER_H__
