#pragma once
#ifndef _STAFFFEESERVICE_H_
#define _STAFFFEESERVICE_H_

#include "domain/vo/StaffFee/StaffFeeListVO.h"
#include "domain/vo/PageVO.h"
#include "domain/query/StaffFee/StaffFeeQuery.h"

class StaffFeeService
{

public:
	PageVO<StaffFeeListVO> listAll(StaffFeeQuery query);
};

#endif // !_STAFFFEESERVICE_H_
