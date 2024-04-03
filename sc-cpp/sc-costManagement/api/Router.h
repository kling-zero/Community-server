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
	//�����ʼ��
	Router(http_server* sever);
	//���г�ʼ��
	void initRouter();
private:
#ifdef HTTP_SERVER_DEMO
	//������ʾ·��
	void createSampleRouter();
	//�����û�����-���Ź���·��
	void createUserDepartRouter();
#endif
	void initFeeSetting();
	void initFeeCombo();
	void initFeeImport();
	// ������������·��
	void initCarFee();
	// ����Ա������·��
	void initStaffFee();
	// �������ù�̯��ʽ·��
	void createFeeFormulaRouter();
	// �������û���·��
	void createFeeSumRouter();
	// ����ȡ������·��
	void createFeeCancelRouter();
	void initDiscountRequest();
	void initDiscountSetting();
	void initPreferentialType();
};

#endif // !_ROUTER_