#ifndef _CHOOSEPARKDO_H_
#define _CHOOSEPARKDO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/11/01 1:13:33
*/
class ChooseParkDO
{
	//区域名
	CC_SYNTHESIZE(std::string, area, Area);
	//区域编号
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//社区id
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//车位编码
	CC_SYNTHESIZE(std::string, num, Num);
	CC_SYNTHESIZE(std::string, paId, PaId);
	//车位类型编号（普通/子母/豪华）
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//车位类型名称（普通/子母/豪华）
	CC_SYNTHESIZE(std::string, parkingTypeName, ParkingTypeName);
	//车位ID
	CC_SYNTHESIZE(std::string, psId, PsId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	//停车状态编码
	CC_SYNTHESIZE(std::string, state, State);
	//停车状态名称
	CC_SYNTHESIZE(std::string, stateName, StateName);
	//停车场位置类型（地上/地下）
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
