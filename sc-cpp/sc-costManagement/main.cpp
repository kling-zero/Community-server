#include "stdafx.h"
#include "HttpServer.h"
#include "DbInit.h"
#include "api/Router.h"
#include "ServerInfo.h"
#include "StringUtil.h"

#ifdef USE_NACOS
#include "NacosClient.h"
#include "YamlHelper.h"
#endif

/**
 * ������������
 * ע�⣺
 * ������������Ҫ����һ���ĸ�ʽ���磺sp=8090��sn=feign-cpp-sample
 * ǰ׺����ʵֵ֮��ʹ��=�ָ�
 */
bool getStartArg(int argc, char* argv[]) {
	// �������˿�
	std::string serverPort = "8090";
	// ���ݿ�������Ϣ
	std::string dbUsername = "root";
	std::string dbPassword = "123456";
	std::string dbName = "zosc_tt";
	std::string dbHost = "localhost";
	int dbPort = 3306;
	int dbMax = 25;
#ifdef USE_NACOS
	// Nacos���ò���
	std::string nacosAddr = "39.99.114.126:8848";
	std::string nacosNs = "1653f775-4782-46ad-9cd2-b60155a574c6";
	std::string serviceName = "feign-cpp-sample";
	std::string regIp = "192.168.220.128";
#endif

	// ��ʼ����
	int currIndex = 1;
	bool isSetDb = false;
	while (currIndex < argc)
	{
		// ����ַ���
		auto args = StringUtil::split(argv[currIndex], "=");
		// �жϲ����Ƿ�Ϸ�
		if (args.size() != 2) {
			cout << "arg: " << argv[currIndex] << ", format error." << endl;
			exit(1);
		}

		// ���ݲ���ǰ׺�Բ�ͬ���Ը���
		std::string prefix = args[0];
		std::string val = args[1];
		if (prefix == "sp") serverPort = val;
		else if (prefix == "du") {
			isSetDb = true;
			dbUsername = val;
		}
		else if (prefix == "dp") {
			isSetDb = true;
			dbPassword = val;
		}
		else if (prefix == "dn") {
			isSetDb = true;
			dbName = val;
		}
		else if (prefix == "dh") {
			isSetDb = true;
			dbHost = val;
		}
		else if (prefix == "dP") {
			isSetDb = true;
			dbPort = atoi(val.c_str());
		}
		else if (prefix == "dm") dbMax = atoi(val.c_str());
#ifdef USE_NACOS
		else if (prefix == "na") nacosAddr = val;
		else if (prefix == "ns") nacosNs = val;
		else if (prefix == "sn") serviceName = val;
		else if (prefix == "ip") regIp = val;
#endif
		// ��������
		currIndex++;
	}

	// ��¼���������õ��ڴ��з���ʹ��
	ServerInfo::getInstance().setServerPort(serverPort);
	ServerInfo::getInstance().setDbUsername(dbUsername);
	ServerInfo::getInstance().setDbPassword(dbPassword);
	ServerInfo::getInstance().setDbName(dbName);
	ServerInfo::getInstance().setDbHost(dbHost);
	ServerInfo::getInstance().setDbPort(dbPort);
	ServerInfo::getInstance().setDbMax(dbMax);
#ifdef USE_NACOS
	ServerInfo::getInstance().setNacosAddr(nacosAddr);
	ServerInfo::getInstance().setNacosNs(nacosNs);
	ServerInfo::getInstance().setRegIp(regIp);
	ServerInfo::getInstance().setServiceName(serviceName);
#endif
	return isSetDb;
}

int main(int argc, char* argv[]) {
	// ������������ʼ��
	bool isSetDb = getStartArg(argc, argv);

#ifdef USE_NACOS
	// ����Nacos�ͻ��˶���
	NacosClient nacosClient(
		ServerInfo::getInstance().getNacosAddr(),
		ServerInfo::getInstance().getNacosNs());
	// ��Nacos���������л�ȡ���ݿ�����
	if (!isSetDb)
	{
#ifdef LINUX
		YAML::Node node = nacosClient.getConfig("data-source.yaml");
#else
		YAML::Node node = nacosClient.getConfig("./conf/data-source.yaml");
#endif
		YamlHelper yaml;
		int dbPort = 0;
		std::string dbHost = "";
		std::string dbName = "";
		// �������ݿ������ַ���
		std::string dbUrl = yaml.getString(node, "spring.datasource.url");
		yaml.parseDbConnUrl(dbUrl, dbHost, dbPort, dbName);
		// ��ȡ���ݿ��û���������
		std::string dbUsername = yaml.getString(node, "spring.datasource.username");
		std::string dbPassword = yaml.getString(node, "spring.datasource.password");
		// �����޸Ļ����е�����
		ServerInfo::getInstance().setDbUsername(dbUsername);
		ServerInfo::getInstance().setDbPassword(dbPassword);
		ServerInfo::getInstance().setDbName(dbName);
		ServerInfo::getInstance().setDbHost(dbHost);
		ServerInfo::getInstance().setDbPort(dbPort);
	}
	// ע�����
	nacosClient.registerInstance(
		ServerInfo::getInstance().getRegIp(),
		atoi(ServerInfo::getInstance().getServerPort().c_str()),
		ServerInfo::getInstance().getServiceName());
#endif

	// ��ʼ���ݿ�����
	DbInit::initDbPool(DBConfig(
		ServerInfo::getInstance().getDbUsername(),
		ServerInfo::getInstance().getDbPassword(),
		ServerInfo::getInstance().getDbName(),
		ServerInfo::getInstance().getDbHost(),
		ServerInfo::getInstance().getDbPort(),
		ServerInfo::getInstance().getDbMax()));
	// ����HTTP������
	int code = HttpServer::startServer(ServerInfo::getInstance().getServerPort(),
		[=](http_server* server) {
			//���Դ���
			server->set_http_handler<GET>("/", [](request& req, response& resp) {
				resp.set_status_and_content(status_type::ok, "hello 01star");
				});
			Router router(server);
			router.initRouter();
		}
	);
	// �ͷ����ݿ�����
	DbInit::releasePool();

#ifdef USE_NACOS
	// ��ע�����
	nacosClient.deregisterInstance(
		ServerInfo::getInstance().getRegIp(),
		atoi(ServerInfo::getInstance().getServerPort().c_str()),
		ServerInfo::getInstance().getServiceName());
#endif
	return code;
}