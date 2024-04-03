#include "stdafx.h"
#include "FeeFormulaDAO.h"
#include "FeeFormulaMapper.h"

//定义条件解析宏，减少重复代码
#define FEEFORMULA_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (obj.getFormulaType() != -1) { \
	sql << " AND `formula_type`=?"; \
	SQLPARAMS_PUSH(params, "i", int, obj.getFormulaType()); \
} \
if (!obj.getFormulaValue().empty()) { \
	sql << " AND `formula_value`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getFormulaValue()); \
} \
if (!obj.getFormulaDesc().empty()) { \
	sql << " AND `formula_desc`=?"; \
	SQLPARAMS_PUSH(params, "s", string, obj.getFormulaDesc()); \
} \
if (obj.getPrice() != -1) {\
	sql << " AND `price`=?"; \
	SQLPARAMS_PUSH(params, "d", double, obj.getPrice()); \
}

long FeeFormulaDAO::count(FeeFormulaDO obj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM `fee_formula`";
	FEEFORMULA_TERAM_PARSE(obj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<FeeFormulaDO> FeeFormulaDAO::selectWithPage(FeeFormulaDO obj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM `fee_formula`";
	FEEFORMULA_TERAM_PARSE(obj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	FeeFormulaMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<FeeFormulaDO, FeeFormulaMapper>(sqlStr, mapper, params);
}

uint64_t FeeFormulaDAO::insert(FeeFormulaDO iObj)
{
	string sql = "INSERT INTO `fee_formula` (`formula_type`,`formula_value`,`formula_desc`,`price`) VALUES(?,?,?,?)";
	return sqlSession->executeInsert(sql, "i%s%s%i", iObj.getFormulaType(), iObj.getFormulaValue(), iObj.getFormulaDesc(), iObj.getPrice());
}

int FeeFormulaDAO::update(FeeFormulaDO uObj)
{
	string sql = "UPDATE `fee_formula` SET `formula_type`=?,`formula_value`=?,`formula_desc`=?,`price`=? WHERE `formula_id`=?";
	return sqlSession->executeUpdate(sql, "i%s%s%d%i", uObj.getFormulaType(), uObj.getFormulaValue(), uObj.getFormulaDesc(), uObj.getPrice(), uObj.getFormulaId());
}

int FeeFormulaDAO::remove(uint64_t id)
{
	string sql = "DELETE FROM `fee_formula` WHERE `formula_id`=?";
    return sqlSession->executeUpdate(sql, "i", id);
}
