/***************************************************************************** 
    *  @file     : FeeFormulaDAO.h
    *  @author   : Caiyucheng 
    *  @date     : 2022/10/20 9:29
    *  @brief    : ��̯��ʽDAO   
*****************************************************************************/  
#ifndef __FEEFORMULADAO_H__
#define __FEEFORMULADAO_H__

#include "../../domain/do/feeformula/FeeFormulaDO.h"
#include "BaseDAO.h"

class FeeFormulaDAO : public BaseDAO{
public:
	// ��ѯ����
	long count(FeeFormulaDO obj);
	// ��ҳ��ѯ
	list<FeeFormulaDO> selectWithPage(FeeFormulaDO obj, long pageIndex, long pageSize);
	// �������
	uint64_t insert(FeeFormulaDO iObj);
	// ��������
	int update(FeeFormulaDO uObj);
	// ɾ������
	int remove(uint64_t id);
};
#endif //__FEEFORMULADAO_H__