/**
* @Anthor: qingyang
* @Date: 2022/10/23 19:08:39
*/
#ifndef _BOOTHDAO_H_
#define _BOOTHDAO_H_
#include "../../domain/do/booth/BoothListDO.h"
#include "BaseDAO.h"
#include "BoothMapper.h"
/**
*
*/
class BoothDAO :public BaseDAO
{
public:
	uint64_t count(BoothListDO iObj);
	std::list<BoothListDO> selectWithPage(BoothListDO obj, long pageIndex, long pageSize);
	uint64_t insert(BoothListDO iObj);
	int update(BoothListDO uObj);
	int deleteById(std::string id);
};


#endif //_BOOTHDAO_H_