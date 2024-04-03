#ifndef _OWNERVEHICLEQUERY_H_
#define _OWNERVEHICLEQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 16:01:39
* 业主车辆-车辆信息查询
*/
class CarInfoQuery : public PageQuery
{
	//未知
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//车牌号
	CC_SYNTHESIZE(std::string, carNumLike, CarNumLike);
	//车位编号
	CC_SYNTHESIZE(std::string, num, Num);
	//车位状态
	CC_SYNTHESIZE(std::string, valid, Valid);
	//车辆类型
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
public:
	friend void from_json(const json& j, CarInfoQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, carNum);
		BIND_FROM_TO_NORMAL(j, t, carNumLike);
		BIND_FROM_TO_NORMAL(j, t, num);
		BIND_FROM_TO_NORMAL(j, t, valid);
		BIND_FROM_TO_NORMAL(j, t, carTypeCd);
	}
	
};

#endif //_OWNERVEHICLEQUERY_H_