#pragma once
#ifndef _FEEIMPORTQUERT_H_
#define _FEEIMPORTQUERY_H_
#include"../PageQuery.h"
class FeeImportQuery :public PageQuery {
	CC_SYNTHESIZE(string, importFeeId, ImportFeeId);
	CC_SYNTHESIZE(string, feeTypeCdName,FeeTypeCdName);

public:
	friend void from_json(const json& j, FeeImportQuery& f) {
		BIND_FROM_TO_L(j, f, pageIndex);
		BIND_FROM_TO_L(j, f, pageSize);
		BIND_FROM_TO_NORMAL(j, f, importFeeId);
		BIND_FROM_TO_NORMAL(j, f, feeTypeCdName);

	}
};

#endif