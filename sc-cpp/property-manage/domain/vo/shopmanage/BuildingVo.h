#ifndef _BUILDINGVO_H_
#define _BUILDINGVO_H_
#include"../../GlobalInclude.h"
/*
	¥��
	@Author:niuniu
	@Date:2022/10/22
*/
class BuildingVo
{
	//¥�����
	CC_SYNTHESIZE(int, bdId, bdId);
	//����״̬����
	CC_SYNTHESIZE(std::string, bdName, BdName);
private:
	BIND_TO_JSON(BuildingVo, bdId, bdName);
};
#endif