#ifndef _BINDCONTROLLER_H_
#define _BINDCONTROLLER_H_

#include "domain/vo/BindOwner/CheckBindOwnerVO.h"
#include "domain/vo/BindOwner/CheckBindOwnerTypeVO.h"
#include "domain/vo/JsonVO.h"
#include "domain/vo/PageVO.h"
#include "domain/query/BindOwner/CheckBindOwnerItemQuery.h"
#include "domain/dto/BindOwner/ChangeBindOwnerState.h"
#include "api/ApiHelper.h"

/*****************
* @Author : kazimiyuuka
* @Time : 2022/10/20
* ****************
*/
class BindOwnerController
{
private:
	JsonVO<PageVO<CheckBindOwnerListVO>> executeQueryCheckList(CheckBindOwnerItemQuery query);
	JsonVO<std::list<CheckBindOwnerTypeVO>> executeQueryCheckType();
	JsonVO<ChangeBindReply> executeChangeBindState(ChangeBindOwnerState change);
public:
	CREATE_API_FUN_QUERY(queryCheckList, executeQueryCheckList,CheckBindOwnerItemQuery);
	CREATE_API_FUN_QUERY3(queryCheckType, executeQueryCheckType);
	CREATE_API_FUN_QUERY(changeBindState, executeChangeBindState, ChangeBindOwnerState);
	
};
#endif // _BINDCONTROLLER_H_

