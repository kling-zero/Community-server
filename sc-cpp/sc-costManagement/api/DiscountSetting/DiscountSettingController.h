#pragma once
#define __CARFEECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/PageVO.h"
#include "domain/vo/DiscountSetting/DiscountListVO.h"
#include "domain/vo/DiscountSetting/DiscountTypeVO.h"
#include "domain/query/DiscountSetting/DiscountItemQuery.h"
#include "api/ApiHelper.h"


class DiscountSettingController
{
public:
	CREATE_API_FUN_QUERY(queryDiscountList, executeQueryDiscountList, DiscountItemQuery);
	CREATE_API_FUN_QUERY3(queryDiscountType, executeQueryDiscountType)
private:
	JsonVO<PageVO<DiscountListVO>> executeQueryDiscountList(DiscountItemQuery query);
	JsonVO<std::list<DiscountTypeVO>> executeQueryDiscountType();
};

