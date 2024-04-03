/**
* @Anthor: qingyang
* @Date: 2022/10/23 19:06:07
*/
#ifndef _BOOTHSERVICE_H_
#define _BOOTHSERVICE_H_
#include "../../dao/booth/BoothDAO.h"
#include "../../domain/query/booth/BoothItemQuery.h"
#include "../../domain/vo/boothlist/BoothListVO.h"
#include "../../domain/vo/boothlist/ShareBoothListVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/dto/BoothList/addbooth/AddBoothDTO.h"
#include "../../domain/dto/BoothList/addsharebooth/AddShareBoothDTO.h"
#include "../../domain/dto/BoothList/deletebooth/DeleteBoothDTO.h"
#include "../../domain/dto/BoothList/deletesharebooth/DeleteShareBoothDTO.h"
#include "../../domain/dto/BoothList/modifybooth/ModifyBoothDTO.h"
#include "../../domain/do/booth/BoothListDO.h"
/**
*岗亭管理服务
*/
class BoothService
{
public:
	PageVO<BoothListVO> listAll(BoothItemQuery query);
	uint64_t saveBooth(AddBoothDTO dto);
	bool updateBooth(ModifyBoothDTO dto);
	bool removeBooth(std::string box_id);

};


#endif //_BOOTHSERVICE_H_

