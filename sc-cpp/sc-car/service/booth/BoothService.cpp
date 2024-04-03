#include "stdafx.h"
#include "BoothService.h"

PageVO<BoothListVO> BoothService::listAll(BoothItemQuery query)
{

	PageVO<BoothListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	BoothListDO obj;
	obj.setBox_id(query.getBoxId());
	obj.setBox_name(query.getBoxName());
	obj.setTemp_car_in(query.getTempCarIn());

	BoothDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	pages.setTotal(count);
	pages.calcPages();
	list<BoothListDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<BoothListVO> vr;
	for (BoothListDO sub : result)
	{
		BoothListVO vo;
		vo.setBlueCarIn(sub.getBlue_car_in());
		vo.setBoxId(sub.getBox_id());
		vo.setBoxName(sub.getBox_name());
		vo.setCommunityId(sub.getCommunity_id());
		vo.setFee(sub.getFee());
		vo.setRemark(sub.getRemark());
		vo.setTempCarIn(sub.getTemp_car_in());
		vo.setYelowCarIn(sub.getYelow_car_in());
		vo.setStatusCd(sub.getStatus_cd());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}

uint64_t BoothService::saveBooth(AddBoothDTO dto)
{
	BoothListDO date;
	date.setBox_name(dto.getBoxName());
	date.setBlue_car_in(dto.getBlueCarIn());
	date.setRemark(dto.getRemark());
	date.setTemp_car_in(dto.getTempCarIn());
	date.setYelow_car_in(dto.getYelowCarIn());
	date.setFee(dto.getFee());
	BoothDAO dao;
	return dao.insert(date);
}

bool BoothService::updateBooth(ModifyBoothDTO dto)
{
	BoothListDO date;
	date.setBox_id(dto.getBoxId());
	date.setBox_name(dto.getBoxName());
	date.setBlue_car_in(dto.getBlueCarIn());
	date.setRemark(dto.getRemark());
	date.setTemp_car_in(dto.getTempCarIn());
	date.setYelow_car_in(dto.getYelowCarIn());
	date.setFee(dto.getFee());
	BoothDAO dao;
	return dao.update(date) == 1;
}

bool BoothService::removeBooth(std::string box_id)
{
	BoothDAO dao;
	return dao.deleteById(box_id) == 1;
}

