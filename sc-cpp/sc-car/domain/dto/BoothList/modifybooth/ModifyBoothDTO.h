/**
* @Anthor: qingyang
* @Date: 2022/10/17 20:55:59
*/
#ifndef _MODIFYBOOTHDTO_H_
#define _MODIFYBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"
/**
*修改岗亭
*/
class ModifyBoothDTO
{
	//蓝牌车进场
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//岗亭编号
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//岗亭名称
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//社区
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//费用
	CC_SYNTHESIZE(std::string, fee, Fee);
	////停车场编号
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////停车场信息
	//CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//备注
	CC_SYNTHESIZE(std::string, remark, Remark);
	//临时车进厂
	CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	//黄牌车进场
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(ModifyBoothDTO, blueCarIn, boxId, boxName, communityId, fee,/* paId, parkingAreasDTO,*/ remark, tempCarIn, yelowCarIn);
	friend void from_json(const json& j, ModifyBoothDTO& t);
};


#endif //_MODIFYBOOTHDTO_H_

