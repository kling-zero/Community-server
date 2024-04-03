#include "stdafx.h"
#include "ChooseOwnerService.h"
#include "../../../dao/OwnerVehicle/OwnerCar/ChooseOwnerDAO.h"

PageVO<ChooseOwnerVO> ChooseOwnerService::listAll(ChooseOwnerQuery query)
{
	//构建返回对象
	PageVO<ChooseOwnerVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
	ChooseOwnerQueryDO obj;

	obj.setCommunityId(query.getCommunityId());
	obj.setName(query.getName());
	obj.setOwnerTypeCd(query.getOwnerTypeCd());
	//obj.setRoomName(query.getRoomName());

	ChooseOwnerDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<ChooseOwnerDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());

	list<ChooseOwnerVO> vr;
	for (ChooseOwnerDO sub : result)
	{
		ChooseOwnerVO vo;
		vo.setAge(sub.getAge());
		vo.setCreateTime(sub.getCreateTime());
		vo.setIdCard(sub.getIdCard());
		vo.setLink(sub.getLink());
		vo.setMemberId(sub.getMemberId());
		vo.setName(sub.getName());
		vo.setOwnerAttrDtos(sub.getOwnerAttrDtos());
		vo.setOwnerId(sub.getOwnerId());
		vo.setOwnerTypeCd(sub.getOwnerTypeCd());
		if (sub.getOwnerTypeCd() == "1001") {
			vo.setOwnerTypeName(u8"业主");
		}
		vo.setRemark(sub.getRemark());
		vo.setSex(sub.getSex());
		vo.setUserName(sub.getUserName());
		vr.push_back(vo);

	}
	pages.setRows(vr);
	return pages;
}