#include"stdafx.h"
#include"OwnerMemberDAO.h"
#include"OwnerMemberMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define OWNER_MEMBER_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getOwnerName().empty()) { \
	sql << " AND `name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getOwnerName()); \
} \
if (!obj.getRoomId().empty()) { \
	sql << " AND roomId=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getRoomId());\
}




uint64_t OwnerMemberDAO::count(OwnerItemDo iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM building_owner";
	OWNER_MEMBER_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<OwnerItemDo> OwnerMemberDAO::selectWithPage(OwnerItemDo obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM building_owner";
	OWNER_MEMBER_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	OwnerMemberMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<OwnerItemDo, OwnerMemberMapper>(sqlStr, mapper, params);
}