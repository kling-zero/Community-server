#ifndef _REQUESTSTATE_H_
#define _REQUESTSTATE_H_

#include "../../GlobalInclude.h"

class RequestStateVO
{
	// ״̬���
	CC_SYNTHESIZE(uint64_t, id, Id);
	// ״̬����
	CC_SYNTHESIZE(string, description, Description);
public:
	// ��JSONת������
	BIND_TO_JSON(RequestStateVO, id, description);
	RequestStateVO() {
		description = u8"�����鷿";
		id = 0;
	}
};

#endif // !_REQUESTSTATE_H_

