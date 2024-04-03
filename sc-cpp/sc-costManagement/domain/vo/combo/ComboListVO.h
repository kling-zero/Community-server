#pragma once
#ifndef _COMBOLISTVO_H_
#define _COMBOLISTVO_H_
#include "../../GlobalInclude.h"

class ComboListVO {
	CC_SYNTHESIZE(string, comboId,ComboId);
	CC_SYNTHESIZE(string, comboName,ComboName);
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, createTime, CreateTime);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, records, Records);
	CC_SYNTHESIZE(string, remark,Remark);
	CC_SYNTHESIZE(int, row,Row);
	CC_SYNTHESIZE(string, statusCd,StatusCd);
	CC_SYNTHESIZE(int, total,Total);

public:
	ComboListVO() {
		comboId = u8"1020221020322510208";
		comboName = u8"首充6元礼包";
		communityId = u8"2022090665021542";
		createTime = u8"2022-10-20 17:35:10";
		page = -1;
		records = 0;
		remark = u8"首充翻倍，更有机会的绝版皮肤";
		row = 0;
		statusCd = u8"0";
		total = 0;
	}

	BIND_TO_JSON(ComboListVO, comboId, comboName, communityId,createTime, page, records,remark,row,statusCd,total);
};

#endif
