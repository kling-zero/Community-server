#ifndef _PARKINGSTATUSCONTROLLER_H_
#define _PARKINGSTATUSCONTROLLER_H_

#include "../../domain/vo/JsonVO.h"
#include "api/ApiHelper.h"
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/OwnerVehicle/CarInfoVO.h"
#include "../../domain/vo/OwnerVehicle/ChooseParkVO.h"
#include "../../domain/vo/OwnerVehicle/ChooseOwnerVO.h"
#include "../../domain/vo/OwnerVehicle/OwnerAccountVO.h"
#include "../../domain/vo/OwnerVehicle/FeeConfigsVO.h"
#include "../../domain/vo/OwnerVehicle/FeeTypeVO.h"
#include "../../domain/vo/OwnerVehicle/AddFeeListVO.h"

#include "../../domain/vo/UniversalVO.h"

#include "../../domain/query/OwnerVehicle/CarInfoQuery.h"
#include "../../domain/query/OwnerVehicle/ChooseParkQuery.h"
#include "../../domain/query/OwnerVehicle/ChooseOwnerQuery.h"
#include "../../domain/query/OwnerVehicle/OwnerAccountQuery.h"
#include "../../domain/query/OwnerVehicle/FeeTypeQuery.h"
#include "../../domain/query/OwnerVehicle/OwnerCarMemberQuery.h"


#include "../../domain/dto/OwnerVehicle/FeeListDTO/AddFeeListDTO.h"
#include "../../domain/dto/OwnerVehicle/FeeListDTO/EditFeeListDTO.h"
#include "../../domain/dto/OwnerVehicle/FeeListDTO/DelFeeListDTO.h"

#include "../../domain/dto/OwnerVehicle/OwnerCar/AddOwnerCarDTO.h"
#include "../../domain/dto/OwnerVehicle/OwnerCar/EditOwnerCarDTO.h"
#include "../../domain/dto/OwnerVehicle/OwnerCar/DelOwnerCarDTO.h"
#include "../../domain/dto/OwnerVehicle/OwnerCarMember/AddOwnerCarMemberDTO.h"
#include "../../domain/dto/OwnerVehicle/OwnerCarMember/DelOwnerCarMemberDTO.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 15:42:31
* 车位状态接口
*/
class OwnerVehicleController
{
public:
	//业主车辆-车辆信息查询
	CREATE_API_FUN_QUERY(queryCarInfo, executeQueryCarInfo, CarInfoQuery);
	//业主车辆中 选择停车位
	CREATE_API_FUN_QUERY(queryChoosePark, executeQueryChoosePark, ChooseParkQuery);
	//业主车辆-添加-选择业主
	CREATE_API_FUN_QUERY(queryChooseOwner, executeQueryChooseOwner, ChooseOwnerQuery);
	//添加业主车辆信息
	CREATE_API_FUN_BODY(dtoAddOwnerCar, executeDTOAddOwnerCar, AddOwnerCarDTO);
	//业主车辆-修改
	CREATE_API_FUN_BODY(dtoEditOwnerCar, executeDTOEditOwnerCar, EditOwnerCarDTO);
	//业主车辆-删除
	CREATE_API_FUN_BODY(dtoDelOwnerCar, executeDTODelOwnerCar, DelOwnerCarDTO);

	//业主车辆-费用-创建费用-费用类型
	CREATE_API_FUN_QUERY(queryFeeType, executeQueryFeeType, FeeTypeQuery);
	//业主车辆-费用-创建费用
	CREATE_API_FUN_BODY(dtoAddFeeList, executeDTOAddFeeList, AddFeeListDTO);
	//业主车辆-费用-变更
	CREATE_API_FUN_BODY(dtoEditFeeListDTO, executeDTOEditFeeList, EditFeeListDTO);
	//业主车辆-费用-取消（删除）
	CREATE_API_FUN_BODY(dtoDelFeeList, executeDTODelFeeList, DelFeeListDTO);
	
	//子母车辆查询
	CREATE_API_FUN_QUERY(queryOwnerCarMember, executeQueryOwnerCarMember, OwnerCarMemberQuery);
	//子母车辆-添加
	CREATE_API_FUN_BODY(dtoAddOwnerCarMember, executeDTOAddOwnerCarMember, AddOwnerCarMemberDTO);
	//子母车辆-删除
	CREATE_API_FUN_BODY(dtoDelOwnerCarMember, executeDTODelOwnerCarMember, DelOwnerCarMemberDTO);
	//子母车辆-修改
	CREATE_API_FUN_BODY(dtoEditOwnerCarMember, executeDTOEditOwnerCarMember, EditOwnerCarDTO);
	

private:
	//返回车辆信息的页面信息
	JsonVO<PageVO<CarInfoVO>>executeQueryCarInfo(CarInfoQuery query);
	JsonVO<PageVO<ChooseParkVO>>executeQueryChoosePark(ChooseParkQuery query);
	JsonVO<PageVO<ChooseOwnerVO>>executeQueryChooseOwner(ChooseOwnerQuery query);
	JsonVO<uint64_t>executeDTOAddOwnerCar(AddOwnerCarDTO dto);
	JsonVO<std::string>executeDTOEditOwnerCar(EditOwnerCarDTO dto);
	JsonVO<std::string>executeDTODelOwnerCar(DelOwnerCarDTO id);

	JsonVO<FeeTypeVO>executeQueryFeeType(FeeTypeQuery query);
	JsonVO<AddFeeListVO>executeDTOAddFeeList(AddFeeListDTO dto);
	JsonVO<UniversalVO>executeDTOEditFeeList(EditFeeListDTO dto);
	JsonVO<UniversalVO>executeDTODelFeeList(DelFeeListDTO dto);

	JsonVO<PageVO<CarInfoVO>>executeQueryOwnerCarMember(OwnerCarMemberQuery query);
	JsonVO<UniversalVO>executeDTOAddOwnerCarMember(AddOwnerCarMemberDTO query);
	JsonVO<UniversalVO>executeDTODelOwnerCarMember(DelOwnerCarMemberDTO query);
	//子母车辆的DTO字段 和 业主车辆的DTO字段 一样
	JsonVO<UniversalVO>executeDTOEditOwnerCarMember(EditOwnerCarDTO query);
	
};

#endif //_PARKINGSTATUSCONTROLLER_H_
