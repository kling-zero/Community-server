#include "stdafx.h"
#include "BindOwnerService.h"

/*
* ***********
* 访问BindType接口
* @Author : kazimiyuuka
* @Time : 2020/10/25 19:50
* ***********
*/
std::list<CheckBindOwnerTypeVO> BindOwnerService::getBindType() {
	//构建返回对象
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
* 查询绑定数据接口
* @Author : kazimiyuuka
* @Time : 2020/10/25 19:50
* ***********
*/
PageVO<CheckBindOwnerListVO> BindOwnerService::listBindAll(CheckBindOwnerItemQuery query) {
	//创建返回对象
	PageVO<CheckBindOwnerListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询条数
	CheckBindOwnerItemDO obj;
	obj.setAppUserName(query.getAppUserName());
	obj.setIdCard(query.getIdCard());
	obj.setLink(query.getLink());
	obj.setState(query.getState());
	BindOwnerItemDAO dao;
	int count = dao.count(obj);
	if (count <= 0)
		return pages;

	//分表查询
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