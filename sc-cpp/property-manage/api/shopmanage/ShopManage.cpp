#include"stdafx.h"
#include"ShopManage.h"


JsonVO<std::list<ShopStateVo>> ShopManageController::executeQueryShopState()
{
	std::list<ShopStateVo> data;
	
	//���Դ���
	ShopStateVo vo;
	vo.setState(1);
	vo.setName(u8"�ѳ���");
	data.push_back(vo);
	//���Դ������

	JsonVO<std::list<ShopStateVo>> res;
	res.success(data);
	return res;
}

//��ѯ�ӿ�
JsonVO<PageVO<ShopListVo>> ShopManageController::executeQueryShopList(ShopManageQuery query)
{
	//query.getShopID();
	//query.getShopNum();
	//query.getShopState();
	PageVO<ShopListVo> data;
	//���Դ���
	ShopListVo vo;
	vo.setBuiltArea(72);
	vo.setCoefficient(1);
	vo.setLink("110");
	vo.setCoefficient(1);
	vo.setendTime("2022/10/30");
	vo.setFloorNum(2);
	vo.setOperate("ɾ��");
	vo.setRoomRent(5000);
	std::list<ShopListVo>list;
	list.push_back(vo);
	data.setRows(list);
	//���Դ������

	JsonVO<PageVO<ShopListVo>> res;
	res.success(data);
	return res; 
}

//�������SAVE�ӿ�

JsonVO<uint64_t> ShopManageController::execAddShop(AddShopDTO dto)
{
	JsonVO<uint64_t>result;
	//dto.getBuiltArea();
	uint64_t id = 114514;
	result.success(id);
	return result;
}

//ɾ�����̽ӿ�
JsonVO<long> ShopManageController::execDeleteShop(AddShopDTO dto)
{
	JsonVO<long>result;

	//ִ������ɾ��
	uint64_t id = 114514;
	result.success(id);
	result.setMessage(u8"ɾ���ɹ���");

	//��Ӧ���
	return result;
}

//¥���ӿ�
JsonVO<std::list<BuildingVo>> ShopManageController::execQueryBuilding()
{
	std::list<BuildingVo> data;
	data.resize(4);

	//����
	BuildingVo vo1;
	BuildingVo vo2;
	BuildingVo vo3;
	BuildingVo vo4;
	vo1.setBdName(u8"1��");
	vo2.setBdName(u8"9��");
	vo3.setBdName(u8"6��");
	vo4.setBdName(u8"7��");
	data.push_back(vo1);
	data.push_back(vo2);
	data.push_back(vo3);
	data.push_back(vo4);

	JsonVO<std::list<BuildingVo>> res;
	res.success(data);
	return res;
}
//�޸�������Ϣ
JsonVO<long> ShopManageController::execModifyShop(AddShopDTO dto)
{
	JsonVO<long>result;

	//ִ�������޸�
	uint64_t id = 114514;
	result.success(id);
	result.setMessage(u8"�޸ĳɹ�");
	//��Ӧ���
	return result;
}