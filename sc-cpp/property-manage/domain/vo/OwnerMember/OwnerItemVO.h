#ifndef _OWNER_ITEM_VO_
#define _OWNER_ITEM_VO_

#include "../../GlobalInclude.h"

class OwnerItemVO
{
	CC_SYNTHESIZE(string, ownerName, OwnerName);
	CC_SYNTHESIZE(string, sex, Sex);
	CC_SYNTHESIZE(int, age, Age);
	CC_SYNTHESIZE(string, idCard, IdCard);
	CC_SYNTHESIZE(string, link, Link);
	CC_SYNTHESIZE(string, createStaff, CreateStaff);	
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(OwnerItemVO, ownerName, sex, age, idCard, link, createStaff);
};

#endif