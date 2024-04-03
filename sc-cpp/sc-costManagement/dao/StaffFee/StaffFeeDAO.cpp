#include "stdafx.h"
#include "StaffFeeDAO.h"
#include "StaffFeeMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define STAFFFEE_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getUserId().empty()) { \
	sql << " AND `userId`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getUserId()); \
}

uint64_t StaffFeeDAO::count(StaffFeeDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `staff-fee-list`";
	STAFFFEE_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<StaffFeeDO> StaffFeeDAO::selectWithPage(StaffFeeDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `staff-fee-list`";
	STAFFFEE_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	StaffFeeMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<StaffFeeDO, StaffFeeMapper>(sqlStr, mapper, params);
}
