#pragma once
#ifndef _COMBOITEMCONTROLLER_H_
#define _COMBOITEMCONTROLLER_H_

#include"../../domain/vo/combo/ComboListVO.h"
#include"api/ApiHelper.h"
#include"../../domain/vo/JsonVO.h"
#include"../../domain/query/combo/ComboItemQuery.h"
#include"../../domain/query/PageQuery.h"
#include"../../domain/vo/PageVO.h"
#include"../../domain/dto/combo/ComboDTO.h"
#include"../../domain/dto/combo/FeeItemDTO.h"
#include"../../domain/vo/combo/FeeComboMemberListVO.h"
#include "../../domain/query/combo/FeeComboMemberListQuery.h"
#include"../../domain/vo/combo/FeeNameVO.h"

#include"../../domain/vo/combo/UserMenuVO.h"

class ComboItemController {
public:
	CREATE_API_FUN_QUERY3(queryFeeName, execQueryFeeName);
	CREATE_API_FUN_QUERY3(queryUserMenu, execQueryUserMenu);
	CREATE_API_FUN_QUERY(queryComboList, execQueryComboList, ComboItemQuery);
	CREATE_API_FUN_QUERY(queryFeeComboMemberList, execQueryFeeComboMemberList,FeeComboMemberListQuery);

	CREATE_API_FUN_BODY(addFeeCombo, execAddFeeCombo, ComboDTO);
	CREATE_API_FUN_BODY(addFeeItem, execAddFeeItem, FeeItemDTO);

	CREATE_API_FUN_BODY(modifyFeeCombo, execModifyFeeCombo, ComboDTO);

	CREATE_API_FUN_BODY(removeFeeCombo, execRemoveFeeCombo, ComboDTO);
	CREATE_API_FUN_BODY(removeFeeItem, execRemoveFeeItem, FeeItemDTO);
private:
	JsonVO<std::list<FeeNameVO>> execQueryFeeName();
	JsonVO<std::list<UserMenuVO>> execQueryUserMenu();
	JsonVO<PageVO<ComboListVO>>  execQueryComboList(ComboItemQuery query);
	JsonVO<PageVO<FeeComboMemberListVO>>  execQueryFeeComboMemberList(FeeComboMemberListQuery query);

	JsonVO<uint64_t> execAddFeeCombo(ComboDTO dto);
	JsonVO<uint64_t> execAddFeeItem(FeeItemDTO dto);

	JsonVO<uint64_t> execModifyFeeCombo(ComboDTO dto);

	JsonVO<uint64_t> execRemoveFeeCombo(ComboDTO dto);
	JsonVO<uint64_t> execRemoveFeeItem(FeeItemDTO dto);

};


#endif