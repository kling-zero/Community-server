#pragma once
#ifndef _CANCELDTO_H_
#define _CANCELDTO_H_
#include "../../GlobalInclude.h"

/**
 * 取消费用
 */
class CancelDTO
{
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, CancelDTO& t);
	BIND_TO_JSON(CancelDTO, id);
private:
	CC_SYNTHESIZE(long, id, ID);
};

#endif // !_CANCELDTO_H_
