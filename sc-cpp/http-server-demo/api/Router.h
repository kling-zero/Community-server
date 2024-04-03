#ifndef _ROUTER_
#define _ROUTER_

#include "api/ApiHelper.h"

class Router
{
private:
	http_server* server;
public:
	//构造初始化
	Router(http_server* sever);
	//呼叫初始化
	void initRouter();
private:
#ifdef HTTP_SERVER_DEMO
	//创建演示路由
	void createSampleRouter();
	//创建用户管理-部门管理路由
	void createUserDepartRouter();
#endif
};

#endif // !_ROUTER_