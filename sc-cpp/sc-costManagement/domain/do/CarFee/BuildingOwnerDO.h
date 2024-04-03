#ifndef _BUILDINGOWNERDO_H_
#define _BUILDINGOWNERDO_H_
#include "../DoInclude.h"

class BuildingOwnerDO
{
private:
	// 业主ID
	CC_SYNTHESIZE(string, owner_id, Owner_id);
	// 业务id
	CC_SYNTHESIZE(string, b_id, B_id);
	// 业主名称
	CC_SYNTHESIZE(string, name, Name);
	// 联系方式
	CC_SYNTHESIZE(string, link, Link);
};

#endif // !_BUILDINGOWNERDO_H_