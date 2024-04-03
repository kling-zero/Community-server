/**
* @Anthor: qingyang
* @Date: 2022/10/17 22:00:21
*/
#ifndef _DELETESHAREBOOTH_H_
#define _DELETESHAREBOOTH_H_
#include "../../../GlobalInclude.h"
/**
*删除共享岗亭
*/
class DeleteShareBoothDTO
{
	CC_SYNTHESIZE(std::string, baId, baId);
	//岗亭编号
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//社区
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//默认
	CC_SYNTHESIZE(std::string, defaultArea, DefaultArea);
	//创建时间
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//停车场编号
	CC_SYNTHESIZE(std::string, paId, PaId);
	//停车场名称
	CC_SYNTHESIZE(std::string, paNum, paNum);
	CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int,records, Records);
	CC_SYNTHESIZE(int,row, Row);
	CC_SYNTHESIZE(int,statusCd, StatusCd);
	CC_SYNTHESIZE(int,total, Total);
public:
	BIND_TO_JSON(DeleteShareBoothDTO, baId, boxId, communityId, defaultArea, createTime, paId, paNum, page, records,row, statusCd, total);
	friend void from_json(const json& j, DeleteShareBoothDTO& t);
};


#endif //_DELETESHAREBOOTH_H_

