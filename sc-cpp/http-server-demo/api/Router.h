#ifndef _ROUTER_
#define _ROUTER_

#include "api/ApiHelper.h"

class Router
{
private:
	http_server* server;
public:
	//�����ʼ��
	Router(http_server* sever);
	//���г�ʼ��
	void initRouter();
private:
#ifdef HTTP_SERVER_DEMO
	//������ʾ·��
	void createSampleRouter();
	//�����û�����-���Ź���·��
	void createUserDepartRouter();
#endif
};

#endif // !_ROUTER_