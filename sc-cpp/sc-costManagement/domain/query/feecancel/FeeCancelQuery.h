#ifndef _FEE_CANCEL_QUERY_
#define _FEE_CANCEL_QUERY_

#include "../PageQuery.h"
#include "../../GlobalInclude.h"

/**
 ����ȡ����ѯQuery
*/
class FeeCancelQuery : public PageQuery
{
	// ���κ�
	CC_SYNTHESIZE(uint64_t, batchId, BatchId); 
	// ����Ա����
	CC_SYNTHESIZE(string, createUserName, CreateUserName); 
	// ���״̬ID
	CC_SYNTHESIZE(uint64_t, stateId, StateId);
public:
	friend void from_json(const json& j, FeeCancelQuery& t);
};
#endif