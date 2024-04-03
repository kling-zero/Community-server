#include "stdafx.h"
#include "PreferentialTypeController.h"

JsonVO<PageVO<PreferentialTypeListVO>> PreferentialTypeController::executeQueryPreferentialTypeList(PreferentialTypeQuery query)
{
	PageVO<PreferentialTypeListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { PreferentialTypeListVO() });
	JsonVO<PageVO<PreferentialTypeListVO>> res;
	res.success(data);
	return res;
}