#include "stdafx.h"
#include "OwnerCarService.h"
#include "../../../dao/OwnerVehicle/OwnerCar/OwnerCarDAO.h"

uint64_t OwnerCarService::saveData(AddOwnerCarDTO dto)
{
	//��װ����
	AddOwnerCarDO data;
	data.setCarAttrs(dto.getCarAttrs());
	data.setCarBrand(dto.getCarBrand());
	data.setCarColor(dto.getCarColor());
	data.setCarNum(dto.getCarNum());
	data.setCarNumType(dto.getCarNumType());
	data.setCarType(dto.getCarType());
	data.setCommunityId(dto.getCommunityId());
	data.setEndTime(dto.getEndTime());
	data.setFlowComponent(dto.getFlowComponent());
	data.setOwnerId(dto.getOwnerId());
	data.setPsId(dto.getPsId());
	data.setRemark(dto.getRemark());
	data.setStartTime(dto.getStartTime());
	data.setValue(dto.getValue());

	//ִ���������
	OwnerCarDAO dao;
	return dao.insert(data);
}



bool OwnerCarService::updateData(EditOwnerCarDTO dto)
{
	//��װ��������
	EditOwnerCarDO data;
	data.setCarBrand(dto.getCarBrand());
	data.setCarColor(dto.getCarColor());
	data.setCarId(dto.getCarId());
	data.setCarNum(dto.getCarNum());
	data.setCarNumType(dto.getCarNumType());
	data.setCarType(dto.getCarType());
	data.setCommunityId(dto.getCommunityId());
	data.setEndTime(dto.getEndTime());
	data.setMemberId(dto.getMemberId());
	data.setRemark(dto.getRemark());
	data.setStartTime(dto.getStartTime());
	//ִ�������޸�
	OwnerCarDAO dao;
	return dao.update(data) == 1;
}


bool OwnerCarService::removeData(std::string id)
{
	OwnerCarDAO dao;
	return dao.deleteById(id) == 1;
}