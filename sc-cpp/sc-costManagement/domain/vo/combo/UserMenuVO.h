#pragma once
#ifndef _USERMENUVO_H_
#define _USERMENUVO_H_
#include"../../GlobalInclude.h"

class UserMenuVO {
	CC_SYNTHESIZE(string, icon, Icon);
	CC_SYNTHESIZE(string, muId, MuId);
	CC_SYNTHESIZE(string, name, Name);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, records, records);
	CC_SYNTHESIZE(int, row, Row);
	CC_SYNTHESIZE(string, seq, Seq);
	CC_SYNTHESIZE(string, staffId, StaffId);
	CC_SYNTHESIZE(string, statusCd, StatusCd);
	CC_SYNTHESIZE(int, total, Total);
	CC_SYNTHESIZE(string, url, Url);
public:
	BIND_TO_JSON(UserMenuVO, icon, muId, name, page, records, row, seq, staffId, statusCd, total, url);
	UserMenuVO() {
		icon = u8"fa fa-comment-o";
		muId = u8"1020221025824011838";
		name = u8"kuuga";
		page = -1;
		records = 0;
		row = 0;
		seq = u8"1";
		staffId = u8"302022102475704277";
		statusCd = u8"0";
		total = 0;
		url = u8"/#/pages/common/enterCommunity";
	}
};

#endif