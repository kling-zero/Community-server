#include "stdafx.h"
#include "ResultStatus.h"

ResultStatus::ResultStatus(std::string message, int code /*= 10000*/)
{
	this->message = message;
	this->code = code;
}

std::string ResultStatus::getMessage()
{
	return message;
}

int ResultStatus::getCode()
{
	return code;
}
