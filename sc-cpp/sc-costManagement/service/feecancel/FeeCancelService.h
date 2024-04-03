/***************************************************************************** 
    *  @file     : FeeCancelService.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/22 20:01
    *  @brief    : ����ȡ��Service
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
    // ��ѯ����״̬
    list<FeeCancelStateVO> listState();
    // ��ѯ���е�ȡ��������
    PageVO<FeeCancelVO> listAll(FeeCancelQuery query);
    // ����ȡ������
    long updateCancel(FeeCancelDTO dto);
    // ���ȡ������
    long updateAudit(FeeCancelAuditDTO dto);
};

#endif //__FEECANCELSERVICE_H__
