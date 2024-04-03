#pragma once
#ifndef _CHOOSEPARKVO_H_
#define _CHOOSEPARKVO_H_

#include "../../GlobalInclude.h"
//#include "../PageVO.h"

/**
* @Anthor: Panda
* @Date: 2022/10/20 18:27:51
* ѡ��ͣ��λ
*/
//template <class T>
class ChooseParkVO
{
	//������
	CC_SYNTHESIZE(std::string, area, Area);
	//������
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//����id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//��λ����
	CC_SYNTHESIZE(std::string, num, Num);
	CC_SYNTHESIZE(std::string, paId, PaId);
	//��λ���ͱ�ţ���ͨ/��ĸ/������
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//��λ�������ƣ���ͨ/��ĸ/������
	CC_SYNTHESIZE(std::string, parkingTypeName, ParkingTypeName);
	//��λID
	CC_SYNTHESIZE(std::string, psId, PsId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	//ͣ��״̬����
	CC_SYNTHESIZE(std::string, state, State);
	//ͣ��״̬����
	CC_SYNTHESIZE(std::string, stateName, StateName);
	//ͣ����λ�����ͣ�����/���£�
	CC_SYNTHESIZE(std::string, typeCd, TypeCd);
public:
	BIND_TO_JSON(ChooseParkVO, area, areaNum, communityId, createTime, num, paId, parkingType, parkingTypeName, psId, remark, state, stateName, typeCd);
};

#endif //_CHOOSEPARKVO_H_