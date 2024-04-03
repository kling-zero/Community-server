#pragma once
#ifndef _PARKINGVO_H_
#define _PARKINGVO_H_

#include "../../GlobalInclude.h"

/**
 * 停车场
 */

class ParkingVO
{
public:
	BIND_TO_JSON(ParkingVO, num);
	ParkingVO() {
	}
private:
	// 停车场
	CC_SYNTHESIZE(string, num, Num);
};

#endif // !_PARKINGVO_H_
