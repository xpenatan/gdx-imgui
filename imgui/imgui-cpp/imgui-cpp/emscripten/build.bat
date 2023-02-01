cmake -G "MinGW Makefiles" -B ../build/emscripten/
cmake --build ../build/emscripten/ -- VERBOSE=1
XCOPY ..\build\emscripten\imgui.js ..\..\..\imgui-core\src\imgui-core-teavm\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.js ..\..\..\imgui-core\imgui-core-teavm\src\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.wasm ..\..\..\imgui-core\imgui-core-teavm\src\main\resources\ /y