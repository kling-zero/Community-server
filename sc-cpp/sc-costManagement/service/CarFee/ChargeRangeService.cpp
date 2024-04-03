#include "stdafx.h"
#include "ChargeRangeService.h"
#include "dao/CarFee/ChargeRangeDAO.h"
#include "domain/do/CarFee/ChargeRangeDO.h"

std::list<ChargeRangeVO> ChargeRangeService::listAll()
{
	ChargeRangeDO obj;
	ChargeRangeDAO dao;


	list<ChargeRangeDO> result = dao.selectRange(obj);

	list<ChargeRangeVO> vr;
	for (ChargeRangeDO sub : result)
	{
		ChargeRangeVO vo;
		vo.setDescription(sub.getDescription());
		vo.setId(sub.getId());
		vr.push_back(vo);
	}
	return vr;
}
