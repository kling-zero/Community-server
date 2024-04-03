#include "stdafx.h"
#include "CarFeeListDAO.h"
#include <sstream>
#include "OwnerCarMapper.h"
#include "BuildingOwnerMapper.h"
#include "ParkingAreaMapper.h"

//定义条件解析宏，减少重复代码
#define CARFEELIST_TERAM_PARSE(ownerCar, parkingAres, buildingOwner, sql)\
SqlParams params;\
if (!ownerCar.getCar_num().empty()) {\
	sql << " AND `car_num`=?";\
	SQLPARAMS_PUSH(params, "s", std::string, ownerCar.getCar_num());\
}\
if (!ownerCar.getPs_id().empty()) {\
	sql << " AND `Ps_id`=?";\
	SQLPARAMS_PUSH(params, "s", std::string, ownerCar.getPs_id());\
}\
if (!ownerCar.getState().empty()) {\
	sql << " AND `state`=?";\
	SQLPARAMS_PUSH(params, "s", std::string, ownerCar.getState());\
}\
if (!parkingAres.getNum().empty()) {\
	sql << "AND `num` = ?";\
	SQLPARAMS_PUSH(params, "s", std::string, parkingAres.getNum());\
}\
if (!buildingOwner.getName().empty()) {\
	sql << "AND `name` = ?";\
	SQLPARAMS_PUSH(params, "s", std::string, buildingOwner.getName());\
}\

uint64_t CarFeeListDAO::count(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres)
{
	stringstream sql; 
	sql << "SELECT count(*) FROM `owner_car` as a, `parking_area` as b, `building_owner` as c where a.b_id = b.b_id and a.community_id = b.community_id and a.owner_id = c.owner_id ";

	CARFEELIST_TERAM_PARSE(ownerCar, parkingAres, buildingOwner, sql)
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<OwnerCarDO> CarFeeListDAO::selectOwnerCarWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT a.car_num, a.ps_id, a.state, b.num, c.name, c.link FROM `owner_car` as a, `parking_area` as b, `building_owner` as c where a.b_id = b.b_id and a.community_id = b.community_id and a.owner_id = c.owner_id";

	CARFEELIST_TERAM_PARSE(ownerCar, parkingAres, buildingOwner, sql)
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	OwnerCarMapper mapper;
	string sqlStr = sql.str();

	return sqlSession->executeQuery<OwnerCarDO, OwnerCarMapper>(sqlStr, mapper, params);
}

std::list<BuildingOwnerDO> CarFeeListDAO::selectBuildingOwnerWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT a.car_num, a.ps_id, a.state, b.num, c.name, c.link FROM `owner_car` as a, `parking_area` as b, `building_owner` as c where a.b_id = b.b_id and a.community_id = b.community_id and a.owner_id = c.owner_id";

	CARFEELIST_TERAM_PARSE(ownerCar, parkingAres, buildingOwner, sql)
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	BuildingOwnerMapper mapper;
	string sqlStr = sql.str();

	return sqlSession->executeQuery<BuildingOwnerDO, BuildingOwnerMapper>(sqlStr, mapper, params);
}

std::list<ParkingAreaDO> CarFeeListDAO::selectParkingAreaWithPage(OwnerCarDO ownerCar, BuildingOwnerDO buildingOwner, ParkingAreaDO parkingAres, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT a.car_num, a.ps_id, a.state, b.num, c.name, c.link FROM `owner_car` as a, `parking_area` as b, `building_owner` as c where a.b_id = b.b_id and a.community_id = b.community_id and a.owner_id = c.owner_id";

	CARFEELIST_TERAM_PARSE(ownerCar, parkingAres, buildingOwner, sql)
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	ParkingAreaMapper mapper;
	string sqlStr = sql.str();

	return sqlSession->executeQuery<ParkingAreaDO, ParkingAreaMapper>(sqlStr, mapper, params);
}
