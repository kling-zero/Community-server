#pragma once
#ifndef _PRE_STORAGE_VO_
#define _PRE_STORAGE_VO_


#include "../../GlobalInclude.h"
#include "../../dto/OwnerAccount/PreStorageDTO.h"
/*
* 预存账户VO
*/
class PreStorageVO
{
	// 编号
	CC_SYNTHESIZE(std::string, ownerPhone, OwnerPhone);
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	CC_SYNTHESIZE(long, preStorageAmount, PreStorageAmount);
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	CC_SYNTHESIZE(std::string, remark, Remark);
public:
	//绑定JSON转换方法
	BIND_TO_JSON(PreStorageVO,
		ownerPhone,
		ownerName,
		preStorageAmount,
		acctType,
		remark);
	PreStorageVO() {};
	PreStorageVO(PreStorageDTO dto) {
		this->setOwnerPhone(dto.getOwnerPhone());
		this->setOwnerName(dto.getOwnerName());
		this->setPreStorageAmount(dto.getPreStorageAmount());
		this->setAcctType(dto.getAcctType());
		this->setRemark(dto.getRemark());
	};
};
#endif // !_PRE_STORAGE_DTO_
