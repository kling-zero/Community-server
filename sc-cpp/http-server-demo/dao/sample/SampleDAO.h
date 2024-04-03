#ifndef _SAMPLE_DAO_
#define _SAMPLE_DAO_
#include "../../domain/do/sample/SampleDO.h"
#include "BaseDAO.h"
class SampleDAO : public BaseDAO
{
public:
	uint64_t count(SampleDO iObj);
	list<SampleDO> selectWithPage(SampleDO obj, long pageIndex, long pageSize);
	list<SampleDO> selectByName(string name);
	uint64_t insert(SampleDO iObj);
	int update(SampleDO uObj);
	int deleteById(int id);
};
#endif // !_SAMPLE_DAO_
