#ifndef  _ADDSHOPDTO_H_
#define  _ADDSHOPDTO_H_
#include"../../GlobalInclude.h"
class AddShopDTO
{
	//商铺编号	
	CC_SYNTHESIZE(std::string, shopId, ShopId);
	//建筑面积
	CC_SYNTHESIZE(double, builtUpArea, BuiltArea);
	//算费系数
	CC_SYNTHESIZE(double, feeCoefficient, Coefficient);
	//楼层数量
	CC_SYNTHESIZE(int, floorNum, FloorNum);
	//室内面积
	CC_SYNTHESIZE(double, roomArea, RoomArea);
	//租金
	CC_SYNTHESIZE(double, roomRent, RoomRent);
	//备注
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
