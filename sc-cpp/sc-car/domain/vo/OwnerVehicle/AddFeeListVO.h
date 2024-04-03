#pragma once
#ifndef _ADDFEELISTVO_H_
#define _ADDFEELISTVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/22 12:30:38
* 业主车辆-费用-创建费用的返回值
*/
class AddFeeListVO
{
	//
	CC_SYNTHESIZE(std::string, errorCar, ErrorCar);
	//
	CC_SYNTHESIZE(std::string, successCar, SuccessCar);
	//
	CC_SYNTHESIZE(std::string, totalCar, TotalCar);
public:
	BIND_TO_JSON(AddFeeListVO, errorCar, successCar, totalCar);
};

#endif //_ADDFEELISTVO_H_