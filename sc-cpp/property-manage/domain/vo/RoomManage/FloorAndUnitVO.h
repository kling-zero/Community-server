#ifndef _FLOORANDUNITVO_H_
#define _FLOORANDUNITVO_H_

#include "../../GlobalInclude.h"

/**
* ���صķ��ݺ͵�Ԫ����
* @Author: Yueyan
* @Date: 2022/11/2 16:44
**/
class FloorAndUnitVO
{
	// ¥��ID ("732022081690440002") ��f_floor
	CC_SYNTHESIZE(std::string, floorId, FloorId);
	// ¥����� ("D")  ��f_floor
	CC_SYNTHESIZE(std::string, floorNum, FloorNum);
	// ���� ("1") ��building_unit
	CC_SYNTHESIZE(int, layerCount, LayerCount);
	// ���޵��� ("1010") ��building_unit
	CC_SYNTHESIZE(std::string, lift, Lift);
	// ��Ԫ��ע ("1") ��buiding_unit
	CC_SYNTHESIZE(std::string, remark, Remark);
	// ¥���������� (0) 
	// CC_SYNTHESIZE(int, seq, Seq);
	// ��Ԫ��� ("1.00") ��buiding_unit
	CC_SYNTHESIZE(double, unitArea, UnitArea);
	// ��ԪID ("742022082058950007") ��buiding_unit 
	CC_SYNTHESIZE(std::string, unitId, UnitId);
	// ��Ԫ��� ("1") ��building_unit
	CC_SYNTHESIZE(std::string, unitNum, UnitNum);

public:
	// ��JSONת������
	BIND_TO_JSON(FloorAndUnitVO, floorId, floorNum, layerCount, lift, remark, unitArea, unitId, unitNum);
};

#endif // !_FLOORANDUNITVO_H_