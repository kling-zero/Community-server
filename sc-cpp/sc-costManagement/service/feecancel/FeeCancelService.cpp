#include "stdafx.h"
#include "FeeCancelService.h"
#include "../../dao/feecancel/FeeCancelDAO.h"
#include "../../dao/feecancel/FeeCancelStateDAO.h"

list<FeeCancelStateVO> FeeCancelService::listState()
{
    // 定义DAO与返回对象
    FeeCancelStateDAO dao;
    list<FeeCancelStateVO> data;
    list<FeeCancelStateDO> objs = dao.listAll();
    // 组装数据
    for (auto& obj : objs) {
        FeeCancelStateVO vo;
        vo.setStateName(obj.getStateName());
        data.push_back(vo);
    }
    return data;
}

PageVO<FeeCancelVO> FeeCancelService::listAll(FeeCancelQuery query)
{
    // 定义DAO与返回对象
    FeeCancelDAO dao;
    FeeCancelStateDAO stateDAO;
    PageVO<FeeCancelVO> pages;
    // 定义组装do
    FeeCancelDO obj;
    obj.setBatchId(query.getBatchId());
    if (query.getStateId() != 0) {
        obj.setStateName(stateDAO.queryStateNameById(query.getStateId()));
    }
    obj.setCreateUserName(query.getCreateUserName());
    long count = dao.count(obj);

    // 组装pages
    pages.setPageIndex(query.getPageIndex());
    pages.setPageSize(query.getPageSize());
    pages.setTotal(count);
    pages.calcPages();

    list<FeeCancelDO> objs = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());
    list<FeeCancelVO> vos;
    for (auto& obj : objs) {
        FeeCancelVO vo;
        vo.setBatchId(obj.getBatchId());
        vo.setCreateTime(obj.getCreateTime());
        vo.setCreateUserName(obj.getCreateUserName());
        vo.setReason(obj.getReason());
        vo.setStateName(obj.getStateName());
        vo.setMsg(obj.getMsg());
        vos.push_back(vo);
    }
    pages.setRows(vos);
    return pages;
}

long FeeCancelService::updateCancel(FeeCancelDTO dto)
{
    // 定义DAO
    FeeCancelDAO dao;
    FeeCancelDO obj;

    //组装DO
    obj.setBatchId(dto.getBatchId());
    obj.setCreateUserName(dto.getCreateUserName());
    obj.setCreateTime(dto.getCreateTime());
    obj.setReason(dto.getReason());
    //写死数据
    obj.setStateName(u8"申请取消");
    obj.setMsg(u8"待审核");
    
    return dao.update(obj);
}

long FeeCancelService::updateAudit(FeeCancelAuditDTO dto)
{
	// 定义DAO
	FeeCancelDAO dao;
	FeeCancelDO obj;

	//组装DO
    obj.setBatchId(dto.getBatchId());

    //填充审核状态
    string stateName = dto.getStateName();
    //填充审核意见
    string ss;
    if (stateName == u8"同意") {
        obj.setStateName(u8"审核通过");
        ss = u8"同意";
    }
    else {
        obj.setStateName(u8"审核失败");
        ss = u8"拒绝";
    }
    string msg = dto.getMsg();
	if (!msg.empty()) {
		ss = ss + ":" + msg;
    }
   
    obj.setMsg(ss);

	return dao.update(obj);
}
