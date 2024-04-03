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
	//ҵ���˻���ѯ�ӿ�
	CREATE_API_FUN_QUERY(queryOwnerAccount, executeQueryOwnerAccount, AccountQuery);
	//�˻����Ͳ�ѯ�ӿ�
	CREATE_API_FUN_QUERY3(queryAccountType, executeQueryAccountType);
	//�˻���ϸ��ѯ�ӿ�
	CREATE_API_FUN_QUERY(queryOwnerAccountDetail, executeQueryOwnerAccountDetail, OwnerAccountDetailQuery);
	//Ԥ���˻��ӿ�
	CREATE_API_FUN_BODY(preStorageAccount, executepreStorageAccount, PreStorageDTO)
	//Ԥ���˻��е�ѡ��ҵ���б�
	CREATE_API_FUN_QUERY3(querySelectOwner, executeQuerySelectOwner);


private:
	//ҵ���˻���ѯ
	JsonVO<PageVO<OwnerAccountListVO>> executeQueryOwnerAccount(AccountQuery query);
	//�˻����Ͳ�ѯ
	JsonVO<std::list<AccountTypeVO>> executeQueryAccountType();
	//�˻���ϸ��ѯ
	JsonVO<PageVO<OwnerAccountDetailVO>> executeQueryOwnerAccountDetail(OwnerAccountDetailQuery query);
	//Ԥ���˻�
	JsonVO<uint64_t> executepreStorageAccount(PreStorageDTO form);
	//Ԥ���˻��е�ѡ��ҵ���б�
	JsonVO<std::list<SelectOwnerVO>> executeQuerySelectOwner();
};

#endif // !_OWNER_ACCOUNT_CONTROLLER_

