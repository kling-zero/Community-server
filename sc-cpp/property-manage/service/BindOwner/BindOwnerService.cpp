#include "stdafx.h"
#include "BindOwnerService.h"

/*
* ***********
* ����BindType�ӿ�
* @Author : kazimiyuuka
* @Time : 2020/10/25 19:50
* ***********
*/
std::list<CheckBindOwnerTypeVO> BindOwnerService::getBindType() {
	//�������ض���
	std::list<CheckBindOwnerTypeVO> data;
	std::list<CheckBindOwnerTypeDO> list;
	BindOwnerTypeDAO bindOwnerTypeDAO;
	list = bindOwnerTypeDAO.selectBindOwnerTypeNameAll();
	for (auto& it :  list) {
		CheckBindOwnerTypeVO temp;
		temp.setTypename(it.getType());
		data.push_back(temp);
	}
	return data;
}

/*
* ***********
* ��ѯ�����ݽӿ�
* @Author : kazimiyuuka
* @Time : 2020/10/25 19:50
* ***********
*/
PageVO<CheckBindOwnerListVO> BindOwnerService::listBindAll(CheckBindOwnerItemQuery query) {
	//�������ض���
	PageVO<CheckBindOwnerListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����
	CheckBindOwnerItemDO obj;
	obj.setAppUserName(query.getAppUserName());
	obj.setIdCard(query.getIdCard());
	obj.setLink(query.getLink());
	obj.setState(query.getState());
	BindOwnerItemDAO dao;
	int count = dao.count(obj);
	if (count <= 0)
		return pages;

	//�ֱ��ѯ
	pages.setTotal(count);
	pages.calcPages();
	list<BindOwnerItemDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<CheckBindOwnerListVO> vr;
	for (BindOwnerItemDO obj: result) {
		CheckBindOwnerListVO data;
		data.setAppUserID(obj.getAppUserID());
		data.setMemberID(obj.getMemberID());
		data.setCommunityID(obj.getCommunityID());
		data.setCommunityName(obj.getCommunityName());
		data.setAppUserName(obj.getAppUserName());
		data.setIdCard(obj.getIdCard());
		data.setLink(obj.getLink());
		data.setStateName(obj.getStateName());
		data.setCreateTime(obj.getCreateTime());
		vr.push_back(data);
	}
	pages.setRows(vr);
	return pages;
}