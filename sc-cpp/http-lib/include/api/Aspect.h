#ifndef _ASPECT_
#define _ASPECT_

/**
 * ���ļ���Ҫ������д�෽��ʵ��
 */
#include "cinatra.hpp"
using namespace cinatra;

/**
 * ������������
 */
class CROS
{
public:
	bool before(request& req, response& res);
};

/**
 * ��֤����
 */
class Check
{
public:
	Check();
	bool before(request& req, response& res);
	bool after(request& req, response& res);
};
#endif // !_ASPECT_