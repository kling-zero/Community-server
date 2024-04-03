#include "stdafx.h"
#include "./RoomManageDAO.h"
#include <sstream>

int RoomStateDAO::count() {
	std::stringstream sql;
	sql << "SELECT COUNT(*) FROM c_status WHERE status_cd LIKE '2%' "; // 可能有问题
	std::string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr);
}

std::list<C_StatusDO> RoomStateDAO::selectRoomStateNameAll() {
	std::stringstream sql;
	sql << "SELECT id, status_cd, name, description FROM c_status WHERE status_cd LIKE '2%' ";
	std::string sqlStr = sql.str();
	// std::list<C_StatusDO> res;
	RoomStateMapper mapper;
	return sqlSession->executeQuery<C_StatusDO, RoomStateMapper>(sqlStr, mapper);
}

int RoomTypeDAO::count() {
	std::stringstream sql;
	sql << "SELECT COUNT(*) FROM t_dict WHERE id = 6125 OR id = 6126 OR id = 6127 ";
	std::string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr);
}

std::list<t_dictDO> RoomTypeDAO::selectRoomTypeAll() {
	std::stringstream sql;
	sql << "SELECT id, status_cd, name, description FROM t_dict WHERE id = 6125 OR id = 6126 OR id = 6127 ";
	std::string sqlStr = sql.str();
	// std::list<t_dictDO> res;
	RoomTypeMapper mapper;
	return sqlSession->executeQuery<t_dictDO, RoomTypeMapper>(sqlStr, mapper);
}


/**************************************/
//定义条件解析宏，减少重复代码
#define FLOORANDUNIT_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (obj.getCommunity_id() != "-1") { \
	sql << " AND f.community_id=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCommunity_id()); \
} \
sql << " AND f.floor_id=b.floor_id"; \

int QueryFloorAndUnitDAO::count(FloorAndUnitDO obj)
{
	std::stringstream sql;
	sql << "SELECT COUNT(*) FROM (SELECT f.floor_id, f.floor_num, b.unit_id, b.unit_num, b.layer_count, b.lift, b.remark, b.unit_area FROM f_floor AS f, building_unit AS b";
	FLOORANDUNIT_TERAM_PARSE(obj, sql);
	sql << ")";
	std::string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<FloorAndUnitDO> QueryFloorAndUnitDAO::getUnitAll(FloorAndUnitDO obj) {
	std::stringstream sql;
	sql << "SELECT f.floor_id, f.floor_num, b.unit_id, b.unit_num, b.layer_count, b.lift, b.remark, b.unit_area FROM f_floor AS f, building_unit AS b";
	FLOORANDUNIT_TERAM_PARSE(obj, sql);
	FloorAndUnitMapper mapper;
	std::string sqlStr = sql.str();
	return sqlSession->executeQuery<FloorAndUnitDO, FloorAndUnitMapper>(sqlStr, mapper, params);
}
uint64_t AddUnitDAO::insert(AddUnitDO iObj)
{
	string sql = "INSERT INTO `building_unit` (`unit_num`, `layer_count`, `unit_area`,`lift`,`remark`) VALUES (?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "s%i%d%s%s", iObj.getUnitNum(), iObj.getLayerCount(), iObj.getUnitArea(),iObj.getLift(), iObj.getRemark());
}
int RemoveDAO::deleteByUnitNum(std::string unit_num)
{
	string sql = "DELETE FROM `building_unit` WHERE `unit_num`=?";
	return sqlSession->executeUpdate(sql, "s", unit_num);
}

int ModifyDAO::update(AddUnitDO uObj)
{
	string sql = "UPDATE `building_unit` SET `unit_num`=?, `layer_count`=?, `unit_area`=? `lift`=? `remark`=? WHERE `unit_id`=742022082058950007";
	return sqlSession->executeUpdate(sql, "s%s%i%i", uObj.getUnitNum(), uObj.getLayerCount(), uObj.getUnitArea(), uObj.getLift(), uObj.getRemark());
}