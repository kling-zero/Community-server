#include"stdafx.h"
#include"OwnerInfoController.h"

//查询业主信息
JsonVO<PageVO<OwnerInfoVO>> OwnerInfoController::executeQueryOwnerInfo(OwnerInfoQuery query)
{
	//定义一个Service
	OwnerInfoService service;
	//查询数据
	PageVO<OwnerInfoVO> result = service.listAllOwnerInfo(query);
	//响应结果
	return JsonVO<PageVO<OwnerInfoVO>>(result, RS_SUCCESS);
}

//添加业主信息
JsonVO<uint64_t> OwnerInfoController::executeAddOwnerInfo(OwnerInfoDTO body) 
{
	JsonVO<uint64_t> result;
	OwnerInfoService service;
	//执行数据新增
	uint64_t id = service.AddOwnerInfo(body);
	if (id > 0) {
		result.success(id);
	}
	else {
		result.fail(id);
	}
	//响应结果
	return result;
}

//修改业主信息
JsonVO<std::string> OwnerInfoController::executeModifyOwnerInfo(OwnerInfoDTO body)
{
	OwnerInfoService service;
	JsonVO<std::string> result;
	if (service.ModifyOwnerInfo(body)) {
		result.success(body.getPeopleId());
	}
	else {
		result.fail(body.getPeopleId());
	}
	return result;
}

//删除业主信息
JsonVO<std::string> OwnerInfoController::executeDeleteOwnerInfo(OwnerInfoDTO body)
{
	OwnerInfoService service;
	JsonVO<std::string> result;
	//执行数据删除
	if (service.DeleteOwnerInfo(body.getPeopleId())) {
		result.success(body.getPeopleId());
	}
	else {
		result.fail(body.getPeopleId());
	}
	//响应结果
	return result;
}

//展示业主详细信息
JsonVO<std::list<HouseInfoVO>> OwnerInfoController::executeShowDetailedOwnerInfo(OwnerInfoQuery query)
{
	HouseInfoVO houseInfovo;
	houseInfovo.setFloor(u8"5楼");
	houseInfovo.setHouseId("12345");
	houseInfovo.setHouseSerial("1-4-213");
	houseInfovo.setHouseArea(80);
	houseInfovo.setHouseType("10");
	houseInfovo.setRoomNum(2);
	houseInfovo.setRefinedDecoration(u8"是");
	std::list<HouseInfoVO> list;
	list.push_back(houseInfovo);
	JsonVO<std::list<HouseInfoVO>> res;
	res.success(list);
	return res;
}

//房屋解绑
JsonVO<int> OwnerInfoController::executeUnbindHouseInfo(HouseInfoDTO body)
{
	std::cout << body.getHouseId() << endl;
	JsonVO<int> res;
	res.success(1);
	res.setMessage(u8"解绑成功");
	return res;
}

//查询楼栋信息
JsonVO<PageVO<BuildingInfoVO>> OwnerInfoController::executeQueryBuildingInfo(BuildingInfoQuery query)
{
	BuildingInfoVO buildingInfovo;
	buildingInfovo.setBuildingId("12334");
	buildingInfovo.setBuildingName(u8"7号楼");
	buildingInfovo.setBuildingNum(7);
	buildingInfovo.setRemark("入住房屋");
	std::list<BuildingInfoVO> list;
	list.push_back(buildingInfovo);
	PageVO<BuildingInfoVO> data;
	data.setRows(list);
	data.setTotal(125);
	JsonVO<PageVO<BuildingInfoVO>> res;
	res.success(data);
	return res;
}