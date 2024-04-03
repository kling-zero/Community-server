#ifndef _ADDFEELISTDTO_H_
#define _ADDFEELISTDTO_H_

#include "../../../GlobalInclude.h"
#include "../../Shared/FeeConfigsDTO.h"
#include "../../Shared/FeeTypeCdsDTO.h"
#include "../../Shared/ParkingAreasDTO.h"


/**
* @Anthor: Panda
* @Date: 2022/10/22 12:16:30
* 业主车辆-费用-创建费用
*/
class AddFeeListDTO
{
	//
	CC_SYNTHESIZE(std::string, billType, BillType);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//
	CC_SYNTHESIZE(std::list<std::string>, carState, CarState);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, configId, ConfigId);
	//
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//
	CC_SYNTHESIZE(std::list<FeeConfigsDTO>, feeConfigs, FeeConfigs);
	//
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	//
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	//
	CC_SYNTHESIZE(std::list<FeeTypeCdsDTO>, feeTypeCds, FeeTypeCds);
	//
	CC_SYNTHESIZE(std::string, isMore, IsMore);
	//
	CC_SYNTHESIZE(std::string, locationObjId, LocationObjId);
	//
	CC_SYNTHESIZE(std::string, locationTypeCd, LocationTypeCd);
	//
	CC_SYNTHESIZE(std::string, locationTypeCdName, LocationTypeCdName);
	//
	CC_SYNTHESIZE(std::string, paId, PaId);
	// DTO
	CC_SYNTHESIZE(std::list<ParkingAreasDTO>, parkingAreas, ParkingAreas);
	//
	CC_SYNTHESIZE(std::string, psId, PsId);
	//
	CC_SYNTHESIZE(std::string, startTime, StartTime);
public:
	friend void from_json(const json& j, AddFeeListDTO& t);
	BIND_TO_JSON(AddFeeListDTO, billType, carId, carState, communityId, configId, endTime, feeConfigs, feeFlag, feeTypeCd, feeTypeCds, isMore, locationObjId, locationTypeCd, locationTypeCdName, paId, parkingAreas, psId, startTime);
};

#endif //_ADDFEELISTDTO_H_
