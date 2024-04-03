#pragma once
#ifndef _ISDEFAULTVO_H_
#define _ISDEFAULTVO_H_
#include"../../GlobalInclude.h"

class IsDefaultVO {

	CC_SYNTHESIZE(int,id,ID);
	CC_SYNTHESIZE(std::string, name, Name);
public:
	BIND_TO_JSON(IsDefaultVO,id,name);

	IsDefaultVO() {
		id = 0;
		name = u8"Ä¬ÈÏ·ÑÓÃ";
	}
};

#endif