#ifndef _NACOSCLIENT_H_
#define _NACOSCLIENT_H_

#include <string>
using namespace std;

#ifdef LINUX
#include "nacos/Nacos.h"
using namespace nacos;
#endif
#include "yaml-cpp/yaml.h"

class NacosClient
{
private:
	//服务器地址
	string m_address;
	//命名空间
	string m_namespace;

#ifdef LINUX
	//当前命名服务
	NamingService* namingSvc;
#endif
public:
	//************************************
	// Method:    NacosClient
	// FullName:  NacosClient::NacosClient
	// Access:    public 
	// Returns:   
	// Qualifier: 构造初始化
	// Parameter: string address 服务器地址，如：39.99.114.126:8848
	// Parameter: string namespaceId 命名空间，如：1653f775-4782-46ad-9cd2-b60155a574c6
	//************************************
	NacosClient(const string& address, const string& namespaceId);
	
	// 析构释放资源
	~NacosClient();

	//************************************
	// Method:    getConfig
	// FullName:  NacosClient::getConfig
	// Access:    public 
	// Returns:   std::string
	// Qualifier: 获取配置
	// Parameter: string& dataId 配置ID
	// Parameter: string groupName 分组名称，默认值：DEFAULT_GROUP
	//************************************
	YAML::Node getConfig(const string& dataId, string groupName = "DEFAULT_GROUP");

	//************************************
	// Method:    registerInstance
	// FullName:  NacosClient::registerInstance
	// Access:    public 
	// Returns:   bool 注册成功返回true
	// Qualifier: 注册服务
	// Parameter: string & ip 注册服务IP地址
	// Parameter: int port 注册服务端口
	// Parameter: string & serviceName 注册服务名称
	// Parameter: string groupName 分组名称，默认值：DEFAULT_GROUP
	// Parameter: string clusterName 集群名称，默认值：DEFAULT
	//************************************
	bool registerInstance(const string& ip, int port, const string& serviceName, string groupName = "DEFAULT_GROUP", string clusterName = "DEFAULT");
	
	//************************************
	// Method:    deregisterInstance
	// FullName:  NacosClient::deregisterInstance
	// Access:    public 
	// Returns:   bool 反注册成功返回true
	// Qualifier: 反注册服务
	// Parameter: string & ip 注册服务IP地址
	// Parameter: int port 注册服务端口
	// Parameter: string & serviceName 注册服务名称
	// Parameter: string groupName 分组名称，默认值：DEFAULT_GROUP
	// Parameter: string clusterName 集群名称，默认值：DEFAULT
	//************************************
	bool deregisterInstance(const string& ip, int port, const string& serviceName, string groupName = "DEFAULT_GROUP", string clusterName = "DEFAULT");
};
#endif // _NACOSCLIENT_H_
