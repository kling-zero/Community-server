#pragma once
#ifndef _COMBODTO_H_
#define _COMBODTO_H_
#include"../../GlobalInclude.h"
#include"../../vo/combo/FeeComboMemberListVO.h"
class ComboDTO {
	CC_SYNTHESIZE(string, comboName, ComboName);
	CC_SYNTHESIZE(string, remark, Remark);
	CC_SYNTHESIZE(FeeComboMemberListVO, feeListVO, FeeListVO);
	CC_SYNTHESIZE(string,communityId,CommunityId);


public:
	friend void from_json(const json& j, ComboDTO& c);
	BIND_TO_JSON(ComboDTO, comboName, remark,communityId);
};

#endif