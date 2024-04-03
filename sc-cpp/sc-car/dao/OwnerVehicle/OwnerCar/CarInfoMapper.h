#pragma once
#ifndef _CARINFO_MAPPER_
#define _CARINFO_MAPPER_

#include "Mapper.h"
#include "../../../domain/do/OwnerVehicle/OwnerCar/CarInfoDO.h"

class CarInfoMapper : public Mapper<CarInfoDO>
{
public:
	CarInfoDO mapper(ResultSet* resultSet) override
	{
		CarInfoDO data;
		//data.setAreaNum(resultSet->getString(2));
		data.setBId(resultSet->getString(3));
		data.setCarBrand(resultSet->getString(5));
		data.setCarColor(resultSet->getString(7));
		data.setCarId(resultSet->getString(1));
		data.setCarNum(resultSet->getString(4));
		//data.setCarType(resultSet->getString(2));
		data.setCarTypeCd(resultSet->getString(17));
		//data.setCarTypeName(resultSet->getString(2));
		data.setCommunityId(resultSet->getString(13));
		data.setCreateTime(resultSet->getString(11));
		data.setEndTime(resultSet->getString(15));
		//data.setIdCard(resultSet->getString());
		//data.setLink(resultSet->getString(2));
		data.setMemberId(resultSet->getString(18));
		//data.setNum(resultSet->getString(2));
		data.setOwnerId(resultSet->getString(2));
		//data.setOwnerName(resultSet->getString(2));
		//data.setParkingType(resultSet->getString(2));
		data.setPsId(resultSet->getString(8));
		data.setRemark(resultSet->getString(10));
		//data.setRoomName(resultSet->getString(2));
		data.setStartTime(resultSet->getString(14));
		data.setState(resultSet->getString(16));
		//data.setStateName(resultSet->getString(2));
		data.setStatusCd(resultSet->getString(12));
		data.setUserId(resultSet->getString(9));
		return data;
	}
};



#endif // !_CARINFO_MAPPER_