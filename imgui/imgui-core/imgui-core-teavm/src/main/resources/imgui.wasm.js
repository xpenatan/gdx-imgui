
var ImGui = (() => {
  var _scriptDir = typeof document !== 'undefined' && document.currentScript ? document.currentScript.src : undefined;
  if (typeof __filename !== 'undefined') _scriptDir = _scriptDir || __filename;
  return (
function(ImGui) {
  ImGui = ImGui || {};


var b;b||(b=typeof ImGui !== 'undefined' ? ImGui : {});var g,h;b.ready=new Promise(function(a,c){g=a;h=c});var l=Object.assign({},b),n="object"==typeof window,p="function"==typeof importScripts,aa="object"==typeof process&&"object"==typeof process.versions&&"string"==typeof process.versions.node,q="",r,t,u;
if(aa){q=p?require("path").dirname(q)+"/":__dirname+"/";var fs,v;"function"===typeof require&&(fs=require("fs"),v=require("path"));r=(a,c)=>{a=v.normalize(a);return fs.readFileSync(a,c?void 0:"utf8")};u=a=>{a=r(a,!0);a.buffer||(a=new Uint8Array(a));return a};t=(a,c,e)=>{a=v.normalize(a);fs.readFile(a,function(d,f){d?e(d):c(f.buffer)})};1<process.argv.length&&process.argv[1].replace(/\\/g,"/");process.argv.slice(2);process.on("uncaughtException",function(a){throw a;});process.on("unhandledRejection",
function(a){throw a;});b.inspect=function(){return"[Emscripten Module object]"}}else if(n||p)p?q=self.location.href:"undefined"!=typeof document&&document.currentScript&&(q=document.currentScript.src),_scriptDir&&(q=_scriptDir),0!==q.indexOf("blob:")?q=q.substr(0,q.replace(/[?#].*/,"").lastIndexOf("/")+1):q="",r=a=>{var c=new XMLHttpRequest;c.open("GET",a,!1);c.send(null);return c.responseText},p&&(u=a=>{var c=new XMLHttpRequest;c.open("GET",a,!1);c.responseType="arraybuffer";c.send(null);return new Uint8Array(c.response)}),
t=(a,c,e)=>{var d=new XMLHttpRequest;d.open("GET",a,!0);d.responseType="arraybuffer";d.onload=()=>{200==d.status||0==d.status&&d.response?c(d.response):e()};d.onerror=e;d.send(null)};var ba=b.print||console.log.bind(console),w=b.printErr||console.warn.bind(console);Object.assign(b,l);l=null;var x;b.wasmBinary&&(x=b.wasmBinary);var noExitRuntime=b.noExitRuntime||!0;"object"!=typeof WebAssembly&&y("no native wasm support detected");
var ca,da=!1,ea="undefined"!=typeof TextDecoder?new TextDecoder("utf8"):void 0;
function fa(a,c,e){var d=c+e;for(e=c;a[e]&&!(e>=d);)++e;if(16<e-c&&a.buffer&&ea)return ea.decode(a.subarray(c,e));for(d="";c<e;){var f=a[c++];if(f&128){var k=a[c++]&63;if(192==(f&224))d+=String.fromCharCode((f&31)<<6|k);else{var m=a[c++]&63;f=224==(f&240)?(f&15)<<12|k<<6|m:(f&7)<<18|k<<12|m<<6|a[c++]&63;65536>f?d+=String.fromCharCode(f):(f-=65536,d+=String.fromCharCode(55296|f>>10,56320|f&1023))}}else d+=String.fromCharCode(f)}return d}var z,A,B,ha=[],ia=[],ja=[];
function ka(){var a=b.preRun.shift();ha.unshift(a)}var C=0,D=null,E=null;function y(a){if(b.onAbort)b.onAbort(a);a="Aborted("+a+")";w(a);da=!0;a=new WebAssembly.RuntimeError(a+". Build with -sASSERTIONS for more info.");h(a);throw a;}function la(){return F.startsWith("data:application/octet-stream;base64,")}var F;F="imgui.wasm.wasm";if(!la()){var ma=F;F=b.locateFile?b.locateFile(ma,q):q+ma}
function na(){var a=F;try{if(a==F&&x)return new Uint8Array(x);if(u)return u(a);throw"both async and sync fetching of the wasm failed";}catch(c){y(c)}}
function oa(){if(!x&&(n||p)){if("function"==typeof fetch&&!F.startsWith("file://"))return fetch(F,{credentials:"same-origin"}).then(function(a){if(!a.ok)throw"failed to load wasm binary file at '"+F+"'";return a.arrayBuffer()}).catch(function(){return na()});if(t)return new Promise(function(a,c){t(F,function(e){a(new Uint8Array(e))},c)})}return Promise.resolve().then(function(){return na()})}function G(a){for(;0<a.length;)a.shift()(b)}
var pa=[null,[],[]],qa={b:function(){y("")},d:function(a,c,e){A.copyWithin(a,c,c+e)},c:function(){y("OOM")},a:function(a,c,e,d){for(var f=0,k=0;k<e;k++){var m=B[c>>2],I=B[c+4>>2];c+=8;for(var U=0;U<I;U++){var V=A[m+U],W=pa[a];0===V||10===V?((1===a?ba:w)(fa(W,0)),W.length=0):W.push(V)}f+=I}B[d>>2]=f;return 0}};
(function(){function a(f){b.asm=f.exports;ca=b.asm.e;f=ca.buffer;b.HEAP8=z=new Int8Array(f);b.HEAP16=new Int16Array(f);b.HEAP32=new Int32Array(f);b.HEAPU8=A=new Uint8Array(f);b.HEAPU16=new Uint16Array(f);b.HEAPU32=B=new Uint32Array(f);b.HEAPF32=new Float32Array(f);b.HEAPF64=new Float64Array(f);ia.unshift(b.asm.f);C--;b.monitorRunDependencies&&b.monitorRunDependencies(C);0==C&&(null!==D&&(clearInterval(D),D=null),E&&(f=E,E=null,f()))}function c(f){a(f.instance)}function e(f){return oa().then(function(k){return WebAssembly.instantiate(k,
d)}).then(function(k){return k}).then(f,function(k){w("failed to asynchronously prepare wasm: "+k);y(k)})}var d={a:qa};C++;b.monitorRunDependencies&&b.monitorRunDependencies(C);if(b.instantiateWasm)try{return b.instantiateWasm(d,a)}catch(f){w("Module.instantiateWasm callback failed with error: "+f),h(f)}(function(){return x||"function"!=typeof WebAssembly.instantiateStreaming||la()||F.startsWith("file://")||aa||"function"!=typeof fetch?e(c):fetch(F,{credentials:"same-origin"}).then(function(f){return WebAssembly.instantiateStreaming(f,
d).then(c,function(k){w("wasm streaming compile failed: "+k);w("falling back to ArrayBuffer instantiation");return e(c)})})})().catch(h);return{}})();b.___wasm_call_ctors=function(){return(b.___wasm_call_ctors=b.asm.f).apply(null,arguments)};
var ra=b._emscripten_bind_VoidPtr___destroy___0=function(){return(ra=b._emscripten_bind_VoidPtr___destroy___0=b.asm.g).apply(null,arguments)},sa=b._emscripten_bind_Im_Begin_1=function(){return(sa=b._emscripten_bind_Im_Begin_1=b.asm.h).apply(null,arguments)},ta=b._emscripten_bind_Im_End_0=function(){return(ta=b._emscripten_bind_Im_End_0=b.asm.i).apply(null,arguments)},ua=b._emscripten_bind_ImVec2_ImVec2_0=function(){return(ua=b._emscripten_bind_ImVec2_ImVec2_0=b.asm.j).apply(null,arguments)},va=b._emscripten_bind_ImVec2_ImVec2_2=
function(){return(va=b._emscripten_bind_ImVec2_ImVec2_2=b.asm.k).apply(null,arguments)},wa=b._emscripten_bind_ImVec2_get_x_0=function(){return(wa=b._emscripten_bind_ImVec2_get_x_0=b.asm.l).apply(null,arguments)},xa=b._emscripten_bind_ImVec2_set_x_1=function(){return(xa=b._emscripten_bind_ImVec2_set_x_1=b.asm.m).apply(null,arguments)},ya=b._emscripten_bind_ImVec2_get_y_0=function(){return(ya=b._emscripten_bind_ImVec2_get_y_0=b.asm.n).apply(null,arguments)},za=b._emscripten_bind_ImVec2_set_y_1=function(){return(za=
b._emscripten_bind_ImVec2_set_y_1=b.asm.o).apply(null,arguments)},Aa=b._emscripten_bind_ImVec2___destroy___0=function(){return(Aa=b._emscripten_bind_ImVec2___destroy___0=b.asm.p).apply(null,arguments)},Ba=b._emscripten_bind_ImVec4_ImVec4_0=function(){return(Ba=b._emscripten_bind_ImVec4_ImVec4_0=b.asm.q).apply(null,arguments)},Ca=b._emscripten_bind_ImVec4_ImVec4_4=function(){return(Ca=b._emscripten_bind_ImVec4_ImVec4_4=b.asm.r).apply(null,arguments)},Da=b._emscripten_bind_ImVec4_get_x_0=function(){return(Da=
b._emscripten_bind_ImVec4_get_x_0=b.asm.s).apply(null,arguments)},Ea=b._emscripten_bind_ImVec4_set_x_1=function(){return(Ea=b._emscripten_bind_ImVec4_set_x_1=b.asm.t).apply(null,arguments)},Fa=b._emscripten_bind_ImVec4_get_y_0=function(){return(Fa=b._emscripten_bind_ImVec4_get_y_0=b.asm.u).apply(null,arguments)},Ga=b._emscripten_bind_ImVec4_set_y_1=function(){return(Ga=b._emscripten_bind_ImVec4_set_y_1=b.asm.v).apply(null,arguments)},Ha=b._emscripten_bind_ImVec4_get_z_0=function(){return(Ha=b._emscripten_bind_ImVec4_get_z_0=
b.asm.w).apply(null,arguments)},Ia=b._emscripten_bind_ImVec4_set_z_1=function(){return(Ia=b._emscripten_bind_ImVec4_set_z_1=b.asm.x).apply(null,arguments)},Ja=b._emscripten_bind_ImVec4_get_w_0=function(){return(Ja=b._emscripten_bind_ImVec4_get_w_0=b.asm.y).apply(null,arguments)},Ka=b._emscripten_bind_ImVec4_set_w_1=function(){return(Ka=b._emscripten_bind_ImVec4_set_w_1=b.asm.z).apply(null,arguments)},La=b._emscripten_bind_ImVec4___destroy___0=function(){return(La=b._emscripten_bind_ImVec4___destroy___0=
b.asm.A).apply(null,arguments)},Ma=b._emscripten_bind_ImDrawList___destroy___0=function(){return(Ma=b._emscripten_bind_ImDrawList___destroy___0=b.asm.B).apply(null,arguments)},Na=b._emscripten_bind_ImDrawCmd_get_ClipRect_0=function(){return(Na=b._emscripten_bind_ImDrawCmd_get_ClipRect_0=b.asm.C).apply(null,arguments)},Oa=b._emscripten_bind_ImDrawCmd_set_ClipRect_1=function(){return(Oa=b._emscripten_bind_ImDrawCmd_set_ClipRect_1=b.asm.D).apply(null,arguments)},Pa=b._emscripten_bind_ImDrawCmd_get_VtxOffset_0=
function(){return(Pa=b._emscripten_bind_ImDrawCmd_get_VtxOffset_0=b.asm.E).apply(null,arguments)},Qa=b._emscripten_bind_ImDrawCmd_set_VtxOffset_1=function(){return(Qa=b._emscripten_bind_ImDrawCmd_set_VtxOffset_1=b.asm.F).apply(null,arguments)},Ra=b._emscripten_bind_ImDrawCmd_get_IdxOffset_0=function(){return(Ra=b._emscripten_bind_ImDrawCmd_get_IdxOffset_0=b.asm.G).apply(null,arguments)},Sa=b._emscripten_bind_ImDrawCmd_set_IdxOffset_1=function(){return(Sa=b._emscripten_bind_ImDrawCmd_set_IdxOffset_1=
b.asm.H).apply(null,arguments)},Ta=b._emscripten_bind_ImDrawCmd_get_ElemCount_0=function(){return(Ta=b._emscripten_bind_ImDrawCmd_get_ElemCount_0=b.asm.I).apply(null,arguments)},Ua=b._emscripten_bind_ImDrawCmd_set_ElemCount_1=function(){return(Ua=b._emscripten_bind_ImDrawCmd_set_ElemCount_1=b.asm.J).apply(null,arguments)},Va=b._emscripten_bind_ImDrawCmd_get_TextureId_0=function(){return(Va=b._emscripten_bind_ImDrawCmd_get_TextureId_0=b.asm.K).apply(null,arguments)},Wa=b._emscripten_bind_ImDrawCmd_set_TextureId_1=
function(){return(Wa=b._emscripten_bind_ImDrawCmd_set_TextureId_1=b.asm.L).apply(null,arguments)},Xa=b._emscripten_bind_ImDrawCmd___destroy___0=function(){return(Xa=b._emscripten_bind_ImDrawCmd___destroy___0=b.asm.M).apply(null,arguments)};b._malloc=function(){return(b._malloc=b.asm.O).apply(null,arguments)};b._free=function(){return(b._free=b.asm.P).apply(null,arguments)};b.___start_em_js=7476;b.___stop_em_js=7574;b.UTF8ToString=function(a,c){return a?fa(A,a,c):""};var H;
E=function Ya(){H||Za();H||(E=Ya)};
function Za(){function a(){if(!H&&(H=!0,b.calledRun=!0,!da)){G(ia);g(b);if(b.onRuntimeInitialized)b.onRuntimeInitialized();if(b.postRun)for("function"==typeof b.postRun&&(b.postRun=[b.postRun]);b.postRun.length;){var c=b.postRun.shift();ja.unshift(c)}G(ja)}}if(!(0<C)){if(b.preRun)for("function"==typeof b.preRun&&(b.preRun=[b.preRun]);b.preRun.length;)ka();G(ha);0<C||(b.setStatus?(b.setStatus("Running..."),setTimeout(function(){setTimeout(function(){b.setStatus("")},1);a()},1)):a())}}
if(b.preInit)for("function"==typeof b.preInit&&(b.preInit=[b.preInit]);0<b.preInit.length;)b.preInit.pop()();Za();function J(){}J.prototype=Object.create(J.prototype);J.prototype.constructor=J;J.prototype.R=J;J.S={};b.WrapperObject=J;function K(a){return(a||J).S}b.getCache=K;function L(a,c){var e=K(c),d=e[a];if(d)return d;d=Object.create((c||J).prototype);d.N=a;return e[a]=d}b.wrapPointer=L;b.castObject=function(a,c){return L(a.N,c)};b.NULL=L(0);
b.destroy=function(a){if(!a.__destroy__)throw"Error: Cannot destroy object. (Did you create it yourself?)";a.__destroy__();delete K(a.R)[a.N]};b.compare=function(a,c){return a.N===c.N};b.getPointer=function(a){return a.N};b.getClass=function(a){return a.R};var M=0,N=0,O=0,P=[],Q=0;function R(){throw"cannot construct a VoidPtr, no constructor in IDL";}R.prototype=Object.create(J.prototype);R.prototype.constructor=R;R.prototype.R=R;R.S={};b.VoidPtr=R;R.prototype.__destroy__=function(){ra(this.N)};
function S(){throw"cannot construct a Im, no constructor in IDL";}S.prototype=Object.create(J.prototype);S.prototype.constructor=S;S.prototype.R=S;S.S={};b.Im=S;
S.prototype.Begin=function(a){var c=this.N;if(Q){for(var e=0;e<P.length;e++)b._free(P[e]);P.length=0;b._free(M);M=0;N+=Q;Q=0}M||(N+=128,(M=b._malloc(N))||y());O=0;if(a&&"object"===typeof a)a=a.N;else if(e=a,"string"===typeof e){for(var d=a=0;d<e.length;++d){var f=e.charCodeAt(d);127>=f?a++:2047>=f?a+=2:55296<=f&&57343>=f?(a+=4,++d):a+=3}a=Array(a+1);f=a.length;d=0;if(0<f){f=d+f-1;for(var k=0;k<e.length;++k){var m=e.charCodeAt(k);if(55296<=m&&57343>=m){var I=e.charCodeAt(++k);m=65536+((m&1023)<<10)|
I&1023}if(127>=m){if(d>=f)break;a[d++]=m}else{if(2047>=m){if(d+1>=f)break;a[d++]=192|m>>6}else{if(65535>=m){if(d+2>=f)break;a[d++]=224|m>>12}else{if(d+3>=f)break;a[d++]=240|m>>18;a[d++]=128|m>>12&63}a[d++]=128|m>>6&63}a[d++]=128|m&63}}a[d]=0}e=z;M||y();e=a.length*e.BYTES_PER_ELEMENT;e=e+7&-8;O+e>=N?(0<e||y(),Q+=e,d=b._malloc(e),P.push(d)):(d=M+O,O+=e);e=d;f=z;d=e>>>0;switch(f.BYTES_PER_ELEMENT){case 2:d>>>=1;break;case 4:d>>>=2;break;case 8:d>>>=3}for(k=0;k<a.length;k++)f[d+k]=a[k];a=e}else a=e;return!!sa(c,
a)};S.prototype.End=function(){ta(this.N)};function T(a,c){a&&"object"===typeof a&&(a=a.N);c&&"object"===typeof c&&(c=c.N);this.N=void 0===a?ua():void 0===c?_emscripten_bind_ImVec2_ImVec2_1(a):va(a,c);K(T)[this.N]=this}T.prototype=Object.create(J.prototype);T.prototype.constructor=T;T.prototype.R=T;T.S={};b.ImVec2=T;T.prototype.get_x=T.prototype.T=function(){return wa(this.N)};T.prototype.set_x=T.prototype.V=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);xa(c,a)};
Object.defineProperty(T.prototype,"x",{get:T.prototype.T,set:T.prototype.V});T.prototype.get_y=T.prototype.U=function(){return ya(this.N)};T.prototype.set_y=T.prototype.W=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);za(c,a)};Object.defineProperty(T.prototype,"y",{get:T.prototype.U,set:T.prototype.W});T.prototype.__destroy__=function(){Aa(this.N)};
function X(a,c,e,d){a&&"object"===typeof a&&(a=a.N);c&&"object"===typeof c&&(c=c.N);e&&"object"===typeof e&&(e=e.N);d&&"object"===typeof d&&(d=d.N);this.N=void 0===a?Ba():void 0===c?_emscripten_bind_ImVec4_ImVec4_1(a):void 0===e?_emscripten_bind_ImVec4_ImVec4_2(a,c):void 0===d?_emscripten_bind_ImVec4_ImVec4_3(a,c,e):Ca(a,c,e,d);K(X)[this.N]=this}X.prototype=Object.create(J.prototype);X.prototype.constructor=X;X.prototype.R=X;X.S={};b.ImVec4=X;X.prototype.get_x=X.prototype.T=function(){return Da(this.N)};
X.prototype.set_x=X.prototype.V=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Ea(c,a)};Object.defineProperty(X.prototype,"x",{get:X.prototype.T,set:X.prototype.V});X.prototype.get_y=X.prototype.U=function(){return Fa(this.N)};X.prototype.set_y=X.prototype.W=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Ga(c,a)};Object.defineProperty(X.prototype,"y",{get:X.prototype.U,set:X.prototype.W});X.prototype.get_z=X.prototype.da=function(){return Ha(this.N)};
X.prototype.set_z=X.prototype.ka=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Ia(c,a)};Object.defineProperty(X.prototype,"z",{get:X.prototype.da,set:X.prototype.ka});X.prototype.get_w=X.prototype.ba=function(){return Ja(this.N)};X.prototype.set_w=X.prototype.ja=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Ka(c,a)};Object.defineProperty(X.prototype,"w",{get:X.prototype.ba,set:X.prototype.ja});X.prototype.__destroy__=function(){La(this.N)};
function Y(){throw"cannot construct a ImDrawList, no constructor in IDL";}Y.prototype=Object.create(J.prototype);Y.prototype.constructor=Y;Y.prototype.R=Y;Y.S={};b.ImDrawList=Y;Y.prototype.__destroy__=function(){Ma(this.N)};function Z(){throw"cannot construct a ImDrawCmd, no constructor in IDL";}Z.prototype=Object.create(J.prototype);Z.prototype.constructor=Z;Z.prototype.R=Z;Z.S={};b.ImDrawCmd=Z;Z.prototype.get_ClipRect=Z.prototype.X=function(){return L(Na(this.N),X)};
Z.prototype.set_ClipRect=Z.prototype.ea=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Oa(c,a)};Object.defineProperty(Z.prototype,"ClipRect",{get:Z.prototype.X,set:Z.prototype.ea});Z.prototype.get_VtxOffset=Z.prototype.aa=function(){return Pa(this.N)};Z.prototype.set_VtxOffset=Z.prototype.ia=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Qa(c,a)};Object.defineProperty(Z.prototype,"VtxOffset",{get:Z.prototype.aa,set:Z.prototype.ia});Z.prototype.get_IdxOffset=Z.prototype.Z=function(){return Ra(this.N)};
Z.prototype.set_IdxOffset=Z.prototype.ga=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Sa(c,a)};Object.defineProperty(Z.prototype,"IdxOffset",{get:Z.prototype.Z,set:Z.prototype.ga});Z.prototype.get_ElemCount=Z.prototype.Y=function(){return Ta(this.N)};Z.prototype.set_ElemCount=Z.prototype.fa=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Ua(c,a)};Object.defineProperty(Z.prototype,"ElemCount",{get:Z.prototype.Y,set:Z.prototype.fa});Z.prototype.get_TextureId=Z.prototype.$=function(){return Va(this.N)};
Z.prototype.set_TextureId=Z.prototype.ha=function(a){var c=this.N;a&&"object"===typeof a&&(a=a.N);Wa(c,a)};Object.defineProperty(Z.prototype,"TextureId",{get:Z.prototype.$,set:Z.prototype.ha});Z.prototype.__destroy__=function(){Xa(this.N)};


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