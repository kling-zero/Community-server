#pragma once
#ifndef _CARINFO_H_
#define _CARINFO_H_

#include "../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 9:29:06
* ҵ������ ��ѯ����ֵ
*/
class CarInfoVO
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
	BIND_TO_JSON(CarInfoVO, areaNum, bId, carBrand, carColor, carId, carNum, carType, carTypeCd,
		carTypeName, communityId, createTime, endTime, idCard, link, memberId, num, 
		//ownerCarAttrDto,
		ownerId, parkingType, psId, remark, roomName,
		startTime, state, stateName, statusCd, userId ,withOwner);
};
#endif //_CARINFO_H_