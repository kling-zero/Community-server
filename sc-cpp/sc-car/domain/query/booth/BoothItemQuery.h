/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:00:55
*/
#ifndef _BOOTHITEMQUERY_H_
#define _BOOTHITEMQUERY_H_
#include "../PageQuery.h"
/*
* ��ͤ��ѯ
*/
class BoothItemQuery :public PageQuery
{
	//��ͤ���
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//��ͤ����
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//�Ƿ����
	CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);

public:
	friend void from_json(const json& j, BoothItemQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, boxId);
		BIND_FROM_TO_NORMAL(j, t, boxName);
		BIND_FROM_TO_NORMAL(j, t, tempCarIn);
	}
};


#endif //_BOOTHITEMQUERY_H_