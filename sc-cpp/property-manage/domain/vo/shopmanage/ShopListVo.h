#ifndef _SHOPLIST_H_
#define _SHOPLIST_H_

#include"../../GlobalInclude.h"
/*
	商铺信息
	@Author：niuniu
	@Date:2022/10/19 
*/

class ShopListVo
{	

	//商铺编号
	CC_SYNTHESIZE(std::string, shopId, ShopId);
	//建筑面积
	CC_SYNTHESIZE(double,builtUpArea,BuiltArea);
	//截租时间
	CC_SYNTHESIZE(std::string,endTime,endTime);
	//算费系数
	CC_SYNTHESIZE(double,feeCoefficient, Coefficient);
	//楼层数量
	CC_SYNTHESIZE(int,floorNum,FloorNum);
	//业主联系方式
	CC_SYNTHESIZE(std::string,link,Link);
	//业主/租方 名称
	CC_SYNTHESIZE(std::string,ownerName,OwnerName);
	//室内面积
	CC_SYNTHESIZE(double,roomArea,RoomArea);
	//租金
	CC_SYNTHESIZE(double,roomRent,RoomRent);
	//起租时间
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	//商铺状态
	CC_SYNTHESIZE(std::string,stateName,StateName);
	//操作
	CC_SYNTHESIZE(std::string, operate, Operate);

public:
	BIND_TO_JSON(ShopListVo,shopId,builtUpArea,endTime,feeCoefficient,floorNum,link,ownerName,roomArea,roomRent,startTime,stateName);
};

#endif