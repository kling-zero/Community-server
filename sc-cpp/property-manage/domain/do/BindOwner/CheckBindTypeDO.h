#ifndef _CHECKTYPEDO_H_
#define _CHECKTYPEDO_H_

#include "../DoInclude.h"

/*****************
* @Author : kazimiyuuka
* @Time : 2022/10/25 21:20
* ****************
*/
class CheckBindOwnerTypeDO {
	CC_SYNTHESIZE(std::string, type, Type);
public:
	CheckBindOwnerTypeDO() {
		type = "NULL";
	}
	CheckBindOwnerTypeDO(string name) {
		type = name;
	}
};
#endif // !_CHECKTYPEDO_H_
