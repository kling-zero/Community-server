#include "pch.h"
#include "JWTUtil.h"
#include <iostream>

#define JU_VERIFY_CATCH(__p__) \
catch (const jwt::TokenExpiredError& e) { \
	std::cerr << "TokenExpiredError:" << e.what() << std::endl; \
	__p__.setCode(PayloadCode::TOKEN_EXPIRED_ERROR); \
} \
catch (const jwt::SignatureFormatError& e) { \
	std::cerr << "SignatureFormatError:" << e.what() << std::endl; \
	__p__.setCode(PayloadCode::SIGNATUREFORMAT_ERROR); \
} \
catch (const jwt::DecodeError& e) { \
	std::cerr << "DecodeError:" << e.what() << std::endl; \
	__p__.setCode(PayloadCode::DECODE_ERROR); \
} \
catch (const jwt::VerificationError& e) { \
	std::cerr << "VerificationError:" << e.what() << std::endl; \
	__p__.setCode(PayloadCode::VERIFICATION_ERROR); \
} \
catch (const std::exception& e) { \
	std::cerr << "OtherError:" << e.what() << std::endl; \
	__p__.setCode(PayloadCode::OTHER_ERROR); \
}

PayloadDTO::PayloadDTO()
{
	this->username = "";
	this->exp = 0;
	this->sub = "";
	this->setCode(PayloadCode::SUCCESS);
}

PayloadDTO::PayloadDTO(std::string _sub, long _exp, std::string _username, std::list<std::string> _authorities) :
	sub(_sub), exp(_exp), username(_username), authorities(_authorities)
{
	this->setCode(PayloadCode::SUCCESS);
}

std::string JWTUtil::md5(const std::string& src)
{
	MD5_CTX ctx;
	std::string md5_string;
	unsigned char md[16] = { 0 };
	char tmp[33] = { 0 };
	MD5_Init(&ctx);
	MD5_Update(&ctx, src.c_str(), src.size());
	MD5_Final(md, &ctx);
	for (int i = 0; i < 16; ++i)
	{
		memset(tmp, 0x00, sizeof(tmp));
		sprintf(tmp, "%02X", md[i]);
		md5_string += tmp;
	}
	return md5_string;
}

std::string JWTUtil::generateTokenByHmac(PayloadDTO payloadDto, std::string secretStr)
{	
	//1 ����JWTͷ������ǩ���㷨������
	jwt_header hdr = jwt_header{ jwt::algorithm::HS256 };
	//2 ��������Ϣ��װ��Payload��
	jwt::jwt_payload jp;
	jp.add_claim("data", nlohmann::json(payloadDto));
	jp.add_claim("exp", std::chrono::system_clock::now() + std::chrono::seconds{ payloadDto.getExp() });
	//3 ����HMACǩ����
	jwt::jwt_signature sgn{ md5(secretStr) };
	std::error_code ec{};
	//4 ����token
	auto res = sgn.encode(hdr, jp, ec);
	return res;
}

PayloadDTO JWTUtil::verifyTokenByHmac(std::string token, std::string secretStr)
{
	PayloadDTO p;
	using namespace jwt::params;
	try {
		jwt_object dec_obj = jwt::decode(token, algorithms({ "HS256" }), secret(md5(secretStr)), verify(true));
		nlohmann::json json = dec_obj.payload().get_claim_value<nlohmann::json>("data");
		p = json.get<PayloadDTO>();
	}
	JU_VERIFY_CATCH(p);
	return p;
}

std::string JWTUtil::generateTokenByRsa(PayloadDTO payloadDto, std::string rsaPriKey)
{
	jwt::jwt_object obj;
	obj.secret(rsaPriKey);
	obj.header().algo(jwt::algorithm::RS256);
	obj.add_claim("authorities", payloadDto.getAuthorities());
	obj.add_claim("user_name", payloadDto.getUsername());
	obj.add_claim("id", payloadDto.getId());
	obj.add_claim("exp", std::chrono::system_clock::now() + std::chrono::seconds{ payloadDto.getExp() });
	return obj.signature();
}

PayloadDTO JWTUtil::verifyTokenByRsa(std::string token, std::string rsaPubKey)
{
	PayloadDTO p;
	using namespace jwt::params;
	try {
		jwt_object dec_obj = jwt::decode(token, algorithms({ "RS256" }), secret(rsaPubKey), verify(true));
		auto payload = dec_obj.payload();
		auto _payload = payload.create_json_obj();
		if (_payload.contains("authorities"))
		{
			p.setAuthorities(payload.get_claim_value<std::list<std::string>>("authorities"));
		}
		p.setExp(payload.get_claim_value<long>("exp"));
		p.setUsername(payload.get_claim_value<std::string>("user_name"));
		if (_payload["id"].is_number()) {
			p.setId(std::to_string(_payload["id"].get<long>()));
		}
		else
		{
			p.setId(_payload["id"].get<std::string>());
		}
	}
	JU_VERIFY_CATCH(p);
	return p;
}
