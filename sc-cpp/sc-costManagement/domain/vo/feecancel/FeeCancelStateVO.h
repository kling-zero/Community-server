#ifndef _FEE_CANCEL_STATE_VO_
#define _FEE_CANCEL_STATE_VO_

#include "../../GlobalInclude.h"

/**
 费用审核状态下拉框VO
*/
class FeeCancelStateVO {
	// 审核状态名称
	CC_SYNTHESIZE(string, stateName, StateName);
public:
	// 绑定JSON转换方法
	BIND_TO_JSON(FeeCancelStateVO, stateName);
};

#endif
