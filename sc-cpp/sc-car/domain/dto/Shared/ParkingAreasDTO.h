#pragma once
#ifndef _PARKINGAREASDTO_H_
#define _PARKINGAREASDTO_H_

#include "../../GlobalInclude.h"
#include "AttrsDTO.h"

/**
* @Anthor: Panda
* @Date: 2022/10/26 14:13:12
*/
class ParkingAreasDTO
{
	//
	CC_SYNTHESIZE(std::list<AttrsDTO>, attrs, Attrs);
	//
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//
	CC_SYNTHESIZE(std::string, num, Num);
	//
	CC_SYNTHESIZE(std::string, paId, PaId);
	//
	CC_SYNTHESIZE(std::string, remark, Remark);
	//
	CC_SYNTHESIZE(std::string, typeCd, TypeCd);
public:
	friend void from_json(const json& j, ParkingAreasDTO& t);
	BIND_TO_JSON(ParkingAreasDTO, attrs, createTime, num, paId, remark, typeCd);
};

#endif //_PARKINGAREASDTO_H_