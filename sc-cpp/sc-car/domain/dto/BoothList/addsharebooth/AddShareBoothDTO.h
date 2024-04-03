/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:48:02
*/
#ifndef _ADDSHAREBOOTHDTO_H_
#define _ADDSHAREBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"
/**
*�����ͤ���
*/
class AddShareBoothDTO
{
	//��ͤid
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//��ͤ����
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//����
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//Ĭ�ϳ���
	CC_SYNTHESIZE(std::string, defaultArea, DefaultArea);
	//ͣ�������
	CC_SYNTHESIZE(std::string, paId, PaId);
	//ͣ������Ϣ
	CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//��ע
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	BIND_TO_JSON(AddShareBoothDTO, boxId, boxName, communityId, defaultArea, parkingAreasDTO, paId,remark);
	friend void from_json(const json& j, AddShareBoothDTO& t);
};


#endif //_ADDSHAREBOOTHDTO_H_