#ifndef _EDITFEELISTDTO_H_
#define _EDITFEELISTDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/22 19:29:28
* 业主车辆-费用-变更
*/
class EditFeeListDTO
{
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, computingFormula, ComputingFormula);
	//
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	//
	CC_SYNTHESIZE(std::string, feeId, FeeId);
	//
	CC_SYNTHESIZE(std::string, maxEndTime, MaxEndTime);
	//
	CC_SYNTHESIZE(std::string, rate, Rate);
	//
	CC_SYNTHESIZE(std::string, rateCycle, RateCycle);
	//
	CC_SYNTHESIZE(std::string, rateStartTime, RateStartTime);
	//
	CC_SYNTHESIZE(std::string, startTime, StartTime);
public:
	friend void from_json(const json& j, EditFeeListDTO& t);
	BIND_TO_JSON(EditFeeListDTO, communityId, computingFormula, endTime, feeFlag, feeId, maxEndTime, rate, rateCycle, rateStartTime, startTime);
};

#endif //_EDITFEELISTDTO_H_