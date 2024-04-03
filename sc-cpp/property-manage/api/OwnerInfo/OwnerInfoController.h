#ifndef _OWNER_INFO_CONTROLLER_
#define _OWNER_INFO_CONTROLLER_

#include "domain/vo/JsonVO.h"
#include "../../domain/vo/PageVO.h"
#include "domain/vo/OwnerInfo/BuildingInfoVO.h"
#include "domain/vo/OwnerInfo/HouseInfoVO.h"
#include "domain/vo/OwnerInfo/OwnerInfoVO.h"
#include "domain/query/OwnerInfo/OwnerInfoQuery.h"
#include "domain/dto/OwnerInfo/OwnerInfoDTO.h"
#include "domain/dto/OwnerInfo/HouseInfoDTO.h"
#include "domain/query/OwnerInfo/BuildingInfoQuery.h"
#include "../../service/OwnerInfo/OwnerInfoService.h"

class OwnerInfoController
{
public:
	CREATE_API_FUN_QUERY(queryOwnerInfo, executeQueryOwnerInfo, OwnerInfoQuery);
	CREATE_API_FUN_QUERY(showDetailedOwnerInfo, executeShowDetailedOwnerInfo, OwnerInfoQuery);
	CREATE_API_FUN_BODY(addOwnerInfo, executeAddOwnerInfo, OwnerInfoDTO);
	CREATE_API_FUN_BODY(modifyOwnerInfo, executeModifyOwnerInfo, OwnerInfoDTO);
	CREATE_API_FUN_BODY(deleteOwnerInfo, executeDeleteOwnerInfo, OwnerInfoDTO);
	CREATE_API_FUN_BODY(unbindHouseInfo, executeUnbindHouseInfo, HouseInfoDTO);
	CREATE_API_FUN_QUERY(queryBuildingInfo, executeQueryBuildingInfo, BuildingInfoQuery);
private:

	//查询业主信息
	JsonVO<PageVO<OwnerInfoVO>> executeQueryOwnerInfo(OwnerInfoQuery query);
	//添加业主
	JsonVO<uint64_t> executeAddOwnerInfo(OwnerInfoDTO body);
	//修改业主
	JsonVO<std::string> executeModifyOwnerInfo(OwnerInfoDTO body);
	//删除业主
	JsonVO<std::string> executeDeleteOwnerInfo(OwnerInfoDTO body);


	//显示业主详细（房屋信息）
	JsonVO<std::list<HouseInfoVO>> executeShowDetailedOwnerInfo(OwnerInfoQuery query);
	//房屋解绑
	JsonVO<int> executeUnbindHouseInfo(HouseInfoDTO body);
	//选择楼（入住房屋）
	JsonVO<PageVO<BuildingInfoVO>> executeQueryBuildingInfo(BuildingInfoQuery query);
};

#endif // !_OWNER_ACCOUNT_CONTROLLER_
