#ifndef _ROOMMANAGESERVICE_H_
#define _ROOMMANAGESERVICE_H_
#include "domain/vo/PageVO.h"
#include "domain/vo/RoomManage/RoomStateVO.h"
#include "domain/vo/RoomManage/RoomTypeVO.h"
#include "domain/vo/RoomManage/FloorAndUnitVO.h"
#include "domain/do/RoomManage/C_StatusDO.h"
#include "domain/do/RoomManage/t_dictDO.h"
#include "domain/do/RoomManage/FloorAndUnitDO.h"
#include "domain/query/RoomManage/FloorAndUnitQuery.h"
#include "dao/RoomManage/RoomManageDAO.h"
#include "domain/dto/AddUnit/AddUnitDTO.h"
#include <domain/do/RoomManage/AddUnitDO.h>


class RoomManageService {
public:
    std::list<RoomStateVO> getRoomState();
    std::list<RoomTypeVO> getRoomType();
    std::list<FloorAndUnitVO> listFloorAndUnit(FloorAndUnitQuery query); // 直接根据communityId返回FloorAndUnit列表
    uint64_t saveData(AddUnitDTO dto);
    bool removeData(std::string unit_num);
    bool updateData(AddUnitDTO dto);
};
#endif // !_ROOMMANAGESERVICE_H_