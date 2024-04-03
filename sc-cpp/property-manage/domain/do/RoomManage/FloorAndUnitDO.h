#ifndef _FLOORANDUNITDO_H_
#define _FLOORANDUNITDO_H_

#include "../DoInclude.h"

/*****************
* @Author : Yueyan
* @Time : 2022/11/3 21:58
* 注: 根据社区ID直接查询出楼栋和单元
* ****************
*/
class FloorAndUnitDO {
	// 社区ID (2022081539020475)
	CC_SYNTHESIZE(std::string, community_id, Community_id);
	// 楼栋ID ("732022081690440002") 表f_floor
	CC_SYNTHESIZE(std::string, floor_id, Floor_id);
	// 楼栋编号 ("D")  表f_floor
	CC_SYNTHESIZE(std::string, floor_num, Floor_num);
	// 单元ID (742022110245860008)
	CC_SYNTHESIZE(std::string, unit_id, Unit_id);
	// 单元编号 (2)
	CC_SYNTHESIZE(std::string, unit_num, Unit_num);
	// 总层数 (123)
	CC_SYNTHESIZE(int, layer_count, Layer_count);
	// 有无电梯 (1010有 2020无)
	CC_SYNTHESIZE(std::string, lift, Lift);
	// 备注 (YY)
	CC_SYNTHESIZE(std::string, remark, Remark);
	// 建筑面积 (45.00)
	CC_SYNTHESIZE(double, unit_area, Unit_area);

public:
	FloorAndUnitDO() {
	}
	// FloorAndUnitDO(string uni, string bi, string un, string fi, int lc, string l, string usi, string r, string ct, string sc, double ua) {
	// 	unit_id = uni;
	// 	b_id = bi;
	// 	unit_num = un;
	// 	floor_id = fi;
	// 	layer_count = lc;
	// 	lift = l;
	// 	user_id = usi;
	// 	remark = r;
	// 	create_time = ct;
	// 	status_cd = sc;
	// 	unit_area = ua;
	// }
};
#endif // !_FLOORANDUNITDO_H_