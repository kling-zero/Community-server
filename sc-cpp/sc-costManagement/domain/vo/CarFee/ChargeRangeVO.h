#ifndef _CHARGERANGEVO_H_
#define _CHARGERANGEVO_H_
#include "../../GlobalInclude.h"

/**
 * 收费范围
 */
class ChargeRangeVO
{
public:
    BIND_TO_JSON(ChargeRangeVO, id, description);
    ChargeRangeVO(string id = u8"1", string description = u8"小区") {}
private:
    // 类型描述
    CC_SYNTHESIZE(string, description, Description);
    // 类型ID
    CC_SYNTHESIZE(long, id, Id);
};
#endif // !_CHARGERANGEVO_H_