#include "stdafx.h"
#include "ChooseOwnerDAO.h"
#include "ChooseOwnerMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define CHOOSEOWNER_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getCommunityId().empty()) { \
	sql << " AND `community_id`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getCommunityId()); \
} \
if (!obj.getName().empty()) { \
	sql << " AND `name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getName()); \
} \
if (!obj.getOwnerTypeCd().empty()) { \
	sql << " AND `owner_type_cd`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getOwnerTypeCd()); \
} \
if (!obj.getRoomName().empty()) { \
	sql << " AND `getRoomName`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getRoomName()); \
} \

#define CHOOSEOWNER_TERAM_PARSE_FORCOUNT(obj, sql) \
SqlParams params_count; \
sql<<" WHERE 1=1"; \
if (!obj.getCommunityId().empty()) { \
	sql << " AND `community_id`=?"; \
	SQLPARAMS_PUSH(params_count, "s", std::string, obj.getCommunityId()); \
} \
if (!obj.getName().empty()) { \
	sql << " AND `name`=?"; \
	SQLPARAMS_PUSH(params_count, "s", std::string, obj.getName()); \
} \
if (!obj.getOwnerTypeCd().empty()) { \
	sql << " AND `owner_type_cd`=?"; \
	SQLPARAMS_PUSH(params_count, "s", std::string, obj.getOwnerTypeCd()); \
} \
if (!obj.getRoomName().empty()) { \
	sql << " AND `getRoomName`=?"; \
	SQLPARAMS_PUSH(params_count, "s", std::string, obj.getRoomName()); \
} \


uint64_t ChooseOwnerDAO::count(ChooseOwnerQueryDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `building_owner`";
	CHOOSEOWNER_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<ChooseOwnerDO> ChooseOwnerDAO::selectWithPage(ChooseOwnerQueryDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT building_owner.*";
	
	string select_user_name = "(`building_owner` inner join `coupon_shop_pool_detail` on building_owner.user_id = coupon_shop_pool_detail.user_id)";
	stringstream sql_count;
	CHOOSEOWNER_TERAM_PARSE_FORCOUNT(obj, sql_count);
	string sql_countStr = sql_count.str();
	long UserName_count = sqlSession->executeQueryNumerical(sql_countStr, params_count);

	if (!obj.getRoomName().empty()) {
		sql << ",room_name";
	}
	else {
		sql << ",null as room_name";

	}
	if (UserName_count > 0) {
		sql << ",user_name";
	}
	else {
		sql << ",null as user_name";

	}
	sql << " FROM ";

	sql_count << "SELECT COUNT(*) FROM " << select_user_name;
	

	int temp = 0;

	if (UserName_count > 0) {
		sql << select_user_name;
		temp = 1;
	}
	if (!obj.getRoomName().empty()) {
		sql << "inner join `contract_change_plan_room` on building_owner.owner_id = contract_change_plan_room.owner_id";
		temp = 1;
	}
	if (temp == 0) {
		sql << "`building_owner`";
	}

	CHOOSEOWNER_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	ChooseOwnerMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ChooseOwnerDO, ChooseOwnerMapper>(sqlStr, mapper, params);
}