#include "stdafx.h"
#include "TestFastDfs.h"
#include "FastDfsClient.h"
#include <iostream>

void TestFastDfs::testDfs(string fileName)
{
#ifdef LINUX
	//定义客户端对象
	FastDfsClient client("conf/client.conf", 3);
#else
	//定义客户端对象
	FastDfsClient client("119.91.222.254");
#endif

	//测试上传
	std::string fieldName = client.uploadFile(fileName);
	std::cout << "upload fieldname is : " << fieldName << std::endl;
	//测试下载
	if (!fieldName.empty())
	{
		std::string path = "./public/fastdfs";
		fileName = client.downloadFile(fieldName, path);
		std::cout << "download savepath is : " << fileName << std::endl;
	}
	//测试删除文件
	if (!fieldName.empty())
	{
		std::cout << "delete file result is : " << client.deleteFile(fieldName) << std::endl;
	}
}
