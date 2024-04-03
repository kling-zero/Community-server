#ifndef _CARFEE_LIST_VO_
#define _CARFEE_LIST_VO_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

/**
 * 车辆收费
 */
class CarFeeListVO:public PageQuery
{
	// 车牌号
	CC_SYNTHESIZE(string, carNum, CarNum);
	// 停车场
	CC_SYNTHESIZE(string, areaNum, AreaNum);
	// 车位
	CC_SYNTHESIZE(string, num, Num);
	// 业主名称
	CC_SYNTHESIZE(string, ownerName, OwnerName);
	// 联系方式
	CC_SYNTHESIZE(string, link, Link);
	// 车位状态
	CC_SYNTHESIZE(string, stateName, StateName);

	// 业主ID
	CC_SYNTHESIZE(string, ownerId, OwnerID);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(CarFeeListVO, carNum, areaNum, num, ownerName, link, stateName, ownerId);
	//CarFeeListVO() {
	//	carNum = u8"川Gerins";
	//	areaNum = u8"11";
	//	num = u8"11";
	//	ownerName = u8"11";
	//	link = u8"18985136859";
	//	stateName = u8"正常";
	//	ownerId = u8"772022101726638968";
	//	pageIndex = 1;
	//	pageSize = 10;
	//}
};

#endif // !_CARFEE_LIST_VO_