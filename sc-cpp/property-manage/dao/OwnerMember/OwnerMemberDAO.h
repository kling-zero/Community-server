#ifndef _OWNERMEMBERDAO_H_
#define _OWNERMEMBERDAO_H_
#include "BaseDAO.h"
#include "../../domain/do/OwnerMember/OwnerItemDo.h"
class OwnerMemberDAO : public BaseDAO
{
public:
	uint64_t count(OwnerItemDo iObj);
	list<OwnerItemDo> selectWithPage(OwnerItemDo obj, long pageIndex, long pageSize);
	//list<SampleDO> selectByName(string name);
	//uint64_t insert(SampleDO iObj);
	//int update(SampleDO uObj);
	//int deleteById(int id);
};
#endif // !_OWNERMEMBERDAO_H_
