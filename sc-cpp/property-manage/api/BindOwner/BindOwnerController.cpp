#include "stdafx.h"
#include "./BindOwnerController.h"
#include "./service/BindOwner/BindOwnerService.h"
#include "./dao/BindOwner/BindOwnerDAO.h"
JsonVO<std::list<CheckBindOwnerTypeVO>> BindOwnerController::executeQueryCheckType()
{
	std::list<CheckBindOwnerTypeVO> data;
	CheckBindOwnerTypeVO val;
	data.push_back(val);
	BindOwnerService service;
	JsonVO<std::list<CheckBindOwnerTypeVO>> res;
	res.success(service.getBindType());
	return res;
}

JsonVO<PageVO<CheckBindOwnerListVO>> BindOwnerController::executeQueryCheckList(CheckBindOwnerItemQuery query)
{
	//Ê¾Àý²ÎÊý
	CheckBindOwnerListVO vo;
	BindOwnerService service;

	vo.setStateName(u8"test");
	vo.setMemberID(u8"123");
	vo.setLink(u8"123");
	vo.setIdCard(u8"123");
	vo.setCreateTime(u8"2022 - 10 - 17 17:24 : 30");
	vo.setCommunityName(u8"test");
	vo.setCommunityID(u8"123");
	vo.setAppUserName(u8"test");
	vo.setAppUserID(u8"test");
	JsonVO<PageVO<CheckBindOwnerListVO>> res;

	
	res.success(service.listBindAll(query));
	return res;
}

JsonVO<ChangeBindReply> BindOwnerController::executeChangeBindState(ChangeBindOwnerState change)
{
	std::cout << change.getAppUserID() << std::endl << change.getOperation()  <<  endl;
	ChangeBindReply reply;
	reply.setappUserID("123");
	reply.setNewPassword("123");
	reply.setOperation(1);
	JsonVO<ChangeBindReply> res;
	res.success(reply);
	return res;
}