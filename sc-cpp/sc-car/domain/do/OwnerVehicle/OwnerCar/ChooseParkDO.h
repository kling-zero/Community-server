#ifndef _CHOOSEPARKDO_H_
#define _CHOOSEPARKDO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/11/01 1:13:33
*/
class ChooseParkDO
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
	ChooseParkDO() {
		std::string area = "";
		std::string areaNum = "";
		std::string communityId = "";
		std::string createTime = "";
		std::string num = "";
		std::string paId = "";
		std::string parkingType = "";
		std::string parkingTypeName = "";
		std::string psId = "";
		std::string remark = "";
		std::string state = "";
		std::string stateName = "";
		std::string typeCd = "";
	}
};

#endif //_CHOOSEPARKDO_H_
