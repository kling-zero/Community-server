#include "stdafx.h"
#include "BoothDAO.h"

#define SAMPLE_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getBox_id().empty()) { \
	sql << " AND `box_id`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getBox_id()); \
} \
if (!obj.getBox_name().empty()) { \
	sql << " AND box_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getBox_name()); \
} \
if (!obj.getTemp_car_in().empty()) { \
	sql << " AND `temp_car_in`=?"; \
	SQLPARAMS_PUSH(params, "s",std::string , obj.getTemp_car_in()); \
}
uint64_t BoothDAO::count(BoothListDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `parking_box`";
	SAMPLE_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<BoothListDO> BoothDAO::selectWithPage(BoothListDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `parking_box` ";
	SAMPLE_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	BoothMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<BoothListDO, BoothMapper>(sqlStr,mapper,params);
}

uint64_t BoothDAO::insert(BoothListDO iObj)
{
	string sql = "INSERT INTO `parking_box`(`box_id`,`box_name`,`community_id`,`temp_car_in`,`fee`,`blue_car_in`,`yelow_car_in`,`remark`,`status_cd`,`create_time`) VALUES(?,?,?,?,?,?,?,?,?,now())";
	return sqlSession->executeInsert(sql, "s%s%s%s%s%s%s%s%s", iObj.getBox_id(), iObj.getBox_name(),iObj.getCommunity_id(),iObj.getTemp_car_in(),iObj.getFee(),iObj.getBlue_car_in(),iObj.getYelow_car_in(),iObj.getRemark(),/*iObj.getCreate_time(),*/iObj.getStatus_cd());
}

int BoothDAO::update(BoothListDO uObj)
{
	string sql = "UPDATE `parking_box` SET `box_name` = ?,`temp_car_in` = ?,`fee` = ?,`blue_car_in` = ?,`yelow_car_in` = ?,`remark` = ? WHERE `box_id` = ?";
	return sqlSession->executeUpdate(sql, "s%s%s%s%s%s%s", uObj.getBox_name(), uObj.getTemp_car_in(), uObj.getFee(), uObj.getBlue_car_in(), uObj.getYelow_car_in(), uObj.getRemark(), uObj.getBox_id());
}

int BoothDAO::deleteById(std::string id)
{
	string sql = "DELETE FROM `parking_box` WHERE `box_id`= ?";
	return sqlSession->executeUpdate(sql, "s", id);
}
