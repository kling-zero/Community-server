#include "stdafx.h"
#include "CarInfoDAO.h"
#include "CarInfoMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define CARINFO_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getCarNum().empty()) { \
	sql << " AND `car_num`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCarNum()); \
} \
if (!obj.getNum().empty()) { \
	sql << " AND `num`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getNum()); \
} \
if (!obj.getCarTypeCd().empty()) { \
	sql << " AND `car_type_cd`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCarTypeCd()); \
} \
if (!obj.getValid().empty()) { \
	if(obj.getValid() == "1"){ \
		sql << "  WHERE `end_time`>CURDATE()"; \
	} \
	else if (obj.getValid() == "2") { \
		sql << "  WHERE `end_time`<CURDATE()"; \
	}\
	else { \
		sql << "  WHERE `area_num` IS NULL"; \
	} \
} \
if (!obj.getCarNumLike().empty()) { \
	sql << " AND `CarNum`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCarNumLike()); \
} \

uint64_t CarInfoDAO :: count(CarInfoQueryDO iObj)
{
	//areaNum 在 temp_car_fee 
	stringstream sql;
	//`business_parking_area``business_temp_car_fee_config`
	sql << "SELECT COUNT(*) FROM `owner_car`";
	CARINFO_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<CarInfoDO> CarInfoDAO::selectWithPage(CarInfoQueryDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `owner_car`";
	CARINFO_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	CarInfoMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<CarInfoDO, CarInfoMapper>(sqlStr, mapper, params);
}