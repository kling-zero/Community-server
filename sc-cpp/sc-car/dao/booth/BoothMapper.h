/**
* @Anthor: qingyang
* @Date: 2022/10/23 19:09:18
*/
#ifndef _BOOTHMAPPER_H_
#define _BOOTHMAPPER_H_
#include "Mapper.h"
#include "../../domain/do/booth/BoothListDO.h"
/**
*
*/
class BoothMapper : public Mapper<BoothListDO>
{
public:
	BoothListDO mapper(ResultSet* resultSet) override
	{
		BoothListDO date;
		date.setBox_id(resultSet->getString(1));
		date.setBox_name(resultSet->getString(2));
		date.setCommunity_id(resultSet->getString(3));
		date.setTemp_car_in(resultSet->getString(4));
		date.setFee(resultSet->getString(5));
		date.setBlue_car_in(resultSet->getString(6));
		date.setYelow_car_in(resultSet->getString(7));
		date.setRemark(resultSet->getString(8));
		date.setCreate_time(resultSet->getString(9));
		date.setStatus_cd(resultSet->getString(10));
		return date;
	}
};


#endif //!_BOOTHMAPPER_H_