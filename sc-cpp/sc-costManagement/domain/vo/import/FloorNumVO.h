#pragma once
#ifndef _FLOORNUMVO_H_
#define _FLOORNUMVO_H_
#include"../../GlobalInclude.h"
class FloorNumVO {
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(double, floorArea, FloorArea);
	CC_SYNTHESIZE(string, floorId, FloorId);
	CC_SYNTHESIZE(string, floorName,FloorName);
	CC_SYNTHESIZE(string, floorNum, FloorNum);
	CC_SYNTHESIZE(string, remark, Remark);
	CC_SYNTHESIZE(int, seq, Seq);
	CC_SYNTHESIZE(string, userName, UserName);

public:
	BIND_TO_JSON(FloorNumVO, communityId, floorArea, floorId, floorName, floorNum, remark, seq, userName);
	FloorNumVO() {
		communityId = u8"2022090665021542";
		floorArea = 10000.00;
		floorId = u8"732022102783770124";
		floorName = u8"»¨ÂúÂ¥ºÅÂ¥";
		floorNum = u8"»¨ÂúÂ¥";
		remark = u8" ";
		seq = 0;
		userName = u8"wuxi";
	}
};

#endif