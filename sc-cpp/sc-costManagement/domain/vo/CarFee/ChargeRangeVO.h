#ifndef _CHARGERANGEVO_H_
#define _CHARGERANGEVO_H_
#include "../../GlobalInclude.h"

/**
 * �շѷ�Χ
 */
class ChargeRangeVO
{
public:
    BIND_TO_JSON(ChargeRangeVO, id, description);
    ChargeRangeVO(string id = u8"1", string description = u8"С��") {}
private:
    // ��������
    CC_SYNTHESIZE(string, description, Description);
    // ����ID
    CC_SYNTHESIZE(long, id, Id);
};
#endif // !_CHARGERANGEVO_H_