#ifndef _DISCOUNTTYPE_H_
#define _DISCOUNTTYPE_H_

#include "../../GlobalInclude.h"

class DiscountTypeVO
{
	// �ۿ۱��
	CC_SYNTHESIZE(uint64_t, id, Id);
	// �ۿ�����
	CC_SYNTHESIZE(string, name, Name);
public:
	// ��JSONת������
	BIND_TO_JSON(DiscountTypeVO, id, name);
	DiscountTypeVO() {
		name = u8"�Ż�";
		id = 0;
	}
};

#endif // !_DISCOUNTTYPE_H_
