/**
* @Anthor: qingyang
* @Date: 2022/10/17 20:55:59
*/
#ifndef _MODIFYBOOTHDTO_H_
#define _MODIFYBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"
/**
*�޸ĸ�ͤ
*/
class ModifyBoothDTO
{
	//���Ƴ�����
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//��ͤ���
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//��ͤ����
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//����
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����
	CC_SYNTHESIZE(std::string, fee, Fee);
	////ͣ�������
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////ͣ������Ϣ
	//CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//��ע
	CC_SYNTHESIZE(std::string, remark, Remark);
	//��ʱ������
	CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	//���Ƴ�����
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(ModifyBoothDTO, blueCarIn, boxId, boxName, communityId, fee,/* paId, parkingAreasDTO,*/ remark, tempCarIn, yelowCarIn);
	friend void from_json(const json& j, ModifyBoothDTO& t);
};


#endif //_MODIFYBOOTHDTO_H_

