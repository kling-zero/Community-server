#ifndef _ROOMMANAGEMAPPER_H_
#define _ROOMMANAGEMAPPER_H_
#include "Mapper.h"
#include "./domain/do/RoomManage/C_StatusDO.h"
#include "./domain/do/RoomManage/t_dictDO.h"

/*****************
* @Author : Yueyan
* @Time : 2022/10/31
* ****************
*/
class RoomStateMapper : public Mapper<C_StatusDO>
{
public:
	C_StatusDO mapper(ResultSet* resultSet) override
	{
		C_StatusDO data;
		data.setId(resultSet->getInt(1));
		data.setStatus_cd(resultSet->getString(2));
		data.setName(resultSet->getString(3));
		data.setDescription(resultSet->getString(4));
		return data;
	}
};

/*****************
* @Author : Yueyan
* @Time : 2022/10/31
* ****************
*/
class RoomTypeMapper : public Mapper<t_dictDO>
{
public:
	t_dictDO mapper(ResultSet* resultSet) override
	{
		t_dictDO data;
		data.setId(resultSet->getInt(1));
		data.setStatus_cd(resultSet->getString(2));
		data.setName(resultSet->getString(3));
		data.setDescription(resultSet->getString(4));
		return data;
	}
};

class FloorAndUnitMapper : public Mapper<FloorAndUnitDO>
{
public:
	FloorAndUnitDO mapper(ResultSet* resultSet) override
	{
		FloorAndUnitDO data;
		data.setFloor_id(resultSet->getString(1));
		data.setFloor_num(resultSet->getString(2));
		data.setUnit_id(resultSet->getString(3));
		data.setUnit_num(resultSet->getString(4));
		data.setLayer_count(resultSet->getInt(5));
		data.setLift(resultSet->getString(6));
		data.setRemark(resultSet->getString(7));
		data.setUnit_area(resultSet->getDouble(8));
		return data;
	}
};

#endif // !_ROOMMANAGEMAPPER_H_