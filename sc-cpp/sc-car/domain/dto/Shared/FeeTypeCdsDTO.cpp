#include "stdafx.h"
#include "FeeTypeCdsDTO.h"


void from_json(const json& j, FeeTypeCdsDTO& t) 
{
	BIND_FROM_TO_NORMAL(j, t, description);
	//BIND_FROM_TO_NORMAL(j, t, id);
	BIND_FROM_TO_NORMAL(j, t, name);
	//BIND_FROM_TO_NORMAL(j, t, page);
	//BIND_FROM_TO_NORMAL(j, t, records);
	//BIND_FROM_TO_NORMAL(j, t, row);
	BIND_FROM_TO_NORMAL(j, t, statusCd);
	//BIND_FROM_TO_NORMAL(j, t, total);
}