#include "stdafx.h"
#include "FeeImportItemController.h"

JsonVO<PageVO<FeeImportListVO>> FeeImportItemController::execQueryFeeImportList(FeeImportQuery query)
{
    PageVO<FeeImportListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { FeeImportListVO() });
    JsonVO<PageVO<FeeImportListVO>> res;
    res.success(data);
    return res;
}

JsonVO<PageVO<ImportFeeDetailVO>> FeeImportItemController::execQueryFeeImportDetail(FeeImportDetailQuery query)
{
    PageVO<ImportFeeDetailVO> data(query.getPageIndex(), query.getPageSize(), 100, 10,{ImportFeeDetailVO()});
    JsonVO<PageVO<ImportFeeDetailVO>> res;
    res.success(data);
    return res;
}



JsonVO<std::list<FeeTypeVO>> FeeImportItemController::execQueryFeeType()
{
    std::list<FeeTypeVO> data;
    data.push_back(FeeTypeVO());
    JsonVO<std::list<FeeTypeVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<FeeFormulVO>> FeeImportItemController::execQueryFeeFormul()
{
    std::list<FeeFormulVO> data;
    data.push_back(FeeFormulVO());
    JsonVO<std::list<FeeFormulVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<FloorNumVO>> FeeImportItemController::execQueryFloorNum()
{
    std::list<FloorNumVO> data;
    data.push_back(FloorNumVO());
    JsonVO<std::list<FloorNumVO>> res;
    res.success(data);
    return res;
}
