#include "stdafx.h"
#include "OwnerAccountDAO.h"
#include <sstream>

#define OWNER_ACCOUNT_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getAcctName().empty()) { \
	sql << " AND `acct_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getAcctName()); \
} \
if (!obj.getAcctIdCard().empty()) { \
	sql << " AND id_card=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getAcctIdCard()); \
} \
if (!obj.getAcctLink().empty()) { \
	sql << " AND link=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getAcctLink()); \
} \
if (!obj.getAcctType().empty()) { \
		sql << " AND acct_type=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, obj.getAcctType()); \
}

#define OWNER_ACCOUNT_DETAIL_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getAcctId().empty()) { \
		sql << " AND acct_id=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, obj.getAcctId()); \
}



uint64_t OwnerAccountDAO::countOwnerAccountItem(OwnerAccountQueryDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM account";
	OWNER_ACCOUNT_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

uint64_t OwnerAccountDAO::countOwnerAccountDetail(OwnerAccountDetailDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM account_detail";
	OWNER_ACCOUNT_DETAIL_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

uint64_t OwnerAccountDAO::countSelectOwner()
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM building_owner";
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr);
}

std::list<OwnerAccountItemDO> OwnerAccountDAO::selectOwnerAccountItemWithPage(OwnerAccountQueryDO iObj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM account";
	OWNER_ACCOUNT_TERAM_PARSE(iObj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	OwnerAccountItemMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<OwnerAccountItemDO, OwnerAccountItemMapper>(sqlStr, mapper, params);
}

std::list<OwnerAccountItemDO> OwnerAccountDAO::selectOwnerAccountItem(OwnerAccountDetailDO iObj)
{
	stringstream sql;
	sql << "SELECT * FROM account";
	OWNER_ACCOUNT_DETAIL_TERAM_PARSE(iObj, sql);
	OwnerAccountItemMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<OwnerAccountItemDO, OwnerAccountItemMapper>(sqlStr, mapper, params);
}

std::list<SelectOwnerDO> OwnerAccountDAO::selectSelectOwner()
{
	stringstream sql;
	sql << "SELECT * FROM building_owner";
	SelectOwnerMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<SelectOwnerDO, SelectOwnerMapper>(sqlStr, mapper);
}

uint64_t OwnerAccountDAO::insertOwnerAccount(OwnerAccountItemDO iObj)
{
	string sql = "INSERT INTO `account` \
		(`acct_id`, `acct_name`, `acct_type`, `amount`, `obj_type`, `obj_id`, `b_id`, `create_time`, `status_cd`, `part_id` ) \
		VALUES (?, ?, ?)";
	return sqlSession->executeInsert(sql, "s%s%s%i%s%s%s%s%s%s", 
		iObj.getAcctId(), 
		iObj.getAcctName(), 
		iObj.getAcctType(), 
		iObj.getAmount(), 
		iObj.getObjType(), 
		iObj.getObjId(), 
		iObj.getBId(), 
		iObj.getCreateTime(), 
		iObj.getStatusCd(), 
		iObj.getPartId());
}

uint64_t OwnerAccountDAO::updateOwnerAccount(OwnerAccountItemDO iObj)
{
	string sql = "UPDATE `account` SET `amount`=? WHERE `acct_name`=? AND `acct_type`=?";
	return sqlSession->executeUpdate(sql, "i%s%s",
		iObj.getAmount(),
		iObj.getAcctName(),
		iObj.getAcctType());
}

std::list<OwnerAccountDetailDO> OwnerAccountDAO::selectOwnerAccountDetailWithPage(OwnerAccountDetailDO iObj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM account_detail";
	OWNER_ACCOUNT_DETAIL_TERAM_PARSE(iObj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	OwnerAccountDetailMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<OwnerAccountDetailDO, OwnerAccountDetailMapper>(sqlStr, mapper, params);
}
