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
	//��������ַ
	string m_address;
	//�����ռ�
	string m_namespace;

#ifdef LINUX
	//��ǰ��������
	NamingService* namingSvc;
#endif
public:
	//************************************
	// Method:    NacosClient
	// FullName:  NacosClient::NacosClient
	// Access:    public 
	// Returns:   
	// Qualifier: �����ʼ��
	// Parameter: string address ��������ַ���磺39.99.114.126:8848
	// Parameter: string namespaceId �����ռ䣬�磺1653f775-4782-46ad-9cd2-b60155a574c6
	//************************************
	NacosClient(const string& address, const string& namespaceId);
	
	// �����ͷ���Դ
	~NacosClient();

	//************************************
	// Method:    getConfig
	// FullName:  NacosClient::getConfig
	// Access:    public 
	// Returns:   std::string
	// Qualifier: ��ȡ����
	// Parameter: string& dataId ����ID
	// Parameter: string groupName �������ƣ�Ĭ��ֵ��DEFAULT_GROUP
	//************************************
	YAML::Node getConfig(const string& dataId, string groupName = "DEFAULT_GROUP");

	//************************************
	// Method:    registerInstance
	// FullName:  NacosClient::registerInstance
	// Access:    public 
	// Returns:   bool ע��ɹ�����true
	// Qualifier: ע�����
	// Parameter: string & ip ע�����IP��ַ
	// Parameter: int port ע�����˿�
	// Parameter: string & serviceName ע���������
	// Parameter: string groupName �������ƣ�Ĭ��ֵ��DEFAULT_GROUP
	// Parameter: string clusterName ��Ⱥ���ƣ�Ĭ��ֵ��DEFAULT
	//************************************
	bool registerInstance(const string& ip, int port, const string& serviceName, string groupName = "DEFAULT_GROUP", string clusterName = "DEFAULT");
	
	//************************************
	// Method:    deregisterInstance
	// FullName:  NacosClient::deregisterInstance
	// Access:    public 
	// Returns:   bool ��ע��ɹ�����true
	// Qualifier: ��ע�����
	// Parameter: string & ip ע�����IP��ַ
	// Parameter: int port ע�����˿�
	// Parameter: string & serviceName ע���������
	// Parameter: string groupName �������ƣ�Ĭ��ֵ��DEFAULT_GROUP
	// Parameter: string clusterName ��Ⱥ���ƣ�Ĭ��ֵ��DEFAULT
	//************************************
	bool deregisterInstance(const string& ip, int port, const string& serviceName, string groupName = "DEFAULT_GROUP", string clusterName = "DEFAULT");
};
#endif // _NACOSCLIENT_H_
