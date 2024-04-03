/**
* @Anthor: qingyang
* @Date: 2022/10/17 15:35:40
*/
#ifndef _SHAREBOOTHLISTVO_H_
#define _SHAREBOOTHLISTVO_H_
#include "../../GlobalInclude.h"
/**
 * �����ͤ��Ϣ
 */
class ShareBoothListVO
{
	//
	CC_SYNTHESIZE(std::string, baId, BaId);
	//��ͤ���
	CC_SYNTHESIZE(std::string,boxId, BoxId);
	//����
	CC_SYNTHESIZE(std::string,communityId, CommunityId);
	//����ʱ��
	CC_SYNTHESIZE(std::string,createTime, CreateTime);
	//Ĭ��ͣ����
	CC_SYNTHESIZE(std::string,defaultArea, DefaultArea);
	//ͣ�������
	CC_SYNTHESIZE(std::string,paId, PaId);
	//ͣ����
	CC_SYNTHESIZE(std::string,paNum, PaNum);
	//��ע
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