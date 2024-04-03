#ifndef _DEPART_CONTROLLER_
#define _DEPART_CONTROLLER_

#include "../../domain/dto/user/depart/AddDepartDTO.h"
#include "../../domain/dto/user/depart/AddDepartMoreDTO.h"
#include "../../domain/vo/JsonVO.h"
#include "../../domain/vo/user/depart/AddDepartVO.h"
#include "../../domain/vo/user/depart/AddDepartMoreVO.h"

class DepartController
{
public:
	CREATE_API_FUN_BODY(addDepart, execAddDepart, AddDepartDTO);
	CREATE_API_FUN_JSON(addDepartMore, execAddDepartMore, AddDepartMoreDTO);
private:
	//执行部门添加
	JsonVO<AddDepartVO> execAddDepart(AddDepartDTO dto);
	JsonVO<AddDepartMoreVO> execAddDepartMore(AddDepartMoreDTO dto);
};

#endif // _DEPART_CONTROLLER_