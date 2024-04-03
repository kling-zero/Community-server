#ifndef _FLOORANDUNITQUERY_H_
#define _FLOORANDUNITQUERY_H_

#include "../../GlobalInclude.h"

/**
 * ¥���͵�Ԫ��ѯ���󣺶�Ӧ��ʾ¥���͵�Ԫѡ�������
 * @Author: Yueyan
 * @Date: 2022/11/2 16:22
 */
class FloorAndUnitQuery
{
	// ��������
	CC_SYNTHESIZE(std::string, communityId, CommunityId);

public:
	friend void from_json(const json& j, FloorAndUnitQuery& t) {
		BIND_FROM_TO_NORMAL(j, t, communityId);
	}
};


#endif // _FLOORANDUNITQUERY_H_