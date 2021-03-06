# 用于构建CMake项目CMake最低版本
cmake_minimum_required(VERSION 3.10)

# 项目名称，LANGUAGES 项目用于，这里CXX代表使用C++语言
project(QTAPP VERSION 0.1 LANGUAGES CXX)

# 自动添加当前源码和编译路径到头文件路径
set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON) # 转换 UI 文件
set(CMAKE_AUTOMOC ON) # 转换 MOC 文件
set(CMAKE_AUTORCC ON) # 转换资源文件

# 使用C++版本
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON) # 为 ON 时必须指明C++版本

# 查找包
find_package(QT NAMES Qt6 COMPONENTS Widgets Sql REQUIRED)
find_package(Qt${QT_VERSION_MAJOR} COMPONENTS Widgets Sql REQUIRED)

set(MAIN_SOURCES main.cpp widget.cpp widget.h widget.ui)

# 编译为可执行文件
add_executable(QTAPP ${MAIN_SOURCES})

# 项目依赖库
target_link_libraries(QTAPP PRIVATE Qt${QT_VERSION_MAJOR}::Widgets Qt${QT_VERSION_MAJOR}::Sql)
