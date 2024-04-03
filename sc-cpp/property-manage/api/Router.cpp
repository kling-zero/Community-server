#include "stdafx.h"
#include "Router.h"
#include "api/Aspect.h"
#include "domain/vo/JsonVO.h"
#include "api/shopmanage/ShopManage.h"

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
	//���þ�̬�ļ�Ŀ¼
	server->set_public_root_directory("public");
	server->set_static_dir("static/file");

#ifdef HTTP_SERVER_DEMO
	//����ҳҳ��
	BIND_GET_ROUTER(server, "/", [](request& req, response& res) {
		res.render_raw_view("./public/test.html");
		}, nullptr);
#endif

//��ʼ��һ���ļ��ϴ�����ӿ�
	//BIND_POST_ROUTER(server, "/upload-file", [](request& req, response& res)
	//	{
	//		if (req.get_content_type() != content_type::multipart)
	//		{
	//			JsonVO vo = JsonVO("", RS_CONTENT_TYPE_ERR);
	//			nlohmann::json jvo = nlohmann::json(vo);
	//			jvo.erase("data");
	//			res.render_json(jvo);
	//			return;
	//		}
	//		//��ȡ�ļ�·��
	//		auto& files = req.get_upload_files();
	//		vector<string> filePaths;
	//		for (auto& file : files) {
	//			filePaths.push_back(file.get_file_path().substr(1));
	//			std::cout << file.get_file_path() << " " << file.get_file_size() << std::endl;
	//		}
	//		res.render_json(nlohmann::json(JsonVO<vector<string>>(filePaths, RS_SUCCESS)));
	//	}, nullptr);
	
#ifdef HTTP_SERVER_DEMO
	createSampleRouter();
	createUserDepartRouter();
	TestWs::addChatHandler(server);
#endif

	//#TIP :ϵͳ��չ·�ɶ��壬д���������
	initOwnerMemberRouter();
	initOwnerInfo();
	initShopManage();
	initBind();
	initOwnerAccount();
	initOwnerMemberRouter();
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
void Router::initOwnerMemberRouter()
{
	BIND_GET_ROUTER(server, "/property-manage/query-owner-list", &OwnerMemberController::queryOwnerList, nullptr);
}
void Router::initOwnerInfo()
{
	BIND_GET_ROUTER(server, "/property-manage/query-owner-info",&OwnerInfoController::queryOwnerInfo, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/add-owner-info", &OwnerInfoController::addOwnerInfo, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/modify-owner-info", &OwnerInfoController::modifyOwnerInfo, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/delete-owner-info", &OwnerInfoController::deleteOwnerInfo, nullptr);
	BIND_GET_ROUTER(server, "/property-manage/show-detailed-owner-info", &OwnerInfoController::showDetailedOwnerInfo, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/unbind-house-info", &OwnerInfoController::unbindHouseInfo, nullptr);
	BIND_GET_ROUTER(server, "/property-manage/query-building-info", &OwnerInfoController::queryBuildingInfo, nullptr);
}
void Router::initOwnerAccount()
{
	//��ѯҵ���˻�
	BIND_GET_ROUTER(server, "/property-manage/query-owner-account", &OwnerAccountController::queryOwnerAccount, nullptr);
	//��ѯ�˻�����
	BIND_GET_ROUTER(server, "/property-manage/query-account-type", &OwnerAccountController::queryAccountType, nullptr);
	//��ѯ�˻���ϸ
	BIND_GET_ROUTER(server, "/property-manage/query-account-detail", &OwnerAccountController::queryOwnerAccountDetail, nullptr);
	//Ԥ���˻��е�ѡ��ҵ�����б�
	BIND_GET_ROUTER(server, "/property-manage/query-select-owner", &OwnerAccountController::querySelectOwner, nullptr);
	//Ԥ���˻�
	BIND_POST_ROUTER(server, "/property-manage/pre-storage", &OwnerAccountController::preStorageAccount, nullptr);
}
/*
	��·��
	@Author: niuniu
	@Date:2022/10/22
*/
void Router::initShopManage()
{
	BIND_GET_ROUTER(server, "/property-manage/query-shop-state", &ShopManageController::queryShopState, nullptr);
	BIND_GET_ROUTER(server, "/property-manage/query-shop-list", &ShopManageController::queryShopList, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/addshop-post", &ShopManageController::AddShop, nullptr);
	BIND_GET_ROUTER(server, "/property-manage/query-building", &ShopManageController::queryBuilding, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/delete-post", &ShopManageController::DeleteShop, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/modify-post", &ShopManageController::ModifyShop, nullptr);
}

void Router::initBind()
{
	BIND_GET_ROUTER(server, "/property-manage/query-check-type", &BindOwnerController::queryCheckType, nullptr);
	BIND_GET_ROUTER(server, "/property-manage/query-check-list", &BindOwnerController::queryCheckList, nullptr);
	BIND_POST_ROUTER(server, "/property-manage/change-bind-type", &BindOwnerController::changeBindState, nullptr);
}


