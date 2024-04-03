#ifndef _UPDATE_DEPART_VO_
#define _UPDATE_DEPART_VO_

#include "../../../GlobalInclude.h"

class AddDepartVO
{
	// 名称
	CC_SYNTHESIZE(string, departName, DepartName);
	// 电话
	CC_SYNTHESIZE(string, phone, Phone);
	// 邮箱
	CC_SYNTHESIZE(string, mail, Mail);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(AddDepartVO, departName, phone, mail);
};

#endif // !_UPDATE_DEPART_DTO_