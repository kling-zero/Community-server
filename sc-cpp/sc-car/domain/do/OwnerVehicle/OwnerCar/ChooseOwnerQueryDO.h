#ifndef _CHOOSEOWNERQUERYDO_H_
#define _CHOOSEOWNERQUERYDO_H_

#include "../../DoInclude.h"


class ChooseOwnerQueryDO
{
	// ����id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//ҵ������
	CC_SYNTHESIZE(std::string, name, Name);
	//���ݱ��
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//δ֪
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
