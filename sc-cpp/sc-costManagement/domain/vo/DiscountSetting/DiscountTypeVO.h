#ifndef _DISCOUNTTYPE_H_
#define _DISCOUNTTYPE_H_

#include "../../GlobalInclude.h"

class DiscountTypeVO
{
	// 折扣编号
	CC_SYNTHESIZE(uint64_t, id, Id);
	// 折扣名称
	CC_SYNTHESIZE(string, name, Name);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(DiscountTypeVO, id, name);
	DiscountTypeVO() {
		name = u8"优惠";
		id = 0;
	}
};

#endif // !_DISCOUNTTYPE_H_
