#ifndef _TRANSACTION_MANAGER_
#define _TRANSACTION_MANAGER_
#include "BaseDAO.h"

/**
 * 定义一个事务管理器
 */
class TransactionManager final
{
private:
	// 记录一个用于管理事务的DAO对象
	BaseDAO* transDao;
	// 设置Sqlsession
	void settingSqlsession(BaseDAO* transDao, BaseDAO* changeDao) {
		changeDao->setSqlSession(transDao->getSqlSession());
		changeDao->setAutoRelease(false);
	}
public:
	//************************************
	// Method:    TransactionManager
	// FullName:  TransactionManager::TransactionManager
	// Access:    public 
	// Returns:   
	// Qualifier: 构造初始化,使用该事务管理器的时候，就已经开启事务了
	// Parameter: BaseDAO * first 管理事务的DAO对象
	// Parameter: DAO ... args 被管理事务的DAO对象
	//************************************
	template <class ... DAO>
	TransactionManager(BaseDAO* transDao, DAO ... args) {
		// 修改被托管DAO的sqlsession
		initializer_list<int>{(settingSqlsession(transDao, std::forward<DAO>(args)), 0)...};
		// 开启事务
		this->transDao = transDao;
		this->transDao->getSqlSession()->beginTransaction();
	}
	// 提交事务
	void commit() {
		this->transDao->getSqlSession()->commitTransaction();
	}
	// 回滚事务
	void rollback() {
		this->transDao->getSqlSession()->rollbackTransaction();
	}
};
#endif // !_TRANSACTION_MANAGER_

