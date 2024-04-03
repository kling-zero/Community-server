#include "pch.h"
#include "HttpServer.h"

#ifndef STOP_PWD
#define STOP_PWD "01star"
#endif

http_server* rec_server = nullptr;
int HttpServer::startServer(string port, function<void(http_server*)> bindRouterFun, string host /*= "0.0.0.0"*/)
{
	//1 �����������
	http_server server(std::thread::hardware_concurrency());
	if (!server.listen(host, port)) {
		LOG("server listen fail");
		return -1;
	}

	//2 ��·��
	bindRouterFun(&server);
	LOG("router setting success");
	//����ֹͣ��������ӿ�
	server.set_http_handler<GET, OPTIONS>("/system-kill/*", [](request& req, response& res)
		{
			std::string_view password = req.get_query_value(0);
			if (password == STOP_PWD)
			{
				res.render_string("server will close \r\n");
				if (rec_server)
				{
					rec_server->stop();
					rec_server = nullptr;
				}
				LOG("server stop ok");
			}
			else
			{
				res.render_string("password is not right \r\n");
			}
		});

	//3 �󶨽����źż�����Ctrl + C��
	rec_server = &server;
	signal(SIGINT, [](int signum)
		{
			if (rec_server)
			{
				rec_server->stop();
				rec_server = nullptr;
			}
			LOG("server stop ok");
		});

	//4 ��������
	char info[100];
	sprintf(info, "server start success, listen port is %s", port.c_str());
	LOG(info);
	server.run();
	return -2;
}