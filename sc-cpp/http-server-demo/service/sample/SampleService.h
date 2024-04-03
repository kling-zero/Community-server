#ifndef _SAMPLE_SERVICE_
#define _SAMPLE_SERVICE_
#include <list>
#include "../../domain/vo/sample/SampleVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/query/sample/SampleQuery.h"
#include "../../domain/dto/sample/SampleDTO.h"

class SampleService
{
public:
	PageVO<SampleVO> listAll(SampleQuery query);
	uint64_t saveData(SampleDTO dto);
	bool updateData(SampleDTO dto);
	bool removeData(int id);
};

#endif // !_SAMPLE_SERVICE_

