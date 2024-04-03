#ifndef _BATCHCREATIONVO_H_
#define _BATCHCREATIONVO_H_
#include "../../GlobalInclude.h"
#include "CarDataVO.h"
#include "ChargeRangeVO.h"
#include <map>

/**
 * ��������
 */

class BatchCreationVO
{
    // �շѷ�Χ
    CC_SYNTHESIZE(std::list<ChargeRangeVO>, chargeRange, ChargeRangeVO);
    // ����
    CC_SYNTHESIZE_MAP(std::string, CarDataVO, carData, CarDataVO);

public:
    BIND_TO_JSON(BatchCreationVO, chargeRange, carData);
};
#endif // !_BATCHCREATIONVO_H_