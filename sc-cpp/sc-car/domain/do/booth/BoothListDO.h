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
		//��ͤID
		CC_SYNTHESIZE(std::string, box_id, Box_id);
		// ��ͤ����
		CC_SYNTHESIZE(std::string,box_name, Box_name);
		//С��ID'					,
		CC_SYNTHESIZE(std::string,community_id, Community_id);
		// ��ʱ���Ƿ���� Y ���� N ������
		CC_SYNTHESIZE(std::string,temp_car_in, Temp_car_in);
		//��ͤ�Ƿ� �շѣ���Ҫ���� ��ͤǶ������ Y �շ� N ���շ�',
		CC_SYNTHESIZE(std::string,fee, Fee);
		//���Ƴ��Ƿ���Խ��� Y ���� N ������',
		CC_SYNTHESIZE(std::string,blue_car_in, Blue_car_in);
		//���Ƴ��Ƿ���Խ��� Y ���� N ������',
		CC_SYNTHESIZE(std::string,yelow_car_in, Yelow_car_in);
		//��ע'
		CC_SYNTHESIZE(std::string,remark, Remark);
		//����ʱ��'
		CC_SYNTHESIZE(std::string, create_time, Create_time);
		//����״̬����ϸ�ο�c_status��S ���棬0, ���� 1ʧЧ
		CC_SYNTHESIZE(std::string, status_cd, Status_cd);
};


#endif //_BOOTHLISTDO_H_
