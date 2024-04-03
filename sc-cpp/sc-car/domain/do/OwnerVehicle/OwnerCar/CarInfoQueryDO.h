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
	//���ƺ�
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	////���ƺ�
	CC_SYNTHESIZE(std::string, carNumLike, CarNumLike);
	//��λ���
	CC_SYNTHESIZE(std::string, num, Num);
	//��λ״̬
	CC_SYNTHESIZE(std::string, valid, Valid);
	//��������
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