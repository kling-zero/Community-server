#ifndef _PAGE_QUERY_
#define _PAGE_QUERY_

#include "../GlobalInclude.h"

/**
 * ��ҳ��ѯ�����࣬������ҳ��ѯ������Լ̳���
 */
class PageQuery
{
	//��ѯҳ��
	CC_SYNTHESIZE(long, pageIndex, PageIndex);
	//��ѯ����
	CC_SYNTHESIZE(long, pageSize, PageSize);
};
#endif // !_PAGE_QUERY_
