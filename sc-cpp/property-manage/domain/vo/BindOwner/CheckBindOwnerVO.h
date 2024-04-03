#ifndef _CHECKCO_H_
#define _CHECKCO_H_

#include "../../GlobalInclude.h"
/*
*  展示审核列表
* @Author : kazimiyuuka
* @Time : 2022/10/17 21:17
*/
class CheckBindOwnerListVO
{
private:
	/*
	* {
    "usrID" : ""
    "stateName" : ""
    "state" : ""
    "memberID" : "",
    "link" : "",
    "idCard" : "",
    "createTime" : "",
    "communityName" : "",
    "communityID" : "",
    "appUserName" : "",
    "appUserID" : "",
    "appTypeName" : "",
    "appType" : ""
}
	*/
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
    //手机端类型
    //CC_SYNTHESIZE(std::string, appTypeName, AppTypeName);
public:
    BIND_TO_JSON(CheckBindOwnerListVO,
        appUserID,
        memberID,
        communityID,
        communityName,
        appUserName,
        idCard,
        link,
        stateName,
        createTime);
};
#endif // !_CHECKCO_H_
