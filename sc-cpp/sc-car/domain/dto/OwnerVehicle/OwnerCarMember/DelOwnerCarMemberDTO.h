#ifndef _DELOWNERCARMEMBERDTO_H_
#define _DELOWNERCARMEMBERDTO_H_

#include "../../../GlobalInclude.h"

/**
* @Anthor: Panda
* @Date: 2022/10/28 18:25:09
*/
class DelOwnerCarMemberDTO
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
	friend void from_json(const json& j, DelOwnerCarMemberDTO& t);
	BIND_TO_JSON(DelOwnerCarMemberDTO, carNum, carNumLike, num, valid, carTypeCd);
};

#endif //_DELOWNERCARMEMBERDTO_H_
