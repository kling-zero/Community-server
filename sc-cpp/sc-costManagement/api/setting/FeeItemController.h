#ifndef _FEEITEMCONTROLLER_H_
#define _FEEITEMCONTROLLER_H_
#include"../../domain/vo/JsonVO.h"
#include"api/ApiHelper.h"
#include"../../domain/vo/setting/FeeTypeVO.h"
#include"../../domain/vo/setting/FeeListVO.h"
#include"../../domain/vo/PageVO.h"
#include"../../domain/query/setting/FeeItemQuery.h"
#include"../../domain/vo/setting/FeeFlagVO.h"
#include"../../domain/vo/setting/PaymentCdVO.h"
#include"../../domain/vo/setting/BillTypeVO.h"
#include"../../domain/vo/setting/IsDefaultVO.h"
#include"../../domain/dto/setting/FeeConfigDTO.h"
#include"../../domain/dto/setting/DiscountDTO.h"
class FeeItemController {
public:
	CREATE_API_FUN_QUERY3(queryFeeType,executeQueryFeeType);
	CREATE_API_FUN_QUERY3(queryFeeFlag, executeQueryFeeFlag);
	CREATE_API_FUN_QUERY3(queryPaymentCd, executeQueryPaymentCd);
	CREATE_API_FUN_QUERY3(queryBillType, executeQueryBillType);
	CREATE_API_FUN_QUERY3(queryIsDefault, executeQueryIsDefault);
	CREATE_API_FUN_QUERY(queryFeeList, executeQueryFeeList,FeeItemQuery);

	CREATE_API_FUN_BODY(addFeeConfig, execAddFeeConfig, FeeConfigDTO);
	CREATE_API_FUN_BODY(addDiscount, execAddDiscount, DiscountDTO);

	CREATE_API_FUN_BODY(modifyFeeConfig, execModifyFeeConfig, FeeConfigDTO);

	CREATE_API_FUN_BODY(removeFeeConfig, execRemoveFeeConfig,FeeConfigDTO);
	CREATE_API_FUN_BODY(removeDiscount, execRemoveDiscount, DiscountDTO);
private:
	JsonVO<std::list<FeeTypeVO>> executeQueryFeeType();
	JsonVO<std::list<FeeFlagVO>> executeQueryFeeFlag();
	JsonVO<PageVO<FeeListVO>> executeQueryFeeList(FeeItemQuery query);
	JsonVO <std::list<PaymentCdVO>> executeQueryPaymentCd();
	JsonVO<std::list<BillTypeVO>> executeQueryBillType();
	JsonVO<std::list<IsDefaultVO>> executeQueryIsDefault();

	JsonVO<uint64_t> execAddFeeConfig(FeeConfigDTO dto);
	JsonVO<uint64_t> execAddDiscount(DiscountDTO dto);

	JsonVO<uint64_t> execModifyFeeConfig(FeeConfigDTO dto);

	JsonVO<uint64_t> execRemoveFeeConfig(FeeConfigDTO dto);
	JsonVO<uint64_t> execRemoveDiscount(DiscountDTO dto);
};


#endif