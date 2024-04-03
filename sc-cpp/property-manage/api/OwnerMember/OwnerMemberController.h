#pragma once

#ifndef _OWNER_MEMBER_CONTROLLER
#define _OWNER_MEMBER_CONTROLLER

#include "../../domain/vo/JsonVO.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/OwnerMember/OwnerItemVO.h"
#include "../../domain/query/OwnerMember/OwnerItemQuery.h"
#include "../../domain/dto/OwnerMember/AddMemberDTO.h"
#include "../../domain/dto/OwnerMember/DeleteMemberDTO.h"
#include "../../domain/dto/OwnerMember/ModifyMemberDTO.h"


class OwnerMemberController
{
public:
	CREATE_API_FUN_QUERY(queryOwnerList, execQueryOwnerList, OwnerItemQuery);
private:
	JsonVO<PageVO<OwnerItemVO>> execQueryOwnerList(OwnerItemQuery query);

};
#endif

