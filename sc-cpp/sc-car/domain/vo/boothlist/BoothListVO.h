/**
* @Anthor: qingyang
* @Date: 2022/10/17 14:56:31
*/
#ifndef _BOOTHLIST_VO_H_
#define _BOOTHLIST_VO_H_
#include "../../GlobalInclude.h"
/**
 * ��ͤ��Ϣ
 */
class BoothListVO 
{
	//���Ƴ�����	
	CC_SYNTHESIZE(std::string, blueCarIn, BlueCarIn);
	//��ͤ���
	CC_SYNTHESIZE(std::string, boxId, BoxId);
	//��ͤ����
	CC_SYNTHESIZE(std::string, boxName, BoxName);
	//����
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����
	CC_SYNTHESIZE(std::string, fee, Fee);
	////ͣ�������
	//CC_SYNTHESIZE(std::string, paId, PaId);
	////ͣ����
	//CC_SYNTHESIZE(std::string, paNum, PaNum);
	//��ע
	CC_SYNTHESIZE(std::string,remark, Remark);
	//'����״̬����ϸ�ο�c_status��S ���棬0, ���� 1ʧЧ'
	CC_SYNTHESIZE(std::string,statusCd, StatusCd);
	//��ʱ������
	CC_SYNTHESIZE(std::string,tempCarIn, TempCarIn);
	//���Ƴ�����	
	CC_SYNTHESIZE(std::string, yelowCarIn, YelowCarIn);

	/*CC_SYNTHESIZE(int, page, Page);
	CC_SYNTHESIZE(int, records, Records);
	CC_SYNTHESIZE(int, total, Total);
	CC_SYNTHESIZE(int,row, Row);*/
public:
	BIND_TO_JSON(BoothListVO, blueCarIn, boxId, boxName, communityId, fee, /*paId, paNum,*/  remark, statusCd, tempCarIn,  yelowCarIn /*,page, row, total, records */);
};


#endif //_BOOTHLIST_VO_H_
