#ifndef _IDDTO_H_
#define _IDDTO_H_

#include "../GlobalInclude.h"

class ID
{
	// ���
	CC_SYNTHESIZE(long, id, Id);
public:
	//��JSONת������
	friend void from_json(const json& j, ID& t) {
		BIND_FROM_TO_L(j, t, id);
	}
};
#endif // _IDDTO_H_
