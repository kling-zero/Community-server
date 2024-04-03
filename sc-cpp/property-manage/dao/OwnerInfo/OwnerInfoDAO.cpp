#include "stdafx.h"
#include "OwnerInfoDAO.h"


//定义条件解析宏，减少重复代码
#define OWNER_INFO_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getOwnerName().empty()) { \
	sql << " AND owner_type_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getOwnerName()); \
} \
if (!obj.getPhoneNum().empty()) { \
	sql << " AND link=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getPhoneNum()); \
} \
if (!obj.getPeopleId().empty()) { \
	sql << " AND owner_id=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getPeopleId()); \
} \
if (!obj.getIdCard().empty()) { \
	sql << " AND id_card=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getIdCard()); \
}\
if (!obj.getRoomNum().empty()) { \
	sql << " AND room_num=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getRoomNum()); \
}


#define OWNER_INFO_DETAIL_TERAM_PARSE(obj, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (!obj.getPeopleId().empty()) { \
	sql << " AND owner_id=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, obj.getPeopleId()); \
}


//查询总条数
uint64_t OwnerInfoDAO::countOwnerInfo(OwnerInfoQueryDO iObj)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM owners";
	OWNER_INFO_TERAM_PARSE(iObj, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}


//分页查询业主信息
std::list<OwnerInfoDO> OwnerInfoDAO::selectOwnerInfoWithPage(OwnerInfoQueryDO iObj, long pageIndex, long pageSize)
{
	stringstream sql;
	sql << "SELECT * FROM owners";
	OWNER_INFO_TERAM_PARSE(iObj, sql);
	sql << " LIMIT " << ((pageIndex - 1) * pageSize) << "," << pageSize;
	OwnerInfoMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<OwnerInfoDO, OwnerInfoMapper>(sqlStr, mapper, params);
}


//添加业主信息
uint64_t OwnerInfoDAO::addOwnerInfo(OwnerInfoDO iObj)
{
	timetool time;
	std::string ID = time.getTimeString(true, true);
	std::string sql = "INSERT INTO `owners` (`age`, `id_card`,`link`, `remark`, `sex`,`owner_type_name`,`owner_id`) VALUES (?,?,?,?,?,?,?)";
	return sqlSession->executeUpdate(sql,"i%s%s%s%i%s%s",iObj.getOwnerAge(), iObj.getIdCard(),iObj.getPhoneNum(), iObj.getRemark(), iObj.getOwnerGender(),iObj.getOwnerName(),ID);
}

//修改业主信息
long OwnerInfoDAO::modifyOwnerInfo(OwnerInfoDO iObj)
{
	//修改信息时判断是否有数据

	string sql = "UPDATE `owners` SET `age`=?, `id_card`=?,`link`=?, `remark`=?, `sex`=?,`owner_type_name`=? WHERE `owner_id`=?";
	return sqlSession->executeUpdate(sql, "i%s%s%s%i%s%s", iObj.getOwnerAge(), iObj.getIdCard(), iObj.getPhoneNum(), iObj.getRemark(), iObj.getOwnerGender(), iObj.getOwnerName(), iObj.getPeopleId());
}

//删除业主信息
int OwnerInfoDAO::deleteById(std::string id)
{
	string sql = "DELETE FROM `owners` WHERE `owner_id`=?";
	return sqlSession->executeUpdate(sql, "s", id);
}