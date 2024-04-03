#include "stdafx.h"
#include "OwnerAccountService.h"

PageVO<OwnerAccountListVO> OwnerAccountService::listAllOwnerAccountItem(AccountQuery query)
{
	//�������ض���
	PageVO<OwnerAccountListVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����������
	OwnerAccountQueryDO obj;
	obj.setAcctName(query.getAcctName());
	obj.setAcctLink(query.getAcctLink());
	obj.setAcctIdCard(query.getAcctIdCard());
	obj.setAcctType(query.getAcctType());
	OwnerAccountDAO dao;
	uint64_t count = dao.countOwnerAccountItem(obj);
	if (count <= 0)
	{
		return pages;
	}

	//��ҳ��ѯ����
	pages.setTotal(count);
	pages.calcPages();
	list<OwnerAccountItemDO> result = dao.selectOwnerAccountItemWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<OwnerAccountListVO> vr;
	for (OwnerAccountItemDO sub : result)
	{
		OwnerAccountListVO vo;
		vo.setAcctId(sub.getAcctId());
		vo.setAcctName(sub.getAcctName());
		vo.setAcctType(sub.getAcctType());
		if (sub.getAcctType() == "2003") {
			vo.setAcctTypeName(u8"�ֽ��˻�");
		}
		else if (sub.getAcctType() == "2004") {
			vo.setAcctTypeName(u8"�����˻�");
		}
		else if (sub.getAcctType() == "2005") {
			vo.setAcctTypeName(u8"�Ż�ȯ�˻�");
		}
		else if (sub.getAcctType() == "2006") {
			vo.setAcctTypeName(u8"����˻�");
		}
		else if (sub.getAcctType() == "2007") {
			vo.setAcctTypeName(u8"ʱ���˻�");
		}
		else{
			vo.setAcctTypeName(u8"δ֪�˻�");
		}
		vo.setAmount(sub.getAmount());
		vo.setObjType(sub.getObjType());
		vo.setObjId(sub.getObjId());
		vo.setStatusCd(sub.getStatusCd());
		vo.setPartId(sub.getPartId());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}

std::list<SelectOwnerVO> OwnerAccountService::listAllSelectOwner()
{
	std::list<SelectOwnerVO> res;
	OwnerAccountDAO dao;
	uint64_t count = dao.countSelectOwner();
	if (count <= 0)
	{
		return res;
	}
	std::list<SelectOwnerDO> result = dao.selectSelectOwner();
	for (SelectOwnerDO sub : result)
	{
		SelectOwnerVO vo;
		vo.setAge(sub.getAge());
		vo.setCreateTime(sub.getCreateTime());
		vo.setIdCard(sub.getIdCard());
		vo.setLink(sub.getLink());
		vo.setMemberId(sub.getMemberId());
		vo.setName(sub.getName());
		vo.setOwnerId(sub.getOwnerId());
		vo.setOwnerTypeCd(sub.getOwnerTypeCd());
		if (sub.getOwnerTypeCd() == "1001") {
			vo.setOwnerTypeName(u8"ҵ������");
		}
		else if (sub.getOwnerTypeCd() == "1002") {
			vo.setOwnerTypeName(u8"��ͥ��Ա");
		}
		else {
			vo.setOwnerTypeName(u8"δ֪����");
		}
		vo.setRemark(sub.getRemark());
		vo.setSex(sub.getSex());
		vo.setUserName(sub.getUserName());
		
		res.push_back(vo);
	}
	return res;
}

uint64_t OwnerAccountService::preStorageAccount(PreStorageDTO dto)
{
	OwnerAccountQueryDO obj;
	obj.setAcctName(dto.getOwnerName());
	obj.setAcctType(dto.getAcctType());
	OwnerAccountDAO dao;
	uint64_t count = dao.countOwnerAccountItem(obj);
	if (count <= 0)
	{
		return 9999;
	}
	//PreStorageDO msg;
	OwnerAccountItemDO data;
	std::list<OwnerAccountItemDO> result = dao.selectOwnerAccountItemWithPage(obj, 1, 1);
	for (OwnerAccountItemDO sub : result)
	{
		cout << dto.getPreStorageAmount() + sub.getAmount()<<endl;
		data.setAmount(dto.getPreStorageAmount()+sub.getAmount());
	}
	return dao.updateOwnerAccount(data) == 1;
}

PageVO<OwnerAccountDetailVO> OwnerAccountService::listAllOwnerAccountDetail(OwnerAccountDetailQuery query)
{
	PageVO<OwnerAccountDetailVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//��ѯ����������
	OwnerAccountDetailDO obj;
	obj.setAcctId(query.getAcctId());
	std::string name;
	OwnerAccountDAO dao;
	uint64_t count = dao.countOwnerAccountDetail(obj);
	list<OwnerAccountItemDO> result_item = dao.selectOwnerAccountItem(obj);
	for (OwnerAccountItemDO sub : result_item)
	{
		name = sub.getAcctName();
	}
	if (count <= 0)
	{
		return pages;
	}
	pages.setTotal(count);
	pages.calcPages();
	list<OwnerAccountDetailDO> result = dao.selectOwnerAccountDetailWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<OwnerAccountDetailVO> vr;
	for (OwnerAccountDetailDO sub : result)
	{
		OwnerAccountDetailVO vo;
		vo.setAcctId(sub.getAcctId());
		vo.setAcctName(name);
		vo.setAmount(sub.getAmount());
		vo.setDetailType(sub.getDetailType());
		vo.setObjType(sub.getObjType());
		vo.setObjId(sub.getObjId());
		vo.setStatusCd(sub.getStatusCd());
		vo.setOrderId(sub.getOrderId());
		vo.setRemark(sub.getRemark());
		vo.setTransactionTime(sub.getTransactionTime());
		vo.setDetailId(sub.getDetailId());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}
