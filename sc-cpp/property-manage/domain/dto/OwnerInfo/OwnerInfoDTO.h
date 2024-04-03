#pragma once
#ifndef _OWNER_INFO_DTO_
#define _OWNER_INFO_DTO_


#include "../../GlobalInclude.h"
/*
* ����޸�ҵ����ϢDTO
*/
class OwnerInfoDTO
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
	//��JSONת������
	friend void from_json(const json& j, OwnerInfoDTO& t) {
		BIND_FROM_TO_NORMAL(j, t, ownerName);
		BIND_FROM_TO_NORMAL(j, t, peopleId);
		BIND_FROM_TO_I(j, t, ownerGender);
		BIND_FROM_TO_I(j, t, ownerAge);
		BIND_FROM_TO_NORMAL(j, t, idCard);
		BIND_FROM_TO_NORMAL(j, t, phoneNum);
		BIND_FROM_TO_NORMAL(j, t, creatStaff);
		BIND_FROM_TO_NORMAL(j, t, entranceGuardkey);
		BIND_FROM_TO_NORMAL(j, t, remark);
		BIND_FROM_TO_NORMAL(j, t, qqNum);
	}
};
#endif // OwnerInfoDTO