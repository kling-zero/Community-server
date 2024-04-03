#ifndef _CHOOSEOWNERQUERYDO_H_
#define _CHOOSEOWNERQUERYDO_H_

#include "../../DoInclude.h"


class ChooseOwnerQueryDO
{
	// 社区id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//业主姓名
	CC_SYNTHESIZE(std::string, name, Name);
	//房屋编号
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//未知
	CC_SYNTHESIZE(std::string, ownerTypeCd, OwnerTypeCd);

public:
	ChooseOwnerQueryDO(){
		std::string  communityId = "";
		std::string  name = "";
		std::string  roomName = "";
		std::string  ownerTypeCd = "";
	}
};

#endif //_CHOOSEOWNERQUERYDO_H_
