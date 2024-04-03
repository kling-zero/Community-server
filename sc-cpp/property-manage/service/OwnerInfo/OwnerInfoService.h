#pragma once
#ifndef _OWNER_INFO_SERVICE_
#define _OWNER_INFO_SERVICE_


#include "domain/vo/JsonVO.h"
#include "../../domain/vo/PageVO.h"
#include "domain/vo/OwnerInfo/BuildingInfoVO.h"
#include "domain/vo/OwnerInfo/HouseInfoVO.h"
#include "domain/vo/OwnerInfo/OwnerInfoVO.h"
#include "domain/query/OwnerInfo/OwnerInfoQuery.h"
#include "domain/dto/OwnerInfo/OwnerInfoDTO.h"
#include "domain/dto/OwnerInfo/HouseInfoDTO.h"
#include "domain/query/OwnerInfo/BuildingInfoQuery.h"
#include "../../dao/OwnerInfo/OwnerInfoDAO.h"


class OwnerInfoService
{
public:
	PageVO<OwnerInfoVO> listAllOwnerInfo(OwnerInfoQuery query);
	uint64_t AddOwnerInfo(OwnerInfoDTO dto);
	long ModifyOwnerInfo(OwnerInfoDTO dto);
	int DeleteOwnerInfo(std::string id);
};


#endif //__OWNERINFOSERVICE_H__