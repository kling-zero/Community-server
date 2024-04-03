#ifndef _STAFFFEEDAO_H_
#define _STAFFFEEDAO_H_
#include "BaseDAO.h"
#include "../../domain/do/StaffFee/StaffFeeDO.h"

class StaffFeeDAO :public BaseDAO
{

public:
	uint64_t count(StaffFeeDO iObj);
	list<StaffFeeDO> selectWithPage(StaffFeeDO obj, long pageIndex, long pageSize);
};

#endif // !_STAFFFEEDAO_H_
#pragma once
