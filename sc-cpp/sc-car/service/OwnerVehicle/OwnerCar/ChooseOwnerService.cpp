#include "stdafx.h"
#include "ChooseOwnerService.h"
#include "../../../dao/OwnerVehicle/OwnerCar/ChooseOwnerDAO.h"

PageVO<ChooseOwnerVO> ChooseOwnerService::listAll(ChooseOwnerQuery query)
{
	//�������ض���
	PageVO<ChooseOwnerVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����������
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

	//��ҳ��ѯ����
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
			vo.setOwnerTypeName(u8"ҵ��");
		}
		vo.setRemark(sub.getRemark());
		vo.setSex(sub.getSex());
		vo.setUserName(sub.getUserName());
		vr.push_back(vo);

	}
	pages.setRows(vr);
	return pages;
}