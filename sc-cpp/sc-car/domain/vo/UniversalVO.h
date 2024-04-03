#pragma once
#ifndef _UNIVERSALVO_H_
#define _UNIVERSALVO_H_

#include "../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 16:21:31
* 添加请求的返回
*/
class UniversalVO
{
	CC_SYNTHESIZE(std::string, msg, Msg);
public:
	BIND_TO_JSON(UniversalVO, msg);
};

#endif //_UNIVERSALVO_H_