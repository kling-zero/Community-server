#ifndef _UPDATE_DEPART_DTO_
#define _UPDATE_DEPART_DTO_

#include "../../../GlobalInclude.h"

class AddDepartDTO
{
	// 名称
	CC_SYNTHESIZE(string, departName, DepartName);
	// 电话
	CC_SYNTHESIZE(string, phone, Phone);
	// 邮箱
	CC_SYNTHESIZE(string, mail, Mail);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, AddDepartDTO& t);
};

#endif // !_UPDATE_DEPART_DTO_