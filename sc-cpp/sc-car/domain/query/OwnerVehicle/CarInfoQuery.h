#ifndef _OWNERVEHICLEQUERY_H_
#define _OWNERVEHICLEQUERY_H_

#include "../../GlobalInclude.h"
#include "../PageQuery.h"

/**
* @Anthor: Panda
* @Date: 2022/10/18 16:01:39
* ҵ������-������Ϣ��ѯ
*/
class CarInfoQuery : public PageQuery
{
	//δ֪
	CC_SYNTHESIZE(std::string, carNum, CarNum);
	//���ƺ�
	CC_SYNTHESIZE(std::string, carNumLike, CarNumLike);
	//��λ���
	CC_SYNTHESIZE(std::string, num, Num);
	//��λ״̬
	CC_SYNTHESIZE(std::string, valid, Valid);
	//��������
	CC_SYNTHESIZE(std::string, carTypeCd, CarTypeCd);
public:
	friend void from_json(const json& j, CarInfoQuery& t) {
		BIND_FROM_TO_L(j, t, pageIndex);
		BIND_FROM_TO_L(j, t, pageSize);
		BIND_FROM_TO_NORMAL(j, t, carNum);
		BIND_FROM_TO_NORMAL(j, t, carNumLike);
		BIND_FROM_TO_NORMAL(j, t, num);
		BIND_FROM_TO_NORMAL(j, t, valid);
		BIND_FROM_TO_NORMAL(j, t, carTypeCd);
	}
	
};

#endif //_OWNERVEHICLEQUERY_H_