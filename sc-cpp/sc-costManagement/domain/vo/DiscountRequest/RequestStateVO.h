#ifndef _REQUESTSTATE_H_
#define _REQUESTSTATE_H_

#include "../../GlobalInclude.h"

class RequestStateVO
{
	// 状态编号
	CC_SYNTHESIZE(uint64_t, id, Id);
	// 状态描述
	CC_SYNTHESIZE(string, description, Description);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(RequestStateVO, id, description);
	RequestStateVO() {
		description = u8"申请验房";
		id = 0;
	}
};

#endif // !_REQUESTSTATE_H_

