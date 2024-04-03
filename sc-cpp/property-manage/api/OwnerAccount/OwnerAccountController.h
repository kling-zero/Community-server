#pragma once
#ifndef _OWNER_ACCOUNT_CONTROLLER_
#define _OWNER_ACCOUNT_CONTROLLER_

#include "domain/vo/JsonVO.h"
#include "domain/vo/OwnerAccount/OwnerAccountListVO.h"
#include "domain/query/OwnerAccount/AccountQuery.h"
#include "domain/vo/OwnerAccount/AccountTypeVO.h"
#include "domain/vo/OwnerAccount/OwnerAccountDetailVO.h"
#include "domain/query/OwnerAccount/OwnerAccountDetailQuery.h"
#include "domain/dto/OwnerAccount/PreStorageDTO.h"
#include "domain/vo/OwnerAccount/PreStorageVO.h"
#include "../../service/OwnerAccount/OwnerAccountService.h"
#include "domain/vo/OwnerAccount/SelectOwnerVO.h"

class OwnerAccountController
{
public:
	//业主账户查询接口
	CREATE_API_FUN_QUERY(queryOwnerAccount, executeQueryOwnerAccount, AccountQuery);
	//账户类型查询接口
	CREATE_API_FUN_QUERY3(queryAccountType, executeQueryAccountType);
	//账户明细查询接口
	CREATE_API_FUN_QUERY(queryOwnerAccountDetail, executeQueryOwnerAccountDetail, OwnerAccountDetailQuery);
	//预存账户接口
	CREATE_API_FUN_BODY(preStorageAccount, executepreStorageAccount, PreStorageDTO)
	//预存账户中的选择业主列表
	CREATE_API_FUN_QUERY3(querySelectOwner, executeQuerySelectOwner);


private:
	//业主账户查询
	JsonVO<PageVO<OwnerAccountListVO>> executeQueryOwnerAccount(AccountQuery query);
	//账户类型查询
	JsonVO<std::list<AccountTypeVO>> executeQueryAccountType();
	//账户明细查询
	JsonVO<PageVO<OwnerAccountDetailVO>> executeQueryOwnerAccountDetail(OwnerAccountDetailQuery query);
	//预存账户
	JsonVO<uint64_t> executepreStorageAccount(PreStorageDTO form);
	//预存账户中的选择业主列表
	JsonVO<std::list<SelectOwnerVO>> executeQuerySelectOwner();
};

#endif // !_OWNER_ACCOUNT_CONTROLLER_

