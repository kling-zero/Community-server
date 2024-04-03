#ifndef _PARKINGAREADO_H_
#define _PARKINGAREADO_H_
#include "../DoInclude.h"

class ParkingAreaDO
{
private:
	// 业主ID
	CC_SYNTHESIZE(string, owner_id, Owner_id);
	// 业务id
	CC_SYNTHESIZE(string, b_id, B_id);
	// 停车场
	CC_SYNTHESIZE(string, num, Num);
};

#endif // !_PARKINGAREADO_H_