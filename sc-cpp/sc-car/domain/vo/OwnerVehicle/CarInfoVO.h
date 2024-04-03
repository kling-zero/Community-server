#pragma once
#ifndef _CARINFO_H_
#define _CARINFO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 9:29:06
* 业主车辆 查询返回值
*/
class CarInfoVO
{
	//车位id
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//
	CC_SYNTHESIZE(std::string, bId, BId);
	//车辆品牌
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	//车辆颜色
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//车牌号
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//车辆类型
	CC_SYNTHESIZE(std::string, carType, CarType);
	//车类型编号
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
	//车类型名称
	CC_SYNTHESIZE(std::string, carTypeName, CarTypeName);
	//社区ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//起租时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//结束时间
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//身份证ID
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//电话号码
	CC_SYNTHESIZE(std::string, link, Link);
	//
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//
	CC_SYNTHESIZE(std::string, num, Num);
	//
	//CC_SYNTHESIZE(std::list<class T>, ownerCarAttrDto, OwnerCarAttrDto)
	////业主ID
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	//业主名称
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	//车位状态
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//
	CC_SYNTHESIZE(std::string, psId, PsId);
	//（车位申请，系统自动填入）
	CC_SYNTHESIZE(std::string, remark, Remark);
	//房屋号
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//起租时间
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	//状态编号
	CC_SYNTHESIZE(std::string, state, State);
	//状态名称
	CC_SYNTHESIZE(std::string, stateName, StateName);
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//用户id
	CC_SYNTHESIZE(std::string, userId, UserId);
	//是否为业主
	CC_SYNTHESIZE(bool, withOwner, WithOwner);
public:
	BIND_TO_JSON(CarInfoVO, areaNum, bId, carBrand, carColor, carId, carNum, carType, carTypeCd,
		carTypeName, communityId, createTime, endTime, idCard, link, memberId, num, 
		//ownerCarAttrDto,
		ownerId, parkingType, psId, remark, roomName,
		startTime, state, stateName, statusCd, userId ,withOwner);
};
#endif //_CARINFO_H_