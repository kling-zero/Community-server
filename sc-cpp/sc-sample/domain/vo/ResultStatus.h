#ifndef _RESULT_STATUS_
#define _RESULT_STATUS_

#include <string>
class ResultStatus
{
public:
	ResultStatus(std::string message, int code = 10000);
	std::string getMessage();
	int getCode();
private:
	int code;
	std::string message;
};

#endif // !_RESULT_STATUS_