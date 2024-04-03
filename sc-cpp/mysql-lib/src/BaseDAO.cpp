#include "../include/BaseDAO.h"

BaseDAO::BaseDAO()
{
	isAutoRelease = true;
	sqlSession = new SqlSession();
}

BaseDAO::~BaseDAO()
{
	if (isAutoRelease && sqlSession) delete sqlSession;
}

SqlSession* BaseDAO::getSqlSession()
{
	return this->sqlSession;
}

void BaseDAO::setSqlSession(SqlSession* session)
{
	if(sqlSession)
		delete sqlSession;
	this->sqlSession = session;
}

void BaseDAO::setAutoRelease(bool release)
{
	this->isAutoRelease = release;
}
