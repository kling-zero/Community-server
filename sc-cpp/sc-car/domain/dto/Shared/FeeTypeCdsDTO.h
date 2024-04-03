#ifndef _FEETYPECDSDTO_H_
#define _FEETYPECDSDTO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/26 13:53:13
*/
class FeeTypeCdsDTO
{
	//
	CC_SYNTHESIZE(std::string, description, Description);
	
	//
	//CC_SYNTHESIZE(std::string, id, Id);
	
	//∑—”√√˚≥∆
	CC_SYNTHESIZE(std::string, name, Name);
	
	//
	//CC_SYNTHESIZE(std::string, page, Page);
	//
	//CC_SYNTHESIZE(std::string, records, Records);
	//
	//CC_SYNTHESIZE(std::string, row, Row);
	
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	
	//
	//CC_SYNTHESIZE(std::string, total, Total);
public:
	friend void from_json(const json& j, FeeTypeCdsDTO& t);
	BIND_TO_JSON(FeeTypeCdsDTO, description, name, statusCd);

};

#endif //_FEETYPECDSDTO_H_