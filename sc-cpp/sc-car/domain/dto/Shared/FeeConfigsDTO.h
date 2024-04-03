#ifndef _FEECONFIGDTO_H_
#define _FEECONFIGDTO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/21 14:14:30
* 业主车辆-费用-历史-费用项详情
* 对应 owner.listFeeConfigs
*/
class FeeConfigsDTO
{
	//附加/固定费用
	CC_SYNTHESIZE(std::string, additionalAmount, AdditionalAmount);
	//催缴类型编号
	CC_SYNTHESIZE(std::string, billType, BillType);
	//催缴类型名称
	CC_SYNTHESIZE(std::string, billTypeName, BillTypeName);
	//公式编号	
	CC_SYNTHESIZE(std::string, computingFormula, BomputingFormula);
	//公式名称
	CC_SYNTHESIZE(std::string, computingFormulaName, ComputingFormulaName);
	//未知
	CC_SYNTHESIZE(std::string, computingFormulaText, ComputingFormulaText);
	//费用项ID
	CC_SYNTHESIZE(std::string, configId, ConfigId);
	//未知
	CC_SYNTHESIZE(std::string, deductFrom, DeductFrom);
	//计费终止时间
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//费用标识编号
	CC_SYNTHESIZE(std::string, feeFlag, FeeFlag);
	//费用标识名称
	CC_SYNTHESIZE(std::string, feeFlagName, FeeFlagName);
	//收费项目
	CC_SYNTHESIZE(std::string, feeName, FeeName);
	//费用类型编号
	CC_SYNTHESIZE(std::string, feeTypeCd, FeeTypeCd);
	//费用类型名称
	CC_SYNTHESIZE(std::string, feeTypeCdName, FeeTypeCdName);
	//未知
	CC_SYNTHESIZE(std::string, isDefault, IsDefault);
	//未知
	CC_SYNTHESIZE(std::string, paymentCd, PaymentCd);
	//缴费周期
	CC_SYNTHESIZE(std::string, paymentCycle, PaymentCycle);
	//计费单价
	CC_SYNTHESIZE(std::string, squarePrice, SquarePrice);
	//计费起始时间
	CC_SYNTHESIZE(std::string, startTime, StartTime);

public:
	friend void from_json(const json& j, FeeConfigsDTO& t);
	BIND_TO_JSON(FeeConfigsDTO, additionalAmount, billType, billTypeName, computingFormula, computingFormulaName, computingFormulaText, configId, deductFrom, endTime, feeFlag, feeFlagName, feeName ,feeTypeCd, feeTypeCdName, isDefault, paymentCd, paymentCycle, squarePrice, startTime);
};

#endif //_LISTFEECONFIGSVO_H_