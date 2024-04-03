#include "stdafx.h"
#include "./BindOwnerDAO.h"
#include <sstream>

int BindOwnerTypeDAO::count() {
	std::stringstream sql;
	sql << "SELECT COUNT(*) FROM BindOwnerTypeName";
	std::string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr);
}

std::list<CheckBindOwnerTypeDO> BindOwnerTypeDAO::selectBindOwnerTypeNameAll() {
	std::stringstream sql;
	sql << "SELECT TypeName FROM BindOwnerTypeName";
	std::string sqlStr = sql.str();
	std::list<CheckBindOwnerTypeDO> res;
	BindOwnerTypeMapper mapper;
	return sqlSession->executeQuery<CheckBindOwnerTypeDO, BindOwnerTypeMapper>(sqlStr,mapper);
}




/**************************************/
//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getAppUserName().empty()) { \
	sql << " AND `appUserName`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getAppUserName()); \
} \
if (!obj.getIdCard().empty()) { \
	sql << " AND idCard=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getIdCard()); \
} \
if (!obj.getLink().empty()) { \
	sql << " AND link=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getLink()); \
}\
if (!obj.getState().empty()){\
    sql << " AND state=?"; \
    SQLPARAMS_PUSH(params,"s",std::string , obj.getState()); }




int BindOwnerItemDAO::count(CheckBindOwnerItemDO obj)
{
	std::stringstream sql;
	sql << "SELECT COUNT(*) FROM BindOwnerItem";
	SAMPLE_TERAM_PARSE(obj, sql);
	std::string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr);
}

std::list<BindOwnerItemDO> BindOwnerItemDAO::selectWithPage(CheckBindOwnerItemDO obj,
	int pageIndex,
	int pageSize) {
	std::stringstream sql;
	sql << "SELECT * FROM BindOwnerItem";
	SAMPLE_TERAM_PARSE(obj, sql);
	BindOwnerItemMapper mapper;
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	std::string sqlStr = sql.str();
	return sqlSession->executeQuery<BindOwnerItemDO,BindOwnerItemMapper>(sqlStr, mapper, params);
}