#ifndef _ROOMTYPE_VO_
#define _ROOMTYPE_VO_

#include "../../GlobalInclude.h"

class RoomTypeVO
{
	// �������� ("סլ" "�칫��" "����")
	CC_SYNTHESIZE(string, description, Discription);
	// ID (6125 6126 6127)
	CC_SYNTHESIZE(int, id, Id);
	// ������ ("סլ" "�칫��" "����")
	CC_SYNTHESIZE(string, name, Name);
	// ���ͱ��� ("110" "120" "119")
	CC_SYNTHESIZE(string, statusCd, StatusCd);

public:
	// ��JSONת������
	BIND_TO_JSON(RoomTypeVO, description, id, name, statusCd);
};

#endif // !_ROOMTYPE_VO_