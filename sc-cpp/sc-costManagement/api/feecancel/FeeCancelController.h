#ifndef _FEE_CANCEL_CONTROLLER_
#define _FEE_CANCEL_CONTROLLER_

#include "../../domain/dto/IDDTO.h"
#include "../../domain/vo/feecancel/FeeCancelVO.h"
#include "../../domain/vo/feecancel/FeeCancelStateVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/JsonVO.h"
#include "../../domain/query/feecancel/FeeCancelQuery.h"
#include "../../domain/dto/feecancel/FeeCancelDTO.h"
#include "../../domain/dto/feecancel/FeeCancelAuditDTO.h"
#include "api/ApiHelper.h"

class FeeCancelController {
public:
	CREATE_API_FUN_QUERY3(queryFeeCancelState, execQueryFeeCancelState);
	CREATE_API_FUN_QUERY(queryFeeCancel, execQueryFeeCancel, FeeCancelQuery);
	CREATE_API_FUN_BODY(updateFeeCancel, execUpdateFeeCancel, FeeCancelDTO);
	CREATE_API_FUN_BODY(updateFeeCancelAudit, execUpdateFeeCancelAudit, FeeCancelAuditDTO);
private:
	// 查询审核状态选项
	JsonVO<list<FeeCancelStateVO>> execQueryFeeCancelState();
	// 查询取消费用
	JsonVO<PageVO<FeeCancelVO>> execQueryFeeCancel(FeeCancelQuery query);
	// 申请取消操作
	JsonVO<long> execUpdateFeeCancel(FeeCancelDTO dto);
	// 审核取消操作
	JsonVO<long> execUpdateFeeCancelAudit(FeeCancelAuditDTO dto);
};
#endif