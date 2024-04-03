#include"stdafx.h"
#include "OwnerMemberService.h"
#include <domain/do/OwnerMember/OwnerItemDo.h>
#include <dao/OwnerMember/OwnerMemberDAO.h>

PageVO<OwnerItemVO> OwnerMemberService::listAll(OwnerItemQuery query)
{
	//构建返回对象
	PageVO<OwnerItemVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
	OwnerItemDo obj;
	obj.setOwnerName(query.getOwnerName());
	obj.setRoomId(query.getRoomId());
	OwnerMemberDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<OwnerItemDo> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<OwnerItemVO> vr;
	for (OwnerItemDo sub : result)
	{
		OwnerItemVO vo;
		vo.setOwnerName(sub.getOwnerName());
		vo.setSex(sub.getSex());
		vo.setAge(sub.getAge());
		vo.setIdCard(sub.getIdCard());
		vo.setLink(sub.getLink());
		vo.setCreateStaff(sub.getCreateStaff());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}
