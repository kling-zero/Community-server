#ifndef __CONNECTION_POOL_H__
#define __CONNECTION_POOL_H__

#include "./mysql/jdbc.h"
#include <list>
#include <string>
#include <mutex>

using namespace std;
using namespace sql;
/**
 * 定义一个数据库连接池类
 */
class ConnPool final
{
public:
	// 构造初始化
	ConnPool(string url, string user, string password, int maxSize);
	// 析构释放内存
	~ConnPool();
	// 获取数据库连接
	Connection* GetConnection();
	// 将数据库连接放回到连接池的容器中
	void ReleaseConnection(Connection* conn);
private:
	// 当前已建立的数据库连接数量
	int curSize;
	// 连接池定义的最大数据库连接数
	int maxSize;
	// 用户名
	string username;
	// 密码
	string password;
	// 连接地址：如tcp://localhost:3306/db
	string url;
	// 连接驱动对象
	Driver* driver;
	// 连接池容器
	list<Connection*> connList;
	// 线程锁
	mutex lock;
	
	// 创建一个连接
	Connection* CreateConnection();
	// 初始化数据库连接池
	void InitConnection(int iInitialSize);
	// 销毁数据库连接对象
	void DestoryConnection(Connection* conn);
	// 销毁数据库连接池
	void DestoryConnPool();
};

#endif /*_CONNECTION_POOL_H */
