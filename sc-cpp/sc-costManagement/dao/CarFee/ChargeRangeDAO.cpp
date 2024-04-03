#include "stdafx.h"
#include "ChargeRangeDAO.h"
#include <sstream>
#include "ChargeRangeMapper.h"

//定义条件解析宏，减少重复代码
#define CHARGERANGE_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (obj.getId() > 0) { \
	sql << " AND `id`=?"; \
	SQLPARAMS_PUSH(params, "s", long, obj.getId()); \
} \
if (!obj.getDescription().empty()) { \
	sql << " AND `description`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getDescription()); \
} \

std::list<ChargeRangeDO> ChargeRangeDAO::selectRange(ChargeRangeDO obj)
{
	stringstream sql;
	sql << "SELECT * FROM `charge-range`";

	CHARGERANGE_TERAM_PARSE(obj, sql);

	ChargeRangeMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ChargeRangeDO, ChargeRangeMapper>(sqlStr, mapper, params);
}

