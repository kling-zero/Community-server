/***************************************************************************** 
    *  @file     : FeeSumService.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/21 14:18
    *  @brief    : ���û���service
*****************************************************************************/  
#ifndef __FEESUMSERVICE_H__
#define __FEESUMSERVICE_H__

#include <list>
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/feesum/FeeSumVO.h"
#include "../../domain/query/feesum/FeeSumQuery.h"
#include "../../dao/feesum/FeeSumDAO.h"


class FeeSumService {
public:
    // ��ѯ��������
    PageVO<FeeSumVO> listAll(FeeSumQuery query);
};

#endif //__FEESUMSERVICE_H__
