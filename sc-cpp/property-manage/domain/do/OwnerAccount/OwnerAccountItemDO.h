#pragma once
#ifndef _OWNER_ACCOUNT_ITEM_DO_
#define _OWNER_ACCOUNT_ITEM_DO_

#include "../DoInclude.h"

class OwnerAccountItemDO
{
	//�˻�ID
	CC_SYNTHESIZE(std::string, acctId, AcctId);
	//�˻�����
	CC_SYNTHESIZE(std::string, acctName, AcctName);
	//�˻�����
	CC_SYNTHESIZE(std::string, acctType, AcctType);
	//�˻����
	CC_SYNTHESIZE(long, amount, Amount);
	//��������
	CC_SYNTHESIZE(std::string, objType, ObjType);
	//����ID
	CC_SYNTHESIZE(std::string, objId, ObjId);
	//ҵ��ID
	CC_SYNTHESIZE(std::string, bId, BId);
	//����ʱ��
	CC_SYNTHESIZE(std::string, createTime, CreateTime);
	//����״̬
	CC_SYNTHESIZE(std::string, statusCd, StatusCd);
	//�ֲ�ID
	CC_SYNTHESIZE(std::string, partId, PartId);
public:
	OwnerAccountItemDO() 
	{
		acctId = "";
		acctName = "";
		acctType = "";
		amount = 0;
		objType = "";
		objId = "";
		bId = "";
		createTime = "";
		statusCd = "";
		partId = "";
	}
};

#endif //__OWNERACCOUNTITEMDO_H__