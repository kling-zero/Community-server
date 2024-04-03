#ifndef  _CHECKITEMQUERY_H_
#define _CHECKITEMQUERY_H_

#include "../PageQuery.h"
#include "./domain/vo/BindOwner/CheckBindOwnerVO.h"
/*
* ��ѯ�����
* @Author : kazimiyuuka
* @Time : 2022/10/18 8:57
*/
class CheckBindOwnerItemQuery : public PageQuery
{
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
	friend void from_json(const json& j , CheckBindOwnerItemQuery& c)
	{
		BIND_FROM_TO_L(j, c, pageIndex);
		BIND_FROM_TO_L(j, c, pageSize);
		BIND_FROM_TO_NORMAL(j, c, appUserName);
		BIND_FROM_TO_NORMAL(j, c, idCard);
		BIND_FROM_TO_NORMAL(j, c, link);
		BIND_FROM_TO_NORMAL(j, c, state);
	}

};
#endif // ! _CHECKITEMQUERY_H_
