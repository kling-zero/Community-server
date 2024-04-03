#include "stdafx.h"
#include "api/Aspect.h"
#include "JWTUtil.h"
#include "../domain/vo/JsonVO.h"
#include <sstream>

// std::string RSA_PUB_KEY = R"(
// -----BEGIN PUBLIC KEY-----
// MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2CUog6kdKUOlOtdOHFcs
// ts0KHt5eg8UPF6Yj/jte7jgxOWsYB571rdMzTDIYo1UIaYVOJcd3oio9QlebUZD7
// O4GL8oJmj9rNCVk60xfx3vhYISzdHbwQhUUgx+YDmDr5UJV/D/uhCdFKziTUBMjD
// otSQXvCsbWIMGGEFbPXKe9VRmgqtjdNfWvjMa7spQwiy0gj7GeOUiIttkVZna6qF
// FZRSRAxp3NJ9ELbcW7Kd9u5IFzrvxXNiYPOtIiw+zqJTYsSXUJTI7YQAXy9zqGtT
// 7QUFUjxUf+7b1DELpGZPmwGd5Jzj+zfTNsS3DRNuPQJPkPbpUo1qCsU55sXgcNrf
// zwIDAQAB
// -----END PUBLIC KEY-----)";
std::string RSA_PUB_KEY = "";

#ifndef CHECK_TOKEN

//开启凭证检查，解开下一行注释即可
//#define CHECK_TOKEN

#endif

//测试负载数据注入
#define TEST_PAYLOAD_INJECTION(__req__) \
PayloadDTO payload; \
payload.setId("1"); \
payload.setUsername("admin"); \
payload.getAuthorities().push_back("ADMIN"); \
payload.getAuthorities().push_back("TEST"); \
__req__.setUserPayload(nlohmann::json(payload));

void checkCommonSender(string message, response& res) {
	JsonVO vo = JsonVO("", RS_UNAUTHORIZED);
	vo.setMessage(message);
	nlohmann::json jvo = nlohmann::json(vo);
	jvo.erase("data");
	res.render_json(jvo);
}

bool CROS::before(request& req, response& res)
{
	res.add_header("Access-Control-Allow-Origin", "*");
	res.add_header("Access-Control-Allow-Methods", "*");
	res.add_header("Access-Control-Expose-Headers", "*");
	//允许携带cookie凭证
	res.add_header("Access-Control-Allow-Credentials", "true");
	res.add_header("Access-Control-Allow-Headers", "Content-Type,Access-Token");
	if (req.get_method() == "OPTIONS") {
		res.set_status_and_content(status_type::ok);
		return false;
	}
	return true;
}

Check::Check()
{
	//读取公钥
	if (RSA_PUB_KEY == "")
	{
		ifstream ifs("public.pem");
		if (ifs.is_open())
		{
			string tmp;
			while (std::getline(ifs, tmp))
			{
				RSA_PUB_KEY += tmp + "\n";
			}
			ifs.close();
		}
	}
}

bool Check::before(request& req, response& res)
{
#ifdef CHECK_TOKEN
	//获取请求凭证
	string_view token = req.get_header_value("Authorization");
	if (token.empty()) {
		checkCommonSender("empty token", res);
		return false;
	}
	//解析凭证
	string_view prefix = "Bearer ";
	if (token.find_first_of(prefix) != 0) {
		checkCommonSender("prefix error", res);
		return false;
	}
	//1 去掉前缀
	token.remove_prefix(prefix.size());
	//2 解析凭证
	PayloadDTO payload = JWTUtil::verifyTokenByRsa(string(token), RSA_PUB_KEY);
	if (payload.getCode() != PayloadCode::SUCCESS) {
		stringstream ss;
		ss << "check fail code : " << (int)payload.getCode();
		checkCommonSender(ss.str(), res);
		return false;
	}
	//3 将解析数据放到userPayload中
	req.setUserPayload(nlohmann::json(payload));
	return true;
#else
	TEST_PAYLOAD_INJECTION(req);
	return true;
#endif
}

bool Check::after(request& req, response& res)
{
	std::cout << "<" << req.get_url() << "> exec finish" << std::endl;
	return true;
}
