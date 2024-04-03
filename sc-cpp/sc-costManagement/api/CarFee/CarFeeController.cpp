#include "stdafx.h"
#include "CarFeeController.h"
#include "service/CarFee/CarFeeService.h"
#include "service/CarFee/ChargeRangeService.h"

JsonVO<PageVO<CarFeeListVO>> CarFeeController::execQueryCarFeeList(CarFeeQuery query)
{
	CarFeeService service;
	PageVO<CarFeeListVO> data = service.listAll(query);
	JsonVO<PageVO<CarFeeListVO>> res;
	res.success(data);
	return res;
}

JsonVO<std::list<CarStateVO>> CarFeeController::execQueryCarState()
{
	/*CarStateService service;

	std::list<CarStateVO> data = service.listAll();
	JsonVO<std::list<CarStateVO>> res;
	res.success(data);
	return res;*/

	CarStateVO v1;
	v1.setId(u8"1001");
	v1.setDescription(u8"正常状态");

	CarStateVO v2;
	v2.setId(u8"2002");
	v2.setDescription(u8"欠费");

	CarStateVO v3;
	v3.setId(u8"3003");
	v3.setDescription(u8"车位释放");

	std::list<CarStateVO> data;
	data.push_back(v1);
	data.push_back(v2);
	data.push_back(v3);

	JsonVO<std::list<CarStateVO>> res;
	res.success(data);
	return res;
}

JsonVO<std::list<FeeTypeVO>> CarFeeController::execQueryFeetype()
{
	std::list<FeeTypeVO> data({ FeeTypeVO() });
	JsonVO<std::list<FeeTypeVO>> res;
	res.success(data);
	return res;
}

JsonVO<PageVO<CheckChargesVO>> CarFeeController::execQueryCheckCharges()
{
	PageVO<CheckChargesVO> data(1, 2, 100, 10, { CheckChargesVO() });
	JsonVO<PageVO<CheckChargesVO>> res;
	res.success(data);
	return res;
}

JsonVO<CheckChargesVO> CarFeeController::execJsonCreateFee(CreateFeeDTO dto)
{
	CheckChargesVO vo;
	vo.setCarNum(dto.getCarNum());
	vo.setfeeTypeCdName(dto.getfeeTypeCdName());
	vo.setfeeName(dto.getfeeName());
	vo.setdeadlineTime(dto.getdeadlineTime());
	vo.setendTime(dto.getendTime());

	JsonVO<CheckChargesVO> res;
	res.success(vo);

	return res;
}

JsonVO<ParkingVO> CarFeeController::execQueryParking()
{
	ParkingVO data({ ParkingVO() });
	JsonVO<ParkingVO> res;
	res.success(data);
	return res;
}

JsonVO<long> CarFeeController::execRemoveCarFee(CancelDTO dto)
{
	JsonVO<long> res;
	res.success(123);
	//响应结果
	return res;
}

JsonVO<long> CarFeeController::execModifyCarFee(ModifyCarFeeDTO dto)
{
	JsonVO<long> res;
	res.success(123);
	//响应结果
	return res;
}

JsonVO<PageVO<PaymentHistoryVO>> CarFeeController::execQueryPaymentHistory(PaymentHistoryQuery query)
{
	PageVO<PaymentHistoryVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { PaymentHistoryVO() });
	JsonVO<PageVO<PaymentHistoryVO>> res;
	res.success(data);
	return res;
}

JsonVO<std::list<ChargeRangeVO>> CarFeeController::execQueryChargeRange()
{
	ChargeRangeService service;

	std::list<ChargeRangeVO> data = service.listAll();
	JsonVO<std::list<ChargeRangeVO>> res;
	res.success(data);
	return res;
}

JsonVO<std::list<ChargingItemVO>> CarFeeController::executeQueryChargingItem()
{
	std::list<ChargingItemVO> data;
	JsonVO<std::list<ChargingItemVO>> res;
	res.success(data);
	return res;
}

JsonVO<BatchCreationVO> CarFeeController::execJsonBatchCreation(BatchCreationDTO dto)
{
	BatchCreationVO vo;
	std::list<ChargeRangeVO> chargeRange;
	ChargeRangeVO v1, v2;
	v1.setId(1);
	v1.setDescription(u8"小区");
	chargeRange.push_back(v1);


	v2.setId(2);
	v2.setDescription(u8"停车场");
	chargeRange.push_back(v2);

	vo.setChargeRangeVO(chargeRange);

	std::map<string, CarDataVO> mp, tmp;

	ChargingItemVO v3;
	v3.setDescription(dto.getChargingItem());

	FeeTypeVO v4;
	v4.setDescription(dto.getFeeType());

	ParkingVO v5;
	v5.setNum(dto.getParking());

	//tmp["3"].setChargingItemVO(v3);
	//tmp["3"].setEndTime(dto.getEndTime());
	//tmp["3"].setFeeType(v4);
	//tmp["3"].setID("1");
	//tmp["3"].setStartTime(dto.getStartTime());
	//tmp["3"].setState(dto.getState());

	//if (dto.getID() == u8"1") {
	//	mp["1"] = tmp["3"];
	//}
	//else {
	//	mp["2"] = tmp["3"];
	//	mp["2"].setParking(v5);
	//	mp["2"].setID("2");
	//}

	mp["1"].setChargingItemVO(v3);
	mp["1"].setEndTime(dto.getEndTime());
	mp["1"].setFeeType(v4);
	mp["1"].setID("1");
	mp["1"].setStartTime(dto.getStartTime());
	mp["1"].setState(dto.getState());

	mp["2"] = mp["1"];
	mp["2"].setParking(v5);
	mp["2"].setID("2");

	vo.setCarDataVO(mp);
	JsonVO<BatchCreationVO> res;
	res.success(vo);
	return res;
}

