#ifndef _ADDOWNERCARDTO_H_
#define _ADDOWNERCARDTO_H_

#include "../../../GlobalInclude.h"
#include "../../Shared/AttrsDTO.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 15:22:28
* 业主车辆-添加 / 业主车辆-子母车辆-添加
*/
class AddOwnerCarDTO
{
	// 
	CC_SYNTHESIZE(std::list<AttrsDTO>, attrs, Attrs);
	CC_SYNTHESIZE(std::string, carAttrs, CarAttrs);
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	CC_SYNTHESIZE(std::string, carNumType, CarNumType);
	CC_SYNTHESIZE(std::string, carType, CarType);
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	CC_SYNTHESIZE(std::string, flowComponent, FlowComponent);
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	CC_SYNTHESIZE(std::string, psId, PsId);
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	CC_SYNTHESIZE(std::string, value, Value);

public:
	//绑定JSON转换方法
	friend void from_json(const json& j, AddOwnerCarDTO& t);
	BIND_TO_JSON(AddOwnerCarDTO, attrs, carAttrs, carBrand, carColor, carNum, carNumType, carType, communityId, endTime, flowComponent, ownerId, psId, remark, startTime, value);
};

#endif //_ADDOWNERCARDTO_H_