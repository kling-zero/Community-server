/***************************************************************************** 
    *  @file     : FeeCancelService.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/22 20:01
    *  @brief    : 费用取消Service
*****************************************************************************/  
#ifndef __FEECANCELSERVICE_H__
#define __FEECANCELSERVICE_H__

#include <list>
#include "../../domain/vo/feecancel/FeeCancelVO.h"
#include "../../domain/vo/feecancel/FeeCancelStateVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/dto/feecancel/FeeCancelDTO.h"
#include "../../domain/dto/feecancel/FeeCancelAuditDTO.h"
#include "../../domain/query/feecancel/FeeCancelQuery.h"

class FeeCancelService {
public:
    // 查询所有状态
    list<FeeCancelStateVO> listState();
    // 查询所有的取消费用项
    PageVO<FeeCancelVO> listAll(FeeCancelQuery query);
    // 申请取消费用
    long updateCancel(FeeCancelDTO dto);
    // 审核取消费用
    long updateAudit(FeeCancelAuditDTO dto);
};

#endif //__FEECANCELSERVICE_H__
