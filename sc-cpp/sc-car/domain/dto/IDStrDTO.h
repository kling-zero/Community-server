#ifndef _IDSTR_H_
#define _IDSTR_H_

#include "../GlobalInclude.h"

class IDStr
{
	// 编号
	CC_SYNTHESIZE(std::string, idStr, IdStr);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, IDStr& t) {
		BIND_FROM_TO_L(j, t, idStr);
	}
};
#endif // _IDDTO_H_
