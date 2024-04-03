#pragma once
#ifndef _MODIFYCARFEEDTO_H_
#define _MODIFYCARFEEDTO_H_
#include "../../GlobalInclude.h"

/**
 * 变更
 */
class ModifyCarFeeDTO
{
	//绑定JSON转换方法
	friend void from_json(const json& j, ModifyCarFeeDTO& t);
	BIND_TO_JSON(ModifyCarFeeDTO, id);
private:
	CC_SYNTHESIZE(long, id, ID);
};

#endif // !_MODIFYCARFEEDTO_H_
