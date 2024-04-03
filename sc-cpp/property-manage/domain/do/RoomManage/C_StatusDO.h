#ifndef _CSTATUSDO_H_
#define _CSTATUSDO_H_

#include "../DoInclude.h"

/*****************
* @Author : Yueyan
* @Time : 2022/10/31 11:17
* ע: ��RoomStateVO��Ӧ
* ****************
*/
class C_StatusDO {
	// id (11 12 15 16)
	CC_SYNTHESIZE(int, id, Id);
	// ״̬���� (2001 2002 2003 2004)
	CC_SYNTHESIZE(std::string, status_cd, Status_cd);
	// ���� (�������� ����δ�� ���ݳ����ѽ����� �����ѳ���)
	CC_SYNTHESIZE(std::string, name, Name);
	// ���� (�������� ����δ�� ���ݳ����ѽ����� �����ѳ���)
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