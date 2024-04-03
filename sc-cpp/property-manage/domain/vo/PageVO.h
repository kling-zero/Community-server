#ifndef _PAGE_VO_
#define _PAGE_VO_
#include "../GlobalInclude.h"
#include <list>

/**
 * 分页数据实体
 */
template <class T>
class PageVO
{
    /**
     * 当前页码
     */
    CC_SYNTHESIZE(long, pageIndex, PageIndex);
    /**
     * 每页显示最大数据条数
     */
    CC_SYNTHESIZE(long, pageSize, PageSize);
    /**
     * 数据的总条数
     */
    CC_SYNTHESIZE(uint64_t, total, Total);
    /**
     * 数据的总页数
     */
    CC_SYNTHESIZE(uint64_t, pages, Pages);
    /**
     * 当前页数据列表
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
    //计算总页数
    void calcPages() {
        this->pages = total / pageSize;
        this->pages = total % pageSize == 0 ? this->pages : this->pages + 1;
    }
    //绑定JSON转换方法
	friend void to_json(json& j, const PageVO<T>& t) {
        j = json{ {"pageIndex", t.pageIndex}, {"pageSize", t.pageSize}, {"total",t.total}, {"pages",t.pages}, {"rows",t.rows} };
	}
};

#endif // !_PAGE_VO_

