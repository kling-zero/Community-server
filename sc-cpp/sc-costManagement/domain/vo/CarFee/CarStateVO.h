#pragma once
#ifndef _CARSTATVO_H_
#define _CARSTATVO_H_

#include "../../GlobalInclude.h"

/**
 * ��λ״̬
 */

class CarStateVO
{
	// ״̬����
	CC_SYNTHESIZE(string, description, Description);
	// ״̬���
	CC_SYNTHESIZE(string, id, Id);

public:
	// ��JSONת������
	BIND_TO_JSON(CarStateVO, description, id);
};

#endif // !_CARSTATVO_H_

