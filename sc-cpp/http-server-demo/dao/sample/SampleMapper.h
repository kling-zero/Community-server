#ifndef _SAMPLE_MAPPER_
#define _SAMPLE_MAPPER_

#include "Mapper.h"
#include "../../domain/do/sample/SampleDO.h"

class SampleMapper : public Mapper<SampleDO>
{
public:
	SampleDO mapper(ResultSet* resultSet) override
	{
		SampleDO data;
		data.setId(resultSet->getInt(1));
		data.setName(resultSet->getString(2));
		data.setSex(resultSet->getString(3));
		data.setAge(resultSet->getInt(4));
		return data;
	}
};

#endif // !_SAMPLE_MAPPER_