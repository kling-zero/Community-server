#ifndef _HTTP_SERVER_
#define _HTTP_SERVER_

#include "api/ApiHelper.h"
/**
 * ��������������
 * ע�⣺
 *  1 ʹ�õ�ʱ����Ҫ���ⲿʵ��api/Aspect.h�ж����������Ա����
 *  2 ��api/ApiHelper.h�����ṩ��һϵ������ת�������
 *  3 HttpLibMacros���涨��ĺ���Ҫ�ڶ�Ӧ��Ŀ���������Ԥ����
 */
class HttpServer
{
public:
	//************************************
	// Method:    startServer
	// FullName:  HttpServer::startServer
	// Access:    public static 
	// Returns:   int
	// Qualifier: ����HTTP������
	// Parameter: string port �󶨶˿�
	// Parameter: function<void(http_server*)> bindRouterFun ��ʼ��·�ɻص�
	// Parameter: string host �󶨵�ַ��Ĭ��ֵ0.0.0.0
	//************************************
	static int startServer(string port, function<void(http_server*)> bindRouterFun, string host = "0.0.0.0");
};

#endif // _HTTP_SERVER_

