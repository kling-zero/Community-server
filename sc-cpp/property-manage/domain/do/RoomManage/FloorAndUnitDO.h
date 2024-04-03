#ifndef _FLOORANDUNITDO_H_
#define _FLOORANDUNITDO_H_

#include "../DoInclude.h"

/*****************
* @Author : Yueyan
* @Time : 2022/11/3 21:58
* ע: ��������IDֱ�Ӳ�ѯ��¥���͵�Ԫ
* ****************
*/
class FloorAndUnitDO {
	// ����ID (2022081539020475)
	CC_SYNTHESIZE(std::string, community_id, Community_id);
	// ¥��ID ("732022081690440002") ��f_floor
	CC_SYNTHESIZE(std::string, floor_id, Floor_id);
	// ¥����� ("D")  ��f_floor
	CC_SYNTHESIZE(std::string, floor_num, Floor_num);
	// ��ԪID (742022110245860008)
	CC_SYNTHESIZE(std::string, unit_id, Unit_id);
	// ��Ԫ��� (2)
	CC_SYNTHESIZE(std::string, unit_num, Unit_num);
	// �ܲ��� (123)
	CC_SYNTHESIZE(int, layer_count, Layer_count);
	// ���޵��� (1010�� 2020��)
	CC_SYNTHESIZE(std::string, lift, Lift);
	// ��ע (YY)
	CC_SYNTHESIZE(std::string, remark, Remark);
	// ������� (45.00)
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