#ifndef _ASPECT_
#define _ASPECT_

/**
 * 此文件需要自行书写类方法实现
 */
#include "cinatra.hpp"
using namespace cinatra;

/**
 * 跨域拦截切面
 */
class CROS
{
public:
	bool before(request& req, response& res);
};

/**
 * 验证切面
 */
class Check
{
public:
	Check();
	bool before(request& req, response& res);
	bool after(request& req, response& res);
};
#endif // !_ASPECT_