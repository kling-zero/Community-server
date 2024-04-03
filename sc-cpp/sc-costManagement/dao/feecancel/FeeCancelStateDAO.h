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
    // 查询所有列表项
    list<FeeCancelStateDO> listAll();
    // 根据ID查询状态
    string queryStateNameById(uint64_t id);
};
#endif //__FEECANCELSTATEDAO_H__
