#ifndef _SAMPLE_DTO_
#define _SAMPLE_DTO_

#include "../../GlobalInclude.h"

class SampleDTO
{
	// ���
	CC_SYNTHESIZE(long, id, Id);
	// ����
	CC_SYNTHESIZE(string, name, Name);
	// ����
	CC_SYNTHESIZE(int, age, Age);
	// �Ա�
	CC_SYNTHESIZE(string, sex, Sex);
public:
	//��JSONת������
	friend void from_json(const json& j, SampleDTO& t);
	BIND_TO_JSON(SampleDTO, id, name, age, sex);
};

#endif // !_SAMPLE_DTO_