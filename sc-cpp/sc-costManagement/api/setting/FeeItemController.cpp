#include "stdafx.h"
#include "FeeItemController.h"


JsonVO<std::list<FeeTypeVO>> FeeItemController::executeQueryFeeType()
{
    std::list<FeeTypeVO> data;
    data.push_back(FeeTypeVO());
    JsonVO<std::list<FeeTypeVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<FeeFlagVO>> FeeItemController::executeQueryFeeFlag()
{
    std::list<FeeFlagVO> data;
    data.push_back(FeeFlagVO());
    JsonVO<std::list<FeeFlagVO>> res;
    res.success(data);
    return res;
}

JsonVO<PageVO<FeeListVO>> FeeItemController::executeQueryFeeList(FeeItemQuery query)
{
    PageVO<FeeListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, {FeeListVO()});
    JsonVO<PageVO<FeeListVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<PaymentCdVO>> FeeItemController::executeQueryPaymentCd()
{
    std::list<PaymentCdVO> data;
    data.push_back(PaymentCdVO());
    JsonVO<std::list<PaymentCdVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<BillTypeVO>> FeeItemController::executeQueryBillType()
{
    std::list<BillTypeVO> data;
    data.push_back(BillTypeVO());
    JsonVO<std::list<BillTypeVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<IsDefaultVO>> FeeItemController::executeQueryIsDefault()
{
    std::list<IsDefaultVO> data;
    data.push_back(IsDefaultVO());
    JsonVO<std::list<IsDefaultVO>> res;
    res.success(data);
    return res;
}

JsonVO<uint64_t> FeeItemController::execAddFeeConfig(FeeConfigDTO dto)
{
    JsonVO<uint64_t> res;
    //Service service
    //uint64_t id = service.addData()
    int id = 1;
    if (id >= 1) {
        res.success(id);
    }
    else {
        res.fail(id);
    }
    return res;
}

JsonVO<uint64_t> FeeItemController::execAddDiscount(DiscountDTO dto)
{
    JsonVO<uint64_t> res;
    //Service

    int id = 1;
    if (id >= 1) {
        res.success(id);
    }
    else {
        res.fail(id);
    }
    return res;
}

JsonVO<uint64_t> FeeItemController::execModifyFeeConfig(FeeConfigDTO dto)
{
    JsonVO<uint64_t> res;
    //Service
    int id = 1;
    if (id >= 1) {
        res.success(id);
    }else{
        res.fail(id);
    }
    return res;
}

JsonVO<uint64_t> FeeItemController::execRemoveFeeConfig(FeeConfigDTO dto)
{
    JsonVO<uint64_t> res;
    //Service

    int id = 1;
    if (id >= 1) {
        res.success(id);
    }
    else {
        res.fail(id);
    }
    return res;
}

JsonVO<uint64_t> FeeItemController::execRemoveDiscount(DiscountDTO dto)
{
    JsonVO<uint64_t> res;
    //service

    int id = 1;
    if (id >= 1) {
        res.success(id);
    }
    else {
        res.fail(id);
    }
    return res;
}
