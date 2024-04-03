#pragma once
#ifndef _FEEIMPORTDETAILQUERY_H_
#define _FEEIMPORTDETAILQUERY_H_
#include"../PageQuery.h"
class FeeImportDetailQuery :public PageQuery{
	CC_SYNTHESIZE(long, floorNum, FloorNum);
	CC_SYNTHESIZE(long, unitNum, UnitNum);
	CC_SYNTHESIZE(long, roomNum, RoomNum);

public:
	friend void from_json(const json& j, FeeImportDetailQuery& f) {
		BIND_FROM_TO_L(j, f, floorNum);
		BIND_FROM_TO_L(j, f, unitNum);
		BIND_FROM_TO_L(j, f, roomNum);
		BIND_FROM_TO_L(j, f, pageIndex);
		BIND_FROM_TO_L(j, f, pageSize);
	}
};
#endif