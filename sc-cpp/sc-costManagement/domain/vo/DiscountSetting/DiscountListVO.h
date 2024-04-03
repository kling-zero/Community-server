#ifndef _DISCOUNTLIST_H_
#define _DISCOUNTLIST_H_

#include "../../GlobalInclude.h"

class DiscountListVO
{
	// �ۿ�ID
	CC_SYNTHESIZE(std::string, discountId, DiscountId);
	// �ۿ�����
	CC_SYNTHESIZE(std::string, discountName, DiscountName);
	// �ۿ�����
	CC_SYNTHESIZE(std::string, discountType, DiscountType);
	// ��������
	CC_SYNTHESIZE(std::string, ruleName, RuleName);
	// ����
	CC_SYNTHESIZE(std::string, rule, Rule);
	// ����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
public:
	// ��JSONת������
	BIND_TO_JSON(DiscountListVO, discountId, discountName, discountType, ruleName, rule, createTime);
	DiscountListVO() {
		discountId = u8"132022101193125824";
		discountName = u8"����";
		discountType = u8"�Ż�";
		ruleName = u8"�������";
		rule = u8"���ɽ�0.1";
		createTime = u8"2022-10-11 15:57:38";
	}
};

#endif // !_DISCOUNTLIST_H_
