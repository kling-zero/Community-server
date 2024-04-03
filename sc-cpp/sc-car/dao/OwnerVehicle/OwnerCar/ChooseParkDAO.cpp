#include "stdafx.h"
#include "ChooseParkDAO.h"
#include "ChooseParkMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define CHOOSEPARK_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getCommunityId().empty()) { \
	sql << " AND `community_id`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCommunityId()); \
} \
if (!obj.getNum().empty()) { \
	sql << " AND `num`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getNum()); \
} \
if (!obj.getState().empty()) { \
	sql << " AND `state`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getState()); \
} \
if (!obj.getAreaNum().empty()) { \
	sql << " AND `userId`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getAreaNum()); \
} \
if (!obj.getCarNum().empty()) { \
	sql << " AND `userId`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCarNum()); \
} \


uint64_t ChooseParkDAO::count(ChooseParkQueryDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `parking_space`";
	CHOOSEPARK_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<ChooseParkDO> ChooseParkDAO::selectWithPage(ChooseParkQueryDO obj, long pageIndex, long pageSize)
{
	stringstream sql;

	sql << "SELECT * FROM `parking_space`";
	CHOOSEPARK_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	ChooseParkMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ChooseParkDO, ChooseParkMapper>(sqlStr, mapper, params);
}