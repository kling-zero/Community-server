﻿# CMakeList.txt: http-server-demo-mk 的 CMake 项目，在此处包括源代码并定义
# 项目特定的逻辑。
#
cmake_minimum_required (VERSION 3.8)


# 设置文件名称
set (appName property-manage)

# 包含库目录
include_directories ("./")
include_directories ("../http-lib/include")
include_directories ("../mysql-lib/include")
include_directories ("../common-lib/include")

# 链接库路径，程序运行的时候也在这里找
link_directories (${PROJECT_BINARY_DIR}/http-lib)
link_directories (${PROJECT_BINARY_DIR}/mysql-lib)
link_directories (${PROJECT_BINARY_DIR}/common-lib)
link_directories (${PROJECT_SOURCE_DIR}/common-lib/lib64)
link_directories (${PROJECT_SOURCE_DIR}/dy-lib/lib64)

# 将源代码添加到此项目的可执行文件
file (GLOB_RECURSE SC_FILES ./*.cpp)

# 编译可执行文件
add_executable (${appName} ${SC_FILES})

# 链接库
target_link_libraries (${appName} "common-lib" "http-lib" "mysql-lib")

# 链接其他库依赖库，如：你要链接libuuid直接写成uuid
target_link_libraries (${appName} uuid pthread stdc++fs OpenSSL::SSL )
target_link_libraries (${appName} mysqlcppconn )
# 链接xlnt
if(USE_XLNT)
	target_link_libraries (${appName} xlnt )
	message (STATUS "${appName}: link xlnt lib")
endif()
# 链接fastdfs
if(USE_DFS)
	target_link_libraries (${appName} fdfsclient fastcommon )
	message (STATUS "${appName}: link fdfsclient lib")
endif()
# 链接ymal
if(USE_YML)
	target_link_libraries (${appName} yaml-cpp )
	message (STATUS "${appName}: link yamlcpp lib")
endif()
# 链接nacos
if(USE_NACOS)
	target_link_libraries (${appName} nacos-cli )
	message (STATUS "${appName}: link nacos lib")
endif()
# 链接redis
if(USE_REDIS)
	target_link_libraries (${appName} redis++ hiredis )
	message (STATUS "${appName}: link redis lib")
endif()
# 链接Kafka
if(USE_KAFKA)
	target_link_libraries (${appName} rdkafka++ rdkafka )
	message (STATUS "${appName}: link kakfa lib")
endif()
# 链接RocketMQ
if(USE_ROCKETMQ)
	target_link_libraries (${appName} rocketmq )
	message (STATUS "${appName}: link rocketmq lib")
endif()

# 复制配置到调试时可执行文件所在的目录
# RSA公钥证书
file (COPY "public.pem" DESTINATION ${PROJECT_BINARY_DIR}/${appName})
# FastDFS配置文件
file (GLOB fdfsConf "../common-lib/include/fastdfs/conf/*")
file (COPY ${fdfsConf} DESTINATION ${PROJECT_BINARY_DIR}/${appName}/conf)

# 安装文件
# 可执行文件
install (TARGETS ${appName} RUNTIME DESTINATION ${appName})
# RSA公钥证书
install (FILES "public.pem" DESTINATION ${appName})
# FastDFS配置文件
install (DIRECTORY "${PROJECT_SOURCE_DIR}/common-lib/include/fastdfs/conf" DESTINATION ${appName})
# 第三方动态链接库
install (DIRECTORY "${PROJECT_SOURCE_DIR}/dy-lib/lib64/" DESTINATION lib FILES_MATCHING PATTERN "*.so*")
# 启动脚本
install (PROGRAMS ${PROJECT_SOURCE_DIR}/run-front.sh ${PROJECT_SOURCE_DIR}/run-back.sh DESTINATION ${appName})