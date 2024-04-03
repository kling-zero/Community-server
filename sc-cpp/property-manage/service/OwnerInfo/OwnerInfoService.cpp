#include "stdafx.h"
#include "OwnerInfoService.h"

PageVO<OwnerInfoVO> OwnerInfoService::listAllOwnerInfo(OwnerInfoQuery query)
{
	//构建返回对象
	PageVO<OwnerInfoVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
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

	//分页查询数据
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


//添加业主信息
uint64_t OwnerInfoService::AddOwnerInfo(OwnerInfoDTO dto) 
{
	//组装数据
	OwnerInfoDO data;
	data.setCreatStaff(dto.getCreatStaff());
	data.setIdCard(dto.getIdCard());
	data.setOwnerAge(dto.getOwnerAge());
	data.setOwnerGender(dto.getOwnerGender());
	data.setOwnerName(dto.getOwnerName());
	data.setPhoneNum(dto.getPhoneNum());
	data.setRemark(dto.getRemark());
	//执行数据添加
	OwnerInfoDAO dao;
	return dao.addOwnerInfo(data);
}


//修改业主信息
long OwnerInfoService::ModifyOwnerInfo(OwnerInfoDTO dto)
{
	//组装传输数据
	OwnerInfoDO data;
	data.setIdCard(dto.getIdCard());
	data.setPeopleId(dto.getPeopleId());
	data.setOwnerAge(dto.getOwnerAge());
	data.setOwnerGender(dto.getOwnerGender());
	data.setOwnerName(dto.getOwnerName());
	data.setPhoneNum(dto.getPhoneNum());
	data.setRemark(dto.getRemark());
	//执行数据修改
	OwnerInfoDAO dao;
	return dao.modifyOwnerInfo(data) == 1;
}


//删除业主信息
int OwnerInfoService::DeleteOwnerInfo(std::string id)
{
	OwnerInfoDAO dao;
	return dao.deleteById(id) == 1;
}