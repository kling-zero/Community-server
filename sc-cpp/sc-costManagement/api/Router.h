#ifndef _ROUTER_
#define _ROUTER_

#include "api/ApiHelper.h"
#include"api/setting/FeeItemController.h"
#include"api/combo/ComboItemController.h"
#include"api/import/FeeImportItemController.h"

class Router
{
private:
	http_server* server;
public:
	//构造初始化
	Router(http_server* sever);
	//呼叫初始化
	void initRouter();
private:
#ifdef HTTP_SERVER_DEMO
	//创建演示路由
	void createSampleRouter();
	//创建用户管理-部门管理路由
	void createUserDepartRouter();
#endif
	void initFeeSetting();
	void initFeeCombo();
	void initFeeImport();
	// 创建车辆费用路由
	void initCarFee();
	// 创建员工费用路由
	void initStaffFee();
	// 创建费用公摊公式路由
	void createFeeFormulaRouter();
	// 创建费用汇总路由
	void createFeeSumRouter();
	// 创建取消费用路由
	void createFeeCancelRouter();
	void initDiscountRequest();
	void initDiscountSetting();
	void initPreferentialType();
};

#endif // !_ROUTER_