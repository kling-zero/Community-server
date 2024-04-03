#include "stdafx.h"
#include "OwnerVehicleController.h"
#include "../../service/OwnerVehicle/OwnerCar/ChooseParkService.h"
#include "../../service/OwnerVehicle/OwnerCar/ChooseOwnerService.h"
#include "../../service/OwnerVehicle/OwnerCar/CarInfoService.h"
#include "../../service/OwnerVehicle/OwnerCar/OwnerCarService.h"




JsonVO<PageVO<CarInfoVO>> OwnerVehicleController::executeQueryCarInfo(CarInfoQuery query)
{
	//定义一个Service
	CarInfoService service;
	//查询数据
	PageVO<CarInfoVO> result = service.listAll(query);
	//响应结果
	return JsonVO<PageVO<CarInfoVO>>(result, RS_SUCCESS);
}

JsonVO<PageVO<ChooseParkVO>> OwnerVehicleController::executeQueryChoosePark(ChooseParkQuery query)
{
	//定义一个Service
	ChooseParkService service;
	//查询数据
	PageVO<ChooseParkVO> result = service.listAll(query);
	//响应结果
	return JsonVO<PageVO<ChooseParkVO>>(result, RS_SUCCESS);
}

JsonVO<PageVO<ChooseOwnerVO>> OwnerVehicleController::executeQueryChooseOwner(ChooseOwnerQuery query)
{
	//定义一个Service
	ChooseOwnerService service;
	//查询数据
	PageVO<ChooseOwnerVO> result = service.listAll(query);
	//响应结果
	return JsonVO<PageVO<ChooseOwnerVO>>(result, RS_SUCCESS);
}

JsonVO<uint64_t> OwnerVehicleController::executeDTOAddOwnerCar(AddOwnerCarDTO dto)
{
	JsonVO<uint64_t> result;
	OwnerCarService service;
	//执行数据新增
	uint64_t id = service.saveData(dto);
	if (id > 0) {
		result.success(id);
	}
	else {
		result.fail(id);
	}
	//响应结果
	return result;
}

JsonVO<std::string> OwnerVehicleController::executeDTOEditOwnerCar(EditOwnerCarDTO dto)
{
	OwnerCarService service;
	JsonVO<std::string> result;
	if (service.updateData(dto)) {
		result.success(dto.getCarId());
	}
	else {
		result.fail(dto.getCarId());
	}
	return result;
}

JsonVO<std::string> OwnerVehicleController::executeDTODelOwnerCar(DelOwnerCarDTO dto)
{
	OwnerCarService service;
	JsonVO<std::string> result;
	if (service.removeData(dto.getCarNum())) {
		result.success(dto.getCarNum());
	}
	else {
		result.fail(dto.getCarNum());
	}
	//响应结果
	return result;
}


JsonVO<FeeTypeVO> OwnerVehicleController::executeQueryFeeType(FeeTypeQuery query)
{
	FeeTypeVO data;
	JsonVO<FeeTypeVO> res;
	res.success(data);
	return res;
}

JsonVO<AddFeeListVO> OwnerVehicleController::executeDTOAddFeeList(AddFeeListDTO dto)
{
	AddFeeListVO data;
	JsonVO<AddFeeListVO> res;
	res.success(data);
	return res;
}

JsonVO<UniversalVO> OwnerVehicleController::executeDTOEditFeeList(EditFeeListDTO dto)
{
	UniversalVO data;
	JsonVO<UniversalVO> res;
	res.success(data);
	return res;
}


JsonVO<UniversalVO> OwnerVehicleController::executeDTODelFeeList(DelFeeListDTO dto)
{
	UniversalVO data;
	JsonVO<UniversalVO> res;
	res.success(data);
	return res;
}






JsonVO<PageVO<CarInfoVO>> OwnerVehicleController::executeQueryOwnerCarMember(OwnerCarMemberQuery query)
{
	PageVO<CarInfoVO> data;
	JsonVO<PageVO<CarInfoVO>> res;
	res.success(data);
	return res;
}

JsonVO<UniversalVO> OwnerVehicleController::executeDTOAddOwnerCarMember(AddOwnerCarMemberDTO query)
{
	UniversalVO data;
	JsonVO<UniversalVO> res;
	res.success(data);
	return res;
}

JsonVO<UniversalVO> OwnerVehicleController::executeDTODelOwnerCarMember(DelOwnerCarMemberDTO query)
{
	UniversalVO data;
	JsonVO<UniversalVO> res;
	res.success(data);
	return res;
}

JsonVO<UniversalVO> OwnerVehicleController::executeDTOEditOwnerCarMember(EditOwnerCarDTO query)
{
	UniversalVO data;
	JsonVO<UniversalVO> res;
	res.success(data);
	return res;
}

