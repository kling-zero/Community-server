#ifndef _OWNERMEMBERMAPPER_H_
#define _OWNERMEMBERMAPPER_H_


#include "Mapper.h"
#include "../../domain/do/OwnerMember/OwnerItemDo.h"

class OwnerMemberMapper : public Mapper<OwnerItemDo>
{
public:
	OwnerItemDo mapper(ResultSet* resultSet) override
	{
		OwnerItemDo data;
		data.setOwnerName(resultSet->getString(4));
		data.setSex(resultSet->getString(5));
		data.setAge(resultSet->getInt(6));
		data.setLink(resultSet->getString(7));
		data.setIdCard(resultSet->getString(14));
		return data;
	}
};

#endif // !_OWNERMEMBERMAPPER_H_