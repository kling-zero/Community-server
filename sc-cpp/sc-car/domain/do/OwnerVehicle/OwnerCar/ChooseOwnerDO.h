#ifndef _CHOOSEOWNERDO_H
#define _CHOOSEOWNERDO_H

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/29 17:01:12
*/
class ChooseOwnerDO
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
	ChooseOwnerDO() {
		// business_temp_car_fee_config
		std::string age = "";
		std::string createTime = "";
		std::string idCard = "";
		std::string link = "";
		std::string memberId = "";
		std::string name = "";
		std::string ownerAttrDtos = "";
		std::string ownerId = "";
		std::string ownerTypeCd = "";
		std::string ownerTypeName = "";
		std::string remark = "";
		std::string sex = "";
		std::string userName = "";
	}
};

#endif //_CARINFODO_H_