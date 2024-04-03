#ifndef _ROOMMANAGEDAO_H_
#define _ROOMMANAGEDAO_H_
#include "BaseDAO.h"
#include "./domain/do/RoomManage/C_StatusDO.h"
#include "./domain/do/RoomManage/t_dictDO.h"
#include "./domain/do/RoomManage/FloorAndUnitDO.h"
#include "./domain/do/RoomManage/AddUnitDO.h"
#include "./RoomManageMapper.h"
#include <list>

/*****************
* RoomState的DAO接口
* @Author : Yueyan
* @Time : 2022/10/31 15:53
* ****************
*/
class RoomStateDAO : public BaseDAO
{
public:
	int count();
	std::list<C_StatusDO> selectRoomStateNameAll();
};

/*****************
* RoomType的DAO接口
* @Author : Yueyan
* @Time : 2022/10/31 17:34
* ****************
*/
class RoomTypeDAO : public BaseDAO
{
public:
	int count();
	std::list<t_dictDO> selectRoomTypeAll();
};

/*****************
* QueryFloorAndUnitDAO的接口
* @Author : Yueyan
* @Time : 2022/11/3 17:31
* ****************
*/
class QueryFloorAndUnitDAO : public BaseDAO
{
public:
	int count(FloorAndUnitDO obj);
	std::list<FloorAndUnitDO> getUnitAll(FloorAndUnitDO);
};
/*
* 添加单元
* @Author :niuniu
* @Time : 2020/11/4 10:10
*/
class AddUnitDAO : public BaseDAO
{
public:
	uint64_t insert(AddUnitDO iObj);
};/*
* 删除单元
* @Author :niuniu
* @Time : 2020/11/5 10:20
*/
class RemoveDAO : public BaseDAO
{
public:
	int deleteByUnitNum(std::string unit_num);
};

/*
* 修改单元
* @Author :niuniu
* @Time : 2020/11/5 10:20
*/
class ModifyDAO : public BaseDAO
{
public:
	int update(AddUnitDO uObj);
};


#endif // !_ROOMMANAGEDAO_H_

