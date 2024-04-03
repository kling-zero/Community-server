#ifndef _CHECKBINDOWNERITEMDO_H_
#define _CHECKBINDOWNERITEMDO_H_
#include "../DoInclude.h"
/*****************
* @Author : kazimiyuuka
* @Time : 2022/10/26 20:45
* ****************
*/

class CheckBindOwnerItemDO {
private:
	//业主名称
	CC_SYNTHESIZE(std::string, appUserName, AppUserName);
	//身份证号
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//电话号
	CC_SYNTHESIZE(std::string, link, Link);
	//状态
	CC_SYNTHESIZE(std::string, state, State);
public:
    CheckBindOwnerItemDO() {
		appUserName = "";
		idCard = "";
		link = "";
		state = "";
    }
	
};

class BindOwnerItemDO {
private:
    //绑定ID
    CC_SYNTHESIZE(std::string, appUserID, AppUserID);
    //业主ID
    CC_SYNTHESIZE(std::string, memberID, MemberID);
    //小区ID
    CC_SYNTHESIZE(std::string, communityID, CommunityID);
    //小区名称
    CC_SYNTHESIZE(std::string, communityName, CommunityName);
    //绑定业主名称
    CC_SYNTHESIZE(std::string, appUserName, AppUserName);
    //身份证
    CC_SYNTHESIZE(std::string, idCard, IdCard);
    //电话号码
    CC_SYNTHESIZE(std::string, link, Link);
    //状态
    CC_SYNTHESIZE(std::string, stateName, StateName);
    //申请时间
    CC_SYNTHESIZE(std::string, createTime, CreateTime);
public:
    BindOwnerItemDO() {
        appUserID = "";
        memberID = "";
        communityID = "";
        communityName = "";
        appUserName = "";
        idCard = "";
        link = "";
        stateName = "";
        createTime = "";
    }
};
#endif // !_CHECKBINDOWNERITEMDO_H_
