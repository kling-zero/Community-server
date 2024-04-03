#ifndef _BINDSERVICE_H_
#define _BINDSERVICE_H_
#include "domain/vo/PageVO.h"
#include "domain/vo/BindOwner/CheckBindOwnerTypeVO.h"
#include "domain/vo/BindOwner/CheckBindOwnerVO.h"
#include "domain/query/BindOwner/CheckBindOwnerItemQuery.h"
#include "domain/dto/BindOwner/ChangeBindOwnerState.h"
#include "domain/do/BindOwner/CheckBindTypeDO.h"
#include "dao/BindOwner/BindOwnerDAO.h"
#include "domain/do/BindOwner/CheckBindOwnerItemDO.h"
#include "domain/vo/BindOwner/CheckBindOwnerVO.h"

class BindOwnerService {
public:
    PageVO<CheckBindOwnerListVO> listBindAll(CheckBindOwnerItemQuery query);
    std::list<CheckBindOwnerTypeVO> getBindType();
};
#endif // !_BINDSERVICE_H_
