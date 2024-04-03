#ifndef _YAMLHELPER_H_
#define _YAMLHELPER_H_
#include "yaml-cpp/yaml.h"

class YamlHelper
{
public:
	//************************************
	// Method:    getString
	// FullName:  YamlCpp::getString
	// Access:    public 
	// Returns:   std::string
	// Qualifier: ��Properties����ȡYaml���ö�Ӧ���ַ���
	// Parameter: YAML::Node & node ���ݽڵ�
	// Parameter: std::string key ���ݵ�key����spring.datasource.url
	//************************************
	std::string getString(YAML::Node& node, std::string key);

	//************************************
	// Method:    parseDbConnUrl
	// FullName:  YamlHelper::parseDbConnUrl
	// Access:    public 
	// Returns:   void
	// Qualifier: �������ݿ������ַ�����ȡ���ݿ������Ϣ
	// Parameter: std::string url ���ݿ������ַ���
	// Parameter: std::string & ip ����IP
	// Parameter: int & port ����˿�
	// Parameter: std::string & dbname �������ݿ�����
	//************************************
	void parseDbConnUrl(std::string url, std::string& ip, int& port, std::string& dbname);
};
#endif // _YAMLHELPER_H_
