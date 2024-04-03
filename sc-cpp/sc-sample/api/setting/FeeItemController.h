/**
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: awei
 * @Date: 2022/10/16 20:41:31
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#ifndef _FEETYPECONTROLLER_H_
#define _FEETYPECONTROLLER_H_
#include "domain/vo/JsonVO.h"
#include "domain/vo/setting/FeeTypeVO.h"
#include "api/ApiHelper.h"
#include "domain/vo/PageVO.h"
#include "domain/vo/setting/FeeListVO.h"
#include "domain/query/setting/FeeItemQuery.h"
/**
 * 费用选项接口
 */
class FeeItemController
{
public:
	CREATE_API_FUN_QUERY3(queryFeeType, executeQueryFeeType);
	CREATE_API_FUN_QUERY(queryFeeList, executeQueryFeeList, FeeItemQuery);
private:
	JsonVO<std::list<FeeTypeVO>> executeQueryFeeType();
	JsonVO<PageVO<FeeListVO>> executeQueryFeeList(FeeItemQuery query);
};

#endif // _FEETYPECONTROLLER_H_
