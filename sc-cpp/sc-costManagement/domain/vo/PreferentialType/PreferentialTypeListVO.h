#ifndef _PREFERENTIALTYPELIST_H_
#define _PREFERENTIALTYPELIST_H_

#include "../../GlobalInclude.h"

class PreferentialTypeListVO
{
	// ��������
	CC_SYNTHESIZE(std::string, applicationType, DiscountType);
	// ��������
	CC_SYNTHESIZE(std::string, typeName, TypeName);
	// ��������
	CC_SYNTHESIZE(std::string, typeDescription, TypeDescription);
public:
	// ��JSONת������
	BIND_TO_JSON(PreferentialTypeListVO, applicationType, typeName, typeDescription);
	PreferentialTypeListVO() {
		applicationType = u8"152022100751454705";
		typeName = u8"����Ż�";
		typeDescription = u8"2022���������������Ż�";
	}
};

#endif // !_PREFERENTIALTYPELIST_H_

