#pragma once
#ifndef _STAFFFEECONTROLLER_H_
#define _STAFFFEECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/StaffFee/StaffFeeListVO.h"
#include "domain/query/StaffFee/StaffFeeQuery.h"
#include "domain/vo/PageVO.h"
#include "api/ApiHelper.h"

/*
* ��ͬ�շѽӿ�
*/
class StaffFeeController
{
public:
	//CREATE_API_FUN_QUERY3(queryStaffFeeList, executeQueryStaffFeeList);

	//  ��ѯ
	CREATE_API_FUN_QUERY(queryStaffFee, execQueryStaffFee, StaffFeeQuery);
private:
	//JsonVO<PageVO<StaffFeeListVO>> executeQueryStaffFeeList();

	JsonVO<PageVO<StaffFeeListVO>> execQueryStaffFee(StaffFeeQuery);
};
#endif // !_STAFFFEECONTROLLER_H_
