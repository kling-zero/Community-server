#ifndef _CHECKCO_H_
#define _CHECKCO_H_

#include "../../GlobalInclude.h"
/*
*  չʾ����б�
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
    //��ID
    CC_SYNTHESIZE(std::string, appUserID, AppUserID);
    //ҵ��ID
    CC_SYNTHESIZE(std::string, memberID, MemberID);
    //С��ID
    CC_SYNTHESIZE(std::string, communityID, CommunityID);
    //С������
    CC_SYNTHESIZE(std::string, communityName, CommunityName);
    //��ҵ������
    CC_SYNTHESIZE(std::string, appUserName, AppUserName);
    //���֤
    CC_SYNTHESIZE(std::string, idCard, IdCard);
    //�绰����
    CC_SYNTHESIZE(std::string, link, Link);
    //״̬
    CC_SYNTHESIZE(std::string, stateName, StateName);
    //����ʱ��
    CC_SYNTHESIZE(std::string, createTime, CreateTime);
    //�ֻ�������
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
