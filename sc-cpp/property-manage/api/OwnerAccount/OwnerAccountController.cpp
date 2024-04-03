#include "stdafx.h"
#include "OwnerAccountController.h"


//************************************
// Method:    executeQueryOwnerAccount
// FullName:  OwnerAccountController::executeQueryOwnerAccount
// Access:    private 
// Returns:   JsonVO<PageVO<OwnerAccountListVO>>
// Qualifier: ��ѯҵ���˻�
// Parameter: AccountQuery query
//************************************`	
JsonVO<PageVO<OwnerAccountListVO>> OwnerAccountController::executeQueryOwnerAccount(AccountQuery query)
{
	//����һ��Service
	OwnerAccountService service;
	//��ѯ����
	PageVO<OwnerAccountListVO> result = service.listAllOwnerAccountItem(query);
	//��Ӧ���
	return JsonVO<PageVO<OwnerAccountListVO>>(result, RS_SUCCESS);
}

//************************************
// Method:    executeQueryAccountType
// FullName:  OwnerAccountController::executeQueryAccountType
// Access:    private 
// Returns:   JsonVO<std::list<AccountTypeVO>>
// Qualifier: ��ѯ�˻�����
//************************************
JsonVO<std::list<AccountTypeVO>> OwnerAccountController::executeQueryAccountType()
{
	std::list<AccountTypeVO> data;
	data.push_back(AccountTypeVO{ 2003,u8"�ֽ��˻�"});
	data.push_back(AccountTypeVO{ 2004,u8"�����˻�" });
	data.push_back(AccountTypeVO{ 2005,u8"�Ż�ȯ�˻�" });
	data.push_back(AccountTypeVO{ 2006,u8"����˻�" });
	data.push_back(AccountTypeVO{ 2007,u8"ʱ���˻�" });
	JsonVO<std::list<AccountTypeVO>> res;
	res.success(data);
	return res;
}

//************************************
// Method:    executeQueryOwnerAccountDetail
// FullName:  OwnerAccountController::executeQueryOwnerAccountDetail
// Access:    private 
// Returns:   JsonVO<PageVO<OwnerAccountDetailVO>>
// Qualifier: ��ѯ�˻���ϸ
// Parameter: OwnerAccountDetailQuery query
//************************************
JsonVO<PageVO<OwnerAccountDetailVO>> OwnerAccountController::executeQueryOwnerAccountDetail(OwnerAccountDetailQuery query)
{
	//����һ��Service
	OwnerAccountService service;
	//��ѯ����
	PageVO<OwnerAccountDetailVO> result = service.listAllOwnerAccountDetail(query);
	//��Ӧ���
	return JsonVO<PageVO<OwnerAccountDetailVO>>(result, RS_SUCCESS);
	
}

//************************************
// Method:    executepreStorageAccount
// FullName:  OwnerAccountController::executepreStorageAccount
// Access:    private 
// Returns:   JsonVO<PreStorageVO>
// Qualifier: Ԥ���˻�
// Parameter: PreStorageDTO form
//************************************
JsonVO<uint64_t> OwnerAccountController::executepreStorageAccount(PreStorageDTO form)
{
	//����һ��Service
	OwnerAccountService service;
	//��ѯ����
	uint64_t result = service.preStorageAccount(form);
	if (result == 9999)
	{
		return JsonVO<uint64_t>(result, RS_FAIL);
	}
	else
	{
		return JsonVO<uint64_t>(result, RS_SUCCESS);
	}
	//��Ӧ���
	
}

JsonVO<std::list<SelectOwnerVO>> OwnerAccountController::executeQuerySelectOwner()
{
	//����һ��Service
	OwnerAccountService service;
	//��ѯ����
	std::list<SelectOwnerVO> result = service.listAllSelectOwner();
	//��Ӧ���
	return JsonVO<std::list<SelectOwnerVO>>(result, RS_SUCCESS);
}
