#include "stdafx.h"
#include "CarFeeService.h"
#include "domain/do/CarFee/BuildingOwnerDO.h"
#include "domain/do/CarFee/OwnerCarDO.h"
#include "domain/do/CarFee/ParkingAreaDO.h"
#include "domain/vo/CarFee/CarFeeListVO.h"
#include "dao/CarFee/CarFeeListDAO.h"

PageVO<CarFeeListVO> CarFeeService::listAll(CarFeeQuery query)
{
	//构建返回对象
	PageVO<CarFeeListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数
	OwnerCarDO ownerCar;
	BuildingOwnerDO buildingOwner;
	ParkingAreaDO parkingAres;

	ownerCar.setState(query.getState());
	ownerCar.setCar_num(query.getCarNum());
	buildingOwner.setName(query.getOwnerName());

	// allNum为停车场-车位
	std::string allNum = query.getAllNum();
	int found = allNum.find('-');
	if (found != std::string::npos) {
		string num = allNum.substr(0, found);
		string ps_id = allNum.substr(found + 1);
		ownerCar.setPs_id(ps_id);
		parkingAres.setNum(num);
	}
	else parkingAres.setNum(allNum);

	CarFeeListDAO dao;
	uint64_t count = dao.count(ownerCar, buildingOwner, parkingAres);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<OwnerCarDO> r1 = dao.selectOwnerCarWithPage(ownerCar, buildingOwner,parkingAres, query.getPageIndex(), query.getPageSize());
	list<BuildingOwnerDO> r2 = dao.selectBuildingOwnerWithPage(ownerCar, buildingOwner, parkingAres, query.getPageIndex(), query.getPageSize());
	list<ParkingAreaDO> r3 = dao.selectParkingAreaWithPage(ownerCar, buildingOwner, parkingAres, query.getPageIndex(), query.getPageSize());

	list<CarFeeListVO> vr;

	list<OwnerCarDO>::const_iterator r_1 = r1.begin();
	list<BuildingOwnerDO>::const_iterator r_2 = r2.begin();
	list<ParkingAreaDO>::const_iterator r_3 = r3.begin();
	
	for (;r_1 != r1.end(); ++r_1, ++r_2, ++r_3)
	{
		CarFeeListVO vo;
		vo.setAreaNum(r_3->getNum());
		vo.setCarNum(r_1->getCar_num());
		vo.setLink(r_2->getLink());
		vo.setNum(r_1->getPs_id());
		vo.setOwnerName(r_2->getName());
		vo.setStateName(r_1->getState());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}
