#include "stdafx.h"
#include "FeeCancelService.h"
#include "../../dao/feecancel/FeeCancelDAO.h"
#include "../../dao/feecancel/FeeCancelStateDAO.h"

list<FeeCancelStateVO> FeeCancelService::listState()
{
    // ����DAO�뷵�ض���
    FeeCancelStateDAO dao;
    list<FeeCancelStateVO> data;
    list<FeeCancelStateDO> objs = dao.listAll();
    // ��װ����
    for (auto& obj : objs) {
        FeeCancelStateVO vo;
        vo.setStateName(obj.getStateName());
        data.push_back(vo);
    }
    return data;
}

PageVO<FeeCancelVO> FeeCancelService::listAll(FeeCancelQuery query)
{
    // ����DAO�뷵�ض���
    FeeCancelDAO dao;
    FeeCancelStateDAO stateDAO;
    PageVO<FeeCancelVO> pages;
    // ������װdo
    FeeCancelDO obj;
    obj.setBatchId(query.getBatchId());
    if (query.getStateId() != 0) {
        obj.setStateName(stateDAO.queryStateNameById(query.getStateId()));
    }
    obj.setCreateUserName(query.getCreateUserName());
    long count = dao.count(obj);

    // ��װpages
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
    // ����DAO
    FeeCancelDAO dao;
    FeeCancelDO obj;

    //��װDO
    obj.setBatchId(dto.getBatchId());
    obj.setCreateUserName(dto.getCreateUserName());
    obj.setCreateTime(dto.getCreateTime());
    obj.setReason(dto.getReason());
    //д������
    obj.setStateName(u8"����ȡ��");
    obj.setMsg(u8"�����");
    
    return dao.update(obj);
}

long FeeCancelService::updateAudit(FeeCancelAuditDTO dto)
{
	// ����DAO
	FeeCancelDAO dao;
	FeeCancelDO obj;

	//��װDO
    obj.setBatchId(dto.getBatchId());

    //������״̬
    string stateName = dto.getStateName();
    //���������
    string ss;
    if (stateName == u8"ͬ��") {
        obj.setStateName(u8"���ͨ��");
        ss = u8"ͬ��";
    }
    else {
        obj.setStateName(u8"���ʧ��");
        ss = u8"�ܾ�";
    }
    string msg = dto.getMsg();
	if (!msg.empty()) {
		ss = ss + ":" + msg;
    }
   
    obj.setMsg(ss);

	return dao.update(obj);
}
