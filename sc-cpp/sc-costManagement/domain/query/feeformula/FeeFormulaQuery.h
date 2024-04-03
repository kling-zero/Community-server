/***************************************************************************** 
    *  @file     : FeeFormulaQuery.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 10:42
    *  @brief    : QueryœÓ
*****************************************************************************/  
#ifndef __FEEFORMULAQUERY_H__
#define __FEEFORMULAQUERY_H__

#include "../PageQuery.h"
#include "../../GlobalInclude.h"

class FeeFormulaQuery : public PageQuery
{
public:
	friend void from_json(const json& j, FeeFormulaQuery& t);
};
#endif //__FEEFORMULAQUERY_H__
