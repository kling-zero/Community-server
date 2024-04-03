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
	//ҵ������
	CC_SYNTHESIZE(std::string, appUserName, AppUserName);
	//���֤��
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//�绰��
	CC_SYNTHESIZE(std::string, link, Link);
	//״̬
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
