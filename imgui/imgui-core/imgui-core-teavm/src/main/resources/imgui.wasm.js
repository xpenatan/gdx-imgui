
var ImGui = (() => {
  var _scriptDir = typeof document !== 'undefined' && document.currentScript ? document.currentScript.src : undefined;
  if (typeof __filename !== 'undefined') _scriptDir = _scriptDir || __filename;
  return (
function(ImGui = {})  {

// include: shell.js
// The Module object: Our interface to the outside world. We import
// and export values on it. There are various ways Module can be used:
// 1. Not defined. We create it here
// 2. A function parameter, function(Module) { ..generated code.. }
// 3. pre-run appended it, var Module = {}; ..generated code..
// 4. External script tag defines var Module.
// We need to check if Module already exists (e.g. case 3 above).
// Substitution will be replaced with actual code on later stage of the build,
// this way Closure Compiler will not mangle it (e.g. case 4. above).
// Note that if you want to run closure, and also to use Module
// after the generated code, you will need to define   var Module = {};
// before the code. Then that object will be used in the code, and you
// can continue to use Module afterwards as well.
var Module = typeof ImGui != 'undefined' ? ImGui : {};

// Set up the promise that indicates the Module is initialized
var readyPromiseResolve, readyPromiseReject;
Module['ready'] = new Promise(function(resolve, reject) {
  readyPromiseResolve = resolve;
  readyPromiseReject = reject;
});
["_free","_malloc","_emscripten_bind_VoidPtr___destroy___0","_emscripten_bind_BoolArray_BoolArray_1","_emscripten_bind_BoolArray_resize_1","_emscripten_bind_BoolArray_getValue_1","_emscripten_bind_BoolArray_setValue_2","_emscripten_bind_BoolArray_getPointer_0","_emscripten_bind_BoolArray_get_size_0","_emscripten_bind_BoolArray_set_size_1","_emscripten_bind_BoolArray___destroy___0","_emscripten_bind_IntArray_IntArray_1","_emscripten_bind_IntArray_resize_1","_emscripten_bind_IntArray_getValue_1","_emscripten_bind_IntArray_setValue_2","_emscripten_bind_IntArray_getPointer_0","_emscripten_bind_IntArray_get_size_0","_emscripten_bind_IntArray_set_size_1","_emscripten_bind_IntArray___destroy___0","_emscripten_bind_FloatArray_FloatArray_1","_emscripten_bind_FloatArray_resize_1","_emscripten_bind_FloatArray_getValue_1","_emscripten_bind_FloatArray_setValue_2","_emscripten_bind_FloatArray_getPointer_0","_emscripten_bind_FloatArray_get_size_0","_emscripten_bind_FloatArray_set_size_1","_emscripten_bind_FloatArray___destroy___0","_emscripten_bind_DoubleArray_DoubleArray_1","_emscripten_bind_DoubleArray_resize_1","_emscripten_bind_DoubleArray_getValue_1","_emscripten_bind_DoubleArray_setValue_2","_emscripten_bind_DoubleArray_getPointer_0","_emscripten_bind_DoubleArray_get_size_0","_emscripten_bind_DoubleArray_set_size_1","_emscripten_bind_DoubleArray___destroy___0","_emscripten_bind_CharArray_CharArray_1","_emscripten_bind_CharArray_resize_1","_emscripten_bind_CharArray_getValue_1","_emscripten_bind_CharArray_setValue_2","_emscripten_bind_CharArray_getPointer_0","_emscripten_bind_CharArray_get_size_0","_emscripten_bind_CharArray_set_size_1","_emscripten_bind_CharArray___destroy___0","_emscripten_bind_ImHelper_memcpyIdx_3","_emscripten_bind_ImHelper_memcpyVtx_3","_emscripten_bind_ImHelper_memcpyFont_5","_emscripten_bind_ImHelper_getTextureId_1","_emscripten_bind_ImHelper_setIniFilename_2","_emscripten_bind_ImHelper_removeIniFilename_1","_emscripten_bind_ImHelper___destroy___0","_emscripten_bind_Im_CreateContext_0","_emscripten_bind_Im_Begin_1","_emscripten_bind_Im_End_0","_emscripten_bind_Im_Render_0","_emscripten_bind_Im_NewFrame_0","_emscripten_bind_Im_GetDrawData_0","_emscripten_bind_Im_GetIO_0","_emscripten_bind_Im_SetNextWindowSize_1","_emscripten_bind_Im_SetNextWindowSize_2","_emscripten_bind_Im_ShowDemoWindow_0","_emscripten_bind_Im_ShowDemoWindow_1","_emscripten_bind_Im_Checkbox_2","_emscripten_bind_ImVec2_ImVec2_0","_emscripten_bind_ImVec2_ImVec2_2","_emscripten_bind_ImVec2_get_x_0","_emscripten_bind_ImVec2_set_x_1","_emscripten_bind_ImVec2_get_y_0","_emscripten_bind_ImVec2_set_y_1","_emscripten_bind_ImVec2___destroy___0","_emscripten_bind_ImVec4_ImVec4_0","_emscripten_bind_ImVec4_ImVec4_4","_emscripten_bind_ImVec4_get_x_0","_emscripten_bind_ImVec4_set_x_1","_emscripten_bind_ImVec4_get_y_0","_emscripten_bind_ImVec4_set_y_1","_emscripten_bind_ImVec4_get_z_0","_emscripten_bind_ImVec4_set_z_1","_emscripten_bind_ImVec4_get_w_0","_emscripten_bind_ImVec4_set_w_1","_emscripten_bind_ImVec4___destroy___0","_emscripten_bind_VecCmdBuffer_getData_1","_emscripten_bind_VecCmdBuffer_size_0","_emscripten_bind_VecCmdBuffer___destroy___0","_emscripten_bind_VecIdxBuffer_size_0","_emscripten_bind_VecIdxBuffer___destroy___0","_emscripten_bind_VecVtxBuffer_size_0","_emscripten_bind_VecVtxBuffer___destroy___0","_emscripten_bind_ImDrawCmd_get_ClipRect_0","_emscripten_bind_ImDrawCmd_set_ClipRect_1","_emscripten_bind_ImDrawCmd_get_VtxOffset_0","_emscripten_bind_ImDrawCmd_set_VtxOffset_1","_emscripten_bind_ImDrawCmd_get_IdxOffset_0","_emscripten_bind_ImDrawCmd_set_IdxOffset_1","_emscripten_bind_ImDrawCmd_get_ElemCount_0","_emscripten_bind_ImDrawCmd_set_ElemCount_1","_emscripten_bind_ImDrawCmd_get_TextureId_0","_emscripten_bind_ImDrawCmd_set_TextureId_1","_emscripten_bind_ImDrawCmd___destroy___0","_emscripten_bind_ImDrawVert_get_pos_0","_emscripten_bind_ImDrawVert_set_pos_1","_emscripten_bind_ImDrawVert_get_uv_0","_emscripten_bind_ImDrawVert_set_uv_1","_emscripten_bind_ImDrawVert_get_col_0","_emscripten_bind_ImDrawVert_set_col_1","_emscripten_bind_ImDrawVert___destroy___0","_emscripten_bind_ImDrawData_get_CmdListsCount_0","_emscripten_bind_ImDrawData_set_CmdListsCount_1","_emscripten_bind_ImDrawData_get_TotalIdxCount_0","_emscripten_bind_ImDrawData_set_TotalIdxCount_1","_emscripten_bind_ImDrawData_get_TotalVtxCount_0","_emscripten_bind_ImDrawData_set_TotalVtxCount_1","_emscripten_bind_ImDrawData_get_CmdLists_1","_emscripten_bind_ImDrawData_set_CmdLists_2","_emscripten_bind_ImDrawData_get_DisplayPos_0","_emscripten_bind_ImDrawData_set_DisplayPos_1","_emscripten_bind_ImDrawData_get_DisplaySize_0","_emscripten_bind_ImDrawData_set_DisplaySize_1","_emscripten_bind_ImDrawData_get_FramebufferScale_0","_emscripten_bind_ImDrawData_set_FramebufferScale_1","_emscripten_bind_ImDrawData___destroy___0","_emscripten_bind_ImDrawList_get_CmdBuffer_0","_emscripten_bind_ImDrawList_set_CmdBuffer_1","_emscripten_bind_ImDrawList_get_IdxBuffer_0","_emscripten_bind_ImDrawList_set_IdxBuffer_1","_emscripten_bind_ImDrawList_get_VtxBuffer_0","_emscripten_bind_ImDrawList_set_VtxBuffer_1","_emscripten_bind_ImDrawList___destroy___0","_emscripten_bind_ImGuiIO_AddMouseWheelEvent_2","_emscripten_bind_ImGuiIO_AddMouseButtonEvent_2","_emscripten_bind_ImGuiIO_AddMousePosEvent_2","_emscripten_bind_ImGuiIO_AddKeyEvent_2","_emscripten_bind_ImGuiIO_AddInputCharacter_1","_emscripten_bind_ImGuiIO_get_WantCaptureMouse_0","_emscripten_bind_ImGuiIO_set_WantCaptureMouse_1","_emscripten_bind_ImGuiIO_get_DisplaySize_0","_emscripten_bind_ImGuiIO_set_DisplaySize_1","_emscripten_bind_ImGuiIO_get_DisplayFramebufferScale_0","_emscripten_bind_ImGuiIO_set_DisplayFramebufferScale_1","_emscripten_bind_ImGuiIO_get_DeltaTime_0","_emscripten_bind_ImGuiIO_set_DeltaTime_1","_emscripten_bind_ImGuiIO_get_Fonts_0","_emscripten_bind_ImGuiIO_set_Fonts_1","_emscripten_bind_ImGuiIO___destroy___0","_emscripten_bind_ImFontAtlas_get_TexID_0","_emscripten_bind_ImFontAtlas_set_TexID_1","_emscripten_bind_ImFontAtlas___destroy___0","_emscripten_enum_ImGuiKey_ImGuiKey_None","_fflush","onRuntimeInitialized"].forEach((prop) => {
  if (!Object.getOwnPropertyDescriptor(Module['ready'], prop)) {
    Object.defineProperty(Module['ready'], prop, {
      get: () => abort('You are getting ' + prop + ' on the Promise object, instead of the instance. Use .then() to get called back with the instance, see the MODULARIZE docs in src/settings.js'),
      set: () => abort('You are setting ' + prop + ' on the Promise object, instead of the instance. Use .then() to get called back with the instance, see the MODULARIZE docs in src/settings.js'),
    });
  }
});

// --pre-jses are emitted after the Module integration code, so that they can
// refer to Module (if they choose; they can also define Module)


// Sometimes an existing Module object exists with properties
// meant to overwrite the default module functionality. Here
// we collect those properties and reapply _after_ we configure
// the current environment's defaults to avoid having to be so
// defensive during initialization.
var moduleOverrides = Object.assign({}, Module);

var arguments_ = [];
var thisProgram = './this.program';
var quit_ = (status, toThrow) => {
  throw toThrow;
};

// Determine the runtime environment we are in. You can customize this by
// setting the ENVIRONMENT setting at compile time (see settings.js).

// Attempt to auto-detect the environment
var ENVIRONMENT_IS_WEB = typeof window == 'object';
var ENVIRONMENT_IS_WORKER = typeof importScripts == 'function';
// N.b. Electron.js environment is simultaneously a NODE-environment, but
// also a web environment.
var ENVIRONMENT_IS_NODE = typeof process == 'object' && typeof process.versions == 'object' && typeof process.versions.node == 'string';
var ENVIRONMENT_IS_SHELL = !ENVIRONMENT_IS_WEB && !ENVIRONMENT_IS_NODE && !ENVIRONMENT_IS_WORKER;

if (Module['ENVIRONMENT']) {
  throw new Error('Module.ENVIRONMENT has been deprecated. To force the environment, use the ENVIRONMENT compile-time option (for example, -sENVIRONMENT=web or -sENVIRONMENT=node)');
}

// `/` should be present at the end if `scriptDirectory` is not empty
var scriptDirectory = '';
function locateFile(path) {
  if (Module['locateFile']) {
    return Module['locateFile'](path, scriptDirectory);
  }
  return scriptDirectory + path;
}

// Hooks that are implemented differently in different runtime environments.
var read_,
    readAsync,
    readBinary,
    setWindowTitle;

// Normally we don't log exceptions but instead let them bubble out the top
// level where the embedding environment (e.g. the browser) can handle
// them.
// However under v8 and node we sometimes exit the process direcly in which case
// its up to use us to log the exception before exiting.
// If we fix https://github.com/emscripten-core/emscripten/issues/15080
// this may no longer be needed under node.
function logExceptionOnExit(e) {
  if (e instanceof ExitStatus) return;
  let toLog = e;
  if (e && typeof e == 'object' && e.stack) {
    toLog = [e, e.stack];
  }
  err('exiting due to exception: ' + toLog);
}

if (ENVIRONMENT_IS_NODE) {
  if (typeof process == 'undefined' || !process.release || process.release.name !== 'node') throw new Error('not compiled for this environment (did you build to HTML and try to run it not on the web, or set ENVIRONMENT to something - like node - and run it someplace else - like on the web?)');
  // `require()` is no-op in an ESM module, use `createRequire()` to construct
  // the require()` function.  This is only necessary for multi-environment
  // builds, `-sENVIRONMENT=node` emits a static import declaration instead.
  // TODO: Swap all `require()`'s with `import()`'s?
  // These modules will usually be used on Node.js. Load them eagerly to avoid
  // the complexity of lazy-loading.
  var fs = require('fs');
  var nodePath = require('path');

  if (ENVIRONMENT_IS_WORKER) {
    scriptDirectory = nodePath.dirname(scriptDirectory) + '/';
  } else {
    scriptDirectory = __dirname + '/';
  }

// include: node_shell_read.js
read_ = (filename, binary) => {
  // We need to re-wrap `file://` strings to URLs. Normalizing isn't
  // necessary in that case, the path should already be absolute.
  filename = isFileURI(filename) ? new URL(filename) : nodePath.normalize(filename);
  return fs.readFileSync(filename, binary ? undefined : 'utf8');
};

readBinary = (filename) => {
  var ret = read_(filename, true);
  if (!ret.buffer) {
    ret = new Uint8Array(ret);
  }
  assert(ret.buffer);
  return ret;
};

readAsync = (filename, onload, onerror) => {
  // See the comment in the `read_` function.
  filename = isFileURI(filename) ? new URL(filename) : nodePath.normalize(filename);
  fs.readFile(filename, function(err, data) {
    if (err) onerror(err);
    else onload(data.buffer);
  });
};

// end include: node_shell_read.js
  if (process['argv'].length > 1) {
    thisProgram = process['argv'][1].replace(/\\/g, '/');
  }

  arguments_ = process['argv'].slice(2);

  // MODULARIZE will export the module in the proper place outside, we don't need to export here

  process['on']('uncaughtException', function(ex) {
    // suppress ExitStatus exceptions from showing an error
    if (!(ex instanceof ExitStatus)) {
      throw ex;
    }
  });

  // Without this older versions of node (< v15) will log unhandled rejections
  // but return 0, which is not normally the desired behaviour.  This is
  // not be needed with node v15 and about because it is now the default
  // behaviour:
  // See https://nodejs.org/api/cli.html#cli_unhandled_rejections_mode
  var nodeMajor = process.version.match(/^v(\d+)\./)[1];
  if (nodeMajor < 15) {
    process['on']('unhandledRejection', function(reason) { throw reason; });
  }

  quit_ = (status, toThrow) => {
    if (keepRuntimeAlive()) {
      process['exitCode'] = status;
      throw toThrow;
    }
    logExceptionOnExit(toThrow);
    process['exit'](status);
  };

  Module['inspect'] = function () { return '[Emscripten Module object]'; };

} else
if (ENVIRONMENT_IS_SHELL) {

  if ((typeof process == 'object' && typeof require === 'function') || typeof window == 'object' || typeof importScripts == 'function') throw new Error('not compiled for this environment (did you build to HTML and try to run it not on the web, or set ENVIRONMENT to something - like node - and run it someplace else - like on the web?)');

  if (typeof read != 'undefined') {
    read_ = function shell_read(f) {
      return read(f);
    };
  }

  readBinary = function readBinary(f) {
    let data;
    if (typeof readbuffer == 'function') {
      return new Uint8Array(readbuffer(f));
    }
    data = read(f, 'binary');
    assert(typeof data == 'object');
    return data;
  };

  readAsync = function readAsync(f, onload, onerror) {
    setTimeout(() => onload(readBinary(f)), 0);
  };

  if (typeof clearTimeout == 'undefined') {
    globalThis.clearTimeout = (id) => {};
  }

  if (typeof scriptArgs != 'undefined') {
    arguments_ = scriptArgs;
  } else if (typeof arguments != 'undefined') {
    arguments_ = arguments;
  }

  if (typeof quit == 'function') {
    quit_ = (status, toThrow) => {
      logExceptionOnExit(toThrow);
      quit(status);
    };
  }

  if (typeof print != 'undefined') {
    // Prefer to use print/printErr where they exist, as they usually work better.
    if (typeof console == 'undefined') console = /** @type{!Console} */({});
    console.log = /** @type{!function(this:Console, ...*): undefined} */ (print);
    console.warn = console.error = /** @type{!function(this:Console, ...*): undefined} */ (typeof printErr != 'undefined' ? printErr : print);
  }

} else

// Note that this includes Node.js workers when relevant (pthreads is enabled).
// Node.js workers are detected as a combination of ENVIRONMENT_IS_WORKER and
// ENVIRONMENT_IS_NODE.
if (ENVIRONMENT_IS_WEB || ENVIRONMENT_IS_WORKER) {
  if (ENVIRONMENT_IS_WORKER) { // Check worker, not web, since window could be polyfilled
    scriptDirectory = self.location.href;
  } else if (typeof document != 'undefined' && document.currentScript) { // web
    scriptDirectory = document.currentScript.src;
  }
  // When MODULARIZE, this JS may be executed later, after document.currentScript
  // is gone, so we saved it, and we use it here instead of any other info.
  if (_scriptDir) {
    scriptDirectory = _scriptDir;
  }
  // blob urls look like blob:http://site.com/etc/etc and we cannot infer anything from them.
  // otherwise, slice off the final part of the url to find the script directory.
  // if scriptDirectory does not contain a slash, lastIndexOf will return -1,
  // and scriptDirectory will correctly be replaced with an empty string.
  // If scriptDirectory contains a query (starting with ?) or a fragment (starting with #),
  // they are removed because they could contain a slash.
  if (scriptDirectory.indexOf('blob:') !== 0) {
    scriptDirectory = scriptDirectory.substr(0, scriptDirectory.replace(/[?#].*/, "").lastIndexOf('/')+1);
  } else {
    scriptDirectory = '';
  }

  if (!(typeof window == 'object' || typeof importScripts == 'function')) throw new Error('not compiled for this environment (did you build to HTML and try to run it not on the web, or set ENVIRONMENT to something - like node - and run it someplace else - like on the web?)');

  // Differentiate the Web Worker from the Node Worker case, as reading must
  // be done differently.
  {
// include: web_or_worker_shell_read.js
read_ = (url) => {
      var xhr = new XMLHttpRequest();
      xhr.open('GET', url, false);
      xhr.send(null);
      return xhr.responseText;
  }

  if (ENVIRONMENT_IS_WORKER) {
    readBinary = (url) => {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, false);
        xhr.responseType = 'arraybuffer';
        xhr.send(null);
        return new Uint8Array(/** @type{!ArrayBuffer} */(xhr.response));
    };
  }

  readAsync = (url, onload, onerror) => {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'arraybuffer';
    xhr.onload = () => {
      if (xhr.status == 200 || (xhr.status == 0 && xhr.response)) { // file URLs can return 0
        onload(xhr.response);
        return;
      }
      onerror();
    };
    xhr.onerror = onerror;
    xhr.send(null);
  }

// end include: web_or_worker_shell_read.js
  }

  setWindowTitle = (title) => document.title = title;
} else
{
  throw new Error('environment detection error');
}

var out = Module['print'] || console.log.bind(console);
var err = Module['printErr'] || console.warn.bind(console);

// Merge back in the overrides
Object.assign(Module, moduleOverrides);
// Free the object hierarchy contained in the overrides, this lets the GC
// reclaim data used e.g. in memoryInitializerRequest, which is a large typed array.
moduleOverrides = null;
checkIncomingModuleAPI();

// Emit code to handle expected values on the Module object. This applies Module.x
// to the proper local x. This has two benefits: first, we only emit it if it is
// expected to arrive, and second, by using a local everywhere else that can be
// minified.

if (Module['arguments']) arguments_ = Module['arguments'];legacyModuleProp('arguments', 'arguments_');

if (Module['thisProgram']) thisProgram = Module['thisProgram'];legacyModuleProp('thisProgram', 'thisProgram');

if (Module['quit']) quit_ = Module['quit'];legacyModuleProp('quit', 'quit_');

// perform assertions in shell.js after we set up out() and err(), as otherwise if an assertion fails it cannot print the message
// Assertions on removed incoming Module JS APIs.
assert(typeof Module['memoryInitializerPrefixURL'] == 'undefined', 'Module.memoryInitializerPrefixURL option was removed, use Module.locateFile instead');
assert(typeof Module['pthreadMainPrefixURL'] == 'undefined', 'Module.pthreadMainPrefixURL option was removed, use Module.locateFile instead');
assert(typeof Module['cdInitializerPrefixURL'] == 'undefined', 'Module.cdInitializerPrefixURL option was removed, use Module.locateFile instead');
assert(typeof Module['filePackagePrefixURL'] == 'undefined', 'Module.filePackagePrefixURL option was removed, use Module.locateFile instead');
assert(typeof Module['read'] == 'undefined', 'Module.read option was removed (modify read_ in JS)');
assert(typeof Module['readAsync'] == 'undefined', 'Module.readAsync option was removed (modify readAsync in JS)');
assert(typeof Module['readBinary'] == 'undefined', 'Module.readBinary option was removed (modify readBinary in JS)');
assert(typeof Module['setWindowTitle'] == 'undefined', 'Module.setWindowTitle option was removed (modify setWindowTitle in JS)');
assert(typeof Module['TOTAL_MEMORY'] == 'undefined', 'Module.TOTAL_MEMORY has been renamed Module.INITIAL_MEMORY');
legacyModuleProp('read', 'read_');
legacyModuleProp('readAsync', 'readAsync');
legacyModuleProp('readBinary', 'readBinary');
legacyModuleProp('setWindowTitle', 'setWindowTitle');
var IDBFS = 'IDBFS is no longer included by default; build with -lidbfs.js';
var PROXYFS = 'PROXYFS is no longer included by default; build with -lproxyfs.js';
var WORKERFS = 'WORKERFS is no longer included by default; build with -lworkerfs.js';
var NODEFS = 'NODEFS is no longer included by default; build with -lnodefs.js';

assert(!ENVIRONMENT_IS_SHELL, "shell environment detected but not enabled at build time.  Add 'shell' to `-sENVIRONMENT` to enable.");


// end include: shell.js
// include: preamble.js
// === Preamble library stuff ===

// Documentation for the public APIs defined in this file must be updated in:
//    site/source/docs/api_reference/preamble.js.rst
// A prebuilt local version of the documentation is available at:
//    site/build/text/docs/api_reference/preamble.js.txt
// You can also build docs locally as HTML or other formats in site/
// An online HTML version (which may be of a different version of Emscripten)
//    is up at http://kripken.github.io/emscripten-site/docs/api_reference/preamble.js.html

var wasmBinary;
if (Module['wasmBinary']) wasmBinary = Module['wasmBinary'];legacyModuleProp('wasmBinary', 'wasmBinary');
var noExitRuntime = Module['noExitRuntime'] || true;legacyModuleProp('noExitRuntime', 'noExitRuntime');

if (typeof WebAssembly != 'object') {
  abort('no native wasm support detected');
}

// Wasm globals

var wasmMemory;

//========================================
// Runtime essentials
//========================================

// whether we are quitting the application. no code should run after this.
// set in exit() and abort()
var ABORT = false;

// set by exit() and abort().  Passed to 'onExit' handler.
// NOTE: This is also used as the process return code code in shell environments
// but only when noExitRuntime is false.
var EXITSTATUS;

/** @type {function(*, string=)} */
function assert(condition, text) {
  if (!condition) {
    abort('Assertion failed' + (text ? ': ' + text : ''));
  }
}

// We used to include malloc/free by default in the past. Show a helpful error in
// builds with assertions.

// include: runtime_strings.js
// runtime_strings.js: String related runtime functions that are part of both
// MINIMAL_RUNTIME and regular runtime.

var UTF8Decoder = typeof TextDecoder != 'undefined' ? new TextDecoder('utf8') : undefined;

/**
 * Given a pointer 'idx' to a null-terminated UTF8-encoded string in the given
 * array that contains uint8 values, returns a copy of that string as a
 * Javascript String object.
 * heapOrArray is either a regular array, or a JavaScript typed array view.
 * @param {number} idx
 * @param {number=} maxBytesToRead
 * @return {string}
 */
function UTF8ArrayToString(heapOrArray, idx, maxBytesToRead) {
  var endIdx = idx + maxBytesToRead;
  var endPtr = idx;
  // TextDecoder needs to know the byte length in advance, it doesn't stop on
  // null terminator by itself.  Also, use the length info to avoid running tiny
  // strings through TextDecoder, since .subarray() allocates garbage.
  // (As a tiny code save trick, compare endPtr against endIdx using a negation,
  // so that undefined means Infinity)
  while (heapOrArray[endPtr] && !(endPtr >= endIdx)) ++endPtr;

  if (endPtr - idx > 16 && heapOrArray.buffer && UTF8Decoder) {
    return UTF8Decoder.decode(heapOrArray.subarray(idx, endPtr));
  }
  var str = '';
  // If building with TextDecoder, we have already computed the string length
  // above, so test loop end condition against that
  while (idx < endPtr) {
    // For UTF8 byte structure, see:
    // http://en.wikipedia.org/wiki/UTF-8#Description
    // https://www.ietf.org/rfc/rfc2279.txt
    // https://tools.ietf.org/html/rfc3629
    var u0 = heapOrArray[idx++];
    if (!(u0 & 0x80)) { str += String.fromCharCode(u0); continue; }
    var u1 = heapOrArray[idx++] & 63;
    if ((u0 & 0xE0) == 0xC0) { str += String.fromCharCode(((u0 & 31) << 6) | u1); continue; }
    var u2 = heapOrArray[idx++] & 63;
    if ((u0 & 0xF0) == 0xE0) {
      u0 = ((u0 & 15) << 12) | (u1 << 6) | u2;
    } else {
      if ((u0 & 0xF8) != 0xF0) warnOnce('Invalid UTF-8 leading byte ' + ptrToString(u0) + ' encountered when deserializing a UTF-8 string in wasm memory to a JS string!');
      u0 = ((u0 & 7) << 18) | (u1 << 12) | (u2 << 6) | (heapOrArray[idx++] & 63);
    }

    if (u0 < 0x10000) {
      str += String.fromCharCode(u0);
    } else {
      var ch = u0 - 0x10000;
      str += String.fromCharCode(0xD800 | (ch >> 10), 0xDC00 | (ch & 0x3FF));
    }
  }
  return str;
}

/**
 * Given a pointer 'ptr' to a null-terminated UTF8-encoded string in the
 * emscripten HEAP, returns a copy of that string as a Javascript String object.
 *
 * @param {number} ptr
 * @param {number=} maxBytesToRead - An optional length that specifies the
 *   maximum number of bytes to read. You can omit this parameter to scan the
 *   string until the first \0 byte. If maxBytesToRead is passed, and the string
 *   at [ptr, ptr+maxBytesToReadr[ contains a null byte in the middle, then the
 *   string will cut short at that byte index (i.e. maxBytesToRead will not
 *   produce a string of exact length [ptr, ptr+maxBytesToRead[) N.B. mixing
 *   frequent uses of UTF8ToString() with and without maxBytesToRead may throw
 *   JS JIT optimizations off, so it is worth to consider consistently using one
 * @return {string}
 */
function UTF8ToString(ptr, maxBytesToRead) {
  return ptr ? UTF8ArrayToString(HEAPU8, ptr, maxBytesToRead) : '';
}

/**
 * Copies the given Javascript String object 'str' to the given byte array at
 * address 'outIdx', encoded in UTF8 form and null-terminated. The copy will
 * require at most str.length*4+1 bytes of space in the HEAP.  Use the function
 * lengthBytesUTF8 to compute the exact number of bytes (excluding null
 * terminator) that this function will write.
 *
 * @param {string} str - The Javascript string to copy.
 * @param {ArrayBufferView|Array<number>} heap - The array to copy to. Each
 *                                               index in this array is assumed
 *                                               to be one 8-byte element.
 * @param {number} outIdx - The starting offset in the array to begin the copying.
 * @param {number} maxBytesToWrite - The maximum number of bytes this function
 *                                   can write to the array.  This count should
 *                                   include the null terminator, i.e. if
 *                                   maxBytesToWrite=1, only the null terminator
 *                                   will be written and nothing else.
 *                                   maxBytesToWrite=0 does not write any bytes
 *                                   to the output, not even the null
 *                                   terminator.
 * @return {number} The number of bytes written, EXCLUDING the null terminator.
 */
function stringToUTF8Array(str, heap, outIdx, maxBytesToWrite) {
  // Parameter maxBytesToWrite is not optional. Negative values, 0, null,
  // undefined and false each don't write out any bytes.
  if (!(maxBytesToWrite > 0))
    return 0;

  var startIdx = outIdx;
  var endIdx = outIdx + maxBytesToWrite - 1; // -1 for string null terminator.
  for (var i = 0; i < str.length; ++i) {
    // Gotcha: charCodeAt returns a 16-bit word that is a UTF-16 encoded code
    // unit, not a Unicode code point of the character! So decode
    // UTF16->UTF32->UTF8.
    // See http://unicode.org/faq/utf_bom.html#utf16-3
    // For UTF8 byte structure, see http://en.wikipedia.org/wiki/UTF-8#Description
    // and https://www.ietf.org/rfc/rfc2279.txt
    // and https://tools.ietf.org/html/rfc3629
    var u = str.charCodeAt(i); // possibly a lead surrogate
    if (u >= 0xD800 && u <= 0xDFFF) {
      var u1 = str.charCodeAt(++i);
      u = 0x10000 + ((u & 0x3FF) << 10) | (u1 & 0x3FF);
    }
    if (u <= 0x7F) {
      if (outIdx >= endIdx) break;
      heap[outIdx++] = u;
    } else if (u <= 0x7FF) {
      if (outIdx + 1 >= endIdx) break;
      heap[outIdx++] = 0xC0 | (u >> 6);
      heap[outIdx++] = 0x80 | (u & 63);
    } else if (u <= 0xFFFF) {
      if (outIdx + 2 >= endIdx) break;
      heap[outIdx++] = 0xE0 | (u >> 12);
      heap[outIdx++] = 0x80 | ((u >> 6) & 63);
      heap[outIdx++] = 0x80 | (u & 63);
    } else {
      if (outIdx + 3 >= endIdx) break;
      if (u > 0x10FFFF) warnOnce('Invalid Unicode code point ' + ptrToString(u) + ' encountered when serializing a JS string to a UTF-8 string in wasm memory! (Valid unicode code points should be in range 0-0x10FFFF).');
      heap[outIdx++] = 0xF0 | (u >> 18);
      heap[outIdx++] = 0x80 | ((u >> 12) & 63);
      heap[outIdx++] = 0x80 | ((u >> 6) & 63);
      heap[outIdx++] = 0x80 | (u & 63);
    }
  }
  // Null-terminate the pointer to the buffer.
  heap[outIdx] = 0;
  return outIdx - startIdx;
}

/**
 * Copies the given Javascript String object 'str' to the emscripten HEAP at
 * address 'outPtr', null-terminated and encoded in UTF8 form. The copy will
 * require at most str.length*4+1 bytes of space in the HEAP.
 * Use the function lengthBytesUTF8 to compute the exact number of bytes
 * (excluding null terminator) that this function will write.
 *
 * @return {number} The number of bytes written, EXCLUDING the null terminator.
 */
function stringToUTF8(str, outPtr, maxBytesToWrite) {
  assert(typeof maxBytesToWrite == 'number', 'stringToUTF8(str, outPtr, maxBytesToWrite) is missing the third parameter that specifies the length of the output buffer!');
  return stringToUTF8Array(str, HEAPU8,outPtr, maxBytesToWrite);
}

/**
 * Returns the number of bytes the given Javascript string takes if encoded as a
 * UTF8 byte array, EXCLUDING the null terminator byte.
 *
 * @param {string} str - JavaScript string to operator on
 * @return {number} Length, in bytes, of the UTF8 encoded string.
 */
function lengthBytesUTF8(str) {
  var len = 0;
  for (var i = 0; i < str.length; ++i) {
    // Gotcha: charCodeAt returns a 16-bit word that is a UTF-16 encoded code
    // unit, not a Unicode code point of the character! So decode
    // UTF16->UTF32->UTF8.
    // See http://unicode.org/faq/utf_bom.html#utf16-3
    var c = str.charCodeAt(i); // possibly a lead surrogate
    if (c <= 0x7F) {
      len++;
    } else if (c <= 0x7FF) {
      len += 2;
    } else if (c >= 0xD800 && c <= 0xDFFF) {
      len += 4; ++i;
    } else {
      len += 3;
    }
  }
  return len;
}

// end include: runtime_strings.js
// Memory management

var HEAP,
/** @type {!Int8Array} */
  HEAP8,
/** @type {!Uint8Array} */
  HEAPU8,
/** @type {!Int16Array} */
  HEAP16,
/** @type {!Uint16Array} */
  HEAPU16,
/** @type {!Int32Array} */
  HEAP32,
/** @type {!Uint32Array} */
  HEAPU32,
/** @type {!Float32Array} */
  HEAPF32,
/** @type {!Float64Array} */
  HEAPF64;

function updateMemoryViews() {
  var b = wasmMemory.buffer;
  Module['HEAP8'] = HEAP8 = new Int8Array(b);
  Module['HEAP16'] = HEAP16 = new Int16Array(b);
  Module['HEAP32'] = HEAP32 = new Int32Array(b);
  Module['HEAPU8'] = HEAPU8 = new Uint8Array(b);
  Module['HEAPU16'] = HEAPU16 = new Uint16Array(b);
  Module['HEAPU32'] = HEAPU32 = new Uint32Array(b);
  Module['HEAPF32'] = HEAPF32 = new Float32Array(b);
  Module['HEAPF64'] = HEAPF64 = new Float64Array(b);
}

assert(!Module['STACK_SIZE'], 'STACK_SIZE can no longer be set at runtime.  Use -sSTACK_SIZE at link time')

assert(typeof Int32Array != 'undefined' && typeof Float64Array !== 'undefined' && Int32Array.prototype.subarray != undefined && Int32Array.prototype.set != undefined,
       'JS engine does not provide full typed array support');

// If memory is defined in wasm, the user can't provide it, or set INITIAL_MEMORY
assert(!Module['wasmMemory'], 'Use of `wasmMemory` detected.  Use -sIMPORTED_MEMORY to define wasmMemory externally');
assert(!Module['INITIAL_MEMORY'], 'Detected runtime INITIAL_MEMORY setting.  Use -sIMPORTED_MEMORY to define wasmMemory dynamically');

// include: runtime_init_table.js
// In regular non-RELOCATABLE mode the table is exported
// from the wasm module and this will be assigned once
// the exports are available.
var wasmTable;

// end include: runtime_init_table.js
// include: runtime_stack_check.js
// Initializes the stack cookie. Called at the startup of main and at the startup of each thread in pthreads mode.
function writeStackCookie() {
  var max = _emscripten_stack_get_end();
  assert((max & 3) == 0);
  // If the stack ends at address zero we write our cookies 4 bytes into the
  // stack.  This prevents interference with the (separate) address-zero check
  // below.
  if (max == 0) {
    max += 4;
  }
  // The stack grow downwards towards _emscripten_stack_get_end.
  // We write cookies to the final two words in the stack and detect if they are
  // ever overwritten.
  HEAPU32[((max)>>2)] = 0x2135467;
  HEAPU32[(((max)+(4))>>2)] = 0x89BACDFE;
  // Also test the global address 0 for integrity.
  HEAPU32[0] = 0x63736d65; /* 'emsc' */
}

function checkStackCookie() {
  if (ABORT) return;
  var max = _emscripten_stack_get_end();
  // See writeStackCookie().
  if (max == 0) {
    max += 4;
  }
  var cookie1 = HEAPU32[((max)>>2)];
  var cookie2 = HEAPU32[(((max)+(4))>>2)];
  if (cookie1 != 0x2135467 || cookie2 != 0x89BACDFE) {
    abort('Stack overflow! Stack cookie has been overwritten at ' + ptrToString(max) + ', expected hex dwords 0x89BACDFE and 0x2135467, but received ' + ptrToString(cookie2) + ' ' + ptrToString(cookie1));
  }
  // Also test the global address 0 for integrity.
  if (HEAPU32[0] !== 0x63736d65 /* 'emsc' */) {
    abort('Runtime error: The application has corrupted its heap memory area (address zero)!');
  }
}

// end include: runtime_stack_check.js
// include: runtime_assertions.js
// Endianness check
(function() {
  var h16 = new Int16Array(1);
  var h8 = new Int8Array(h16.buffer);
  h16[0] = 0x6373;
  if (h8[0] !== 0x73 || h8[1] !== 0x63) throw 'Runtime error: expected the system to be little-endian! (Run with -sSUPPORT_BIG_ENDIAN to bypass)';
})();

// end include: runtime_assertions.js
var __ATPRERUN__  = []; // functions called before the runtime is initialized
var __ATINIT__    = []; // functions called during startup
var __ATEXIT__    = []; // functions called during shutdown
var __ATPOSTRUN__ = []; // functions called after the main() is called

var runtimeInitialized = false;

function keepRuntimeAlive() {
  return noExitRuntime;
}

function preRun() {
  if (Module['preRun']) {
    if (typeof Module['preRun'] == 'function') Module['preRun'] = [Module['preRun']];
    while (Module['preRun'].length) {
      addOnPreRun(Module['preRun'].shift());
    }
  }
  callRuntimeCallbacks(__ATPRERUN__);
}

function initRuntime() {
  assert(!runtimeInitialized);
  runtimeInitialized = true;

  checkStackCookie();

  
  callRuntimeCallbacks(__ATINIT__);
}

function postRun() {
  checkStackCookie();

  if (Module['postRun']) {
    if (typeof Module['postRun'] == 'function') Module['postRun'] = [Module['postRun']];
    while (Module['postRun'].length) {
      addOnPostRun(Module['postRun'].shift());
    }
  }

  callRuntimeCallbacks(__ATPOSTRUN__);
}

function addOnPreRun(cb) {
  __ATPRERUN__.unshift(cb);
}

function addOnInit(cb) {
  __ATINIT__.unshift(cb);
}

function addOnExit(cb) {
}

function addOnPostRun(cb) {
  __ATPOSTRUN__.unshift(cb);
}

// include: runtime_math.js
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/imul

// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/fround

// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/clz32

// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/trunc

assert(Math.imul, 'This browser does not support Math.imul(), build with LEGACY_VM_SUPPORT or POLYFILL_OLD_MATH_FUNCTIONS to add in a polyfill');
assert(Math.fround, 'This browser does not support Math.fround(), build with LEGACY_VM_SUPPORT or POLYFILL_OLD_MATH_FUNCTIONS to add in a polyfill');
assert(Math.clz32, 'This browser does not support Math.clz32(), build with LEGACY_VM_SUPPORT or POLYFILL_OLD_MATH_FUNCTIONS to add in a polyfill');
assert(Math.trunc, 'This browser does not support Math.trunc(), build with LEGACY_VM_SUPPORT or POLYFILL_OLD_MATH_FUNCTIONS to add in a polyfill');

// end include: runtime_math.js
// A counter of dependencies for calling run(). If we need to
// do asynchronous work before running, increment this and
// decrement it. Incrementing must happen in a place like
// Module.preRun (used by emcc to add file preloading).
// Note that you can add dependencies in preRun, even though
// it happens right before run - run will be postponed until
// the dependencies are met.
var runDependencies = 0;
var runDependencyWatcher = null;
var dependenciesFulfilled = null; // overridden to take different actions when all run dependencies are fulfilled
var runDependencyTracking = {};

function getUniqueRunDependency(id) {
  var orig = id;
  while (1) {
    if (!runDependencyTracking[id]) return id;
    id = orig + Math.random();
  }
}

function addRunDependency(id) {
  runDependencies++;

  if (Module['monitorRunDependencies']) {
    Module['monitorRunDependencies'](runDependencies);
  }

  if (id) {
    assert(!runDependencyTracking[id]);
    runDependencyTracking[id] = 1;
    if (runDependencyWatcher === null && typeof setInterval != 'undefined') {
      // Check for missing dependencies every few seconds
      runDependencyWatcher = setInterval(function() {
        if (ABORT) {
          clearInterval(runDependencyWatcher);
          runDependencyWatcher = null;
          return;
        }
        var shown = false;
        for (var dep in runDependencyTracking) {
          if (!shown) {
            shown = true;
            err('still waiting on run dependencies:');
          }
          err('dependency: ' + dep);
        }
        if (shown) {
          err('(end of list)');
        }
      }, 10000);
    }
  } else {
    err('warning: run dependency added without ID');
  }
}

function removeRunDependency(id) {
  runDependencies--;

  if (Module['monitorRunDependencies']) {
    Module['monitorRunDependencies'](runDependencies);
  }

  if (id) {
    assert(runDependencyTracking[id]);
    delete runDependencyTracking[id];
  } else {
    err('warning: run dependency removed without ID');
  }
  if (runDependencies == 0) {
    if (runDependencyWatcher !== null) {
      clearInterval(runDependencyWatcher);
      runDependencyWatcher = null;
    }
    if (dependenciesFulfilled) {
      var callback = dependenciesFulfilled;
      dependenciesFulfilled = null;
      callback(); // can add another dependenciesFulfilled
    }
  }
}

/** @param {string|number=} what */
function abort(what) {
  if (Module['onAbort']) {
    Module['onAbort'](what);
  }

  what = 'Aborted(' + what + ')';
  // TODO(sbc): Should we remove printing and leave it up to whoever
  // catches the exception?
  err(what);

  ABORT = true;
  EXITSTATUS = 1;

  // Use a wasm runtime error, because a JS error might be seen as a foreign
  // exception, which means we'd run destructors on it. We need the error to
  // simply make the program stop.
  // FIXME This approach does not work in Wasm EH because it currently does not assume
  // all RuntimeErrors are from traps; it decides whether a RuntimeError is from
  // a trap or not based on a hidden field within the object. So at the moment
  // we don't have a way of throwing a wasm trap from JS. TODO Make a JS API that
  // allows this in the wasm spec.

  // Suppress closure compiler warning here. Closure compiler's builtin extern
  // defintion for WebAssembly.RuntimeError claims it takes no arguments even
  // though it can.
  // TODO(https://github.com/google/closure-compiler/pull/3913): Remove if/when upstream closure gets fixed.
  /** @suppress {checkTypes} */
  var e = new WebAssembly.RuntimeError(what);

  readyPromiseReject(e);
  // Throw the error whether or not MODULARIZE is set because abort is used
  // in code paths apart from instantiation where an exception is expected
  // to be thrown when abort is called.
  throw e;
}

// include: memoryprofiler.js
// end include: memoryprofiler.js
// show errors on likely calls to FS when it was not included
var FS = {
  error: function() {
    abort('Filesystem support (FS) was not included. The problem is that you are using files from JS, but files were not used from C/C++, so filesystem support was not auto-included. You can force-include filesystem support with -sFORCE_FILESYSTEM');
  },
  init: function() { FS.error() },
  createDataFile: function() { FS.error() },
  createPreloadedFile: function() { FS.error() },
  createLazyFile: function() { FS.error() },
  open: function() { FS.error() },
  mkdev: function() { FS.error() },
  registerDevice: function() { FS.error() },
  analyzePath: function() { FS.error() },
  loadFilesFromDB: function() { FS.error() },

  ErrnoError: function ErrnoError() { FS.error() },
};
Module['FS_createDataFile'] = FS.createDataFile;
Module['FS_createPreloadedFile'] = FS.createPreloadedFile;

// include: URIUtils.js
// Prefix of data URIs emitted by SINGLE_FILE and related options.
var dataURIPrefix = 'data:application/octet-stream;base64,';

// Indicates whether filename is a base64 data URI.
function isDataURI(filename) {
  // Prefix of data URIs emitted by SINGLE_FILE and related options.
  return filename.startsWith(dataURIPrefix);
}

// Indicates whether filename is delivered via file protocol (as opposed to http/https)
function isFileURI(filename) {
  return filename.startsWith('file://');
}

// end include: URIUtils.js
/** @param {boolean=} fixedasm */
function createExportWrapper(name, fixedasm) {
  return function() {
    var displayName = name;
    var asm = fixedasm;
    if (!fixedasm) {
      asm = Module['asm'];
    }
    assert(runtimeInitialized, 'native function `' + displayName + '` called before runtime initialization');
    if (!asm[name]) {
      assert(asm[name], 'exported native function `' + displayName + '` not found');
    }
    return asm[name].apply(null, arguments);
  };
}

var wasmBinaryFile;
  wasmBinaryFile = 'imgui.wasm.wasm';
  if (!isDataURI(wasmBinaryFile)) {
    wasmBinaryFile = locateFile(wasmBinaryFile);
  }

function getBinary(file) {
  try {
    if (file == wasmBinaryFile && wasmBinary) {
      return new Uint8Array(wasmBinary);
    }
    if (readBinary) {
      return readBinary(file);
    }
    throw "both async and sync fetching of the wasm failed";
  }
  catch (err) {
    abort(err);
  }
}

function getBinaryPromise() {
  // If we don't have the binary yet, try to to load it asynchronously.
  // Fetch has some additional restrictions over XHR, like it can't be used on a file:// url.
  // See https://github.com/github/fetch/pull/92#issuecomment-140665932
  // Cordova or Electron apps are typically loaded from a file:// url.
  // So use fetch if it is available and the url is not a file, otherwise fall back to XHR.
  if (!wasmBinary && (ENVIRONMENT_IS_WEB || ENVIRONMENT_IS_WORKER)) {
    if (typeof fetch == 'function'
      && !isFileURI(wasmBinaryFile)
    ) {
      return fetch(wasmBinaryFile, { credentials: 'same-origin' }).then(function(response) {
        if (!response['ok']) {
          throw "failed to load wasm binary file at '" + wasmBinaryFile + "'";
        }
        return response['arrayBuffer']();
      }).catch(function () {
          return getBinary(wasmBinaryFile);
      });
    }
    else {
      if (readAsync) {
        // fetch is not available or url is file => try XHR (readAsync uses XHR internally)
        return new Promise(function(resolve, reject) {
          readAsync(wasmBinaryFile, function(response) { resolve(new Uint8Array(/** @type{!ArrayBuffer} */(response))) }, reject)
        });
      }
    }
  }

  // Otherwise, getBinary should be able to get it synchronously
  return Promise.resolve().then(function() { return getBinary(wasmBinaryFile); });
}

// Create the wasm instance.
// Receives the wasm imports, returns the exports.
function createWasm() {
  // prepare imports
  var info = {
    'env': wasmImports,
    'wasi_snapshot_preview1': wasmImports,
  };
  // Load the wasm module and create an instance of using native support in the JS engine.
  // handle a generated wasm instance, receiving its exports and
  // performing other necessary setup
  /** @param {WebAssembly.Module=} module*/
  function receiveInstance(instance, module) {
    var exports = instance.exports;

    Module['asm'] = exports;

    wasmMemory = Module['asm']['memory'];
    assert(wasmMemory, "memory not found in wasm exports");
    // This assertion doesn't hold when emscripten is run in --post-link
    // mode.
    // TODO(sbc): Read INITIAL_MEMORY out of the wasm file in post-link mode.
    //assert(wasmMemory.buffer.byteLength === 67108864);
    updateMemoryViews();

    wasmTable = Module['asm']['__indirect_function_table'];
    assert(wasmTable, "table not found in wasm exports");

    addOnInit(Module['asm']['__wasm_call_ctors']);

    removeRunDependency('wasm-instantiate');

  }
  // wait for the pthread pool (if any)
  addRunDependency('wasm-instantiate');

  // Prefer streaming instantiation if available.
  // Async compilation can be confusing when an error on the page overwrites Module
  // (for example, if the order of elements is wrong, and the one defining Module is
  // later), so we save Module and check it later.
  var trueModule = Module;
  function receiveInstantiationResult(result) {
    // 'result' is a ResultObject object which has both the module and instance.
    // receiveInstance() will swap in the exports (to Module.asm) so they can be called
    assert(Module === trueModule, 'the Module object should not be replaced during async compilation - perhaps the order of HTML elements is wrong?');
    trueModule = null;
    // TODO: Due to Closure regression https://github.com/google/closure-compiler/issues/3193, the above line no longer optimizes out down to the following line.
    // When the regression is fixed, can restore the above USE_PTHREADS-enabled path.
    receiveInstance(result['instance']);
  }

  function instantiateArrayBuffer(receiver) {
    return getBinaryPromise().then(function(binary) {
      return WebAssembly.instantiate(binary, info);
    }).then(function (instance) {
      return instance;
    }).then(receiver, function(reason) {
      err('failed to asynchronously prepare wasm: ' + reason);

      // Warn on some common problems.
      if (isFileURI(wasmBinaryFile)) {
        err('warning: Loading from a file URI (' + wasmBinaryFile + ') is not supported in most browsers. See https://emscripten.org/docs/getting_started/FAQ.html#how-do-i-run-a-local-webserver-for-testing-why-does-my-program-stall-in-downloading-or-preparing');
      }
      abort(reason);
    });
  }

  function instantiateAsync() {
    if (!wasmBinary &&
        typeof WebAssembly.instantiateStreaming == 'function' &&
        !isDataURI(wasmBinaryFile) &&
        // Don't use streaming for file:// delivered objects in a webview, fetch them synchronously.
        !isFileURI(wasmBinaryFile) &&
        // Avoid instantiateStreaming() on Node.js environment for now, as while
        // Node.js v18.1.0 implements it, it does not have a full fetch()
        // implementation yet.
        //
        // Reference:
        //   https://github.com/emscripten-core/emscripten/pull/16917
        !ENVIRONMENT_IS_NODE &&
        typeof fetch == 'function') {
      return fetch(wasmBinaryFile, { credentials: 'same-origin' }).then(function(response) {
        // Suppress closure warning here since the upstream definition for
        // instantiateStreaming only allows Promise<Repsponse> rather than
        // an actual Response.
        // TODO(https://github.com/google/closure-compiler/pull/3913): Remove if/when upstream closure is fixed.
        /** @suppress {checkTypes} */
        var result = WebAssembly.instantiateStreaming(response, info);

        return result.then(
          receiveInstantiationResult,
          function(reason) {
            // We expect the most common failure cause to be a bad MIME type for the binary,
            // in which case falling back to ArrayBuffer instantiation should work.
            err('wasm streaming compile failed: ' + reason);
            err('falling back to ArrayBuffer instantiation');
            return instantiateArrayBuffer(receiveInstantiationResult);
          });
      });
    } else {
      return instantiateArrayBuffer(receiveInstantiationResult);
    }
  }

  // User shell pages can write their own Module.instantiateWasm = function(imports, successCallback) callback
  // to manually instantiate the Wasm module themselves. This allows pages to run the instantiation parallel
  // to any other async startup actions they are performing.
  // Also pthreads and wasm workers initialize the wasm instance through this path.
  if (Module['instantiateWasm']) {
    try {
      var exports = Module['instantiateWasm'](info, receiveInstance);
      return exports;
    } catch(e) {
      err('Module.instantiateWasm callback failed with error: ' + e);
        // If instantiation fails, reject the module ready promise.
        readyPromiseReject(e);
    }
  }

  // If instantiation fails, reject the module ready promise.
  instantiateAsync().catch(readyPromiseReject);
  return {}; // no exports yet; we'll fill them in later
}

// Globals used by JS i64 conversions (see makeSetValue)
var tempDouble;
var tempI64;

// include: runtime_debug.js
function legacyModuleProp(prop, newName) {
  if (!Object.getOwnPropertyDescriptor(Module, prop)) {
    Object.defineProperty(Module, prop, {
      configurable: true,
      get: function() {
        abort('Module.' + prop + ' has been replaced with plain ' + newName + ' (the initial value can be provided on Module, but after startup the value is only looked for on a local variable of that name)');
      }
    });
  }
}

function ignoredModuleProp(prop) {
  if (Object.getOwnPropertyDescriptor(Module, prop)) {
    abort('`Module.' + prop + '` was supplied but `' + prop + '` not included in INCOMING_MODULE_JS_API');
  }
}

// forcing the filesystem exports a few things by default
function isExportedByForceFilesystem(name) {
  return name === 'FS_createPath' ||
         name === 'FS_createDataFile' ||
         name === 'FS_createPreloadedFile' ||
         name === 'FS_unlink' ||
         name === 'addRunDependency' ||
         // The old FS has some functionality that WasmFS lacks.
         name === 'FS_createLazyFile' ||
         name === 'FS_createDevice' ||
         name === 'removeRunDependency';
}

function missingGlobal(sym, msg) {
  if (typeof globalThis !== 'undefined') {
    Object.defineProperty(globalThis, sym, {
      configurable: true,
      get: function() {
        warnOnce('`' + sym + '` is not longer defined by emscripten. ' + msg);
        return undefined;
      }
    });
  }
}

missingGlobal('buffer', 'Please use HEAP8.buffer or wasmMemory.buffer');

function missingLibrarySymbol(sym) {
  if (typeof globalThis !== 'undefined' && !Object.getOwnPropertyDescriptor(globalThis, sym)) {
    Object.defineProperty(globalThis, sym, {
      configurable: true,
      get: function() {
        // Can't `abort()` here because it would break code that does runtime
        // checks.  e.g. `if (typeof SDL === 'undefined')`.
        var msg = '`' + sym + '` is a library symbol and not included by default; add it to your library.js __deps or to DEFAULT_LIBRARY_FUNCS_TO_INCLUDE on the command line';
        // DEFAULT_LIBRARY_FUNCS_TO_INCLUDE requires the name as it appears in
        // library.js, which means $name for a JS name with no prefix, or name
        // for a JS name like _name.
        var librarySymbol = sym;
        if (!librarySymbol.startsWith('_')) {
          librarySymbol = '$' + sym;
        }
        msg += " (e.g. -sDEFAULT_LIBRARY_FUNCS_TO_INCLUDE=" + librarySymbol + ")";
        if (isExportedByForceFilesystem(sym)) {
          msg += '. Alternatively, forcing filesystem support (-sFORCE_FILESYSTEM) can export this for you';
        }
        warnOnce(msg);
        return undefined;
      }
    });
  }
  // Any symbol that is not included from the JS libary is also (by definttion)
  // not exported on the Module object.
  unexportedRuntimeSymbol(sym);
}

function unexportedRuntimeSymbol(sym) {
  if (!Object.getOwnPropertyDescriptor(Module, sym)) {
    Object.defineProperty(Module, sym, {
      configurable: true,
      get: function() {
        var msg = "'" + sym + "' was not exported. add it to EXPORTED_RUNTIME_METHODS (see the FAQ)";
        if (isExportedByForceFilesystem(sym)) {
          msg += '. Alternatively, forcing filesystem support (-sFORCE_FILESYSTEM) can export this for you';
        }
        abort(msg);
      }
    });
  }
}

// end include: runtime_debug.js
// === Body ===

function array_bounds_check_error(idx,size) { throw 'Array index ' + idx + ' out of bounds: [0,' + size + ')'; }



// end include: preamble.js

  /** @constructor */
  function ExitStatus(status) {
      this.name = 'ExitStatus';
      this.message = 'Program terminated with exit(' + status + ')';
      this.status = status;
    }

  function callRuntimeCallbacks(callbacks) {
      while (callbacks.length > 0) {
        // Pass the module as the first argument.
        callbacks.shift()(Module);
      }
    }

  
    /**
     * @param {number} ptr
     * @param {string} type
     */
  function getValue(ptr, type = 'i8') {
      if (type.endsWith('*')) type = '*';
      switch (type) {
        case 'i1': return HEAP8[((ptr)>>0)];
        case 'i8': return HEAP8[((ptr)>>0)];
        case 'i16': return HEAP16[((ptr)>>1)];
        case 'i32': return HEAP32[((ptr)>>2)];
        case 'i64': return HEAP32[((ptr)>>2)];
        case 'float': return HEAPF32[((ptr)>>2)];
        case 'double': return HEAPF64[((ptr)>>3)];
        case '*': return HEAPU32[((ptr)>>2)];
        default: abort('invalid type for getValue: ' + type);
      }
      return null;
    }

  function ptrToString(ptr) {
      assert(typeof ptr === 'number');
      return '0x' + ptr.toString(16).padStart(8, '0');
    }

  
    /**
     * @param {number} ptr
     * @param {number} value
     * @param {string} type
     */
  function setValue(ptr, value, type = 'i8') {
      if (type.endsWith('*')) type = '*';
      switch (type) {
        case 'i1': HEAP8[((ptr)>>0)] = value; break;
        case 'i8': HEAP8[((ptr)>>0)] = value; break;
        case 'i16': HEAP16[((ptr)>>1)] = value; break;
        case 'i32': HEAP32[((ptr)>>2)] = value; break;
        case 'i64': (tempI64 = [value>>>0,(tempDouble=value,(+(Math.abs(tempDouble))) >= 1.0 ? (tempDouble > 0.0 ? ((Math.min((+(Math.floor((tempDouble)/4294967296.0))), 4294967295.0))|0)>>>0 : (~~((+(Math.ceil((tempDouble - +(((~~(tempDouble)))>>>0))/4294967296.0)))))>>>0) : 0)],HEAP32[((ptr)>>2)] = tempI64[0],HEAP32[(((ptr)+(4))>>2)] = tempI64[1]); break;
        case 'float': HEAPF32[((ptr)>>2)] = value; break;
        case 'double': HEAPF64[((ptr)>>3)] = value; break;
        case '*': HEAPU32[((ptr)>>2)] = value; break;
        default: abort('invalid type for setValue: ' + type);
      }
    }

  function warnOnce(text) {
      if (!warnOnce.shown) warnOnce.shown = {};
      if (!warnOnce.shown[text]) {
        warnOnce.shown[text] = 1;
        if (ENVIRONMENT_IS_NODE) text = 'warning: ' + text;
        err(text);
      }
    }

  function ___assert_fail(condition, filename, line, func) {
      abort('Assertion failed: ' + UTF8ToString(condition) + ', at: ' + [filename ? UTF8ToString(filename) : 'unknown filename', line, func ? UTF8ToString(func) : 'unknown function']);
    }

  function setErrNo(value) {
      HEAP32[((___errno_location())>>2)] = value;
      return value;
    }
  
  var SYSCALLS = {varargs:undefined,get:function() {
        assert(SYSCALLS.varargs != undefined);
        SYSCALLS.varargs += 4;
        var ret = HEAP32[(((SYSCALLS.varargs)-(4))>>2)];
        return ret;
      },getStr:function(ptr) {
        var ret = UTF8ToString(ptr);
        return ret;
      }};
  function ___syscall_fcntl64(fd, cmd, varargs) {
  SYSCALLS.varargs = varargs;
  
      return 0;
    }

  function ___syscall_ioctl(fd, op, varargs) {
  SYSCALLS.varargs = varargs;
  
      return 0;
    }

  function ___syscall_openat(dirfd, path, flags, varargs) {
  SYSCALLS.varargs = varargs;
  
  abort('it should not be possible to operate on streams when !SYSCALLS_REQUIRE_FILESYSTEM');
  }

  function _abort() {
      abort('native code called abort()');
    }

  function _emscripten_memcpy_big(dest, src, num) {
      HEAPU8.copyWithin(dest, src, src + num);
    }

  function getHeapMax() {
      // Stay one Wasm page short of 4GB: while e.g. Chrome is able to allocate
      // full 4GB Wasm memories, the size will wrap back to 0 bytes in Wasm side
      // for any code that deals with heap sizes, which would require special
      // casing all heap size related code to treat 0 specially.
      return 2147483648;
    }
  
  function emscripten_realloc_buffer(size) {
      var b = wasmMemory.buffer;
      try {
        // round size grow request up to wasm page size (fixed 64KB per spec)
        wasmMemory.grow((size - b.byteLength + 65535) >>> 16); // .grow() takes a delta compared to the previous size
        updateMemoryViews();
        return 1 /*success*/;
      } catch(e) {
        err('emscripten_realloc_buffer: Attempted to grow heap from ' + b.byteLength  + ' bytes to ' + size + ' bytes, but got error: ' + e);
      }
      // implicit 0 return to save code size (caller will cast "undefined" into 0
      // anyhow)
    }
  function _emscripten_resize_heap(requestedSize) {
      var oldSize = HEAPU8.length;
      requestedSize = requestedSize >>> 0;
      // With multithreaded builds, races can happen (another thread might increase the size
      // in between), so return a failure, and let the caller retry.
      assert(requestedSize > oldSize);
  
      // Memory resize rules:
      // 1.  Always increase heap size to at least the requested size, rounded up
      //     to next page multiple.
      // 2a. If MEMORY_GROWTH_LINEAR_STEP == -1, excessively resize the heap
      //     geometrically: increase the heap size according to
      //     MEMORY_GROWTH_GEOMETRIC_STEP factor (default +20%), At most
      //     overreserve by MEMORY_GROWTH_GEOMETRIC_CAP bytes (default 96MB).
      // 2b. If MEMORY_GROWTH_LINEAR_STEP != -1, excessively resize the heap
      //     linearly: increase the heap size by at least
      //     MEMORY_GROWTH_LINEAR_STEP bytes.
      // 3.  Max size for the heap is capped at 2048MB-WASM_PAGE_SIZE, or by
      //     MAXIMUM_MEMORY, or by ASAN limit, depending on which is smallest
      // 4.  If we were unable to allocate as much memory, it may be due to
      //     over-eager decision to excessively reserve due to (3) above.
      //     Hence if an allocation fails, cut down on the amount of excess
      //     growth, in an attempt to succeed to perform a smaller allocation.
  
      // A limit is set for how much we can grow. We should not exceed that
      // (the wasm binary specifies it, so if we tried, we'd fail anyhow).
      var maxHeapSize = getHeapMax();
      if (requestedSize > maxHeapSize) {
        err('Cannot enlarge memory, asked to go up to ' + requestedSize + ' bytes, but the limit is ' + maxHeapSize + ' bytes!');
        return false;
      }
  
      let alignUp = (x, multiple) => x + (multiple - x % multiple) % multiple;
  
      // Loop through potential heap size increases. If we attempt a too eager
      // reservation that fails, cut down on the attempted size and reserve a
      // smaller bump instead. (max 3 times, chosen somewhat arbitrarily)
      for (var cutDown = 1; cutDown <= 4; cutDown *= 2) {
        var overGrownHeapSize = oldSize * (1 + 0.2 / cutDown); // ensure geometric growth
        // but limit overreserving (default to capping at +96MB overgrowth at most)
        overGrownHeapSize = Math.min(overGrownHeapSize, requestedSize + 100663296 );
  
        var newSize = Math.min(maxHeapSize, alignUp(Math.max(requestedSize, overGrownHeapSize), 65536));
  
        var replacement = emscripten_realloc_buffer(newSize);
        if (replacement) {
  
          return true;
        }
      }
      err('Failed to grow the heap from ' + oldSize + ' bytes to ' + newSize + ' bytes, not enough memory!');
      return false;
    }

  function _fd_close(fd) {
      abort('fd_close called without SYSCALLS_REQUIRE_FILESYSTEM');
    }

  function _fd_read(fd, iov, iovcnt, pnum) {
      abort('fd_read called without SYSCALLS_REQUIRE_FILESYSTEM');
    }

  function convertI32PairToI53Checked(lo, hi) {
      assert(lo == (lo >>> 0) || lo == (lo|0)); // lo should either be a i32 or a u32
      assert(hi === (hi|0));                    // hi should be a i32
      return ((hi + 0x200000) >>> 0 < 0x400001 - !!lo) ? (lo >>> 0) + hi * 4294967296 : NaN;
    }
  
  
  
  
  function _fd_seek(fd, offset_low, offset_high, whence, newOffset) {
      return 70;
    }

  var printCharBuffers = [null,[],[]];
  function printChar(stream, curr) {
      var buffer = printCharBuffers[stream];
      assert(buffer);
      if (curr === 0 || curr === 10) {
        (stream === 1 ? out : err)(UTF8ArrayToString(buffer, 0));
        buffer.length = 0;
      } else {
        buffer.push(curr);
      }
    }
  
  function flush_NO_FILESYSTEM() {
      // flush anything remaining in the buffers during shutdown
      _fflush(0);
      if (printCharBuffers[1].length) printChar(1, 10);
      if (printCharBuffers[2].length) printChar(2, 10);
    }
  
  
  function _fd_write(fd, iov, iovcnt, pnum) {
      // hack to support printf in SYSCALLS_REQUIRE_FILESYSTEM=0
      var num = 0;
      for (var i = 0; i < iovcnt; i++) {
        var ptr = HEAPU32[((iov)>>2)];
        var len = HEAPU32[(((iov)+(4))>>2)];
        iov += 8;
        for (var j = 0; j < len; j++) {
          printChar(fd, HEAPU8[ptr+j]);
        }
        num += len;
      }
      HEAPU32[((pnum)>>2)] = num;
      return 0;
    }

  /** @type {function(string, boolean=, number=)} */
  function intArrayFromString(stringy, dontAddNull, length) {
    var len = length > 0 ? length : lengthBytesUTF8(stringy)+1;
    var u8array = new Array(len);
    var numBytesWritten = stringToUTF8Array(stringy, u8array, 0, u8array.length);
    if (dontAddNull) u8array.length = numBytesWritten;
    return u8array;
  }
function checkIncomingModuleAPI() {
  ignoredModuleProp('fetchSettings');
}
var wasmImports = {
  "__assert_fail": ___assert_fail,
  "__syscall_fcntl64": ___syscall_fcntl64,
  "__syscall_ioctl": ___syscall_ioctl,
  "__syscall_openat": ___syscall_openat,
  "abort": _abort,
  "emscripten_memcpy_big": _emscripten_memcpy_big,
  "emscripten_resize_heap": _emscripten_resize_heap,
  "fd_close": _fd_close,
  "fd_read": _fd_read,
  "fd_seek": _fd_seek,
  "fd_write": _fd_write
};
var asm = createWasm();
/** @type {function(...*):?} */
var ___wasm_call_ctors = createExportWrapper("__wasm_call_ctors");
/** @type {function(...*):?} */
var _emscripten_bind_VoidPtr___destroy___0 = Module["_emscripten_bind_VoidPtr___destroy___0"] = createExportWrapper("emscripten_bind_VoidPtr___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_BoolArray_1 = Module["_emscripten_bind_BoolArray_BoolArray_1"] = createExportWrapper("emscripten_bind_BoolArray_BoolArray_1");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_resize_1 = Module["_emscripten_bind_BoolArray_resize_1"] = createExportWrapper("emscripten_bind_BoolArray_resize_1");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_getValue_1 = Module["_emscripten_bind_BoolArray_getValue_1"] = createExportWrapper("emscripten_bind_BoolArray_getValue_1");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_setValue_2 = Module["_emscripten_bind_BoolArray_setValue_2"] = createExportWrapper("emscripten_bind_BoolArray_setValue_2");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_getPointer_0 = Module["_emscripten_bind_BoolArray_getPointer_0"] = createExportWrapper("emscripten_bind_BoolArray_getPointer_0");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_get_size_0 = Module["_emscripten_bind_BoolArray_get_size_0"] = createExportWrapper("emscripten_bind_BoolArray_get_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray_set_size_1 = Module["_emscripten_bind_BoolArray_set_size_1"] = createExportWrapper("emscripten_bind_BoolArray_set_size_1");
/** @type {function(...*):?} */
var _emscripten_bind_BoolArray___destroy___0 = Module["_emscripten_bind_BoolArray___destroy___0"] = createExportWrapper("emscripten_bind_BoolArray___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_IntArray_1 = Module["_emscripten_bind_IntArray_IntArray_1"] = createExportWrapper("emscripten_bind_IntArray_IntArray_1");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_resize_1 = Module["_emscripten_bind_IntArray_resize_1"] = createExportWrapper("emscripten_bind_IntArray_resize_1");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_getValue_1 = Module["_emscripten_bind_IntArray_getValue_1"] = createExportWrapper("emscripten_bind_IntArray_getValue_1");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_setValue_2 = Module["_emscripten_bind_IntArray_setValue_2"] = createExportWrapper("emscripten_bind_IntArray_setValue_2");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_getPointer_0 = Module["_emscripten_bind_IntArray_getPointer_0"] = createExportWrapper("emscripten_bind_IntArray_getPointer_0");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_get_size_0 = Module["_emscripten_bind_IntArray_get_size_0"] = createExportWrapper("emscripten_bind_IntArray_get_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray_set_size_1 = Module["_emscripten_bind_IntArray_set_size_1"] = createExportWrapper("emscripten_bind_IntArray_set_size_1");
/** @type {function(...*):?} */
var _emscripten_bind_IntArray___destroy___0 = Module["_emscripten_bind_IntArray___destroy___0"] = createExportWrapper("emscripten_bind_IntArray___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_FloatArray_1 = Module["_emscripten_bind_FloatArray_FloatArray_1"] = createExportWrapper("emscripten_bind_FloatArray_FloatArray_1");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_resize_1 = Module["_emscripten_bind_FloatArray_resize_1"] = createExportWrapper("emscripten_bind_FloatArray_resize_1");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_getValue_1 = Module["_emscripten_bind_FloatArray_getValue_1"] = createExportWrapper("emscripten_bind_FloatArray_getValue_1");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_setValue_2 = Module["_emscripten_bind_FloatArray_setValue_2"] = createExportWrapper("emscripten_bind_FloatArray_setValue_2");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_getPointer_0 = Module["_emscripten_bind_FloatArray_getPointer_0"] = createExportWrapper("emscripten_bind_FloatArray_getPointer_0");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_get_size_0 = Module["_emscripten_bind_FloatArray_get_size_0"] = createExportWrapper("emscripten_bind_FloatArray_get_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray_set_size_1 = Module["_emscripten_bind_FloatArray_set_size_1"] = createExportWrapper("emscripten_bind_FloatArray_set_size_1");
/** @type {function(...*):?} */
var _emscripten_bind_FloatArray___destroy___0 = Module["_emscripten_bind_FloatArray___destroy___0"] = createExportWrapper("emscripten_bind_FloatArray___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_DoubleArray_1 = Module["_emscripten_bind_DoubleArray_DoubleArray_1"] = createExportWrapper("emscripten_bind_DoubleArray_DoubleArray_1");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_resize_1 = Module["_emscripten_bind_DoubleArray_resize_1"] = createExportWrapper("emscripten_bind_DoubleArray_resize_1");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_getValue_1 = Module["_emscripten_bind_DoubleArray_getValue_1"] = createExportWrapper("emscripten_bind_DoubleArray_getValue_1");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_setValue_2 = Module["_emscripten_bind_DoubleArray_setValue_2"] = createExportWrapper("emscripten_bind_DoubleArray_setValue_2");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_getPointer_0 = Module["_emscripten_bind_DoubleArray_getPointer_0"] = createExportWrapper("emscripten_bind_DoubleArray_getPointer_0");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_get_size_0 = Module["_emscripten_bind_DoubleArray_get_size_0"] = createExportWrapper("emscripten_bind_DoubleArray_get_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray_set_size_1 = Module["_emscripten_bind_DoubleArray_set_size_1"] = createExportWrapper("emscripten_bind_DoubleArray_set_size_1");
/** @type {function(...*):?} */
var _emscripten_bind_DoubleArray___destroy___0 = Module["_emscripten_bind_DoubleArray___destroy___0"] = createExportWrapper("emscripten_bind_DoubleArray___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_CharArray_1 = Module["_emscripten_bind_CharArray_CharArray_1"] = createExportWrapper("emscripten_bind_CharArray_CharArray_1");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_resize_1 = Module["_emscripten_bind_CharArray_resize_1"] = createExportWrapper("emscripten_bind_CharArray_resize_1");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_getValue_1 = Module["_emscripten_bind_CharArray_getValue_1"] = createExportWrapper("emscripten_bind_CharArray_getValue_1");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_setValue_2 = Module["_emscripten_bind_CharArray_setValue_2"] = createExportWrapper("emscripten_bind_CharArray_setValue_2");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_getPointer_0 = Module["_emscripten_bind_CharArray_getPointer_0"] = createExportWrapper("emscripten_bind_CharArray_getPointer_0");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_get_size_0 = Module["_emscripten_bind_CharArray_get_size_0"] = createExportWrapper("emscripten_bind_CharArray_get_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray_set_size_1 = Module["_emscripten_bind_CharArray_set_size_1"] = createExportWrapper("emscripten_bind_CharArray_set_size_1");
/** @type {function(...*):?} */
var _emscripten_bind_CharArray___destroy___0 = Module["_emscripten_bind_CharArray___destroy___0"] = createExportWrapper("emscripten_bind_CharArray___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_memcpyIdx_3 = Module["_emscripten_bind_ImHelper_memcpyIdx_3"] = createExportWrapper("emscripten_bind_ImHelper_memcpyIdx_3");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_memcpyVtx_3 = Module["_emscripten_bind_ImHelper_memcpyVtx_3"] = createExportWrapper("emscripten_bind_ImHelper_memcpyVtx_3");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_memcpyFont_5 = Module["_emscripten_bind_ImHelper_memcpyFont_5"] = createExportWrapper("emscripten_bind_ImHelper_memcpyFont_5");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_getTextureId_1 = Module["_emscripten_bind_ImHelper_getTextureId_1"] = createExportWrapper("emscripten_bind_ImHelper_getTextureId_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_setIniFilename_2 = Module["_emscripten_bind_ImHelper_setIniFilename_2"] = createExportWrapper("emscripten_bind_ImHelper_setIniFilename_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper_removeIniFilename_1 = Module["_emscripten_bind_ImHelper_removeIniFilename_1"] = createExportWrapper("emscripten_bind_ImHelper_removeIniFilename_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImHelper___destroy___0 = Module["_emscripten_bind_ImHelper___destroy___0"] = createExportWrapper("emscripten_bind_ImHelper___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_CreateContext_0 = Module["_emscripten_bind_Im_CreateContext_0"] = createExportWrapper("emscripten_bind_Im_CreateContext_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_Begin_1 = Module["_emscripten_bind_Im_Begin_1"] = createExportWrapper("emscripten_bind_Im_Begin_1");
/** @type {function(...*):?} */
var _emscripten_bind_Im_End_0 = Module["_emscripten_bind_Im_End_0"] = createExportWrapper("emscripten_bind_Im_End_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_Render_0 = Module["_emscripten_bind_Im_Render_0"] = createExportWrapper("emscripten_bind_Im_Render_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_NewFrame_0 = Module["_emscripten_bind_Im_NewFrame_0"] = createExportWrapper("emscripten_bind_Im_NewFrame_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_GetDrawData_0 = Module["_emscripten_bind_Im_GetDrawData_0"] = createExportWrapper("emscripten_bind_Im_GetDrawData_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_GetIO_0 = Module["_emscripten_bind_Im_GetIO_0"] = createExportWrapper("emscripten_bind_Im_GetIO_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_SetNextWindowSize_1 = Module["_emscripten_bind_Im_SetNextWindowSize_1"] = createExportWrapper("emscripten_bind_Im_SetNextWindowSize_1");
/** @type {function(...*):?} */
var _emscripten_bind_Im_SetNextWindowSize_2 = Module["_emscripten_bind_Im_SetNextWindowSize_2"] = createExportWrapper("emscripten_bind_Im_SetNextWindowSize_2");
/** @type {function(...*):?} */
var _emscripten_bind_Im_ShowDemoWindow_0 = Module["_emscripten_bind_Im_ShowDemoWindow_0"] = createExportWrapper("emscripten_bind_Im_ShowDemoWindow_0");
/** @type {function(...*):?} */
var _emscripten_bind_Im_ShowDemoWindow_1 = Module["_emscripten_bind_Im_ShowDemoWindow_1"] = createExportWrapper("emscripten_bind_Im_ShowDemoWindow_1");
/** @type {function(...*):?} */
var _emscripten_bind_Im_Checkbox_2 = Module["_emscripten_bind_Im_Checkbox_2"] = createExportWrapper("emscripten_bind_Im_Checkbox_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_ImVec2_0 = Module["_emscripten_bind_ImVec2_ImVec2_0"] = createExportWrapper("emscripten_bind_ImVec2_ImVec2_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_ImVec2_2 = Module["_emscripten_bind_ImVec2_ImVec2_2"] = createExportWrapper("emscripten_bind_ImVec2_ImVec2_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_get_x_0 = Module["_emscripten_bind_ImVec2_get_x_0"] = createExportWrapper("emscripten_bind_ImVec2_get_x_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_set_x_1 = Module["_emscripten_bind_ImVec2_set_x_1"] = createExportWrapper("emscripten_bind_ImVec2_set_x_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_get_y_0 = Module["_emscripten_bind_ImVec2_get_y_0"] = createExportWrapper("emscripten_bind_ImVec2_get_y_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2_set_y_1 = Module["_emscripten_bind_ImVec2_set_y_1"] = createExportWrapper("emscripten_bind_ImVec2_set_y_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec2___destroy___0 = Module["_emscripten_bind_ImVec2___destroy___0"] = createExportWrapper("emscripten_bind_ImVec2___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_ImVec4_0 = Module["_emscripten_bind_ImVec4_ImVec4_0"] = createExportWrapper("emscripten_bind_ImVec4_ImVec4_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_ImVec4_4 = Module["_emscripten_bind_ImVec4_ImVec4_4"] = createExportWrapper("emscripten_bind_ImVec4_ImVec4_4");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_get_x_0 = Module["_emscripten_bind_ImVec4_get_x_0"] = createExportWrapper("emscripten_bind_ImVec4_get_x_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_set_x_1 = Module["_emscripten_bind_ImVec4_set_x_1"] = createExportWrapper("emscripten_bind_ImVec4_set_x_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_get_y_0 = Module["_emscripten_bind_ImVec4_get_y_0"] = createExportWrapper("emscripten_bind_ImVec4_get_y_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_set_y_1 = Module["_emscripten_bind_ImVec4_set_y_1"] = createExportWrapper("emscripten_bind_ImVec4_set_y_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_get_z_0 = Module["_emscripten_bind_ImVec4_get_z_0"] = createExportWrapper("emscripten_bind_ImVec4_get_z_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_set_z_1 = Module["_emscripten_bind_ImVec4_set_z_1"] = createExportWrapper("emscripten_bind_ImVec4_set_z_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_get_w_0 = Module["_emscripten_bind_ImVec4_get_w_0"] = createExportWrapper("emscripten_bind_ImVec4_get_w_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4_set_w_1 = Module["_emscripten_bind_ImVec4_set_w_1"] = createExportWrapper("emscripten_bind_ImVec4_set_w_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImVec4___destroy___0 = Module["_emscripten_bind_ImVec4___destroy___0"] = createExportWrapper("emscripten_bind_ImVec4___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_VecCmdBuffer_getData_1 = Module["_emscripten_bind_VecCmdBuffer_getData_1"] = createExportWrapper("emscripten_bind_VecCmdBuffer_getData_1");
/** @type {function(...*):?} */
var _emscripten_bind_VecCmdBuffer_size_0 = Module["_emscripten_bind_VecCmdBuffer_size_0"] = createExportWrapper("emscripten_bind_VecCmdBuffer_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_VecCmdBuffer___destroy___0 = Module["_emscripten_bind_VecCmdBuffer___destroy___0"] = createExportWrapper("emscripten_bind_VecCmdBuffer___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_VecIdxBuffer_size_0 = Module["_emscripten_bind_VecIdxBuffer_size_0"] = createExportWrapper("emscripten_bind_VecIdxBuffer_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_VecIdxBuffer___destroy___0 = Module["_emscripten_bind_VecIdxBuffer___destroy___0"] = createExportWrapper("emscripten_bind_VecIdxBuffer___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_VecVtxBuffer_size_0 = Module["_emscripten_bind_VecVtxBuffer_size_0"] = createExportWrapper("emscripten_bind_VecVtxBuffer_size_0");
/** @type {function(...*):?} */
var _emscripten_bind_VecVtxBuffer___destroy___0 = Module["_emscripten_bind_VecVtxBuffer___destroy___0"] = createExportWrapper("emscripten_bind_VecVtxBuffer___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_get_ClipRect_0 = Module["_emscripten_bind_ImDrawCmd_get_ClipRect_0"] = createExportWrapper("emscripten_bind_ImDrawCmd_get_ClipRect_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_set_ClipRect_1 = Module["_emscripten_bind_ImDrawCmd_set_ClipRect_1"] = createExportWrapper("emscripten_bind_ImDrawCmd_set_ClipRect_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_get_VtxOffset_0 = Module["_emscripten_bind_ImDrawCmd_get_VtxOffset_0"] = createExportWrapper("emscripten_bind_ImDrawCmd_get_VtxOffset_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_set_VtxOffset_1 = Module["_emscripten_bind_ImDrawCmd_set_VtxOffset_1"] = createExportWrapper("emscripten_bind_ImDrawCmd_set_VtxOffset_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_get_IdxOffset_0 = Module["_emscripten_bind_ImDrawCmd_get_IdxOffset_0"] = createExportWrapper("emscripten_bind_ImDrawCmd_get_IdxOffset_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_set_IdxOffset_1 = Module["_emscripten_bind_ImDrawCmd_set_IdxOffset_1"] = createExportWrapper("emscripten_bind_ImDrawCmd_set_IdxOffset_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_get_ElemCount_0 = Module["_emscripten_bind_ImDrawCmd_get_ElemCount_0"] = createExportWrapper("emscripten_bind_ImDrawCmd_get_ElemCount_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_set_ElemCount_1 = Module["_emscripten_bind_ImDrawCmd_set_ElemCount_1"] = createExportWrapper("emscripten_bind_ImDrawCmd_set_ElemCount_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_get_TextureId_0 = Module["_emscripten_bind_ImDrawCmd_get_TextureId_0"] = createExportWrapper("emscripten_bind_ImDrawCmd_get_TextureId_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd_set_TextureId_1 = Module["_emscripten_bind_ImDrawCmd_set_TextureId_1"] = createExportWrapper("emscripten_bind_ImDrawCmd_set_TextureId_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawCmd___destroy___0 = Module["_emscripten_bind_ImDrawCmd___destroy___0"] = createExportWrapper("emscripten_bind_ImDrawCmd___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_get_pos_0 = Module["_emscripten_bind_ImDrawVert_get_pos_0"] = createExportWrapper("emscripten_bind_ImDrawVert_get_pos_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_set_pos_1 = Module["_emscripten_bind_ImDrawVert_set_pos_1"] = createExportWrapper("emscripten_bind_ImDrawVert_set_pos_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_get_uv_0 = Module["_emscripten_bind_ImDrawVert_get_uv_0"] = createExportWrapper("emscripten_bind_ImDrawVert_get_uv_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_set_uv_1 = Module["_emscripten_bind_ImDrawVert_set_uv_1"] = createExportWrapper("emscripten_bind_ImDrawVert_set_uv_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_get_col_0 = Module["_emscripten_bind_ImDrawVert_get_col_0"] = createExportWrapper("emscripten_bind_ImDrawVert_get_col_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert_set_col_1 = Module["_emscripten_bind_ImDrawVert_set_col_1"] = createExportWrapper("emscripten_bind_ImDrawVert_set_col_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawVert___destroy___0 = Module["_emscripten_bind_ImDrawVert___destroy___0"] = createExportWrapper("emscripten_bind_ImDrawVert___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_CmdListsCount_0 = Module["_emscripten_bind_ImDrawData_get_CmdListsCount_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_CmdListsCount_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_CmdListsCount_1 = Module["_emscripten_bind_ImDrawData_set_CmdListsCount_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_CmdListsCount_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_TotalIdxCount_0 = Module["_emscripten_bind_ImDrawData_get_TotalIdxCount_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_TotalIdxCount_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_TotalIdxCount_1 = Module["_emscripten_bind_ImDrawData_set_TotalIdxCount_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_TotalIdxCount_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_TotalVtxCount_0 = Module["_emscripten_bind_ImDrawData_get_TotalVtxCount_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_TotalVtxCount_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_TotalVtxCount_1 = Module["_emscripten_bind_ImDrawData_set_TotalVtxCount_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_TotalVtxCount_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_CmdLists_1 = Module["_emscripten_bind_ImDrawData_get_CmdLists_1"] = createExportWrapper("emscripten_bind_ImDrawData_get_CmdLists_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_CmdLists_2 = Module["_emscripten_bind_ImDrawData_set_CmdLists_2"] = createExportWrapper("emscripten_bind_ImDrawData_set_CmdLists_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_DisplayPos_0 = Module["_emscripten_bind_ImDrawData_get_DisplayPos_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_DisplayPos_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_DisplayPos_1 = Module["_emscripten_bind_ImDrawData_set_DisplayPos_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_DisplayPos_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_DisplaySize_0 = Module["_emscripten_bind_ImDrawData_get_DisplaySize_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_DisplaySize_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_DisplaySize_1 = Module["_emscripten_bind_ImDrawData_set_DisplaySize_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_DisplaySize_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_get_FramebufferScale_0 = Module["_emscripten_bind_ImDrawData_get_FramebufferScale_0"] = createExportWrapper("emscripten_bind_ImDrawData_get_FramebufferScale_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData_set_FramebufferScale_1 = Module["_emscripten_bind_ImDrawData_set_FramebufferScale_1"] = createExportWrapper("emscripten_bind_ImDrawData_set_FramebufferScale_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawData___destroy___0 = Module["_emscripten_bind_ImDrawData___destroy___0"] = createExportWrapper("emscripten_bind_ImDrawData___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_get_CmdBuffer_0 = Module["_emscripten_bind_ImDrawList_get_CmdBuffer_0"] = createExportWrapper("emscripten_bind_ImDrawList_get_CmdBuffer_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_set_CmdBuffer_1 = Module["_emscripten_bind_ImDrawList_set_CmdBuffer_1"] = createExportWrapper("emscripten_bind_ImDrawList_set_CmdBuffer_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_get_IdxBuffer_0 = Module["_emscripten_bind_ImDrawList_get_IdxBuffer_0"] = createExportWrapper("emscripten_bind_ImDrawList_get_IdxBuffer_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_set_IdxBuffer_1 = Module["_emscripten_bind_ImDrawList_set_IdxBuffer_1"] = createExportWrapper("emscripten_bind_ImDrawList_set_IdxBuffer_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_get_VtxBuffer_0 = Module["_emscripten_bind_ImDrawList_get_VtxBuffer_0"] = createExportWrapper("emscripten_bind_ImDrawList_get_VtxBuffer_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList_set_VtxBuffer_1 = Module["_emscripten_bind_ImDrawList_set_VtxBuffer_1"] = createExportWrapper("emscripten_bind_ImDrawList_set_VtxBuffer_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImDrawList___destroy___0 = Module["_emscripten_bind_ImDrawList___destroy___0"] = createExportWrapper("emscripten_bind_ImDrawList___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_AddMouseWheelEvent_2 = Module["_emscripten_bind_ImGuiIO_AddMouseWheelEvent_2"] = createExportWrapper("emscripten_bind_ImGuiIO_AddMouseWheelEvent_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_AddMouseButtonEvent_2 = Module["_emscripten_bind_ImGuiIO_AddMouseButtonEvent_2"] = createExportWrapper("emscripten_bind_ImGuiIO_AddMouseButtonEvent_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_AddMousePosEvent_2 = Module["_emscripten_bind_ImGuiIO_AddMousePosEvent_2"] = createExportWrapper("emscripten_bind_ImGuiIO_AddMousePosEvent_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_AddKeyEvent_2 = Module["_emscripten_bind_ImGuiIO_AddKeyEvent_2"] = createExportWrapper("emscripten_bind_ImGuiIO_AddKeyEvent_2");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_AddInputCharacter_1 = Module["_emscripten_bind_ImGuiIO_AddInputCharacter_1"] = createExportWrapper("emscripten_bind_ImGuiIO_AddInputCharacter_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_get_WantCaptureMouse_0 = Module["_emscripten_bind_ImGuiIO_get_WantCaptureMouse_0"] = createExportWrapper("emscripten_bind_ImGuiIO_get_WantCaptureMouse_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_set_WantCaptureMouse_1 = Module["_emscripten_bind_ImGuiIO_set_WantCaptureMouse_1"] = createExportWrapper("emscripten_bind_ImGuiIO_set_WantCaptureMouse_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_get_DisplaySize_0 = Module["_emscripten_bind_ImGuiIO_get_DisplaySize_0"] = createExportWrapper("emscripten_bind_ImGuiIO_get_DisplaySize_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_set_DisplaySize_1 = Module["_emscripten_bind_ImGuiIO_set_DisplaySize_1"] = createExportWrapper("emscripten_bind_ImGuiIO_set_DisplaySize_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_get_DisplayFramebufferScale_0 = Module["_emscripten_bind_ImGuiIO_get_DisplayFramebufferScale_0"] = createExportWrapper("emscripten_bind_ImGuiIO_get_DisplayFramebufferScale_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_set_DisplayFramebufferScale_1 = Module["_emscripten_bind_ImGuiIO_set_DisplayFramebufferScale_1"] = createExportWrapper("emscripten_bind_ImGuiIO_set_DisplayFramebufferScale_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_get_DeltaTime_0 = Module["_emscripten_bind_ImGuiIO_get_DeltaTime_0"] = createExportWrapper("emscripten_bind_ImGuiIO_get_DeltaTime_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_set_DeltaTime_1 = Module["_emscripten_bind_ImGuiIO_set_DeltaTime_1"] = createExportWrapper("emscripten_bind_ImGuiIO_set_DeltaTime_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_get_Fonts_0 = Module["_emscripten_bind_ImGuiIO_get_Fonts_0"] = createExportWrapper("emscripten_bind_ImGuiIO_get_Fonts_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO_set_Fonts_1 = Module["_emscripten_bind_ImGuiIO_set_Fonts_1"] = createExportWrapper("emscripten_bind_ImGuiIO_set_Fonts_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImGuiIO___destroy___0 = Module["_emscripten_bind_ImGuiIO___destroy___0"] = createExportWrapper("emscripten_bind_ImGuiIO___destroy___0");
/** @type {function(...*):?} */
var _emscripten_bind_ImFontAtlas_get_TexID_0 = Module["_emscripten_bind_ImFontAtlas_get_TexID_0"] = createExportWrapper("emscripten_bind_ImFontAtlas_get_TexID_0");
/** @type {function(...*):?} */
var _emscripten_bind_ImFontAtlas_set_TexID_1 = Module["_emscripten_bind_ImFontAtlas_set_TexID_1"] = createExportWrapper("emscripten_bind_ImFontAtlas_set_TexID_1");
/** @type {function(...*):?} */
var _emscripten_bind_ImFontAtlas___destroy___0 = Module["_emscripten_bind_ImFontAtlas___destroy___0"] = createExportWrapper("emscripten_bind_ImFontAtlas___destroy___0");
/** @type {function(...*):?} */
var _emscripten_enum_ImGuiKey_ImGuiKey_None = Module["_emscripten_enum_ImGuiKey_ImGuiKey_None"] = createExportWrapper("emscripten_enum_ImGuiKey_ImGuiKey_None");
/** @type {function(...*):?} */
var _fflush = Module["_fflush"] = createExportWrapper("fflush");
/** @type {function(...*):?} */
var _malloc = Module["_malloc"] = createExportWrapper("malloc");
/** @type {function(...*):?} */
var _free = Module["_free"] = createExportWrapper("free");
/** @type {function(...*):?} */
var ___errno_location = createExportWrapper("__errno_location");
/** @type {function(...*):?} */
var _emscripten_stack_init = function() {
  return (_emscripten_stack_init = Module["asm"]["emscripten_stack_init"]).apply(null, arguments);
};

/** @type {function(...*):?} */
var _emscripten_stack_get_free = function() {
  return (_emscripten_stack_get_free = Module["asm"]["emscripten_stack_get_free"]).apply(null, arguments);
};

/** @type {function(...*):?} */
var _emscripten_stack_get_base = function() {
  return (_emscripten_stack_get_base = Module["asm"]["emscripten_stack_get_base"]).apply(null, arguments);
};

/** @type {function(...*):?} */
var _emscripten_stack_get_end = function() {
  return (_emscripten_stack_get_end = Module["asm"]["emscripten_stack_get_end"]).apply(null, arguments);
};

/** @type {function(...*):?} */
var stackSave = createExportWrapper("stackSave");
/** @type {function(...*):?} */
var stackRestore = createExportWrapper("stackRestore");
/** @type {function(...*):?} */
var stackAlloc = createExportWrapper("stackAlloc");
/** @type {function(...*):?} */
var _emscripten_stack_get_current = function() {
  return (_emscripten_stack_get_current = Module["asm"]["emscripten_stack_get_current"]).apply(null, arguments);
};

/** @type {function(...*):?} */
var dynCall_jiji = Module["dynCall_jiji"] = createExportWrapper("dynCall_jiji");
var ___start_em_js = Module['___start_em_js'] = 188544;
var ___stop_em_js = Module['___stop_em_js'] = 188642;

// include: postamble.js
// === Auto-generated postamble setup entry stuff ===

Module["UTF8ToString"] = UTF8ToString;
var missingLibrarySymbols = [
  'zeroMemory',
  'stringToNewUTF8',
  'exitJS',
  'inetPton4',
  'inetNtop4',
  'inetPton6',
  'inetNtop6',
  'readSockaddr',
  'writeSockaddr',
  'getHostByName',
  'getRandomDevice',
  'traverseStack',
  'convertPCtoSourceLocation',
  'readEmAsmArgs',
  'jstoi_q',
  'jstoi_s',
  'getExecutableName',
  'listenOnce',
  'autoResumeAudioContext',
  'dynCallLegacy',
  'getDynCaller',
  'dynCall',
  'handleException',
  'runtimeKeepalivePush',
  'runtimeKeepalivePop',
  'callUserCallback',
  'maybeExit',
  'safeSetTimeout',
  'asmjsMangle',
  'asyncLoad',
  'alignMemory',
  'mmapAlloc',
  'handleAllocator',
  'getNativeTypeSize',
  'STACK_SIZE',
  'STACK_ALIGN',
  'POINTER_SIZE',
  'ASSERTIONS',
  'writeI53ToI64',
  'writeI53ToI64Clamped',
  'writeI53ToI64Signaling',
  'writeI53ToU64Clamped',
  'writeI53ToU64Signaling',
  'readI53FromI64',
  'readI53FromU64',
  'convertI32PairToI53',
  'convertU32PairToI53',
  'getCFunc',
  'ccall',
  'cwrap',
  'uleb128Encode',
  'sigToWasmTypes',
  'generateFuncType',
  'convertJsFunctionToWasm',
  'getEmptyTableSlot',
  'updateTableMap',
  'getFunctionAddress',
  'addFunction',
  'removeFunction',
  'reallyNegative',
  'unSign',
  'strLen',
  'reSign',
  'formatString',
  'intArrayToString',
  'AsciiToString',
  'stringToAscii',
  'UTF16ToString',
  'stringToUTF16',
  'lengthBytesUTF16',
  'UTF32ToString',
  'stringToUTF32',
  'lengthBytesUTF32',
  'allocateUTF8',
  'allocateUTF8OnStack',
  'writeStringToMemory',
  'writeArrayToMemory',
  'writeAsciiToMemory',
  'getSocketFromFD',
  'getSocketAddress',
  'registerKeyEventCallback',
  'maybeCStringToJsString',
  'findEventTarget',
  'findCanvasEventTarget',
  'getBoundingClientRect',
  'fillMouseEventData',
  'registerMouseEventCallback',
  'registerWheelEventCallback',
  'registerUiEventCallback',
  'registerFocusEventCallback',
  'fillDeviceOrientationEventData',
  'registerDeviceOrientationEventCallback',
  'fillDeviceMotionEventData',
  'registerDeviceMotionEventCallback',
  'screenOrientation',
  'fillOrientationChangeEventData',
  'registerOrientationChangeEventCallback',
  'fillFullscreenChangeEventData',
  'registerFullscreenChangeEventCallback',
  'JSEvents_requestFullscreen',
  'JSEvents_resizeCanvasForFullscreen',
  'registerRestoreOldStyle',
  'hideEverythingExceptGivenElement',
  'restoreHiddenElements',
  'setLetterbox',
  'softFullscreenResizeWebGLRenderTarget',
  'doRequestFullscreen',
  'fillPointerlockChangeEventData',
  'registerPointerlockChangeEventCallback',
  'registerPointerlockErrorEventCallback',
  'requestPointerLock',
  'fillVisibilityChangeEventData',
  'registerVisibilityChangeEventCallback',
  'registerTouchEventCallback',
  'fillGamepadEventData',
  'registerGamepadEventCallback',
  'registerBeforeUnloadEventCallback',
  'fillBatteryEventData',
  'battery',
  'registerBatteryEventCallback',
  'setCanvasElementSize',
  'getCanvasElementSize',
  'demangle',
  'demangleAll',
  'jsStackTrace',
  'stackTrace',
  'getEnvStrings',
  'checkWasiClock',
  'createDyncallWrapper',
  'setImmediateWrapped',
  'clearImmediateWrapped',
  'polyfillSetImmediate',
  'newNativePromise',
  'getPromise',
  'ExceptionInfo',
  'exception_addRef',
  'exception_decRef',
  'setMainLoop',
  'heapObjectForWebGLType',
  'heapAccessShiftForWebGLHeap',
  'emscriptenWebGLGet',
  'computeUnpackAlignedImageSize',
  'emscriptenWebGLGetTexPixelData',
  'emscriptenWebGLGetUniform',
  'webglGetUniformLocation',
  'webglPrepareUniformLocationsBeforeFirstUse',
  'webglGetLeftBracePos',
  'emscriptenWebGLGetVertexAttrib',
  'writeGLArray',
  'SDL_unicode',
  'SDL_ttfContext',
  'SDL_audio',
  'GLFW_Window',
  'runAndAbortIfError',
  'ALLOC_NORMAL',
  'ALLOC_STACK',
  'allocate',
];
missingLibrarySymbols.forEach(missingLibrarySymbol)

var unexportedSymbols = [
  'run',
  'UTF8ArrayToString',
  'stringToUTF8Array',
  'stringToUTF8',
  'lengthBytesUTF8',
  'addOnPreRun',
  'addOnInit',
  'addOnPreMain',
  'addOnExit',
  'addOnPostRun',
  'addRunDependency',
  'removeRunDependency',
  'FS_createFolder',
  'FS_createPath',
  'FS_createDataFile',
  'FS_createPreloadedFile',
  'FS_createLazyFile',
  'FS_createLink',
  'FS_createDevice',
  'FS_unlink',
  'out',
  'err',
  'callMain',
  'abort',
  'keepRuntimeAlive',
  'wasmMemory',
  'stackAlloc',
  'stackSave',
  'stackRestore',
  'getTempRet0',
  'setTempRet0',
  'writeStackCookie',
  'checkStackCookie',
  'ptrToString',
  'getHeapMax',
  'emscripten_realloc_buffer',
  'ENV',
  'ERRNO_CODES',
  'ERRNO_MESSAGES',
  'setErrNo',
  'DNS',
  'Protocols',
  'Sockets',
  'timers',
  'warnOnce',
  'UNWIND_CACHE',
  'readEmAsmArgsArray',
  'convertI32PairToI53Checked',
  'freeTableIndexes',
  'functionsInTableMap',
  'setValue',
  'getValue',
  'PATH',
  'PATH_FS',
  'intArrayFromString',
  'UTF16Decoder',
  'SYSCALLS',
  'JSEvents',
  'specialHTMLTargets',
  'currentFullscreenStrategy',
  'restoreOldWindowedStyle',
  'ExitStatus',
  'flush_NO_FILESYSTEM',
  'dlopenMissingError',
  'promiseMap',
  'uncaughtExceptionCount',
  'exceptionLast',
  'exceptionCaught',
  'Browser',
  'wget',
  'tempFixedLengthArray',
  'miniTempWebGLFloatBuffers',
  'GL',
  'AL',
  'SDL',
  'SDL_gfx',
  'GLUT',
  'EGL',
  'GLFW',
  'GLEW',
  'IDBStore',
];
unexportedSymbols.forEach(unexportedRuntimeSymbol);



var calledRun;

dependenciesFulfilled = function runCaller() {
  // If run has never been called, and we should call run (INVOKE_RUN is true, and Module.noInitialRun is not false)
  if (!calledRun) run();
  if (!calledRun) dependenciesFulfilled = runCaller; // try this again later, after new deps are fulfilled
};

function stackCheckInit() {
  // This is normally called automatically during __wasm_call_ctors but need to
  // get these values before even running any of the ctors so we call it redundantly
  // here.
  _emscripten_stack_init();
  // TODO(sbc): Move writeStackCookie to native to to avoid this.
  writeStackCookie();
}

/** @type {function(Array=)} */
function run() {

  if (runDependencies > 0) {
    return;
  }

    stackCheckInit();

  preRun();

  // a preRun added a dependency, run will be called later
  if (runDependencies > 0) {
    return;
  }

  function doRun() {
    // run may have just been called through dependencies being fulfilled just in this very frame,
    // or while the async setStatus time below was happening
    if (calledRun) return;
    calledRun = true;
    Module['calledRun'] = true;

    if (ABORT) return;

    initRuntime();

    readyPromiseResolve(Module);
    if (Module['onRuntimeInitialized']) Module['onRuntimeInitialized']();

    assert(!Module['_main'], 'compiled without a main, but one is present. if you added it from JS, use Module["onRuntimeInitialized"]');

    postRun();
  }

  if (Module['setStatus']) {
    Module['setStatus']('Running...');
    setTimeout(function() {
      setTimeout(function() {
        Module['setStatus']('');
      }, 1);
      doRun();
    }, 1);
  } else
  {
    doRun();
  }
  checkStackCookie();
}

function checkUnflushedContent() {
  // Compiler settings do not allow exiting the runtime, so flushing
  // the streams is not possible. but in ASSERTIONS mode we check
  // if there was something to flush, and if so tell the user they
  // should request that the runtime be exitable.
  // Normally we would not even include flush() at all, but in ASSERTIONS
  // builds we do so just for this check, and here we see if there is any
  // content to flush, that is, we check if there would have been
  // something a non-ASSERTIONS build would have not seen.
  // How we flush the streams depends on whether we are in SYSCALLS_REQUIRE_FILESYSTEM=0
  // mode (which has its own special function for this; otherwise, all
  // the code is inside libc)
  var oldOut = out;
  var oldErr = err;
  var has = false;
  out = err = (x) => {
    has = true;
  }
  try { // it doesn't matter if it fails
    flush_NO_FILESYSTEM();
  } catch(e) {}
  out = oldOut;
  err = oldErr;
  if (has) {
    warnOnce('stdio streams had content in them that was not flushed. you should set EXIT_RUNTIME to 1 (see the FAQ), or make sure to emit a newline when you printf etc.');
    warnOnce('(this may also be due to not including full filesystem support - try building with -sFORCE_FILESYSTEM)');
  }
}

if (Module['preInit']) {
  if (typeof Module['preInit'] == 'function') Module['preInit'] = [Module['preInit']];
  while (Module['preInit'].length > 0) {
    Module['preInit'].pop()();
  }
}

run();


// end include: postamble.js
// include: D:\Dev\Projects\java\jDear-imgui\imgui\imgui-cpp\imgui-cpp\build\emscripten\glue.js

// Bindings utilities

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function WrapperObject() {
}
WrapperObject.prototype = Object.create(WrapperObject.prototype);
WrapperObject.prototype.constructor = WrapperObject;
WrapperObject.prototype.__class__ = WrapperObject;
WrapperObject.__cache__ = {};
Module['WrapperObject'] = WrapperObject;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant)
    @param {*=} __class__ */
function getCache(__class__) {
  return (__class__ || WrapperObject).__cache__;
}
Module['getCache'] = getCache;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant)
    @param {*=} __class__ */
function wrapPointer(ptr, __class__) {
  var cache = getCache(__class__);
  var ret = cache[ptr];
  if (ret) return ret;
  ret = Object.create((__class__ || WrapperObject).prototype);
  ret.ptr = ptr;
  return cache[ptr] = ret;
}
Module['wrapPointer'] = wrapPointer;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function castObject(obj, __class__) {
  return wrapPointer(obj.ptr, __class__);
}
Module['castObject'] = castObject;

Module['NULL'] = wrapPointer(0);

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function destroy(obj) {
  if (!obj['__destroy__']) throw 'Error: Cannot destroy object. (Did you create it yourself?)';
  obj['__destroy__']();
  // Remove from cache, so the object can be GC'd and refs added onto it released
  delete getCache(obj.__class__)[obj.ptr];
}
Module['destroy'] = destroy;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function compare(obj1, obj2) {
  return obj1.ptr === obj2.ptr;
}
Module['compare'] = compare;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function getPointer(obj) {
  return obj.ptr;
}
Module['getPointer'] = getPointer;

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function getClass(obj) {
  return obj.__class__;
}
Module['getClass'] = getClass;

// Converts big (string or array) values into a C-style storage, in temporary space

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
var ensureCache = {
  buffer: 0,  // the main buffer of temporary storage
  size: 0,   // the size of buffer
  pos: 0,    // the next free offset in buffer
  temps: [], // extra allocations
  needed: 0, // the total size we need next time

  prepare: function() {
    if (ensureCache.needed) {
      // clear the temps
      for (var i = 0; i < ensureCache.temps.length; i++) {
        Module['_free'](ensureCache.temps[i]);
      }
      ensureCache.temps.length = 0;
      // prepare to allocate a bigger buffer
      Module['_free'](ensureCache.buffer);
      ensureCache.buffer = 0;
      ensureCache.size += ensureCache.needed;
      // clean up
      ensureCache.needed = 0;
    }
    if (!ensureCache.buffer) { // happens first time, or when we need to grow
      ensureCache.size += 128; // heuristic, avoid many small grow events
      ensureCache.buffer = Module['_malloc'](ensureCache.size);
      assert(ensureCache.buffer);
    }
    ensureCache.pos = 0;
  },
  alloc: function(array, view) {
    assert(ensureCache.buffer);
    var bytes = view.BYTES_PER_ELEMENT;
    var len = array.length * bytes;
    len = (len + 7) & -8; // keep things aligned to 8 byte boundaries
    var ret;
    if (ensureCache.pos + len >= ensureCache.size) {
      // we failed to allocate in the buffer, ensureCache time around :(
      assert(len > 0); // null terminator, at least
      ensureCache.needed += len;
      ret = Module['_malloc'](len);
      ensureCache.temps.push(ret);
    } else {
      // we can allocate in the buffer
      ret = ensureCache.buffer + ensureCache.pos;
      ensureCache.pos += len;
    }
    return ret;
  },
  copy: function(array, view, offset) {
    offset >>>= 0;
    var bytes = view.BYTES_PER_ELEMENT;
    switch (bytes) {
      case 2: offset >>>= 1; break;
      case 4: offset >>>= 2; break;
      case 8: offset >>>= 3; break;
    }
    for (var i = 0; i < array.length; i++) {
      view[offset + i] = array[i];
    }
  },
};

/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureString(value) {
  if (typeof value === 'string') {
    var intArray = intArrayFromString(value);
    var offset = ensureCache.alloc(intArray, HEAP8);
    ensureCache.copy(intArray, HEAP8, offset);
    return offset;
  }
  return value;
}
/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureInt8(value) {
  if (typeof value === 'object') {
    var offset = ensureCache.alloc(value, HEAP8);
    ensureCache.copy(value, HEAP8, offset);
    return offset;
  }
  return value;
}
/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureInt16(value) {
  if (typeof value === 'object') {
    var offset = ensureCache.alloc(value, HEAP16);
    ensureCache.copy(value, HEAP16, offset);
    return offset;
  }
  return value;
}
/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureInt32(value) {
  if (typeof value === 'object') {
    var offset = ensureCache.alloc(value, HEAP32);
    ensureCache.copy(value, HEAP32, offset);
    return offset;
  }
  return value;
}
/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureFloat32(value) {
  if (typeof value === 'object') {
    var offset = ensureCache.alloc(value, HEAPF32);
    ensureCache.copy(value, HEAPF32, offset);
    return offset;
  }
  return value;
}
/** @suppress {duplicate} (TODO: avoid emitting this multiple times, it is redundant) */
function ensureFloat64(value) {
  if (typeof value === 'object') {
    var offset = ensureCache.alloc(value, HEAPF64);
    ensureCache.copy(value, HEAPF64, offset);
    return offset;
  }
  return value;
}

// VoidPtr
/** @suppress {undefinedVars, duplicate} @this{Object} */function VoidPtr() { throw "cannot construct a VoidPtr, no constructor in IDL" }
VoidPtr.prototype = Object.create(WrapperObject.prototype);
VoidPtr.prototype.constructor = VoidPtr;
VoidPtr.prototype.__class__ = VoidPtr;
VoidPtr.__cache__ = {};
Module['VoidPtr'] = VoidPtr;

  VoidPtr.prototype['__destroy__'] = VoidPtr.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_VoidPtr___destroy___0(self);
};
// BoolArray
/** @suppress {undefinedVars, duplicate} @this{Object} */function BoolArray(size) {
  if (size && typeof size === 'object') size = size.ptr;
  this.ptr = _emscripten_bind_BoolArray_BoolArray_1(size);
  getCache(BoolArray)[this.ptr] = this;
};;
BoolArray.prototype = Object.create(WrapperObject.prototype);
BoolArray.prototype.constructor = BoolArray;
BoolArray.prototype.__class__ = BoolArray;
BoolArray.__cache__ = {};
Module['BoolArray'] = BoolArray;

BoolArray.prototype['resize'] = BoolArray.prototype.resize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  _emscripten_bind_BoolArray_resize_1(self, size);
};;

BoolArray.prototype['getValue'] = BoolArray.prototype.getValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return !!(_emscripten_bind_BoolArray_getValue_1(self, index));
};;

BoolArray.prototype['setValue'] = BoolArray.prototype.setValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index, value) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  if (value && typeof value === 'object') value = value.ptr;
  _emscripten_bind_BoolArray_setValue_2(self, index, value);
};;

BoolArray.prototype['getPointer'] = BoolArray.prototype.getPointer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_BoolArray_getPointer_0(self);
};;

  BoolArray.prototype['get_size'] = BoolArray.prototype.get_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_BoolArray_get_size_0(self);
};
    BoolArray.prototype['set_size'] = BoolArray.prototype.set_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_BoolArray_set_size_1(self, arg0);
};
    Object.defineProperty(BoolArray.prototype, 'size', { get: BoolArray.prototype.get_size, set: BoolArray.prototype.set_size });
  BoolArray.prototype['__destroy__'] = BoolArray.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_BoolArray___destroy___0(self);
};
// IntArray
/** @suppress {undefinedVars, duplicate} @this{Object} */function IntArray(size) {
  if (size && typeof size === 'object') size = size.ptr;
  this.ptr = _emscripten_bind_IntArray_IntArray_1(size);
  getCache(IntArray)[this.ptr] = this;
};;
IntArray.prototype = Object.create(WrapperObject.prototype);
IntArray.prototype.constructor = IntArray;
IntArray.prototype.__class__ = IntArray;
IntArray.__cache__ = {};
Module['IntArray'] = IntArray;

IntArray.prototype['resize'] = IntArray.prototype.resize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  _emscripten_bind_IntArray_resize_1(self, size);
};;

IntArray.prototype['getValue'] = IntArray.prototype.getValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return _emscripten_bind_IntArray_getValue_1(self, index);
};;

IntArray.prototype['setValue'] = IntArray.prototype.setValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index, value) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  if (value && typeof value === 'object') value = value.ptr;
  _emscripten_bind_IntArray_setValue_2(self, index, value);
};;

IntArray.prototype['getPointer'] = IntArray.prototype.getPointer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_IntArray_getPointer_0(self);
};;

  IntArray.prototype['get_size'] = IntArray.prototype.get_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_IntArray_get_size_0(self);
};
    IntArray.prototype['set_size'] = IntArray.prototype.set_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_IntArray_set_size_1(self, arg0);
};
    Object.defineProperty(IntArray.prototype, 'size', { get: IntArray.prototype.get_size, set: IntArray.prototype.set_size });
  IntArray.prototype['__destroy__'] = IntArray.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_IntArray___destroy___0(self);
};
// FloatArray
/** @suppress {undefinedVars, duplicate} @this{Object} */function FloatArray(size) {
  if (size && typeof size === 'object') size = size.ptr;
  this.ptr = _emscripten_bind_FloatArray_FloatArray_1(size);
  getCache(FloatArray)[this.ptr] = this;
};;
FloatArray.prototype = Object.create(WrapperObject.prototype);
FloatArray.prototype.constructor = FloatArray;
FloatArray.prototype.__class__ = FloatArray;
FloatArray.__cache__ = {};
Module['FloatArray'] = FloatArray;

FloatArray.prototype['resize'] = FloatArray.prototype.resize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  _emscripten_bind_FloatArray_resize_1(self, size);
};;

FloatArray.prototype['getValue'] = FloatArray.prototype.getValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return _emscripten_bind_FloatArray_getValue_1(self, index);
};;

FloatArray.prototype['setValue'] = FloatArray.prototype.setValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index, value) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  if (value && typeof value === 'object') value = value.ptr;
  _emscripten_bind_FloatArray_setValue_2(self, index, value);
};;

FloatArray.prototype['getPointer'] = FloatArray.prototype.getPointer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_FloatArray_getPointer_0(self);
};;

  FloatArray.prototype['get_size'] = FloatArray.prototype.get_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_FloatArray_get_size_0(self);
};
    FloatArray.prototype['set_size'] = FloatArray.prototype.set_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_FloatArray_set_size_1(self, arg0);
};
    Object.defineProperty(FloatArray.prototype, 'size', { get: FloatArray.prototype.get_size, set: FloatArray.prototype.set_size });
  FloatArray.prototype['__destroy__'] = FloatArray.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_FloatArray___destroy___0(self);
};
// DoubleArray
/** @suppress {undefinedVars, duplicate} @this{Object} */function DoubleArray(size) {
  if (size && typeof size === 'object') size = size.ptr;
  this.ptr = _emscripten_bind_DoubleArray_DoubleArray_1(size);
  getCache(DoubleArray)[this.ptr] = this;
};;
DoubleArray.prototype = Object.create(WrapperObject.prototype);
DoubleArray.prototype.constructor = DoubleArray;
DoubleArray.prototype.__class__ = DoubleArray;
DoubleArray.__cache__ = {};
Module['DoubleArray'] = DoubleArray;

DoubleArray.prototype['resize'] = DoubleArray.prototype.resize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  _emscripten_bind_DoubleArray_resize_1(self, size);
};;

DoubleArray.prototype['getValue'] = DoubleArray.prototype.getValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return _emscripten_bind_DoubleArray_getValue_1(self, index);
};;

DoubleArray.prototype['setValue'] = DoubleArray.prototype.setValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index, value) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  if (value && typeof value === 'object') value = value.ptr;
  _emscripten_bind_DoubleArray_setValue_2(self, index, value);
};;

DoubleArray.prototype['getPointer'] = DoubleArray.prototype.getPointer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_DoubleArray_getPointer_0(self);
};;

  DoubleArray.prototype['get_size'] = DoubleArray.prototype.get_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_DoubleArray_get_size_0(self);
};
    DoubleArray.prototype['set_size'] = DoubleArray.prototype.set_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_DoubleArray_set_size_1(self, arg0);
};
    Object.defineProperty(DoubleArray.prototype, 'size', { get: DoubleArray.prototype.get_size, set: DoubleArray.prototype.set_size });
  DoubleArray.prototype['__destroy__'] = DoubleArray.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_DoubleArray___destroy___0(self);
};
// CharArray
/** @suppress {undefinedVars, duplicate} @this{Object} */function CharArray(size) {
  if (size && typeof size === 'object') size = size.ptr;
  this.ptr = _emscripten_bind_CharArray_CharArray_1(size);
  getCache(CharArray)[this.ptr] = this;
};;
CharArray.prototype = Object.create(WrapperObject.prototype);
CharArray.prototype.constructor = CharArray;
CharArray.prototype.__class__ = CharArray;
CharArray.__cache__ = {};
Module['CharArray'] = CharArray;

CharArray.prototype['resize'] = CharArray.prototype.resize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  _emscripten_bind_CharArray_resize_1(self, size);
};;

CharArray.prototype['getValue'] = CharArray.prototype.getValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return _emscripten_bind_CharArray_getValue_1(self, index);
};;

CharArray.prototype['setValue'] = CharArray.prototype.setValue = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index, value) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  if (value && typeof value === 'object') value = value.ptr;
  _emscripten_bind_CharArray_setValue_2(self, index, value);
};;

CharArray.prototype['getPointer'] = CharArray.prototype.getPointer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_CharArray_getPointer_0(self);
};;

  CharArray.prototype['get_size'] = CharArray.prototype.get_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_CharArray_get_size_0(self);
};
    CharArray.prototype['set_size'] = CharArray.prototype.set_size = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_CharArray_set_size_1(self, arg0);
};
    Object.defineProperty(CharArray.prototype, 'size', { get: CharArray.prototype.get_size, set: CharArray.prototype.set_size });
  CharArray.prototype['__destroy__'] = CharArray.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_CharArray___destroy___0(self);
};
// ImHelper
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImHelper() { throw "cannot construct a ImHelper, no constructor in IDL" }
ImHelper.prototype = Object.create(WrapperObject.prototype);
ImHelper.prototype.constructor = ImHelper;
ImHelper.prototype.__class__ = ImHelper;
ImHelper.__cache__ = {};
Module['ImHelper'] = ImHelper;

ImHelper.prototype['memcpyIdx'] = ImHelper.prototype.memcpyIdx = /** @suppress {undefinedVars, duplicate} @this{Object} */function(destination, drawList, num) {
  var self = this.ptr;
  if (destination && typeof destination === 'object') destination = destination.ptr;
  if (drawList && typeof drawList === 'object') drawList = drawList.ptr;
  if (num && typeof num === 'object') num = num.ptr;
  _emscripten_bind_ImHelper_memcpyIdx_3(self, destination, drawList, num);
};;

ImHelper.prototype['memcpyVtx'] = ImHelper.prototype.memcpyVtx = /** @suppress {undefinedVars, duplicate} @this{Object} */function(destination, drawList, num) {
  var self = this.ptr;
  if (destination && typeof destination === 'object') destination = destination.ptr;
  if (drawList && typeof drawList === 'object') drawList = drawList.ptr;
  if (num && typeof num === 'object') num = num.ptr;
  _emscripten_bind_ImHelper_memcpyVtx_3(self, destination, drawList, num);
};;

ImHelper.prototype['memcpyFont'] = ImHelper.prototype.memcpyFont = /** @suppress {undefinedVars, duplicate} @this{Object} */function(io, pixelBuffer, widthData, heightData, bytesPerPixel) {
  var self = this.ptr;
  ensureCache.prepare();
  if (io && typeof io === 'object') io = io.ptr;
  if (pixelBuffer && typeof pixelBuffer === 'object') pixelBuffer = pixelBuffer.ptr;
  if (typeof widthData == 'object') { widthData = ensureInt32(widthData); }
  if (typeof heightData == 'object') { heightData = ensureInt32(heightData); }
  if (typeof bytesPerPixel == 'object') { bytesPerPixel = ensureInt32(bytesPerPixel); }
  _emscripten_bind_ImHelper_memcpyFont_5(self, io, pixelBuffer, widthData, heightData, bytesPerPixel);
};;

ImHelper.prototype['getTextureId'] = ImHelper.prototype.getTextureId = /** @suppress {undefinedVars, duplicate} @this{Object} */function(imDrawCmd) {
  var self = this.ptr;
  if (imDrawCmd && typeof imDrawCmd === 'object') imDrawCmd = imDrawCmd.ptr;
  return _emscripten_bind_ImHelper_getTextureId_1(self, imDrawCmd);
};;

ImHelper.prototype['setIniFilename'] = ImHelper.prototype.setIniFilename = /** @suppress {undefinedVars, duplicate} @this{Object} */function(io, fileName) {
  var self = this.ptr;
  ensureCache.prepare();
  if (io && typeof io === 'object') io = io.ptr;
  if (typeof fileName == 'object') { fileName = ensureInt8(fileName); }
  _emscripten_bind_ImHelper_setIniFilename_2(self, io, fileName);
};;

ImHelper.prototype['removeIniFilename'] = ImHelper.prototype.removeIniFilename = /** @suppress {undefinedVars, duplicate} @this{Object} */function(io) {
  var self = this.ptr;
  if (io && typeof io === 'object') io = io.ptr;
  _emscripten_bind_ImHelper_removeIniFilename_1(self, io);
};;

  ImHelper.prototype['__destroy__'] = ImHelper.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImHelper___destroy___0(self);
};
// Im
/** @suppress {undefinedVars, duplicate} @this{Object} */function Im() { throw "cannot construct a Im, no constructor in IDL" }
Im.prototype = Object.create(WrapperObject.prototype);
Im.prototype.constructor = Im;
Im.prototype.__class__ = Im;
Im.__cache__ = {};
Module['Im'] = Im;

Im.prototype['CreateContext'] = Im.prototype.CreateContext = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_Im_CreateContext_0(self), ImGuiContext);
};;

Im.prototype['Begin'] = Im.prototype.Begin = /** @suppress {undefinedVars, duplicate} @this{Object} */function(name) {
  var self = this.ptr;
  ensureCache.prepare();
  if (name && typeof name === 'object') name = name.ptr;
  else name = ensureString(name);
  return !!(_emscripten_bind_Im_Begin_1(self, name));
};;

Im.prototype['End'] = Im.prototype.End = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_Im_End_0(self);
};;

Im.prototype['Render'] = Im.prototype.Render = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_Im_Render_0(self);
};;

Im.prototype['NewFrame'] = Im.prototype.NewFrame = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_Im_NewFrame_0(self);
};;

Im.prototype['GetDrawData'] = Im.prototype.GetDrawData = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_Im_GetDrawData_0(self), ImDrawData);
};;

Im.prototype['GetIO'] = Im.prototype.GetIO = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_Im_GetIO_0(self), ImGuiIO);
};;

Im.prototype['SetNextWindowSize'] = Im.prototype.SetNextWindowSize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(size, cond) {
  var self = this.ptr;
  if (size && typeof size === 'object') size = size.ptr;
  if (cond && typeof cond === 'object') cond = cond.ptr;
  if (cond === undefined) { _emscripten_bind_Im_SetNextWindowSize_1(self, size);  return }
  _emscripten_bind_Im_SetNextWindowSize_2(self, size, cond);
};;

Im.prototype['ShowDemoWindow'] = Im.prototype.ShowDemoWindow = /** @suppress {undefinedVars, duplicate} @this{Object} */function(p_open) {
  var self = this.ptr;
  ensureCache.prepare();
  if (p_open === undefined) { _emscripten_bind_Im_ShowDemoWindow_0(self);  return }
  _emscripten_bind_Im_ShowDemoWindow_1(self, p_open);
};;

Im.prototype['Checkbox'] = Im.prototype.Checkbox = /** @suppress {undefinedVars, duplicate} @this{Object} */function(label, v) {
  var self = this.ptr;
  ensureCache.prepare();
  if (label && typeof label === 'object') label = label.ptr;
  else label = ensureString(label);
  return !!(_emscripten_bind_Im_Checkbox_2(self, label, v));
};;

// ImVec2
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImVec2(x, y) {
  if (x && typeof x === 'object') x = x.ptr;
  if (y && typeof y === 'object') y = y.ptr;
  if (x === undefined) { this.ptr = _emscripten_bind_ImVec2_ImVec2_0(); getCache(ImVec2)[this.ptr] = this;return }
  if (y === undefined) { this.ptr = _emscripten_bind_ImVec2_ImVec2_1(x); getCache(ImVec2)[this.ptr] = this;return }
  this.ptr = _emscripten_bind_ImVec2_ImVec2_2(x, y);
  getCache(ImVec2)[this.ptr] = this;
};;
ImVec2.prototype = Object.create(WrapperObject.prototype);
ImVec2.prototype.constructor = ImVec2;
ImVec2.prototype.__class__ = ImVec2;
ImVec2.__cache__ = {};
Module['ImVec2'] = ImVec2;

  ImVec2.prototype['get_x'] = ImVec2.prototype.get_x = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec2_get_x_0(self);
};
    ImVec2.prototype['set_x'] = ImVec2.prototype.set_x = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec2_set_x_1(self, arg0);
};
    Object.defineProperty(ImVec2.prototype, 'x', { get: ImVec2.prototype.get_x, set: ImVec2.prototype.set_x });
  ImVec2.prototype['get_y'] = ImVec2.prototype.get_y = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec2_get_y_0(self);
};
    ImVec2.prototype['set_y'] = ImVec2.prototype.set_y = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec2_set_y_1(self, arg0);
};
    Object.defineProperty(ImVec2.prototype, 'y', { get: ImVec2.prototype.get_y, set: ImVec2.prototype.set_y });
  ImVec2.prototype['__destroy__'] = ImVec2.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImVec2___destroy___0(self);
};
// ImVec4
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImVec4(x, y, z, w) {
  if (x && typeof x === 'object') x = x.ptr;
  if (y && typeof y === 'object') y = y.ptr;
  if (z && typeof z === 'object') z = z.ptr;
  if (w && typeof w === 'object') w = w.ptr;
  if (x === undefined) { this.ptr = _emscripten_bind_ImVec4_ImVec4_0(); getCache(ImVec4)[this.ptr] = this;return }
  if (y === undefined) { this.ptr = _emscripten_bind_ImVec4_ImVec4_1(x); getCache(ImVec4)[this.ptr] = this;return }
  if (z === undefined) { this.ptr = _emscripten_bind_ImVec4_ImVec4_2(x, y); getCache(ImVec4)[this.ptr] = this;return }
  if (w === undefined) { this.ptr = _emscripten_bind_ImVec4_ImVec4_3(x, y, z); getCache(ImVec4)[this.ptr] = this;return }
  this.ptr = _emscripten_bind_ImVec4_ImVec4_4(x, y, z, w);
  getCache(ImVec4)[this.ptr] = this;
};;
ImVec4.prototype = Object.create(WrapperObject.prototype);
ImVec4.prototype.constructor = ImVec4;
ImVec4.prototype.__class__ = ImVec4;
ImVec4.__cache__ = {};
Module['ImVec4'] = ImVec4;

  ImVec4.prototype['get_x'] = ImVec4.prototype.get_x = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec4_get_x_0(self);
};
    ImVec4.prototype['set_x'] = ImVec4.prototype.set_x = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec4_set_x_1(self, arg0);
};
    Object.defineProperty(ImVec4.prototype, 'x', { get: ImVec4.prototype.get_x, set: ImVec4.prototype.set_x });
  ImVec4.prototype['get_y'] = ImVec4.prototype.get_y = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec4_get_y_0(self);
};
    ImVec4.prototype['set_y'] = ImVec4.prototype.set_y = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec4_set_y_1(self, arg0);
};
    Object.defineProperty(ImVec4.prototype, 'y', { get: ImVec4.prototype.get_y, set: ImVec4.prototype.set_y });
  ImVec4.prototype['get_z'] = ImVec4.prototype.get_z = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec4_get_z_0(self);
};
    ImVec4.prototype['set_z'] = ImVec4.prototype.set_z = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec4_set_z_1(self, arg0);
};
    Object.defineProperty(ImVec4.prototype, 'z', { get: ImVec4.prototype.get_z, set: ImVec4.prototype.set_z });
  ImVec4.prototype['get_w'] = ImVec4.prototype.get_w = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImVec4_get_w_0(self);
};
    ImVec4.prototype['set_w'] = ImVec4.prototype.set_w = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImVec4_set_w_1(self, arg0);
};
    Object.defineProperty(ImVec4.prototype, 'w', { get: ImVec4.prototype.get_w, set: ImVec4.prototype.set_w });
  ImVec4.prototype['__destroy__'] = ImVec4.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImVec4___destroy___0(self);
};
// VecCmdBuffer
/** @suppress {undefinedVars, duplicate} @this{Object} */function VecCmdBuffer() { throw "cannot construct a VecCmdBuffer, no constructor in IDL" }
VecCmdBuffer.prototype = Object.create(WrapperObject.prototype);
VecCmdBuffer.prototype.constructor = VecCmdBuffer;
VecCmdBuffer.prototype.__class__ = VecCmdBuffer;
VecCmdBuffer.__cache__ = {};
Module['VecCmdBuffer'] = VecCmdBuffer;

VecCmdBuffer.prototype['getData'] = VecCmdBuffer.prototype.getData = /** @suppress {undefinedVars, duplicate} @this{Object} */function(index) {
  var self = this.ptr;
  if (index && typeof index === 'object') index = index.ptr;
  return wrapPointer(_emscripten_bind_VecCmdBuffer_getData_1(self, index), ImDrawCmd);
};;

VecCmdBuffer.prototype['size'] = VecCmdBuffer.prototype.size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_VecCmdBuffer_size_0(self);
};;

  VecCmdBuffer.prototype['__destroy__'] = VecCmdBuffer.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_VecCmdBuffer___destroy___0(self);
};
// VecIdxBuffer
/** @suppress {undefinedVars, duplicate} @this{Object} */function VecIdxBuffer() { throw "cannot construct a VecIdxBuffer, no constructor in IDL" }
VecIdxBuffer.prototype = Object.create(WrapperObject.prototype);
VecIdxBuffer.prototype.constructor = VecIdxBuffer;
VecIdxBuffer.prototype.__class__ = VecIdxBuffer;
VecIdxBuffer.__cache__ = {};
Module['VecIdxBuffer'] = VecIdxBuffer;

VecIdxBuffer.prototype['size'] = VecIdxBuffer.prototype.size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_VecIdxBuffer_size_0(self);
};;

  VecIdxBuffer.prototype['__destroy__'] = VecIdxBuffer.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_VecIdxBuffer___destroy___0(self);
};
// VecVtxBuffer
/** @suppress {undefinedVars, duplicate} @this{Object} */function VecVtxBuffer() { throw "cannot construct a VecVtxBuffer, no constructor in IDL" }
VecVtxBuffer.prototype = Object.create(WrapperObject.prototype);
VecVtxBuffer.prototype.constructor = VecVtxBuffer;
VecVtxBuffer.prototype.__class__ = VecVtxBuffer;
VecVtxBuffer.__cache__ = {};
Module['VecVtxBuffer'] = VecVtxBuffer;

VecVtxBuffer.prototype['size'] = VecVtxBuffer.prototype.size = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_VecVtxBuffer_size_0(self);
};;

  VecVtxBuffer.prototype['__destroy__'] = VecVtxBuffer.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_VecVtxBuffer___destroy___0(self);
};
// ImDrawCmd
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImDrawCmd() { throw "cannot construct a ImDrawCmd, no constructor in IDL" }
ImDrawCmd.prototype = Object.create(WrapperObject.prototype);
ImDrawCmd.prototype.constructor = ImDrawCmd;
ImDrawCmd.prototype.__class__ = ImDrawCmd;
ImDrawCmd.__cache__ = {};
Module['ImDrawCmd'] = ImDrawCmd;

  ImDrawCmd.prototype['get_ClipRect'] = ImDrawCmd.prototype.get_ClipRect = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawCmd_get_ClipRect_0(self), ImVec4);
};
    ImDrawCmd.prototype['set_ClipRect'] = ImDrawCmd.prototype.set_ClipRect = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawCmd_set_ClipRect_1(self, arg0);
};
    Object.defineProperty(ImDrawCmd.prototype, 'ClipRect', { get: ImDrawCmd.prototype.get_ClipRect, set: ImDrawCmd.prototype.set_ClipRect });
  ImDrawCmd.prototype['get_VtxOffset'] = ImDrawCmd.prototype.get_VtxOffset = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawCmd_get_VtxOffset_0(self);
};
    ImDrawCmd.prototype['set_VtxOffset'] = ImDrawCmd.prototype.set_VtxOffset = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawCmd_set_VtxOffset_1(self, arg0);
};
    Object.defineProperty(ImDrawCmd.prototype, 'VtxOffset', { get: ImDrawCmd.prototype.get_VtxOffset, set: ImDrawCmd.prototype.set_VtxOffset });
  ImDrawCmd.prototype['get_IdxOffset'] = ImDrawCmd.prototype.get_IdxOffset = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawCmd_get_IdxOffset_0(self);
};
    ImDrawCmd.prototype['set_IdxOffset'] = ImDrawCmd.prototype.set_IdxOffset = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawCmd_set_IdxOffset_1(self, arg0);
};
    Object.defineProperty(ImDrawCmd.prototype, 'IdxOffset', { get: ImDrawCmd.prototype.get_IdxOffset, set: ImDrawCmd.prototype.set_IdxOffset });
  ImDrawCmd.prototype['get_ElemCount'] = ImDrawCmd.prototype.get_ElemCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawCmd_get_ElemCount_0(self);
};
    ImDrawCmd.prototype['set_ElemCount'] = ImDrawCmd.prototype.set_ElemCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawCmd_set_ElemCount_1(self, arg0);
};
    Object.defineProperty(ImDrawCmd.prototype, 'ElemCount', { get: ImDrawCmd.prototype.get_ElemCount, set: ImDrawCmd.prototype.set_ElemCount });
  ImDrawCmd.prototype['get_TextureId'] = ImDrawCmd.prototype.get_TextureId = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawCmd_get_TextureId_0(self);
};
    ImDrawCmd.prototype['set_TextureId'] = ImDrawCmd.prototype.set_TextureId = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawCmd_set_TextureId_1(self, arg0);
};
    Object.defineProperty(ImDrawCmd.prototype, 'TextureId', { get: ImDrawCmd.prototype.get_TextureId, set: ImDrawCmd.prototype.set_TextureId });
  ImDrawCmd.prototype['__destroy__'] = ImDrawCmd.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImDrawCmd___destroy___0(self);
};
// ImDrawVert
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImDrawVert() { throw "cannot construct a ImDrawVert, no constructor in IDL" }
ImDrawVert.prototype = Object.create(WrapperObject.prototype);
ImDrawVert.prototype.constructor = ImDrawVert;
ImDrawVert.prototype.__class__ = ImDrawVert;
ImDrawVert.__cache__ = {};
Module['ImDrawVert'] = ImDrawVert;

  ImDrawVert.prototype['get_pos'] = ImDrawVert.prototype.get_pos = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawVert_get_pos_0(self), ImVec2);
};
    ImDrawVert.prototype['set_pos'] = ImDrawVert.prototype.set_pos = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawVert_set_pos_1(self, arg0);
};
    Object.defineProperty(ImDrawVert.prototype, 'pos', { get: ImDrawVert.prototype.get_pos, set: ImDrawVert.prototype.set_pos });
  ImDrawVert.prototype['get_uv'] = ImDrawVert.prototype.get_uv = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawVert_get_uv_0(self), ImVec2);
};
    ImDrawVert.prototype['set_uv'] = ImDrawVert.prototype.set_uv = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawVert_set_uv_1(self, arg0);
};
    Object.defineProperty(ImDrawVert.prototype, 'uv', { get: ImDrawVert.prototype.get_uv, set: ImDrawVert.prototype.set_uv });
  ImDrawVert.prototype['get_col'] = ImDrawVert.prototype.get_col = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawVert_get_col_0(self);
};
    ImDrawVert.prototype['set_col'] = ImDrawVert.prototype.set_col = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawVert_set_col_1(self, arg0);
};
    Object.defineProperty(ImDrawVert.prototype, 'col', { get: ImDrawVert.prototype.get_col, set: ImDrawVert.prototype.set_col });
  ImDrawVert.prototype['__destroy__'] = ImDrawVert.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImDrawVert___destroy___0(self);
};
// ImDrawData
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImDrawData() { throw "cannot construct a ImDrawData, no constructor in IDL" }
ImDrawData.prototype = Object.create(WrapperObject.prototype);
ImDrawData.prototype.constructor = ImDrawData;
ImDrawData.prototype.__class__ = ImDrawData;
ImDrawData.__cache__ = {};
Module['ImDrawData'] = ImDrawData;

  ImDrawData.prototype['get_CmdListsCount'] = ImDrawData.prototype.get_CmdListsCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawData_get_CmdListsCount_0(self);
};
    ImDrawData.prototype['set_CmdListsCount'] = ImDrawData.prototype.set_CmdListsCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_CmdListsCount_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'CmdListsCount', { get: ImDrawData.prototype.get_CmdListsCount, set: ImDrawData.prototype.set_CmdListsCount });
  ImDrawData.prototype['get_TotalIdxCount'] = ImDrawData.prototype.get_TotalIdxCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawData_get_TotalIdxCount_0(self);
};
    ImDrawData.prototype['set_TotalIdxCount'] = ImDrawData.prototype.set_TotalIdxCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_TotalIdxCount_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'TotalIdxCount', { get: ImDrawData.prototype.get_TotalIdxCount, set: ImDrawData.prototype.set_TotalIdxCount });
  ImDrawData.prototype['get_TotalVtxCount'] = ImDrawData.prototype.get_TotalVtxCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImDrawData_get_TotalVtxCount_0(self);
};
    ImDrawData.prototype['set_TotalVtxCount'] = ImDrawData.prototype.set_TotalVtxCount = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_TotalVtxCount_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'TotalVtxCount', { get: ImDrawData.prototype.get_TotalVtxCount, set: ImDrawData.prototype.set_TotalVtxCount });
  ImDrawData.prototype['get_CmdLists'] = ImDrawData.prototype.get_CmdLists = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  return wrapPointer(_emscripten_bind_ImDrawData_get_CmdLists_1(self, arg0), ImDrawList);
};
    ImDrawData.prototype['set_CmdLists'] = ImDrawData.prototype.set_CmdLists = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0, arg1) {
  var self = this.ptr;
  ensureCache.prepare();
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  if (arg1 && typeof arg1 === 'object') arg1 = arg1.ptr;
  _emscripten_bind_ImDrawData_set_CmdLists_2(self, arg0, arg1);
};
    Object.defineProperty(ImDrawData.prototype, 'CmdLists', { get: ImDrawData.prototype.get_CmdLists, set: ImDrawData.prototype.set_CmdLists });
  ImDrawData.prototype['get_DisplayPos'] = ImDrawData.prototype.get_DisplayPos = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawData_get_DisplayPos_0(self), ImVec2);
};
    ImDrawData.prototype['set_DisplayPos'] = ImDrawData.prototype.set_DisplayPos = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_DisplayPos_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'DisplayPos', { get: ImDrawData.prototype.get_DisplayPos, set: ImDrawData.prototype.set_DisplayPos });
  ImDrawData.prototype['get_DisplaySize'] = ImDrawData.prototype.get_DisplaySize = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawData_get_DisplaySize_0(self), ImVec2);
};
    ImDrawData.prototype['set_DisplaySize'] = ImDrawData.prototype.set_DisplaySize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_DisplaySize_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'DisplaySize', { get: ImDrawData.prototype.get_DisplaySize, set: ImDrawData.prototype.set_DisplaySize });
  ImDrawData.prototype['get_FramebufferScale'] = ImDrawData.prototype.get_FramebufferScale = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawData_get_FramebufferScale_0(self), ImVec2);
};
    ImDrawData.prototype['set_FramebufferScale'] = ImDrawData.prototype.set_FramebufferScale = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawData_set_FramebufferScale_1(self, arg0);
};
    Object.defineProperty(ImDrawData.prototype, 'FramebufferScale', { get: ImDrawData.prototype.get_FramebufferScale, set: ImDrawData.prototype.set_FramebufferScale });
  ImDrawData.prototype['__destroy__'] = ImDrawData.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImDrawData___destroy___0(self);
};
// ImDrawList
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImDrawList() { throw "cannot construct a ImDrawList, no constructor in IDL" }
ImDrawList.prototype = Object.create(WrapperObject.prototype);
ImDrawList.prototype.constructor = ImDrawList;
ImDrawList.prototype.__class__ = ImDrawList;
ImDrawList.__cache__ = {};
Module['ImDrawList'] = ImDrawList;

  ImDrawList.prototype['get_CmdBuffer'] = ImDrawList.prototype.get_CmdBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawList_get_CmdBuffer_0(self), VecCmdBuffer);
};
    ImDrawList.prototype['set_CmdBuffer'] = ImDrawList.prototype.set_CmdBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawList_set_CmdBuffer_1(self, arg0);
};
    Object.defineProperty(ImDrawList.prototype, 'CmdBuffer', { get: ImDrawList.prototype.get_CmdBuffer, set: ImDrawList.prototype.set_CmdBuffer });
  ImDrawList.prototype['get_IdxBuffer'] = ImDrawList.prototype.get_IdxBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawList_get_IdxBuffer_0(self), VecIdxBuffer);
};
    ImDrawList.prototype['set_IdxBuffer'] = ImDrawList.prototype.set_IdxBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawList_set_IdxBuffer_1(self, arg0);
};
    Object.defineProperty(ImDrawList.prototype, 'IdxBuffer', { get: ImDrawList.prototype.get_IdxBuffer, set: ImDrawList.prototype.set_IdxBuffer });
  ImDrawList.prototype['get_VtxBuffer'] = ImDrawList.prototype.get_VtxBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImDrawList_get_VtxBuffer_0(self), VecVtxBuffer);
};
    ImDrawList.prototype['set_VtxBuffer'] = ImDrawList.prototype.set_VtxBuffer = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImDrawList_set_VtxBuffer_1(self, arg0);
};
    Object.defineProperty(ImDrawList.prototype, 'VtxBuffer', { get: ImDrawList.prototype.get_VtxBuffer, set: ImDrawList.prototype.set_VtxBuffer });
  ImDrawList.prototype['__destroy__'] = ImDrawList.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImDrawList___destroy___0(self);
};
// ImGuiIO
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImGuiIO() { throw "cannot construct a ImGuiIO, no constructor in IDL" }
ImGuiIO.prototype = Object.create(WrapperObject.prototype);
ImGuiIO.prototype.constructor = ImGuiIO;
ImGuiIO.prototype.__class__ = ImGuiIO;
ImGuiIO.__cache__ = {};
Module['ImGuiIO'] = ImGuiIO;

ImGuiIO.prototype['AddMouseWheelEvent'] = ImGuiIO.prototype.AddMouseWheelEvent = /** @suppress {undefinedVars, duplicate} @this{Object} */function(wheel_x, wheel_y) {
  var self = this.ptr;
  if (wheel_x && typeof wheel_x === 'object') wheel_x = wheel_x.ptr;
  if (wheel_y && typeof wheel_y === 'object') wheel_y = wheel_y.ptr;
  _emscripten_bind_ImGuiIO_AddMouseWheelEvent_2(self, wheel_x, wheel_y);
};;

ImGuiIO.prototype['AddMouseButtonEvent'] = ImGuiIO.prototype.AddMouseButtonEvent = /** @suppress {undefinedVars, duplicate} @this{Object} */function(button, down) {
  var self = this.ptr;
  if (button && typeof button === 'object') button = button.ptr;
  if (down && typeof down === 'object') down = down.ptr;
  _emscripten_bind_ImGuiIO_AddMouseButtonEvent_2(self, button, down);
};;

ImGuiIO.prototype['AddMousePosEvent'] = ImGuiIO.prototype.AddMousePosEvent = /** @suppress {undefinedVars, duplicate} @this{Object} */function(x, y) {
  var self = this.ptr;
  if (x && typeof x === 'object') x = x.ptr;
  if (y && typeof y === 'object') y = y.ptr;
  _emscripten_bind_ImGuiIO_AddMousePosEvent_2(self, x, y);
};;

ImGuiIO.prototype['AddKeyEvent'] = ImGuiIO.prototype.AddKeyEvent = /** @suppress {undefinedVars, duplicate} @this{Object} */function(key, down) {
  var self = this.ptr;
  if (key && typeof key === 'object') key = key.ptr;
  if (down && typeof down === 'object') down = down.ptr;
  _emscripten_bind_ImGuiIO_AddKeyEvent_2(self, key, down);
};;

ImGuiIO.prototype['AddInputCharacter'] = ImGuiIO.prototype.AddInputCharacter = /** @suppress {undefinedVars, duplicate} @this{Object} */function(c) {
  var self = this.ptr;
  if (c && typeof c === 'object') c = c.ptr;
  _emscripten_bind_ImGuiIO_AddInputCharacter_1(self, c);
};;

  ImGuiIO.prototype['get_WantCaptureMouse'] = ImGuiIO.prototype.get_WantCaptureMouse = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return !!(_emscripten_bind_ImGuiIO_get_WantCaptureMouse_0(self));
};
    ImGuiIO.prototype['set_WantCaptureMouse'] = ImGuiIO.prototype.set_WantCaptureMouse = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImGuiIO_set_WantCaptureMouse_1(self, arg0);
};
    Object.defineProperty(ImGuiIO.prototype, 'WantCaptureMouse', { get: ImGuiIO.prototype.get_WantCaptureMouse, set: ImGuiIO.prototype.set_WantCaptureMouse });
  ImGuiIO.prototype['get_DisplaySize'] = ImGuiIO.prototype.get_DisplaySize = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImGuiIO_get_DisplaySize_0(self), ImVec2);
};
    ImGuiIO.prototype['set_DisplaySize'] = ImGuiIO.prototype.set_DisplaySize = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImGuiIO_set_DisplaySize_1(self, arg0);
};
    Object.defineProperty(ImGuiIO.prototype, 'DisplaySize', { get: ImGuiIO.prototype.get_DisplaySize, set: ImGuiIO.prototype.set_DisplaySize });
  ImGuiIO.prototype['get_DisplayFramebufferScale'] = ImGuiIO.prototype.get_DisplayFramebufferScale = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImGuiIO_get_DisplayFramebufferScale_0(self), ImVec2);
};
    ImGuiIO.prototype['set_DisplayFramebufferScale'] = ImGuiIO.prototype.set_DisplayFramebufferScale = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImGuiIO_set_DisplayFramebufferScale_1(self, arg0);
};
    Object.defineProperty(ImGuiIO.prototype, 'DisplayFramebufferScale', { get: ImGuiIO.prototype.get_DisplayFramebufferScale, set: ImGuiIO.prototype.set_DisplayFramebufferScale });
  ImGuiIO.prototype['get_DeltaTime'] = ImGuiIO.prototype.get_DeltaTime = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImGuiIO_get_DeltaTime_0(self);
};
    ImGuiIO.prototype['set_DeltaTime'] = ImGuiIO.prototype.set_DeltaTime = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImGuiIO_set_DeltaTime_1(self, arg0);
};
    Object.defineProperty(ImGuiIO.prototype, 'DeltaTime', { get: ImGuiIO.prototype.get_DeltaTime, set: ImGuiIO.prototype.set_DeltaTime });
  ImGuiIO.prototype['get_Fonts'] = ImGuiIO.prototype.get_Fonts = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return wrapPointer(_emscripten_bind_ImGuiIO_get_Fonts_0(self), ImFontAtlas);
};
    ImGuiIO.prototype['set_Fonts'] = ImGuiIO.prototype.set_Fonts = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImGuiIO_set_Fonts_1(self, arg0);
};
    Object.defineProperty(ImGuiIO.prototype, 'Fonts', { get: ImGuiIO.prototype.get_Fonts, set: ImGuiIO.prototype.set_Fonts });
  ImGuiIO.prototype['__destroy__'] = ImGuiIO.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImGuiIO___destroy___0(self);
};
// ImFontAtlas
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImFontAtlas() { throw "cannot construct a ImFontAtlas, no constructor in IDL" }
ImFontAtlas.prototype = Object.create(WrapperObject.prototype);
ImFontAtlas.prototype.constructor = ImFontAtlas;
ImFontAtlas.prototype.__class__ = ImFontAtlas;
ImFontAtlas.__cache__ = {};
Module['ImFontAtlas'] = ImFontAtlas;

  ImFontAtlas.prototype['get_TexID'] = ImFontAtlas.prototype.get_TexID = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  return _emscripten_bind_ImFontAtlas_get_TexID_0(self);
};
    ImFontAtlas.prototype['set_TexID'] = ImFontAtlas.prototype.set_TexID = /** @suppress {undefinedVars, duplicate} @this{Object} */function(arg0) {
  var self = this.ptr;
  if (arg0 && typeof arg0 === 'object') arg0 = arg0.ptr;
  _emscripten_bind_ImFontAtlas_set_TexID_1(self, arg0);
};
    Object.defineProperty(ImFontAtlas.prototype, 'TexID', { get: ImFontAtlas.prototype.get_TexID, set: ImFontAtlas.prototype.set_TexID });
  ImFontAtlas.prototype['__destroy__'] = ImFontAtlas.prototype.__destroy__ = /** @suppress {undefinedVars, duplicate} @this{Object} */function() {
  var self = this.ptr;
  _emscripten_bind_ImFontAtlas___destroy___0(self);
};
// ImGuiContext
/** @suppress {undefinedVars, duplicate} @this{Object} */function ImGuiContext() { throw "cannot construct a ImGuiContext, no constructor in IDL" }
ImGuiContext.prototype = Object.create(WrapperObject.prototype);
ImGuiContext.prototype.constructor = ImGuiContext;
ImGuiContext.prototype.__class__ = ImGuiContext;
ImGuiContext.__cache__ = {};
Module['ImGuiContext'] = ImGuiContext;

(function() {
  function setupEnums() {
    

    // ImGuiKey

    Module['ImGuiKey_None'] = _emscripten_enum_ImGuiKey_ImGuiKey_None();

  }
  if (runtimeInitialized) setupEnums();
  else addOnInit(setupEnums);
})();


// end include: D:\Dev\Projects\java\jDear-imgui\imgui\imgui-cpp\imgui-cpp\build\emscripten\glue.js


  return ImGui.ready
}
);
})();
if (typeof exports === 'object' && typeof module === 'object')
  module.exports = ImGui;
else if (typeof define === 'function' && define['amd'])
  define([], function() { return ImGui; });
else if (typeof exports === 'object')
  exports["ImGui"] = ImGui;
async function asyncCall() {
	window.ImGui = await ImGui();
}

asyncCall();