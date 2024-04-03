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
* ��λ״̬�ӿ�
*/
class OwnerVehicleController
{
public:
	//ҵ������-������Ϣ��ѯ
	CREATE_API_FUN_QUERY(queryCarInfo, executeQueryCarInfo, CarInfoQuery);
	//ҵ�������� ѡ��ͣ��λ
	CREATE_API_FUN_QUERY(queryChoosePark, executeQueryChoosePark, ChooseParkQuery);
	//ҵ������-���-ѡ��ҵ��
	CREATE_API_FUN_QUERY(queryChooseOwner, executeQueryChooseOwner, ChooseOwnerQuery);
	//���ҵ��������Ϣ
	CREATE_API_FUN_BODY(dtoAddOwnerCar, executeDTOAddOwnerCar, AddOwnerCarDTO);
	//ҵ������-�޸�
	CREATE_API_FUN_BODY(dtoEditOwnerCar, executeDTOEditOwnerCar, EditOwnerCarDTO);
	//ҵ������-ɾ��
	CREATE_API_FUN_BODY(dtoDelOwnerCar, executeDTODelOwnerCar, DelOwnerCarDTO);

	//ҵ������-����-��������-��������
	CREATE_API_FUN_QUERY(queryFeeType, executeQueryFeeType, FeeTypeQuery);
	//ҵ������-����-��������
	CREATE_API_FUN_BODY(dtoAddFeeList, executeDTOAddFeeList, AddFeeListDTO);
	//ҵ������-����-���
	CREATE_API_FUN_BODY(dtoEditFeeListDTO, executeDTOEditFeeList, EditFeeListDTO);
	//ҵ������-����-ȡ����ɾ����
	CREATE_API_FUN_BODY(dtoDelFeeList, executeDTODelFeeList, DelFeeListDTO);
	
	//��ĸ������ѯ
	CREATE_API_FUN_QUERY(queryOwnerCarMember, executeQueryOwnerCarMember, OwnerCarMemberQuery);
	//��ĸ����-���
	CREATE_API_FUN_BODY(dtoAddOwnerCarMember, executeDTOAddOwnerCarMember, AddOwnerCarMemberDTO);
	//��ĸ����-ɾ��
	CREATE_API_FUN_BODY(dtoDelOwnerCarMember, executeDTODelOwnerCarMember, DelOwnerCarMemberDTO);
	//��ĸ����-�޸�
	CREATE_API_FUN_BODY(dtoEditOwnerCarMember, executeDTOEditOwnerCarMember, EditOwnerCarDTO);
	

private:
	//���س�����Ϣ��ҳ����Ϣ
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
	//��ĸ������DTO�ֶ� �� ҵ��������DTO�ֶ� һ��
	JsonVO<UniversalVO>executeDTOEditOwnerCarMember(EditOwnerCarDTO query);
	
};

#endif //_PARKINGSTATUSCONTROLLER_H_
