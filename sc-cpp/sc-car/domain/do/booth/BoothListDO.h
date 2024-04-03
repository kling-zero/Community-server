/**
* @Anthor: qingyang
* @Date: 2022/10/28 16:45:37
*/
#ifndef _BOOTHLISTDO_H_
#define _BOOTHLISTDO_H_
#include "../../GlobalInclude.h"
/**
*
*/
class BoothListDO
{
		//岗亭ID
		CC_SYNTHESIZE(std::string, box_id, Box_id);
		// 岗亭名称
		CC_SYNTHESIZE(std::string,box_name, Box_name);
		//小区ID'					,
		CC_SYNTHESIZE(std::string,community_id, Community_id);
		// 临时车是否进场 Y 进场 N 不进场
		CC_SYNTHESIZE(std::string,temp_car_in, Temp_car_in);
		//岗亭是否 收费，主要考虑 岗亭嵌套问题 Y 收费 N 不收费',
		CC_SYNTHESIZE(std::string,fee, Fee);
		//蓝牌车是否可以进场 Y 进场 N 不进场',
		CC_SYNTHESIZE(std::string,blue_car_in, Blue_car_in);
		//黄牌车是否可以进场 Y 进场 N 不进场',
		CC_SYNTHESIZE(std::string,yelow_car_in, Yelow_car_in);
		//备注'
		CC_SYNTHESIZE(std::string,remark, Remark);
		//创建时间'
		CC_SYNTHESIZE(std::string, create_time, Create_time);
		//数据状态，详细参考c_status表，S 保存，0, 在用 1失效
		CC_SYNTHESIZE(std::string, status_cd, Status_cd);
};


#endif //_BOOTHLISTDO_H_
