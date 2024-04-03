/***************************************************************************** 
    *  @file     : FeeSumDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 13:56
    *  @brief    : ���û���DAO
*****************************************************************************/  
#ifndef __FEESUMDAO_H__
#define __FEESUMDAO_H__

#include "../../domain/do/feesum/FeeSumDO.h"
#include "BaseDAO.h"

class FeeSumDAO : public BaseDAO {
public:
	// ��ѯ����
	long count(FeeSumDO obj);
	// ��ҳ��ѯ
	list<FeeSumDO> selectWithPage(FeeSumDO obj, long pageIndex, long pageSize);
};

#endif //__FEESUMDAO_H__
