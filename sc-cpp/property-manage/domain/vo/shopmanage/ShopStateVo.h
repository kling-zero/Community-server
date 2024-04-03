#ifndef _SHPOSTATE_H_
#define	_SHPOSTATE_H_
#include"../../GlobalInclude.h"

/*
*	ÉÌÆÌ×´Ì¬
	@Author£ºniuniu
	@Date:2022/10/19
*/

class ShopStateVo
{	
	//ÉÌÆÌ×´Ì¬±àºÅ
	CC_SYNTHESIZE(int, state,State);
	//ÉÌÆÌ×´Ì¬Ãû³Æ
	CC_SYNTHESIZE(std::string, name, Name);
public:
	BIND_TO_JSON(ShopStateVo, state, name);
};

#endif 