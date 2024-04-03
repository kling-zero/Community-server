#pragma once
#ifndef _OWNER_INFO_QUERY_DO_
#define _OWNER_INFO_QUERY_DO_

#include "../DoInclude.h"
class OwnerInfoQueryDO
{
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(std::string, roomNum, RoomNum);
	CC_SYNTHESIZE(std::string, phoneNum, PhoneNum);
	CC_SYNTHESIZE(std::string, peopleId, PeopleId);
	CC_SYNTHESIZE(std::string, idCard, IdCard);
public:
	OwnerInfoQueryDO()   
	{
		ownerName = "";
		roomNum = "";
		phoneNum = "";
		peopleId = "";
		idCard = "";
	}
};

#endif //__OWNERINFOQUERYDO_H__
