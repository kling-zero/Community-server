#pragma once
#ifndef _FEEIMPORTITEMCONTROLLER_H_
#define _FEEIMPORTITEMCONTROLLER_H_
#include"api/ApiHelper.h"
#include"../../domain/query/import/FeeImportQuery.h"
#include"../../domain/query/PageQuery.h"
#include"../../domain/vo/JsonVO.h"
#include"../../domain/vo/PageVO.h"
#include"../../domain/vo/import/FeeImportListVO.h"
#include"../../domain/vo/setting/FeeTypeVO.h"
#include"../../domain/query/import/FeeImportDetailQuery.h"
#include"../../domain/vo/import/ImportFeeDetailVO.h"
#include"../../domain/vo/import/FeeFormulVO.h"
#include"../../domain/vo/import/FloorNumVO.h"


class FeeImportItemController {
public:
	CREATE_API_FUN_QUERY(queryFeeImportList,execQueryFeeImportList,FeeImportQuery);
	CREATE_API_FUN_QUERY(queryFeeImportDetail, execQueryFeeImportDetail, FeeImportDetailQuery);
	CREATE_API_FUN_QUERY3(queryFeeType, execQueryFeeType);
	CREATE_API_FUN_QUERY3(queryFeeFormul, execQueryFeeFormul);
	CREATE_API_FUN_QUERY3(queryFloorNum, execQueryFloorNum);


private:
	JsonVO<PageVO<FeeImportListVO>> execQueryFeeImportList(FeeImportQuery query);
	JsonVO<PageVO<ImportFeeDetailVO>> execQueryFeeImportDetail(FeeImportDetailQuery query);
	JsonVO<std::list<FeeTypeVO>> execQueryFeeType();
	JsonVO<std::list<FeeFormulVO>> execQueryFeeFormul();
	JsonVO<std::list<FloorNumVO>> execQueryFloorNum();
};


#endif