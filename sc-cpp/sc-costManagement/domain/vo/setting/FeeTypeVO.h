#pragma once
#ifndef _FEETYPEVO_H__
#define _FEETYPEVO_H__
#include"../../GlobalInclude.h"

/**
*费用类型
*/
class FeeTypeVO {

	CC_SYNTHESIZE(int, id, ID);
	CC_SYNTHESIZE(string, description, Description);
public:
	FeeTypeVO() {
		id = 1;
		description = u8"押金";
	}
	BIND_TO_JSON(FeeTypeVO, id, description);
};

#endif