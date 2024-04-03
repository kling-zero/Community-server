#include "../include/SqlSession.h"
#include <sstream>

void SqlSession::releasePreparedStatement()
{
	RELEASE_SQL_OBJECT(pstmt, "releasePreparedStatement");
}

void SqlSession::releaseStatement()
{
	RELEASE_SQL_OBJECT(stmt, "releaseStatement");
}

void SqlSession::releaseResultSet()
{
	RELEASE_SQL_OBJECT(res, "releaseResultSet");
}

int SqlSession::update(string& sql, string& fmt, va_list args)
{
	try
	{
		//1 获取prepareStatement对象
		pstmt = conn->prepareStatement(sql);
		//2 处理参数
		SQL_ARG_EXEC_1(pstmt, fmt, args);
		//3 执行数据操作
		int row = pstmt->executeUpdate();
		//4 释放State
		releasePreparedStatement();
		return row;
	}
	catch (const std::exception& e)
	{
		//4 释放State
		releasePreparedStatement();
		printf("ExecuteUpdate Exception. %s\n", e.what());
	}
	return 0;
}

SqlSession::SqlSession()
{
	this->conn = DbInit::getConnPool()->GetConnection();
	this->pstmt = NULL;
	this->stmt = NULL;
	this->res = NULL;
	//设置编码
	this->setCharset("utf8");
}

SqlSession::~SqlSession()
{
	//析构释放连接对象
	DbInit::getConnPool()->ReleaseConnection(conn);
}

bool SqlSession::execute(string& sql)
{
	bool result = false;
	TryFinally(
		[&] {
			stmt = conn->createStatement();
			result = stmt->execute(sql);
		},
		[](const std::exception e) {
			printf("Execute Exception. %s\n", e.what());
		},
		[=] {
			releaseStatement();
		}
		);
	return result;
}

int SqlSession::executeUpdate(string& sql, string fmt, ...)
{
	va_list args;
	va_start(args, fmt);
	int row = update(sql, fmt, args);
	va_end(args);
	return row;
}

int SqlSession::executeUpdate(string& sql)
{
	return executeUpdate(sql, "");
}

int SqlSession::executeUpdate(string& sql, SqlParams& params)
{
	try
	{
		//1 获取prepareStatement对象
		pstmt = conn->prepareStatement(sql);
		//2 处理参数
		SQL_ARG_EXEC_3(params, pstmt);
		//3 执行数据操作
		int row = pstmt->executeUpdate();
		//4 释放State
		releasePreparedStatement();
		return row;
	}
	catch (const std::exception& e)
	{
		//4 释放State
		releasePreparedStatement();
		printf("ExecuteUpdate Exception. %s\n", e.what());
	}
	return 0;
}

uint64_t SqlSession::executeInsert(string& sql, string fmt, ...)
{
	//执行数据插入
	va_list args;
	va_start(args, fmt);
	int row = update(sql, fmt, args);
	va_end(args);

	//获取主键ID
	uint64_t id = 0;
	if (row == 1)
	{
		TryFinally(
			[&] {
				stmt = conn->createStatement();
				stmt->execute("SELECT LAST_INSERT_ID()");
				res = stmt->getResultSet();
				if (res->next()) {
					id = res->getInt64(1);
				}
			},
			[](std::exception e) {
				printf("Get Insert Id Exception. %s\n", e.what());
			},
			[=] {
				releaseResultSet();
				releaseStatement();
			}
		);
	}
	return id;
}

uint64_t SqlSession::executeInsert(string& sql)
{
	return executeInsert(sql, "");
}

uint64_t SqlSession::executeInsert(string& sql, SqlParams& params)
{
	//执行数据插入
	int row = executeUpdate(sql, params);

	//获取主键ID
	uint64_t id = 0;
	if (row == 1)
	{
		TryFinally(
			[&] {
				stmt = conn->createStatement();
				stmt->execute("SELECT LAST_INSERT_ID()");
				res = stmt->getResultSet();
				if (res->next()) {
					id = res->getInt64(1);
				}
			},
			[](std::exception e) {
				printf("Get Insert Id Exception. %s\n", e.what());
			},
				[=] {
				releaseResultSet();
				releaseStatement();
			}
			);
	}
	return id;
}

uint64_t SqlSession::executeQueryNumerical(string& sql, string fmt, ...)
{
	uint64_t result = 0;
	try
	{
		//1 获取prepareStatement对象
		pstmt = conn->prepareStatement(sql);
		//2 处理参数
		SQL_ARG_EXEC_2(pstmt, fmt);
		//3 执行查询
		res = pstmt->executeQuery();
		//4 处理查询结果
		if (res->next()) {
			result = res->getUInt64(1);
		}
		//5 释放资源
		releaseResultSet();
		releasePreparedStatement();
	}
	catch (const std::exception& e)
	{
		//5 释放资源
		releaseResultSet();
		releasePreparedStatement();
		printf("ExecuteQuery Exception. %s\n", e.what());
	}
	return result;
}

uint64_t SqlSession::executeQueryNumerical(string& sql)
{
	return executeQueryNumerical(sql, "");
}

uint64_t SqlSession::executeQueryNumerical(string& sql, SqlParams& params)
{
	uint64_t result = 0;
	TryFinally(
		[&] {
			//1 获取prepareStatement对象
			pstmt = conn->prepareStatement(sql);
			//2 处理参数
			SQL_ARG_EXEC_3(params, pstmt);
			//3 执行查询
			res = pstmt->executeQuery();
			//4 处理查询结果
			if (res->next()) {
				result = res->getUInt64(1);
			}
		},
		[](std::exception e) {
			printf("ExecuteQuery Exception. %s\n", e.what());
		},
		[=] {
			//4 释放资源
			releaseResultSet();
			releasePreparedStatement();
		}
	);
	return result;
}

bool SqlSession::setCharset(std::string charset)
{
	stringstream ss;
	ss << "set names '" << charset << "'";
	string sql = ss.str();
	return this->execute(sql);
}

void SqlSession::beginTransaction()
{
	conn->setAutoCommit(false);
}

void SqlSession::commitTransaction()
{
	TryFinally(
		[=] {
			conn->commit();
		},
		[](const std::exception e) {
			printf("Commit Exception. %s\n", e.what());
		},
		[=] {
			conn->setAutoCommit(true);
		}
	);
}

void SqlSession::rollbackTransaction()
{
	TryFinally(
		[=] {
			conn->rollback();
		},
		[](const std::exception e) {
			printf("Rollback Exception. %s\n", e.what());
		},
		[=] {
			conn->setAutoCommit(true);
		}
	);
}
