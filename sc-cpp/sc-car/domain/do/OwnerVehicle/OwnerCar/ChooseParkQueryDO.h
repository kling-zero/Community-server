#ifndef _CHOOSEPARKQUERYDO_H_
#define _CHOOSEPARKQUERYDO_H_

#include "../../DoInclude.h"

class ChooseParkQueryDO
{
	//����ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//ͣ��λ���
	CC_SYNTHESIZE(std::string, num, Num);
	//ͣ�������
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//���ƺ�
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//��λ״̬
	CC_SYNTHESIZE(std::string, state, State); 
public:
	ChooseParkQueryDO() {
		std::string communityId = "";
		std::string num = "";
		std::string areaNum = "";
		std::string carNum = "";
		std::string state = "";
	}
};

#endif //_CHOOSEPARKQUERYDO_H_
