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

	//��ѯҵ����Ϣ
	JsonVO<PageVO<OwnerInfoVO>> executeQueryOwnerInfo(OwnerInfoQuery query);
	//���ҵ��
	JsonVO<uint64_t> executeAddOwnerInfo(OwnerInfoDTO body);
	//�޸�ҵ��
	JsonVO<std::string> executeModifyOwnerInfo(OwnerInfoDTO body);
	//ɾ��ҵ��
	JsonVO<std::string> executeDeleteOwnerInfo(OwnerInfoDTO body);


	//��ʾҵ����ϸ��������Ϣ��
	JsonVO<std::list<HouseInfoVO>> executeShowDetailedOwnerInfo(OwnerInfoQuery query);
	//���ݽ��
	JsonVO<int> executeUnbindHouseInfo(HouseInfoDTO body);
	//ѡ��¥����ס���ݣ�
	JsonVO<PageVO<BuildingInfoVO>> executeQueryBuildingInfo(BuildingInfoQuery query);
};

#endif // !_OWNER_ACCOUNT_CONTROLLER_
