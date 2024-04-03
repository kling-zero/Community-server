#include "stdafx.h"
#include "FeeItemController.h"

JsonVO<std::list<FeeTypeVO>> FeeItemController::executeQueryFeeType()
{
	std::list<FeeTypeVO> data;
	FeeTypeVO vo;
	vo.setID(1);
	vo.setName(u8"Ñº½ð");
	data.push_back(vo);
	JsonVO<std::list<FeeTypeVO>> res;
	res.success(data);
	return res;
}

JsonVO<PageVO<FeeListVO>> FeeItemController::executeQueryFeeList(FeeItemQuery query)
{
	PageVO<FeeListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, {FeeListVO()});
	JsonVO<PageVO<FeeListVO>> res;
	res.success(data);
	return res;
}
