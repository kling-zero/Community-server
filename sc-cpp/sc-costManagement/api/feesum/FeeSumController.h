#ifndef _FEE_SUM_CONTROLLER_
#define _FEE_SUM_CONTROLLER_

#include "../../domain/dto/IDDTO.h"
#include "../../domain/vo/feesum/FeeSumVO.h"
#include "../../domain/query/feesum/FeeSumQuery.h"
#include "../../domain/vo/JsonVO.h"
#include "../../domain/vo/PageVO.h"
#include "api/ApiHelper.h"

class FeeSumController {
public:
	CREATE_API_FUN_QUERY(queryFeeSum, execQueryFeeSum, FeeSumQuery);
private:
	// 查询费用汇总列表
	JsonVO<PageVO<FeeSumVO>> execQueryFeeSum(FeeSumQuery query);
};
#endif
