#ifndef _CARFEE_LIST_VO_
#define _CARFEE_LIST_VO_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

/**
 * �����շ�
 */
class CarFeeListVO:public PageQuery
{
	// ���ƺ�
	CC_SYNTHESIZE(string, carNum, CarNum);
	// ͣ����
	CC_SYNTHESIZE(string, areaNum, AreaNum);
	// ��λ
	CC_SYNTHESIZE(string, num, Num);
	// ҵ������
	CC_SYNTHESIZE(string, ownerName, OwnerName);
	// ��ϵ��ʽ
	CC_SYNTHESIZE(string, link, Link);
	// ��λ״̬
	CC_SYNTHESIZE(string, stateName, StateName);

	// ҵ��ID
	CC_SYNTHESIZE(string, ownerId, OwnerID);
public:
	// ��JSONת������
	BIND_TO_JSON(CarFeeListVO, carNum, areaNum, num, ownerName, link, stateName, ownerId);
	//CarFeeListVO() {
	//	carNum = u8"��Gerins";
	//	areaNum = u8"11";
	//	num = u8"11";
	//	ownerName = u8"11";
	//	link = u8"18985136859";
	//	stateName = u8"����";
	//	ownerId = u8"772022101726638968";
	//	pageIndex = 1;
	//	pageSize = 10;
	//}
};

#endif // !_CARFEE_LIST_VO_