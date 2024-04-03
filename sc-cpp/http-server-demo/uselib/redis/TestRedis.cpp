#include "stdafx.h"
#include "TestRedis.h"
#include "NacosClient.h"
#include "ServerInfo.h"
#include "YamlHelper.h"
#include "sw/redis++/redis++.h"
#include <sstream>
#include <iostream>
using namespace sw::redis;

void TestRedis::testUseRedis()
{
	//获取配置
	NacosClient nacosClient(ServerInfo::getInstance().getNacosAddr(), ServerInfo::getInstance().getNacosNs());
#ifdef LINUX
	std::string dataId = "data-source.yaml";
	YAML::Node node = nacosClient.getConfig(dataId);
#else
	std::string dataId = "./conf/data-source.yaml";
	YAML::Node node = nacosClient.getConfig(dataId);
#endif
	//获取redis相关配置
	YamlHelper yaml;
	string host = yaml.getString(node, "spring.redis.host");
	string port = yaml.getString(node, "spring.redis.port");

	//创建Redis对象
	stringstream ss;
	ss << "tcp://" << host << ":" << port;
	auto redis = Redis(ss.str());

	//添加set值
	redis.set("key", "val");
	auto val = redis.get("key");
	if (val) {
		std::cout << *val << std::endl;
	}
}
