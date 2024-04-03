#include "stdafx.h"
#include "StaffFeeService.h"
#include "domain/do/StaffFee/StaffFeeDO.h"
#include "dao/StaffFee/StaffFeeDAO.h"

PageVO<StaffFeeListVO> StaffFeeService::listAll(StaffFeeQuery query)
{
	//�������ض���
	PageVO<StaffFeeListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����������
	StaffFeeDO obj;
	obj.setUserId(query.getUserId());

	StaffFeeDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//��ҳ��ѯ����
	pages.setTotal(count);
	pages.calcPages();
	list<StaffFeeDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());

	list<StaffFeeListVO> vr;
	for (StaffFeeDO sub : result)
	{
		StaffFeeListVO vo;
		vo.setUserId(sub.getUserId());
		vo.setUserName(sub.getUserName());
		vo.setReceivableAmount(sub.getReceivableAmount());
		vo.setReceivedAmount(sub.getReceivedAmount());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}
