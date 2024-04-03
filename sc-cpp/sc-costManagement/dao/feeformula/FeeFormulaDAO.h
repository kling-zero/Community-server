/***************************************************************************** 
    *  @file     : FeeFormulaDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 9:29
    *  @brief    : 公摊公式DAO   
*****************************************************************************/  
#ifndef __FEEFORMULADAO_H__
#define __FEEFORMULADAO_H__

#include "../../domain/do/feeformula/FeeFormulaDO.h"
#include "BaseDAO.h"

class FeeFormulaDAO : public BaseDAO{
public:
	// 查询总数
	long count(FeeFormulaDO obj);
	// 分页查询
	list<FeeFormulaDO> selectWithPage(FeeFormulaDO obj, long pageIndex, long pageSize);
	// 添加数据
	uint64_t insert(FeeFormulaDO iObj);
	// 更改数据
	int update(FeeFormulaDO uObj);
	// 删除数据
	int remove(uint64_t id);
};
#endif //__FEEFORMULADAO_H__