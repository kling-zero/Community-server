#include "stdafx.h"
#include "Router.h"
#include "api/Aspect.h"
#include "../domain/vo/JsonVO.h"
#include "OwnerVehicle/OwnerVehicleController.h"
#include "booth/BoothItemController.h"

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
	initOwnerVehicle();
	initBooth();
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


void Router::initOwnerVehicle()
{
	//BIND_GET_ROUTER(server, "/query-parking-status", &OwnerVehicleController::queryParkingStatus, nullptr);
	BIND_GET_ROUTER(server, "/query-car-info", &OwnerVehicleController::queryCarInfo, nullptr);

	BIND_GET_ROUTER(server, "/query-choose-park", &OwnerVehicleController::queryChoosePark, nullptr);
	BIND_GET_ROUTER(server, "/query-choose-owner", &OwnerVehicleController::queryChooseOwner, nullptr);
	BIND_POST_ROUTER(server, "/dto-add-owner-car", &OwnerVehicleController::dtoAddOwnerCar, nullptr);

	BIND_GET_ROUTER(server, "/query-fee-type", &OwnerVehicleController::queryFeeType, nullptr);
	BIND_POST_ROUTER(server, "/dto-add-fee-list", &OwnerVehicleController::dtoAddFeeList, nullptr);
	BIND_PUT_ROUTER(server, "/dto-edit-fee-list", &OwnerVehicleController::dtoEditFeeListDTO, nullptr);
	BIND_DEL_ROUTER(server, "/dto-del-fee-list", &OwnerVehicleController::dtoDelFeeList, nullptr);

	BIND_PUT_ROUTER(server, "/dto-edit-owner-car", &OwnerVehicleController::dtoEditOwnerCar, nullptr);
	BIND_DEL_ROUTER(server, "/dto-del-owner-car", &OwnerVehicleController::dtoDelOwnerCar, nullptr);

	BIND_GET_ROUTER(server, "/query-owner-car-member", &OwnerVehicleController::queryOwnerCarMember, nullptr);
	BIND_POST_ROUTER(server, "/dto-add-owner-car-member", &OwnerVehicleController::dtoAddOwnerCarMember, nullptr);
	BIND_DEL_ROUTER(server, "/dto-del-owner-car-member", &OwnerVehicleController::dtoDelOwnerCarMember, nullptr);
	BIND_PUT_ROUTER(server, "/dto-edit-owner-car-member", &OwnerVehicleController::dtoEditOwnerCarMember, nullptr);

}

void Router::initBooth()
{
	BIND_GET_ROUTER(server, "/query-booth-list", &BoothItemController::queryBoothList, nullptr);
	BIND_GET_ROUTER(server, "/query3-booth-list", &BoothItemController::query3BoothList, nullptr);
	BIND_GET_ROUTER(server, "/query-sharebooth-list", &BoothItemController::queryShareBoothList, nullptr);

	BIND_POST_ROUTER(server, "/booth-add", &BoothItemController::addBooth, nullptr);
	BIND_DEL_ROUTER(server, "/booth-delete", &BoothItemController::deleteBooth, nullptr);
	BIND_PUT_ROUTER(server, "/booth-modify", &BoothItemController::modifyBooth, nullptr);
	BIND_POST_ROUTER(server, "/sharebooth-add", &BoothItemController::addShareBooth, nullptr);
	BIND_DEL_ROUTER(server, "/sharebooth-delete", &BoothItemController::deleteShareBooth, nullptr);
}