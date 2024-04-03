/**
* @Anthor: qingyang
* @Date: 2022/10/17 22:00:21
*/
#ifndef _DELETESHAREBOOTH_H_
#define _DELETESHAREBOOTH_H_
#include "../../../GlobalInclude.h"
/**
*ɾ�������ͤ
*/
class DeleteShareBoothDTO
{
	CC_SYNTHESIZE(std::string, baId, baId);
	//��ͤ���
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//����
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//Ĭ��
	CC_SYNTHESIZE(std::string, defaultArea, DefaultArea);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//ͣ�������
	CC_SYNTHESIZE(std::string, paId, PaId);
	//ͣ��������
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

