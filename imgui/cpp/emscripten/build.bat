cmake -G "MinGW Makefiles" -B ../build/emscripten/
cmake --build ../build/emscripten/ -- VERBOSE=1
XCOPY ..\build\emscripten\imgui.js ..\..\..\imgui\core\core-teavm\src\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.js ..\..\..\imgui\core\core-teavm\src\main\resources\ /y
XCOPY ..\build\emscripten\imgui.wasm.wasm ..\..\..\imgui\core\core-teavm\src\main\resources\ /y