#include "stdafx.h"
#include "FeeCancelDAO.h"
#include "FeeCancelMapper.h"

//定义条件解析宏，减少重复代码
#define FEECANCEL_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (obj.getBatchId() != 0) { \
	sql << " AND `batch_id`=?"; \
	SQLPARAMS_PUSH(params, "i", int, obj.getBatchId()); \
} \
if (!obj.getStateName().empty()) { \
	sql << " AND `state_name`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getStateName()); \
} \
if (!obj.getCreateUserName().empty()) { \
	sql << " AND `create_user_name`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getCreateUserName()); \
} \
if (!obj.getReason().empty()) { \
	sql << " AND `reason`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getReason()); \
} \
if (!obj.getMsg().empty()) { \
	sql << " AND `msg`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getMsg()); \
} 

long FeeCancelDAO::count(FeeCancelDO obj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `fee_cancel`";
	FEECANCEL_TERAM_PARSE(obj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<FeeCancelDO> FeeCancelDAO::selectWithPage(FeeCancelDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `fee_cancel`";
	FEECANCEL_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	FeeCancelMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<FeeCancelDO, FeeCancelMapper>(sqlStr, mapper, params);
}

int FeeCancelDAO::update(FeeCancelDO obj)
{
	if (!obj.getReason().empty()) {
		string sql = "UPDATE `fee_cancel` SET `reason`=?, `state_name`=?, `msg`=? WHERE `batch_id`=?";
		return sqlSession->executeUpdate(sql, "s%s%s%i", obj.getReason(), obj.getStateName(), obj.getMsg(), obj.getBatchId());
	}
	else if (!obj.getStateName().empty()) {
		string sql = "UPDATE `fee_cancel` SET `state_name`=?, `msg`=? WHERE `batch_id`=?";
		return sqlSession->executeUpdate(sql, "s%s%i", obj.getStateName(), obj.getMsg(), obj.getBatchId());
	}
	else {
		return -1;
	}

}
