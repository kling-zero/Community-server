#ifndef  _ADDSHOPDTO_H_
#define  _ADDSHOPDTO_H_
#include"../../GlobalInclude.h"
class AddShopDTO
{
	//���̱��	
	CC_SYNTHESIZE(std::string, shopId, ShopId);
	//�������
	CC_SYNTHESIZE(double, builtUpArea, BuiltArea);
	//���ϵ��
	CC_SYNTHESIZE(double, feeCoefficient, Coefficient);
	//¥������
	CC_SYNTHESIZE(int, floorNum, FloorNum);
	//�������
	CC_SYNTHESIZE(double, roomArea, RoomArea);
	//���
	CC_SYNTHESIZE(double, roomRent, RoomRent);
	//��ע
	CC_SYNTHESIZE(std::string, remark, Remark);
private:
	friend void from_json(const json& j, AddShopDTO& t) {
		BIND_FROM_TO_NORMAL(j, t, shopId);
		BIND_FROM_TO_D(j, t, builtUpArea);
		BIND_FROM_TO_D(j, t, feeCoefficient);
		BIND_FROM_TO_I(j, t, floorNum);
		BIND_FROM_TO_D(j, t, roomArea);
		BIND_FROM_TO_D(j, t, roomRent);
		BIND_FROM_TO_NORMAL(j, t, remark);
	}
};
#endif // ! _ADDSHOPDTO_H_
