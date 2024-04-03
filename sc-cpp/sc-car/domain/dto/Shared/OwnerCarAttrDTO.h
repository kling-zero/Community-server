#ifndef _OWNERCARATTRDTO_H_
#define _OWNERCARATTRDTO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/26 17:34:41
*/
class OwnerCarAttrDTO
{
	//
	CC_SYNTHESIZE(std::string, attrId, AttrId);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//
	CC_SYNTHESIZE(std::string, listShow, ListShow);
	//
	CC_SYNTHESIZE(std::string, specCd, SpecCd);
	//
	CC_SYNTHESIZE(std::string, specName, SpecName);
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//
	CC_SYNTHESIZE(std::string, value, Value);
	//
	CC_SYNTHESIZE(std::string, valueName, ValueName);
public:
	friend void from_json(const json& j, OwnerCarAttrDTO& t);
	BIND_TO_JSON(OwnerCarAttrDTO, attrId, carId, communityId, createTime, listShow, specCd, specName, statusCd, value, valueName);
};

#endif //_OWNERCARATTRDTO_H_
