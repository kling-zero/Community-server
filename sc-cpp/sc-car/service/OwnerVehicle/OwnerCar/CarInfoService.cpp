#include "stdafx.h"
#include "CarInfoService.h"
#include "../../../dao/OwnerVehicle/OwnerCar/CarInfoDAO.h"

PageVO<CarInfoVO> CarInfoService::listAll(CarInfoQuery query)
{
	//构建返回对象
	PageVO<CarInfoVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
	CarInfoQueryDO obj;

	obj.setCarNum(query.getCarNum());
	obj.setCarTypeCd(query.getCarTypeCd());
	obj.setNum(query.getNum());
	obj.setValid(query.getValid());

	CarInfoDAO dao;
	uint64_t count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<CarInfoDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());

	list<CarInfoVO> vr;
	for (CarInfoDO sub : result)
	{
		CarInfoVO vo;
		vo.setAreaNum(sub.getAreaNum());
		vo.setBId(sub.getBId());
		vo.setCarBrand(sub.getCarBrand());
		vo.setCarColor(sub.getCarColor());
		vo.setCarId(sub.getCarId());
		vo.setCarNum(sub.getCarNum());
		vo.setCarType(sub.getCarType());
		vo.setCarTypeCd(sub.getCarTypeCd());
		vo.setCarTypeName(sub.getCarTypeName());
		vo.setCommunityId(sub.getCommunityId());
		vo.setCreateTime(sub.getCreateTime());
		vo.setEndTime(sub.getEndTime());
		vo.setIdCard(sub.getIdCard());
		vo.setLink(sub.getLink());
		vo.setMemberId(sub.getMemberId());
		vo.setNum(sub.getNum());
		vo.setOwnerId(sub.getOwnerId());
		//vo.setOwnerName(sub.getOwnerName());
		vo.setParkingType(sub.getParkingType());
		vo.setPsId(sub.getPsId());
		vo.setRemark(sub.getRemark());
		//vo.setRoomName(sub.getRoomName());
		vo.setStartTime(sub.getStartTime());
		vo.setState(sub.getState());
		//vo.setStateName(sub.getStateName());
		vo.setStatusCd(sub.getStatusCd());
		vo.setUserId(sub.getUserId());
		//vo.setWithOwner(sub.getWithOwner());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}