#ifndef _API_HELPER_
#define _API_HELPER_

#include "cinatra.hpp"
#include "JWTUtil.h"
using namespace cinatra;
using namespace nlohmann;
using namespace std;

/** ���������־���� */
#define LOG(data) std::cout << data << std::endl

/** ����API������ͷ */
#define API_FUN_BEGIN(__FUN_NAME__) \
void __FUN_NAME__(request& req, response& res) \
{

/** ����API�������� */
#define API_FUN_END \
	res.render_json(data); \
}

/** ����ִ�з������ú� */
#define API_EXEC_FUN(__EXEC_FUN__) \
nlohmann::json data = nlohmann::json(__EXEC_FUN__(query));

/** ����ִ�з������ú꣨���ϴ������� */
#define API_EXEC_FUN1(__EXEC_FUN__) \
nlohmann::json data = nlohmann::json(__EXEC_FUN__());

/** ����ִ�и�����Ϣ�������ú� */
#define API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
PayloadDTO payload = req.getUserPayload().get<PayloadDTO>(); \
nlohmann::json data = nlohmann::json(__EXEC_FUN__(query, payload));

/** ����ִ�и�����Ϣ�������ú꣨���ϴ������� */
#define API_EXEC_FUN_PAYLOAD1(__EXEC_FUN__) \
PayloadDTO payload = req.getUserPayload().get<PayloadDTO>(); \
nlohmann::json data = nlohmann::json(__EXEC_FUN__(payload));

#pragma region ��ѯ��

#define API_QUERY_PARAM(__DATA_TYPE__) \
auto queries = req.queries(); \
nlohmann::json j; \
for (auto one : queries) { \
	j[one.first] = one.second; \
} \
__DATA_TYPE__ query = j.get<__DATA_TYPE__>();

/** ����һ������/*�������ֵ�ĺ� */
#define API_QUERY_VALUES \
std::vector<std::string_view> query = req.get_query_values();

/** ����һ������/*�������ֵ�ĺֻ꣨��ȡһ�������� */
#define API_QUERY_VALUES1 \
std::string_view query = req.get_query_value(0);

/** ����API�����궨��,���ղ�ѯ�����ݣ�����ͳһ�·�JSON����*/
#define CREATE_API_FUN_QUERY(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����/*��Ĳ�ѯ����������ͳһ�·�JSON���� */
#define CREATE_API_FUN_QUERY1(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_VALUES \
	API_EXEC_FUN(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����/*��Ĳ�ѯ������ֻ��ȡһ��������������ͳһ�·�JSON���� */
#define CREATE_API_FUN_QUERY2(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_VALUES1 \
	API_EXEC_FUN(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,���ϴ�����������ͳһ�·�JSON���� */
#define CREATE_API_FUN_QUERY3(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_EXEC_FUN1(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,���ղ�ѯ�������븺�����ݣ�����ͳһ�·�JSON����*/
#define CREATE_API_FUN_QUERY_PAYLOAD(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����/*��Ĳ�ѯ�����븺�����ݣ�����ͳһ�·�JSON����*/
#define CREATE_API_FUN_QUERY_PAYLOAD1(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_VALUES \
	API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����/*��Ĳ�ѯ������ֻ��ȡһ���������븺�����ݣ�����ͳһ�·�JSON����*/
#define CREATE_API_FUN_QUERY_PAYLOAD2(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_QUERY_VALUES1 \
	API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,�����ո������ݣ�����ͳһ�·�JSON����*/
#define CREATE_API_FUN_QUERY_PAYLOAD3(__FUN_NAME__, __EXEC_FUN__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_EXEC_FUN_PAYLOAD1(__EXEC_FUN__) \
API_FUN_END

#pragma endregion

#pragma region BODY��

#define API_BODY_PARAM(__DATA_TYPE__) \
auto bodys = req.parse_query(req.body()); \
nlohmann::json j; \
for (auto one : bodys) { \
	j[one.first] = one.second; \
} \
if (req.queries().size()) { \
	nlohmann::json jq; \
	auto queries = req.queries(); \
	for (auto one : queries) { \
		jq[one.first] = one.second; \
	} \
	j.merge_patch(jq); \
} \
__DATA_TYPE__ query = j.get<__DATA_TYPE__>(); 

/** ����API�����궨��,����BODY�����ݣ�����ͳһ�·�JSON���� */
#define CREATE_API_FUN_BODY(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_BODY_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����BODY�����ݺ͸������ݣ�����ͳһ�·�JSON���� */
#define CREATE_API_FUN_BODY_PAYLOAD(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_BODY_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
API_FUN_END

#pragma endregion

#pragma region BODYJSON

#define API_BODY_JSON_PARAM(__DATA_TYPE__) \
nlohmann::json json = nlohmann::json::parse(req.body()); \
__DATA_TYPE__ query = json.get<__DATA_TYPE__>();

/** ����API�����궨��,����JSON�������ݣ�����ͳһ�·�JSON���� */
#define CREATE_API_FUN_JSON(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_BODY_JSON_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN(__EXEC_FUN__) \
API_FUN_END

/** ����API�����궨��,����JSON�������ݺ͸������ݣ�����ͳһ�·�JSON���� */
#define CREATE_API_FUN_JSON_PAYLOAD(__FUN_NAME__, __EXEC_FUN__, __DATA_TYPE__) \
API_FUN_BEGIN(__FUN_NAME__) \
	API_BODY_JSON_PARAM(__DATA_TYPE__) \
	API_EXEC_FUN_PAYLOAD(__EXEC_FUN__) \
API_FUN_END

#pragma endregion

/** ��·�ɺ궨�� */
#define BIND_GET_ROUTER(__SERVER__, __PATH__, __FUN_NAME__, ...) \
__SERVER__->set_http_handler<GET, OPTIONS>(__PATH__, __FUN_NAME__, CROS(), Check(), __VA_ARGS__);

#define BIND_POST_ROUTER(__SERVER__,__PATH__, __FUN_NAME__, ...) \
__SERVER__->set_http_handler<POST, OPTIONS>(__PATH__, __FUN_NAME__, CROS(), Check(), __VA_ARGS__);

#define BIND_PUT_ROUTER(__SERVER__,__PATH__, __FUN_NAME__, ...) \
__SERVER__->set_http_handler<PUT, OPTIONS>(__PATH__, __FUN_NAME__, CROS(), Check(), __VA_ARGS__);

#define BIND_DEL_ROUTER(__SERVER__,__PATH__, __FUN_NAME__, ...) \
__SERVER__->set_http_handler<DEL, OPTIONS>(__PATH__, __FUN_NAME__, CROS(), Check(), __VA_ARGS__);

/** JSON�󶨺������� */
#define BIND_TO_JSON(Type, ...)  \
friend void to_json(nlohmann::json& nlohmann_json_j, const Type& nlohmann_json_t) { NLOHMANN_JSON_EXPAND(NLOHMANN_JSON_PASTE(NLOHMANN_JSON_TO, __VA_ARGS__)) } 
#define BIND_FROM_JSON(Type, ...) \
friend void from_json(const nlohmann::json& nlohmann_json_j, Type& nlohmann_json_t) { NLOHMANN_JSON_EXPAND(NLOHMANN_JSON_PASTE(NLOHMANN_JSON_FROM, __VA_ARGS__)) }

/** JSON�ֶ�ת���������ֶκ궨�� */
#define BIND_FROM_TO_NORMAL(nlohmann_json_j, nlohmann_json_t, field) \
if(nlohmann_json_j.contains(#field)) { \
	nlohmann::json jf = nlohmann_json_j.at(#field); \
	if(jf.is_string()) { \
		nlohmann_json_t.field = code_utils::url_decode(jf.get<string>()); \
	} \
	else { \
		jf.get_to(nlohmann_json_t.field); \
	} \
}
#define BIND_FROM_TO_B(nlohmann_json_j, nlohmann_json_t, field) \
if(nlohmann_json_j.contains(#field)) { \
	nlohmann::json jf = nlohmann_json_j.at(#field); \
	if (jf.is_string()) { \
		std::string s = jf.get<string>(); \
		if (s == "true" || s == "1") nlohmann_json_t.field = true; \
		else nlohmann_json_t.field = false; \
	} \
	else { \
		jf.get_to(nlohmann_json_t.field); \
	} \
}
#define BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, toFun) \
if(nlohmann_json_j.contains(#field)) {\
	nlohmann::json jf = nlohmann_json_j.at(#field); \
	if(jf.is_string()) { \
		nlohmann_json_t.field = toFun(jf.get<string>()); \
	} \
	else { \
		jf.get_to(nlohmann_json_t.field); \
	} \
}
#define BIND_FROM_TO_I(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stoi)
#define BIND_FROM_TO_L(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stol)
#define BIND_FROM_TO_UL(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stoul)
#define BIND_FROM_TO_LL(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stoll)
#define BIND_FROM_TO_ULL(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stoull)
#define BIND_FROM_TO_F(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stof)
#define BIND_FROM_TO_D(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stod)
#define BIND_FROM_TO_LD(nlohmann_json_j, nlohmann_json_t, field) BIND_FROM_TO(nlohmann_json_j, nlohmann_json_t, field, stold)
#define BIND_FROM_TO_OBJ(nlohmann_json_j, nlohmann_json_t, field, __DATA_TYPE__) \
if(nlohmann_json_j.contains(#field)) { \
	nlohmann::json jf = nlohmann_json_j.at(#field); \
	__DATA_TYPE__ obj = jf.get<__DATA_TYPE__>(); \
	nlohmann_json_t.field = obj; \
}
#endif // !_API_HELPER_