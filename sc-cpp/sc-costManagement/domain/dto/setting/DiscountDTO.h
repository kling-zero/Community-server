#pragma once
#ifndef _DISCOUNTDTO_H_
#define DISCOUNTDTO_H_
#include"../../GlobalInclude.h"
class DiscountDTO {
	CC_SYNTHESIZE(string,discountTypeName,DiscountTypeName);
	CC_SYNTHESIZE(string, discountName, DiscountName);
	CC_SYNTHESIZE(string, startTime, StartTime);
	CC_SYNTHESIZE(string, endTime, EndTime);
	CC_SYNTHESIZE(string, payMaxEndTime, PayMaxEndTime);

public:
	friend void from_json(const json& j, DiscountDTO& t);
	BIND_TO_JSON(DiscountDTO,discountTypeName, discountName, startTime, endTime, payMaxEndTime);
};

#endif