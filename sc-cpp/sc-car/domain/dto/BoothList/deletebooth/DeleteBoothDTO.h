/**
* @Anthor: qingyang
* @Date: 2022/10/17 20:50:41
*/
#ifndef _DELETEBOOTHDTO_H_
#define _DELETEBOOTHDTO_H_
#include "../../../GlobalInclude.h"
/**
*岗亭删除
*/
class DeleteBoothDTO
{
	//岗亭编号
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	////蓝牌车进场	
	//CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	////岗亭名称
	//CC_SYNTHESIZE(std::string, boxName, BoxName);
	////社区
	//CC_SYNTHESIZE(std::string, communityId, CommunityId);
	////费用
	//CC_SYNTHESIZE(std::string, fee, Fee);
	////停车场编号
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////停车场
	//CC_SYNTHESIZE(std::string, paNum, PaNum);
	//CC_SYNTHESIZE(int, page, Page);
	//CC_SYNTHESIZE(int, records, Records);
	////备注
	//CC_SYNTHESIZE(std::string, remark, Remark);
	//CC_SYNTHESIZE(int, row, Row);
	//CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	////临时车进厂
	//CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	////总共
	//CC_SYNTHESIZE(int, total, Total);
	////黄牌车进场
	//CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(DeleteBoothDTO,boxId/*, blueCarIn, boxName, communityId, fee, paId, paNum, page, records, remark, row, statusCd, tempCarIn, total, yelowCarIn*/);
	friend void from_json(const json& j, DeleteBoothDTO& t);
};


#endif //_DELETEBOOTHDTO_H_

