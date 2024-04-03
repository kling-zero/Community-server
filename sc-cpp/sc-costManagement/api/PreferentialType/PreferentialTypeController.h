#pragma once
#define __CARFEECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/PageVO.h"
#include "domain/vo/PreferentialType/PreferentialTypeListVO.h"
#include "domain/query/PreferentialType/PreferentialTypeQuery.h"
#include "api/ApiHelper.h"


class PreferentialTypeController
{
public:
	CREATE_API_FUN_QUERY(queryPreferentialTypeList, executeQueryPreferentialTypeList, PreferentialTypeQuery);

private:
	JsonVO<PageVO<PreferentialTypeListVO>> executeQueryPreferentialTypeList(PreferentialTypeQuery query);

};


