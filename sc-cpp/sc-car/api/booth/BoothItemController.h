/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:57:28
*/
#ifndef _BOOTHITEMCONTROLLER_H_
#define _BOOTHITEMCONTROLLER_H_
#include "../../service/booth/BoothService.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/JsonVO.h"
#include "api/ApiHelper.h"
#include "../../domain/query/booth/BoothItemQuery.h"
#include "../../domain/vo/boothlist/BoothListVO.h"
#include "../../domain/vo/boothlist/ShareBoothListVO.h"
#include "../../domain/dto/BoothList/addbooth/AddBoothDTO.h"
#include "../../domain/dto/BoothList/deletebooth/DeleteBoothDTO.h"
#include "../../domain/dto/BoothList/modifybooth/ModifyBoothDTO.h"
#include "../../domain/dto/BoothList/addsharebooth/AddShareBoothDTO.h"
#include "../../domain/dto/BoothList/deletesharebooth/DeleteShareBoothDTO.h"
/**
*岗亭接口
*/
class BoothItemController
{	
public:
	CREATE_API_FUN_QUERY(queryBoothList, execQueryBoothList, BoothItemQuery);
	//无参查询boothlist
	CREATE_API_FUN_QUERY3(query3BoothList, execQuery3BoothList);
	CREATE_API_FUN_QUERY3(queryShareBoothList, execQueryShareBoothList);

	CREATE_API_FUN_BODY(addBooth, execAddBooth, AddBoothDTO);
	CREATE_API_FUN_BODY(modifyBooth, execModifyBooth, ModifyBoothDTO);
	CREATE_API_FUN_BODY(deleteBooth, execDeleteBooth, DeleteBoothDTO);
	CREATE_API_FUN_BODY(addShareBooth, execAddShareBooth, AddShareBoothDTO);
	CREATE_API_FUN_BODY(deleteShareBooth, execDeleteShareBooth, DeleteShareBoothDTO);



private:
	JsonVO<PageVO<BoothListVO>> execQueryBoothList(BoothItemQuery query);
	JsonVO<PageVO<BoothListVO>> execQuery3BoothList();
	JsonVO<PageVO<ShareBoothListVO>> execQueryShareBoothList();

	JsonVO<uint64_t> execAddBooth(AddBoothDTO dto);
	JsonVO<std::string> execModifyBooth(ModifyBoothDTO dto);
	JsonVO<std::string> execDeleteBooth(DeleteBoothDTO dto);
	JsonVO<uint64_t> execAddShareBooth(AddShareBoothDTO dto);
	JsonVO<long> execDeleteShareBooth(DeleteShareBoothDTO dto);

};


#endif //_BOOTHITEMCONTROLLER_H_