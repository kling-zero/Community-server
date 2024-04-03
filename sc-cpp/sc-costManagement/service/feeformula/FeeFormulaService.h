/***************************************************************************** 
    *  @file     : FeeFormulaService.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 10:07
    *  @brief    : ¹«Ì¯¹«Ê½service
*****************************************************************************/  
#ifndef __FEEFORMULASERVICE_H__
#define __FEEFORMULASERVICE_H__

#include <list>
#include "../../domain/vo/feeformula/FeeFormulaVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/dto/feeformula/FeeFormulaDTO.h"
#include "../../domain/query/feeformula/FeeFormulaQuery.h"

class FeeFormulaService {
public:
	PageVO<FeeFormulaVO> listAll(FeeFormulaQuery query);
	uint64_t saveData(FeeFormulaDTO dto);
	bool updateData(FeeFormulaDTO dto);
	bool removeData(uint64_t id);
};

#endif //__FEEFORMULASERVICE_H__
