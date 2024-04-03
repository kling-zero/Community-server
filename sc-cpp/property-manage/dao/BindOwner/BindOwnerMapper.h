#ifndef _BINDOWENERMAPPER_H_
#define _BINDOWENERMAPPER_H_
#include "Mapper.h"
#include "./domain/do/BindOwner/CheckBindTypeDO.h"
#include "./domain/do/BindOwner/CheckBindOwnerItemDO.h"
/*****************
* @Author : kazimiyuuka
* @Time : 2022/10/25
* ****************
*/
class BindOwnerTypeMapper : public Mapper<CheckBindOwnerTypeDO> 
{
public:
	CheckBindOwnerTypeDO mapper(ResultSet* resultSet) override
	{
		CheckBindOwnerTypeDO data;
		data.setType(resultSet->getString(1));
		return data;
	}
};

class BindOwnerItemMapper : public Mapper<BindOwnerItemDO>
{
public:
	BindOwnerItemDO mapper(ResultSet* resultSet) override
	{
		BindOwnerItemDO data;
		data.setAppUserID(resultSet->getString(1));
		data.setMemberID(resultSet->getString(2));
		data.setCommunityID(resultSet->getString(3));
		data.setCommunityName(resultSet->getString(4));
		data.setAppUserName(resultSet->getString(5));
		data.setIdCard(resultSet->getString(6));
		data.setLink(resultSet->getString(7));
		data.setStateName(resultSet->getString(8));
		data.setCreateTime(resultSet->getString(9));
		return data;
	}
};
#endif // !_BINDOWENERMAPPER_H_
