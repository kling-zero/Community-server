#ifndef _CHOOSEOWNERDO_H
#define _CHOOSEOWNERDO_H

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/29 17:01:12
*/
class ChooseOwnerDO
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