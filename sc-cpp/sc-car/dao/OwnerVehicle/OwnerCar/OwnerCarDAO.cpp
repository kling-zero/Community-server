#include "stdafx.h"
#include "OwnerCarDAO.h"
#include <sstream>

uint64_t OwnerCarDAO::insert(AddOwnerCarDO iObj)
{
	string sql = "INSERT INTO `owner_car` VALUES (?, ?, '', ?, ?, ?, ?,  '', ?, ?, NOW(),'', ?, ?, ?, '','', ?)";
	return sqlSession->executeUpdate(sql, "cs%s%s%s%s%s%s%s%s%s%s%cs",\
		"102022081507340423", iObj.getOwnerId(), \
		iObj.getCarNum(), iObj.getCarBrand(), iObj.getCarType(), \
		iObj.getCarColor(), iObj.getPsId(), \
		iObj.getRemark(),  \
		iObj.getCommunityId(), iObj.getStartTime(), iObj.getEndTime(), \
		  "102022081507340423");
}

int OwnerCarDAO::update(EditOwnerCarDO uObj)
{
	string sql = "UPDATE `owner_car` SET `car_brand`=?, `car_color`=?, `car_id`=?,`car_num`=?,`car_type`=?,`community_id`=?,`end_time`=?,`member_id`=?,`remark`=?,`start_time`=? WHERE `car_num`=?";
	return sqlSession->executeUpdate(sql, "s%s%s%s%s%s%s%s%s%s%s", uObj.getCarBrand(), uObj.getCarColor(), uObj.getCarId(), uObj.getCarNum(), uObj.getCarType(), uObj.getCommunityId(), uObj.getEndTime(), uObj.getMemberId(), uObj.getRemark(), uObj.getStartTime(), uObj.getCarNum());
}

int OwnerCarDAO::deleteById(std::string Id)
{
	string sql = "DELETE FROM `owner_car` WHERE `car_num`=?";
	return sqlSession->executeUpdate(sql, "s", Id);
}