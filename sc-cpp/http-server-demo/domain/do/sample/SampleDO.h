#ifndef _SAMPLE_DO_
#define _SAMPLE_DO_
#include "../DoInclude.h"

class SampleDO
{
	// ���
	CC_SYNTHESIZE(int, id, Id);
	// ����
	CC_SYNTHESIZE(string, name, Name);
	// �Ա�
	CC_SYNTHESIZE(string, sex, Sex);
	// ����
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
