#include "stdafx.h"
#include "FeeSumService.h"

PageVO<FeeSumVO> FeeSumService::listAll(FeeSumQuery query)
{
    //�������ض���
    PageVO<FeeSumVO> pages;
    pages.setPageIndex(query.getPageIndex());
    pages.setPageSize(query.getPageSize());

    // ���������
    FeeSumDAO dao;
    FeeSumDO obj;
    long count = dao.count(obj);
    if (count < 0)
    {
        return pages;
    }

    // ��ʼ��ҳ��ѯ
    pages.setTotal(count);
    pages.calcPages();
    
    list<FeeSumDO> result = dao.selectWithPage(obj, pages.getPageIndex(), pages.getPageSize());
    list<FeeSumVO> vr;
    for (auto& obj : result) {
        FeeSumVO vo;
        vo.setCreateTime(obj.getCreateTime());
        vo.setConfigId(obj.getConfigId());
        vo.setFeeName(obj.getFeeName());
        vo.setReceivableAmounts(obj.getReceivableAmounts());
        vo.setReceivedAmounts(obj.getReceivedAmounts());
        vr.push_back(vo);
    }

    pages.setRows(vr);
    return pages;
}
