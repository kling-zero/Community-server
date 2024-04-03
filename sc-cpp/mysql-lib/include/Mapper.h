#ifndef _RESULT_MAPPER_
#define _RESULT_MAPPER_
#include "jdbc/cppconn/resultset.h"
using namespace sql;

/**
 * 查询结果集匹配接口定义
 */
template <class T>
class Mapper
{
public:
	virtual T mapper(ResultSet* resultSet) = 0;
};

#endif // !_RESULT_MAPPER_