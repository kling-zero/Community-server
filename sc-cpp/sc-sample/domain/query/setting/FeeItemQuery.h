/**
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: awei
 * @Date: 2022/10/16 20:49:48
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
#ifndef _FEEITEMQUERY_H_
#define _FEEITEMQUERY_H_
#include "../PageQuery.h"
/**
 * 费用项查询对象
 */
class FeeItemQuery : public PageQuery
{
	// 类型名称
	CC_SYNTHESIZE(std::string, configId, configId);
	// 类型名称
	CC_SYNTHESIZE(std::string, feeFlag, feeFlag);
	// 类型名称
	CC_SYNTHESIZE(std::string, billType, billType);
	CC_SYNTHESIZE(std::string, feeTypeCd, feeTypeCd);
	CC_SYNTHESIZE(std::string, isDefault, isDefault);
public:
	friend void from_json(const json& j, FeeItemQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, configId);
		BIND_FROM_TO_NORMAL(j, t, feeFlag);
	}
};

#endif // _FEEITEMQUERY_H_
