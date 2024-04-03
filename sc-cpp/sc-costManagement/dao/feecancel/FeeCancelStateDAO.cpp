#include "stdafx.h"
#include "FeeCancelStateDAO.h"
#include "FeeCancelStateMapper.h"

list<FeeCancelStateDO> FeeCancelStateDAO::listAll()
{
	stringstream sql;
	sql << "SELECT * FROM `fee_cancel_state`";
	FeeCancelStateMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<FeeCancelStateDO, FeeCancelStateMapper>(sqlStr, mapper);
}

string FeeCancelStateDAO::queryStateNameById(uint64_t id)
{
	string sql = "SELECT * FROM `fee_cancel_state` WHERE `state_id` = ?";
	FeeCancelStateMapper mapper;
	list<FeeCancelStateDO> objs = sqlSession->executeQuery<FeeCancelStateDO, FeeCancelStateMapper>(sql, mapper, "i", id);
	FeeCancelStateDO obj = objs.front();
	return obj.getStateName();
}
