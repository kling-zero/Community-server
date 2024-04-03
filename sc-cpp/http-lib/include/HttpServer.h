#ifndef _HTTP_SERVER_
#define _HTTP_SERVER_

#include "api/ApiHelper.h"
/**
 * 服务器控制类型
 * 注意：
 *  1 使用的时候需要在外部实现api/Aspect.h中定义的类和类成员方法
 *  2 在api/ApiHelper.h里面提供了一系列数据转换处理宏
 *  3 HttpLibMacros里面定义的宏需要在对应项目属性中添加预定义
 */
class HttpServer
{
public:
	//************************************
	// Method:    startServer
	// FullName:  HttpServer::startServer
	// Access:    public static 
	// Returns:   int
	// Qualifier: 启动HTTP服务器
	// Parameter: string port 绑定端口
	// Parameter: function<void(http_server*)> bindRouterFun 初始化路由回调
	// Parameter: string host 绑定地址，默认值0.0.0.0
	//************************************
	static int startServer(string port, function<void(http_server*)> bindRouterFun, string host = "0.0.0.0");
};

#endif // _HTTP_SERVER_

