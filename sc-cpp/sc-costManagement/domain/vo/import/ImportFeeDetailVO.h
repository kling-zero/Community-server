#pragma once
#ifndef _IMPORTFEEDETAILVO_H_
#define _IMPORTFEEDETAILVO_H_
#include"../../GlobalInclude.h"
class ImportFeeDetailVO {
	CC_SYNTHESIZE(double,amount,Amount);
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, endTime, EndTime);
	CC_SYNTHESIZE(string, feeId, FeeId);
	CC_SYNTHESIZE(string, feeName, FeeName);
	CC_SYNTHESIZE(int, floorNum, FloorNum);
	CC_SYNTHESIZE(string, ifdId, IfdId);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, records, Record);
	CC_SYNTHESIZE(string, roomId, RoomId);
	CC_SYNTHESIZE(int, roomNum, RoomNum);
	CC_SYNTHESIZE(int, row, Row);
	CC_SYNTHESIZE(string, startTime, StartTime);
	CC_SYNTHESIZE(string, state, State);
	CC_SYNTHESIZE(string, statusCd, StatusCd);
	CC_SYNTHESIZE(int, total, Total);
	CC_SYNTHESIZE(int, unitNum, UnitNum);

public:
	BIND_TO_JSON(ImportFeeDetailVO, amount, communityId, endTime, feeId, feeName, floorNum, ifdId, page, records, roomId, roomNum, row, startTime, state, statusCd, total, unitNum);
	ImportFeeDetailVO() {
		amount = 100.00;
		communityId = u8"2022090665021542";
		endTime = u8"2022-11-21 00:00:00";
		feeId = u8"9020221021506510360";
		feeName = u8"111";
		floorNum = 1;
		ifdId = u8"1120221021681310366";
		page = -1;
		records = 0;
		roomId = u8"752022100910441032";
		roomNum = 1;
		row = 0;
		startTime = u8"2022-10-21 00:00:00";
		state = u8"1000";
		statusCd = u8"0";
		total = 0;
		unitNum = 1;
	}

};

#endif