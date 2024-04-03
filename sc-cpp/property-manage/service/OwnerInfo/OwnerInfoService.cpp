#include "stdafx.h"
#include "OwnerInfoService.h"

PageVO<OwnerInfoVO> OwnerInfoService::listAllOwnerInfo(OwnerInfoQuery query)
{
	//�������ض���
	PageVO<OwnerInfoVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����������
	OwnerInfoQueryDO obj;
	obj.setOwnerName(query.getOwnerName());
	obj.setRoomNum(query.getRoomNum());
	obj.setIdCard(query.getIdCard());
	obj.setPeopleId(query.getPeopleId());
	obj.setPhoneNum(query.getPhoneNum());
	OwnerInfoDAO dao;

	uint64_t count = dao.countOwnerInfo(obj);
	if (count <= 0)
	{
		return pages;
	}

	//��ҳ��ѯ����
	pages.setTotal(count);
	pages.calcPages();
	list<OwnerInfoDO> result = dao.selectOwnerInfoWithPage(obj, query.getPageIndex(), query.getPageSize());
	//list<OwnerInfoDO> result = dao.selectOwnerInfoWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<OwnerInfoVO> vr;
	for (OwnerInfoDO sub : result)
	{
		OwnerInfoVO vo;
		vo.setOwnerName(sub.getOwnerName());
		vo.setPeopleId(sub.getPeopleId());
		vo.setPhoneNum(sub.getPhoneNum());
		vo.setIdCard(sub.getIdCard());
		vo.setOwnerAge(sub.getOwnerAge());
		vo.setOwnerGender(sub.getOwnerGender());
		vo.setCreateStaff(sub.getCreatStaff());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}


//���ҵ����Ϣ
uint64_t OwnerInfoService::AddOwnerInfo(OwnerInfoDTO dto) 
{
	//��װ����
	OwnerInfoDO data;
	data.setCreatStaff(dto.getCreatStaff());
	data.setIdCard(dto.getIdCard());
	data.setOwnerAge(dto.getOwnerAge());
	data.setOwnerGender(dto.getOwnerGender());
	data.setOwnerName(dto.getOwnerName());
	data.setPhoneNum(dto.getPhoneNum());
	data.setRemark(dto.getRemark());
	//ִ���������
	OwnerInfoDAO dao;
	return dao.addOwnerInfo(data);
}


//�޸�ҵ����Ϣ
long OwnerInfoService::ModifyOwnerInfo(OwnerInfoDTO dto)
{
	//��װ��������
	OwnerInfoDO data;
	data.setIdCard(dto.getIdCard());
	data.setPeopleId(dto.getPeopleId());
	data.setOwnerAge(dto.getOwnerAge());
	data.setOwnerGender(dto.getOwnerGender());
	data.setOwnerName(dto.getOwnerName());
	data.setPhoneNum(dto.getPhoneNum());
	data.setRemark(dto.getRemark());
	//ִ�������޸�
	OwnerInfoDAO dao;
	return dao.modifyOwnerInfo(data) == 1;
}


//ɾ��ҵ����Ϣ
int OwnerInfoService::DeleteOwnerInfo(std::string id)
{
	OwnerInfoDAO dao;
	return dao.deleteById(id) == 1;
}