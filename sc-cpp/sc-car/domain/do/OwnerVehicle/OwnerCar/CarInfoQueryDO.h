#pragma once
#ifndef _CARINFOQUERYDO_H_
#define _CARINFOQUERYDO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/30 16:58:46
*/
class CarInfoQueryDO
{
	//车牌号
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	////车牌号
	CC_SYNTHESIZE(std::string, carNumLike, CarNumLike);
	//车位编号
	CC_SYNTHESIZE(std::string, num, Num);
	//车位状态
	CC_SYNTHESIZE(std::string, valid, Valid);
	//车辆类型
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
public:
	CarInfoQueryDO() {
		std::string carNum = "";
		std::string carNumLike = "";
		std::string num = "";
		std::string valid = "";
		std::string carTypeCd = "";
	}
};

#endif //_CARINFOQUERYDO_H_