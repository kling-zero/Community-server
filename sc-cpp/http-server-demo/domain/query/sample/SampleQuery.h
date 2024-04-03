#ifndef _SAMPLE_QUERY_
#define _SAMPLE_QUERY_

#include "../PageQuery.h"

class SampleQuery : public PageQuery
{
	// ÐÕÃû
	CC_SYNTHESIZE(string, name, Name);
	// ÐÔ±ð
	CC_SYNTHESIZE(string, sex, Sex);
public:
	friend void from_json(const json& j, SampleQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, name);
		BIND_FROM_TO_NORMAL(j, t, sex);
	}
};

#endif // !_SAMPLE_QUERY_