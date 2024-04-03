#include "stdafx.h"
#include "DiscountSettingController.h"

JsonVO<PageVO<DiscountListVO>> DiscountSettingController::executeQueryDiscountList(DiscountItemQuery query)
{
	PageVO<DiscountListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { DiscountListVO() });
	JsonVO<PageVO<DiscountListVO>> res;
	res.success(data);
	return res;
}
JsonVO<std::list<DiscountTypeVO>> DiscountSettingController::executeQueryDiscountType()
{
	std::list<DiscountTypeVO> data({ DiscountTypeVO() });
	JsonVO<std::list<DiscountTypeVO>> res;
	res.success(data);
	return res;
}