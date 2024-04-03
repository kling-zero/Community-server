#pragma once
#ifndef __CARFEECONTROLLER_H_
#define __CARFEECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/PageVO.h"
#include "domain/vo/CarFee/CarFeeListVO.h"
#include "domain/vo/CarFee/CarStateVO.h"
#include "domain/vo/setting/FeeTypeVO.h"
#include "domain/vo/CarFee/CheckChargesVO.h"
#include "domain/vo/CarFee/ParkingVO.h"
#include "domain/vo/CarFee/PaymentHistoryVO.h"
#include "domain/vo/CarFee/ChargeRangeVO.h"
#include "domain/vo/CarFee/ChargingItemVO.h"
#include "domain/vo/CarFee/CarDataVO.h"
#include "domain/vo/CarFee/BatchCreationVO.h"
#include "domain/query/CarFee/CarFeeQuery.h"
#include "domain/query/CarFee/PaymentHistoryQuery.h"
#include "domain/dto/CarFee/CreateFeeDTO.h"
#include "domain/dto/CarFee/CancelDTO.h"
#include "domain/dto/CarFee/ModifyCarFeeDTO.h"
#include "domain/dto/CarFee/BatchCreationDTO.h"
#include "api/ApiHelper.h"

/*
* 车辆收费接口
*/

class CarFeeController
{
public:
	CREATE_API_FUN_QUERY(queryCarFeeList, execQueryCarFeeList, CarFeeQuery);
	CREATE_API_FUN_QUERY3(queryCarState, execQueryCarState);
	CREATE_API_FUN_QUERY3(queryFeetype, execQueryFeetype);
	CREATE_API_FUN_QUERY3(queryCheckCharges, execQueryCheckCharges);
	CREATE_API_FUN_JSON(jsonCreateFee, execJsonCreateFee, CreateFeeDTO);
	CREATE_API_FUN_QUERY3(queryParking, execQueryParking);
	CREATE_API_FUN_BODY(removeCarFee, execRemoveCarFee, CancelDTO);
	CREATE_API_FUN_BODY(modifyCarFee, execModifyCarFee, ModifyCarFeeDTO);
	CREATE_API_FUN_QUERY(queryPaymentHistory, execQueryPaymentHistory, PaymentHistoryQuery);

	CREATE_API_FUN_QUERY3(queryChargeRange, execQueryChargeRange);

	CREATE_API_FUN_QUERY3(queryChargingItem, executeQueryChargingItem);
	CREATE_API_FUN_JSON(jsonBatchCreation, execJsonBatchCreation, BatchCreationDTO);
private:
	// 车辆收费
	JsonVO<PageVO<CarFeeListVO>> execQueryCarFeeList(CarFeeQuery query);
	// 车位状态
	JsonVO<std::list<CarStateVO>> execQueryCarState();
	// 费用类型
	JsonVO<std::list<FeeTypeVO>> execQueryFeetype();
	// 查看收费
	JsonVO<PageVO<CheckChargesVO>> execQueryCheckCharges();
	// 创建费用
	JsonVO<CheckChargesVO> execJsonCreateFee(CreateFeeDTO dto);
	// 停车场
	JsonVO<ParkingVO> execQueryParking();
	// 取消费用
	JsonVO<long> execRemoveCarFee(CancelDTO dto);
	// 变更
	JsonVO<long> execModifyCarFee(ModifyCarFeeDTO dto);
	// 缴费历史查询
	JsonVO<PageVO<PaymentHistoryVO>> execQueryPaymentHistory(PaymentHistoryQuery query);
	// 收费范围
	JsonVO<std::list<ChargeRangeVO>> execQueryChargeRange();
	// 收费项目
	JsonVO<std::list<ChargingItemVO>>executeQueryChargingItem();
	// 批量创建
	JsonVO<BatchCreationVO> execJsonBatchCreation(BatchCreationDTO dto);
};

#endif // !__CARFEECONTROLLER_H_
