/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:48:02
*/
#ifndef _ADDSHAREBOOTHDTO_H_
#define _ADDSHAREBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"
/**
*共享岗亭添加
*/
class AddShareBoothDTO
{
	//岗亭id
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//岗亭名称
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//社区
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//默认场地
	CC_SYNTHESIZE(std::string, defaultArea, DefaultArea);
	//停车厂编号
	CC_SYNTHESIZE(std::string, paId, PaId);
	//停车场信息
	CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//备注
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	BIND_TO_JSON(AddShareBoothDTO, boxId, boxName, communityId, defaultArea, parkingAreasDTO, paId,remark);
	friend void from_json(const json& j, AddShareBoothDTO& t);
};


#endif //_ADDSHAREBOOTHDTO_H_