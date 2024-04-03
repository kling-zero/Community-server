/**
* @Anthor: qingyang
* @Date: 2022/10/17 14:56:31
*/
#ifndef _BOOTHLIST_VO_H_
#define _BOOTHLIST_VO_H_
#include "../../GlobalInclude.h"
/**
 * 岗亭信息
 */
class BoothListVO 
{
	//蓝牌车进场	
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//岗亭编号
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//岗亭名称
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//社区
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//费用
	CC_SYNTHESIZE(std::string, fee, Fee);
	////停车场编号
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////停车场
	//CC_SYNTHESIZE(std::string, paNum, PaNum);
	//备注
	CC_SYNTHESIZE(std::string,remark, Remark);
	//'数据状态，详细参考c_status表，S 保存，0, 在用 1失效'
	CC_SYNTHESIZE(std::string,statusCd, StatusCd);
	//临时车进厂
	CC_SYNTHESIZE(std::string,tempCarIn, TempCarIn);
	//黄牌车进场	
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);

	/*CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, records, Records);
	CC_SYNTHESIZE(int, total, Total);
	CC_SYNTHESIZE(int,row, Row);*/
public:
	BIND_TO_JSON(BoothListVO, blueCarIn, boxId, boxName, communityId, fee, /*paId, paNum,*/  remark, statusCd, tempCarIn,  yelowCarIn /*,page, row, total, records */);
};


#endif //_BOOTHLIST_VO_H_
