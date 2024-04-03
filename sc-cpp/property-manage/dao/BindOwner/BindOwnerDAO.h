#ifndef _BINDOWNERDAO_H_
#define _BINDOWNERDAO_H_
#include "BaseDAO.h"
#include "./domain/do/BindOwner/CheckBindTypeDO.h"
#include "./BindOwnerMapper.h"
#include "./domain/do/BindOwner/CheckBindOwnerItemDO.h"
#include <list>

/*****************
* BindOwnerType的DAO接口
* @Author : kazimiyuuka
* @Time : 2022/10/25 21:20
* ****************
*/
class BindOwnerTypeDAO : public BaseDAO
{
public:
	int count();
	std::list<CheckBindOwnerTypeDO> selectBindOwnerTypeNameAll();
};

/*****************
* BindOwnerItemDAO的接口
* @Author : kazimiyuuka
* @Time : 2022/10/25 21:20
* ****************
*/
class BindOwnerItemDAO : public BaseDAO
{
public:
	int count(CheckBindOwnerItemDO obj);
	std::list<BindOwnerItemDO> selectWithPage(CheckBindOwnerItemDO, int pageIndex, int pageSize);
};
#endif // !_BINDOWNERDAO_H_
