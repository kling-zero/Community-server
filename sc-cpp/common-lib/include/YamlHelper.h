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
	// Qualifier: 以Properties风格读取Yaml配置对应的字符串
	// Parameter: YAML::Node & node 数据节点
	// Parameter: std::string key 数据的key，如spring.datasource.url
	//************************************
	std::string getString(YAML::Node& node, std::string key);

	//************************************
	// Method:    parseDbConnUrl
	// FullName:  YamlHelper::parseDbConnUrl
	// Access:    public 
	// Returns:   void
	// Qualifier: 解析数据库连接字符串获取数据库相关信息
	// Parameter: std::string url 数据库连接字符串
	// Parameter: std::string & ip 保存IP
	// Parameter: int & port 保存端口
	// Parameter: std::string & dbname 保存数据库名称
	//************************************
	void parseDbConnUrl(std::string url, std::string& ip, int& port, std::string& dbname);
};
#endif // _YAMLHELPER_H_
