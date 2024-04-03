#include "stdafx.h"
#include "StaffFeeController.h"
#include "service/StaffFee/StaffFeeService.h"


//JsonVO <PageVO<StaffFeeListVO>> StaffFeeController::executeQueryStaffFeeList()
//{
//	PageVO<StaffFeeListVO> data(1, 10, 100, 10, { StaffFeeListVO() });
//	JsonVO<PageVO<StaffFeeListVO>> res;
//	res.success(data);
//	return res;
//}


JsonVO<PageVO<StaffFeeListVO>> StaffFeeController::execQueryStaffFee(StaffFeeQuery query)
{
	//定义一个Service
	StaffFeeService service;
	//查询数据
	PageVO<StaffFeeListVO> data = service.listAll(query);
	//响应结果
	JsonVO<PageVO<StaffFeeListVO>> res;
	res.success(data);
	return res;
}