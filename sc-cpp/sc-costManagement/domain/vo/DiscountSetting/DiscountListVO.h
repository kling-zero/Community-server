#ifndef _DISCOUNTLIST_H_
#define _DISCOUNTLIST_H_

#include "../../GlobalInclude.h"

class DiscountListVO
{
	// 折扣ID
	CC_SYNTHESIZE(std::string, discountId, DiscountId);
	// 折扣名称
	CC_SYNTHESIZE(std::string, discountName, DiscountName);
	// 折扣类型
	CC_SYNTHESIZE(std::string, discountType, DiscountType);
	// 规则名称
	CC_SYNTHESIZE(std::string, ruleName, RuleName);
	// 规则
	CC_SYNTHESIZE(std::string, rule, Rule);
	// 创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(DiscountListVO, discountId, discountName, discountType, ruleName, rule, createTime);
	DiscountListVO() {
		discountId = u8"132022101193125824";
		discountName = u8"骨折";
		discountType = u8"优惠";
		ruleName = u8"减免规则";
		rule = u8"滞纳金：0.1";
		createTime = u8"2022-10-11 15:57:38";
	}
};

#endif // !_DISCOUNTLIST_H_
