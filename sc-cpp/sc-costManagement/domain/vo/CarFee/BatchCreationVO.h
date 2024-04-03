#ifndef _BATCHCREATIONVO_H_
#define _BATCHCREATIONVO_H_
#include "../../GlobalInclude.h"
#include "CarDataVO.h"
#include "ChargeRangeVO.h"
#include <map>

/**
 * 批量创建
 */

class BatchCreationVO
{
    // 收费范围
    CC_SYNTHESIZE(std::list<ChargeRangeVO>, chargeRange, ChargeRangeVO);
    // 数据
    CC_SYNTHESIZE_MAP(std::string, CarDataVO, carData, CarDataVO);

public:
    BIND_TO_JSON(BatchCreationVO, chargeRange, carData);
};
#endif // !_BATCHCREATIONVO_H_