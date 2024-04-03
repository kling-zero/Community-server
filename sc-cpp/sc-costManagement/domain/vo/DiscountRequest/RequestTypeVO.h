#ifndef _REQUESTTYPE_H_
#define _REQUESTTYPE_H_

#include "../../GlobalInclude.h"

class RequestTypeVO
{
	// 类型编号
	CC_SYNTHESIZE(uint64_t, id, Id);
	// 类型名称
	CC_SYNTHESIZE(string, name, Name);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(RequestTypeVO, id, name);
	RequestTypeVO() {
		name = u8"租金优惠";
		id = 0;
	}
};

#endif // !_REQUESTTYPE_H_

