#pragma once
#ifndef _CHOOSEOWNERVO_H_
#define _CHOOSEOWNERVO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 10:03:13
* ҵ������-���-ѡ��ҵ��
*/
class ChooseOwnerVO
{
	//����
	CC_SYNTHESIZE(long, age, Age);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//���֤
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//��ϵ��ʽ
	CC_SYNTHESIZE(std::string, link, Link);
	//δ֪
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//����
	CC_SYNTHESIZE(std::string, name, Name);
	//δ֪
	CC_SYNTHESIZE(std::string, ownerAttrDtos, OwnerAttrDtos);
	//ҵ��ID
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	//ҵ�����ͱ��
	CC_SYNTHESIZE(std::string, ownerTypeCd, OwnerTypeCd);
	//ҵ����������
	CC_SYNTHESIZE(std::string, ownerTypeName, OwnerTypeName);
	//δ֪
	CC_SYNTHESIZE(std::string, remark, Remark);
	//�Ա�
	CC_SYNTHESIZE(long, sex, Sex);
	//����Ա��
	CC_SYNTHESIZE(std::string, userName, UserName);

public:
	BIND_TO_JSON(ChooseOwnerVO, age, createTime, idCard, link, memberId, name, ownerAttrDtos, ownerId, ownerTypeCd, ownerTypeName, remark, sex, userName);
};

#endif //_CHOOSEOWNERVO_H_