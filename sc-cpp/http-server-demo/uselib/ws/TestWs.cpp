#include "stdafx.h"
#include "TestWs.h"
#include "StringUtil.h"

std::map<std::string_view, conn_type*> conn_pool;
std::mutex m_mutex;


void TestWs::addChatHandler(http_server* server)
{
	server->set_http_handler("/chat/*", [](request& req, response& res) {
		// �ж�content-type
		if (req.get_content_type() == content_type::websocket)
		{
			//������
			req.on(ws_open, [](request& req) {
				// ��ȡ�ͻ���ID
				std::string_view id = req.get_query_value("id");
				// �жϿͻ����Ƿ����
				std::lock_guard<std::mutex> gu(m_mutex);
				if (conn_pool.find(id) != conn_pool.end())
				{
					// �ܾ�����
					req.get_conn()->on_close();
					// ����һ���������
					req.set_part_data("reason id");
					return;
				}
				// ���뵽���ӳ���
				conn_pool.insert(std::make_pair(id, req.get_conn()));
				std::cout << "client (" << id << ") open" << std::endl;
				});
			//������Ϣ
			req.on(ws_message, [](request& req) {
				//��ȡ��Ϣ
				std::string_view _part_data = req.get_part_data();
				//ת�����ַ���
				std::string msg = std::string(_part_data.data(), _part_data.length());
				//��Ϣ���
				std::vector<string> msgs = StringUtil::split(msg, "::");
				//Ⱥ��
				if ("all" == msgs[0])
				{
					std::lock_guard<std::mutex> gu(m_mutex);
					for (auto one : conn_pool)
					{
						//�ų��Լ�
						if (one.second == req.get_conn())
						{
							continue;
						}
						one.second->send_ws_string(msgs[1]);
					}
				}
				//ָ������
				else
				{
					std::lock_guard<std::mutex> gu(m_mutex);
					auto iter = conn_pool.find(msgs[0]);
					if (iter != conn_pool.end())
					{
						iter->second->send_ws_string(msgs[1]);
					}
				}
				req.get_conn()->send_ws_string("msg send succ");
				});
			//�쳣����
			req.on(ws_error, [](request& req) {
				// ��ȡ�ͻ���ID
				std::string_view id = req.get_query_value("id");
				// �Ƿ��Ǿܾ�����
				if ("reason id" == req.get_part_data())
				{
					std::cout << "client (" << id << ") has been used" << std::endl;
				}
				else
				{
					std::cout << "client (" << id << ") close" << std::endl;
					std::lock_guard<std::mutex> gu(m_mutex);
					conn_pool.erase(id);
				}
				});
		}
		});
}
