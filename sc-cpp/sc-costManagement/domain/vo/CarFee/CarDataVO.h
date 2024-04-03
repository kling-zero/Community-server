#ifndef _CARDATAVO_H_
#define _CARDATAVO_H_
#include "../../GlobalInclude.h"
#include "../setting/FeeTypeVO.h"
#include "ChargingItemVO.h"
#include "ParkingVO.h"

class CarDataVO
{
private:
    // 收费范围
    CC_SYNTHESIZE(string, id, ID);
    // 费用类型
    CC_SYNTHESIZE(FeeTypeVO, feeType, FeeType);
    // 收费项目
    CC_SYNTHESIZE(ChargingItemVO, chargingItem, ChargingItemVO);
    // 停车场
    CC_SYNTHESIZE(ParkingVO, parking, Parking);
    // 车位状态
    CC_SYNTHESIZE(string, state, State);
    // 计费起始时间
    CC_SYNTHESIZE(string, startTime, StartTime);
    // 计费结束时间
    CC_SYNTHESIZE(string, endTime, EndTime);
public:
    BIND_TO_JSON(CarDataVO, id, feeType, chargingItem, parking, state, startTime, endTime);
    CarDataVO() {
        id = u8"1";
        feeType = FeeTypeVO();
        chargingItem = ChargingItemVO();
        parking = ParkingVO();
        state = u8"已出售";
        startTime = u8"2020-10-09";
        endTime = u8"2020-10-09";
    }
};
#endif // !_CARDATAVO_H_
