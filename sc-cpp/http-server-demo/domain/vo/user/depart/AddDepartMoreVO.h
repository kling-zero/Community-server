#ifndef _UPDATE_DEPART_MORE_VO_
#define _UPDATE_DEPART_MORE_VO_

#include "AddDepartVO.h"

class AddDepartMoreVO : public AddDepartVO
{
	// 名称
	CC_SYNTHESIZE(int, id, Id);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(AddDepartMoreVO, departName, phone, mail, id);
};

#endif // !_UPDATE_DEPART_DTO_