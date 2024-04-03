#ifndef _SHOPMANAGEQUERY_H_
#define _SHOPMANAGEQUERY_H_

/*
	商铺管理查询对象
*/
#include"../PageQuery.h"

class ShopManageQuery :public PageQuery
{
	//商铺编号
	CC_SYNTHESIZE(std::string, shopNum, ShopNum);
	//商铺状态
	CC_SYNTHESIZE(std::string, shopState, ShopState);
	//商铺ID
	CC_SYNTHESIZE(std::string, shopId, ShopID);
public:
	friend void from_json(const json& j, ShopManageQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, shopNum);
		BIND_FROM_TO_NORMAL(j, t, shopState);
		BIND_FROM_TO_NORMAL(j, t, shopId);
	}
};

#endif 