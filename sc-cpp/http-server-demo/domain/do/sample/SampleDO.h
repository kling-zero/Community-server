#ifndef _SAMPLE_DO_
#define _SAMPLE_DO_
#include "../DoInclude.h"

class SampleDO
{
	// 编号
	CC_SYNTHESIZE(int, id, Id);
	// 姓名
	CC_SYNTHESIZE(string, name, Name);
	// 性别
	CC_SYNTHESIZE(string, sex, Sex);
	// 年龄
	CC_SYNTHESIZE(int, age, Age);
public:
	SampleDO() {
		id = -1;
		name = "";
		sex = "";
		age = -1;
	}
};

#endif // !_SAMPLE_DO_
