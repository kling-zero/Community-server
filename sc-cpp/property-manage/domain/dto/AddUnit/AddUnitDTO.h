#ifndef _ADDUNITDTO_H_
#define _ADDUNITDTO_H_

#include "../../GlobalInclude.h"

/*
	@author:niuniu
	@Date:2022/11/4
	@��ӵ�Ԫ
*/

class AddUnitDTO
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
	//��JSONת������
	friend void from_json(const json& j, AddUnitDTO& t);
	BIND_TO_JSON(AddUnitDTO, unit_num, layer_count, unit_area,lift ,remark);

};
#endif //!_ADDUNITDTO_H_