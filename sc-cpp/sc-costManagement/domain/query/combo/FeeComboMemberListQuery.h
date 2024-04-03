#pragma once
#ifndef _FEECOMBOMEMBERLISTQUERY_H_
#define _FEECOMBOMEMBERLISTQUERY_H_
#include"../PageQuery.h"

class FeeComboMemberListQuery :public PageQuery{
public:
	friend void from_json(const json& j,FeeComboMemberListQuery& f) {
		BIND_FROM_TO_L(j, f, pageIndex);
		BIND_FROM_TO_L(j, f, pageSize);
	}
};


#endif