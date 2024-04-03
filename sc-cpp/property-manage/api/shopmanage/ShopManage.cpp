#include"stdafx.h"
#include"ShopManage.h"


JsonVO<std::list<ShopStateVo>> ShopManageController::executeQueryShopState()
{
	std::list<ShopStateVo> data;
	
	//测试代码
	ShopStateVo vo;
	vo.setState(1);
	vo.setName(u8"已出售");
	data.push_back(vo);
	//测试代码结束

	JsonVO<std::list<ShopStateVo>> res;
	res.success(data);
	return res;
}

//查询接口
JsonVO<PageVO<ShopListVo>> ShopManageController::executeQueryShopList(ShopManageQuery query)
{
	//query.getShopID();
	//query.getShopNum();
	//query.getShopState();
	PageVO<ShopListVo> data;
	//测试代码
	ShopListVo vo;
	vo.setBuiltArea(72);
	vo.setCoefficient(1);
	vo.setLink("110");
	vo.setCoefficient(1);
	vo.setendTime("2022/10/30");
	vo.setFloorNum(2);
	vo.setOperate("删除");
	vo.setRoomRent(5000);
	std::list<ShopListVo>list;
	list.push_back(vo);
	data.setRows(list);
	//测试代码结束

	JsonVO<PageVO<ShopListVo>> res;
	res.success(data);
	return res; 
}

//添加商铺SAVE接口

JsonVO<uint64_t> ShopManageController::execAddShop(AddShopDTO dto)
{
	JsonVO<uint64_t>result;
	//dto.getBuiltArea();
	uint64_t id = 114514;
	result.success(id);
	return result;
}

//删除商铺接口
JsonVO<long> ShopManageController::execDeleteShop(AddShopDTO dto)
{
	JsonVO<long>result;

	//执行数据删除
	uint64_t id = 114514;
	result.success(id);
	result.setMessage(u8"删除成功！");

	//响应结果
	return result;
}

//楼栋接口
JsonVO<std::list<BuildingVo>> ShopManageController::execQueryBuilding()
{
	std::list<BuildingVo> data;
	data.resize(4);

	//测试
	BuildingVo vo1;
	BuildingVo vo2;
	BuildingVo vo3;
	BuildingVo vo4;
	vo1.setBdName(u8"1栋");
	vo2.setBdName(u8"9栋");
	vo3.setBdName(u8"6栋");
	vo4.setBdName(u8"7栋");
	data.push_back(vo1);
	data.push_back(vo2);
	data.push_back(vo3);
	data.push_back(vo4);

	JsonVO<std::list<BuildingVo>> res;
	res.success(data);
	return res;
}
//修改商铺信息
JsonVO<long> ShopManageController::execModifyShop(AddShopDTO dto)
{
	JsonVO<long>result;

	//执行数据修改
	uint64_t id = 114514;
	result.success(id);
	result.setMessage(u8"修改成功");
	//响应结果
	return result;
}