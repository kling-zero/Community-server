#ifndef _CHANGEBINDSTATE_H_
#define _CHANGEBINDSTATE_H_

#include "../../GlobalInclude.h"
/*
*  上传修改状态
*/
class ChangeBindOwnerState
{
private:
	//绑定ID
	CC_SYNTHESIZE(std::string, appUserID, AppUserID);
	//操作
	CC_SYNTHESIZE(std::string, operation, Operation);
public:
	friend void from_json(const json& j, ChangeBindOwnerState& c)
	{
		BIND_FROM_TO_NORMAL(j, c, appUserID);
		BIND_FROM_TO_NORMAL(j, c, operation);
	}
};

class ChangeBindReply
{
private:
	CC_SYNTHESIZE(std::string, newPassword, NewPassword);
	CC_SYNTHESIZE(std::string, appUserID, appUserID);
	CC_SYNTHESIZE(int, operation, Operation);
public:
	BIND_TO_JSON(ChangeBindReply, appUserID, operation, newPassword);
};

#endif // !_CHANGEBINDSTATE_H_
