#ifndef _UPDATE_DEPART_MORE_DTO_
#define _UPDATE_DEPART_MORE_DTO_

#include "AddDepartDTO.h"

class AddDepartMoreDTO
{
	// 编号
	CC_SYNTHESIZE(int, id, Id);
	// 其他信息
	CC_SYNTHESIZE(list<AddDepartDTO>, other, Other);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, AddDepartMoreDTO& t) {
		BIND_FROM_TO_I(j, t, id);
		BIND_FROM_TO_OBJ(j, t, other, list<AddDepartDTO>);
	};
};

#endif // !_UPDATE_DEPART_DTO_