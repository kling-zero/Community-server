#ifndef _ROCKETCLIENT_H_
#define _ROCKETCLIENT_H_
#define WIN32_LEAN_AND_MEAN

#ifdef LINUX
#include "unistd.h"
#include <functional>
#endif
#include "rocketmq/DefaultMQProducer.h"
#include "rocketmq/DefaultMQPushConsumer.h"
using namespace rocketmq;

/**
 * 定义一个Rocketmq客户端，来封装常用操作。
 * 参考连接：https://github.com/apache/rocketmq-client-cpp/tree/release-2.1.0/example
 */
class RocketClient
{
private:
	/**
	 * MQ消息监听器
	 */
	class RMessageLisenter : public MessageListenerConcurrently {
	private:
		RocketClient* client;
	public:
		RMessageLisenter(RocketClient* client);
		ConsumeStatus consumeMessage(const std::vector<MQMessageExt>& msgs) override;
	};
	/**
	 * MQ自动删除回调
	 */
	class RAutoDeleteSendCallback : public AutoDeleteSendCallBack {
	public:
		void onSuccess(SendResult& sendResult) override;
		void onException(MQException& e) override;
	};
public:
	/**
	 * 消息交付回调
	 */
	class RSendCallback : public SendCallback {
	private:
		std::function<void(SendStatus)> cf;
	public:
		RSendCallback(std::function<void(SendStatus)> cf);
		void onSuccess(SendResult& sendResult) override;
		void onException(MQException& e) override;
	};
	/**
	 * 消费消息监听器
	 */
	class RConsumerListener {
	public:
		// 接收消息
		virtual void receiveMessage(std::string payload) = 0;
	};
private:
	// nameserver地址
	std::string namesrv;
	// 分组名称
	std::string groupname;
	// 当前主题
	std::string m_topic;
	// 接收消息事件通知集合
	std::vector<RConsumerListener*> m_listeners;
	// 生产者
	DefaultMQProducer* m_producer;
	// 消费者
	DefaultMQPushConsumer* m_consumer;
	// MQ消息监听器
	RMessageLisenter* m_msgListener;
	// 释放生产者
	void releaseProducer();
	// 释放消费者
	void releaseConsumer();
public:
	//************************************
	// Method:    RocketClient
	// FullName:  RocketClient::RocketClient
	// Access:    public 
	// Returns:   
	// Qualifier: 构造初始化
	// Parameter: const std::string & namesrv nameserver地址，如：ip1:port1;ip2:port2
	// Parameter: const std::string & groupName 分组名称，默认值为cpp-rocketmq
	//************************************
	RocketClient(const std::string& namesrv, const std::string& groupName = "cpp-rocketmq");
	// 析构释放资源
	~RocketClient();
	//************************************
	// Method:    productMsg
	// FullName:  RocketClient::productMsg
	// Access:    public 
	// Returns:   void
	// Qualifier: 生产消息
	// Parameter: const std::string & topic 主题
	// Parameter: const std::string & body 消息主题
	// Parameter: SendCallback * cb 发送结果回调对象，默认值nullptr
	//************************************
	void productMsgAsync(const std::string& topic, const std::string& body, SendCallback* cb = nullptr);
	//************************************
	// Method:    productMsgSync
	// FullName:  RocketClient::productMsgSync
	// Access:    public 
	// Returns:   rocketmq::SendStatus 消息发送结果状态
	// Qualifier: 同步生产消息
	// Parameter: const std::string & topic 主题
	// Parameter: const std::string & body 消息主体
	//************************************
	rocketmq::SendStatus productMsgSync(const std::string& topic, const std::string& body);
	//************************************
	// Method:    subscribe
	// FullName:  RocketClient::subscribe
	// Access:    public 
	// Returns:   bool 订阅成功返回true
	// Qualifier: 订阅主题
	// 注意：同一个RocketClient对象只能订阅一次，当然你可以取消订阅，然后重新订阅
	// Parameter: const std::string & topic 主题
	//************************************
	bool subscribe(const std::string& topic);
	//************************************
	// Method:    unsubscribe
	// FullName:  RocketClient::unsubscribe
	// Access:    public 
	// Returns:   void
	// Qualifier: 取消订阅
	//************************************
	void unsubscribe();
	//************************************
	// Method:    addListener
	// FullName:  RocketClient::addListener
	// Access:    public 
	// Returns:   void
	// Qualifier: 添加订阅消息处理监听者
	// Parameter: RConsumerListener * listener 监听者对象
	//************************************
	void addListener(RConsumerListener* listener);
	//************************************
	// Method:    removeListener
	// FullName:  RocketClient::removeListener
	// Access:    public 
	// Returns:   void
	// Qualifier: 移除订阅消息处理监听者
	// Parameter: RConsumerListener * listener 监听者对象
	//************************************
	void removeListener(RConsumerListener* listener);
	//************************************
	// Method:    removeAllListener
	// FullName:  RocketClient::removeAllListener
	// Access:    public 
	// Returns:   void
	// Qualifier: 移除所有订阅消息处理监听者
	//************************************
	void removeAllListener();
};

// 异步发布对象消息，这里会将对象转换成JSON字符串
#define RC_PUBLISH_OBJ_MSG_ASYNC(__ROCKET_CLIENT__, __TOPIC__, __DATA_OBJ__, __CB_OBJ__) \
{ \
	nlohmann::json jobj(__DATA_OBJ__); \
	__ROCKET_CLIENT__->productMsgAsync(__TOPIC__, jobj.dump(), __CB_OBJ__); \
}

// 同步发布对象消息，这里会将对象转换成JSON字符串
#define RC_PUBLISH_OBJ_MSG_SYNC(__RETURN_VAR_NAME__, __ROCKET_CLIENT__, __TOPIC__, __DATA_OBJ__) \
nlohmann::json jobj##__RETURN_VAR_NAME__(__DATA_OBJ__); \
rocketmq::SendStatus __RETURN_VAR_NAME__ = __ROCKET_CLIENT__->productMsgSync(__TOPIC__, jobj##__RETURN_VAR_NAME__.dump()); 

// 接收消息，将JSON字符串转换成对象
#define RC_RECEIVER_MSG_CONVERT(__RETURN_VAR_NAME__, __DATA__TYPE__, __PAYLOAD__) \
nlohmann::json jobj##__RETURN_VAR_NAME__ = nlohmann::json::parse(__PAYLOAD__); \
__DATA__TYPE__ __RETURN_VAR_NAME__ = jobj##__RETURN_VAR_NAME__.get<__DATA__TYPE__>();

#endif // _ROCKETCLIENT_H_
