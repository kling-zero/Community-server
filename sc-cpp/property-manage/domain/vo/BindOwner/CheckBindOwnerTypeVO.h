#ifndef _CHECKTYPEVO_H_
#define _CHECKTYPEVO_H_

#include "../../GlobalInclude.h"

/*
*  ѡ�����״̬
*  @Author : kazimiyuuka 
*  @Time : 2022/10/17 21:32
*/

/*
* ����1
* @Author : kazimiyuuka
* @Time : 2022/10/24 22:33
*/
class CheckBindOwnerTypeVO
{
private:
	//�����
	CC_SYNTHESIZE(std::string, typeName,Typename);
public:
	BIND_TO_JSON(CheckBindOwnerTypeVO, typeName);
};
#endif // !_CHECKTYPEVO_H_
