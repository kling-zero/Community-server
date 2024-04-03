#ifndef _ROOMTYPE_VO_
#define _ROOMTYPE_VO_

#include "../../GlobalInclude.h"

class RoomTypeVO
{
	// 类型描述 ("住宅" "办公室" "宿舍")
	CC_SYNTHESIZE(string, description, Discription);
	// ID (6125 6126 6127)
	CC_SYNTHESIZE(int, id, Id);
	// 类型名 ("住宅" "办公室" "宿舍")
	CC_SYNTHESIZE(string, name, Name);
	// 类型编码 ("110" "120" "119")
	CC_SYNTHESIZE(string, statusCd, StatusCd);

public:
	// 绑定JSON转换方法
	BIND_TO_JSON(RoomTypeVO, description, id, name, statusCd);
};

#endif // !_ROOMTYPE_VO_