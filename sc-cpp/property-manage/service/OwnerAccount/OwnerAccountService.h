#pragma once
#ifndef _OWNER_ACCOUNT_SERVICE_
#define _OWNER_ACCOUNT_SERVICE_

#include "../../domain/vo/OwnerAccount/OwnerAccountListVO.h"
#include "../../domain/query/OwnerAccount/AccountQuery.h"
#include "../../domain/do/OwnerAccount/OwnerAccountQueryDO.h"
#include "../../domain/do/OwnerAccount/OwnerAccountItemDO.h"
#include "../../dao/OwnerAccount/OwnerAccountDAO.h"
#include "../../domain/vo/OwnerAccount/SelectOwnerVO.h"
#include "../../domain/do/OwnerAccount/SelectOwnerDO.h"
#include "../../domain/dto/OwnerAccount/PreStorageDTO.h"
#include "../../domain/do/OwnerAccount/OwnerAccountDetailDO.h"
#include "../../domain/vo/OwnerAccount/OwnerAccountDetailVO.h"
#include "../../domain/query/OwnerAccount/OwnerAccountDetailQuery.h"

class OwnerAccountService
{
public:
	PageVO<OwnerAccountListVO> listAllOwnerAccountItem(AccountQuery query);
	std::list<SelectOwnerVO> listAllSelectOwner();
	uint64_t preStorageAccount(PreStorageDTO dto);
	PageVO<OwnerAccountDetailVO> listAllOwnerAccountDetail(OwnerAccountDetailQuery query);
};

#endif //__OWNERACCOUNTSERVICE_H__