#ifndef _UPDATE_DEPART_VO_
#define _UPDATE_DEPART_VO_

#include "../../../GlobalInclude.h"

class AddDepartVO
{
	// ����
	CC_SYNTHESIZE(string, departName, DepartName);
	// �绰
	CC_SYNTHESIZE(string, phone, Phone);
	// ����
	CC_SYNTHESIZE(string, mail, Mail);
public:
	//��JSONת������
	BIND_TO_JSON(AddDepartVO, departName, phone, mail);
};

#endif // !_UPDATE_DEPART_DTO_