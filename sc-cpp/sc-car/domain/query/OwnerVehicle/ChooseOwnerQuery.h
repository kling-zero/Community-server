#pragma once
#ifndef _CHOOSEOWNERQUERY_H_
#define _CHOOSEOWNERQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 9:55:38
* ҵ������-���-ѡ��ҵ��
*/
class ChooseOwnerQuery : public PageQuery
{
	//����id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//ҵ������
	CC_SYNTHESIZE(std::string, name, Name);
	//���ݱ��
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//δ֪
	CC_SYNTHESIZE(std::string, ownerTypeCd, OwnerTypeCd);

public:
	friend void from_json(const json& j, ChooseOwnerQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, communityId);
		BIND_FROM_TO_NORMAL(j, t, name);
		BIND_FROM_TO_NORMAL(j, t, roomName);
		BIND_FROM_TO_NORMAL(j, t, ownerTypeCd);
	}
};

#endif //_CHOOSEOWNERQUERY_H_