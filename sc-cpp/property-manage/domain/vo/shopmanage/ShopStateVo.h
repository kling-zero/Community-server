#ifndef _SHPOSTATE_H_
#define	_SHPOSTATE_H_
#include"../../GlobalInclude.h"

/*
*	����״̬
	@Author��niuniu
	@Date:2022/10/19
*/

class ShopStateVo
{	
	//����״̬���
	CC_SYNTHESIZE(int, state,State);
	//����״̬����
	CC_SYNTHESIZE(std::string, name, Name);
public:
	BIND_TO_JSON(ShopStateVo, state, name);
};

#endif 