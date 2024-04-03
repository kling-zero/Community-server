#ifndef _DELOWNERCARMEMBERDTO_H_
#define _DELOWNERCARMEMBERDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/28 18:25:09
*/
class DelOwnerCarMemberDTO
{
	//未知
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//车牌号
	CC_SYNTHESIZE(std::string, carNumLike, CarNumLike);
	//车位编号
	CC_SYNTHESIZE(std::string, num, Num);
	//车位状态
	CC_SYNTHESIZE(std::string, valid, Valid);
	//车辆类型
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
public:
	friend void from_json(const json& j, DelOwnerCarMemberDTO& t);
	BIND_TO_JSON(DelOwnerCarMemberDTO, carNum, carNumLike, num, valid, carTypeCd);
};

#endif //_DELOWNERCARMEMBERDTO_H_
