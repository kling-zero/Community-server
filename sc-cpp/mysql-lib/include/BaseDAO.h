#ifndef _ABSTRACT_DAO_
#define _ABSTRACT_DAO_
#include "SqlSession.h"

/**
 * 定义一个基础的DAO类，方便管理，后续定义DAO都需要继承它
 */
class BaseDAO
{
private:
	//是否自动释放SQLSession
	bool isAutoRelease;
protected:
	// 定义一个SqlSession
	SqlSession* sqlSession;
public:
	BaseDAO();
	virtual ~BaseDAO();
	// 获取SqlSession
	SqlSession* getSqlSession();
	// 设置SqlSession
	void setSqlSession(SqlSession* session);
	// 设置是否自动释放SqlSession
	void setAutoRelease(bool release);
};

#endif // !_ABSTRACT_DAO_
