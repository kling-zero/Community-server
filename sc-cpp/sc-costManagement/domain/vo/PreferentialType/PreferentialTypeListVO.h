#ifndef _PREFERENTIALTYPELIST_H_
#define _PREFERENTIALTYPELIST_H_

#include "../../GlobalInclude.h"

class PreferentialTypeListVO
{
	// 申请类型
	CC_SYNTHESIZE(std::string, applicationType, DiscountType);
	// 类型名称
	CC_SYNTHESIZE(std::string, typeName, TypeName);
	// 类型描述
	CC_SYNTHESIZE(std::string, typeDescription, TypeDescription);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(PreferentialTypeListVO, applicationType, typeName, typeDescription);
	PreferentialTypeListVO() {
		applicationType = u8"152022100751454705";
		typeName = u8"租金优惠";
		typeDescription = u8"2022年度疫情商铺租金优惠";
	}
};

#endif // !_PREFERENTIALTYPELIST_H_

