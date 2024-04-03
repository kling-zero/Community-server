#ifndef _OWNERMENBERSERVICE_H_
#define _OWNERMENBERSERVICE_H_

#include<list>
#include "../../domain/vo/PageVO.h"
#include "../../domain/vo/OwnerMember/OwnerItemVO.h"
#include "../../domain//query/OwnerMember/OwnerItemQuery.h"
#include "../../domain/dto/OwnerMember/AddMemberDTO.h"
/*
	@Author:niuniu
	@Date:2022/10/30
	业主成员Service：将Query/Dto转化为Do
*/
class OwnerMemberService
{
public:
	PageVO<OwnerItemVO> listAll(OwnerItemQuery query);
	//uint64_t saveData( dto);
	//bool updateData( dto);
	//bool removeData(int id);

};
#endif // !_OWNERMENBERSERVICE_H_
