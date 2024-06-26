#ifndef _MACROS_
#define _MACROS_

/** 定义受保护的变量，并提供get、set方法 */
#define CC_SYNTHESIZE(varType, varName, funName)\
protected: varType varName;\
public: varType get##funName(void) const { return varName; }\
public: void set##funName(varType var){	varName = var; }

/** 定义受保护的变量，并提供get方法 */
#define CC_SYNTHESIZE_GET(varType, varName, funName)\
protected: varType varName;\
public: varType get##funName(void) const { return varName; }

/** 定义受保护的变量，并提供set方法 */
#define CC_SYNTHESIZE_SET(varType, varName, funName)\
protected: varType varName;\
public: void set##funName(varType var){	varName = var; }

/** 定义受保护集合的变量，并提供get方法，返回集合引用 */
#define CC_SYNTHESIZE_CR_GET(varType, varName, funName)\
protected: varType varName;\
public: varType& get##funName(void) { return varName; }\

/** 定义受保护的变量，并提供虚get、set方法 */
#define CC_SYNTHESIZE_VIRTUAL(varType, varName, funName)\
protected: varType varName;\
public: virtual varType get##funName(void) const { return varName; }\
public: virtual void set##funName(varType var){ varName = var; }

/** 定义受保护的变量，并提供虚get方法 */
#define CC_SYNTHESIZE_VIRTUAL_GET(varType, varName, funName)\
protected: varType varName;\
public: virtual varType get##funName(void) const { return varName; }

/** 定义受保护的变量，并提供虚set方法 */
#define CC_SYNTHESIZE_VIRTUAL_SET(varType, varName, funName)\
protected: varType varName;\
public: virtual void set##funName(varType var){ varName = var; }

/** 定义受保护的集合变量，并提供虚get方法，返回集合引用 */
#define CC_SYNTHESIZE_VIRTUAL_CR_GET(varType, varName, funName)\
protected: varType varName;\
public: virtual varType& get##funName(void) { return varName; }

/** 禁止赋值运算符/拷贝构造/无参构造 */
#define SINGLETON_HEPLER(TypeName) \
private: \
TypeName() {/*std::cout << #TypeName << std::endl;*/}; \
TypeName(const TypeName&) = delete; \
TypeName& operator=(const TypeName&) = delete;

/** 定义单例模式 */
#define DECLARE_INSTANCE(TypeName) \
SINGLETON_HEPLER(TypeName) \
public: \
	static TypeName& getInstance() \
	{ \
		static TypeName instance; \
		return instance; \
	} 

#endif // !_MACROS_