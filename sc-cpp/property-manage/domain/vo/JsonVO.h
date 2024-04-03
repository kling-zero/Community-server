#ifndef _JSON_VO_
#define _JSON_VO_

#include "../GlobalInclude.h"
#include "Message.h"

/**
 * 前后端数据对接数据对象
 */
template<class T>
class JsonVO
{
    //状态码
    CC_SYNTHESIZE(int, code, Code);
    //提示消息
    CC_SYNTHESIZE(string, message, Message);
    //数据对象
    CC_SYNTHESIZE(T, data, Data);
public:
    JsonVO() {
        this->message = "";
    }
    JsonVO(T data, ResultStatus resultStatus) {
		this->setStatus(resultStatus);
        this->setData(data);
    }
    //设置状态
	void setStatus(ResultStatus resultStatus) {
        this->message = resultStatus.getMessage();
        this->code = resultStatus.getCode();
	}
    //构建成功消息
    void success(T data) {
        this->setStatus(RS_SUCCESS);
        this->setData(data);
    }
    //构建失败消息
	void fail(T data) {
		this->setStatus(RS_FAIL);
		this->setData(data);
	}
    //绑定JSON转换方法
    friend void to_json(json& j, const JsonVO<T>& t) {
        j = json{ {"code", t.code}, {"message", t.message}, {"data",t.data} };
    }
};
#endif // !_JSON_VO_


