#ifndef _PAGE_VO_
#define _PAGE_VO_
#include "../GlobalInclude.h"
#include <list>

/**
 * ��ҳ����ʵ��
 */
template <class T>
class PageVO
{
    /**
     * ��ǰҳ��
     */
    CC_SYNTHESIZE(long, pageIndex, PageIndex);
    /**
     * ÿҳ��ʾ�����������
     */
    CC_SYNTHESIZE(long, pageSize, PageSize);
    /**
     * ���ݵ�������
     */
    CC_SYNTHESIZE(uint64_t, total, Total);
    /**
     * ���ݵ���ҳ��
     */
    CC_SYNTHESIZE(uint64_t, pages, Pages);
    /**
     * ��ǰҳ�����б�
     */
    CC_SYNTHESIZE(std::list<T>, rows, Rows);
    //std::list<T> rows;
public:
    PageVO() {
        this->setPageIndex(1);
        this->setPageSize(1);
        this->setPages(0);
        this->setTotal(0);
    };
    PageVO(long pageIndex, long pageSize, uint64_t total, uint64_t pages, std::list<T> rows) {
		this->setPageIndex(pageIndex);
		this->setPageSize(pageSize);
		this->setTotal(total);
		this->setPages(pages);
        this->setRows(rows);
    };
    //������ҳ��
    void calcPages() {
        this->pages = total / pageSize;
        this->pages = total % pageSize == 0 ? this->pages : this->pages + 1;
    }
    //��JSONת������
	friend void to_json(json& j, const PageVO<T>& t) {
        j = json{ {"pageIndex", t.pageIndex}, {"pageSize", t.pageSize}, {"total",t.total}, {"pages",t.pages}, {"rows",t.rows} };
	}
};

#endif // !_PAGE_VO_

