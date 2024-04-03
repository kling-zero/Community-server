#ifndef _CARINFODO_H_
#define _CARINFODO_H_

#include "../../DoInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/29 17:01:12
*/
class CarInfoDO
{
	//��λid
	CC_SYNTHESIZE(std::string, areaNum, AreaNum);
	//
	CC_SYNTHESIZE(std::string, bId, BId);
	//����Ʒ��
	CC_SYNTHESIZE(std::string, carBrand, CarBrand);
	//������ɫ
	CC_SYNTHESIZE(std::string, carColor, CarColor);
	//
	CC_SYNTHESIZE(std::string, carId, CarId);
	//���ƺ�
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//��������
	CC_SYNTHESIZE(std::string, carType, CarType);
	//�����ͱ��
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
	//����������
	CC_SYNTHESIZE(std::string, carTypeName, CarTypeName);
	//����ID
	CC_SYNTHESIZE(std::string, communityId, CommunityId);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//����ʱ��
	CC_SYNTHESIZE(std::string, endTime, EndTime);
	//���֤ID
	CC_SYNTHESIZE(std::string, idCard, IdCard);
	//�绰����
	CC_SYNTHESIZE(std::string, link, Link);
	//
	CC_SYNTHESIZE(std::string, memberId, MemberId);
	//
	CC_SYNTHESIZE(std::string, num, Num);
	//
	//CC_SYNTHESIZE(std::list<class T>, ownerCarAttrDto, OwnerCarAttrDto)
	////ҵ��ID
	CC_SYNTHESIZE(std::string, ownerId, OwnerId);
	//ҵ������
	CC_SYNTHESIZE(std::string, ownerName, OwnerName);
	//��λ״̬
	CC_SYNTHESIZE(std::string, parkingType, ParkingType);
	//
	CC_SYNTHESIZE(std::string, psId, PsId);
	//����λ���룬ϵͳ�Զ����룩
	CC_SYNTHESIZE(std::string, remark, Remark);
	//���ݺ�
	CC_SYNTHESIZE(std::string, roomName, RoomName);
	//����ʱ��
	CC_SYNTHESIZE(std::string, startTime, StartTime);
	//״̬���
	CC_SYNTHESIZE(std::string, state, State);
	//״̬����
	CC_SYNTHESIZE(std::string, stateName, StateName);
	//
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//�û�id
	CC_SYNTHESIZE(std::string, userId, UserId);
	//�Ƿ�Ϊҵ��
	CC_SYNTHESIZE(bool, withOwner, WithOwner);
public:
	CarInfoDO() {
		// business_temp_car_fee_config
		std::string areaNum = "";
		std::string bId = "";
		std::string carBrand = "";
		std::string carColor = "";
		std::string carId = "";
		std::string carNum = "";
		std::string carType = "";
		std::string carTypeCd = "";
		std::string carTypeName = "";
		std::string communityId = "";
		std::string createTime = "";
		std::string endTime = "";
		std::string idCard = "";
		std::string link = "";
		std::string memberId = "";
		std::string num = "";
	//ownerCarAttrDto
		std::string ownerId = "";
		std::string ownerName = "";
		std::string parkingType = "";
		std::string psId = "";
		std::string remark = "";
		std::string roomName = "";
		std::string startTime = "";
		std::string state = "";
		std::string stateName = "";
		std::string statusCd = "";
		std::string userId = "";

		bool withOwner = false;
	}
};

#endif //_CARINFODO_H_