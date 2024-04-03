#include "stdafx.h"
#include "DepartController.h"

JsonVO<AddDepartVO> DepartController::execAddDepart(AddDepartDTO dto)
{
	//ת����VO
	AddDepartVO vo;
	vo.setDepartName(dto.getDepartName());
	vo.setMail(dto.getMail());
	vo.setPhone(dto.getPhone());
	//���ؽ��
	return JsonVO<AddDepartVO>(vo, RS_SUCCESS);
}

JsonVO<AddDepartMoreVO> DepartController::execAddDepartMore(AddDepartMoreDTO dto)
{
	//ת����VO
	AddDepartMoreVO vo;
	vo.setDepartName(dto.getOther().front().getDepartName());
	vo.setMail(dto.getOther().front().getMail());
	vo.setPhone(dto.getOther().front().getPhone());
	vo.setId(dto.getId());
	//���ؽ��
	return JsonVO<AddDepartMoreVO>(vo, RS_SUCCESS);
}
