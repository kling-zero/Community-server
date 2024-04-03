#include "stdafx.h"
#include "TestWs.h"
#include "StringUtil.h"

std::map<std::string_view, conn_type*> conn_pool;
std::mutex m_mutex;


void TestWs::addChatHandler(http_server* server)
{
	server->set_http_handler("/chat/*", [](request& req, response& res) {
		// 判断content-type
		if (req.get_content_type() == content_type::websocket)
		{
			//打开连接
			req.on(ws_open, [](request& req) {
				// 获取客户端ID
				std::string_view id = req.get_query_value("id");
				// 判断客户端是否存在
				std::lock_guard<std::mutex> gu(m_mutex);
				if (conn_pool.find(id) != conn_pool.end())
				{
					// 拒绝连接
					req.get_conn()->on_close();
					// 设置一个标记数据
					req.set_part_data("reason id");
					return;
				}
				// 加入到连接池中
				conn_pool.insert(std::make_pair(id, req.get_conn()));
				std::cout << "client (" << id << ") open" << std::endl;
				});
			//接受消息
			req.on(ws_message, [](request& req) {
				//获取消息
				std::string_view _part_data = req.get_part_data();
				//转换成字符串
				std::string msg = std::string(_part_data.data(), _part_data.length());
				//消息拆分
				std::vector<string> msgs = StringUtil::split(msg, "::");
				//群发
				if ("all" == msgs[0])
				{
					std::lock_guard<std::mutex> gu(m_mutex);
					for (auto one : conn_pool)
					{
						//排除自己
						if (one.second == req.get_conn())
						{
							continue;
						}
						one.second->send_ws_string(msgs[1]);
					}
				}
				//指定发送
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
			//异常处理
			req.on(ws_error, [](request& req) {
				// 获取客户端ID
				std::string_view id = req.get_query_value("id");
				// 是否是拒绝加入
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
