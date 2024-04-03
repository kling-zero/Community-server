#ifndef _PAGE_QUERY_
#define _PAGE_QUERY_

#include "../GlobalInclude.h"

/**
 * 分页查询对象父类，后续分页查询对象可以继承它
 */
class PageQuery
{
	//查询页码
	CC_SYNTHESIZE(long, pageIndex, PageIndex);
	//查询条数
	CC_SYNTHESIZE(long, pageSize, PageSize);
};
#endif // !_PAGE_QUERY_
