#include "pch.h"
#include "../include/YamlHelper.h"
#include "StringUtil.h"
#include <stack>

std::string YamlHelper::getString(YAML::Node& node, std::string key)
{
	//拆分Key
	vector<std::string> keys = StringUtil::split(key, ".");
	//通过Key循环获取属性
	auto iter = keys.begin();
	std::stack<YAML::Node> st;
	st.push(node[*iter++]);
	for (; iter != keys.end(); ++iter)
	{
		auto tmp = st.top()[*iter];
		st.pop();
		st.push(tmp);
	}
	auto curr = st.top();
	return curr.as<std::string>();
}

void YamlHelper::parseDbConnUrl(std::string url, std::string& ip, int& port, std::string& dbname)
{
	//第一次通过?拆分
	std::string data = StringUtil::split(url, "?")[0];
	//第二次通过//拆分
	auto tmp = StringUtil::split(data, "//");
	data = tmp[1];
	//设置数据库名称
	dbname = tmp[2];
	//获取ip和端口
	tmp = StringUtil::split(data, ":");
	ip = tmp[0];
	port = atoi(tmp[1].c_str());
}
