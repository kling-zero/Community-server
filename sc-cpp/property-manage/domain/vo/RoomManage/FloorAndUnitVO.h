#ifndef _FLOORANDUNITVO_H_
#define _FLOORANDUNITVO_H_

#include "../../GlobalInclude.h"

/**
* 返回的房屋和单元对象
* @Author: Yueyan
* @Date: 2022/11/2 16:44
**/
class FloorAndUnitVO
{
	// 楼栋ID ("732022081690440002") 表f_floor
	CC_SYNTHESIZE(std::string, floorId, FloorId);
	// 楼栋编号 ("D")  表f_floor
	CC_SYNTHESIZE(std::string, floorNum, FloorNum);
	// 层数 ("1") 表building_unit
	CC_SYNTHESIZE(int, layerCount, LayerCount);
	// 有无电梯 ("1010") 表building_unit
	CC_SYNTHESIZE(std::string, lift, Lift);
	// 单元备注 ("1") 表buiding_unit
	CC_SYNTHESIZE(std::string, remark, Remark);
	// 楼栋加入排序 (0) 
	// CC_SYNTHESIZE(int, seq, Seq);
	// 单元面积 ("1.00") 表buiding_unit
	CC_SYNTHESIZE(double, unitArea, UnitArea);
	// 单元ID ("742022082058950007") 表buiding_unit 
	CC_SYNTHESIZE(std::string, unitId, UnitId);
	// 单元编号 ("1") 表building_unit
	CC_SYNTHESIZE(std::string, unitNum, UnitNum);

public:
	// 绑定JSON转换方法
	BIND_TO_JSON(FloorAndUnitVO, floorId, floorNum, layerCount, lift, remark, unitArea, unitId, unitNum);
};

#endif // !_FLOORANDUNITVO_H_