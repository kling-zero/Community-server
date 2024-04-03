/***************************************************************************** 
    *  @file     : FeeCancelDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:30
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEECANCELDAO_H__
#define __FEECANCELDAO_H__

#include "../../domain/do/feecancel/FeeCancelDO.h"
#include "BaseDAO.h"

class FeeCancelDAO : public BaseDAO {
public:
    // ��ѯ����
    long count(FeeCancelDO obj);
    // ��ҳ��ѯ
    list<FeeCancelDO> selectWithPage(FeeCancelDO obj, long pageIndex, long pageSize);
    // ����ȡ������
    int update(FeeCancelDO obj);
};

#endif //__FEECANCELDAO_H__
