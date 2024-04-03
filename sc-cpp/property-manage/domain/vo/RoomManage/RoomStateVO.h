#ifndef _ROOMSTATE_VO_
#define _ROOMSTATE_VO_

#include "../../GlobalInclude.h"

class RoomStateVO
{
	// ״̬���� ("δ����")
	CC_SYNTHESIZE(string, description, Discription);
	// ID (0)
	CC_SYNTHESIZE(int, id, Id);
	// ״̬�� ("δ����")
	CC_SYNTHESIZE(string, name, Name);
	// ״̬���� ("2002")
	CC_SYNTHESIZE(string, statusCd, StatusCd);
	
public:
	// ��JSONת������
	BIND_TO_JSON(RoomStateVO, description, id, name, statusCd);
};

#endif // !_ROOMSTATE_VO_