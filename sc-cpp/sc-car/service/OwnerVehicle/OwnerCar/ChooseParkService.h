#ifndef _CHOOSEPARKSERVICE_H_
#define _CHOOSEPARKSERVICE_H_

#include "../../../domain/vo/OwnerVehicle/ChooseParkVO.h"
#include "../../../domain/vo/PageVO.h"
#include "../../../domain/query/OwnerVehicle/ChooseParkQuery.h"
/**
* @Anthor: Panda
* @Date: 2022/11/01 1:52:41
*/
class ChooseParkService
{

public:
	PageVO<ChooseParkVO> listAll(ChooseParkQuery query);
};

#endif //_CHOOSEPARKSERVICE_H_
