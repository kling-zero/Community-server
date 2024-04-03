#include "stdafx.h"
#include "ComboItemController.h"

JsonVO<std::list<FeeNameVO>> ComboItemController::execQueryFeeName()
{
    std::list<FeeNameVO> data;
    data.push_back(FeeNameVO());
    JsonVO<std::list<FeeNameVO>> res;
    res.success(data);
    return res;
}

JsonVO<std::list<UserMenuVO>> ComboItemController::execQueryUserMenu()
{
    std::list<UserMenuVO> data;
    data.push_back(UserMenuVO());
    JsonVO<std::list<UserMenuVO>> res;
    res.success(data);
    return res;
}

JsonVO<PageVO<ComboListVO>> ComboItemController::execQueryComboList(ComboItemQuery query)
{
    PageVO<ComboListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10, { ComboListVO() });
    JsonVO<PageVO<ComboListVO>> res;
    res.success(data);
    return res;
}

JsonVO<PageVO<FeeComboMemberListVO>> ComboItemController::execQueryFeeComboMemberList(FeeComboMemberListQuery query)
{
    PageVO<FeeComboMemberListVO> data(query.getPageIndex(), query.getPageSize(), 100, 10,{FeeComboMemberListVO()});
    JsonVO<PageVO<FeeComboMemberListVO>> res;
    res.success(data);
    return res;
}

JsonVO<uint64_t> ComboItemController::execAddFeeCombo(ComboDTO dto)
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

JsonVO<uint64_t> ComboItemController::execAddFeeItem(FeeItemDTO dto)
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

JsonVO<uint64_t> ComboItemController::execModifyFeeCombo(ComboDTO dto)
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

JsonVO<uint64_t> ComboItemController::execRemoveFeeCombo(ComboDTO dto)
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

JsonVO<uint64_t> ComboItemController::execRemoveFeeItem(FeeItemDTO dto)
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
