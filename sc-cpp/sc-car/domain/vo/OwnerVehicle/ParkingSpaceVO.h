#pragma once
#ifndef _PARKINGSPACEVO_H_
#define _PARKINGSPACEVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 21:56:12
*/
class ParkingSpaceVO
{
	//���
	CC_SYNTHESIZE(std::string, area, Area);
	
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//����id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//��λ����
	CC_SYNTHESIZE(std::string, num, Num);
	//��λID
	CC_SYNTHESIZE(std::string, paId, PaId);
	//
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//��λ���
	CC_SYNTHESIZE(std::string, parkingTypeName, ParkingTypeName);
	CC_SYNTHESIZE(std::string, psId, PsId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, state, State);
	CC_SYNTHESIZE(std::string, stateName, StateName);
	CC_SYNTHESIZE(std::string, typeCd, TypeCd);

public:
	BIND_TO_JSON(ParkingSpaceVO, area, areaNum, communityId, createTime, num, paId, parkingType, parkingTypeName, psId, remark, state, stateName, typeCd);
};

#endif //_LISTPARKINGSPACEVO_H_