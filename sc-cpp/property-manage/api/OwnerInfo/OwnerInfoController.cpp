#include"stdafx.h"
#include"OwnerInfoController.h"

//��ѯҵ����Ϣ
JsonVO<PageVO<OwnerInfoVO>> OwnerInfoController::executeQueryOwnerInfo(OwnerInfoQuery query)
{
	//����һ��Service
	OwnerInfoService service;
	//��ѯ����
	PageVO<OwnerInfoVO> result = service.listAllOwnerInfo(query);
	//��Ӧ���
	return JsonVO<PageVO<OwnerInfoVO>>(result, RS_SUCCESS);
}

//���ҵ����Ϣ
JsonVO<uint64_t> OwnerInfoController::executeAddOwnerInfo(OwnerInfoDTO body) 
{
	JsonVO<uint64_t> result;
	OwnerInfoService service;
	//ִ����������
	uint64_t id = service.AddOwnerInfo(body);
	if (id > 0) {
		result.success(id);
	}
	else {
		result.fail(id);
	}
	//��Ӧ���
	return result;
}

//�޸�ҵ����Ϣ
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

//ɾ��ҵ����Ϣ
JsonVO<std::string> OwnerInfoController::executeDeleteOwnerInfo(OwnerInfoDTO body)
{
	OwnerInfoService service;
	JsonVO<std::string> result;
	//ִ������ɾ��
	if (service.DeleteOwnerInfo(body.getPeopleId())) {
		result.success(body.getPeopleId());
	}
	else {
		result.fail(body.getPeopleId());
	}
	//��Ӧ���
	return result;
}

//չʾҵ����ϸ��Ϣ
JsonVO<std::list<HouseInfoVO>> OwnerInfoController::executeShowDetailedOwnerInfo(OwnerInfoQuery query)
{
	HouseInfoVO houseInfovo;
	houseInfovo.setFloor(u8"5¥");
	houseInfovo.setHouseId("12345");
	houseInfovo.setHouseSerial("1-4-213");
	houseInfovo.setHouseArea(80);
	houseInfovo.setHouseType("10");
	houseInfovo.setRoomNum(2);
	houseInfovo.setRefinedDecoration(u8"��");
	std::list<HouseInfoVO> list;
	list.push_back(houseInfovo);
	JsonVO<std::list<HouseInfoVO>> res;
	res.success(list);
	return res;
}

//���ݽ��
JsonVO<int> OwnerInfoController::executeUnbindHouseInfo(HouseInfoDTO body)
{
	std::cout << body.getHouseId() << endl;
	JsonVO<int> res;
	res.success(1);
	res.setMessage(u8"���ɹ�");
	return res;
}

//��ѯ¥����Ϣ
JsonVO<PageVO<BuildingInfoVO>> OwnerInfoController::executeQueryBuildingInfo(BuildingInfoQuery query)
{
	BuildingInfoVO buildingInfovo;
	buildingInfovo.setBuildingId("12334");
	buildingInfovo.setBuildingName(u8"7��¥");
	buildingInfovo.setBuildingNum(7);
	buildingInfovo.setRemark("��ס����");
	std::list<BuildingInfoVO> list;
	list.push_back(buildingInfovo);
	PageVO<BuildingInfoVO> data;
	data.setRows(list);
	data.setTotal(125);
	JsonVO<PageVO<BuildingInfoVO>> res;
	res.success(data);
	return res;
}