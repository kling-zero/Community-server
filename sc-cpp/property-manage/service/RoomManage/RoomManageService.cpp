#include "stdafx.h"
#include "RoomManageService.h"
#include "./dao/RoomManage/RoomManageDAO.h"
/*
* ***********
* 访问RoomState接口
* @Author : Yueyan
* @Time : 2020/10/31 11:12
* ***********
*/
std::list<RoomStateVO> RoomManageService::getRoomState() {
	//构建返回对象
	std::list<RoomStateVO> data;
	std::list<C_StatusDO> list;
	RoomStateDAO roomStateDAO;
	list = roomStateDAO.selectRoomStateNameAll();
	for (auto& it : list) {
		RoomStateVO temp;
		temp.setId(it.getId());
		temp.setStatusCd(it.getStatus_cd());
		temp.setName(it.getName());
		temp.setDiscription(it.getDescription());
		data.push_back(temp);
	}
	return data;
}

/*
* ***********
* 访问RoomType接口
* @Author : Yueyan
* @Time : 2020/10/31 17:30
* ***********
*/
std::list<RoomTypeVO> RoomManageService::getRoomType() {
	//构建返回对象
	std::list<RoomTypeVO> data;
	std::list<t_dictDO> list;
	RoomTypeDAO roomTypeDAO;
	list = roomTypeDAO.selectRoomTypeAll();
	for (auto& it : list) {
		RoomTypeVO temp;
		temp.setId(it.getId());
		temp.setStatusCd(it.getStatus_cd());
		temp.setName(it.getName());
		temp.setDiscription(it.getDescription());
		data.push_back(temp);
	}
	return data;
}

/*
* 直接返回FloorAndUnitVO对象
**/
std::list<FloorAndUnitVO> RoomManageService::listFloorAndUnit(FloorAndUnitQuery query) {
	// 创建返回对象
	std::list<FloorAndUnitVO> data;
	QueryFloorAndUnitDAO dao;

	FloorAndUnitDO obj;
	obj.setCommunity_id(query.getCommunityId());

	int count = dao.count(obj);
	// if (count <= 0)
	// {
	// 	return data;
	// }

	std::list<FloorAndUnitDO> result = dao.getUnitAll(obj);

	for (FloorAndUnitDO sub : result)
	{
		FloorAndUnitVO vo;
		vo.setFloorId(sub.getFloor_id());
		vo.setFloorNum(sub.getFloor_num());
		vo.setLayerCount(sub.getLayer_count());
		vo.setLift(sub.getLift());
		vo.setRemark(sub.getRemark());
		vo.setUnitArea(sub.getUnit_area());
		vo.setUnitId(sub.getUnit_id());
		vo.setUnitNum(sub.getUnit_num());
		data.push_back(vo);
	}
	return data;
}
/*
* 添加单元
* @Author :niuniu
* @Time : 2020/11/4 10:10
*/
uint64_t RoomManageService::saveData(AddUnitDTO dto)
{
	//组装数据
	AddUnitDO data;
	data.setUnitNum(dto.getUnitNum());
	data.setLayerCount(dto.getLayerCount());
	data.setUnitArea(dto.getUnitArea());
	data.setLift(dto.getLift());
	data.setRemark(dto.getRemark());
	//执行数据添加
	AddUnitDAO dao;
	return dao.insert(data);
}
/*
* 删除单元	
* @Author :niuniu
* @Time : 2020/11/5 10:19
*/
bool RoomManageService::removeData(std::string unit_num)
{
	RemoveDAO dao;
	return dao.deleteByUnitNum(unit_num) == 1;
}

/*
* 修改单元
* @Author :niuniu
* @Time : 2020/11/5 20:44
*/
bool RoomManageService::updateData(AddUnitDTO dto)
{
	//组装传输数据
	AddUnitDO data;
	data.setUnitNum(dto.getUnitNum());
	data.setLayerCount(dto.getLayerCount());
	data.setUnitArea(dto.getUnitArea());
	data.setLift(dto.getLift());
	data.setRemark(dto.getRemark());
	//执行数据修改
	ModifyDAO dao;
	return dao.update(data) == 1;
}