#include "stdafx.h"
#include "OwnerAccountController.h"


//************************************
// Method:    executeQueryOwnerAccount
// FullName:  OwnerAccountController::executeQueryOwnerAccount
// Access:    private 
// Returns:   JsonVO<PageVO<OwnerAccountListVO>>
// Qualifier: 查询业主账户
// Parameter: AccountQuery query
//************************************`	
JsonVO<PageVO<OwnerAccountListVO>> OwnerAccountController::executeQueryOwnerAccount(AccountQuery query)
{
	//定义一个Service
	OwnerAccountService service;
	//查询数据
	PageVO<OwnerAccountListVO> result = service.listAllOwnerAccountItem(query);
	//响应结果
	return JsonVO<PageVO<OwnerAccountListVO>>(result, RS_SUCCESS);
}

//************************************
// Method:    executeQueryAccountType
// FullName:  OwnerAccountController::executeQueryAccountType
// Access:    private 
// Returns:   JsonVO<std::list<AccountTypeVO>>
// Qualifier: 查询账户类型
//************************************
JsonVO<std::list<AccountTypeVO>> OwnerAccountController::executeQueryAccountType()
{
	std::list<AccountTypeVO> data;
	data.push_back(AccountTypeVO{ 2003,u8"现金账户"});
	data.push_back(AccountTypeVO{ 2004,u8"积分账户" });
	data.push_back(AccountTypeVO{ 2005,u8"优惠券账户" });
	data.push_back(AccountTypeVO{ 2006,u8"金币账户" });
	data.push_back(AccountTypeVO{ 2007,u8"时间账户" });
	JsonVO<std::list<AccountTypeVO>> res;
	res.success(data);
	return res;
}

//************************************
// Method:    executeQueryOwnerAccountDetail
// FullName:  OwnerAccountController::executeQueryOwnerAccountDetail
// Access:    private 
// Returns:   JsonVO<PageVO<OwnerAccountDetailVO>>
// Qualifier: 查询账户明细
// Parameter: OwnerAccountDetailQuery query
//************************************
JsonVO<PageVO<OwnerAccountDetailVO>> OwnerAccountController::executeQueryOwnerAccountDetail(OwnerAccountDetailQuery query)
{
	//定义一个Service
	OwnerAccountService service;
	//查询数据
	PageVO<OwnerAccountDetailVO> result = service.listAllOwnerAccountDetail(query);
	//响应结果
	return JsonVO<PageVO<OwnerAccountDetailVO>>(result, RS_SUCCESS);
	
}

//************************************
// Method:    executepreStorageAccount
// FullName:  OwnerAccountController::executepreStorageAccount
// Access:    private 
// Returns:   JsonVO<PreStorageVO>
// Qualifier: 预存账户
// Parameter: PreStorageDTO form
//************************************
JsonVO<uint64_t> OwnerAccountController::executepreStorageAccount(PreStorageDTO form)
{
	//定义一个Service
	OwnerAccountService service;
	//查询数据
	uint64_t result = service.preStorageAccount(form);
	if (result == 9999)
	{
		return JsonVO<uint64_t>(result, RS_FAIL);
	}
	else
	{
		return JsonVO<uint64_t>(result, RS_SUCCESS);
	}
	//响应结果
	
}

JsonVO<std::list<SelectOwnerVO>> OwnerAccountController::executeQuerySelectOwner()
{
	//定义一个Service
	OwnerAccountService service;
	//查询数据
	std::list<SelectOwnerVO> result = service.listAllSelectOwner();
	//响应结果
	return JsonVO<std::list<SelectOwnerVO>>(result, RS_SUCCESS);
}
