#ifndef _CHOOSEPARKQUERYDO_H_
#define _CHOOSEPARKQUERYDO_H_

#include "../../DoInclude.h"

class ChooseParkQueryDO
{
	//社区ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//停车位编号
	CC_SYNTHESIZE(std::string, num, Num);
	//停车场编号
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//车牌号
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//车位状态
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
