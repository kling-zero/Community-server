#include "stdafx.h"
#include "DepartController.h"

JsonVO<AddDepartVO> DepartController::execAddDepart(AddDepartDTO dto)
{
	//转换成VO
	AddDepartVO vo;
	vo.setDepartName(dto.getDepartName());
	vo.setMail(dto.getMail());
	vo.setPhone(dto.getPhone());
	//返回结果
	return JsonVO<AddDepartVO>(vo, RS_SUCCESS);
}

JsonVO<AddDepartMoreVO> DepartController::execAddDepartMore(AddDepartMoreDTO dto)
{
	//转换成VO
	AddDepartMoreVO vo;
	vo.setDepartName(dto.getOther().front().getDepartName());
	vo.setMail(dto.getOther().front().getMail());
	vo.setPhone(dto.getOther().front().getPhone());
	vo.setId(dto.getId());
	//返回结果
	return JsonVO<AddDepartMoreVO>(vo, RS_SUCCESS);
}
