#ifndef _JWT_UTIL_
#define _JWT_UTIL_
#include "jwt/jwt.hpp"
#include <openssl/md5.h>
#include <list>
using namespace jwt;

/**
 * ������Ϣ��ȡ״̬����
 */
enum class PayloadCode
{
	// ��Ϣ��֤����ɹ�
	SUCCESS,
	// Token�ѹ���
	TOKEN_EXPIRED_ERROR,
	// ǩ����ʽ����
	SIGNATUREFORMAT_ERROR,
	// ���ܴ���
	DECODE_ERROR,
	// ��֤����
	VERIFICATION_ERROR,
	// ��������
	OTHER_ERROR
};

/**
 * ������Ϣʵ����
 */
class PayloadDTO
{
private:
	// ��������
	std::string sub;
	// ƾ֤��Чʱ�����룩
	long exp;
	// �û����
	std::string id;
	// �û���
	std::string username;
	// �û�ӵ�е�Ȩ��
	std::list<std::string> authorities;
	// ����״̬ϵ��Ϣ
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

	// ��JSONת������
	NLOHMANN_DEFINE_TYPE_INTRUSIVE(PayloadDTO, id, username, authorities);
	
};

/**
 * JWT������
 */
class JWTUtil
{
private:
	//���ַ�������MD5����
	static std::string md5(const std::string& src);
public:
	//************************************
	// Method:    generateTokenByHmac
	// FullName:  JWTUtil::generateTokenByHmac
	// Access:    public static 
	// Returns:   std::string ����Token�ַ���
	// Qualifier: ʹ��HMAC�㷨����Token
	// Parameter: PayloadDTO payloadDto ������Ϣ����
	// Parameter: std::string secretStr ��Կ
	//************************************
	static std::string generateTokenByHmac(PayloadDTO payloadDto, std::string secretStr);
	//************************************
	// Method:    verifyTokenByHmac
	// FullName:  JWTUtil::verifyTokenByHmac
	// Access:    public static 
	// Returns:   PayloadDTO ������Ϣ����
	// Qualifier: ��֤HMAC Token
	// Parameter: std::string token Token�ַ���
	// Parameter: std::string secretStr ��Կ
	//************************************
	static PayloadDTO verifyTokenByHmac(std::string token, std::string secretStr);
	//************************************
	// Method:    generateTokenByRsa
	// FullName:  JWTUtil::generateTokenByRsa
	// Access:    public static 
	// Returns:   std::string
	// Qualifier: ʹ��RSA Pem����Token����Կ���������ɹ��ߣ�http://www.metools.info/code/c80.html
	// Parameter: PayloadDTO payloadDto ������Ϣ
	// Parameter: std::string rsaPriKey RSA˽Կ
	//************************************
	static std::string generateTokenByRsa(PayloadDTO payloadDto, std::string rsaPriKey);
	//************************************
	// Method:    verifyTokenByRsa
	// FullName:  JWTUtil::verifyTokenByRsa
	// Access:    public static 
	// Returns:   PayloadDTO
	// Qualifier: ��֤RSA Pem Token
	// Parameter: std::string token Token�ַ���
	// Parameter: std::string rsaPubKey RSA��Կ
	//************************************
	static PayloadDTO verifyTokenByRsa(std::string token, std::string rsaPubKey);
};

#endif // !_JWT_UTIL_
