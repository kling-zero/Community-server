#ifndef _OWNERITEMDO_H_
#define _OWNERITEMDO_H_

#include "../DoInclude.h"

class OwnerItemDo
{

	CC_SYNTHESIZE(string, name, OwnerName);
	CC_SYNTHESIZE(string, sex, Sex);
	CC_SYNTHESIZE(int, age, Age);
	CC_SYNTHESIZE(string, id_card, IdCard);
	CC_SYNTHESIZE(string, link, Link);
	CC_SYNTHESIZE(string, createStaff, CreateStaff);
	CC_SYNTHESIZE(string, roomId, RoomId);
public:
	OwnerItemDo() {
		name = "";
		sex = "";
		age = 0;
		id_card = "";
		link = "";
		createStaff = "";
		roomId = "";
	}
};
#endif // !_OWNERITEMDO_H_

