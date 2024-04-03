#pragma once
#ifndef _COMBOITEMQUERY_H_
#define _COMBOITEMQUERY_H_
#include"../PageQuery.h"


class ComboItemQuery :public PageQuery {
	CC_SYNTHESIZE(string, comboId, ComboId);
	CC_SYNTHESIZE(string, comboName, ComboName);

public:
	friend void from_json(const json& j,ComboItemQuery& c) {
		BIND_FROM_TO_L(j, c, pageIndex);
		BIND_FROM_TO_L(j, c, pageSize);
		BIND_FROM_TO_NORMAL(j, c, comboId);
		BIND_FROM_TO_NORMAL(j, c, comboName);
	}
};



#endif
