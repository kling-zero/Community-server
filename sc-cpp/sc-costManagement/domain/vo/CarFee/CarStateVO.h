#pragma once
#ifndef _CARSTATVO_H_
#define _CARSTATVO_H_

#include "../../GlobalInclude.h"

/**
 * ³µÎ»×´Ì¬
 */

class CarStateVO
{
	// ×´Ì¬ÃèÊö
	CC_SYNTHESIZE(string, description, Description);
	// ×´Ì¬±àºÅ
	CC_SYNTHESIZE(string, id, Id);

public:
	// °ó¶¨JSON×ª»»·½·¨
	BIND_TO_JSON(CarStateVO, description, id);
};

#endif // !_CARSTATVO_H_

