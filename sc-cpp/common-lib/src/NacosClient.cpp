#include "pch.h"
#include "../include/NacosClient.h"
#include <iostream>

#ifdef LINUX

// 初始化Nacos服务器对象
#define NACOS_INIT(__SERVER_TYPE__, __VAR_NAME__, __CREATE_FUN__) \
Properties props; \
props[PropertyKeyConst::SERVER_ADDR] = m_address; \
props[PropertyKeyConst::NAMESPACE] = m_namespace; \
INacosServiceFactory* factory = NacosFactoryFactory::getNacosFactory(props); \
ResourceGuard<INacosServiceFactory> _guardFactory(factory); \
__SERVER_TYPE__* __VAR_NAME__ = factory->__CREATE_FUN__();

// 定义Nacos实例属性
#define NACOS_INSTANCE_DECLARE(__VAR_NAME__) \
Instance __VAR_NAME__; \
__VAR_NAME__.ip = ip; \
__VAR_NAME__.port = port; \
__VAR_NAME__.serviceName = serviceName; \
__VAR_NAME__.groupName = groupName; \
__VAR_NAME__.clusterName = clusterName; \
__VAR_NAME__.instanceId = "1"; \
__VAR_NAME__.ephemeral = true; \
__VAR_NAME__.metadata.insert(make_pair("preserved.register.source", "CPP"));

#endif

NacosClient::NacosClient(const string& address, const string& namespaceId)
{
	this->m_address = address;
	this->m_namespace = namespaceId;

#ifdef LINUX
	this->namingSvc = nullptr;
#endif
}

NacosClient::~NacosClient()
{
#ifdef LINUX
	if (this->namingSvc) delete namingSvc;
#endif
}

YAML::Node NacosClient::getConfig(const string& dataId, string groupName /*= "DEFAULT_GROUP"*/)
{
#ifdef LINUX

	NACOS_INIT(ConfigService, configSvc, CreateConfigService);
	ResourceGuard<ConfigService> _serviceFactory(configSvc);
	NacosString ss = "";
	try {
		ss = configSvc->getConfig(dataId, groupName, 1000);
		return YAML::Load(ss.c_str());
	}
	catch (NacosException& e) {
		cout << "Request failed with curl code:" << e.errorcode() << endl << "Reason:" << e.what() << endl;
		return YAML::Node();
	}

#else
	return YAML::LoadFile(dataId);
#endif
}

bool NacosClient::registerInstance(const string& ip, int port, const string& serviceName, string groupName /*= "DEFAULT_GROUP"*/, string clusterName /*= "DEFAULT"*/)
{
#ifdef LINUX

	if (!this->namingSvc)
	{
		NACOS_INIT(NamingService, tempNamingSvc, CreateNamingService);
		this->namingSvc = tempNamingSvc;
	}
	NACOS_INSTANCE_DECLARE(instance);
	try {
		this->namingSvc->registerInstance(serviceName, instance);
		cout << serviceName <<" register success" << endl;
		return true;
	}
	catch (NacosException& e) {
		cout << "encounter exception while registering service instance, raison:" << e.what() << endl;
		return false;
	}

#else
	return false;
#endif
}

bool NacosClient::deregisterInstance(const string& ip, int port, const string& serviceName, string groupName /*= "DEFAULT_GROUP"*/, string clusterName /*= "DEFAULT"*/)
{
#ifdef LINUX

	if (!this->namingSvc)
	{
		cout << "you are never register any service, can not deregister" << endl;
		return false;
	}
	NACOS_INSTANCE_DECLARE(instance);
	try {
		this->namingSvc->deregisterInstance(serviceName, groupName, instance);
		cout << serviceName << " deregister success" << endl;
		return true;
	}
	catch (NacosException& e) {
		cout << "encounter exception while deregister service instance, raison:" << e.what() << endl;
		return false;
	}

#else
	return false;
#endif
}
