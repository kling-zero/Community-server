#ifndef _JWT_UTIL_
#define _JWT_UTIL_
#include "jwt/jwt.hpp"
#include <openssl/md5.h>
#include <list>
using namespace jwt;

/**
 * 负载信息获取状态编码
 */
enum class PayloadCode
{
	// 信息验证处理成功
	SUCCESS,
	// Token已过期
	TOKEN_EXPIRED_ERROR,
	// 签名格式错误
	SIGNATUREFORMAT_ERROR,
	// 解密错误
	DECODE_ERROR,
	// 验证错误
	VERIFICATION_ERROR,
	// 其他错误
	OTHER_ERROR
};

/**
 * 负载信息实体类
 */
class PayloadDTO
{
private:
	// 主体数据
	std::string sub;
	// 凭证有效时长（秒）
	long exp;
	// 用户编号
	std::string id;
	// 用户名
	std::string username;
	// 用户拥有的权限
	std::list<std::string> authorities;
	// 数据状态系信息
	PayloadCode code;
public:
	PayloadDTO();
	PayloadDTO(std::string _sub, long _exp, std::string _username, std::list<std::string> _authorities);
	
	// getter/setter
	std::string getSub() const { return sub; }
	void setSub(std::string val) { sub = val; }
	long getExp() const { return exp; }
	void setExp(long val) { exp = val; }
	std::string getUsername() const { return username; }
	void setUsername(std::string val) { username = val; }
	std::list<std::string>& getAuthorities() { return authorities; }
	void setAuthorities(std::list<std::string> val) { authorities = val; }
	PayloadCode getCode() const { return code; }
	void setCode(PayloadCode val) { code = val; }
	std::string getId() const { return id; }
	void setId(std::string val) { id = val; }

	// 绑定JSON转换方法
	NLOHMANN_DEFINE_TYPE_INTRUSIVE(PayloadDTO, id, username, authorities);
	
};

/**
 * JWT工具类
 */
class JWTUtil
{
private:
	//对字符串进行MD5处理
	static std::string md5(const std::string& src);
public:
	//************************************
	// Method:    generateTokenByHmac
	// FullName:  JWTUtil::generateTokenByHmac
	// Access:    public static 
	// Returns:   std::string 返回Token字符串
	// Qualifier: 使用HMAC算法构建Token
	// Parameter: PayloadDTO payloadDto 负载信息对象
	// Parameter: std::string secretStr 秘钥
	//************************************
	static std::string generateTokenByHmac(PayloadDTO payloadDto, std::string secretStr);
	//************************************
	// Method:    verifyTokenByHmac
	// FullName:  JWTUtil::verifyTokenByHmac
	// Access:    public static 
	// Returns:   PayloadDTO 负载信息对象
	// Qualifier: 验证HMAC Token
	// Parameter: std::string token Token字符串
	// Parameter: std::string secretStr 秘钥
	//************************************
	static PayloadDTO verifyTokenByHmac(std::string token, std::string secretStr);
	//************************************
	// Method:    generateTokenByRsa
	// FullName:  JWTUtil::generateTokenByRsa
	// Access:    public static 
	// Returns:   std::string
	// Qualifier: 使用RSA Pem生成Token，密钥对在线生成工具：http://www.metools.info/code/c80.html
	// Parameter: PayloadDTO payloadDto 负载信息
	// Parameter: std::string rsaPriKey RSA私钥
	//************************************
	static std::string generateTokenByRsa(PayloadDTO payloadDto, std::string rsaPriKey);
	//************************************
	// Method:    verifyTokenByRsa
	// FullName:  JWTUtil::verifyTokenByRsa
	// Access:    public static 
	// Returns:   PayloadDTO
	// Qualifier: 验证RSA Pem Token
	// Parameter: std::string token Token字符串
	// Parameter: std::string rsaPubKey RSA公钥
	//************************************
	static PayloadDTO verifyTokenByRsa(std::string token, std::string rsaPubKey);
};

#endif // !_JWT_UTIL_
