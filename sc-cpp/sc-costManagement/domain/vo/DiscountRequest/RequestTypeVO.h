#ifndef _REQUESTTYPE_H_
#define _REQUESTTYPE_H_

#include "../../GlobalInclude.h"

class RequestTypeVO
{
	// ���ͱ��
	CC_SYNTHESIZE(uint64_t, id, Id);
	// ��������
	CC_SYNTHESIZE(string, name, Name);
public:
	// ��JSONת������
	BIND_TO_JSON(RequestTypeVO, id, name);
	RequestTypeVO() {
		name = u8"����Ż�";
		id = 0;
	}
};

#endif // !_REQUESTTYPE_H_

