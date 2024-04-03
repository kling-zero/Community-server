#pragma once
#ifndef _BILLTYPEVO_H_
#define _BILLTYPEVO_H_
#include"../../GlobalInclude.h"
class BillTypeVO {
	CC_SYNTHESIZE(int,id,ID);
	CC_SYNTHESIZE(std::string, name, Name);

public:
	BIND_TO_JSON(BillTypeVO, id, name);

	BillTypeVO() {
		id = 0;
		name = u8"Ã¿ÔÂ1ÈÕ";
	}
};

#endif // !_BILLTYPEVO_H_
