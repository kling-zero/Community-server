#pragma once
#ifndef _ATTRSDTO_H_
#define _ATTRSDTO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/26 14:13:35
*/
class AttrsDTO
{
	//
	CC_SYNTHESIZE(std::string, attrId, AttrId);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, listShow, ListShow);
	//
	CC_SYNTHESIZE(std::string, paId, PaId);
	//
	CC_SYNTHESIZE(std::string, page, Page);
	//
	CC_SYNTHESIZE(std::string, records, Records);
	//
	CC_SYNTHESIZE(std::string, row, Row);
	//
	CC_SYNTHESIZE(std::string, specCd, SpecCd);
	//
	CC_SYNTHESIZE(std::string, specName, SpecName);
	//
	CC_SYNTHESIZE(std::string, specType, SpecType);
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//
	CC_SYNTHESIZE(std::string, total, Total);
	//
	CC_SYNTHESIZE(std::string, value, Value);
public:
	friend void from_json(const json& j, AttrsDTO& t);
	BIND_TO_JSON(AttrsDTO, attrId, communityId, listShow, paId, page, records, row, specCd, specName, specType, statusCd, total, value);
};

#endif //_ATTRSDTO_H_