#include "stdafx.h"
#include "BoothItemController.h"

JsonVO<PageVO<BoothListVO>> BoothItemController::execQueryBoothList(BoothItemQuery query)
{
	BoothService service;
	PageVO<BoothListVO> result = service.listAll(query);
    return JsonVO<PageVO<BoothListVO>>(result, RS_SUCCESS);
}

JsonVO<PageVO<BoothListVO>> BoothItemController::execQuery3BoothList()
{
	PageVO<BoothListVO> date;
	JsonVO<PageVO<BoothListVO>> res;
	res.success(date);
	return res;
}

JsonVO<PageVO<ShareBoothListVO>> BoothItemController::execQueryShareBoothList()
{
	PageVO<ShareBoothListVO> date;
	JsonVO<PageVO<ShareBoothListVO>> res;
	res.success(date);
	return res;
}

JsonVO<uint64_t> BoothItemController::execAddBooth(AddBoothDTO dto)
{
	JsonVO<uint64_t> result;
	BoothService service;
	//执行数据新增
	uint64_t id = service.saveBooth(dto);
	if (id > 0) {
		result.success(id);
	}
	else {
		result.fail(id);
	}
	return result;
}

JsonVO<std::string>BoothItemController::execModifyBooth(ModifyBoothDTO dto)
{
	BoothService service;
	JsonVO<std::string> result;
	if (service.updateBooth(dto)) {
		result.success(dto.getBoxId());
	}
	else {
		result.fail(dto.getBoxId());
	}
	return result;
}

JsonVO<std::string>BoothItemController::execDeleteBooth(DeleteBoothDTO dto)
{
	BoothService service;
	JsonVO<std::string> result;
	//执行数据删除
	if (service.removeBooth(dto.getBoxId())) {
		result.success(dto.getBoxId());
	}
	else {
		result.fail(dto.getBoxId());
	}
	//响应结果
	return result;
}

JsonVO<uint64_t> BoothItemController::execAddShareBooth(AddShareBoothDTO dto)
{
	JsonVO<uint64_t> res;
	res.success(0);
	return res;
}

JsonVO<long> BoothItemController::execDeleteShareBooth(DeleteShareBoothDTO dto)
{
	JsonVO<long> res;
	res.success(0);
	return res;
}
