#ifndef _UPDATE_DEPART_DTO_
#define _UPDATE_DEPART_DTO_

#include "../../../GlobalInclude.h"

class AddDepartDTO
{
	// ����
	CC_SYNTHESIZE(string, departName, DepartName);
	// �绰
	CC_SYNTHESIZE(string, phone, Phone);
	// ����
	CC_SYNTHESIZE(string, mail, Mail);
public:
	//��JSONת������
	friend void from_json(const json& j, AddDepartDTO& t);
};

#endif // !_UPDATE_DEPART_DTO_