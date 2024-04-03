/***************************************************************************** 
    *  @file     : FeeSumDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 13:56
    *  @brief    : 费用汇总DAO
*****************************************************************************/  
#ifndef __FEESUMDAO_H__
#define __FEESUMDAO_H__

#include "../../domain/do/feesum/FeeSumDO.h"
#include "BaseDAO.h"

class FeeSumDAO : public BaseDAO {
public:
	// 查询总数
	long count(FeeSumDO obj);
	// 分页查询
	list<FeeSumDO> selectWithPage(FeeSumDO obj, long pageIndex, long pageSize);
};

#endif //__FEESUMDAO_H__
