#ifndef _SAMPLE_VO_
#define _SAMPLE_VO_

#include "../../GlobalInclude.h"

class SampleVO
{
	// 编号
	CC_SYNTHESIZE(uint64_t, id, Id);
	// 姓名
	CC_SYNTHESIZE(string, name, Name);
	// 性别
	CC_SYNTHESIZE(string, sex, Sex);
	// 年龄
	CC_SYNTHESIZE(int, age, Age);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(SampleVO, id, name, age, sex);
};

#endif // !_SAMPLE_VO_