#ifndef _CSTATUSDO_H_
#define _CSTATUSDO_H_

#include "../DoInclude.h"

/*****************
* @Author : Yueyan
* @Time : 2022/10/31 11:17
* 注: 与RoomStateVO对应
* ****************
*/
class C_StatusDO {
	// id (11 12 15 16)
	CC_SYNTHESIZE(int, id, Id);
	// 状态编码 (2001 2002 2003 2004)
	CC_SYNTHESIZE(std::string, status_cd, Status_cd);
	// 名称 (房屋已售 房屋未售 房屋出售已交定金 房屋已出租)
	CC_SYNTHESIZE(std::string, name, Name);
	// 描述 (房屋已售 房屋未售 房屋出售已交定金 房屋已出租)
	CC_SYNTHESIZE(std::string, description, Description);

public:
	C_StatusDO() {
	}
	C_StatusDO(int i, string s, string n, string d) {
		id = i;
		status_cd = s;
		name = n;
		description = d;
	}
};
#endif // !_CSTATUSDO_H_