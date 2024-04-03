#ifndef _ADDUNITDTO_H_
#define _ADDUNITDTO_H_

#include "../../GlobalInclude.h"

/*
	@author:niuniu
	@Date:2022/11/4
	@添加单元
*/

class AddUnitDTO
{
	// 单元编号
	CC_SYNTHESIZE(string, unit_num, UnitNum);
	// 总层数
	CC_SYNTHESIZE(int, layer_count, LayerCount);
	// 建筑面积
	CC_SYNTHESIZE(double, unit_area, UnitArea);
	// 电梯
	CC_SYNTHESIZE(string, lift, Lift);
	// 备注
	CC_SYNTHESIZE(string, remark, Remark);
public:
	//绑定JSON转换方法
	friend void from_json(const json& j, AddUnitDTO& t);
	BIND_TO_JSON(AddUnitDTO, unit_num, layer_count, unit_area,lift ,remark);

};
#endif //!_ADDUNITDTO_H_