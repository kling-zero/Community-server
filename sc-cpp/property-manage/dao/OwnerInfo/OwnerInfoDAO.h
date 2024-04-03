#pragma once
#ifndef _OWNER_INFO_DAO_
#define _OWNER_INFO_DAO_


#include "BaseDAO.h"
#include "../../domain/do/OwnerInfo/OwnerInfoDO.h"
#include "../../domain/do/OwnerInfo/OwnerInfoQueryDO.h"
#include "OwnerInfoMapper.h"


class OwnerInfoDAO : public BaseDAO
{
public:
	uint64_t countOwnerInfo(OwnerInfoQueryDO iObj);
	std::list<OwnerInfoDO> selectOwnerInfoWithPage(OwnerInfoQueryDO iObj, long pageIndex, long pageSize);
	uint64_t addOwnerInfo(OwnerInfoDO iObj);
	long modifyOwnerInfo(OwnerInfoDO iObj);
	int deleteById(std::string id);
};

class timetool
{
public:
	// Ê±¼ä×Ö·û´®(Èç£º2020-05-02 14:40:31.015)
	std::string getTimeString(bool bLocal, bool bIncludeMS) {
		auto tNow = std::chrono::system_clock::now();
		//auto tmNow = std::chrono::system_clock::to_time_t(tNow);
		auto tSeconds = std::chrono::duration_cast<std::chrono::seconds>(tNow.time_since_epoch());
		auto secNow = tSeconds.count();
		tm tmNow;
		if (bLocal) {
			localtime_s(&tmNow, &secNow);
		}
		else {
			gmtime_s(&tmNow, &secNow);
		}

		std::ostringstream oss;
		oss << std::put_time(&tmNow, "%Y%m%d%H%M%S");
		if (bIncludeMS) {
			auto tMilli = std::chrono::duration_cast<std::chrono::milliseconds>(tNow.time_since_epoch());
			auto ms = tMilli - tSeconds;
			oss << std::setfill('0') << std::setw(3) << ms.count();
		}

		return oss.str();
	}
};

#endif //__OWNERINFODAO_H__
