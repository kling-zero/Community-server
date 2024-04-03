#ifndef _ROUTER_
#define _ROUTER_

#include "api/ApiHelper.h"
#include "OwnerAccount/OwnerAccountController.h"
#include "OwnerInfo/OwnerInfoController.h"
#include "OwnerMember/OwnerMemberController.h"

#include "api/BindOwner/BindOwnerController.h"
#include "OwnerMember/OwnerMemberController.h"
class Router
{
private:
	http_server* server;
public:
	//�����ʼ��
	Router(http_server* sever);
	//���г�ʼ��
	void initRouter();
	void initBind();
private:
#ifdef HTTP_SERVER_DEMO
	//������ʾ·��
	void createSampleRouter();
	//�����û�����-���Ź���·��
	void createUserDepartRouter();
#endif
	void initOwnerInfo();
	void initOwnerAccount();
	void initShopManage();
	void initOwnerMemberRouter();};
#endif