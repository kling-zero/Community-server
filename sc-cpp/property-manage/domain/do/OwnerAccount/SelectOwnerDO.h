#pragma once
#ifndef _SELECT_OWNER_DO_
#define _SELECT_OWNER_DO_

#include "../DoInclude.h"

class SelectOwnerDO
{
	CC_SYNTHESIZE(int, age, Age);
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	CC_SYNTHESIZE(std::string, link, Link);
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	CC_SYNTHESIZE(std::string, name, Name);
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	CC_SYNTHESIZE(std::string, ownerTypeCd, OwnerTypeCd);
	CC_SYNTHESIZE(std::string, ownerTypeName, OwnerTypeName);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, sex, Sex);
	CC_SYNTHESIZE(std::string, userName, UserName);
public:
	SelectOwnerDO() {
		age = 0;
		createTime = "";
		idCard = "";
		link = "";
		memberId = "";
		name = "";
		ownerId = "";
		ownerTypeCd = "";
		ownerTypeName = "";
		remark = "";
		sex = "";
		userName = "";
	}
};

#endif //__SELECTOWNERDO_H__