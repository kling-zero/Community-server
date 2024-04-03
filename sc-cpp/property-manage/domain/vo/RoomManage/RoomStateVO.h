#ifndef _ROOMSTATE_VO_
#define _ROOMSTATE_VO_

#include "../../GlobalInclude.h"

class RoomStateVO
{
	// 状态描述 ("未销售")
	CC_SYNTHESIZE(string, description, Discription);
	// ID (0)
	CC_SYNTHESIZE(int, id, Id);
	// 状态名 ("未销售")
	CC_SYNTHESIZE(string, name, Name);
	// 状态编码 ("2002")
	CC_SYNTHESIZE(string, statusCd, StatusCd);
	
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(RoomStateVO, description, id, name, statusCd);
};

#endif // !_ROOMSTATE_VO_