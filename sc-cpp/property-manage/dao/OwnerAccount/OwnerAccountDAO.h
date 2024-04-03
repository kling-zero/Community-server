#pragma once
#ifndef _OWNER_ACCOUNT_DAO_
#define _OWNER_ACCOUNT_DAO_

#include "BaseDAO.h"
#include "../../domain/do/OwnerAccount/OwnerAccountItemDO.h"
#include "../../domain/do/OwnerAccount/OwnerAccountQueryDO.h"
#include "../../domain/do/OwnerAccount/SelectOwnerDO.h"
#include "../../domain/do/OwnerAccount/OwnerAccountDetailDO.h"
#include "OwnerAccountItemMapper.h"
#include "SelectOwnerMapper.h"
#include "OwnerAccountDetailMapper.h"

class OwnerAccountDAO: public BaseDAO
{
public:
	uint64_t countOwnerAccountItem(OwnerAccountQueryDO iObj);
	uint64_t countOwnerAccountDetail(OwnerAccountDetailDO iObj);
	uint64_t countSelectOwner();
	std::list<OwnerAccountItemDO> selectOwnerAccountItemWithPage(OwnerAccountQueryDO iObj, long pageIndex, long pageSize);
	std::list<OwnerAccountItemDO> selectOwnerAccountItem(OwnerAccountDetailDO iObj);
	std::list<SelectOwnerDO> selectSelectOwner();
	uint64_t insertOwnerAccount(OwnerAccountItemDO iObj);
	uint64_t updateOwnerAccount(OwnerAccountItemDO iObj);
	std::list<OwnerAccountDetailDO> selectOwnerAccountDetailWithPage(OwnerAccountDetailDO iObj, long pageIndex, long pageSize);
};

#endif //__OWNERACCOUNTDAO_H__
