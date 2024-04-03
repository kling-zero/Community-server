/***************************************************************************** 
    *  @file     : FeeSumQuery.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 15:09
    *  @brief    : ·ÑÓÃ»ã×ÜQuery
*****************************************************************************/  
#ifndef __FEESUMQUERY_H__
#define __FEESUMQUERY_H__

#include "../PageQuery.h"
#include "../../GlobalInclude.h"

class FeeSumQuery : public PageQuery{
public:
    friend void from_json(const json& j, FeeSumQuery& t);
};

#endif //__FEESUMQUERY_H__
