#include "stdafx.h"
#include "Router.h"
#include "api/Aspect.h"
#include "domain/vo/JsonVO.h"

#ifdef HTTP_SERVER_DEMO
#include "sample/SampleController.h"
#include "user/DepartController.h"
#include "uselib/ws/TestWs.h"
#endif


Router::Router(http_server* sever)
{
	this->server = sever;
}

void Router::initRouter()
{
	//设置静态文件目录
	server->set_public_root_directory("public");
	server->set_static_dir("static/file");

#ifdef HTTP_SERVER_DEMO
	//绑定首页页面
	BIND_GET_ROUTER(server, "/", [](request& req, response& res) {
		res.render_raw_view("./public/test.html");
		}, nullptr);
#endif

	//初始化一个文件上传处理接口
	BIND_POST_ROUTER(server, "/upload-file", [](request& req, response& res)
		{
			if (req.get_content_type() != content_type::multipart)
			{
				JsonVO vo = JsonVO("", RS_CONTENT_TYPE_ERR);
				nlohmann::json jvo = nlohmann::json(vo);
				jvo.erase("data");
				res.render_json(jvo);
				return;
			}
			//获取文件路径
			auto& files = req.get_upload_files();
			vector<string> filePaths;
			for (auto& file : files) {
				filePaths.push_back(file.get_file_path().substr(1));
				std::cout << file.get_file_path() << " " << file.get_file_size() << std::endl;
			}
			res.render_json(nlohmann::json(JsonVO<vector<string>>(filePaths, RS_SUCCESS)));
		}, nullptr);
	
#ifdef HTTP_SERVER_DEMO
	createSampleRouter();
	createUserDepartRouter();
	TestWs::addChatHandler(server);
#endif

	//#TIP :系统扩展路由定义，写在这个后面

}

#ifdef HTTP_SERVER_DEMO
void Router::createSampleRouter()
{
	BIND_GET_ROUTER(server, "/get", &SampleController::querySample, nullptr);
	BIND_POST_ROUTER(server, "/post", &SampleController::addSample, nullptr);
	BIND_PUT_ROUTER(server, "/put", &SampleController::modifySample, nullptr);
	BIND_DEL_ROUTER(server, "/delete", &SampleController::removeSample, nullptr);
	BIND_DEL_ROUTER(server, "/delete-by-id", &SampleController::removeById, nullptr);
	BIND_POST_ROUTER(server, "/json", &SampleController::jsonSample, nullptr);
}

void Router::createUserDepartRouter()
{
	BIND_POST_ROUTER(server, "/depart-add", &DepartController::addDepart, nullptr);
	BIND_POST_ROUTER(server, "/depart-add-more", &DepartController::addDepartMore, nullptr);
}
#endif
