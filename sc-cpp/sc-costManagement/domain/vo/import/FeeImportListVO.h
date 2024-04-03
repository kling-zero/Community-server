#ifndef _FEEIMPORTLISTVO_H_
#define _FEEIMPORTLISTVO_H_
#include"../../GlobalInclude.h"

class FeeImportListVO {
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, createTime,CreateTime);
	CC_SYNTHESIZE(string, feeTypeCd,FeeTypeCd);
	CC_SYNTHESIZE(string, feeTypeCdName,FeeTypeCdName);
	CC_SYNTHESIZE(string, importFeeId, ImportFeeId);
	CC_SYNTHESIZE(int, page,Page);
	CC_SYNTHESIZE(int, records,Records);
	CC_SYNTHESIZE(string, remark, Remark);
	CC_SYNTHESIZE(int, row,Row);
	CC_SYNTHESIZE(string, statusCd,StatusCd);
	CC_SYNTHESIZE(int, total,Total);

public:
	BIND_TO_JSON(FeeImportListVO, communityId, createTime, feeTypeCd, feeTypeCdName, importFeeId, page, records, remark,row, statusCd, total);
	FeeImportListVO() {
		communityId = u8"2022090665021542";
		createTime = u8"2022-10-21 15:09:08";
		feeTypeCd = u8"888800010015";
		feeTypeCdName = u8"水费";
		importFeeId = u8"902022102153570006";
		page = -1;
		records = 0;
		remark = u8"总使用量：100，公式：？？？公摊范围：整个小区";
		row = 0;
		statusCd = u8"0";
		total = 0;
	}
};

#endif