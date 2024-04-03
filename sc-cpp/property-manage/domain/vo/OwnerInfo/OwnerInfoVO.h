#pragma once
#ifndef _OWNER_INFO_VO_
#define _OWNER_INFO_VO_

#include "../../GlobalInclude.h"

//业主信息
class OwnerInfoVO
{
	CC_SYNTHESIZE(std::string, peopleId, PeopleId);
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(int, ownerGender, OwnerGender);
	CC_SYNTHESIZE(int, ownerAge, OwnerAge);
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	CC_SYNTHESIZE(std::string, phoneNum, PhoneNum);
	CC_SYNTHESIZE(std::string, createStaff, CreateStaff);
	CC_SYNTHESIZE(std::string, entranceGuardkey, EntranceGuardkey);
	CC_SYNTHESIZE(std::string, qqNum,QqNum);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(OwnerInfoVO,
		peopleId,
		ownerName,
		ownerGender,
		ownerAge,
		idCard,
		phoneNum,
		createStaff,
		entranceGuardkey,
		qqNum);
};

#endif