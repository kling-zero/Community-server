#ifndef _CHARGERANGEDO_H_
#define _CHARGERANGEDO_H_

#include "../DoInclude.h"

/**
 * 收费范围
 */

class ChargeRangeDO
{

public:
	// 类型ID
	CC_SYNTHESIZE(long, id, Id);
	// 类型描述
	CC_SYNTHESIZE(string, description, Description);
};

#endif // !_CHARGERANGEDO_H_
#pragma once
