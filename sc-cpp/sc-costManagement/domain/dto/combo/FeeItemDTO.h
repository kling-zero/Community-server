#pragma once
#ifndef _FEEITEMDTO_H_
#define _FEEITEMDTO_H_
#include"../../GlobalInclude.h"
class FeeItemDTO {
	CC_SYNTHESIZE(string, communityId, CommunityId);
	CC_SYNTHESIZE(string, createTime,CreateTime);
	CC_SYNTHESIZE(string,feeTypeCd,FeeTypeCd);
	CC_SYNTHESIZE(string,feeTypeCdName,FeeTypeCdName);
	CC_SYNTHESIZE(string,importFeeId,ImportFeeId);
	CC_SYNTHESIZE(int,page,Page);
	CC_SYNTHESIZE(int,records,Records);
	CC_SYNTHESIZE(int,row,Row);
	CC_SYNTHESIZE(int,statusCd,StatusCd);
	CC_SYNTHESIZE(int,total,Total);

public:
	friend void from_json(const json& j, FeeItemDTO& f);
	BIND_TO_JSON(FeeItemDTO,communityId,createTime,feeTypeCd,feeTypeCdName,importFeeId,page,records,row,statusCd,total);
};

#endif