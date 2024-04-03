#ifndef _DELOWNERCARDTO_H_
#define _DELOWNERCARDTO_H_

#include "../../../GlobalInclude.h"
#include "../../Shared/OwnerCarAttrDTO.h"
/**
* @Anthor: Panda
* @Date: 2022/10/22 22:29:22
* 业主车辆-删除 / 业主车辆-子母车辆-删除
*/
class DelOwnerCarDTO
{
	//
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//
	CC_SYNTHESIZE(std::string, bId, BId);
	//
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	//
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//
	CC_SYNTHESIZE(std::string, carType, CarType);
	//
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
	//
	CC_SYNTHESIZE(std::string, carTypeName, CarTypeName);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//
	CC_SYNTHESIZE(std::string, link, Link);
	//
	//CC_SYNTHESIZE(std::list<std::string>, listValues, ListValues);
	//
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//
	CC_SYNTHESIZE(std::string, num, Num);
	//
	//CC_SYNTHESIZE(std::list<OwnerCarAttrDTO>, ownerCarAttrDto, OwnerCarAttrDto);
	//
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	//
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	//
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//
	CC_SYNTHESIZE(std::string, psId, PsId);
	//
	CC_SYNTHESIZE(std::string, remark, Remark);
	//
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	//
	CC_SYNTHESIZE(std::string, state, State);
	//
	CC_SYNTHESIZE(std::string, stateName, StateName);
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//
	CC_SYNTHESIZE(std::string, userId, UserId);
	//
	//CC_SYNTHESIZE(std::string, withOwner, WithOwner);
public:
	friend void from_json(const json& j, DelOwnerCarDTO& t);
	BIND_TO_JSON(DelOwnerCarDTO, areaNum, bId, carBrand, carColor, carId, carNum, carType, carTypeCd, carTypeName, communityId, createTime, endTime, idCard, link, /*listValues*,*/ memberId, num, /*ownerCarAttrDto,*/ ownerId, ownerName, parkingType, psId, remark, roomName, startTime, state, stateName, statusCd, userId);
};

#endif //_DELOWNERCARDTO_H_