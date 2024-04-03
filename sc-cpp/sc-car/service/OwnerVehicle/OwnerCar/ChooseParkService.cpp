#include "stdafx.h"
#include "ChooseParkService.h"
#include "../../../dao/OwnerVehicle/OwnerCar/ChooseParkDAO.h"

PageVO<ChooseParkVO> ChooseParkService::listAll(ChooseParkQuery query)
{
	//构建返回对象
	PageVO<ChooseParkVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
	ChooseParkQueryDO obj;
	obj.setNum(query.getNum());
	obj.setAreaNum(query.getAreaNum());
	obj.setCarNum(query.getCarNum());
	obj.setState(query.getState());

	ChooseParkDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<ChooseParkDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());

	list<ChooseParkVO> vr;
	for (ChooseParkDO sub : result)
	{
		ChooseParkVO vo;
		vo.setArea(sub.getArea());
		vo.setAreaNum(sub.getAreaNum());
		vo.setCommunityId(sub.getCommunityId());
		vo.setCreateTime(sub.getCreateTime());
		vo.setNum(sub.getNum());
		vo.setPaId(sub.getPaId());
		vo.setParkingType(sub.getParkingType());
		vo.setParkingTypeName(sub.getParkingTypeName());
		vo.setPsId(sub.getPsId());
		vo.setRemark(sub.getRemark());
		vo.setState(sub.getState());
		vo.setStateName(sub.getStateName());
		vo.setTypeCd(sub.getTypeCd());
		vr.push_back(vo);

	}
	pages.setRows(vr);
	return pages;
}