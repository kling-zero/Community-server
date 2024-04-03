#pragma once
#ifndef _FEEFLAGVO_H_
#define _FEEFLAGVO_H_
#include"../../GlobalInclude.h"

class FeeFlagVO {
	CC_SYNTHESIZE(int,id,ID);
	CC_SYNTHESIZE(std::string, name, Name);

public:
	BIND_TO_JSON(FeeFlagVO, id, name);
	FeeFlagVO() {
		id = 0;
		name = u8"周期性费用";
	}
};

#endif // !_FEEFLAGVO_H_
