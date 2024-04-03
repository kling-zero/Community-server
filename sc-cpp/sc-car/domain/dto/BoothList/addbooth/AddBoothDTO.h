/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:48:16
*/
#ifndef _ADDBOOTHDTO_H_
#define _ADDBOOTHDTO_H_
#include "../../../GlobalInclude.h"
#include "../../shared/ParkingAreasDTO.h"

/**
*��Ӹ�ͤ��Ϣ
*/

class AddBoothDTO
{
	//���Ƴ�����
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//��ͤ����
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//����
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����
	CC_SYNTHESIZE(std::string, fee, Fee);
	//ͣ�������
	CC_SYNTHESIZE(std::string, paId, PaId);
	////ͣ������Ϣ
	//CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreasDTO, ParkingAreasDTO);
	//��ע
	CC_SYNTHESIZE(std::string, remark, Remark);
	//��ʱ������
	CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	//���Ƴ�����
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(AddBoothDTO, blueCarIn, boxName, communityId, fee,/* paId, parkingAreasDTO,*/ remark, tempCarIn, yelowCarIn);
	friend void from_json(const json& j, AddBoothDTO& t);
};


#endif //_ADDBOOTHDTO_H_