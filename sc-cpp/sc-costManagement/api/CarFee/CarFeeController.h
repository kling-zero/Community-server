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
* �����շѽӿ�
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
	// �����շ�
	JsonVO<PageVO<CarFeeListVO>> execQueryCarFeeList(CarFeeQuery query);
	// ��λ״̬
	JsonVO<std::list<CarStateVO>> execQueryCarState();
	// ��������
	JsonVO<std::list<FeeTypeVO>> execQueryFeetype();
	// �鿴�շ�
	JsonVO<PageVO<CheckChargesVO>> execQueryCheckCharges();
	// ��������
	JsonVO<CheckChargesVO> execJsonCreateFee(CreateFeeDTO dto);
	// ͣ����
	JsonVO<ParkingVO> execQueryParking();
	// ȡ������
	JsonVO<long> execRemoveCarFee(CancelDTO dto);
	// ���
	JsonVO<long> execModifyCarFee(ModifyCarFeeDTO dto);
	// �ɷ���ʷ��ѯ
	JsonVO<PageVO<PaymentHistoryVO>> execQueryPaymentHistory(PaymentHistoryQuery query);
	// �շѷ�Χ
	JsonVO<std::list<ChargeRangeVO>> execQueryChargeRange();
	// �շ���Ŀ
	JsonVO<std::list<ChargingItemVO>>executeQueryChargingItem();
	// ��������
	JsonVO<BatchCreationVO> execJsonBatchCreation(BatchCreationDTO dto);
};

#endif // !__CARFEECONTROLLER_H_
