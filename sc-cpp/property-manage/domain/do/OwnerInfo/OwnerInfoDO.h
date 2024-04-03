#pragma once
#ifndef _OWNER_INFO_DO_
#define _OWNER_INFO_DO_


#include "../DoInclude.h"
/*
* 业主信息DO
*/
class OwnerInfoDO
{
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(std::string, peopleId, PeopleId);
	CC_SYNTHESIZE(int, ownerGender, OwnerGender);
	CC_SYNTHESIZE(int, ownerAge, OwnerAge);
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	CC_SYNTHESIZE(std::string, phoneNum, PhoneNum);
	CC_SYNTHESIZE(std::string, creatStaff, CreatStaff);
	CC_SYNTHESIZE(std::string, entranceGuardkey, EntranceGuardkey);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, qqNum, QqNum);
public:
	OwnerInfoDO()
	{
		ownerName = "";
		peopleId = "";
		ownerGender = 0;
		ownerAge = 1;
		idCard = "";
		phoneNum = "";
		creatStaff = "";
		entranceGuardkey = 1;
		remark = "";
		qqNum = "";
	}
};
#endif //_OWNERINFODO_H_