
#ifndef _CHOOSEPARKDAO_H_
#define _CHOOSEPARKDAO_H_

#include "BaseDAO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseParkDO.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/ChooseParkQueryDO.h"

class ChooseParkDAO : public BaseDAO
{
public:
	uint64_t count(ChooseParkQueryDO iObj);
	list<ChooseParkDO> selectWithPage(ChooseParkQueryDO obj, long pageIndex, long pageSize);
};

#endif //_CHOOSEPARKDAO_H_