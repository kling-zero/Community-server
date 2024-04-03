#pragma once
#ifndef _FEENAMEVO_H_
#define _FEENAMEVO_H_
#include"../../GlobalInclude.h"
class FeeNameVO {
	CC_SYNTHESIZE(string, feeName, FeeName);

public:
	FeeNameVO() {
		feeName = u8"Å¯Æø·Ñ";
	}
	BIND_TO_JSON(FeeNameVO, feeName);

};

#endif
