#ifndef _JSON_VO_
#define _JSON_VO_

#include "../GlobalInclude.h"
#include "Message.h"

/**
 * ǰ������ݶԽ����ݶ���
 */
template<class T>
class JsonVO
{
    //״̬��
    CC_SYNTHESIZE(int, code, Code);
    //��ʾ��Ϣ
    CC_SYNTHESIZE(string, message, Message);
    //���ݶ���
    CC_SYNTHESIZE(T, data, Data);
public:
    JsonVO() {
        this->message = "";
    }
    JsonVO(T data, ResultStatus resultStatus) {
		this->setStatus(resultStatus);
        this->setData(data);
    }
    //����״̬
	void setStatus(ResultStatus resultStatus) {
        this->message = resultStatus.getMessage();
        this->code = resultStatus.getCode();
	}
    //�����ɹ���Ϣ
    void success(T data) {
        this->setStatus(RS_SUCCESS);
        this->setData(data);
    }
    //����ʧ����Ϣ
	void fail(T data) {
		this->setStatus(RS_FAIL);
		this->setData(data);
	}
    //��JSONת������
    friend void to_json(json& j, const JsonVO<T>& t) {
        j = json{ {"code", t.code}, {"message", t.message}, {"data",t.data} };
    }
};
#endif // !_JSON_VO_


