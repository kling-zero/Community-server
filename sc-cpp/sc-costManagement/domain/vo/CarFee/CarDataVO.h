#ifndef _CARDATAVO_H_
#define _CARDATAVO_H_
#include "../../GlobalInclude.h"
#include "../setting/FeeTypeVO.h"
#include "ChargingItemVO.h"
#include "ParkingVO.h"

class CarDataVO
{
private:
    // �շѷ�Χ
    CC_SYNTHESIZE(string, id, ID);
    // ��������
    CC_SYNTHESIZE(FeeTypeVO, feeType, FeeType);
    // �շ���Ŀ
    CC_SYNTHESIZE(ChargingItemVO, chargingItem, ChargingItemVO);
    // ͣ����
    CC_SYNTHESIZE(ParkingVO, parking, Parking);
    // ��λ״̬
    CC_SYNTHESIZE(string, state, State);
    // �Ʒ���ʼʱ��
    CC_SYNTHESIZE(string, startTime, StartTime);
    // �Ʒѽ���ʱ��
    CC_SYNTHESIZE(string, endTime, EndTime);
public:
    BIND_TO_JSON(CarDataVO, id, feeType, chargingItem, parking, state, startTime, endTime);
    CarDataVO() {
        id = u8"1";
        feeType = FeeTypeVO();
        chargingItem = ChargingItemVO();
        parking = ParkingVO();
        state = u8"�ѳ���";
        startTime = u8"2020-10-09";
        endTime = u8"2020-10-09";
    }
};
#endif // !_CARDATAVO_H_
