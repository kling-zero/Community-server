#include "../include/DbInit.h"
#include <sstream>

ConnPool* DbInit::connPool = NULL;

void DbInit::initDbPool(DBConfig config)
{
	releasePool();
	stringstream ss;
	ss << "tcp://" << config.host << ":" << config.port << "/" << config.db;
	connPool = new ConnPool(ss.str(), config.user, config.pass, config.poolMaxSize);
	cout << "mysql db init finish" << endl;
}

ConnPool* DbInit::getConnPool()
{
	return connPool;
}

void DbInit::releasePool()
{
	if (connPool) {
		delete connPool;
		connPool = nullptr;
		cout << "mysql db release finish" << endl;
	}
}
