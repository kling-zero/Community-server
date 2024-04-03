#include "stdafx.h"
#include "FeeFormulaService.h"
#include "../../dao/feeformula/FeeFormulaDAO.h"

PageVO<FeeFormulaVO> FeeFormulaService::listAll(FeeFormulaQuery query)
{
	//构建返回对象
	PageVO<FeeFormulaVO> pages;
	pages.setPageIndex(query.getPageIndex());
	pages.setPageSize(query.getPageSize());

	//查询数据总条数count
	FeeFormulaDO obj;
	FeeFormulaDAO dao;
	long count = dao.count(obj);
	if (count <= 0)
	{
		return pages;
	}

	//分页查询数据
	pages.setTotal(count);
	pages.calcPages();
	list<FeeFormulaDO> result = dao.selectWithPage(obj, query.getPageIndex(), query.getPageSize());
	list<FeeFormulaVO> vr;
	for (FeeFormulaDO obj : result)
	{
		FeeFormulaVO vo;
		vo.setFormulaId(obj.getFormulaId());
		vo.setFormulaType(obj.getFormulaType());
		vo.setFormulaValue(obj.getFormulaValue());
		vo.setFormulaDesc(obj.getFormulaDesc());
		vo.setPrice(obj.getPrice());
		vr.push_back(vo);
	}
	pages.setRows(vr);
	return pages;
}

uint64_t FeeFormulaService::saveData(FeeFormulaDTO dto)
{
	//组装数据
	FeeFormulaDO data;
	data.setFormulaType(1);
	data.setFormulaValue(dto.getFormulaValue());
	data.setFormulaDesc(dto.getFormulaDesc());
	data.setPrice(dto.getPrice());
	//执行数据添加
	FeeFormulaDAO dao;
	return dao.insert(data);
}

bool FeeFormulaService::updateData(FeeFormulaDTO dto)
{
	//组装数据
	FeeFormulaDO data;
	data.setFormulaType(1);
	data.setFormulaValue(dto.getFormulaValue());
	data.setFormulaDesc(dto.getFormulaDesc());
	data.setPrice(dto.getPrice());
	data.setFormulaId(dto.getFormulaId());
	//执行数据添加
	FeeFormulaDAO dao;
	return dao.update(data) == 1;
}

bool FeeFormulaService::removeData(uint64_t id)
{
	FeeFormulaDAO dao;
	return dao.remove(id) == 1;
}
