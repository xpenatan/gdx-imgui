cmake_minimum_required(VERSION 3.13 FATAL_ERROR)
set(CMAKE_POLICY_DEFAULT_CMP0077 NEW)

FIND_PACKAGE(Python3)
set(PYTHON ${Python3_EXECUTABLE} CACHE STRING "Python path")
set(EMSCRIPTEN_ROOT $ENV{EMSDK}/upstream/emscripten CACHE STRING "Emscripten path")
set(CMAKE_TOOLCHAIN_FILE ${EMSCRIPTEN_ROOT}/cmake/Modules/Platform/Emscripten.cmake)
set(WEBIDL_BINDER_SCRIPT ${EMSCRIPTEN_ROOT}/tools/webidl_binder.py)
set(IMGUI_HEADER_FILE ${CMAKE_CURRENT_SOURCE_DIR}/imgui_lib.h)
set(IMGUI_IDL_FILE ${CMAKE_CURRENT_SOURCE_DIR}/imgui.idl)
set(IMGUI_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../build/imgui)

SET(IMGUI_SRCS
    ../build/imgui/imgui.cpp
    ../build/imgui/imgui_draw.cpp
    ../build/imgui/imgui_tables.cpp
    ../build/imgui/imgui_widgets.cpp
)

SET(IMGUI_HDRS
    ../build/imgui/imconfig.h
    ../build/imgui/imgui.h
    ../build/imgui/imgui_internal.h
)

ADD_LIBRARY(IMGUI ${IMGUI_SRCS} ${IMGUI_HDRS})

set(IMGUI_TARGETS IMGUI)
foreach(_TARGET ${IMGUI_TARGETS})
  list(APPEND IMGUI_LIBS $<TARGET_FILE:${_TARGET}>)
endforeach()

# Build Release by default
set(CMAKE_BUILD_TYPE Release CACHE STRING "Build Type")

# Default is 64*1024*1024 = 64MB
set(INITIAL_MEMORY 67108864 CACHE STRING "Total Memory")

# Enable for resizable heap, with some amount of slowness
set(ALLOW_MEMORY_GROWTH 0 CACHE STRING "Allow Memory Growth")

set(EMCC_ARGS
  -O3
  -g0 -Wall
  --llvm-lto 1
  --post-js glue.js
  --extern-post-js ${CMAKE_CURRENT_SOURCE_DIR}/post.js
  --closure 1
  -s ALLOW_MEMORY_GROWTH=${ALLOW_MEMORY_GROWTH}
  -s ALLOW_TABLE_GROWTH=1
  -s EXPORT_NAME="ImGui"
  -s MODULARIZE=1
  -s NO_FILESYSTEM=1
  -s INITIAL_MEMORY=${INITIAL_MEMORY}
  -s EXPORTED_FUNCTIONS=["_free","_malloc"]
  -s EXPORTED_RUNTIME_METHODS=["UTF8ToString"]
)

#set(EMCC_JS_ARGS ${EMCC_ARGS}
#  -s AGGRESSIVE_VARIABLE_ELIMINATION=1
#  -s ELIMINATE_DUPLICATE_FUNCTIONS=1
#  -s SINGLE_FILE=1
#  -s WASM=0
#)

set(EMCC_WASM_ARGS ${EMCC_ARGS}
  -s BINARYEN_IGNORE_IMPLICIT_TRAPS=1
  -s WASM=1
)

set(EMCC_GLUE_ARGS
  -c
  -I${IMGUI_SRC_DIR}
  -include ${CMAKE_CURRENT_SOURCE_DIR}/custom_glue.cpp
  -include${IMGUI_HEADER_FILE}
)

#######################################
project("imgui")

#######################################
add_custom_command(
  OUTPUT glue.cpp glue.js
  BYPRODUCTS parser.out WebIDLGrammar.pkl
  COMMAND ${PYTHON} ${WEBIDL_BINDER_SCRIPT} ${IMGUI_IDL_FILE} glue
  DEPENDS ${IMGUI_IDL_FILE}
  COMMENT "Generating ImGui bindings"
  VERBATIM
)
add_custom_command(
  OUTPUT glue.o
  COMMAND em++ glue.cpp ${EMCC_GLUE_ARGS} -o glue.o
  DEPENDS glue.cpp ${IMGUI_HEADER_FILE}
  COMMENT "Building ImGui bindings"
  VERBATIM
)
add_custom_target(imgui-bindings ALL DEPENDS glue.js glue.o)

#######################################
add_custom_command(
  OUTPUT imgui.wasm.js imgui.wasm.wasm
  COMMAND emcc glue.o ${IMGUI_LIBS} ${EMCC_WASM_ARGS} -o imgui.wasm.js
  DEPENDS imgui-bindings ${IMGUI_TARGETS}
  COMMENT "Building ImGui webassembly"
  VERBATIM
)
add_custom_target(imgui-wasm ALL DEPENDS imgui.wasm.js imgui.wasm.wasm)
