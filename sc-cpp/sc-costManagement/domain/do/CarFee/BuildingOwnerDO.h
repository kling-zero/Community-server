#ifndef _BUILDINGOWNERDO_H_
#define _BUILDINGOWNERDO_H_
#include "../DoInclude.h"

class BuildingOwnerDO
{
private:
	// ҵ��ID
	CC_SYNTHESIZE(string, owner_id, Owner_id);
	// ҵ��id
	CC_SYNTHESIZE(string, b_id, B_id);
	// ҵ������
	CC_SYNTHESIZE(string, name, Name);
	// ��ϵ��ʽ
	CC_SYNTHESIZE(string, link, Link);
};

#endif // !_BUILDINGOWNERDO_H_