/**
* @Anthor: qingyang
* @Date: 2022/10/28 17:21:55
*/
#ifndef _PARKINGAREASDO_H_
#define _PARKINGAREASDO_H_
#include "../../GlobalInclude.h"
/**
*
*/
class ParkingAreasDO
{	//ͣ����ID'	
	CC_SYNTHESIZE(std::string,pa_id, Pa_id);
	//ҵ��ID
	CC_SYNTHESIZE(std::string,b_id, B_id);
	//С��ID
	CC_SYNTHESIZE(std::string,community_id , Community_id);
	//ͣ�������
	CC_SYNTHESIZE(std::string,num, Num);
	//`ͣ�������ͣ�1001 ����ͣ���� 2001 ����ͣ����'
	CC_SYNTHESIZE(std::string,type_cd, Type_cd);
	//��ע
	CC_SYNTHESIZE(std::string,remark, Remark);
	//����ʱ��'
	CC_SYNTHESIZE(std::string,create_time, Create_time);
	//'����״̬�����ADD���޸�MOD ɾ��DEL'
	CC_SYNTHESIZE(std::string,operate, Operate);
};


#endif //_PARKINGAREASDO_H_
