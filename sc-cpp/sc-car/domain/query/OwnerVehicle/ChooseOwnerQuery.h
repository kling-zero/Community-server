#pragma once
#ifndef _CHOOSEOWNERQUERY_H_
#define _CHOOSEOWNERQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 9:55:38
* 业主车辆-添加-选择业主
*/
class ChooseOwnerQuery : public PageQuery
{
	//社区id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//业主姓名
	CC_SYNTHESIZE(std::string, name, Name);
	//房屋编号
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//未知
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