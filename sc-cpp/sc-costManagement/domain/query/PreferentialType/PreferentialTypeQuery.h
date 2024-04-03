#pragma once
#ifndef _PREFERENTIALTYPEQUERY_H_
#define _PREFERENTIALTYPEQUERY_H_
#include "../PageQuery.h"



class PreferentialTypeQuery : public PageQuery
{
public:
	friend void from_json(const json& j, PreferentialTypeQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, applicationType);
		BIND_FROM_TO_NORMAL(j, t, typeName);
	}
private:
	CC_SYNTHESIZE(string, applicationType, ApplicationType);
	CC_SYNTHESIZE(string, typeName, TypeName);
};
#endif // !_PREFERENTIALTYPEQUERY_H_