#include "stdafx.h"
#include "OwnerMemberController.h"
#include "../../domain/dto/OwnerMember/AddMemberDTO.h"
#include "../../domain/dto/OwnerMember/DeleteMemberDTO.h"
#include "../../domain/dto/OwnerMember/ModifyMemberDTO.h"
#include "../../domain/vo/OwnerMember/OwnerItemVO.h"
#include "../../domain/query/OwnerMember/OwnerItemQuery.h"
#include "../../service/OwnerMember/OwnerMemberService.h"

JsonVO<PageVO<OwnerItemVO>> OwnerMemberController::execQueryOwnerList(OwnerItemQuery query)
{
	//����һ��Service
	OwnerMemberService service;
	//��ѯ����
	PageVO<OwnerItemVO> result = service.listAll(query);
	//��Ӧ���
	return JsonVO<PageVO<OwnerItemVO>>(result, RS_SUCCESS);
	//
	/*
	OwnerItemVO ownerItem_vo;
	ownerItem_vo.setOwnerName("xiaohao");
	ownerItem_vo.setSex("��");
	ownerItem_vo.setAge(19);
	ownerItem_vo.setCreateStaff("123");
	ownerItem_vo.setIdCard("888888");
	std::list<OwnerItemVO> list;
	list.push_back(ownerItem_vo);
	PageVO<OwnerItemVO> data;
	data.setRows(list);
	data.setTotal(125);
	JsonVO<PageVO<OwnerItemVO>> ret;
	ret.success(data);
	return ret;
	*/
}