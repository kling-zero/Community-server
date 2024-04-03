#ifndef _SHOPMANAGE_H_
#define _SHOPMANAGE_H_
#include"domain/vo/JsonVO.h"
#include <domain/vo/shopmanage/ShopStateVo.h>
#include"api/ApiHelper.h"
#include <domain/vo/shopmanage/ShopListVo.h>
#include"domain/vo/PageVO.h"
#include <domain/query/shopmanage/ShopManageQuery.h>
#include <domain/dto/shopmanage/AddShopDTO.h>
#include <domain/vo/shopmanage/BuildingVo.h>
/*
	商铺管理接口
*/
class ShopManageController
{
public:
	//商铺状态接口
	CREATE_API_FUN_QUERY3(queryShopState, executeQueryShopState);
	//查询
	CREATE_API_FUN_QUERY(queryShopList,executeQueryShopList, ShopManageQuery);
	//添加商铺接口
	CREATE_API_FUN_BODY(AddShop, execAddShop,AddShopDTO);
	//删除商铺接口
	CREATE_API_FUN_BODY(DeleteShop, execDeleteShop, AddShopDTO);
	//楼栋接口
	CREATE_API_FUN_QUERY3(queryBuilding, execQueryBuilding);
	//修改商铺信息
	CREATE_API_FUN_BODY(ModifyShop, execModifyShop, AddShopDTO);

private:
	//商铺状态接口
	JsonVO<std::list<ShopStateVo>> executeQueryShopState();
	//查询接口
	JsonVO<PageVO<ShopListVo>> executeQueryShopList(ShopManageQuery query);
	//添加商铺SAVE接口 
	JsonVO<uint64_t> execAddShop(AddShopDTO dto);
	//删除商铺
	JsonVO<long> execDeleteShop(AddShopDTO dto);
	//楼栋接口
	JsonVO<std::list<BuildingVo>> execQueryBuilding();
	//修改商铺信息接口
	JsonVO<long> execModifyShop(AddShopDTO dto);
};

#endif