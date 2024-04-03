#pragma once
#ifndef _CHOOSEOWNERVO_H_
#define _CHOOSEOWNERVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 10:03:13
* 业主车辆-添加-选择业主
*/
class ChooseOwnerVO
{
	//年龄
	CC_SYNTHESIZE(long, age, Age);
	//创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//身份证
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//联系方式
	CC_SYNTHESIZE(std::string, link, Link);
	//未知
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//名字
	CC_SYNTHESIZE(std::string, name, Name);
	//未知
	CC_SYNTHESIZE(std::string, ownerAttrDtos, OwnerAttrDtos);
	//业主ID
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	//业主类型编号
	CC_SYNTHESIZE(std::string, ownerTypeCd, OwnerTypeCd);
	//业主类型名称
	CC_SYNTHESIZE(std::string, ownerTypeName, OwnerTypeName);
	//未知
	CC_SYNTHESIZE(std::string, remark, Remark);
	//性别
	CC_SYNTHESIZE(long, sex, Sex);
	//创建员工
	CC_SYNTHESIZE(std::string, userName, UserName);

public:
	BIND_TO_JSON(ChooseOwnerVO, age, createTime, idCard, link, memberId, name, ownerAttrDtos, ownerId, ownerTypeCd, ownerTypeName, remark, sex, userName);
};

#endif //_CHOOSEOWNERVO_H_