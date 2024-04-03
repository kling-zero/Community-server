#pragma once
#ifndef _CHOOSEPARKINGSPACEQUERY_H_
#define _CHOOSEPARKINGSPACEQUERY_H_

#include "domain/vo/JsonVO.h"
#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/20 18:13:33
* ҵ������-���-ѡ��ͣ����
*/
class ChooseParkQuery : public PageQuery
{
	//����ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//ͣ��λ���
	CC_SYNTHESIZE(std::string, num, Num);
	//ͣ�������
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//���ƺ�
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//��λ״̬
	CC_SYNTHESIZE(std::string, state, State);

public:
	friend void from_json(const json& j, ChooseParkQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, num);
		BIND_FROM_TO_NORMAL(j, t, areaNum);
		BIND_FROM_TO_NORMAL(j, t, carNum);
		BIND_FROM_TO_NORMAL(j, t, state);
	}

};

#endif //_OWNERVEHICLEQUERY_H_