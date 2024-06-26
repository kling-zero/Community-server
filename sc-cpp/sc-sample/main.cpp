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
#include "FastDfsClient.h"
#include "ExcelComponent.h"
#include "CharsetConvertHepler.h"
#include "RocketClient.h"
#include "../http-server-demo/domain/dto/sample/SampleDTO.h"

/**
 * 解析启动参数
 * 注意：
 * 参数中数据需要满足一定的格式，如：sp=8090、sn=feign-cpp-sample
 * 前缀与真实值之间使用=分隔
 */
bool getStartArg(int argc, char* argv[]) {
	// 服务器端口
	std::string serverPort = "8090";
	// 数据库连接信息
	std::string dbUsername = "root";
	std::string dbPassword = "123456";
	std::string dbName = "test";
	std::string dbHost = "172.29.40.47";
	int dbPort = 3306;
	int dbMax = 25;
#ifdef USE_NACOS
	// Nacos配置参数
	std::string nacosAddr = "39.99.114.126:8848";
	std::string nacosNs = "1653f775-4782-46ad-9cd2-b60155a574c6";
	std::string serviceName = "feign-cpp-sample";
	std::string regIp = "192.168.220.128";
#endif

	// 开始解析
	int currIndex = 1;
	bool isSetDb = false;
	while (currIndex < argc)
	{
		// 拆分字符串
		auto args = StringUtil::split(argv[currIndex], "=");
		// 判断参数是否合法
		if (args.size() != 2) {
			cout << "arg: " << argv[currIndex] << ", format error." << endl;
			exit(1);
		}

		// 根据参数前缀对不同属性复制
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
		// 更新索引
		currIndex++;
	}

	// 记录服务器配置到内存中方便使用
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

// 订阅消息监听者
class ML : public RocketClient::RConsumerListener {

public:
	void receiveMessage(std::string payload) override
	{
		std::cout << "receiveMessage: " << payload << std::endl;
	}
};

int main(int argc, char* argv[]) {
	// 服务器参数初始化
	bool isSetDb = getStartArg(argc, argv);
// #ifdef LINUX
// 	//定义客户端对象
// 	FastDfsClient client("conf/client.conf", 3);
// #else
// 	//定义客户端对象
// 	FastDfsClient client("192.168.220.128");
// #endif
// 	std:string fileName = "C:\\Users\\Administrator\\Desktop\\temp.gif";
// 	//测试上传
// 	std::string fieldName = client.uploadFile(fileName);
// 	std::cout << "upload fieldname is : " << fieldName << std::endl;
// 	//测试下载
// 	if (!fieldName.empty())
// 	{
// 		std::string path = "./public/fastdfs";
// 		fileName = client.downloadFile(fieldName, path);
// 		std::cout << "download savepath is : " << fileName << std::endl;
// 	}
// 	//测试删除文件
// 	if (!fieldName.empty())
// 	{
// 		std::cout << "delete file result is : " << client.deleteFile(fieldName) << std::endl;
// 	}
// 
// 
// 	//创建测试数据
// 	vector<vector<std::string>> data;
// 	stringstream ss;
// 	for (int i = 1; i <= 10; i++)
// 	{
// 		vector<std::string> row;
// 		for (int j = 1; j <= 5; j++)
// 		{
// 			ss.clear();
// 			ss
// 				<< CharsetConvertHepler::ansiToUtf8("单元格坐标：(") << i
// 				<< CharsetConvertHepler::ansiToUtf8(",") << j << ")";
// 			row.push_back(ss.str());
// 			ss.str("");
// 		}
// 		data.push_back(row);
// 	}
// 
// 	//定义保存数据位置和页签名称
// 	fileName = "./public/excel/1.xlsx";
// 	std::string sheetName = CharsetConvertHepler::ansiToUtf8("数据表");
// 
// 	//保存到文件
// 	ExcelComponent excel;
// 	excel.writeVectorToFile(fileName, sheetName, data);
// 
// 	//从文件中读取
// 	auto readData = excel.readIntoVector(fileName, sheetName);
// 	for (auto row : readData)
// 	{
// 		for (auto cellVal : row)
// 		{
// 			cout << CharsetConvertHepler::utf8ToAnsi(cellVal) << ",";
// }
// 		cout << endl;
// 	}
// 
// 	//上传Excel到FastDFS
// 	fieldName = client.uploadFile(fileName);
// 	std::cout << "upload fieldname is : " << fieldName << std::endl;
	
//     //演示消息中间件
// 	std::shared_ptr<RocketClient> client = make_shared<RocketClient>("192.168.220.128:9876");
// 	// 定义消息对象
// 	SampleDTO dto;
// 	dto.setName("cat");
// 	dto.setSex("man");
// 	dto.setAge(10);
// 	RC_PUBLISH_OBJ_MSG_SYNC(res1, client, "test1", dto);
// 	cout << "sync send result: " << res1 << endl;
// 	client->subscribe("test1");
// 	//订阅消息
// 	ML m;
// 	client->addListener(&m);

#ifdef USE_NACOS
	// 创建Nacos客户端对象
	NacosClient nacosClient(
		ServerInfo::getInstance().getNacosAddr(), 
		ServerInfo::getInstance().getNacosNs());
	// 从Nacos配置中心中获取数据库配置
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
		// 解析数据库连接字符串
		std::string dbUrl = yaml.getString(node, "spring.datasource.url");
		yaml.parseDbConnUrl(dbUrl, dbHost, dbPort, dbName);
		// 获取数据库用户名和密码
		std::string dbUsername = yaml.getString(node, "spring.datasource.username");
		std::string dbPassword = yaml.getString(node, "spring.datasource.password");
		// 重新修改缓存中的数据
		ServerInfo::getInstance().setDbUsername(dbUsername);
		ServerInfo::getInstance().setDbPassword(dbPassword);
		ServerInfo::getInstance().setDbName(dbName);
		ServerInfo::getInstance().setDbHost(dbHost);
		ServerInfo::getInstance().setDbPort(dbPort);
	}
	// 注册服务
	nacosClient.registerInstance(
		ServerInfo::getInstance().getRegIp(), 
		atoi(ServerInfo::getInstance().getServerPort().c_str()),
		ServerInfo::getInstance().getServiceName());
#endif
	
	// 初始数据库连接
	DbInit::initDbPool(DBConfig(
		ServerInfo::getInstance().getDbUsername(), 
		ServerInfo::getInstance().getDbPassword(), 
		ServerInfo::getInstance().getDbName(),
		ServerInfo::getInstance().getDbHost(),
		ServerInfo::getInstance().getDbPort(), 
		ServerInfo::getInstance().getDbMax()));
	// 启动HTTP服务器
	int code = HttpServer::startServer(ServerInfo::getInstance().getServerPort(),
		[=](http_server* server) {
			//测试代码
			server->set_http_handler<GET>("/", [](request& req, response& resp) {
				resp.set_status_and_content(status_type::ok, "hello 01star");
				});
			Router router(server);
			router.initRouter();
		}
	);
	// 释放数据库连接
	DbInit::releasePool();

#ifdef USE_NACOS
	// 反注册服务
	nacosClient.deregisterInstance(
		ServerInfo::getInstance().getRegIp(),
		atoi(ServerInfo::getInstance().getServerPort().c_str()),
		ServerInfo::getInstance().getServiceName());
#endif
	return code;
}
