/**
* @Anthor: qingyang
* @Date: 2022/10/17 20:50:41
*/
#ifndef _DELETEBOOTHDTO_H_
#define _DELETEBOOTHDTO_H_
#include "../../../GlobalInclude.h"
/**
*��ͤɾ��
*/
class DeleteBoothDTO
{
	//��ͤ���
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	////���Ƴ�����	
	//CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	////��ͤ����
	//CC_SYNTHESIZE(std::string, boxName, BoxName);
	////����
	//CC_SYNTHESIZE(std::string, communityId, CommunityId);
	////����
	//CC_SYNTHESIZE(std::string, fee, Fee);
	////ͣ�������
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////ͣ����
	//CC_SYNTHESIZE(std::string, paNum, PaNum);
	//CC_SYNTHESIZE(int, page, Page);
	//CC_SYNTHESIZE(int, records, Records);
	////��ע
	//CC_SYNTHESIZE(std::string, remark, Remark);
	//CC_SYNTHESIZE(int, row, Row);
	//CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	////��ʱ������
	//CC_SYNTHESIZE(std::string, tempCarIn, TempCarIn);
	////�ܹ�
	//CC_SYNTHESIZE(int, total, Total);
	////���Ƴ�����
	//CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);
public:
	BIND_TO_JSON(DeleteBoothDTO,boxId/*, blueCarIn, boxName, communityId, fee, paId, paNum, page, records, remark, row, statusCd, tempCarIn, total, yelowCarIn*/);
	friend void from_json(const json& j, DeleteBoothDTO& t);
};


#endif //_DELETEBOOTHDTO_H_

