#ifndef _FLOORANDUNITQUERY_H_
#define _FLOORANDUNITQUERY_H_

#include "../../GlobalInclude.h"

/**
 * 楼栋和单元查询对象：对应显示楼栋和单元选择的区块
 * @Author: Yueyan
 * @Date: 2022/11/2 16:22
 */
class FloorAndUnitQuery
{
	// 类型名称
	CC_SYNTHESIZE(std::string, communityId, CommunityId);

public:
	friend void from_json(const json& j, FloorAndUnitQuery& t) {
		BIND_FROM_TO_NORMAL(j, t, communityId);
	}
};


#endif // _FLOORANDUNITQUERY_H_