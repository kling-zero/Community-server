#ifndef _SHOPLIST_H_
#define _SHOPLIST_H_

#include"../../GlobalInclude.h"
/*
	������Ϣ
	@Author��niuniu
	@Date:2022/10/19 
*/

class ShopListVo
{	

	//���̱��
	CC_SYNTHESIZE(std::string, shopId, ShopId);
	//�������
	CC_SYNTHESIZE(double,builtUpArea,BuiltArea);
	//����ʱ��
	CC_SYNTHESIZE(std::string,endTime,endTime);
	//���ϵ��
	CC_SYNTHESIZE(double,feeCoefficient, Coefficient);
	//¥������
	CC_SYNTHESIZE(int,floorNum,FloorNum);
	//ҵ����ϵ��ʽ
	CC_SYNTHESIZE(std::string,link,Link);
	//ҵ��/�ⷽ ����
	CC_SYNTHESIZE(std::string,ownerName,OwnerName);
	//�������
	CC_SYNTHESIZE(double,roomArea,RoomArea);
	//���
	CC_SYNTHESIZE(double,roomRent,RoomRent);
	//����ʱ��
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	//����״̬
	CC_SYNTHESIZE(std::string,stateName,StateName);
	//����
	CC_SYNTHESIZE(std::string, operate, Operate);

public:
	BIND_TO_JSON(ShopListVo,shopId,builtUpArea,endTime,feeCoefficient,floorNum,link,ownerName,roomArea,roomRent,startTime,stateName);
};

#endif