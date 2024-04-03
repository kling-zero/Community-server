#ifndef _ADDUNITDO_H_
#define _ADDUNITDO_H_

#include "../DoInclude.h"

class AddUnitDO
{
	// ��Ԫ���
	CC_SYNTHESIZE(string, unit_num, UnitNum);
	// �ܲ���
	CC_SYNTHESIZE(int, layer_count, LayerCount);
	// �������
	CC_SYNTHESIZE(double, unit_area, UnitArea);
	// ����
	CC_SYNTHESIZE(string, lift, Lift);
	// ��ע
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
