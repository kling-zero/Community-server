/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:48:16
*/
#ifndef _ADDBOOTHDTO_H_
#define _ADDBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"

/**
*添加岗亭信息
*/

class AddBoothDTO
{
	//蓝牌车进场
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//岗亭名称
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//社区
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//费用
	CC_SYNTHESIZE(std::string, fee, Fee);
	//停车场编号
	CC_SYNTHESIZE(std::string, paId, PaId);
	////停车场信息
	//CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//备注
	CC_SYNTHESIZE(std::string, remark, Remark);
	//临时车进场
	CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	//黄牌车进场
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(AddBoothDTO, blueCarIn, boxName, communityId, fee,/* paId, parkingAreasDTO,*/ remark, tempCarIn, yelowCarIn);
	friend void from_json(const json& j, AddBoothDTO& t);
};


#endif //_ADDBOOTHDTO_H_