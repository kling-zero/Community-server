#ifndef _LIB_TEST_
#define _LIB_TEST_
#include <string>
#include "Mapper.h"
#include "BaseDAO.h"

/**
 * 测试数据库查询的实体类
 */
class LibTest
{
public:
	int id = 0;
	std::string first = "";
	std::string last = "";
	int age = 1;
};

/**
 * 测试结果集匹配Mapper实现
 */
class LibTestMapper : public Mapper<LibTest>
{
public:
	LibTest mapper(ResultSet* resultSet) override
	{
		LibTest p;
		p.id = resultSet->getInt(1);
		p.first = resultSet->getString(2);
		p.last = resultSet->getString(3);
		p.age = resultSet->getInt(4);
		return p;
	}
};

/**
 * 测试DAO1
 */
class LibTestDAO1 :public BaseDAO {
public:
	int update(LibTest uObj) {
		string sql = "UPDATE `lib_test` SET `first`=? WHERE `id`=?";
		return sqlSession->executeUpdate(sql, "s%i", uObj.first, uObj.id);
	}
};

/**
 * 测试DAO2
 */
class LibTestDAO2 :public BaseDAO {
public:
	int deleteById(int id) {
		string sql = "DELETE FROM `lib_test` WHERE `id`=?";
		return sqlSession->executeUpdate(sql, "i", id);
	}
};

#endif // _LIB_TEST_
