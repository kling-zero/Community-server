#ifndef _SAMPLE_DTO_
#define _SAMPLE_DTO_

#include "../../GlobalInclude.h"

class SampleDTO
{
	// 编号
	CC_SYNTHESIZE(long, id, Id);
	// 姓名
	CC_SYNTHESIZE(string, name, Name);
	// 年龄
	CC_SYNTHESIZE(int, age, Age);
	// 性别
	CC_SYNTHESIZE(string, sex, Sex);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, SampleDTO& t);
	BIND_TO_JSON(SampleDTO, id, name, age, sex);
};

#endif // !_SAMPLE_DTO_