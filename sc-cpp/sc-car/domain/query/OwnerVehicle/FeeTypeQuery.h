#pragma once
#ifndef _FEETYPEQUERY_H_
#define _FEETYPEQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"


/**
* @Anthor: Panda
* @Date: 2022/10/22 11:33:11
* ҵ������-����-��������-��������
*/
class FeeTypeQuery
{
	//����ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//�������ͱ��
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	//δ֪
	CC_SYNTHESIZE(std::string, isDefault, IsDefault);
	//δ֪
	CC_SYNTHESIZE(std::string, valid, Valid);
public:
	friend void from_json(const json & j, FeeTypeQuery& t) {
		BIND_FROM_TO_NORMAL(j, t, communityId);
		BIND_FROM_TO_NORMAL(j, t, feeTypeCd);
		BIND_FROM_TO_NORMAL(j, t, isDefault);
		BIND_FROM_TO_NORMAL(j, t, valid);
	}
};

#endif //_FEETYPEQUERY_H_