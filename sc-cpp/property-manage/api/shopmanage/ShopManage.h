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
	���̹���ӿ�
*/
class ShopManageController
{
public:
	//����״̬�ӿ�
	CREATE_API_FUN_QUERY3(queryShopState, executeQueryShopState);
	//��ѯ
	CREATE_API_FUN_QUERY(queryShopList,executeQueryShopList, ShopManageQuery);
	//������̽ӿ�
	CREATE_API_FUN_BODY(AddShop, execAddShop,AddShopDTO);
	//ɾ�����̽ӿ�
	CREATE_API_FUN_BODY(DeleteShop, execDeleteShop, AddShopDTO);
	//¥���ӿ�
	CREATE_API_FUN_QUERY3(queryBuilding, execQueryBuilding);
	//�޸�������Ϣ
	CREATE_API_FUN_BODY(ModifyShop, execModifyShop, AddShopDTO);

private:
	//����״̬�ӿ�
	JsonVO<std::list<ShopStateVo>> executeQueryShopState();
	//��ѯ�ӿ�
	JsonVO<PageVO<ShopListVo>> executeQueryShopList(ShopManageQuery query);
	//�������SAVE�ӿ� 
	JsonVO<uint64_t> execAddShop(AddShopDTO dto);
	//ɾ������
	JsonVO<long> execDeleteShop(AddShopDTO dto);
	//¥���ӿ�
	JsonVO<std::list<BuildingVo>> execQueryBuilding();
	//�޸�������Ϣ�ӿ�
	JsonVO<long> execModifyShop(AddShopDTO dto);
};

#endif