#ifndef _TDICTDO_H_
#define _TDICTDO_H_

#include "../DoInclude.h"

/*****************
* @Author : Yueyan
* @Time : 2022/10/31 17:18
* ע: ��RoomTypeVO��Ӧ
* ****************
*/
class t_dictDO {
	// id (6125 6126 6127)
	CC_SYNTHESIZE(int, id, Id);
	// ���ͱ��� (110 120 119)
	CC_SYNTHESIZE(std::string, status_cd, Status_cd);
	// �������� ("סլ" "�칫��" "����")
	CC_SYNTHESIZE(std::string, name, Name);
	// �������� ("סլ" "�칫��" "����")
	CC_SYNTHESIZE(std::string, description, Description);

public:
	t_dictDO() {
	}
	t_dictDO(int i, string s, string n, string d) {
		id = i;
		status_cd = s;
		name = n;
		description = d;
	}
};
#endif // !_TDICTVO_H_