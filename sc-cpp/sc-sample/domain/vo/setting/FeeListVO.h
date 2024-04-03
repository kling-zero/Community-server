/**
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: awei
 * @Date: 2022/10/16 20:33:59
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
#ifndef _FEELISTVO_H_
#define _FEELISTVO_H_

#include "../../GlobalInclude.h"

 /**
  * 费用项列表
  * @Author: awei
  * @Date: 2022/10/16 20:29:08
  */
class FeeListVO
{
	//
	CC_SYNTHESIZE(double, additionalAmount, additionalAmount);
	//
	CC_SYNTHESIZE(std::string, billType, BillType);
	CC_SYNTHESIZE(std::string, billTypeName, BillTypeName);
	CC_SYNTHESIZE(std::string, computingFormula, ComputingFormula);
	CC_SYNTHESIZE(std::string, computingFormulaName, ComputingFormulaName);
	CC_SYNTHESIZE(std::string, computingFormulaText, ComputingFormulaText);
	CC_SYNTHESIZE(std::string, configId, ConfigId);
	CC_SYNTHESIZE(std::string, deductFrom, DeductFrom);
	CC_SYNTHESIZE(std::string, endTime, EndTime);

public:
	BIND_TO_JSON(FeeListVO, additionalAmount, billType);
	FeeListVO() {
		additionalAmount = 200;
		billType = u8"押金";
	}
};


#endif // _FEELISTVO_H_
