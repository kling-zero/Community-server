/***************************************************************************** 
    *  @file     : FeeCancelStateDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 17:23
    *  @brief    : 
*****************************************************************************/  
#ifndef __FEECANCELSTATEDAO_H__
#define __FEECANCELSTATEDAO_H__

#include "../../domain/do/feecancel/FeeCancelStateDO.h"
#include "BaseDAO.h"

class FeeCancelStateDAO : public BaseDAO {
public:
    // ��ѯ�����б���
    list<FeeCancelStateDO> listAll();
    // ����ID��ѯ״̬
    string queryStateNameById(uint64_t id);
};
#endif //__FEECANCELSTATEDAO_H__
