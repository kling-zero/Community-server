/**
* @Anthor: qingyang
* @Date: 2022/10/28 17:21:55
*/
#ifndef _PARKINGAREASDO_H_
#define _PARKINGAREASDO_H_
#include "../../GlobalInclude.h"
/**
*
*/
class ParkingAreasDO
{	//停车场ID'	
	CC_SYNTHESIZE(std::string,pa_id, Pa_id);
	//业务ID
	CC_SYNTHESIZE(std::string,b_id, B_id);
	//小区ID
	CC_SYNTHESIZE(std::string,community_id , Community_id);
	//停车场编号
	CC_SYNTHESIZE(std::string,num, Num);
	//`停车场类型，1001 地上停车场 2001 地下停车场'
	CC_SYNTHESIZE(std::string,type_cd, Type_cd);
	//备注
	CC_SYNTHESIZE(std::string,remark, Remark);
	//创建时间'
	CC_SYNTHESIZE(std::string,create_time, Create_time);
	//'数据状态，添加ADD，修改MOD 删除DEL'
	CC_SYNTHESIZE(std::string,operate, Operate);
};


#endif //_PARKINGAREASDO_H_
