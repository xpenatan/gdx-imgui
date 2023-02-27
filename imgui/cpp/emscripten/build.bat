cmake -G "MinGW Makefiles" -B ../build/emscripten/
cmake --build ../build/emscripten/ -- VERBOSE=1
XCOPY ..\build\emscripten\imgui.js ..\..\..\core\imgui-teavm\src\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.js ..\..\..\core\imgui-teavm\src\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.wasm ..\..\..\core\imgui-teavm\src\main\resources\ /y