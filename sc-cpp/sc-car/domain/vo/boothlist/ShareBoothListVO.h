/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:35:40
*/
#ifndef _SHAREBOOTHLISTVO_H_
#define _SHAREBOOTHLISTVO_H_
#include "../../GlobalInclude.h"
/**
 * 共享岗亭信息
 */
class ShareBoothListVO
{
	//
	CC_SYNTHESIZE(std::string, baId, BaId);
	//岗亭编号
	CC_SYNTHESIZE(std::string,boxId, BoxId);
	//社区
	CC_SYNTHESIZE(std::string,communityId, CommunityId);
	//创建时间
	CC_SYNTHESIZE(std::string,createTime, CreateTime);
	//默认停车场
	CC_SYNTHESIZE(std::string,defaultArea, DefaultArea);
	//停车场编号
	CC_SYNTHESIZE(std::string,paId, PaId);
	//停车场
	CC_SYNTHESIZE(std::string,paNum, PaNum);
	//备注
	CC_SYNTHESIZE(std::string, remark, Remark);
	CC_SYNTHESIZE(int,page, Page);
	CC_SYNTHESIZE(int,records, Records);
	CC_SYNTHESIZE(int,row, Row);
	CC_SYNTHESIZE(std::string,statusCd, StatusCd);
	CC_SYNTHESIZE(int,total, Total);
public:
	BIND_TO_JSON(ShareBoothListVO, baId, boxId, communityId, createTime, defaultArea, paId, paNum,remark, page, records, row, statusCd, total);
};


#endif //_SHAREBOOTHLISTVO_H_