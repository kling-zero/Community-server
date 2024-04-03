#ifndef _SHOPMANAGEQUERY_H_
#define _SHOPMANAGEQUERY_H_

/*
	���̹����ѯ����
*/
#include"../PageQuery.h"

class ShopManageQuery :public PageQuery
{
	//���̱��
	CC_SYNTHESIZE(std::string, shopNum, ShopNum);
	//����״̬
	CC_SYNTHESIZE(std::string, shopState, ShopState);
	//����ID
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