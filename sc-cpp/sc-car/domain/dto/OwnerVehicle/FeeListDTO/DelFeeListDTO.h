#ifndef _DELFEELISTDTO_H_
#define _DELFEELISTDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/22 19:38:46
* 业主车辆-费用-取消（删除）
*/
class DelFeeListDTO
{
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, feeId, FeeId);
public:
	friend void from_json(const json& j, DelFeeListDTO& t);
	BIND_TO_JSON(DelFeeListDTO, communityId, feeId);
};

#endif //_DELFEELISTDTO_H_