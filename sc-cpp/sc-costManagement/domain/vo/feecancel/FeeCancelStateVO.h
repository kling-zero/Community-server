#ifndef _FEE_CANCEL_STATE_VO_
#define _FEE_CANCEL_STATE_VO_

#include "../../GlobalInclude.h"

/**
 �������״̬������VO
*/
class FeeCancelStateVO {
	// ���״̬����
	CC_SYNTHESIZE(string, stateName, StateName);
public:
	// ��JSONת������
	BIND_TO_JSON(FeeCancelStateVO, stateName);
};

#endif
