#include "stdafx.h"
#include "FeeSumDAO.h"
#include "FeeSumMapper.h"

//定义条件解析宏，减少重复代码
#define FEESUM_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getCreateTime().empty()) { \
	sql << " AND `create_time`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getCreateTime()); \
} \
if (!obj.getFeeName().empty()) { \
	sql << " AND `fee_name`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getFeeName()); \
} \
if (obj.getReceivableAmounts() != -1) { \
	sql << " AND `receivable_amounts`=?"; \
	SQLPARAMS_PUSH(params, "d", double, obj.getReceivableAmounts()); \
} \
if (obj.getReceivedAmounts() != -1) {\
	sql << " AND `received_amounts`=?"; \
	SQLPARAMS_PUSH(params, "d", double, obj.getReceivedAmounts()); \
}

long FeeSumDAO::count(FeeSumDO obj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `fee_sum`";
	FEESUM_TERAM_PARSE(obj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<FeeSumDO> FeeSumDAO::selectWithPage(FeeSumDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `fee_sum`";
	FEESUM_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	FeeSumMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<FeeSumDO, FeeSumMapper>(sqlStr, mapper, params);
}
