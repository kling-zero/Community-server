#ifndef _PARKINGAREADO_H_
#define _PARKINGAREADO_H_
#include "../DoInclude.h"

class ParkingAreaDO
{
private:
	// ҵ��ID
	CC_SYNTHESIZE(string, owner_id, Owner_id);
	// ҵ��id
	CC_SYNTHESIZE(string, b_id, B_id);
	// ͣ����
	CC_SYNTHESIZE(string, num, Num);
};

#endif // !_PARKINGAREADO_H_