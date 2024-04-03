#ifndef _RESULT_MAPPER_
#define _RESULT_MAPPER_
#include "jdbc/cppconn/resultset.h"
using namespace sql;

/**
 * ��ѯ�����ƥ��ӿڶ���
 */
template <class T>
class Mapper
{
public:
	virtual T mapper(ResultSet* resultSet) = 0;
};

#endif // !_RESULT_MAPPER_