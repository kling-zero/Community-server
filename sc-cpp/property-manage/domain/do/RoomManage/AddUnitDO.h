#ifndef _ADDUNITDO_H_
#define _ADDUNITDO_H_

#include "../DoInclude.h"

class AddUnitDO
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
	AddUnitDO() {
		unit_num = "";
		layer_count = 0;
		unit_area = 0;
		lift = "1010";
		remark = "";
	}
};
#endif // !_ADDUNITDO_H_
