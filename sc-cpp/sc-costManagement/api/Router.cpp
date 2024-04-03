#include "stdafx.h"
#include "Router.h"
#include "api/Aspect.h"
#include "domain/vo/JsonVO.h"
#include "api/CarFee/CarFeeController.h"
#include "api/StaffFee/StaffFeeController.h"
#include"api/feecancel/FeeCancelController.h"
#include"api/feeformula/FeeFormulaController.h"
#include"api/feesum/FeeSumController.h"
#include "api/DiscountRequest/DiscountRequestController.h"
#include "api/DiscountSetting/DiscountSettingController.h"
#include "api/PreferentialType/PreferentialTypeController.h"

#ifdef HTTP_SERVER_DEMO
#include "sample/SampleController.h"
#include "user/DepartController.h"
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
#endif

	//#TIP :系统扩展路由定义，写在这个后面
	initFeeSetting();
	initFeeCombo();
	initFeeImport();
	initCarFee();
	initStaffFee();
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

void Router::initCarFee()
{
	// 车辆收费
	BIND_GET_ROUTER(server, "/query-carFee-list", &CarFeeController::queryCarFeeList, nullptr);
	// 车位状态
	BIND_GET_ROUTER(server, "/query-carState", &CarFeeController::queryCarState, nullptr);
	// 费用类型
	BIND_GET_ROUTER(server, "/query-feetype", &CarFeeController::queryFeetype, nullptr);
	// 查看收费
	BIND_GET_ROUTER(server, "/query-checkCharges", &CarFeeController::queryCheckCharges, nullptr);
	// 创建费用
	BIND_POST_ROUTER(server, "/json-createFee", &CarFeeController::jsonCreateFee, nullptr);
	// 停车场
	BIND_GET_ROUTER(server, "/query-parking", &CarFeeController::queryParking, nullptr);
	// 取消费用
	BIND_DEL_ROUTER(server, "/delete-carFee", &CarFeeController::removeCarFee, nullptr);
	// 变更费用
	BIND_PUT_ROUTER(server, "/put-modifyCarFee", &CarFeeController::modifyCarFee, nullptr);
	// 缴费历史查询
	BIND_GET_ROUTER(server, "/query-paymentHistory", &CarFeeController::queryPaymentHistory, nullptr);
	// 收费范围
	BIND_GET_ROUTER(server, "/query-chargeRange", &CarFeeController::queryChargeRange, nullptr);

	// 收费项目
	BIND_GET_ROUTER(server, "/query-chargingItem", &CarFeeController::queryChargingItem, nullptr);

	// 批量创建
	BIND_POST_ROUTER(server, "/json-batchCreation", &CarFeeController::jsonBatchCreation, nullptr);
	
}



void Router::initStaffFee()
{
	//// 员工收费
	//BIND_GET_ROUTER(server, "/query-stafffee-list", &StaffFeeController::queryStaffFeeList, nullptr);
	// 查询
	BIND_GET_ROUTER(server, "/query-staffFee", &StaffFeeController::queryStaffFee, nullptr);
}


void Router::createFeeFormulaRouter()
{
	BIND_GET_ROUTER(server, "/query-fee-formula", &FeeFormulaController::queryFeeFormula, nullptr);
	BIND_POST_ROUTER(server, "/add-fee-formula", &FeeFormulaController::addFeeFormula, nullptr);
	BIND_PUT_ROUTER(server, "/update-fee-formula", &FeeFormulaController::updateFeeFormula, nullptr);
	BIND_DEL_ROUTER(server, "/remove-fee-formula", &FeeFormulaController::removeFeeFormula, nullptr);
}

void Router::createFeeSumRouter()
{
	BIND_GET_ROUTER(server, "/query-fee-sum", &FeeSumController::queryFeeSum, nullptr);
}

void Router::createFeeCancelRouter()
{
	BIND_GET_ROUTER(server, "/query-fee-cancel-state", &FeeCancelController::queryFeeCancelState, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-cancel", &FeeCancelController::queryFeeCancel, nullptr);
	BIND_PUT_ROUTER(server, "/update-fee-cancel", &FeeCancelController::updateFeeCancel, nullptr);
	BIND_PUT_ROUTER(server, "/update-fee-cancel-audit", &FeeCancelController::updateFeeCancelAudit, nullptr);
}

void Router::initFeeSetting()
{
	BIND_GET_ROUTER(server, "/query-fee-type", &FeeItemController::queryFeeType,nullptr);
	BIND_GET_ROUTER(server, "/query-fee-list", &FeeItemController::queryFeeList, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-flag", &FeeItemController::queryFeeFlag, nullptr);
	BIND_GET_ROUTER(server, "/query-payment-cd", &FeeItemController::queryPaymentCd, nullptr);
	BIND_GET_ROUTER(server, "/query-bill-type", &FeeItemController::queryBillType, nullptr);
	BIND_GET_ROUTER(server, "/query-is-default", &FeeItemController::queryIsDefault, nullptr);

	BIND_POST_ROUTER(server, "/add-fee-config", &FeeItemController::addFeeConfig, nullptr);
	BIND_POST_ROUTER(server, "/add-discount", &FeeItemController::addDiscount, nullptr);

	BIND_PUT_ROUTER(server, "/modify-fee-config",&FeeItemController::modifyFeeConfig,nullptr);

	BIND_DEL_ROUTER(server, "/remove-fee-config", &FeeItemController::removeFeeConfig, nullptr);
	BIND_DEL_ROUTER(server, "/remove-discount", &FeeItemController::removeDiscount, nullptr);
}


void Router::initFeeCombo() {
	BIND_GET_ROUTER(server, "/query-fee-name", &ComboItemController::queryFeeName, nullptr);
	BIND_GET_ROUTER(server, "/query-user-menu", &ComboItemController::queryUserMenu, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-combo", &ComboItemController::queryComboList, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-comboMember", &ComboItemController::queryFeeComboMemberList, nullptr);

	BIND_POST_ROUTER(server, "/add-fee-combo", &ComboItemController::addFeeCombo, nullptr);
	BIND_POST_ROUTER(server, "/add-fee-item", &ComboItemController::addFeeItem, nullptr);

	BIND_POST_ROUTER(server, "/modify-fee-combo", &ComboItemController::modifyFeeCombo, nullptr);

	BIND_POST_ROUTER(server, "/remove-fee-combo", &ComboItemController::removeFeeCombo, nullptr);
	BIND_POST_ROUTER(server, "/remove-fee-item", &ComboItemController::removeFeeItem, nullptr);
}


void Router::initFeeImport() {
	BIND_GET_ROUTER(server, "/query-fee-import", &FeeImportItemController::queryFeeImportList, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-type", &FeeImportItemController::queryFeeType, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-import-detail", &FeeImportItemController::queryFeeImportDetail, nullptr);
	BIND_GET_ROUTER(server, "/query-fee-formul", &FeeImportItemController::queryFeeFormul, nullptr);
	BIND_GET_ROUTER(server, "/query-floor-num", &FeeImportItemController::queryFloorNum, nullptr);
}





void Router::initDiscountRequest()
{
	// 合同信息
	BIND_GET_ROUTER(server, "/query-requestlist",&DiscountSettingController::queryDiscountList, nullptr);
	// 支付方式
	//BIND_GET_ROUTER(server, "/query-requeststate", &DiscountSettingController::queryRequestState, nullptr);
	// 欠费缴费
	BIND_GET_ROUTER(server, "/query-requesttype", &DiscountSettingController::queryDiscountType, nullptr);
}
void Router::initDiscountSetting()
{
	// 合同信息
	BIND_GET_ROUTER(server, "/query-discountlist", &DiscountSettingController::queryDiscountList, nullptr);
	// 支付方式
	BIND_GET_ROUTER(server, "/query-discounttype", &DiscountSettingController::queryDiscountType, nullptr);

}
void Router::initPreferentialType()
{
	// 合同信息
	BIND_GET_ROUTER(server, "/query-preferentialtype", &PreferentialTypeController::queryPreferentialTypeList, nullptr);

}



