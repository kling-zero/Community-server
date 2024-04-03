# CMakeList.txt: mysql-lib 的 CMake 项目，在此处包括源代码并定义
# 项目特定的逻辑。
#
cmake_minimum_required (VERSION 3.8)

# 包含库目录
include_directories ("./")
include_directories ("include")

# 编译动态库
file (GLOB_RECURSE SC_FILES src/*.cpp)
add_library (mysql-lib STATIC ${SC_FILES})

# 静态库输出名修改
set_target_properties (mysql-lib PROPERTIES OUTPUT_NAME mysql)
# 防止同名库被删除
set_target_properties (mysql-lib PROPERTIES CLEAN_DIRECT_OUTPUT 1)

# 安装库
install (TARGETS mysql-lib ARCHIVE DESTINATION libstatic)
install (DIRECTORY include/ DESTINATION include/mysql-lib)
