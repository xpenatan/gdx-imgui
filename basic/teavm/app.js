"use strict";
(function(module){if(typeof define==='function'&&define.amd){define(['exports'],function(exports){module(exports);});}else if(typeof exports==='object'&&exports!==null&&typeof exports.nodeName!=='string'){module(exports);}else{module(typeof self!=='undefined'?self:this);}}(function(Bga){let BlO=2463534242,AO9=()=>{let x=BlO;x^=x<<13;x^=x>>>17;x^=x<<5;BlO=x;return x;},F=f=>function(){return f(this);},E=f=>function(p1){return f(this,p1);},G=f=>function(p1,p2){return f(this,p1,p2);},J=f=>function(p1,p2,p3){return f(this,
p1,p2,p3,p3);},R=f=>function(p1,p2,p3,p4){return f(this,p1,p2,p3,p4);},Blr=f=>function(){let args=Array.prototype.slice.apply(arguments);BlP(function(){f.apply(this,args);});},Bk4=f=>(args,callback)=>{if(!args){args=[];}let javaArgs=Bt(Of(),args.length);for(let i=0;i<args.length;++i){javaArgs.data[i]=Ba(args[i]);}BlP(()=>{f.call(null,javaArgs);},callback);},N=target=>target.$clinit=()=>{},BkC=obj=>{let cls=obj.constructor,arrayDegree=0;while(cls.$meta&&cls.$meta.item){++arrayDegree;cls=cls.$meta.item;}let clsName
="";if(cls.$meta.primitive){clsName=cls.$meta.name;}else {clsName=cls.$meta?cls.$meta.name||"a/"+cls.name:"@"+cls.name;}while(arrayDegree-->0){clsName+="[]";}return clsName;},B=superclass=>{if(superclass===0){return function(){};}if(superclass===void 0){superclass=Of();}return function(){superclass.call(this);};},Br=cls=>IN(cls),Of=()=>A,AJK=()=>{{return C2();}},JZ=t=>{{return DW(t);}};let BlQ=()=>{return {$array:null,classObject:null,$meta:{supertypes:[],superclass:null}};},BlR=(name,binaryName)=>{let cls=
BlQ();cls.$meta.primitive=true;cls.$meta.name=name;cls.$meta.binaryName=binaryName;cls.$meta.enum=false;cls.$meta.item=null;cls.$meta.simpleName=null;cls.$meta.declaringClass=null;cls.$meta.enclosingClass=null;return cls;},BlS=BlR("boolean","Z"),BkA=BlR("char","C"),BlT=BlR("byte","B"),BlU=BlR("short","S"),Bla=BlR("int","I"),Bk_=BlR("long","J"),Blj=BlR("float","F"),BkG=BlR("double","D"),FK=BlR("void","V");let BlV=new ArrayBuffer(16),BlW=new DataView(BlV),BlX=new Float32Array(BlV),BlY=new Float64Array(BlV),BlZ
=new Int32Array(BlV),BlK;if(typeof BigInt!=='function'){BlK=n=>{BlW.setFloat64(0,n,true);return new Bl0(BlW.getInt32(0,true),BlW.getInt32(4,true));};}else if(typeof BigInt64Array!=='function'){BlK=n=>{BlW.setFloat64(0,n,true);let lo=BlW.getInt32(0,true),hi=BlW.getInt32(4,true);return BigInt.asIntN(64,BigInt.asUintN(32,BigInt(lo))|BigInt(hi)<<BigInt(32));};}else {let $rt_numberConversionLongArray=new BigInt64Array(BlV);BlK=n=>{BlY[0]=n;return $rt_numberConversionLongArray[0];};}let BkL=n=>{BlX[0]=n;return BlZ[0];},
VF=n=>{BlZ[0]=n;return BlX[0];},CA=(a,b)=>a>b?1:a<b? -1:a===b?0:1,CW=Math.imul||function(a,b){let ah=a>>>16&0xFFFF,al=a&0xFFFF,bh=b>>>16&0xFFFF,bl=b&0xFFFF;return al*bl+(ah*bl+al*bh<<16>>>0)|0;},CS=(a,b)=>(a>>>0)/(b>>>0)>>>0,Bk3=(a,b)=>(a>>>0)%(b>>>0)>>>0,DD=(a,b)=>{a>>>=0;b>>>=0;return a<b? -1:a>b?1:0;};function Bl0(lo,hi){this.lo=lo|0;this.hi=hi|0;}Bl0.prototype.__teavm_class__=()=>{return "long";};let Bl1=a=>(a.hi&0x80000000)===0,Bl2=a=>(a.hi&0x80000000)!==0,Bl3=1<<18,Bg,C,Q,Xu,BkZ,U;if(typeof BigInt!=="function")
{Bl0.prototype.toString=function(){let result=[],n=this,positive=Bl1(n);if(!positive){n=A5i(n);}let radix=new Bl0(10,0);do {let divRem=Bl4(n,radix);result.push(String.fromCharCode(48+divRem[1].lo));n=divRem[0];}while(n.lo!==0||n.hi!==0);result=(result.reverse()).join('');return positive?result:"-"+result;};Bl0.prototype.valueOf=function(){return BkZ(this);};Bg=new Bl0(0,0);Q=val=>new Bl0(val, -(val<0)|0);Xu=val=>val>=0?new Bl0(val|0,val/0x100000000|0):A5i(new Bl0( -val|0, -val/0x100000000|0));C=(lo,hi)=>new Bl0(lo,
hi);BkZ=val=>0x100000000*val.hi+(val.lo>>>0);U=val=>val.lo;}else {Bg=BigInt(0);C=(lo,hi)=>BigInt.asIntN(64,BigInt.asUintN(64,BigInt(lo))|BigInt.asUintN(64,BigInt(hi)<<BigInt(32)));Q=val=>BigInt.asIntN(64,BigInt(val|0));Xu=val=>BigInt.asIntN(64,BigInt(val>=0?Math.floor(val):Math.ceil(val)));BkZ=val=>Number(val);U=val=>Number(BigInt.asIntN(32,val))|0;}let BS,AUp,ASZ,BkD,ATB,ATF,Blc,B1,AZq,Bl5,Bx,Ow,AKw,Ble,BkB,A5i,Cp,AUm,AF5,Ef,BkY,BV;if(typeof BigInt!=='function'){BS=(a,b)=>a.hi===b.hi&&a.lo===b.lo;AUp=(a,b)=>
a.hi!==b.hi||a.lo!==b.lo;ASZ=(a,b)=>{if(a.hi<b.hi){return false;}if(a.hi>b.hi){return true;}let x=a.lo>>>1,y=b.lo>>>1;if(x!==y){return x>y;}return (a.lo&1)>(b.lo&1);};BkD=(a,b)=>{if(a.hi<b.hi){return false;}if(a.hi>b.hi){return true;}let x=a.lo>>>1,y=b.lo>>>1;if(x!==y){return x>=y;}return (a.lo&1)>=(b.lo&1);};ATB=(a,b)=>{if(a.hi>b.hi){return false;}if(a.hi<b.hi){return true;}let x=a.lo>>>1,y=b.lo>>>1;if(x!==y){return x<y;}return (a.lo&1)<(b.lo&1);};ATF=(a,b)=>{if(a.hi>b.hi){return false;}if(a.hi<b.hi){return true;}let x
=a.lo>>>1,y=b.lo>>>1;if(x!==y){return x<=y;}return (a.lo&1)<=(b.lo&1);};B1=(a,b)=>{if(a.hi===a.lo>>31&&b.hi===b.lo>>31){return Xu(a.lo+b.lo);}else if(Bl6.abs(a.hi)<Bl3&&Bl6.abs(b.hi)<Bl3){return Xu(BkZ(a)+BkZ(b));}let a_lolo=a.lo&0xFFFF,a_lohi=a.lo>>>16,a_hilo=a.hi&0xFFFF,a_hihi=a.hi>>>16,b_lolo=b.lo&0xFFFF,b_lohi=b.lo>>>16,b_hilo=b.hi&0xFFFF,b_hihi=b.hi>>>16,lolo=a_lolo+b_lolo|0,lohi=a_lohi+b_lohi+(lolo>>16)|0,hilo=a_hilo+b_hilo+(lohi>>16)|0,hihi=a_hihi+b_hihi+(hilo>>16)|0;return new Bl0(lolo&0xFFFF|(lohi&
0xFFFF)<<16,hilo&0xFFFF|(hihi&0xFFFF)<<16);};Bl5=a=>{let lo=a.lo+1|0,hi=a.hi;if(lo===0){hi=hi+1|0;}return new Bl0(lo,hi);};A5i=a=>Bl5(new Bl0(a.lo^0xFFFFFFFF,a.hi^0xFFFFFFFF));AZq=(a,b)=>{if(a.hi===a.lo>>31&&b.hi===b.lo>>31){return Xu(a.lo -b.lo);}let a_lolo=a.lo&0xFFFF,a_lohi=a.lo>>>16,a_hilo=a.hi&0xFFFF,a_hihi=a.hi>>>16,b_lolo=b.lo&0xFFFF,b_lohi=b.lo>>>16,b_hilo=b.hi&0xFFFF,b_hihi=b.hi>>>16,lolo=a_lolo -b_lolo|0,lohi=a_lohi -b_lohi+(lolo>>16)|0,hilo=a_hilo -b_hilo+(lohi>>16)|0,hihi=a_hihi -b_hihi+(hilo>>16)
|0;return new Bl0(lolo&0xFFFF|(lohi&0xFFFF)<<16,hilo&0xFFFF|(hihi&0xFFFF)<<16);};Blc=(a,b)=>{let r=DD(a.hi,b.hi);if(r!==0){return r;}r=(a.lo>>>1) -(b.lo>>>1);if(r!==0){return r;}return (a.lo&1) -(b.lo&1);};Bx=(a,b)=>{let positive=Bl2(a)===Bl2(b);if(Bl2(a)){a=A5i(a);}if(Bl2(b)){b=A5i(b);}let a_lolo=a.lo&0xFFFF,a_lohi=a.lo>>>16,a_hilo=a.hi&0xFFFF,a_hihi=a.hi>>>16,b_lolo=b.lo&0xFFFF,b_lohi=b.lo>>>16,b_hilo=b.hi&0xFFFF,b_hihi=b.hi>>>16,lolo=0,lohi=0,hilo=0,hihi=0;lolo=a_lolo*b_lolo|0;lohi=lolo>>>16;lohi=(lohi&0xFFFF)
+a_lohi*b_lolo|0;hilo=hilo+(lohi>>>16)|0;lohi=(lohi&0xFFFF)+a_lolo*b_lohi|0;hilo=hilo+(lohi>>>16)|0;hihi=hilo>>>16;hilo=(hilo&0xFFFF)+a_hilo*b_lolo|0;hihi=hihi+(hilo>>>16)|0;hilo=(hilo&0xFFFF)+a_lohi*b_lohi|0;hihi=hihi+(hilo>>>16)|0;hilo=(hilo&0xFFFF)+a_lolo*b_hilo|0;hihi=hihi+(hilo>>>16)|0;hihi=hihi+a_hihi*b_lolo+a_hilo*b_lohi+a_lohi*b_hilo+a_lolo*b_hihi|0;let result=new Bl0(lolo&0xFFFF|lohi<<16,hilo&0xFFFF|hihi<<16);return positive?result:A5i(result);};Ow=(a,b)=>{if(Bl6.abs(a.hi)<Bl3&&Bl6.abs(b.hi)<Bl3){return Xu(BkZ(a)
/BkZ(b));}return (Long_divRem(a,b))[0];};Ble=(a,b)=>{if(a.hi>=0&&a.hi<Bl3&&b.hi>=0&&b.hi<Bl3){return Xu(BkZ(a)/BkZ(b));}return (Long_udivRem(a,b))[0];};AKw=(a,b)=>{if(Bl6.abs(a.hi)<Bl3&&Bl6.abs(b.hi)<Bl3){return Xu(BkZ(a)%BkZ(b));}return (Long_divRem(a,b))[1];};BkB=(a,b)=>{if(a.hi>=0&&a.hi<Bl3&&b.hi>=0&&b.hi<Bl3){return Xu(BkZ(a)/BkZ(b));}return (Long_udivRem(a,b))[1];};let Long_divRem=(a,b)=>{if(b.lo===0&&b.hi===0){throw new Error("Division by zero");}let positive=Bl2(a)===Bl2(b);if(Bl2(a)){a=A5i(a);}if(Bl2(b))
{b=A5i(b);}a=new Bl7(a.lo,a.hi,0);b=new Bl7(b.lo,b.hi,0);let q=LongInt_div(a,b);a=new Bl0(a.lo,a.hi);q=new Bl0(q.lo,q.hi);return positive?[q,a]:[A5i(q),A5i(a)];};Cp=(a,b)=>new Bl0(a.lo&b.lo,a.hi&b.hi);AUm=(a,b)=>new Bl0(a.lo|b.lo,a.hi|b.hi);AF5=(a,b)=>new Bl0(a.lo^b.lo,a.hi^b.hi);Ef=(a,b)=>{b&=63;if(b===0){return a;}else if(b<32){return new Bl0(a.lo<<b,a.lo>>>32 -b|a.hi<<b);}else if(b===32){return new Bl0(0,a.lo);}else {return new Bl0(0,a.lo<<b -32);}};BkY=(a,b)=>{b&=63;if(b===0){return a;}else if(b<32){return new Bl0(a.lo
>>>b|a.hi<<32 -b,a.hi>>b);}else if(b===32){return new Bl0(a.hi,a.hi>>31);}else {return new Bl0(a.hi>>b -32,a.hi>>31);}};BV=(a,b)=>{b&=63;if(b===0){return a;}else if(b<32){return new Bl0(a.lo>>>b|a.hi<<32 -b,a.hi>>>b);}else if(b===32){return new Bl0(a.hi,0);}else {return new Bl0(a.hi>>>b -32,0);}};function Bl7(lo,hi,sup){this.lo=lo;this.hi=hi;this.sup=sup;}}else {BS=(a,b)=>a===b;AUp=(a,b)=>a!==b;ASZ=(a,b)=>a>b;BkD=(a,b)=>a>=b;ATB=(a,b)=>a<b;ATF=(a,b)=>a<=b;B1=(a,b)=>BigInt.asIntN(64,a+b);Bl5=a=>BigInt.asIntN(64,
a+1);A5i=a=>BigInt.asIntN(64, -a);AZq=(a,b)=>BigInt.asIntN(64,a -b);Blc=(a,b)=>{a=BigInt.asUintN(64,a);b=BigInt.asUintN(64,b);return a<b? -1:a>b?1:0;};Bx=(a,b)=>BigInt.asIntN(64,a*b);Ow=(a,b)=>BigInt.asIntN(64,a/b);Ble=(a,b)=>BigInt.asIntN(64,BigInt.asUintN(64,a)/BigInt.asUintN(64,b));AKw=(a,b)=>BigInt.asIntN(64,a%b);BkB=(a,b)=>BigInt.asIntN(64,BigInt.asUintN(64,a)%BigInt.asUintN(64,b));Cp=(a,b)=>BigInt.asIntN(64,a&b);AUm=(a,b)=>BigInt.asIntN(64,a|b);AF5=(a,b)=>BigInt.asIntN(64,a^b);Ef=(a,b)=>BigInt.asIntN(64,
a<<BigInt(b&63));BkY=(a,b)=>BigInt.asIntN(64,a>>BigInt(b&63));BV=(a,b)=>BigInt.asIntN(64,BigInt.asUintN(64,a)>>BigInt(b&63));}let Bt=(cls,sz)=>{let data=new Array(sz);data.fill(null);return new (BkX(cls))(data);},H=(cls,init)=>Bl8(cls,init),Bl8=(cls,data)=>new (BkX(cls))(data),TQ;if(typeof BigInt64Array!=='function'){TQ=init=>new Bl9(init);}else {TQ=data=>{let buffer=new BigInt64Array(data.length);buffer.set(data);return new Bl9(buffer);};}let Cr=sz=>new Bl$(new Uint16Array(sz)),AY4=data=>{let buffer=new Uint16Array(data.length);buffer.set(data);return new Bl$(buffer);},
EL=sz=>new Bl_(new Int8Array(sz)),AT7=sz=>new Bma(new Int16Array(sz)),BlL=data=>{let buffer=new Int16Array(data.length);buffer.set(data);return new Bma(buffer);},Bp=sz=>new Bmb(new Int32Array(sz)),FM=data=>{let buffer=new Int32Array(data.length);buffer.set(data);return new Bmb(buffer);},Qh=sz=>new Bmc(new Int8Array(sz)),Cq=sz=>new Bmd(new Float32Array(sz)),BkX=cls=>{let result=cls.$array;if(result===null){function JavaArray(data){(Of()).call(this);this.data=data;}JavaArray.prototype=Object.create((Of()).prototype);JavaArray.prototype.type
=cls;JavaArray.prototype.constructor=JavaArray;JavaArray.prototype.toString=function(){let str="[";for(let i=0;i<this.data.length;++i){if(i>0){str+=", ";}str+=this.data[i].toString();}str+="]";return str;};JavaArray.prototype.b$=function(){let dataCopy;if('slice' in this.data){dataCopy=this.data.slice();}else {dataCopy=new this.data.constructor(this.data.length);for(let i=0;i<dataCopy.length;++i){dataCopy[i]=this.data[i];}}return new (BkX(this.type))(dataCopy);};let name="["+cls.$meta.binaryName;JavaArray.$meta
={item:cls,supertypes:[Of()],primitive:false,superclass:Of(),name:name,binaryName:name,enum:false,simpleName:null,declaringClass:null,enclosingClass:null};JavaArray.classObject=null;JavaArray.$array=null;result=JavaArray;cls.$array=JavaArray;}return result;};let Bme,BkH=strings=>{Bmf();Bme=new Array(strings.length);for(let i=0;i<strings.length;++i){Bme[i]=Bmg(Ba(strings[i]));}},D=index=>Bme[index],AMR=(array,offset,count)=>{let result="",limit=offset+count;for(let i=offset;i<limit;i=i+1024|0){let next=Math.min(limit,
i+1024|0);result+=String.fromCharCode.apply(null,array.subarray(i,next));}return result;},Bkq=array=>AMR(array,0,array.length),Ba=str=>str===null?null:ACT(str),Be=str=>str===null?null:str.wc,Bmf=()=>C8(),Bmg;{Bmg=str=>str;}let BcJ=(obj,cls)=>obj instanceof Of()&&!!obj.constructor.$meta&&Bmh(obj.constructor,cls),Bmh=(from,to)=>{if(from===to){return true;}if(to.$meta.item!==null){return from.$meta.item!==null&&Bmh(from.$meta.item,to.$meta.item);}let supertypes=from.$meta.supertypes;for(let i=0;i<supertypes.length;i
=i+1|0){if(Bmh(supertypes[i],to)){return true;}}return false;};let I=ex=>{throw BcC(ex);},Bmi=Symbol("javaException"),BcC=ex=>{let err=ex.$jsException;if(!err){let javaCause=Bmj(ex),jsCause=javaCause!==null?javaCause.$jsException:void 0,cause=typeof jsCause==="object"?{cause:jsCause}:void 0;err=new Bmk("Java exception thrown",cause);if(typeof Error.captureStackTrace==="function"){Error.captureStackTrace(err);}err[Bmi]=ex;ex.$jsException=err;Bml(err,ex);}return err;},Bml=(err,ex)=>{if(typeof Bmm==="function"
&&err.stack){let stack=Bmm(err.stack),javaStack=Bt(Bmn(),stack.length),elem,noStack=false;for(let i=0;i<stack.length;++i){let element=stack[i];elem=Bmo(Ba(element.className),Ba(element.methodName),Ba(element.fileName),element.lineNumber);if(elem==null){noStack=true;break;}javaStack.data[i]=elem;}if(!noStack){Bmp(ex,javaStack);}}},Bmk;if(typeof Bmq==='object'){let defaultMessage=Symbol("defaultMessage");Bmk=function Bmk(message,cause){let self=Reflect.construct(Error,[void 0,cause],Bmk);Object.setPrototypeOf(self,
Bmk.prototype);self[defaultMessage]=message;return self;};Bmk.prototype=Object.create(Error.prototype,{constructor:{configurable:true,writable:true,value:Bmk},message:{get(){try {let javaException=this[Bmi];if(typeof javaException==='object'){let javaMessage=Bmr(javaException);if(typeof javaMessage==="object"){return javaMessage!==null?javaMessage.toString():null;}}return this[defaultMessage];}catch(Bms){return "Exception occurred trying to extract Java exception message: "+Bms;}}}});}else {Bmk=Error;}let BkT
=e=>e instanceof Error&&typeof e[Bmi]==='object'?e[Bmi]:null,Bb=err=>{let ex=err[Bmi];if(!ex){ex=Bmt(Ba("(JavaScript) "+err.toString()));err[Bmi]=ex;ex.$jsException=err;Bml(err,ex);}return ex;},Bmt=message=>ARL(message),Bmr=t=>A_Y(t),Bmj=t=>Bab(t),Bmn=()=>Bmu,Bmo=(className,methodName,fileName,lineNumber)=>{{return null;}},Bmp=(e,stack)=>{};let Bmv=outputFunction=>{let buffer="";return msg=>{let index=0;while(true){let next=msg.indexOf('\n',index);if(next<0){break;}outputFunction(buffer+msg.substring(index,
next));buffer="";index=next+1;}buffer+=msg.substring(index);};},Bli=typeof $rt_putStdoutCustom==="function"?$rt_putStdoutCustom:typeof Bmw==="object"?Bmv(msg=>Bmw.info(msg)):()=>{},BkJ=typeof $rt_putStderrCustom==="function"?$rt_putStderrCustom:typeof Bmw==="object"?Bmv(msg=>Bmw.error(msg)):()=>{};let Bmx=null,Bkv=data=>{let i=0,packages=new Array(data.length);for(let j=0;j<data.length;++j){let prefixIndex=data[i++],prefix=prefixIndex>=0?packages[prefixIndex]:"";packages[j]=prefix+data[i++]+".";}Bmx=packages;},
BW=data=>{let packages=Bmx,i=0;while(i<data.length){let cls=data[i++];cls.$meta={};let m=cls.$meta,className=data[i++];m.name=className!==0?className:null;if(m.name!==null){let packageIndex=data[i++];if(packageIndex>=0){m.name=packages[packageIndex]+m.name;}}m.binaryName="L"+m.name+";";let superclass=data[i++];m.superclass=superclass!==0?superclass:null;m.supertypes=data[i++];if(m.superclass){m.supertypes.push(m.superclass);cls.prototype=Object.create(m.superclass.prototype);}else {cls.prototype={};}let flags
=data[i++];m.enum=(flags&8)!==0;m.flags=flags;m.primitive=false;m.item=null;cls.prototype.constructor=cls;cls.classObject=null;m.accessLevel=data[i++];let innerClassInfo=data[i++];if(innerClassInfo===0){m.simpleName=null;m.declaringClass=null;m.enclosingClass=null;}else {let enclosingClass=innerClassInfo[0];m.enclosingClass=enclosingClass!==0?enclosingClass:null;let declaringClass=innerClassInfo[1];m.declaringClass=declaringClass!==0?declaringClass:null;let simpleName=innerClassInfo[2];m.simpleName=simpleName
!==0?simpleName:null;}let clinit=data[i++];cls.$clinit=clinit!==0?clinit:function(){};let virtualMethods=data[i++];if(virtualMethods!==0){for(let j=0;j<virtualMethods.length;j+=2){let name=virtualMethods[j],func=virtualMethods[j+1];if(typeof name==='string'){name=[name];}for(let k=0;k<name.length;++k){cls.prototype[name[k]]=func;}}}cls.$array=null;}};function Bmy(runner){this.status=3;this.stack=[];this.suspendCallback=null;this.runner=runner;this.attribute=null;this.completeCallback=null;}Bmy.prototype.push
=function(){for(let i=0;i<arguments.length;++i){this.stack.push(arguments[i]);}return this;};Bmy.prototype.s=Bmy.prototype.push;Bmy.prototype.pop=function(){return this.stack.pop();};Bmy.prototype.l=Bmy.prototype.pop;Bmy.prototype.isResuming=function(){return this.status===2;};Bmy.prototype.isSuspending=function(){return this.status===1;};Bmy.prototype.suspend=function(callback){this.suspendCallback=callback;this.status=1;};Bmy.prototype.start=function(callback){if(this.status!==3){throw new Error("Thread already started");}if
(Bmz!==null){throw new Error("Another thread is running");}this.status=0;this.completeCallback=callback?callback:result=>{if(result instanceof Error){throw result;}};this.run();};Bmy.prototype.resume=function(){if(Bmz!==null){throw new Error("Another thread is running");}this.status=2;this.run();};Bmy.prototype.run=function(){Bmz=this;let result;try {result=this.runner();}catch(Bms){result=Bms;}finally {Bmz=null;}if(this.suspendCallback!==null){let self=this,callback=this.suspendCallback;this.suspendCallback
=null;callback(()=>self.resume());}else if(this.status===0){this.completeCallback(result);}};let DM=()=>{let thread=BZ();return thread!=null&&thread.isSuspending();},DO=()=>{let thread=BZ();return thread!=null&&thread.isResuming();},BlP=(runner,callback)=>(new Bmy(runner)).start(callback),Bmz=null,BZ=()=>Bmz,DB=()=>{throw new Error("Invalid recorded state");};function A(){this.v5=null;this.$id$=0;}
let Eo=b=>{let c;if(b.v5===null)Na(b);if(b.v5.wt===null)b.v5.wt=C2();else if(b.v5.wt!==C2())I(WM(D(0)));c=b.v5;c.wB=c.wB+1|0;},
CD=b=>{let c,d;if(!EN(b)&&b.v5.wt===C2()){c=b.v5;d=c.wB-1|0;c.wB=d;if(!d)b.v5.wt=null;EN(b);return;}I(ON());},
Blk=b=>{AXF(b,1);},
AXF=(b,c)=>{let d,$p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();d=$T.l();c=$T.l();b=$T.l();}_:while(true){switch($p){case 0:if(b.v5===null)Na(b);if(b.v5.wt===null)b.v5.wt=C2();if(b.v5.wt===C2()){d=b.v5;d.wB=d.wB+c|0;return;}$p=1;case 1:A1i(b,c);if(DM()){break _;}return;default:DB();}}BZ().s(b,c,d,$p);},
Na=b=>{b.v5=A0E();},
A1i=(b,c)=>{let $p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();c=$T.l();b=$T.l();}_:while(true){switch($p){case 0:$p=1;case 1:ALH(b,c);if(DM()){break _;}return;default:DB();}}BZ().s(b,c,$p);},
A2I=(b,c,d)=>{let e,f,g;e=C2();if(b.v5===null){Na(b);DW(e);f=b.v5;f.wB=f.wB+c|0;d.j(null);return;}if(b.v5.wt===null){b.v5.wt=e;DW(e);f=b.v5;f.wB=f.wB+c|0;d.j(null);return;}g=b.v5;if(g.wW===null)g.wW=AJD();A4x(g.wW,BgQ(e,b,c,d));},
Blp=b=>{AKV(b,1);},
AKV=(b,c)=>{let d;if(!EN(b)&&b.v5.wt===C2()){d=b.v5;d.wB=d.wB-c|0;if(d.wB>0)return;d.wt=null;if(d.wW!==null&&!GC(d.wW))AAF(AUi(b));else EN(b);return;}I(ON());},
Bbi=b=>{let c,d,e;if(!EN(b)&&b.v5.wt===null){c=b.v5;if(c.wW!==null&&!GC(c.wW)){d=c.wW;e=ACr(d);c.wW=null;e.s();}return;}},
EN=a=>{let b,c;b=a.v5;if(b===null)return 1;a:{b:{if(b.wt===null){if(b.wW!==null){c=b.wW;if(!GC(c))break b;}if(b.AI===null)break a;c=b.AI;if(GC(c))break a;}}return 0;}Bg8(a);return 1;},
Bg8=a=>{a.v5=null;},
A7S=b=>{return b.v5!==null&&b.v5.wt===C2()?1:0;},
L=a=>{return;},
UW=()=>{let a=new A();L(a);return a;},
Do=a=>{return IN(a.constructor);},
AR$=a=>{return J5(a);},
A4k=(a,b)=>{return a!==b?0:1;},
TD=a=>{let b,c;b=P_(J5(a));c=O();K(K(c,D(1)),b);return S(c);},
J5=a=>{let b,c;b=a;if(!b.$id$){c=AO9();b.$id$=c;}return a.$id$;},
A2w=a=>{let b,c,d;if(!BcJ(a,Du)){b=a;if(b.constructor.$meta.item===null)I(A5I());}c=AKa(a);b=c;d=AO9();b.$id$=d;return c;},
JK=a=>{let b,c;if(!A7S(a))I(ON());b=a.v5.AI;if(b===null)return;while(!GC(b)){c=ACr(b);if(!c.B())AAF(c);}a.v5.AI=null;},
A1O=b=>{Bbi(b);},
A5r=(b,c,d,e)=>{let f;DW(b);c.v5.wt=b;f=c.v5;f.wB=f.wB+d|0;e.j(null);},
ALH=(b,c)=>{let thread=BZ();let javaThread=AJK();if(thread.isResuming()){thread.status=0;let result=thread.attribute;if(result instanceof Error){throw result;}return result;}let callback=function(){};callback.j=val=>{thread.attribute=val;JZ(javaThread);thread.resume();};callback.u5=e=>{thread.attribute=BcC(e);JZ(javaThread);thread.resume();};callback=Z1(callback);thread.suspend(()=>{try {A2I(b,c,callback);;}catch(Qf){callback.u5(Qf);}});return null;};
function W(){let a=this;A.call(a);a.CE=null;a.BY=null;}
let Bn=a=>{L(a);},
A_v=(a,b)=>{if(!b&&a.CE===null)a.CE=a.D();else if(b&&a.BY===null)a.BY=(a.D()).E(1);if(b)return a.BY;return a.CE;};
let Z2=B(W);
let AEA=a=>{Bn(a);},
AOl=()=>{let a=new Z2();AEA(a);return a;},
ASc=a=>{return ((Cy()).F(32)).F(9);};
let U1=B(W);
let AHe=a=>{Bn(a);},
AUk=()=>{let a=new U1();AHe(a);return a;},
A4F=a=>{return ((Cy()).G(0,31)).F(127);};
let El=B(0);
function Rg(){A.call(this);this.Cf=null;}
let Qp=(a,b)=>{a.Cf=b;L(a);},
A0D=a=>{let b=new Rg();Qp(b,a);return b;},
AJR=a=>{let b;b=a.Cf.Aa.H();a.Cf.AS.Do.DQ.I(b);};
let Ep=B();
let NC=B(0);
let HW=B(Ep);
let AVJ=null;
let AB0=()=>{AB0=N(HW);AZP();};
let AZP=()=>{AVJ=BF();};
let KN=B(0);
let B6=B(HW);
let DC=B(B6);
let ANC=null,A1f=null,A_1=null,Bi1=null,A6A=null,AJA=null,AVj=null,A5M=null;
let Wz=()=>{Wz=N(DC);BaY();};
let BaY=()=>{ANC=CE(0.0,0.0,1.0,1.0);A1f=CE(1.0,0.0,0.0,1.0);A_1=CE(0.0,1.0,0.0,1.0);Bi1=AQG();A6A=AI6();AJA=ALO();AVj=AYM();A5M=AWf();};
let Bd=B();
let ANZ=null,A_L=null,AS8=null,AEo=null,ARA=null,AVb=null,Zu=null,AKM=null,ZH=null,ARx=null,A4M=null,ATZ=null,AU_=null,AMy=null,AKb=null,A$v=null,AXh=null,AVg=null,ARG=null,A9Q=null,AVf=null,Beo=null,AVn=null,A2O=null,BdJ=null,A3J=null,AI$=null,AKt=null,A_D=null,AV4=null,Bi7=null,A8D=null,Be$=null,A0T=null,A$k=null,BjQ=null,AYC=null,AZh=null,AKQ=null,BaH=null,Bjb=null,BfD=null,A8Y=null,Bjv=null;
let Pd=()=>{Pd=N(Bd);AOD();};
let BN=a=>{Pd();L(a);},
AOD=()=>{ANZ=AMo();A_L=AJs();AS8=A0g();AEo=APH();ARA=AEo;AVb=G2(2);Zu=IR(2);AKM=Zu;ZH=JD(2);ARx=ZH;A4M=BbR();ATZ=AT4();AU_=G2(3);AMy=IR(3);AKb=JD(3);A$v=A2j();AXh=A_x();AVg=G2(4);ARG=IR(4);A9Q=JD(4);AVf=G2(5);Beo=IR(5);AVn=JD(5);A2O=Bkd();BdJ=ALl();A3J=ALT();AI$=T6(2.0,10.0);AKt=VP(2.0,10.0);A_D=ABy(2.0,10.0);AV4=T6(2.0,5.0);Bi7=VP(2.0,5.0);A8D=ABy(2.0,5.0);Be$=AYx();A0T=AVL();A$k=BaI();BjQ=A_0(2.0,10.0,7,1.0);AYC=ATE(2.0,10.0,6,1.0);AZh=A8m(2.0,10.0,7,1.0);AKQ=AWT(1.5);BaH=BgF(2.0);Bjb=A6w(2.0);BfD=AZv(4);A8Y
=A5u(4);Bjv=AR1(4);};
function Fx(){let a=this;Bd.call(a);a.wx=null;a.wN=null;}
let HP=(a,b)=>{let c;BN(a);if(b>=2&&b<=5){b:{a.wx=Cq(b);a.wN=Cq(b);a.wN.data[0]=1.0;switch(b){case 2:break;case 3:a.wx.data[0]=0.4000000059604645;a.wx.data[1]=0.4000000059604645;a.wx.data[2]=0.20000000298023224;a.wN.data[1]=0.33000001311302185;a.wN.data[2]=0.10000000149011612;break b;case 4:a.wx.data[0]=0.3400000035762787;a.wx.data[1]=0.3400000035762787;a.wx.data[2]=0.20000000298023224;a.wx.data[3]=0.15000000596046448;a.wN.data[1]=0.25999999046325684;a.wN.data[2]=0.10999999940395355;a.wN.data[3]=0.029999999329447746;break b;case 5:a.wx.data[0]
=0.30000001192092896;a.wx.data[1]=0.30000001192092896;a.wx.data[2]=0.20000000298023224;a.wx.data[3]=0.10000000149011612;a.wx.data[4]=0.10000000149011612;a.wN.data[1]=0.44999998807907104;a.wN.data[2]=0.30000001192092896;a.wN.data[3]=0.15000000596046448;a.wN.data[4]=0.05999999865889549;break b;default:break b;}a.wx.data[0]=0.6000000238418579;a.wx.data[1]=0.4000000059604645;a.wN.data[1]=0.33000001311302185;}c=a.wx.data;c[0]=c[0]*2.0;return;}I(B3((((O()).O(D(2))).P(b)).y()));},
AR1=a=>{let b=new Fx();HP(b,a);return b;};
let A0C=B();
let AO2=B();
let Bj8=b=>{let c,d;c=b.Q();d=c.data;if(d.length<=0)return null;return K8(d[0]);},
A6f=(b,c)=>{let d,e,f,g,h,$$je;if(c!==null&&c.data.length){b:{c:{try{d=b.S(c);e=K8(d);}catch($$e){$$je=Bb($$e);if($$je instanceof KZ){f=$$je;break b;}else if($$je instanceof HV){f=$$je;break c;}else{throw $$e;}}return e;}e=new D8;g=b.T();h=O();K(K(h,D(3)),g);Fh(e,S(h),f);I(e);}e=new D8;g=b.T();h=O();K(K(K(h,D(4)),g),D(5));Fh(e,S(h),f);I(e);}return Bj8(b);},
ATK=(b,c)=>{let d,e,f,g,h,$$je;a:{try{d=b.W(c);e=K8(d);}catch($$e){$$je=Bb($$e);if($$je instanceof KZ){f=$$je;break a;}else if($$je instanceof HV){f=$$je;e=new D8;g=b.T();h=O();K(K(h,D(3)),g);Fh(e,S(h),f);I(e);}else{throw $$e;}}return e;}e=new D8;g=b.T();h=O();K(K(h,D(6)),g);Fh(e,S(h),f);I(e);};
let Pb=B(0);
let D1=B();
let Bs=B(0);
let Dg=B();
let PN=a=>{L(a);};
let Cf=B(0);
function F4(){Dg.call(this);this.A6=0;}
let AKF=null,Gn=null;
let B_=()=>{B_=N(F4);Bbx();};
let U4=(a,b)=>{B_();PN(a);a.A6=b;},
AF2=a=>{let b=new F4();U4(b,a);return b;},
ARX=(b,c)=>{B_();if(!(c>=2&&c<=36))c=10;return ((Bgd(20)).X(b,c)).y();},
P_=b=>{B_();return AKd(b,4);},
Od=b=>{B_();return ARX(b,10);},
Hh=(b,c)=>{B_();if(b!==null)return BfA(b,0,b.bb(),c);I(E4(D(7)));},
BfA=(b,c,d,e)=>{let f,g,h,i,j,k,l,m,n;B_();if(c==d)I(E4(D(8)));if(e>=2&&e<=36){c:{f=0;switch(b.bc(c)){case 43:g=c+1|0;break c;case 45:f=1;g=c+1|0;break c;default:}g=c;}h=0;i=1+(2147483647/e|0)|0;if(g==d)I(AIE());while(true){if(g>=d){if(f)h= -h|0;return h;}j=g+1|0;k=Bay(b.bc(g));if(k<0){l=new B$;m=b.be(c,d);n=O();K(K(n,D(9)),m);C9(l,S(n));I(l);}if(k>=e){l=new B$;m=b.be(c,d);n=O();K(K(V(K(n,D(10)),e),D(11)),m);C9(l,S(n));I(l);}if(h>i)break;h=CW(e,h)+k|0;if(h<0){if(j==d&&h==(-2147483648)&&f)return (-2147483648);l
=new B$;m=b.be(c,d);n=O();K(K(n,D(12)),m);C9(l,S(n));I(l);}g=j;}I(E4(D(13)));}l=new B$;m=O();V(K(m,D(14)),e);C9(l,S(m));I(l);},
ASv=b=>{B_();return Hh(b,10);},
DG=b=>{B_();if(b>=(-128)&&b<=127){ANp();return Gn.data[b+128|0];}return AF2(b);},
ANp=()=>{let b;B_();d:{if(Gn===null){Gn=Bt(F4,256);b=0;while(true){if(b>=Gn.data.length)break d;Gn.data[b]=AF2(b-128|0);b=b+1|0;}}}},
AM2=a=>{return a.A6;},
BhO=(a,b)=>{if(a===b)return 1;return b instanceof F4&&b.A6==a.A6?1:0;},
Bay=b=>{B_();if(b>=48&&b<=57)return b-48|0;if(b>=97&&b<=122)return (b-97|0)+10|0;if(b>=65&&b<=90)return (b-65|0)+10|0;return (-1);},
Sl=b=>{let c,d,e;B_();if(!b)return 32;c=0;d=b>>>16|0;if(d)c=16;else d=b;e=d>>>8|0;if(!e)e=d;else c=c|8;d=e>>>4|0;if(!d)d=e;else c=c|4;e=d>>>2|0;if(!e)e=d;else c=c|2;if(e>>>1|0)c=c|1;return (32-c|0)-1|0;},
Gz=b=>{let c,d,e;B_();if(!b)return 32;c=0;d=b<<16;if(d)c=16;else d=b;e=d<<8;if(!e)e=d;else c=c|8;d=e<<4;if(!d)d=e;else c=c|4;e=d<<2;if(!e)e=d;else c=c|2;if(e<<1)c=c|1;return (32-c|0)-1|0;},
AVY=(b,c)=>{let d;B_();d=c&31;return b<<d|(b>>>(32-d|0)|0);},
Bbx=()=>{AKF=Br(Bla);};
let AGl=B();
let Ck=B(0);
let D0=B(0);
let Gk=B(0);
let Ex=B();
let BX=B(Ex);
let GR=B(BX);
let Is=B(W);
let Lu=a=>{Bn(a);},
BeQ=()=>{let a=new Is();Lu(a);return a;},
Ud=a=>{return ((Cy()).G(97,122)).G(65,90);};
let AH3=B();
let Bbm=0,Bg_=0,A4i=0,Bhu=0,AXq=0;
let AD2=()=>{AD2=N(AH3);BgU();};
let BgU=()=>{let b;Bbm=Ba(navigator.platform).bh(D(15));Bg_=Ba(navigator.platform).bh(D(16));A4i=Ba(navigator.platform).bh(D(17));Bhu=!Ba(navigator.platform).bh(D(18))&&!Ba(navigator.platform).bh(D(19))?0:1;b=!Ba(navigator.platform).bh(D(20))&&!Ba(navigator.platform).bh(D(21))&&!Ba(navigator.platform).bh(D(22))?0:1;AXq=b;};
let DE=B(0);
let BC=B();
let DA=B(BC);
let AZe=B(DA);
let Hd=B(W);
let LQ=a=>{Bn(a);},
A6J=()=>{let a=new Hd();LQ(a);return a;},
Z5=a=>{return ((((Cy()).G(97,122)).G(65,90)).G(48,57)).F(95);};
let AFH=B(Hd);
let XE=a=>{LQ(a);},
ANE=()=>{let a=new AFH();XE(a);return a;},
A5E=a=>{let b;b=(Z5(a)).E(1);b.v3=1;return b;};
let Dc=B(0);
let Sd=B();
let AR5=0,GD=0,Qe=0,OM=0,L9=0;
let Jp=()=>{Jp=N(Sd);AYZ();};
let AYZ=()=>{AR5=imgui.ImGuiDir_None;GD=imgui.ImGuiDir_Left;Qe=imgui.ImGuiDir_Right;OM=imgui.ImGuiDir_Up;L9=imgui.ImGuiDir_Down;};
let BE=B(0);
let Db=B(0);
function LH(){let a=this;A.call(a);a.C5=null;a.CS=null;a.Dx=null;a.AT=null;}
let ACy=(a,b,c,d,e)=>{a.AT=b;a.C5=c;a.CS=d;a.Dx=e;L(a);},
A9d=(a,b,c,d)=>{let e=new LH();ACy(e,a,b,c,d);return e;},
AW5=(a,b)=>{if(Ba(b.type).bi(D(23)))a.AT.y9.bj(a.C5);else{KR(a.CS,a.Dx);a.AT.y9.bl(a.C5,a.CS);}a.AT.z3.bm();},
AUr=(a,b)=>{a.bn(b);};
function Bz(){let a=this;A.call(a);a.DB=null;a.FH=0;}
let Ce=(a,b,c)=>{L(a);a.DB=b;a.FH=c;},
Bl=a=>{return a.FH;},
AXL=a=>{return a.DB.y();};
let Hi=B(Bz);
let PX=null,OJ=null,TU=null,Oc=null,ET=null,Oz=null,AWy=null;
let D3=()=>{D3=N(Hi);AQ6();};
let AN$=(a,b,c)=>{D3();Ce(a,b,c);},
Fc=(a,b)=>{let c=new Hi();AN$(c,a,b);return c;},
AQ6=()=>{PX=Fc(D(15),0);OJ=Fc(D(24),1);TU=Fc(D(25),2);Oc=Fc(D(26),3);ET=Fc(D(27),4);Oz=Fc(D(28),5);AWy=H(Hi,[PX,OJ,TU,Oc,ET,Oz]);};
function Bw(){let a=this;A.call(a);a.vN=null;a.ww=0;a.DX=null;a.FA=0;}
let Fa=0;
let FU=()=>{FU=N(Bw);BiE();};
let Cd=a=>{let b;FU();L(a);b=Fa;Fa=b+1|0;a.DX=Od(b);},
M2=(a,b)=>{let c;FU();L(a);c=Fa;Fa=c+1|0;a.DX=Od(c);a.vN=b;},
FY=(a,b,c,d)=>{let e;e=d.bq();while(true){if(b>e)return (-1);if(a.br(b,c,d)>=0)break;b=b+1|0;}return b;},
F$=(a,b,c,d,e)=>{while(true){if(c<b)return (-1);if(a.br(c,d,e)>=0)break;c=c+(-1)|0;}return c;},
AQ$=(a,b)=>{a.FA=b;},
APr=a=>{return a.FA;},
Bbh=a=>{return a.vN;},
Po=(a,b)=>{a.vN=b;},
Bd4=(a,b)=>{return 1;},
Bha=a=>{return null;},
QP=a=>{let b;a.ww=1;if(a.vN!==null){if(!a.vN.ww){b=a.vN.bs();if(b!==null){a.vN.ww=1;a.vN=b;}a.vN.bt();}else if(a.vN instanceof E0&&a.vN.wM.BE)a.vN=a.vN.vN;}},
BiE=()=>{Fa=1;};
function BM(){Bw.call(this);this.wj=0;}
let RN=(a,b)=>{M2(a,b);a.wj=1;a.bv(1);},
CO=a=>{Cd(a);a.wj=1;},
BiP=(a,b,c,d)=>{let e;if((b+a.bw()|0)>d.bq()){d.wZ=1;return (-1);}e=a.bx(b,c);if(e<0)return (-1);return a.vN.br(b+e|0,c,d);},
Bcp=a=>{return a.wj;},
A0A=(a,b)=>{return 1;};
function RP(){BM.call(this);this.zo=null;}
let W_=(a,b)=>{CO(a);a.zo=b.y();a.wj=b.bb();},
Bki=a=>{let b=new RP();W_(b,a);return b;},
Bav=(a,b,c)=>{let d,e,f,g;d=0;while(true){if(d>=a.zo.bb())return a.zo.bb();e=a.zo.bc(d);f=b+d|0;if(e!=c.bc(f)){g=a.zo;if(FS(g.bc(d))!=c.bc(f))break;}d=d+1|0;}return (-1);};
let JG=B(0);
function B4(){let a=this;A.call(a);a.CI=null;a.yg=null;a.AO=0;a.A_=0;a.DT=null;}
let WS=a=>{a.AO=1;a.A_=1;a.bz();},
Blw=()=>{let a=new B4();WS(a);return a;},
PU=(a,b)=>{a.AO=1;a.A_=1;a.bz();a.CI=b;},
Bky=a=>{let b=new B4();PU(b,a);return b;},
M1=(a,b,c)=>{a.AO=1;a.A_=1;a.bz();a.CI=b;a.yg=c;},
Bln=(a,b)=>{let c=new B4();M1(c,a,b);return c;},
AGm=(a,b)=>{a.AO=1;a.A_=1;a.bz();a.yg=b;},
BkN=a=>{let b=new B4();AGm(b,a);return b;},
AVe=a=>{return a;},
A_Y=a=>{return a.CI;},
AW3=a=>{return a.bA();},
Bab=a=>{return a.yg===a?null:a.yg;},
AYm=a=>{a.bB(AEH());},
BiB=(a,b)=>{let c,d,e,f,g,h;b.bD((Do(a)).T());c=a.bF();if(c!==null){d=O();K(K(d,D(11)),c);b.bD(S(d));}a:{b.bG();if(a.DT!==null){e=a.DT.data;f=e.length;g=0;while(true){if(g>=f)break a;h=e[g];b.bD(D(29));b.bH(h);g=g+1|0;}}}if(a.yg!==null&&a.yg!==a){b.bD(D(30));a.yg.bB(b);}};
let C7=B(B4);
let Oj=(a,b,c)=>{M1(a,b,c);},
Blz=(a,b)=>{let c=new C7();Oj(c,a,b);return c;},
LI=(a,b)=>{PU(a,b);},
Bk$=a=>{let b=new C7();LI(b,a);return b;},
N8=(a,b)=>{AGm(a,b);},
Bkw=a=>{let b=new C7();N8(b,a);return b;};
let Fz=B(C7);
let Kb=(a,b)=>{LI(a,b);},
Bk5=a=>{let b=new Fz();Kb(b,a);return b;};
let WY=B();
let Kr=null;
let HJ=()=>{HJ=N(WY);A6B();};
let Bdy=(b,c)=>{let d;HJ();d=Kr.bJ(b);if(d===null){d=Bhw(b,4,c);Kr.bL(b,d);}return d;},
AC6=b=>{HJ();return Bdy(b,100);},
A6B=()=>{Kr=Dl();};
let AAD=B();
function AGI(){Bd.call(this);this.HA=0.0;}
let ZT=(a,b)=>{BN(a);a.HA=b;},
A6w=a=>{let b=new AGI();ZT(b,a);return b;};
function MG(){let a=this;W.call(a);a.CR=0;a.Bb=0;a.DZ=0;}
let Uk=(a,b,c)=>{Bn(a);a.Bb=c;a.CR=b;},
By=(a,b)=>{let c=new MG();Uk(c,a,b);return c;},
AHq=(a,b,c,d)=>{Bn(a);a.DZ=d;a.Bb=c;a.CR=b;},
A2Y=(a,b,c)=>{let d=new MG();AHq(d,a,b,c);return d;},
AVC=a=>{let b;b=Bhd(a.CR);if(a.DZ)b.wd.bN(0,2048);b.v3=a.Bb;return b;};
function Fm(){let a=this;Bd.call(a);a.Hq=0.0;a.HX=0.0;a.Gf=0.0;a.H1=0.0;}
let IT=(a,b,c)=>{BN(a);a.Hq=b;a.HX=c;a.Gf=Bj9(b, -c);a.H1=1.0/(1.0-a.Gf);},
T6=(a,b)=>{let c=new Fm();IT(c,a,b);return c;};
let AW2=B();
function Cj(){let a=this;Bw.call(a);a.BE=0;a.y6=0;}
let GI=null;
let Ez=()=>{Ez=N(Cj);AUw();};
let Ed=(a,b)=>{Ez();Cd(a);a.y6=b;},
A_W=a=>{let b=new Cj();Ed(b,a);return b;},
ANu=(a,b,c,d)=>{let e,f;e=d.bP(a.y6);d.bQ(a.y6,b);f=a.vN.br(b,c,d);if(f<0)d.bQ(a.y6,e);return f;},
A4q=a=>{return a.y6;},
AOO=(a,b)=>{return 0;},
AUw=()=>{GI=AQr();};
let LP=B(Cj);
let Ps=(a,b)=>{Ed(a,b);},
BlH=a=>{let b=new LP();Ps(b,a);return b;},
APi=(a,b,c,d)=>{let e,f;e=a.bR();f=d.bS(e);if(f!=b)b=(-1);return b;};
let I6=B(0);
let A7O=B();
function BD(){let a=this;Bw.call(a);a.wg=null;a.wM=null;a.v8=0;}
let Cu=a=>{Cd(a);},
Bkp=()=>{let a=new BD();Cu(a);return a;},
NY=(a,b,c)=>{Cd(a);a.wg=b;a.wM=c;a.v8=c.bR();},
A12=(a,b)=>{let c=new BD();NY(c,a,b);return c;},
AXm=(a,b,c,d)=>{let e,f,g,h,i;if(a.wg===null)return (-1);e=d.bT(a.v8);d.bU(a.v8,b);f=a.wg.bV();g=0;while(true){if(g>=f){d.bU(a.v8,e);return (-1);}h=a.wg.bW(g);i=h.br(b,c,d);if(i>=0)break;g=g+1|0;}return i;},
A8y=(a,b)=>{a.wM.bX(b);},
A23=(a,b)=>{let c;a:{if(a.wg!==null){c=a.wg.bY();while(true){if(!c.bZ())break a;if(!(c.b0()).b1(b))continue;else return 1;}}}return 0;},
A$r=(a,b)=>{let c,d;d:{if(b.bP(a.v8)>=0){c=b.bT(a.v8);d=a.v8;if(c==b.bP(d)){c=0;break d;}}c=1;}return c;},
AQu=a=>{let b,c,d,e;a.ww=1;if(a.wM!==null&&!a.wM.ww)a.wM.bt();a:{if(a.wg!==null){b=a.wg.bV();c=0;while(true){if(c>=b)break a;d=a.wg.bW(c);e=d.bs();if(e===null)e=d;else{d.ww=1;a.wg.b2(c);a.wg.b3(c,e);}if(!e.ww)e.bt();c=c+1|0;}}}if(a.vN!==null)QP(a);};
function Q2(){let a=this;BD.call(a);a.Ef=null;a.Gy=0;}
let AGf=(a,b)=>{Cu(a);a.Ef=b.b4();a.Gy=b.wa;},
AJ1=a=>{let b=new Q2();AGf(b,a);return b;},
AU9=(a,b)=>{a.vN=b;},
AYV=(a,b,c,d)=>{let e,f,g,h,i,j,k;e=d.b5();f=d.bq();g=b+1|0;h=CA(g,f);if(h>0){d.wZ=1;return (-1);}i=c.bc(b);if(!a.Ef.b6(i))return (-1);if(Cs(i)){if(h<0){j=c.bc(g);if(CU(j))return (-1);}}else if(CU(i)&&b>e){k=c.bc(b-1|0);if(Cs(k))return (-1);}return a.vN.br(g,c,d);};
let AH8=B(0);
let ABp=B(0);
let ADi=B(0);
let Ge=B();
let JU=a=>{L(a);};
function P2(){Ge.call(this);this.Gu=null;}
let ZI=a=>{KV(a,32);},
A4y=()=>{let a=new P2();ZI(a);return a;},
KV=(a,b)=>{JU(a);a.Gu=EL(b);},
BlA=a=>{let b=new P2();KV(b,a);return b;};
let AIJ=B();
let AVi=null,Ks=null,PW=null;
let UI=()=>{UI=N(AIJ);ALc();};
let ALc=()=>{let b;AVi=Bt(Dd,15);Ks=Bt(Dd,8);PW=Bt(Dd,9);b=0;while(b<PW.data.length){PW.data[b]=X();b=b+1|0;}b=0;while(b<Ks.data.length){Ks.data[b]=X();b=b+1|0;}};
let Vc=B(0);
let A6b=B();
let C6=null,B5=null,A24=null,Vl=null,A2c=null,A$p=null,Bc=null,Y=null,Ek=null;
let B8=B(B4);
let Ff=a=>{WS(a);},
Bko=()=>{let a=new B8();Ff(a);return a;},
KG=(a,b,c)=>{M1(a,b,c);},
Blx=(a,b)=>{let c=new B8();KG(c,a,b);return c;},
J$=(a,b)=>{PU(a,b);},
Blh=a=>{let b=new B8();J$(b,a);return b;};
let Bi=B(B8);
let B9=a=>{Ff(a);},
BkE=()=>{let a=new Bi();B9(a);return a;},
Dw=(a,b)=>{J$(a,b);},
ARL=a=>{let b=new Bi();Dw(b,a);return b;};
let A0M=B(Bi);
let Kn=B(0);
let I7=B();
let LY=a=>{L(a);},
Blm=()=>{let a=new I7();LY(a);return a;},
ALe=(a,b)=>{return;};
let Yd=B(0);
function E2(){let a=this;I7.call(a);a.Hh=null;a.Hf=null;a.Fb=0;a.Es=0;a.E0=null;a.Im=null;}
let Or=(a,b,c,d,e,f,g)=>{LY(a);a.Hh=b;a.Hf=c;a.Fb=d;a.Es=e;a.E0=f;a.Im=g;},
Bll=(a,b,c,d,e,f)=>{let g=new E2();Or(g,a,b,c,d,e,f);return g;},
A8P=a=>{return ATH(a.Fb,a.Es);},
AXO=a=>{return a.E0.b$();};
function Dp(){Bw.call(this);this.vY=null;}
let FL=(a,b,c,d)=>{M2(a,c);a.vY=b;a.bv(d);},
Bja=a=>{return a.vY;},
Ban=(a,b)=>{return !a.vY.b1(b)&&!a.vN.b1(b)?0:1;},
BeM=(a,b)=>{return 1;},
A4O=a=>{let b;a.ww=1;if(a.vN!==null&&!a.vN.ww){b=a.vN.bs();if(b!==null){a.vN.ww=1;a.vN=b;}a.vN.bt();}if(a.vY!==null){if(!a.vY.ww){b=a.vY.bs();if(b!==null){a.vY.ww=1;a.vY=b;}a.vY.bt();}else if(a.vY instanceof E0&&a.vY.wM.BE)a.vY=a.vY.vN;}};
let CB=B(Dp);
let Es=(a,b,c,d)=>{FL(a,b,c,d);},
AQf=(a,b,c)=>{let d=new CB();Es(d,a,b,c);return d;},
AKW=(a,b,c,d)=>{let e;if(!a.vY.ca(d))return a.vN.br(b,c,d);e=a.vY.br(b,c,d);if(e>=0)return e;return a.vN.br(b,c,d);};
let Va=B(CB);
let Za=(a,b,c,d)=>{Es(a,b,c,d);Ez();b.bX(GI);},
A5p=(a,b,c)=>{let d=new Va();Za(d,a,b,c);return d;},
A5o=(a,b,c,d)=>{let e,f;e=a.vY.br(b,c,d);if(e<0)return (-1);if(e>b){while(true){f=a.vY.br(e,c,d);if(f<=e)break;e=f;}b=e;}return a.vN.br(b,c,d);};
function Ec(){let a=this;A.call(a);a.vO=null;a.v6=0;}
let Hn=a=>{Ha(a,16);},
BkO=()=>{let a=new Ec();Hn(a);return a;},
Ha=(a,b)=>{L(a);a.vO=Cr(b);},
Bgd=a=>{let b=new Ec();Ha(b,a);return b;},
X0=(a,b)=>{return a.cb(a.v6,b);},
ACt=(a,b)=>{return a.cc(a.v6,b);},
AEz=(a,b,c)=>{let d,e,f;if(b>=0&&b<=a.v6){if(c===null)c=D(31);else if(c.cd())return a;a.ce(a.v6+c.bb()|0);d=a.v6-1|0;while(d>=b){a.vO.data[d+c.bb()|0]=a.vO.data[d];d=d+(-1)|0;}a.v6=a.v6+c.bb()|0;d=0;while(d<c.bb()){e=a.vO.data;f=b+1|0;e[b]=c.bc(d);d=d+1|0;b=f;}return a;}I(FT());},
SV=(a,b)=>{return a.X(b,10);},
AMD=(a,b,c)=>{return a.cf(a.v6,b,c);},
AZC=(a,b,c,d)=>{let e,f,g,h,i,j,k,l;e=1;if(c<0){e=0;c= -c|0;}b:{if(DD(c,d)<0){if(e)BU(a,b,b+1|0);else{BU(a,b,b+2|0);f=a.vO.data;g=b+1|0;f[b]=45;b=g;}a.vO.data[b]=GV(c,d);}else{h=1;i=1;j=CS((-1),d);e:{while(true){k=CW(h,d);if(DD(k,c)>0){k=h;break e;}i=i+1|0;if(DD(k,j)>0)break;h=k;}}if(!e)i=i+1|0;BU(a,b,b+i|0);if(e)l=b;else{f=a.vO.data;l=b+1|0;f[b]=45;}while(true){if(!k)break b;f=a.vO.data;g=l+1|0;f[l]=GV(CS(c,k),d);c=Bk3(c,k);k=CS(k,d);l=g;}}}return a;},
AGY=(a,b)=>{return a.ci(a.v6,b);},
ZP=(a,b,c)=>{return a.cj(b,c,10);},
A4G=(a,b,c,d)=>{let e,f,g,h,i,j,k,l,m;e=1;if(ATB(c,Bg)){e=0;c=A5i(c);}b:{f=Q(d);if(CV(c,f)<0){if(e)BU(a,b,b+1|0);else{BU(a,b,b+2|0);g=a.vO.data;h=b+1|0;g[b]=45;b=h;}a.vO.data[b]=GV(U(c),d);}else{i=1;j=Q(1);k=CK(Q(-1),f);e:{while(true){l=Bx(j,f);if(CV(l,c)>0){l=j;break e;}i=i+1|0;if(CV(l,k)>0)break;j=l;}}if(!e)i=i+1|0;BU(a,b,b+i|0);if(e)m=b;else{g=a.vO.data;m=b+1|0;g[b]=45;}while(true){if(BS(l,Bg))break b;g=a.vO.data;h=m+1|0;g[m]=GV(U((CK(c,l))),d);c=AMx(c,l);l=CK(l,f);m=h;}}}return a;},
AE0=(a,b)=>{return a.cn(a.v6,b);},
ABu=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u;d=CA(c,0.0);if(!d){if(1.0/c===Infinity){BU(a,b,b+3|0);e=a.vO.data;d=b+1|0;e[b]=48;e=a.vO.data;f=d+1|0;e[d]=46;a.vO.data[f]=48;return a;}BU(a,b,b+4|0);e=a.vO.data;d=b+1|0;e[b]=45;e=a.vO.data;f=d+1|0;e[d]=48;e=a.vO.data;d=f+1|0;e[f]=46;a.vO.data[d]=48;return a;}if(isNaN(c)?1:0){BU(a,b,b+3|0);e=a.vO.data;d=b+1|0;e[b]=78;e=a.vO.data;f=d+1|0;e[d]=97;a.vO.data[f]=78;return a;}if(!isFinite(c)?1:0){if(d>0){BU(a,b,b+8|0);d=b;}else{BU(a,b,b+9|0);e=a.vO.data;d=b+1|
0;e[b]=45;}e=a.vO.data;f=d+1|0;e[d]=73;e=a.vO.data;d=f+1|0;e[f]=110;e=a.vO.data;f=d+1|0;e[d]=102;e=a.vO.data;d=f+1|0;e[f]=105;e=a.vO.data;f=d+1|0;e[d]=110;e=a.vO.data;d=f+1|0;e[f]=105;e=a.vO.data;f=d+1|0;e[d]=116;a.vO.data[f]=121;return a;}FX();g=W7;A5n(c,g);h=g.B2;i=g.BI;j=g.DF;k=1;l=1;if(j)l=2;m=9;n=Bcw(h);if(n>0)m=m-n|0;o=0;p=0;if(i<7&&i>=(-3)){if(i>=0){k=i+1|0;m=BT(m,k+1|0);i=0;}else{k=0;o=( -i|0)-1|0;p=1;l=l+1|0;i=0;}}if(i){l=l+2|0;if(!(i>(-10)&&i<10))l=l+1|0;if(i<0)l=l+1|0;}if(i&&m==k)m=m+1|0;d=l+(m+o
|0)|0;BU(a,b,b+d|0);if(!j)q=b;else{e=a.vO.data;q=b+1|0;e[b]=45;}r=100000000;if(p){e=a.vO.data;d=q+1|0;e[q]=48;e=a.vO.data;q=d+1|0;e[d]=46;while(true){d=o+(-1)|0;if(o<=0)break;e=a.vO.data;f=q+1|0;e[q]=48;o=d;q=f;}}s=0;while(s<m){if(r<=0)t=0;else{t=h/r|0;h=h%r|0;}e=a.vO.data;f=q+1|0;e[q]=(48+t|0)&65535;k=k+(-1)|0;if(k)q=f;else{e=a.vO.data;q=f+1|0;e[f]=46;}r=r/10|0;s=s+1|0;}if(i){e=a.vO.data;d=q+1|0;e[q]=69;if(i>=0)f=d;else{i= -i|0;e=a.vO.data;f=d+1|0;e[d]=45;}if(i<10)u=f;else{e=a.vO.data;u=f+1|0;e[f]=(48+(i/10
|0)|0)&65535;}a.vO.data[u]=(48+(i%10|0)|0)&65535;}return a;},
V1=(a,b)=>{return a.cr(a.v6,b);},
U2=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u;d=CA(c,0.0);if(!d){if(1.0/c===Infinity){BU(a,b,b+3|0);e=a.vO.data;d=b+1|0;e[b]=48;e=a.vO.data;f=d+1|0;e[d]=46;a.vO.data[f]=48;return a;}BU(a,b,b+4|0);e=a.vO.data;d=b+1|0;e[b]=45;e=a.vO.data;f=d+1|0;e[d]=48;e=a.vO.data;d=f+1|0;e[f]=46;a.vO.data[d]=48;return a;}if(isNaN(c)?1:0){BU(a,b,b+3|0);e=a.vO.data;d=b+1|0;e[b]=78;e=a.vO.data;f=d+1|0;e[d]=97;a.vO.data[f]=78;return a;}if(!isFinite(c)?1:0){if(d>0){BU(a,b,b+8|0);d=b;}else{BU(a,b,b+9|0);e=a.vO.data;d=b+1|0;e[b]
=45;}e=a.vO.data;f=d+1|0;e[d]=73;e=a.vO.data;d=f+1|0;e[f]=110;e=a.vO.data;f=d+1|0;e[d]=102;e=a.vO.data;d=f+1|0;e[f]=105;e=a.vO.data;f=d+1|0;e[d]=110;e=a.vO.data;d=f+1|0;e[f]=105;e=a.vO.data;f=d+1|0;e[d]=116;a.vO.data[f]=121;return a;}FX();g=Vt;AZX(c,g);h=g.Cj;i=g.By;j=g.Dv;k=1;l=1;if(j)l=2;m=18;n=A9f(h);if(n>0)m=m-n|0;o=0;p=0;if(i<7&&i>=(-3)){if(i>=0){k=i+1|0;m=BT(m,k+1|0);i=0;}else{k=0;o=( -i|0)-1|0;p=1;l=l+1|0;i=0;}}if(i){l=l+2|0;if(!(i>(-10)&&i<10))l=l+1|0;if(!(i>(-100)&&i<100))l=l+1|0;if(i<0)l=l+1|0;}if
(i&&m==k)m=m+1|0;d=l+(m+o|0)|0;BU(a,b,b+d|0);if(!j)q=b;else{e=a.vO.data;q=b+1|0;e[b]=45;}r=C(1569325056, 23283064);if(p){e=a.vO.data;d=q+1|0;e[q]=48;e=a.vO.data;q=d+1|0;e[d]=46;while(true){d=o+(-1)|0;if(o<=0)break;e=a.vO.data;f=q+1|0;e[q]=48;o=d;q=f;}}s=0;while(s<m){if(ATF(r,Bg))t=0;else{t=U(Ow(h,r));h=AKw(h,r);}e=a.vO.data;d=q+1|0;e[q]=(48+t|0)&65535;k=k+(-1)|0;if(k)q=d;else{e=a.vO.data;q=d+1|0;e[d]=46;}r=Ow(r,Q(10));s=s+1|0;}if(i){e=a.vO.data;f=q+1|0;e[q]=69;if(i>=0)u=f;else{i= -i|0;e=a.vO.data;u=f+1|0;e[f]
=45;}if(i>=100){e=a.vO.data;d=u+1|0;e[u]=(48+(i/100|0)|0)&65535;i=i%100|0;e=a.vO.data;f=d+1|0;e[d]=(48+(i/10|0)|0)&65535;}else if(i<10)f=u;else{e=a.vO.data;f=u+1|0;e[u]=(48+(i/10|0)|0)&65535;}a.vO.data[f]=(48+(i%10|0)|0)&65535;}return a;},
Bcw=b=>{let c,d,e,f;if(!(b%1000000000|0))return 9;c=0;d=1;if(!(b%100000000|0)){c=8;d=100000000;}e=d*10000|0;if(b%e|0)e=d;else c=c|4;f=e*100|0;if(b%f|0)f=e;else c=c|2;if(!(b%(f*10|0)|0))c=c|1;return c;},
A9f=b=>{let c,d,e,f;c=Q(1);d=0;e=16;FX();f=G3.data.length-1|0;while(f>=0){if(BS(AKw(b,Bx(c,G3.data[f])),Bg)){d=d|e;c=Bx(c,G3.data[f]);}e=e>>>1|0;f=f+(-1)|0;}return d;},
MO=(a,b)=>{return a.cu(a.v6,b);},
PT=(a,b,c)=>{BU(a,b,b+1|0);a.vO.data[b]=c;return a;},
VN=(a,b,c)=>{return a.cc(b,c===null?D(31):c.y());},
ADY=(a,b)=>{return a.cv(a.v6,b);},
Qt=(a,b,c)=>{return a.cc(b,!c?D(32):D(33));},
K0=(a,b)=>{let c;if(a.vO.data.length>=b)return;c=a.vO.data.length>=1073741823?2147483647:BT(b,BT(a.vO.data.length*2|0,5));a.vO=Sb(a.vO,c);},
NB=a=>{return Lg(a.vO,0,a.v6);},
Mt=a=>{return a.v6;},
Ru=(a,b)=>{if(b>=0&&b<a.v6)return a.vO.data[b];I(Ch());},
PL=(a,b,c,d)=>{return a.cy(a.v6,b,c,d);},
Kk=(a,b,c,d,e)=>{let f,g,h,i,j;BU(a,b,b+e|0);f=e+d|0;while(d<f){g=c.data;h=a.vO.data;i=b+1|0;j=d+1|0;h[b]=g[d];b=i;d=j;}return a;},
N6=(a,b)=>{return a.cz(b,0,b.data.length);},
AGk=(a,b)=>{let c,d,e;if(b>=0&&b<a.v6){a.v6=a.v6-1|0;while(b<a.v6){c=a.vO.data;d=a.vO.data;e=b+1|0;c[b]=d[e];b=e;}return a;}I(FT());},
AGX=(a,b,c)=>{let d,e,f,g,h,i;if(b>=0){d=CA(b,c);if(d<=0&&b<=a.v6){if(!d)return a;if(c>a.v6)c=a.v6;e=a.v6-c|0;a.v6=a.v6-(c-b|0)|0;f=0;while(f<e){g=a.vO.data;d=b+1|0;h=a.vO.data;i=c+1|0;g[b]=h[c];f=f+1|0;b=d;c=i;}return a;}}I(FT());},
BU=(a,b,c)=>{let d,e;d=a.v6-b|0;a.ce((a.v6+c|0)-b|0);e=d-1|0;while(e>=0){a.vO.data[c+e|0]=a.vO.data[b+e|0];e=e+(-1)|0;}a.v6=a.v6+(c-b|0)|0;};
let H2=B(0);
let SX=B(Ec);
let Xj=a=>{Hn(a);},
A$1=()=>{let a=new SX();Xj(a);return a;},
Bce=(a,b)=>{MO(a,b);return a;},
BhF=(a,b,c,d)=>{PL(a,b,c,d);return a;},
ATM=(a,b)=>{N6(a,b);return a;},
A4K=(a,b,c,d,e)=>{Kk(a,b,c,d,e);return a;},
Bfx=(a,b,c)=>{PT(a,b,c);return a;},
AVx=(a,b,c,d,e)=>{return a.cC(b,c,d,e);},
AOI=(a,b,c,d)=>{return a.cD(b,c,d);},
AJX=(a,b)=>{return Ru(a,b);},
BiV=a=>{return Mt(a);},
APd=a=>{return NB(a);},
APQ=(a,b)=>{K0(a,b);},
Bch=(a,b,c)=>{return a.cE(b,c);};
let Wf=B();
let A3H=null;
let ABG=()=>{ABG=N(Wf);Bh9();};
let Bh9=()=>{A3H=BF();};
function CZ(){let a=this;A.call(a);a.zT=0;a.vU=0;a.v4=0;a.ym=0;}
let Fj=(a,b)=>{L(a);a.ym=(-1);a.zT=b;a.v4=b;},
DL=a=>{return a.zT;},
BY=a=>{return a.vU;},
ER=(a,b)=>{let c,d,e;if(b>=0&&b<=a.v4){a.vU=b;if(b<a.ym)a.ym=0;return a;}c=new Ca;d=a.v4;e=O();BA(V(K(V(K(e,D(34)),b),D(35)),d),93);Dy(c,S(e));I(c);},
BI=a=>{return a.v4;},
HR=(a,b)=>{let c,d,e;if(b>=0&&b<=a.zT){if(a.ym>b)a.ym=(-1);a.v4=b;if(a.vU>a.v4)a.vU=a.v4;return a;}c=new Ca;d=a.zT;e=O();BA(V(K(V(K(e,D(36)),b),D(35)),d),93);Dy(c,S(e));I(c);},
FP=a=>{a.vU=0;a.v4=a.zT;a.ym=(-1);return a;},
GT=a=>{a.v4=a.vU;a.vU=0;a.ym=(-1);return a;},
Bk=a=>{return a.v4-a.vU|0;},
GL=a=>{return a.vU>=a.v4?0:1;};
let BeL=B();
let N3=B(B6);
let GA=B();
let J3=a=>{L(a);};
function T(){let a=this;GA.call(a);a.wa=0;a.wl=0;a.wd=null;a.zR=null;a.z7=null;a.v3=0;}
let Vg=null;
let EJ=()=>{EJ=N(T);ARQ();};
let Bh=a=>{EJ();J3(a);a.wd=A$K(2048);},
AOC=a=>{return null;},
AMH=a=>{return a.wd;},
A4m=a=>{return !a.wl?(a.wd.cG(0)>=2048?0:1):a.wd.cH(0)>=2048?0:1;},
AXZ=a=>{return a.v3;},
Bb6=a=>{return a;},
ANg=a=>{let b;if(a.z7===null){b=a.cI();a.z7=Bkb(a,b);a.z7.E(a.wl);}return a.z7;},
AOT=a=>{let b;if(a.zR===null){b=a.cI();a.zR=A2A(a,b,a);a.zR.E(a.cL());a.zR.v3=a.v3;}return a.zR;},
Bg1=a=>{return 0;},
BdZ=(a,b)=>{if(a.wa^b){a.wa=a.wa?0:1;a.wl=a.wl?0:1;}if(!a.v3)a.v3=1;return a;},
AVp=a=>{return a.wa;},
Mg=(b,c)=>{EJ();return b.b6(c);},
IQ=(b,c)=>{EJ();if(b.cM()!==null&&c.cM()!==null)return (b.cM()).cN(c.cM());return 1;},
ZL=(b,c)=>{EJ();return (AGO(Vg,b)).cP(c);},
ARQ=()=>{Vg=AZD();};
function AAt(){T.call(this);this.Gv=null;}
let Y5=(a,b)=>{a.Gv=b;Bh(a);},
A5h=a=>{let b=new AAt();Y5(b,a);return b;},
Bhp=(a,b)=>{return AVX(b);};
let Dt=B();
let Gh=B(Dt);
let CG=B(Gh);
let AVR=null;
let WR=()=>{WR=N(CG);AM6();};
let AM6=()=>{AVR=X();};
let Pn=B();
let Kq=null,MJ=null,Oe=null;
let Ji=()=>{Ji=N(Pn);ATm();};
let AFM=a=>{Ji();L(a);},
AZD=()=>{let a=new Pn();AFM(a);return a;},
AGO=(a,b)=>{let c,d,e;c=0;while(true){Ji();if(c>=Oe.data.length)I(A5x(D(37),D(37),b));d=Oe.data[c];e=d.data;if(b.bi(e[0]))break;c=c+1|0;}return e[1];},
ATm=()=>{Kq=Bca();MJ=A1J();Oe=H(BkX(A),[H(A,[D(38),Bih()]),H(A,[D(39),AKi()]),H(A,[D(40),BbI()]),H(A,[D(41),BeQ()]),H(A,[D(42),MJ]),H(A,[D(43),A3T()]),H(A,[D(44),A0Z()]),H(A,[D(45),ANB()]),H(A,[D(46),AMk()]),H(A,[D(47),AOl()]),H(A,[D(48),AUk()]),H(A,[D(49),ANQ()]),H(A,[D(50),A9I()]),H(A,[D(51),AJE()]),H(A,[D(52),BdG()]),H(A,[D(53),AT0()]),H(A,[D(54),A3L()]),H(A,[D(55),ATP()]),H(A,[D(56),A3O()]),H(A,[D(57),APj()]),H(A,[D(58),BfY()]),H(A,[D(59),AQ7()]),H(A,[D(60),A5k()]),H(A,[D(61),Bbs()]),H(A,[D(62),Ba6()]),
H(A,[D(63),Bfs()]),H(A,[D(64),AO1()]),H(A,[D(65),A$X()]),H(A,[D(66),Kq]),H(A,[D(67),A6J()]),H(A,[D(68),ANE()]),H(A,[D(69),Kq]),H(A,[D(70),AI7()]),H(A,[D(71),MJ]),H(A,[D(72),AWU()]),H(A,[D(73),M(0,127)]),H(A,[D(74),M(128,255)]),H(A,[D(75),M(256,383)]),H(A,[D(76),M(384,591)]),H(A,[D(77),M(592,687)]),H(A,[D(78),M(688,767)]),H(A,[D(79),M(768,879)]),H(A,[D(80),M(880,1023)]),H(A,[D(81),M(1024,1279)]),H(A,[D(82),M(1280,1327)]),H(A,[D(83),M(1328,1423)]),H(A,[D(84),M(1424,1535)]),H(A,[D(85),M(1536,1791)]),H(A,[D(86),
M(1792,1871)]),H(A,[D(87),M(1872,1919)]),H(A,[D(88),M(1920,1983)]),H(A,[D(89),M(2304,2431)]),H(A,[D(90),M(2432,2559)]),H(A,[D(91),M(2560,2687)]),H(A,[D(92),M(2688,2815)]),H(A,[D(93),M(2816,2943)]),H(A,[D(94),M(2944,3071)]),H(A,[D(95),M(3072,3199)]),H(A,[D(96),M(3200,3327)]),H(A,[D(97),M(3328,3455)]),H(A,[D(98),M(3456,3583)]),H(A,[D(99),M(3584,3711)]),H(A,[D(100),M(3712,3839)]),H(A,[D(101),M(3840,4095)]),H(A,[D(102),M(4096,4255)]),H(A,[D(103),M(4256,4351)]),H(A,[D(104),M(4352,4607)]),H(A,[D(105),M(4608,4991)]),
H(A,[D(106),M(4992,5023)]),H(A,[D(107),M(5024,5119)]),H(A,[D(108),M(5120,5759)]),H(A,[D(109),M(5760,5791)]),H(A,[D(110),M(5792,5887)]),H(A,[D(111),M(5888,5919)]),H(A,[D(112),M(5920,5951)]),H(A,[D(113),M(5952,5983)]),H(A,[D(114),M(5984,6015)]),H(A,[D(115),M(6016,6143)]),H(A,[D(116),M(6144,6319)]),H(A,[D(117),M(6400,6479)]),H(A,[D(118),M(6480,6527)]),H(A,[D(119),M(6528,6623)]),H(A,[D(120),M(6624,6655)]),H(A,[D(121),M(6656,6687)]),H(A,[D(122),M(7424,7551)]),H(A,[D(123),M(7552,7615)]),H(A,[D(124),M(7616,7679)]),
H(A,[D(125),M(7680,7935)]),H(A,[D(126),M(7936,8191)]),H(A,[D(127),M(8192,8303)]),H(A,[D(128),M(8304,8351)]),H(A,[D(129),M(8352,8399)]),H(A,[D(130),M(8400,8447)]),H(A,[D(131),M(8448,8527)]),H(A,[D(132),M(8528,8591)]),H(A,[D(133),M(8592,8703)]),H(A,[D(134),M(8704,8959)]),H(A,[D(135),M(8960,9215)]),H(A,[D(136),M(9216,9279)]),H(A,[D(137),M(9280,9311)]),H(A,[D(138),M(9312,9471)]),H(A,[D(139),M(9472,9599)]),H(A,[D(140),M(9600,9631)]),H(A,[D(141),M(9632,9727)]),H(A,[D(142),M(9728,9983)]),H(A,[D(143),M(9984,10175)]),
H(A,[D(144),M(10176,10223)]),H(A,[D(145),M(10224,10239)]),H(A,[D(146),M(10240,10495)]),H(A,[D(147),M(10496,10623)]),H(A,[D(148),M(10624,10751)]),H(A,[D(149),M(10752,11007)]),H(A,[D(150),M(11008,11263)]),H(A,[D(151),M(11264,11359)]),H(A,[D(152),M(11392,11519)]),H(A,[D(153),M(11520,11567)]),H(A,[D(154),M(11568,11647)]),H(A,[D(155),M(11648,11743)]),H(A,[D(156),M(11776,11903)]),H(A,[D(157),M(11904,12031)]),H(A,[D(158),M(12032,12255)]),H(A,[D(159),M(12272,12287)]),H(A,[D(160),M(12288,12351)]),H(A,[D(161),M(12352,
12447)]),H(A,[D(162),M(12448,12543)]),H(A,[D(163),M(12544,12591)]),H(A,[D(164),M(12592,12687)]),H(A,[D(165),M(12688,12703)]),H(A,[D(166),M(12704,12735)]),H(A,[D(167),M(12736,12783)]),H(A,[D(168),M(12784,12799)]),H(A,[D(169),M(12800,13055)]),H(A,[D(170),M(13056,13311)]),H(A,[D(171),M(13312,19893)]),H(A,[D(172),M(19904,19967)]),H(A,[D(173),M(19968,40959)]),H(A,[D(174),M(40960,42127)]),H(A,[D(175),M(42128,42191)]),H(A,[D(176),M(42752,42783)]),H(A,[D(177),M(43008,43055)]),H(A,[D(178),M(44032,55203)]),H(A,[D(179),
M(55296,56191)]),H(A,[D(180),M(56192,56319)]),H(A,[D(181),M(56320,57343)]),H(A,[D(182),M(57344,63743)]),H(A,[D(183),M(63744,64255)]),H(A,[D(184),M(64256,64335)]),H(A,[D(185),M(64336,65023)]),H(A,[D(186),M(65024,65039)]),H(A,[D(187),M(65040,65055)]),H(A,[D(188),M(65056,65071)]),H(A,[D(189),M(65072,65103)]),H(A,[D(190),M(65104,65135)]),H(A,[D(191),M(65136,65279)]),H(A,[D(192),M(65280,65519)]),H(A,[D(193),M(0,1114111)]),H(A,[D(194),ANV()]),H(A,[D(195),By(0,1)]),H(A,[D(196),Fs(62,1)]),H(A,[D(197),By(1,1)]),H(A,
[D(198),By(2,1)]),H(A,[D(199),By(3,0)]),H(A,[D(200),By(4,0)]),H(A,[D(201),By(5,1)]),H(A,[D(202),Fs(448,1)]),H(A,[D(203),By(6,1)]),H(A,[D(204),By(7,0)]),H(A,[D(205),By(8,1)]),H(A,[D(206),Fs(3584,1)]),H(A,[D(207),By(9,1)]),H(A,[D(208),By(10,1)]),H(A,[D(209),By(11,1)]),H(A,[D(210),Fs(28672,0)]),H(A,[D(211),By(12,0)]),H(A,[D(212),By(13,0)]),H(A,[D(213),By(14,0)]),H(A,[D(214),AZH(983040,1,1)]),H(A,[D(215),By(15,0)]),H(A,[D(216),By(16,1)]),H(A,[D(217),By(18,1)]),H(A,[D(218),A2Y(19,0,1)]),H(A,[D(219),Fs(1643118592,
1)]),H(A,[D(220),By(20,0)]),H(A,[D(221),By(21,0)]),H(A,[D(222),By(22,0)]),H(A,[D(223),By(23,0)]),H(A,[D(224),By(24,1)]),H(A,[D(225),Fs(2113929216,1)]),H(A,[D(226),By(25,1)]),H(A,[D(227),By(26,0)]),H(A,[D(228),By(27,0)]),H(A,[D(229),By(28,1)]),H(A,[D(230),By(29,0)]),H(A,[D(231),By(30,0)])]);};
let ABT=B(0);
function KK(){let a=this;A.call(a);a.zu=null;a.zA=null;a.EH=null;a.Fc=null;}
let AUc=null;
let Qj=()=>{Qj=N(KK);Bak();};
let U3=a=>{Qj();L(a);a.zu=X();a.zA=X();a.EH=X();a.Fc=X();a.cV();},
A3f=()=>{let a=new KK();U3(a);return a;},
A7T=(a,b,c)=>{let d,e,f,g,h;d=a.zu;e=b.vZ>=c.vZ?c.vZ:b.vZ;f=b.v1>=c.v1?c.v1:b.v1;g=b.v0>=c.v0?c.v0:b.v0;d.cW(e,f,g);d=a.zA;f=b.vZ<=c.vZ?c.vZ:b.vZ;g=b.v1<=c.v1?c.v1:b.v1;h=b.v0<=c.v0?c.v0:b.v0;d.cW(f,g,h);a.cX();return a;},
A93=a=>{((a.EH.cY(a.zu)).cZ(a.zA)).c0(0.5);(a.Fc.cY(a.zA)).c1(a.zu);},
BbV=a=>{return a.c2(a.zu.cW(0.0,0.0,0.0),a.zA.cW(0.0,0.0,0.0));},
Bak=()=>{AUc=X();};
let Fi=B(BX);
let BcS=null,BcQ=null,BcT=null,Be6=null;
let AEs=()=>{AEs=N(Fi);A2x();};
let A2x=()=>{BcS=X();BcQ=X();BcT=X();Be6=FI();};
let Dh=B(Fi);
let AU0=B(Dh);
let HD=B(W);
let O9=a=>{Bn(a);},
A1J=()=>{let a=new HD();O9(a);return a;},
AAw=a=>{return (Cy()).G(48,57);};
let AAk=B(W);
let T0=a=>{Bn(a);},
A5k=()=>{let a=new AAk();T0(a);return a;},
AWS=a=>{let b;b=ASR(a);b.v3=1;return b;};
let AFn=B();
let AJT=null,AJU=null,AJW=null,AQ_=null,Bcs=null,A2V=null,AMX=null,AMY=null,A1_=null,A14=null,AWz=null,AWC=null,AWD=null,AWF=null,A2d=null,A19=null,A3c=null,AYr=null,A$4=null,AXC=null,Bel=null,Bek=null,Bej=null,AZK=null;
let Ws=()=>{Ws=N(AFn);ARM();};
let ARM=()=>{AJT=X();AJU=X();AJW=X();AQ_=AB6();Bcs=AB6();A2V=BF();AMX=BF();AMY=BF();A1_=BF();A14=BF();AWz=BF();AWC=BF();AWD=BF();AWF=BF();A2d=ADN(X(),0.0);A19=X();A3c=X();AYr=X();A$4=X();AXC=X();Bel=X();Bek=X();Bej=X();AZK=X();};
let Ct=B();
let ATo=B(Ct);
let ADy=B(Bd);
let AAi=a=>{BN(a);},
AMo=()=>{let a=new ADy();AAi(a);return a;};
let AWj=B();
let DI=()=>{return A$t();};
let ADp=B(Bd);
let Y6=a=>{BN(a);},
AJs=()=>{let a=new ADp();Y6(a);return a;};
let Dq=B(Ex);
let AUl=B(Dq);
let Cx=B();
let AZ8=B(Cx);
let ADq=B(Bd);
let AES=a=>{BN(a);},
BbR=()=>{let a=new ADq();AES(a);return a;};
let AHZ=B(Cj);
let Qs=a=>{Ed(a,(-1));},
AKm=()=>{let a=new AHZ();Qs(a);return a;},
AQ5=(a,b,c,d)=>{return b;};
function E8(){Bd.call(this);this.IO=0;}
let IA=(a,b)=>{BN(a);a.IO=b;},
G2=a=>{let b=new E8();IA(b,a);return b;};
let ADt=B(Bd);
let ZA=a=>{BN(a);},
AT4=()=>{let a=new ADt();ZA(a);return a;};
let ADo=B(Bd);
let AEu=a=>{BN(a);},
A0g=()=>{let a=new ADo();AEu(a);return a;};
let MS=B(Ct);
let AS$=B(MS);
let ADr=B(Bd);
let AII=a=>{BN(a);},
APH=()=>{let a=new ADr();AII(a);return a;};
let ADu=B(Bd);
let Q0=a=>{BN(a);},
Bkd=()=>{let a=new ADu();Q0(a);return a;};
let ADs=B(Bd);
let Tm=a=>{BN(a);},
A2j=()=>{let a=new ADs();Tm(a);return a;};
let ADv=B(Bd);
let QZ=a=>{BN(a);},
A_x=()=>{let a=new ADv();QZ(a);return a;};
let JM=B(BD);
let KH=(a,b,c)=>{NY(a,b,c);},
BgX=(a,b)=>{let c=new JM();KH(c,a,b);return c;},
A7U=(a,b,c,d)=>{let e,f,g,h,i;e=d.bS(a.v8);d.c7(a.v8,b);f=a.wg.bV();g=0;while(true){if(g>=f){d.c7(a.v8,e);return (-1);}h=a.wg.bW(g);i=h.br(b,c,d);if(i>=0)break;g=g+1|0;}return i;},
A_m=(a,b)=>{let c;c=b.bS(a.v8);return !c?0:1;};
let C_=B(JM);
let EW=(a,b,c)=>{KH(a,b,c);},
AML=(a,b)=>{let c=new C_();EW(c,a,b);return c;},
ASz=(a,b,c,d)=>{let e,f,g,h,i;e=d.bS(a.v8);d.c7(a.v8,b);f=a.wg.bV();g=0;while(g<f){h=a.wg.bW(g);i=h.br(b,c,d);if(i>=0)return a.vN.br(a.wM.c8(),c,d);g=g+1|0;}d.c7(a.v8,e);return (-1);},
A$C=(a,b)=>{a.vN=b;};
let QR=B(C_);
let WO=(a,b,c)=>{EW(a,b,c);},
ASX=(a,b)=>{let c=new QR();WO(c,a,b);return c;},
A8f=(a,b,c,d)=>{let e,f,g,h;e=a.wg.bV();f=0;while(f<e){g=a.wg.bW(f);h=g.br(b,c,d);if(h>=0)return a.vN.br(b,c,d);f=f+1|0;}return (-1);},
Bee=(a,b)=>{return 0;};
let AFz=B(C_);
let VV=(a,b,c)=>{EW(a,b,c);},
AJO=(a,b)=>{let c=new AFz();VV(c,a,b);return c;},
AOv=(a,b,c,d)=>{let e,f,g;e=a.wg.bV();f=0;while(true){if(f>=e)return a.vN.br(b,c,d);g=a.wg.bW(f);if(g.br(b,c,d)>=0)break;f=f+1|0;}return (-1);},
BcO=(a,b)=>{return 0;};
let Bq=B();
let BdN=null,A$8=null,Bbz=null,ATi=null,A13=null,AY3=null,A$V=null;
let J8=()=>{J8=N(Bq);AN2();};
let CH=a=>{J8();L(a);},
AN2=()=>{BdN=A4A(0.0);A$8=BeA();Bbz=AYb();ATi=ALV();A13=AJe();AY3=ALx();A$V=AOg();};
let Bit=B(Bq);
let EA=B(Dh);
let AVh=B(EA);
let HN=B(Bi);
let Nj=a=>{B9(a);},
BdX=()=>{let a=new HN();Nj(a);return a;};
let AId=B(HN);
let Yu=a=>{Nj(a);},
D2=()=>{let a=new AId();Yu(a);return a;};
let AEO=B(0);
function Nh(){A.call(this);this.yE=null;}
let BgT=(a,b)=>{a.yE=b;L(a);},
A1j=a=>{let b=new Nh();BgT(b,a);return b;},
Bhl=a=>{a.yE.Aq=1;AEy(Be(a.yE.Ci));},
AWc=a=>{a.yE.Aq=0;},
AVG=a=>{a.yE.Aq=1;AEy(Be(a.yE.Ci));},
AKX=a=>{a.c$();},
ARB=a=>{a.c_();},
AJ_=a=>{a.da();};
let Fd=B(0);
let Bo=B();
let A5R=null;
let R2=()=>{R2=N(Bo);Bgk();};
let Bgk=()=>{A5R=BF();};
let CI=B(Bo);
let BcD=0.0;
let T7=()=>{T7=N(CI);BdB();};
let BdB=()=>{BcD=0.10000000149011612;};
let Ky=B(CI);
let A55=B();
let I4=b=>{if(b===null||b.constructor.$meta.item==='undefined'){I(CF());}return b.data.length;},
On=(b,c)=>{if(b===null)I(S8());if(b===Br(FK))I(CF());if(c<0)I(AGU());return Bgm(b.dc(),c);},
Bgm=(b,c)=>{if(b.$meta.primitive){switch(b){};}return Bt(b,c);};
let L3=B(Dt);
let AAr=B(0);
function AEd(){A.call(this);this.In=null;}
let AD6=(a,b)=>{L(a);a.In=b;},
AQs=a=>{let b=new AEd();AD6(b,a);return b;};
let Cc=B(Ep);
let AM3=B(Cc);
let Fn=B(Fz);
let HZ=(a,b)=>{Kb(a,b);},
BkR=a=>{let b=new Fn();HZ(b,a);return b;};
let ACe=B(Fn);
let TK=(a,b)=>{HZ(a,b);},
BlE=a=>{let b=new ACe();TK(b,a);return b;};
let H_=B(0);
let Sr=B(W);
let TM=a=>{Bn(a);},
ATP=()=>{let a=new Sr();TM(a);return a;},
AS_=a=>{let b;b=A7d(a);b.v3=1;return b;};
let A1C=B(Ky);
let AL3=B(Bo);
let AL1=B(Bo);
let AC9=B(B6);
let A2u=null;
let QI=()=>{QI=N(AC9);A20();};
let A20=()=>{A2u=BF();};
let ARk=B();
let A2G=b=>{let c,d,e,f,g;if(b===null)return null;c=b.data;d=c.length;e=new Array(d);f=0;while(f<d){g=c[f];f;e[f]=g;f=f+1|0;}return e;},
Bu=(b,c)=>{let name='jso$functor$'+c;let result=b[name];if(typeof result!=='function'){let fn=function(){return b[c].apply(b,arguments);};result=()=>fn;b[name]=result;}return result();},
Cl=(b,c)=>{if(typeof b!=='function')return b;let result={};result[c]=b;return result;};
function Ra(){T.call(this);this.IQ=null;}
let AD4=(a,b)=>{a.IQ=b;Bh(a);},
A2y=a=>{let b=new Ra();AD4(b,a);return b;},
ASa=(a,b)=>{return Bgh(b);};
let JL=B();
let R7=B(JL);
let AL4=B(DC);
let Eb=B(BX);
let APA=B();
let Bhh=b=>{let c,d,e,f,g,h,i,j,k;c=AEt(b.dg());d=Hq(c);e=Bp(d*2|0);f=0;g=0;h=0;i=0;while(i<d){j=e.data;g=g+Ko(c)|0;h=h+Ko(c)|0;k=f+1|0;j[f]=g;f=k+1|0;j[k]=h;i=i+1|0;}return e;},
Xi=b=>{let c,d,e,f,g,h,i;c=AEt(b.dg());d=Hq(c);e=Bp(d*2|0);f=0;g=0;while(g<d){h=e.data;f=f+Hq(c)|0;i=g*2|0;h[i]=f;h[i+1|0]=Ko(c);g=g+1|0;}return e;},
QU=b=>{let c,d,e,f,g,h,i,j,k;c=Bp(65536);d=0;e=0;f=0;d:{while(true){g=b.data;if(f>=g.length)break d;h=c.data;i=g[f];j=g[f+1|0];k=h.length;if(i<k)k=i;else if(i==d)break;VQ(c,d,k,e);f=f+2|0;d=k;e=j;}}return A0S(b,c);},
Ig=b=>{if(b>92)return ((b-32|0)-2|0)<<24>>24;if(b<=34)return (b-32|0)<<24>>24;return ((b-32|0)-1|0)<<24>>24;},
Bj2=b=>{let c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r;c=Bt(KB,16384);d=EL(16384);e=0;f=0;g=0;h=0;while(h<b.bb()){i=Ig(b.bc(h));if(i==64){h=h+1|0;i=Ig(b.bc(h));j=0;k=1;l=0;while(l<3){h=h+1|0;m=Ig(b.bc(h));j=j|CW(k,m);k=k*64|0;l=l+1|0;}}else if(i<32)j=1;else{i=(i-32|0)<<24>>24;h=h+1|0;j=Ig(b.bc(h));}if(!i&&j>=128){if(e>0){n=c.data;o=f+1|0;n[f]=V7(g,g+e|0,AGF(d,e));f=o;}g=g+(e+j|0)|0;e=0;}else{p=d.data;o=e+j|0;if(o<p.length)q=f;else{n=c.data;q=f+1|0;n[f]=V7(g,g+e|0,AGF(d,e));g=g+o|0;e=0;}while(true){o=j+(-1)|0;if(j<=0)break;r
=e+1|0;p[e]=i;e=r;j=o;}f=q;}h=h+1|0;}return H8(c,f);};
let EK=B(0);
function AA6(){let a=this;A.call(a);a.D3=null;a.D4=null;a.D1=0;a.D2=null;}
let Wm=(a,b,c,d,e)=>{L(a);a.D3=b;a.D4=c;a.D1=d;a.D2=e;},
BgQ=(a,b,c,d)=>{let e=new AA6();Wm(e,a,b,c,d);return e;},
AZJ=a=>{A5r(a.D3,a.D4,a.D1,a.D2);};
let BbB=B(Bo);
let MP=B();
let BbA=B(MP);
let OP=B();
let BbE=B(OP);
let I8=B(Is);
let MI=a=>{Lu(a);},
A3T=()=>{let a=new I8();MI(a);return a;},
Wj=a=>{return (Ud(a)).G(48,57);};
let JT=B(I8);
let Oo=a=>{MI(a);},
ANB=()=>{let a=new JT();Oo(a);return a;},
QD=a=>{return (((Wj(a)).G(33,64)).G(91,96)).G(123,126);};
let Yt=B(JT);
let AFf=a=>{Oo(a);},
AMk=()=>{let a=new Yt();AFf(a);return a;},
A4S=a=>{return (QD(a)).F(32);};
let AEc=B(W);
let ABA=a=>{Bn(a);},
Ba6=()=>{let a=new AEc();ABA(a);return a;},
BdY=a=>{return Bfu(a);};
let BbD=B(Bo);
let XL=B(C_);
let AFA=(a,b,c)=>{EW(a,b,c);},
ARH=(a,b)=>{let c=new XL();AFA(c,a,b);return c;},
AQh=(a,b,c,d)=>{let e,f,g,h,i;e=a.wg.bV();f=!d.ds()?d.b5():0;c:{g=a.vN.br(b,c,d);if(g>=0){d.c7(a.v8,b);h=0;while(true){if(h>=e)break c;i=a.wg.bW(h);if(i.dt(f,b,c,d)>=0){d.c7(a.v8,(-1));return g;}h=h+1|0;}}}return (-1);},
BjY=(a,b)=>{return 0;};
let A7P=B(BX);
let AGt=B(Bi);
let VZ=a=>{B9(a);},
LM=()=>{let a=new AGt();VZ(a);return a;};
let AF6=B();
let AOU=null,AMC=null,AP2=null,BfJ=null,BfM=null,BfL=null,ATq=null,AV1=null,Bg5=null,AL_=null,Bf0=null;
let AF$=()=>{AF$=N(AF6);A3U();};
let A3U=()=>{AOU=Cq(16);AMC=FI();AP2=FI();BfJ=X();BfM=X();BfL=X();ATq=X();AV1=C0();Bg5=X();AL_=X();Bf0=X();};
let CC=B();
let ARg=B(CC);
let A0Q=B(CG);
let BeD=B();
let Ph=B(0);
function OC(){let a=this;A.call(a);a.wP=null;a.zS=null;a.Ca=null;a.Ax=null;a.DV=0;a.Au=0;a.BG=0;a.Gl=0;a.w2=0;a.HJ=0;a.ET=0;a.wZ=0;a.Ii=0;a.yW=0;a.CP=0;}
let NI=(a,b,c,d,e,f,g)=>{let h;L(a);a.yW=(-1);h=e+1|0;a.DV=h;a.wP=Bp(h*2|0);a.zS=Bp(g);Hl(a.zS,(-1));if(f>0)a.Ca=Bp(f);Hl(a.wP,(-1));a.dv(b,c,d);},
BlC=(a,b,c,d,e,f)=>{let g=new OC();NI(g,a,b,c,d,e,f);return g;},
BeS=(a,b,c)=>{a.zS.data[b]=c;},
A3d=(a,b)=>{return a.zS.data[b];},
AJF=a=>{return a.dw(0);},
A2e=(a,b)=>{Y_(a,b);return a.wP.data[(b*2|0)+1|0];},
ARy=(a,b,c)=>{a.wP.data[b*2|0]=c;},
AOf=(a,b,c)=>{a.wP.data[(b*2|0)+1|0]=c;},
A9_=(a,b)=>{return a.wP.data[b*2|0];},
A$A=(a,b)=>{return a.wP.data[(b*2|0)+1|0];},
AM7=(a,b)=>{if(a.dy(b)<0)return null;return (a.Ax.be(a.dy(b),a.dw(b))).y();},
A1u=(a,b)=>{let c,d;c=a.bT(b);d=a.bP(b);if((d|c|(d-c|0))>=0&&d<=a.Ax.bb())return (a.Ax.be(c,d)).y();return null;},
A$e=a=>{return a.dy(0);},
AQM=(a,b)=>{Y_(a,b);return a.wP.data[b*2|0];},
A31=a=>{if(a.wP.data[0]==(-1)){a.wP.data[0]=a.w2;a.wP.data[1]=a.w2;}a.yW=a.dz();},
AKH=(a,b)=>{return a.Ca.data[b];},
AQq=(a,b,c)=>{a.Ca.data[b]=c;},
Y_=(a,b)=>{if(!a.Au)I(IW());if(b>=0&&b<a.DV)return;I(GF(IP(b)));},
BfG=a=>{a.Au=1;},
BfK=a=>{return a.Au;},
BhN=(a,b,c,d)=>{a.Au=0;a.CP=2;Hl(a.wP,(-1));Hl(a.zS,(-1));if(b!==null)a.Ax=b;if(c>=0)BeR(a,c,d);a.w2=a.BG;},
ASb=a=>{a.dv(null,(-1),(-1));},
BeR=(a,b,c)=>{a.BG=b;a.Gl=c;},
A_X=(a,b)=>{a.w2=b;if(a.yW>=0)b=a.yW;a.yW=b;},
APq=a=>{return a.BG;},
A3X=a=>{return a.Gl;},
ATj=(a,b)=>{a.CP=b;},
AWk=a=>{return a.CP;},
AVc=(a,b)=>{a.ET=b;},
AYe=a=>{return a.ET;},
AKB=a=>{return a.HJ;},
AMQ=a=>{return a.yW;};
let AO0=B();
let E1=B();
let A98=B(Ct);
let ABS=B();
let A4W=0,Bgt=0,Bcq=0,Jk=0,AJ9=0,AU5=0,AL7=0;
let GS=()=>{GS=N(ABS);AXA();};
let AXA=()=>{A4W=imgui.ImGuiFocusedFlags_None;Bgt=imgui.ImGuiFocusedFlags_ChildWindows;Bcq=imgui.ImGuiFocusedFlags_RootWindow;Jk=imgui.ImGuiFocusedFlags_AnyWindow;AJ9=imgui.ImGuiFocusedFlags_NoPopupHierarchy;AU5=imgui.ImGuiFocusedFlags_DockHierarchy;AL7=imgui.ImGuiFocusedFlags_RootAndChildWindows;};
function QO(){T.call(this);this.Gr=null;}
let Y7=(a,b)=>{a.Gr=b;Bh(a);},
A7F=a=>{let b=new QO();Y7(b,a);return b;},
BiA=(a,b)=>{return Bio(b);};
let JR=B();
let Bfn=0.0;
let AEK=()=>{AEK=N(JR);AYd();};
let AYd=()=>{Bfn=0.0;};
let AEF=B(JR);
let Bjk=null;
let Tb=()=>{Tb=N(AEF);A$D();};
let A$D=()=>{Bjk=M8();};
let EU=B(Bi);
let EO=(a,b)=>{Dw(a,b);},
DF=a=>{let b=new EU();EO(b,a);return b;};
let A6V=B(B6);
function Ku(){let a=this;A.call(a);a.Gs=null;a.Hg=null;}
let T9=(a,b,c)=>{let d,e,f,g;d=c.data;L(a);AD9(b);e=d.length;f=0;while(f<e){g=d[f];AD9(g);f=f+1|0;}a.Gs=b;a.Hg=c.b$();},
AD9=b=>{let c,d;if(b.cd())I(Mb(b));if(!AEa(b.bc(0)))I(Mb(b));c=1;while(c<b.bb()){f:{d=b.bc(c);switch(d){case 43:case 45:case 46:case 58:case 95:break;default:if(AEa(d))break f;else I(Mb(b));}}c=c+1|0;}},
AEa=b=>{let c;d:{a:{if(!(b>=48&&b<=57)&&!(b>=97&&b<=122)){if(b<65)break a;if(b>90)break a;}c=1;break d;}c=0;}return c;},
AAR=(a,b)=>{let c,d,e,$$je;d:{try{c=a.dF();DZ();d=ED;d=AGg(c,d);c=ED;d=ABJ(d,c);d=TX(d,b);}catch($$e){$$je=Bb($$e);if($$je instanceof Ew){e=$$je;break d;}else{throw $$e;}}return d;}I(AUX(D(232),e));};
function D_(){let a=this;BD.call(a);a.zy=0;a.BM=null;a.Bg=null;a.Bc=0;}
let Hk=(a,b,c)=>{Cu(a);a.zy=1;a.Bg=b;a.Bc=c;},
BjH=(a,b)=>{let c=new D_();Hk(c,a,b);return c;},
Bhe=(a,b)=>{a.vN=b;},
A7R=(a,b,c,d)=>{let e,f,g,h,i,j,k,l,m,n,o,p;e=Bp(4);f=0;g=d.bq();if(b>=g)return (-1);h=a.dJ(b,c,g);i=b+a.zy|0;j=AF3(h);if(j===null){k=e.data;l=1;k[f]=h;}else{l=j.data.length;C5(j,0,e,0,l);l=f+l|0;}c:{if(i<g){m=a.dJ(i,c,g);while(l<4){if(!A8M(m)){k=e.data;n=l+1|0;k[l]=m;}else{k=(AF3(m)).data;if(k.length!=2){o=e.data;n=l+1|0;o[l]=k[0];}else{o=e.data;m=l+1|0;o[l]=k[0];n=m+1|0;o[m]=k[1];}}i=i+a.zy|0;if(i>=g){l=n;break c;}m=a.dJ(i,c,g);l=n;}}}if(l!=a.Bc)return (-1);p=0;while(true){if(p>=l)return a.vN.br(i,c,d);if
(e.data[p]!=a.Bg.data[p])break;p=p+1|0;}return (-1);},
AGx=a=>{let b,c;if(a.BM===null){b=O();c=0;while(c<a.Bc){b.dN(Gf(a.Bg.data[c]));c=c+1|0;}a.BM=b.y();}return a.BM;},
AZ5=(a,b,c,d)=>{let e,f,g,h;a.zy=1;if(b>=(d-1|0))e=c.bc(b);else{f=b+1|0;e=c.bc(b);g=c.bc(f);if(G_(e,g)){h=AY4([e,g]);e=A9p(h,0);a.zy=2;}}return e;},
A1E=(a,b)=>{let c,d;d:{if(b instanceof D_){c=b;if(!(AGx(c)).bi(AGx(a))){d=0;break d;}}d=1;}return d;},
A$L=(a,b)=>{return 1;};
let Ca=B(Bi);
let FO=a=>{B9(a);},
CF=()=>{let a=new Ca();FO(a);return a;},
Dy=(a,b)=>{Dw(a,b);},
B3=a=>{let b=new Ca();Dy(b,a);return b;};
function AEn(){Ca.call(this);this.GN=null;}
let AFJ=(a,b)=>{FO(a);a.GN=b;},
Mb=a=>{let b=new AEn();AFJ(b,a);return b;};
let Ju=B(Bo);
let AZU=null;
let AEN=()=>{AEN=N(Ju);AL6();};
let AL6=()=>{AZU=BF();};
let A3$=B();
function He(){Ge.call(this);this.IS=null;}
let Ki=(a,b)=>{JU(a);a.IS=b;},
BlI=a=>{let b=new He();Ki(b,a);return b;};
function F9(){let a=this;He.call(a);a.H2=0;a.Hr=null;a.G6=null;a.Id=null;}
let Pp=(a,b,c)=>{Ki(a,b);a.Hr=O();a.G6=Cr(32);a.H2=c;F7();a.Id=Qa;},
Bld=(a,b)=>{let c=new F9();Pp(c,a,b);return c;},
Ob=(a,b)=>{Pp(a,b,0);},
BlG=a=>{let b=new F9();Ob(b,a);return b;};
let ABI=B(C_);
let RD=(a,b,c)=>{EW(a,b,c);},
AV3=(a,b)=>{let c=new ABI();RD(c,a,b);return c;},
AJ2=(a,b,c,d)=>{let e,f,g,h;e=a.wg.bV();d.c7(a.v8,b);f=0;while(true){if(f>=e)return a.vN.br(b,c,d);g=a.wg.bW(f);h=g.dt(0,b,c,d);if(h>=0)break;f=f+1|0;}return (-1);},
A_I=(a,b)=>{return 0;};
let FQ=B(CZ);
let ACx=(a,b,c,d)=>{Fj(a,b);a.vU=c;a.v4=d;},
A0o=(b,c,d)=>{return A7C(0,b.data.length,b,c,c+d|0,0);},
AXd=b=>{return A0o(b,0,b.data.length);},
Dv=a=>{FP(a);return a;},
AJG=(a,b)=>{ER(a,b);return a;},
A52=a=>{return Dv(a);};
let Gd=B(FQ);
let Lp=(a,b,c,d)=>{ACx(a,b,c,d);},
Bdl=a=>{let b;if(a.vU>=a.v4)I(PO());b=a.vU;a.vU=b+1|0;return a.d0(b);},
A5H=(a,b)=>{let c;if(a.d1())I(D2());if(a.vU>=a.v4)I(FR());c=a.vU;a.vU=c+1|0;a.d2(c,b);return a;},
A37=(a,b)=>{let c,d,e;if(b>=0&&b<a.v4)return a.d0(b);c=new Bv;d=a.v4;e=O();BA(V(K(V(K(e,D(233)),b),D(35)),d),41);BB(c,S(e));I(c);},
BdO=(a,b,c)=>{let d,e,f;if(a.d1())I(D2());if(b>=0&&b<a.v4){a.d2(b,c);return a;}d=new Bv;e=a.v4;f=O();BA(V(K(V(K(f,D(233)),b),D(35)),e),41);BB(d,S(f));I(d);},
A29=a=>{return a.d3();};
let E3=B(0);
function GE(){let a=this;Gd.call(a);a.wr=null;a.EN=0;a.ws=0;}
let Ke=(a,b,c,d,e,f,g)=>{Lp(a,c,e,f);a.ws=b;a.wr=d;a.EN=g;},
A2F=a=>{return a.EN;};
let SE=B(GE);
let Vy=(a,b,c,d,e,f,g)=>{Ke(a,b,c,d,e,f,g);},
A8Z=(a,b,c,d,e,f)=>{let g=new SE();Vy(g,a,b,c,d,e,f);return g;},
AV9=(a,b)=>{let c,d,e;c=a.wr.vS.data;d=a.ws;e=b*4|0;return c[d+e|0]&255|(a.wr.vS.data[(a.ws+e|0)+1|0]&255)<<8|(a.wr.vS.data[(a.ws+e|0)+2|0]&255)<<16|(a.wr.vS.data[(a.ws+e|0)+3|0]&255)<<24;},
AJo=(a,b,c)=>{let d,e,f;d=a.wr.vS.data;e=a.ws;f=b*4|0;d[e+f|0]=c<<24>>24;a.wr.vS.data[(a.ws+f|0)+1|0]=c>>8<<24>>24;a.wr.vS.data[(a.ws+f|0)+2|0]=c>>16<<24>>24;a.wr.vS.data[(a.ws+f|0)+3|0]=c>>24<<24>>24;};
function Md(){A.call(this);this.HO=null;}
let S2=(a,b)=>{a.HO=b;L(a);},
A9v=a=>{let b=new Md();S2(b,a);return b;},
A5b=(a,b)=>{b.preventDefault();},
A0t=(a,b)=>{a.bn(b);};
function Me(){A.call(this);this.It=null;}
let AIg=(a,b)=>{a.It=b;L(a);},
AX4=a=>{let b=new Me();AIg(b,a);return b;},
BjT=(a,b)=>{b.preventDefault();},
Bho=(a,b)=>{a.bn(b);};
let AEj=B(W);
let XC=a=>{Bn(a);},
BfY=()=>{let a=new AEj();XC(a);return a;},
A2f=a=>{let b;b=A7F(a);b.v3=1;return b;};
function Mc(){let a=this;A.call(a);a.DA=null;a.Do=null;a.DW=null;}
let Xf=(a,b,c,d)=>{a.DW=b;a.DA=c;a.Do=d;L(a);},
AY_=(a,b,c)=>{let d=new Mc();Xf(d,a,b,c);return d;},
A4$=(a,b)=>{let c,d,e,f,g,h,i,j,k,l;d:{b.preventDefault();c=b.dataTransfer;d=c.files;e=d.length;if(e>0){f=Dx();g=0;while(true){if(g>=e)break d;h=d[g];i=Ba(h.name);j=BeF(i);k=new FileReader();l=Bds(a,j,i,f,e);k.addEventListener("load",Bu(l,"handleEvent"));CM();if(j!==DJ&&j!==Dz){if(j===DP)k.readAsDataURL(h);else if(j===DS)k.readAsText(h);}else k.readAsArrayBuffer(h);g=g+1|0;}}}},
A9i=(a,b)=>{a.bn(b);};
let Cn=B();
let DT=a=>{L(a);},
Ba5=()=>{let a=new Cn();DT(a);return a;},
A4z=(a,b)=>{return;},
AX6=(a,b)=>{return;};
function Wp(){let a=this;Cn.call(a);a.DO=null;a.DK=0;a.xw=null;}
let TT=(a,b,c,d)=>{a.xw=b;a.DO=c;a.DK=d;DT(a);},
A1G=(a,b,c)=>{let d=new Wp();TT(d,a,b,c);return d;},
Bcc=(a,b)=>{return;},
ATD=(a,b)=>{let c,d,e;c=Ci();d=a.DO;e=O();K(K(e,D(234)),d);c.d$(S(e));},
AMt=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q;d=c.d_(D(235));e=d.data;f=e.length;g=0;while(true){if(g>=f){g:{a.xw.B_=a.xw.zg.v2;if(a.DK){h=0;while(true){if(h>=a.xw.zg.v2)break g;i=a.xw.zg.bW(h);a.xw.ea(i);h=h+1|0;}}}return 0;}j=e[g];k=j.d_(D(236));l=k.data;if(l.length!=4)break;m=l[0];n=l[1].eb();o=Bfr(l[2]);p=l[3];CM();q=DS;if(m.bi(D(237)))q=DP;if(m.bi(D(238)))q=DJ;if(m.bi(D(239)))q=Dz;if(m.bi(D(71)))q=GQ;if(q===Dz&&!(EE()).ee())o=Bg;i=APY(n,q,o,p);a.xw.Eh.bL(i.zj,i.zj);a.xw.zg.eg(i);g=g+1|0;}I(DF(D(240)));},
A59=(a,b,c)=>{return a.eh(b,c);};
function Wq(){let a=this;Cn.call(a);a.yz=null;a.IF=null;}
let AAA=(a,b,c)=>{a.IF=b;a.yz=c;DT(a);},
A_n=(a,b)=>{let c=new Wq();AAA(c,a,b);return c;},
Bgn=(a,b)=>{a.yz.En=Xu(b);},
A3h=(a,b)=>{a.yz.BZ=1;a.yz.zs=0;},
AUh=(a,b,c)=>{a.yz.CB=1;a.yz.zs=0;return 0;};
function EB(){let a=this;A.call(a);a.x8=0.0;a.x7=0.0;a.x6=0.0;a.x5=0.0;}
let VX=null,AX5=null,A6r=null,Bi8=null,AZp=null,AB3=0.0,AMa=null,Bgj=null,AKq=null,Bdm=null,Bfd=null,A76=null,Bb8=null,AWN=null,AVT=null,A$B=null,BgP=null,Bc5=null,BjJ=null,ALU=null,AZn=null,Bjw=null,A4j=null,Bhc=null,BeG=null,BbX=null,A4f=null,AK4=null,A3P=null,AWo=null,AYf=null,AVq=null,A3I=null,A9g=null,A_c=null;
let EH=()=>{EH=N(EB);AJI();};
let AIn=a=>{EH();L(a);},
SW=()=>{let a=new EB();AIn(a);return a;},
AGd=(a,b)=>{EH();L(a);Bc3(a,b);},
BH=a=>{let b=new EB();AGd(b,a);return b;},
ACC=(a,b,c,d,e)=>{EH();L(a);a.x8=b;a.x7=c;a.x6=d;a.x5=e;a.ej();},
CE=(a,b,c,d)=>{let e=new EB();ACC(e,a,b,c,d);return e;},
BaL=a=>{if(a.x8<0.0)a.x8=0.0;else if(a.x8>1.0)a.x8=1.0;if(a.x7<0.0)a.x7=0.0;else if(a.x7>1.0)a.x7=1.0;if(a.x6<0.0)a.x6=0.0;else if(a.x6>1.0)a.x6=1.0;if(a.x5<0.0)a.x5=0.0;else if(a.x5>1.0)a.x5=1.0;return a;},
Beq=a=>{let b;b=(255.0*a.x5|0)<<24|(255.0*a.x6|0)<<16|(255.0*a.x7|0)<<8|255.0*a.x8|0;return AO$(b);},
Bc3=(b,c)=>{EH();b.x8=((c&(-16777216))>>>24|0)/255.0;b.x7=((c&16711680)>>>16|0)/255.0;b.x6=((c&65280)>>>8|0)/255.0;b.x5=(c&255)/255.0;},
AJI=()=>{VX=CE(1.0,1.0,1.0,1.0);AX5=BH((-1077952513));A6r=BH(2139062271);Bi8=BH(1061109759);AZp=CE(0.0,0.0,0.0,1.0);AB3=VX.el();AMa=CE(0.0,0.0,0.0,0.0);Bgj=CE(0.0,0.0,1.0,1.0);AKq=CE(0.0,0.0,0.5,1.0);Bdm=BH(1097458175);Bfd=BH(1887473919);A76=BH((-2016482305));Bb8=CE(0.0,1.0,1.0,1.0);AWN=CE(0.0,0.5,0.5,1.0);AVT=BH(16711935);A$B=BH(2147418367);BgP=BH(852308735);Bc5=BH(579543807);BjJ=BH(1804477439);ALU=BH((-65281));AZn=BH((-2686721));Bjw=BH((-626712321));A4j=BH((-5963521));Bhc=BH((-1958407169));BeG=BH((-759919361));BbX
=BH((-1306385665));A4f=BH((-16776961));AK4=BH((-13361921));A3P=BH((-8433409));AWo=BH((-92245249));AYf=BH((-9849601));AVq=CE(1.0,0.0,1.0,1.0);A3I=BH((-1608453889));A9g=BH((-293409025));A_c=BH((-1339006721));};
function Wo(){let a=this;Cn.call(a);a.A0=null;a.FL=null;a.Ex=null;a.E$=null;}
let Ym=(a,b,c,d,e)=>{a.E$=b;a.A0=c;a.FL=d;a.Ex=e;DT(a);},
AS5=(a,b,c,d)=>{let e=new Wo();Ym(e,a,b,c,d);return e;},
ANL=(a,b)=>{a.A0.em(b);},
AJ4=(a,b)=>{a.A0.bj(b);},
A38=(a,b,c)=>{a.E$.en(a.FL,a.Ex,c);a.A0.bl(b,c);return 0;};
let Eh=B();
let Bdx=B(Eh);
function DY(){let a=this;A.call(a);a.HH=0;a.xd=0;a.xU=0;a.xC=0;a.x$=0;a.xs=null;a.Ig=0;a.HY=0;}
let ABm=(a,b,c,d)=>{P0(a,b,c,d,0);},
OA=(a,b,c)=>{let d=new DY();ABm(d,a,b,c);return d;},
P0=(a,b,c,d,e)=>{let f;f=CA(b,4);Ja(a,b,c,f?5126:5121,f?0:1,d,e);},
Bk1=(a,b,c,d)=>{let e=new DY();P0(e,a,b,c,d);return e;},
U_=(a,b,c,d,e,f)=>{Ja(a,b,c,d,e,f,0);},
OR=(a,b,c,d,e)=>{let f=new DY();U_(f,a,b,c,d,e);return f;},
Ja=(a,b,c,d,e,f,g)=>{L(a);a.HH=b;a.xd=c;a.xC=d;a.xU=e;a.xs=f;a.Ig=g;a.HY=Gz(b);},
BkU=(a,b,c,d,e,f)=>{let g=new DY();Ja(g,a,b,c,d,e,f);return g;},
VD=a=>{b:{switch(a.xC){case 5120:case 5121:break;case 5122:case 5123:return 2*a.xd|0;case 5124:case 5125:case 5127:case 5128:case 5129:case 5130:case 5131:break b;case 5126:case 5132:return 4*a.xd|0;default:break b;}return a.xd;}return 0;};
let F1=B(Bo);
function Cv(){Dp.call(this);this.v9=null;}
let Em=(a,b,c,d)=>{FL(a,b,c,d);a.v9=b;},
A9V=(a,b,c)=>{let d=new Cv();Em(d,a,b,c);return d;},
AJ5=(a,b,c,d)=>{let e,f;e=0;d:{while((b+a.v9.bw()|0)<=d.bq()){f=a.v9.bx(b,c);if(f<=0)break d;b=b+f|0;e=e+1|0;}}while(true){if(e<0)return (-1);f=a.vN.br(b,c,d);if(f>=0)break;b=b-a.v9.bw()|0;e=e+(-1)|0;}return f;};
let AF4=B(Cv);
let Yk=(a,b)=>{Em(a,b.es(),b.et(),b.eu());a.vY.bX(a);},
AQp=a=>{let b=new AF4();Yk(b,a);return b;},
Bis=(a,b,c,d)=>{let e;while((b+a.v9.bw()|0)<=d.bq()){e=a.v9;if(e.bx(b,c)<=0)break;b=b+a.v9.bw()|0;}return a.vN.br(b,c,d);},
A54=(a,b,c,d)=>{let e,f,g;e=a.vN.ev(b,c,d);if(e<0)return (-1);f=e-a.v9.bw()|0;while(f>=b&&a.v9.bx(f,c)>0){g=f-a.v9.bw()|0;e=f;f=g;}return e;};
let QJ=B(0);
function Jv(){let a=this;A.call(a);a.BN=null;a.FT=null;a.xi=null;a.yO=null;}
let AEC=0;
let Bb3=(a,b)=>{let c;L(a);a.xi=b;c=a;b.classObject=c;},
A$m=a=>{let b=new Jv();Bb3(b,a);return b;},
IN=b=>{let c;if(b===null)return null;c=b.classObject;if(c===null)c=A$m(b);return c;},
AN6=a=>{return a.xi;},
ATa=(a,b)=>{return A6p(b,a.xi);},
A11=a=>{if(a.BN===null)a.BN=AEV(a.xi);return a.BN;},
AQy=a=>{let b,c,d,e,f;b=A0H(a);if(b===null){if(a.eA()){c=(a.eB()).eC();d=O();K(K(d,c),D(241));b=S(d);}else if(a.eD()!==null){b=BeV(a.xi);if(b===null)b=D(37);}else{b=AEV(a.xi);e=b.eF(36);if(e==(-1)){f=b.eF(46);if(f!=(-1))b=b.eG(f+1|0);}else{b=b.eG(e+1|0);if(b.bc(0)>=48&&b.bc(0)<=57)b=D(37);}}AVI(a,b);}return b;},
A0H=b=>{return b.FT;},
AVI=(b,c)=>{b.FT=c;},
AXo=a=>{return Bbt(a.xi);},
Bgq=a=>{return AHM(a.xi)===null?0:1;},
A4c=a=>{return IN(AHM(a.xi));},
AUs=()=>{if(!AEC){AEC=1;A1P();}},
A1P=()=>{Hy.$meta.methods=[{name:"<init>",modifiers:0,accessLevel:3,parameterTypes:[],returnType:FK,callable:null},{name:"<clinit>",modifiers:512,accessLevel:0,parameterTypes:[],returnType:FK,callable:null}];Ho.$meta.methods=[{name:"<init>",modifiers:0,accessLevel:3,parameterTypes:[],returnType:FK,callable:null},{name:"appendRun",modifiers:0,accessLevel:0,parameterTypes:[Ho],returnType:FK,callable:null},{name:"reset",modifiers:0,accessLevel:3,parameterTypes:[],returnType:FK,callable:null},{name:"toString",modifiers
:0,accessLevel:3,parameterTypes:[],returnType:BG,callable:null}];},
Bjn=a=>{let b,c,d,e,f,g,h,i,j,k,l,m;if(!a.eL()&&!a.eA()){if(a.yO===null){AUs();b=(a.dc()).$meta;c=b.methods;a.yO=Bt(E2,c.length);d=0;e=0;while(e<c.length){f=AMb(c[e]);if(Ba(f.name).bi(D(242))){g=f.parameterTypes;h=Bt(Jv,g.length);i=0;while(true){j=h.data;if(i>=j.length)break;j[i]=IN(g[i]);i=i+1|0;}j=a.yO.data;k=d+1|0;l=new E2;b=Ba(f.name);m=f.modifiers;Or(l,a,b,m,f.accessLevel,h,Cl(f.callable,"call"));j[d]=l;d=k;}e=e+1|0;}a.yO=H8(a.yO,d);}return a.yO.b$();}return Bt(E2,0);},
BgL=a=>{let b,c,d,e,f,g,h,i,j;b=a.eQ();c=b.data;d=c.length;e=Bt(E2,d);f=0;g=0;while(g<d){h=c[g];if(UP(h.eS())){i=e.data;j=f+1|0;i[f]=h;f=j;}g=g+1|0;}if(f<e.data.length)e=H8(e,f);return e;},
Ba8=(a,b)=>{let c,d,e,f;c=(a.eQ()).data;d=c.length;e=0;while(true){if(e>=d)I(AHj());f=c[e];if(AEP(f.eU(),b))break;e=e+1|0;}return f;},
Ba1=(a,b)=>{let c,d,e,f;c=(a.eQ()).data;d=c.length;e=0;while(true){if(e>=d)I(AHj());f=c[e];if(UP(f.eS())&&AEP(f.eU(),b))break;e=e+1|0;}return f;},
AUU=a=>{let b;b=Bd7(a.dc());return b===null?null:IN(b);};
let A1k=B(CC);
let Du=B(0);
function PC(){let a=this;A.call(a);a.vT=null;a.v7=0;}
let TI=a=>{L(a);a.vT=Bp(2);},
AIO=()=>{let a=new PC();TI(a);return a;},
Rd=(a,b)=>{L(a);if(b<0)I(AGU());a.vT=Bp(((b+32|0)-1|0)/32|0);},
A$K=a=>{let b=new PC();Rd(b,a);return b;},
A$l=(a,b)=>{let c,d;if(b<0)I(Ch());c=b/32|0;if(b>=a.v7){I1(a,c+1|0);a.v7=b+1|0;}d=a.vT.data;d[c]=d[c]|1<<(b%32|0);},
AYn=(a,b,c)=>{let d,e,f,g,h;if(b>=0){d=CA(b,c);if(d<=0){if(!d)return;e=b/32|0;f=c/32|0;if(c>a.v7){I1(a,f+1|0);a.v7=c;}if(e==f){g=a.vT.data;g[e]=g[e]|HG(a,b)&ID(a,c);}else{g=a.vT.data;g[e]=g[e]|HG(a,b);h=e+1|0;while(h<f){a.vT.data[h]=(-1);h=h+1|0;}if(c&31){g=a.vT.data;g[f]=g[f]|ID(a,c);}}return;}}I(Ch());},
HG=(a,b)=>{let c;c=b%32|0;return (-1)<<c;},
ID=(a,b)=>{let c;c=b%32|0;return !c?0:(-1)>>>(32-c|0)|0;},
Bj1=(a,b)=>{let c,d;if(b<0)I(Ch());c=b/32|0;if(c<a.vT.data.length){d=a.vT.data;d[c]=d[c]&AVY((-2),b%32|0);if(b==(a.v7-1|0))GN(a);}},
ALr=(a,b,c)=>{let d,e,f,g,h;if(b>=0&&b<=c){if(b>=a.v7)return;d=B7(a.v7,c);if(b==d)return;e=b/32|0;f=d/32|0;if(e==f){g=a.vT.data;g[e]=g[e]&(ID(a,b)|HG(a,d));}else{g=a.vT.data;g[e]=g[e]&ID(a,b);h=e+1|0;while(h<f){a.vT.data[h]=0;h=h+1|0;}if(d&31){g=a.vT.data;g[f]=g[f]&HG(a,d);}}GN(a);return;}I(Ch());},
ALE=(a,b)=>{let c;if(b<0)I(Ch());c=b/32|0;return c<a.vT.data.length&&a.vT.data[c]&1<<(b%32|0)?1:0;},
Bid=(a,b)=>{let c,d,e,f,g;if(b<0)I(Ch());if(b>=a.v7)return (-1);c=b/32|0;d=a.vT.data[c];e=d>>>(b%32|0)|0;if(e)return Gz(e)+b|0;f=(a.v7+31|0)/32|0;g=c+1|0;while(g<f){if(a.vT.data[g])return (g*32|0)+Gz(a.vT.data[g])|0;g=g+1|0;}return (-1);},
A9q=(a,b)=>{let c,d,e,f,g;if(b<0)I(Ch());if(b>=a.v7)return b;c=b/32|0;d=a.vT.data[c]^(-1);e=d>>>(b%32|0)|0;if(e)return Gz(e)+b|0;f=(a.v7+31|0)/32|0;g=c+1|0;while(g<f){if(a.vT.data[g]!=(-1))return (g*32|0)+Gz(a.vT.data[g]^(-1))|0;g=g+1|0;}return a.v7;},
I1=(a,b)=>{let c;if(a.vT.data.length>=b)return;c=BT((b*3|0)/2|0,(a.vT.data.length*2|0)+1|0);a.vT=BhQ(a.vT,c);},
GN=a=>{let b,c,d;b=(a.v7+31|0)/32|0;a.v7=b*32|0;c=b-1|0;d:{while(true){if(c<0)break d;d=Sl(a.vT.data[c]);if(d<32)break;c=c+(-1)|0;a.v7=a.v7-32|0;}a.v7=a.v7-d|0;}},
A8n=(a,b)=>{let c,d;c=B7(a.vT.data.length,b.vT.data.length);d=0;while(d<c){if(a.vT.data[d]&b.vT.data[d])return 1;d=d+1|0;}return 0;},
Bf9=(a,b)=>{let c,d,e;c=B7(a.vT.data.length,b.vT.data.length);d=0;while(d<c){e=a.vT.data;e[d]=e[d]&b.vT.data[d];d=d+1|0;}while(c<a.vT.data.length){a.vT.data[c]=0;c=c+1|0;}a.v7=B7(a.v7,b.v7);GN(a);},
BiT=(a,b)=>{let c,d,e;c=B7(a.vT.data.length,b.vT.data.length);d=0;while(d<c){e=a.vT.data;e[d]=e[d]&(b.vT.data[d]^(-1));d=d+1|0;}GN(a);},
BfI=(a,b)=>{let c,d,e;a.v7=BT(a.v7,b.v7);I1(a,(a.v7+31|0)/32|0);c=B7(a.vT.data.length,b.vT.data.length);d=0;while(d<c){e=a.vT.data;e[d]=e[d]|b.vT.data[d];d=d+1|0;}},
A2l=(a,b)=>{let c,d,e;a.v7=BT(a.v7,b.v7);I1(a,(a.v7+31|0)/32|0);c=B7(a.vT.data.length,b.vT.data.length);d=0;while(d<c){e=a.vT.data;e[d]=e[d]^b.vT.data[d];d=d+1|0;}GN(a);},
Bgu=a=>{return a.v7?0:1;};
function PR(){Dg.call(this);this.GB=0.0;}
let AXc=null;
let F2=()=>{F2=N(PR);A9a();};
let Sh=(a,b)=>{F2();PN(a);a.GB=b;},
A0c=a=>{let b=new PR();Sh(b,a);return b;},
Zq=b=>{F2();return A0c(b);},
Pi=b=>{F2();if(isNaN(b)?1:0)return 2143289344;return BkL(b);},
A9a=()=>{AXc=Br(Blj);};
let ACU=B();
let A4e=0,Sz=0,AT5=0,A4s=0,Bj$=0,BjM=0,AI_=0,ATy=0,VG=0,A4I=0,ARI=0;
let Ne=()=>{Ne=N(ACU);Bh3();};
let Bh3=()=>{A4e=imgui.ImGuiTabBarFlags_None;Sz=imgui.ImGuiTabBarFlags_Reorderable;AT5=imgui.ImGuiTabBarFlags_AutoSelectNewTabs;A4s=imgui.ImGuiTabBarFlags_TabListPopupButton;Bj$=imgui.ImGuiTabBarFlags_NoCloseWithMiddleMouseButton;BjM=imgui.ImGuiTabBarFlags_NoTabListScrollingButtons;AI_=imgui.ImGuiTabBarFlags_NoTooltip;ATy=imgui.ImGuiTabBarFlags_FittingPolicyResizeDown;VG=imgui.ImGuiTabBarFlags_FittingPolicyScroll;A4I=imgui.ImGuiTabBarFlags_FittingPolicyMask_;ARI=imgui.ImGuiTabBarFlags_FittingPolicyDefault_;};
function Dr(){BM.call(this);this.xA=0;}
let ADf=(a,b)=>{CO(a);a.xA=b;},
LF=a=>{let b=new Dr();ADf(b,a);return b;},
A01=a=>{return 1;},
AXV=(a,b,c)=>{return a.xA!=c.bc(b)?(-1):1;},
ATX=(a,b,c,d)=>{let e,f,g,h;if(!(c instanceof BG))return FY(a,b,c,d);e=c;f=d.bq();while(true){if(b>=f)return (-1);g=e.e3(a.xA,b);if(g<0)return (-1);h=a.vN;b=g+1|0;if(h.br(b,c,d)>=0)break;}return g;},
A1g=(a,b,c,d,e)=>{let f,g;if(!(d instanceof BG))return F$(a,b,c,d,e);f=d;a:{while(true){if(c<b)return (-1);g=f.e4(a.xA,c);if(g<0)break a;if(g<b)break a;if(a.vN.br(g+1|0,d,e)>=0)break;c=g+(-1)|0;}return g;}return (-1);},
AOx=a=>{return a.xA;},
Bdo=(a,b)=>{if(b instanceof Dr)return b.e5()!=a.xA?0:1;if(!(b instanceof Di)){if(b instanceof CP)return b.b6(a.xA);if(!(b instanceof Df))return 1;return 0;}return b.bx(0,AGR(a.xA))<=0?0:1;};
let K7=B(BX);
function Cb(){let a=this;A.call(a);a.HQ=0;a.Hz=null;}
let O4=a=>{Qk(a,16,2147483647);},
Qk=(a,b,c)=>{L(a);a.Hz=AQc(0,b);a.HQ=c;};
let APv=B(Cb);
let XS=B(0);
let IO=B(0);
let ANP=B();
let La=B();
let NM=null;
let GM=()=>{GM=N(La);AS0();};
let TC=a=>{GM();L(a);},
AQX=()=>{let a=new La();TC(a);return a;},
BeU=(a,b)=>{a.e8(b,null,null);},
AOs=(a,b,c,d)=>{let e,f,g,h,i,j;e=O();K(K(K(e,D(243)),b),D(244));f=S(e);GM();if(NM.e9(f))return;if(b!==null){e=Ci();g=O();K(K(g,D(245)),f);e.d$(S(g));h=window;i=h.document;j=i.createElement("script");e=Be(f);j.src=e;e=APc(a,f,d);j.addEventListener("load",Bu(e,"handleEvent"));i.body.appendChild(j);}},
AS0=()=>{NM=Bij();};
let B0=B(BC);
let ASy=B(B0);
function MM(){let a=this;W.call(a);a.CQ=0;a.Bq=0;a.Dt=0;}
let Vm=(a,b,c)=>{Bn(a);a.Bq=c;a.CQ=b;},
Fs=(a,b)=>{let c=new MM();Vm(c,a,b);return c;},
QC=(a,b,c,d)=>{Bn(a);a.Dt=d;a.Bq=c;a.CQ=b;},
AZH=(a,b,c)=>{let d=new MM();QC(d,a,b,c);return d;},
AJj=a=>{let b;b=ANn(a.CQ);if(a.Dt)b.wd.bN(0,2048);b.v3=a.Bq;return b;};
function Bm(){let a=this;A.call(a);a.zx=Bg;a.Al=0;a.GS=0;a.EX=0;}
let SJ=0,ACI=0;
let Gx=()=>{Gx=N(Bm);A8o();};
let BR=a=>{Gx();L(a);},
Bb$=(a,b,c)=>{a.Al=c;a.zx=b;},
BgC=(a,b)=>{if(!a.Al)a.zx=b;},
ANv=a=>{return a.zx;},
Bhb=a=>{return;},
AJr=a=>{let b,c,d;if(a.EX>0){Gx();if(SJ&&ACI){b=a.y();c=a.EX;d=O();K(V(K(K(K(d,D(246)),b),D(247)),c),D(248));A7G(D(249),S(d));}}if(a.Al){a.GS=1;a.fa();a.zx=Bg;}},
A1h=a=>{let b,c,d,e;b=(Do(a)).eC();c=a.zx;d=a.Al;e=O();BA(SI(BA(W4(BA(K(e,b),40),c),44),d),41);return S(e);},
A7G=(b,c)=>{Gx();},
A8o=()=>{SJ=0;ACI=1;};
let Hp=B(Bm);
let O7=(a,b)=>{let c;BR(a);c=Q(A1v(b));a.fe(c,1);},
Bk8=a=>{let b=new Hp();O7(b,a);return b;},
AXi=(a,b)=>{return A0e(U((a.fg())),b);},
A1v=b=>{var jsObj=new imgui.IDLDoubleArray(b);return imgui.getPointer(jsObj);},
A0e=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.IDLDoubleArray);var returnedJSObj=jsObj.getValue(c);return returnedJSObj;};
let KU=B(Hp);
let Sf=null,Sg=null;
let IC=()=>{IC=N(KU);ALZ();};
let A$j=()=>{IC();Sf.fh();Sg.fh();},
AHL=a=>{IC();O7(a,1);},
Sp=()=>{let a=new KU();AHL(a);return a;},
ARw=a=>{return a.fi(0);},
AZr=a=>{return AUg(a.fk());},
ALZ=()=>{Sf=Sp();Sg=Sp();};
let ACZ=B();
let AOo=null;
let Qo=()=>{Qo=N(ACZ);BfT();};
let BfT=()=>{AOo=SW();};
function AGL(){let a=this;A.call(a);a.y3=null;a.FY=0;a.EI=0;a.wp=null;a.w7=null;a.CN=0;a.H3=null;a.Gp=null;}
let AE8=a=>{let b,c;L(a);a.wp=C0();a.H3=D(250);a.Gp=D(251);a.y3=W8(H(DY,[OR(1,2,5126,0,D(252)),OR(16,2,5126,0,D(253)),OR(4,4,5121,1,D(254))]));b=Bh8(a);c=Bil(a);a.w7=Wt(b,c);if(!a.w7.fq()){C6.fr(D(255),a.w7.fs());C6.ft();}AXt(a);AK8(a);},
A7p=()=>{let a=new AGL();AE8(a);return a;},
AXt=a=>{let b,c,d,e,f,g,h,i,j,k,l;b=131072;c=DH(b);d=OI(1);e=OI(1);f=OI(1);g=Biu(b);h=CX();h.fy(g,d,e,f);i=d.fz(0);j=e.fz(0);f.fz(0);k=CW(i,j)*4|0;l=0;while(l<k){c.fA(l,g.fB(l));l=l+1|0;}c.fC(0);c.fD(k);a.CN=Bc.fE();Bc.fF(3553,a.CN);Bc.fG(3553,10241,9729);Bc.fG(3553,10240,9729);Bc.fH(3317,1);Bc.fI(3553,0,6408,i,j,0,6408,5121,c);h.fJ(a.CN);},
AK8=a=>{a.FY=Y.fK();a.EI=Y.fK();},
A8W=a=>{let b,c,d,e,f;b=B5.fL();c=B5.fM();d=B5.fN();e=B5.fO();f=B5.fP();a.fQ(b,c,d,e,f);},
AZm=(a,b,c,d,e,f)=>{AOk(b,c,d,e,f);},
A4p=(a,b)=>{a.fS(b,0);},
A0v=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ba,bb,bc,bd,be,bf,bg,bh,bi,bj;d=UH(b);if(d>0){e=Bc.fU(3042);f=Bc.fU(2884);g=Bc.fU(2929);h=Bc.fU(2960);i=Bc.fU(3089);j=KY(b)*L_(b)|0;k=NZ(b)*Nw(b)|0;Beu(a,b,j,k);l=Ik(b);m=Hb(b);n=L_(b);o=Nw(b);p=0;while(p<d){q=AEl(b,p);r=q.f3();s=q.f4();t=BI(r);u=BI(s);Bc.f6(34962,t,r,35040);Bc.f6(34963,u,s,35040);v=q.f7();w=0;while(w<v){x=q.f8(w);y=x.f9();z=y.f$();ba=y.f_();bb=y.ga();bc=y.gb();bd=(z-l)*n;be=(ba-m)*o;bf=(bb-l)*n;bg=(bc-m)*o;if(bf>=bd&&bg>=be){Bc.gc(bd
|0,k-bg|0,bf-bd|0,bg-be|0);bh=x.gd();bi=x.ge();bj=x.gf();Bc.fF(3553,bh);Bc.gg(4,bj,5123,bi*2|0);}w=w+1|0;}p=p+1|0;}a.gh();if(!e)Bc.gi(3042);else Bc.gj(3042);if(!f)Bc.gi(2884);else Bc.gj(2884);if(!g)Bc.gi(2929);else Bc.gj(2929);if(!h)Bc.gi(2960);else Bc.gj(2960);if(!i)Bc.gi(3089);else Bc.gj(3089);}},
Beu=(a,b,c,d)=>{let e,f,g,h,i,j,k,l;Bc.gj(3042);Bc.gk(32774);Bc.gl(770,771,1,771);Bc.gi(2884);Bc.gi(2929);Bc.gi(2960);Bc.gj(3089);e=Ik(b);f=Ik(b)+KY(b);g=Hb(b);h=Hb(b)+NZ(b);a.wp.vL.data[0]=2.0/(f-e);a.wp.vL.data[1]=0.0;a.wp.vL.data[2]=0.0;a.wp.vL.data[3]=0.0;a.wp.vL.data[4]=0.0;a.wp.vL.data[5]=2.0/(g-h);a.wp.vL.data[6]=0.0;a.wp.vL.data[7]=0.0;a.wp.vL.data[8]=0.0;a.wp.vL.data[9]=0.0;a.wp.vL.data[10]=(-1.0);a.wp.vL.data[11]=0.0;a.wp.vL.data[12]=(f+e)/(e-f);a.wp.vL.data[13]=(g+h)/(h-g);a.wp.vL.data[14]=0.0;a.wp.vL.data[15]
=1.0;a.w7.gm();a.w7.gn(D(256),0);a.w7.go(D(257),a.wp);Bc.gp(34962,a.FY);Bc.gp(34963,a.EI);i=De(a.y3);j=0;while(j<i){k=CQ(a.y3,j);l=a.w7.gr(k.xs);if(l>=0){a.w7.gs(l);a.w7.gt(l,k.xd,k.xC,k.xU,a.y3.w6,k.x$);}j=j+1|0;}},
A7w=a=>{let b,c;Bc.gp(34962,0);b=De(a.y3);c=0;while(c<b){a.w7.gu((CQ(a.y3,c)).xs);c=c+1|0;}Bc.gp(34963,0);Bc.gv();},
Bh8=a=>{return D(250);},
Bil=a=>{return D(251);};
let EX=B(0);
let I_=B(Cc);
let AWG=null,AWH=null,AWK=null,A57=0.0,AKz=0.0;
let W6=()=>{W6=N(I_);BhD();};
let BhD=()=>{AWG=BF();AWH=BF();AWK=BF();A57=0.4000000059604645;AKz=0.10000000149011612;};
let ASW=B(I_);
let Z3=B(0);
let NA=B(CZ);
let AAC=(a,b,c,d)=>{Fj(a,b);a.vU=c;a.v4=d;},
AHQ=b=>{let c,d;if(b>=0)return ANd(b);c=new Ca;d=O();V(K(d,D(258)),b);Dy(c,S(d));I(c);},
A1r=(b,c,d)=>{return A9M(0,b.data.length,b,c,c+d|0,0);},
A5A=b=>{return A1r(b,0,b.data.length);},
AME=(a,b,c,d)=>{let e,f,g,h,i,j,k,l;if(c>=0){e=b.data;f=e.length;if(c<=f){g=c+d|0;if(g>f){h=new Bv;i=O();V(K(V(K(i,D(259)),g),D(260)),f);BB(h,S(i));I(h);}if(Bk(a)<d)I(PO());if(d<0){i=new Bv;h=O();K(V(K(h,D(261)),d),D(262));BB(i,S(h));I(i);}j=a.vU;k=0;while(k<d){g=c+1|0;f=j+1|0;e[c]=a.gz(j);k=k+1|0;c=g;j=f;}a.vU=a.vU+d|0;return a;}}e=b.data;i=new Bv;f=e.length;l=O();BA(V(K(V(K(l,D(263)),c),D(35)),f),41);BB(i,S(l));I(i);},
A$F=(a,b)=>{return a.gA(b,0,b.data.length);},
Bjr=(a,b,c,d)=>{let e,f,g,h,i,j,k,l;if(a.d1())I(D2());if(Bk(a)<d)I(FR());if(c>=0){e=b.data;f=e.length;if(c<=f){g=c+d|0;if(g>f){h=new Bv;i=O();V(K(V(K(i,D(264)),g),D(260)),f);BB(h,S(i));I(h);}if(d<0){i=new Bv;h=O();K(V(K(h,D(261)),d),D(262));BB(i,S(h));I(i);}j=a.vU;k=0;while(k<d){g=j+1|0;l=c+1|0;a.gB(j,e[c]);k=k+1|0;j=g;c=l;}a.vU=a.vU+d|0;return a;}}e=b.data;i=new Bv;f=e.length;h=O();BA(V(K(V(K(h,D(263)),c),D(35)),f),41);BB(i,S(h));I(i);},
ANR=(a,b,c,d)=>{let e,f,g,h,i,j;if(a.d1())I(D2());e=d-c|0;if(Bk(a)<e)I(FR());if(c>=0&&c<=b.bb()){if(d>b.bb()){f=new Bv;g=b.bb();h=O();V(K(V(K(h,D(264)),d),D(265)),g);BB(f,S(h));I(f);}if(c>d){f=new Bv;h=O();V(K(V(K(h,D(266)),c),D(267)),d);BB(f,S(h));I(f);}i=a.vU;while(c<d){j=i+1|0;g=c+1|0;a.gB(i,b.bc(c));i=j;c=g;}a.vU=a.vU+e|0;return a;}f=new Bv;g=b.bb();h=O();BA(V(K(V(K(h,D(266)),c),D(35)),g),41);BB(f,S(h));I(f);},
HH=(a,b)=>{return a.gC(b,0,b.bb());},
Tz=a=>{return a.gD();},
Om=a=>{return a.gE();},
AA5=a=>{GT(a);return a;},
A3s=(a,b)=>{ER(a,b);return a;};
let LN=B(NA);
let Uu=(a,b,c,d)=>{AAC(a,b,c,d);},
Bh6=a=>{return a.d3();};
function MB(){let a=this;LN.call(a);a.Ge=0;a.CX=0;a.Av=null;}
let ACY=(a,b)=>{Qc(a,0,b,Cr(b),0,b,0);},
ANd=a=>{let b=new MB();ACY(b,a);return b;},
Qc=(a,b,c,d,e,f,g)=>{Uu(a,c,e,f);a.CX=b;a.Ge=g;a.Av=d;},
A9M=(a,b,c,d,e,f)=>{let g=new MB();Qc(g,a,b,c,d,e,f);return g;},
A7r=(a,b)=>{return a.Av.data[b+a.CX|0];},
A3k=(a,b,c)=>{a.Av.data[b+a.CX|0]=c;},
A7i=a=>{return 1;},
AWb=a=>{return a.Av;},
Bhv=a=>{return a.Ge;};
let AE2=B();
function AB9(){T.call(this);this.H4=null;}
let QL=(a,b)=>{a.H4=b;Bh(a);},
BhP=a=>{let b=new AB9();QL(b,a);return b;},
Bef=(a,b)=>{return ALh(b);};
function Dn(){let a=this;A.call(a);a.Gb=null;a.IC=Bg;a.HI=Bg;a.xZ=null;a.D6=null;a.He=null;a.z4=0;a.IN=null;}
let Gm=null,FH=null,MK=0,Da=0,Ye=null;
let C1=()=>{C1=N(Dn);ANW();};
let JO=a=>{C1();Jd(a,null,null);},
Blq=()=>{let a=new Dn();JO(a);return a;},
S_=(a,b)=>{C1();Jd(a,null,b);},
A3l=a=>{let b=new Dn();S_(b,a);return b;},
Jd=(a,b,c)=>{let d;C1();L(a);a.xZ=UW();a.z4=1;a.He=c;a.IN=b;d=MK;MK=d+1|0;a.IC=Q(d);},
Bkz=(a,b)=>{let c=new Dn();Jd(c,a,b);return c;},
AK5=a=>{A$b(BhB(a));},
A2L=a=>{let b,c,d,$$je;d:{a:{b:{c:{try{C1();Da=Da+1|0;DW(a);a.s();}catch($$e){$$je=Bb($$e);if($$je instanceof B4){b=$$je;break c;}else{c=$$je;break b;}}c=a.xZ;Eo(c);f:{try{JK(a.xZ);CD(c);break f;}catch($$e){$$je=Bb($$e);d=$$je;}CD(c);I(d);}a.z4=0;Da=Da-1|0;DW(Gm);break d;}try{(a.gL()).gM(a,b);break a;}catch($$e){$$je=Bb($$e);c=$$je;}}d=a.xZ;Eo(d);h:{try{JK(a.xZ);CD(d);break h;}catch($$e){$$je=Bb($$e);c=$$je;}CD(d);I(c);}a.z4=0;Da=Da-1|0;DW(Gm);I(c);}c=a.xZ;Eo(c);e:{try{JK(a.xZ);CD(c);break e;}catch($$e){$$je
=Bb($$e);d=$$je;}CD(c);I(d);}a.z4=0;Da=Da-1|0;DW(Gm);}},
DW=b=>{C1();if(FH!==b)FH=b;FH.HI=OO();},
C2=()=>{C1();return FH;},
LK=b=>{let $p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();b=$T.l();}_:while(true){switch($p){case 0:C1();$p=1;case 1:Bd0(b);if(DM()){break _;}return;default:DB();}}BZ().s(b,$p);},
ATb=(b,c)=>{let d,e,f;C1();d=C2();e=ASH(d,c);f=BkD(b,Q(2147483647))?2147483647:U(b);e.Iq=AEY(e,f);d.D6=e;},
AYi=a=>{if(a.Gb!==null)return a.Gb;C1();return Ye;},
ANW=()=>{Gm=A3l(D(268));FH=Gm;MK=1;Da=1;Ye=Bc$();},
Bd0=b=>{let thread=BZ();let javaThread=AJK();if(thread.isResuming()){thread.status=0;let result=thread.attribute;if(result instanceof Error){throw result;}return result;}let callback=function(){};callback.j=val=>{thread.attribute=val;JZ(javaThread);thread.resume();};callback.u5=e=>{thread.attribute=BcC(e);JZ(javaThread);thread.resume();};callback=Z1(callback);thread.suspend(()=>{try {ATb(b,callback);;}catch(Qf){callback.u5(Qf);}});return null;};
function Rl(){let a=this;Dn.call(a);a.z2=0;a.yc=null;a.yu=null;a.yl=null;}
let AHz=(a,b,c,d,e)=>{a.yl=b;a.z2=c;a.yc=d;a.yu=e;JO(a);},
AM9=(a,b,c,d)=>{let e=new Rl();AHz(e,a,b,c,d);return e;},
A8r=a=>{let b,c,d,e;b=new XMLHttpRequest();c=Bu(BhH(a,b),"handleEvent");b.onreadystatechange=c;P8(a.yl,b,a.yu);d=a.yc;e=a.z2;b.open("GET",Be(d),!!e);b.setRequestHeader("Content-Type","text/plain; charset=utf-8");b.send();};
let FF=B(0);
function Kf(){let a=this;A.call(a);a.yb=null;a.B$=0;a.yL=null;a.zJ=null;a.yT=null;}
let AFw=(a,b,c,d,e,f)=>{a.yT=b;a.yb=c;a.B$=d;a.yL=e;a.zJ=f;L(a);},
Bao=(a,b,c,d,e)=>{let f=new Kf();AFw(f,a,b,c,d,e);return f;},
BhG=(a,b)=>{let c,d,e,f,g,h,i,j,$$je,$p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();j=$T.l();i=$T.l();h=$T.l();g=$T.l();f=$T.l();e=$T.l();d=$T.l();c=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:if(a.yb.readyState==4){a:{if(a.yb.status!=200){if(a.yb.status!=404){c=a.yb;if(c.status!=403){try{d=Q(100);$p=1;continue _;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}a.yT.gT(a.B$,a.yL,a.zJ);break a;}}a.zJ.bj(a.yL);}else{if(a.yT.xM){c=Ci();e=a.yL;f=O();K(K(f,D(269)),e);c.d$(S(f));}g=a.yb.response;h
=Jq();i=h.gV();j=i.createElement("script");c=i.createTextNode(g);j.appendChild(c);i.body.appendChild(j);a.zJ.bl(a.yL,Ba(a.yb.responseText));}}a.yT.bm();}return;case 1:d:{try{LK(d);if(DM()){break _;}break d;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}}a.yT.gT(a.B$,a.yL,a.zJ);a.yT.bm();return;default:DB();}}BZ().s(a,b,c,d,e,f,g,h,i,j,$p);},
A0w=(a,b)=>{let $p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:$p=1;case 1:a.bn(b);if(DM()){break _;}return;default:DB();}}BZ().s(a,b,$p);};
function Rm(){let a=this;Cn.call(a);a.AA=null;a.Ih=null;}
let AGn=(a,b,c)=>{a.Ih=b;a.AA=c;DT(a);},
APV=(a,b)=>{let c=new Rm();AGn(c,a,b);return c;},
AP3=(a,b)=>{a.AA.em(b);},
A5f=(a,b)=>{a.AA.bj(b);},
Bg2=(a,b,c)=>{return a.AA.bl(b,null);},
ANj=(a,b,c)=>{return a.gX(b,c);};
function Rn(){let a=this;Dn.call(a);a.zK=0;a.x3=null;a.yM=null;a.ye=null;}
let XU=(a,b,c,d,e)=>{a.ye=b;a.zK=c;a.x3=d;a.yM=e;JO(a);},
Bap=(a,b,c,d)=>{let e=new Rn();XU(e,a,b,c,d);return e;},
APX=a=>{let b,c,d,e;b=new XMLHttpRequest();c=Bu(AKv(a,b),"handleEvent");b.onreadystatechange=c;P8(a.ye,b,a.yM);d=a.x3;e=a.zK;b.open("GET",Be(d),!!e);if(a.zK){c="arraybuffer";b.responseType=c;}b.send();};
function W$(){T.call(this);this.HF=null;}
let Wh=(a,b)=>{a.HF=b;Bh(a);},
ARJ=a=>{let b=new W$();Wh(b,a);return b;},
A_E=(a,b)=>{return AXf(b);};
function Ro(){let a=this;Cn.call(a);a.y9=null;a.B1=null;a.F_=null;a.z3=null;}
let AHP=(a,b,c,d,e)=>{a.z3=b;a.y9=c;a.B1=d;a.F_=e;DT(a);},
A8w=(a,b,c,d)=>{let e=new Ro();AHP(e,a,b,c,d);return e;},
AWx=(a,b)=>{a.y9.em(b);},
AK_=(a,b)=>{a.y9.bj(b);},
ALf=(a,b,c)=>{let d,e,f,g,h;d=window.document;e=d.createElement("img");if(a.B1!==null){d=a.B1;e.setAttribute("crossOrigin",Be(d));}a.z3.g0();A4a(e,A9d(a,b,c,e));if(!a.z3.Gj){d=Be(b);e.src=d;}else{f=a.F_;g=AD7(c);h=O();K(K(K(K(h,D(270)),f),D(271)),g);h=Be(S(h));e.src=h;}return 0;},
AXy=(a,b,c)=>{return a.gX(b,c);};
function Kh(){let a=this;A.call(a);a.DP=null;a.Iv=null;}
let XY=(a,b,c)=>{a.Iv=b;a.DP=c;L(a);},
AYO=(a,b)=>{let c=new Kh();XY(c,a,b);return c;},
AQz=(a,b)=>{a.DP.em(b.loaded);},
A69=(a,b)=>{a.bn(b);};
let DV=B(CZ);
let ADd=(a,b,c,d)=>{Fj(a,b);a.vU=c;a.v4=d;},
Bgx=(b,c,d)=>{return A1s(0,b.data.length,b,c,c+d|0,0);},
ALg=b=>{return Bgx(b,0,b.data.length);},
A5V=(a,b,c,d)=>{let e,f,g,h,i,j,k;if(a.d1())I(D2());if(Bk(a)<d)I(FR());if(c>=0){e=b.data;f=e.length;if(c<=f){g=c+d|0;if(g>f){h=new Bv;i=O();V(K(V(K(i,D(272)),g),D(260)),f);BB(h,S(i));I(h);}if(d<0){h=new Bv;i=O();K(V(K(i,D(261)),d),D(262));BB(h,S(i));I(h);}j=a.vU;k=0;while(k<d){g=j+1|0;f=c+1|0;a.g6(j,e[c]);k=k+1|0;j=g;c=f;}a.vU=a.vU+d|0;return a;}}e=b.data;h=new Bv;f=e.length;i=O();BA(V(K(V(K(i,D(263)),c),D(35)),f),41);BB(h,S(i));I(h);},
Nf=a=>{FP(a);return a;},
Hm=a=>{GT(a);return a;},
AW4=(a,b)=>{HR(a,b);return a;},
A6z=(a,b)=>{ER(a,b);return a;},
AXE=a=>{return Hm(a);},
Bjg=a=>{return Nf(a);},
A87=(a,b)=>{return a.g$(b);},
BgO=(a,b)=>{return a.g_(b);};
let F3=B(DV);
let M_=(a,b,c,d)=>{ADd(a,b,c,d);},
A0L=(a,b)=>{let c,d,e;if(b>=0&&b<a.v4)return a.ha(b);c=new Bv;d=a.v4;e=O();BA(V(K(V(K(e,D(233)),b),D(35)),d),41);BB(c,S(e));I(c);},
ASm=a=>{return a.d3();};
function F8(){let a=this;F3.call(a);a.wo=null;a.F8=0;a.wq=0;}
let PD=(a,b,c,d,e,f,g)=>{M_(a,c,e,f);a.wq=b;a.wo=d;a.F8=g;},
A8g=a=>{return a.F8;},
A$G=a=>{let b;b=a.wo;return b.hb();};
let Ql=B(0);
function Sv(){let a=this;A.call(a);a.zQ=0;a.FI=0;a.Gj=0;a.xM=0;}
let AEZ=(a,b)=>{L(a);a.FI=0;a.Gj=0;a.xM=1;a.xM=b;},
AYE=a=>{let b=new Sv();AEZ(b,a);return b;},
AJZ=a=>{return a.FI;},
A6$=a=>{let b,c,d;b=Jq();c=b.hc();d=Ba(c.href);return d;},
AZ$=a=>{return a.zQ;},
Bdp=a=>{a.zQ=a.zQ-1|0;},
A4l=a=>{a.zQ=a.zQ+1|0;},
AQK=(a,b,c,d,e,f)=>{let g,h;a:{OV();switch(Eq.data[Bl(d)]){case 1:break;case 2:a.he(b,c,e,f);break a;case 3:a.hf(b,c,f);break a;case 4:a.hg(b,c,f);break a;case 5:f.bl(c,null);break a;default:g=new EU;h=O();K(K(h,D(273)),d);EO(g,S(h));I(g);}a.hh(b,c,f);}},
ALL=(a,b,c,d)=>{let e,f,g;if(a.xM){e=Ci();f=O();K(K(f,D(274)),c);e.d$(S(f));}a.g0();g=AM9(a,b,c,d);g.hj();},
Bji=(a,b,c,d)=>{let e,f;if(a.xM){e=Ci();f=O();K(K(f,D(275)),c);e.d$(S(f));}a.g0();e=new XMLHttpRequest();f=Bu(Bao(a,e,b,c,d),"handleEvent");e.onreadystatechange=f;P8(a,e,d);e.open("GET",Be(c),!!b);e.setRequestHeader("Content-Type","text/plain; charset=utf-8");e.send();},
AXw=(a,b,c,d)=>{a.hf(b,c,APV(a,d));},
ARi=(a,b,c,d)=>{let e,f,g;if(a.xM){e=Ci();f=O();K(K(f,D(274)),c);e.d$(S(f));}a.g0();g=Bap(a,b,c,d);g.hj();},
A5s=(a,b,c,d,e)=>{a.hm(b,c,d,null,e);},
AJk=(a,b,c,d,e,f)=>{a.hf(b,c,A8w(a,f,e,d));},
A4a=(b,c)=>{b.addEventListener("load",Bu(c,"handleEvent"),!!0);b.addEventListener("error",Bu(c,"handleEvent"),!!0);},
P8=(a,b,c)=>{let d;d=Bu(AYO(a,c),"handleEvent");b.onprogress=d;};
let Rp=B();
let Eq=null;
let OV=()=>{OV=N(Rp);A3x();};
let A3x=()=>{Eq=Bp((T3()).data.length);Eq.data[Bl(DS)]=1;Eq.data[Bl(DP)]=2;Eq.data[Bl(DJ)]=3;Eq.data[Bl(Dz)]=4;Eq.data[Bl(GQ)]=5;};
let A5$=B(BC);
let F0=B(BX);
let A$z=B(F0);
let Ys=B(Fx);
let Zs=(a,b)=>{HP(a,b);},
A5u=a=>{let b=new Ys();Zs(b,a);return b;};
let CL=B(0);
function Fb(){let a=this;A.call(a);a.wn=null;a.v2=0;a.If=0;a.Bu=null;}
let Tp=a=>{Hw(a,1,16);},
Dx=()=>{let a=new Fb();Tp(a);return a;},
PK=(a,b)=>{Hw(a,1,b);},
ADh=a=>{let b=new Fb();PK(b,a);return b;},
Hw=(a,b,c)=>{L(a);a.If=b;a.wn=Bt(A,c);},
AQc=(a,b)=>{let c=new Fb();Hw(c,a,b);return c;},
A_J=(a,b)=>{let c,d,e;c=a.wn;d=c.data;if(a.v2==d.length)c=a.hp(BT(8,a.v2*1.75|0));d=c.data;e=a.v2;a.v2=e+1|0;d[e]=b;},
AYy=(a,b)=>{a.hq(b.wn,0,b.v2);},
AO7=(a,b,c,d)=>{let e,f,g;e=a.wn;f=e.data;g=a.v2+d|0;if(g>f.length)e=a.hp(BT(BT(8,g),a.v2*1.75|0));C5(b,c,e,a.v2,d);a.v2=g;},
Bf3=(a,b)=>{if(b<a.v2)return a.wn.data[b];I(GF((((((O()).O(D(276))).P(b)).O(D(277))).P(a.v2)).y()));},
AUt=a=>{AP$(a.wn,0,a.v2,null);a.v2=0;},
AS3=(a,b)=>{let c,d,e;c=a.wn;d=AAn((Do(c)).eB(),b);e=d.data;C5(c,0,d,0,B7(a.v2,e.length));a.wn=d;return d;},
AZN=a=>{if(Rr)return Iu(a,1);if(a.Bu===null)a.Bu=Bi9(a);return a.Bu.hv();},
ALA=a=>{return a.hw((Do(a.wn)).eB());},
AOW=(a,b)=>{let c;c=AAn(b,a.v2);C5(a.wn,0,c,0,a.v2);return c;};
function No(){Cj.call(this);this.Ds=0;}
let PY=(a,b)=>{Ed(a,b);},
BlM=a=>{let b=new No();PY(b,a);return b;},
AL2=(a,b,c,d)=>{let e;e=a.bR();d.c7(e,b-d.bS(e)|0);a.Ds=b;return b;},
APx=a=>{return a.Ds;},
A8G=(a,b)=>{return 0;};
let Kx=B(0);
function Iw(){BD.call(this);this.yR=0;}
let TE=(a,b)=>{Cu(a);a.yR=b;},
ABX=a=>{let b=new Iw();TE(b,a);return b;},
A8e=(a,b)=>{a.vN=b;},
AQT=(a,b,c,d)=>{let e,f,g;e=b+1|0;if(e>d.bq()){d.wZ=1;return (-1);}f=c.bc(b);if(b>d.b5()){g=c.bc(b-1|0);if(Cs(g))return (-1);}if(a.yR!=f)return (-1);return a.vN.br(e,c,d);},
AX_=(a,b,c,d)=>{let e,f,g,h,i;if(!(c instanceof BG))return FY(a,b,c,d);e=c;f=d.b5();g=d.bq();while(true){if(b>=g)return (-1);h=e.e3(a.yR,b);if(h<0)return (-1);if(h>f&&Cs(e.bc(h-1|0))){b=h+1|0;continue;}i=a.vN;b=h+1|0;if(i.br(b,c,d)>=0)break;}return h;},
ASP=(a,b,c,d,e)=>{let f,g,h;if(!(d instanceof BG))return F$(a,b,c,d,e);f=e.b5();g=d;a:{while(true){if(c<b)return (-1);h=g.e4(a.yR,c);if(h<0)break a;if(h<b)break a;if(h>f&&Cs(g.bc(h-1|0))){c=h+(-2)|0;continue;}if(a.vN.br(h+1|0,d,e)>=0)break;c=h+(-1)|0;}return h;}return (-1);},
ALq=(a,b)=>{if(b instanceof Dr)return 0;if(b instanceof Di)return 0;if(b instanceof CP)return 0;if(b instanceof Df)return 0;if(b instanceof IS)return 0;if(!(b instanceof Iw))return 1;return b.yR!=a.yR?0:1;},
BcX=(a,b)=>{return 1;};
let AG4=B(C7);
let U0=(a,b,c)=>{Oj(a,b,c);},
AUX=(a,b)=>{let c=new AG4();U0(c,a,b);return c;};
let ADU=B();
let EI=null;
let AFv=()=>{AFv=N(ADU);AS1();};
let AS1=()=>{let b;EI=Cq(16384);b=0;while(b<16384){EI.data[b]=BcL((b+0.5)/16384.0*6.2831854820251465);b=b+1|0;}EI.data[0]=0.0;EI.data[4096]=1.0;EI.data[8192]=0.0;EI.data[12288]=(-1.0);};
let Uw=B(0);
function D6(){Cv.call(this);this.yo=null;}
let Im=(a,b,c,d,e)=>{Em(a,c,d,e);a.yo=b;},
ATR=(a,b,c,d)=>{let e=new D6();Im(e,a,b,c,d);return e;},
ANx=(a,b,c,d)=>{let e,f,g,h;e=a.yo.hy();f=a.yo.hz();g=0;while(true){if(g>=e){f:{while(g<f){if((b+a.v9.bw()|0)>d.bq())break f;h=a.v9.bx(b,c);if(h<1)break f;b=b+h|0;g=g+1|0;}}while(true){if(g<e)return (-1);h=a.vN.br(b,c,d);if(h>=0)break;b=b-a.v9.bw()|0;g=g+(-1)|0;}return h;}if((b+a.v9.bw()|0)>d.bq()){d.wZ=1;return (-1);}h=a.v9.bx(b,c);if(h<1)break;b=b+h|0;g=g+1|0;}return (-1);};
function CP(){let a=this;BD.call(a);a.xk=null;a.HG=0;}
let Og=(a,b)=>{Cu(a);a.xk=b.b4();a.HG=b.wa;},
Zb=a=>{let b=new CP();Og(b,a);return b;},
AT6=(a,b,c,d)=>{let e,f,g,h,i,j;e=d.bq();if(b<e){f=b+1|0;g=c.bc(b);if(a.b6(g)){h=a.vN.br(f,c,d);if(h>0)return h;}if(f<e){i=f+1|0;j=c.bc(f);if(G_(g,j)&&a.b6(Ev(g,j)))return a.vN.br(i,c,d);}}return (-1);},
AVZ=(a,b)=>{return a.xk.b6(b);},
AMZ=(a,b)=>{if(b instanceof Df)return Mg(a.xk,b.hC());if(b instanceof Dr)return Mg(a.xk,b.e5());if(b instanceof CP)return IQ(a.xk,b.xk);if(!(b instanceof Di))return 1;return IQ(a.xk,b.hE());},
A1b=a=>{return a.xk;},
BbS=(a,b)=>{a.vN=b;},
AUM=(a,b)=>{return 1;};
let Ei=B();
let AQ0=B(Ei);
function BG(){A.call(this);this.z1=0;}
let BfC=null,AAZ=null,AKc=null;
let C8=()=>{C8=N(BG);Bd9();};
let Rc=a=>{C8();L(a);a.wc="";},
AXM=()=>{let a=new BG();Rc(a);return a;},
Kt=(a,b)=>{let c;C8();c=b.data;L(a);a.wc=AMR(b.data,0,c.length);},
J2=a=>{let b=new BG();Kt(b,a);return b;},
WQ=(a,b)=>{a.wc=b;},
ACT=a=>{let b=new BG();WQ(b,a);return b;},
AIP=(a,b,c,d)=>{let e;C8();e=b.data;L(a);AIe(c,d,e.length);a.wc=AMR(b.data,c,d);},
Lg=(a,b,c)=>{let d=new BG();AIP(d,a,b,c);return d;},
SC=(a,b,c,d)=>{C8();L(a);F7();A$f(a,b,c,d,Qa);},
BjZ=(a,b,c)=>{let d=new BG();SC(d,a,b,c);return d;},
A$f=(a,b,c,d,e)=>{let f,g;f=AAR(e,Yg(b,c,d));if(Tz(f)&&!BY(f)&&BI(f)==DL(f))g=Om(f);else{g=Cr(Bk(f));f.hM(g);}a.wc=Bkq(g.data);},
ANq=(a,b)=>{if(b>=0&&b<a.wc.length)return a.wc.charCodeAt(b);I(FT());},
AWe=a=>{return a.wc.length;},
A0Y=a=>{return a.wc.length?0:1;},
A9l=(a,b,c)=>{let d,e,f;if((c+b.bb()|0)>a.bb())return 0;d=0;while(d<b.bb()){e=b.bc(d);f=c+1|0;if(e!=a.bc(c))return 0;d=d+1|0;c=f;}return 1;},
A1a=(a,b)=>{if(a===b)return 1;return a.hN(b,0);},
A6P=(a,b,c)=>{let d,e,f,g;d=BT(0,c);if(b<65536){e=b&65535;while(true){if(d>=a.wc.length)return (-1);if(a.wc.charCodeAt(d)==e)break;d=d+1|0;}return d;}f=Iq(b);g=Jx(b);while(true){if(d>=(a.wc.length-1|0))return (-1);if(a.wc.charCodeAt(d)==f&&a.wc.charCodeAt((d+1|0))==g)break;d=d+1|0;}return d;},
AT3=(a,b)=>{return a.e3(b,0);},
ANG=(a,b,c)=>{let d,e,f,g,h;d=B7(c,a.bb()-1|0);if(b<65536){e=b&65535;while(true){if(d<0)return (-1);if(a.wc.charCodeAt(d)==e)break;d=d+(-1)|0;}return d;}f=Iq(b);g=Jx(b);while(true){if(d<1)return (-1);if(a.wc.charCodeAt(d)==g){h=d-1|0;if(a.wc.charCodeAt(h)==f)break;}d=d+(-1)|0;}return h;},
AZA=(a,b)=>{return a.e4(b,a.bb()-1|0);},
ATg=(a,b,c)=>{let d,e,f;d=BT(0,c);e=a.bb()-b.bb()|0;a:while(true){if(d>e)return (-1);f=0;while(true){if(f>=b.bb())break a;if(a.bc(d+f|0)!=b.bc(f))break;f=f+1|0;}d=d+1|0;}return d;},
ATN=(a,b,c)=>{let d,e;d=B7(c,a.bb()-b.bb()|0);a:while(true){if(d<0)return (-1);e=0;while(true){if(e>=b.bb())break a;if(a.bc(d+e|0)!=b.bc(e))break;e=e+1|0;}d=d+(-1)|0;}return d;},
AK0=(a,b,c)=>{let d,e;d=a.wc.length;e=CA(b,c);if(!e)return AAZ;if(!b&&c==d)return a;if(b>=0&&e<=0&&c<=d)return ACT(a.wc.substring(b,c));I(FT());},
AZF=(a,b)=>{return a.hQ(b,a.bb());},
AUn=(a,b,c)=>{return a.hQ(b,c);},
AI5=(a,b)=>{let c,d,e;c=a.bb()-b.bb()|0;d=0;while(d<=c){e=0;while(true){if(e>=b.bb())return 1;if(a.bc(d+e|0)!=b.bc(e))break;e=e+1|0;}d=d+1|0;}return 0;},
A_h=(a,b,c)=>{let d,e,f,g;d=O();e=a.bb()-b.bb()|0;f=0;while(f<=e){g=0;a:{while(true){if(g>=b.bb()){d.x(c);f=f+(b.bb()-1|0)|0;break a;}if(a.bc(f+g|0)!=b.bc(g))break;g=g+1|0;}d.cF(a.bc(f));}f=f+1|0;}d.x(a.eG(f));return d.y();},
A1U=a=>{let b,c;b=0;c=a.bb()-1|0;d:{while(b<=c){if(a.bc(b)>32)break d;b=b+1|0;}}while(b<=c&&a.bc(c)<=32){c=c+(-1)|0;}return a.hQ(b,c+1|0);},
APD=a=>{return a;},
A09=a=>{let b,c,d;b=Cr(a.wc.length);c=0;while(true){d=b.data;if(c>=d.length)break;d[c]=a.bc(c);c=c+1|0;}return b;},
A6e=b=>{C8();return !b?D(32):D(33);},
IP=b=>{C8();return ((O()).P(b)).y();},
AWt=b=>{C8();return ((O()).hR(b)).y();},
AUg=b=>{C8();return ((O()).hS(b)).y();},
Be9=(a,b)=>{let c;if(a===b)return 1;if(!(b instanceof BG))return 0;c=b;return a.wc!==c.wc?0:1;},
A7b=a=>{let b;d:{if(!a.z1){b=0;while(true){if(b>=a.wc.length)break d;a.z1=(31*a.z1|0)+a.wc.charCodeAt(b)|0;b=b+1|0;}}}return a.z1;},
ARW=a=>{let b;b=a.wc.toLowerCase();if(b!==a.wc)a=ACT(b);return a;},
A2z=(a,b)=>{return RV(UO(b),a.y());},
Bd9=()=>{BfC=Cr(0);AAZ=AXM();AKc=A0i();};
let Q6=B();
let AWd=0,AWn=0,AMp=0,BiI=0,ASQ=0;
let AA2=()=>{AA2=N(Q6);A0l();};
let A0l=()=>{let b;AWd=Ba(navigator.platform).bh(D(15));AWn=Ba(navigator.platform).bh(D(16));AMp=Ba(navigator.platform).bh(D(17));BiI=!Ba(navigator.platform).bh(D(18))&&!Ba(navigator.platform).bh(D(19))?0:1;b=!Ba(navigator.platform).bh(D(20))&&!Ba(navigator.platform).bh(D(21))&&!Ba(navigator.platform).bh(D(22))?0:1;ASQ=b;};
let ATQ=B();
let FG=b=>{if(!BcJ(b,E3))return null;return b.hb();};
function WP(){let a=this;Gd.call(a);a.F6=0;a.CC=0;a.BD=null;}
let Xn=(a,b,c,d,e,f,g)=>{Lp(a,c,e,f);a.CC=b;a.F6=g;a.BD=d;},
A7C=(a,b,c,d,e,f)=>{let g=new WP();Xn(g,a,b,c,d,e,f);return g;},
A64=(a,b)=>{return a.BD.data[b+a.CC|0];},
A3y=(a,b,c)=>{a.BD.data[b+a.CC|0]=c;},
AJq=a=>{return a.F6;};
let G1=B(Bz);
let HE=null,Hf=null,HY=null,Ly=null,OL=null,Mo=null,L$=null,K3=null,Ng=null,Pa=null,Uq=null;
let IB=()=>{IB=N(G1);AQx();};
let Sa=()=>{IB();return Uq.b$();},
A5c=(a,b,c)=>{IB();Ce(a,b,c);},
C$=(a,b)=>{let c=new G1();A5c(c,a,b);return c;},
AQx=()=>{HE=C$(D(278),0);Hf=C$(D(279),1);HY=C$(D(280),2);Ly=C$(D(281),3);OL=C$(D(282),4);Mo=C$(D(283),5);L$=C$(D(284),6);K3=C$(D(285),7);Ng=C$(D(286),8);Pa=C$(D(287),9);Uq=H(G1,[HE,Hf,HY,Ly,OL,Mo,L$,K3,Ng,Pa]);};
let MA=B();
let VE=a=>{L(a);};
let Nr=B(0);
function Ft(){let a=this;MA.call(a);a.Br=0;a.wU=null;a.EU=0.0;a.DH=0;a.zW=0;a.zr=0;a.Gh=0;}
let Bjx=null,AVV=null;
let GH=()=>{GH=N(Ft);Bh_();};
let Bbn=(b,c,d)=>{GH();return A8$(b,c);},
H$=a=>{GH();K9(a,11);},
Blg=()=>{let a=new Ft();H$(a);return a;},
K9=(a,b)=>{GH();VE(a);a.zr=(-1);if(b<0)I(CF());a.Br=0;if(!b)b=1;a.wU=AIL(a,b);a.zW=a.wU.data.length;a.EU=0.75;Sc(a);},
BkM=a=>{let b=new Ft();K9(b,a);return b;},
AIL=(a,b)=>{return Bt(LG,b);},
Sc=a=>{a.DH=a.wU.data.length*a.EU|0;},
A9h=(a,b,c)=>{let d,e,f,g,h,i,j;Eo(a);try{if(b!==null&&c!==null){d=b.hY();e=d&2147483647;f=e%a.wU.data.length|0;g=a.wU.data[f];while(g!==null&&!g.hZ(b,d)){g=g.AN;}if(g!==null){h=g.yH;g.yH=c;return h;}a.Gh=a.Gh+1|0;i=a.Br+1|0;a.Br=i;if(i>a.DH){a.h0();f=e%a.wU.data.length|0;}if(f<a.zW)a.zW=f;if(f>a.zr)a.zr=f;j=Bbn(b,c,d);j.AN=a.wU.data[f];a.wU.data[f]=j;return null;}I(S8());}finally{CD(a);}},
A30=a=>{let b,c,d,e,f,g,h,i,j;b=(a.wU.data.length<<1)+1|0;if(!b)b=1;c=(-1);d=AIL(a,b);e=a.zr+1|0;f=b;while(true){e=e+(-1)|0;if(e<a.zW)break;g=a.wU.data[e];while(g!==null){h=(g.h2()&2147483647)%b|0;if(h<f)f=h;if(h>c)c=h;i=d.data;j=g.AN;g.AN=i[h];i[h]=g;g=j;}}a.zW=f;a.zr=c;a.wU=d;Sc(a);},
Bh_=()=>{Bjx=A$h();AVV=A0I();};
function Oq(){Ft.call(this);this.HZ=null;}
let ACu=a=>{H$(a);},
A2v=()=>{let a=new Oq();ACu(a);return a;},
Yc=(a,b)=>{H$(a);a.HZ=b;},
A21=a=>{let b=new Oq();Yc(b,a);return b;};
function AGa(){let a=this;F3.call(a);a.EG=0;a.C2=0;a.B6=null;}
let Ub=(a,b,c,d,e,f,g)=>{M_(a,c,e,f);a.C2=b;a.EG=g;a.B6=d;},
A1s=(a,b,c,d,e,f)=>{let g=new AGa();Ub(g,a,b,c,d,e,f);return g;},
A9r=(a,b)=>{return a.B6.data[b+a.C2|0];},
A7o=(a,b,c)=>{a.B6.data[b+a.C2|0]=c;},
A7Z=a=>{return a.EG;};
let A4h=B();
let AXk=B();
let Ds=B(B0);
let A7j=B(Ds);
function E$(){let a=this;Bd.call(a);a.IH=0.0;a.GP=0.0;a.GT=0.0;a.Ho=0.0;}
let Ih=(a,b,c,d,e)=>{BN(a);a.IH=b;a.GP=c;a.GT=e;a.Ho=d*3.1415927410125732*(d%2|0?(-1):1);},
A_0=(a,b,c,d)=>{let e=new E$();Ih(e,a,b,c,d);return e;};
let XG=B(E$);
let Ur=(a,b,c,d,e)=>{Ih(a,b,c,d,e);},
A8m=(a,b,c,d)=>{let e=new XG();Ur(e,a,b,c,d);return e;};
let H5=B(Bz);
let WZ=null,Sj=null,ACB=null,Q8=null,S4=null,A_d=null;
let Pj=()=>{Pj=N(H5);A81();};
let A_q=(a,b,c)=>{Pj();Ce(a,b,c);},
Gc=(a,b)=>{let c=new H5();A_q(c,a,b);return c;},
A81=()=>{WZ=Gc(D(288),0);Sj=Gc(D(193),1);ACB=Gc(D(289),2);Q8=Gc(D(290),3);S4=Gc(D(291),4);A_d=H(H5,[WZ,Sj,ACB,Q8,S4]);};
let Gi=B(0);
function Ss(){let a=this;A.call(a);a.Dn=null;a.Dm=null;a.Dl=null;a.Dk=null;a.z8=null;}
let ABB=a=>{L(a);a.Dn=Fr(1);a.Dm=Fr(2);a.Dl=Fr(3);a.Dk=Fr(4);a.z8=TA();},
AMv=()=>{let a=new Ss();ABB(a);return a;},
BiU=a=>{let b,c,d;A_C(D(292),a.Dn);ATv(D(293),a.Dm);Bfc(D(294),a.Dl);AKn(D(295),a.Dk,0.009999999776482582,(-2.0),2.0);if(WN(D(296),a.z8,a.z8.h8())){b=a.z8.h9();c=Ci();d=O();K(K(d,D(297)),b);c.d$(S(d));}},
ATw=a=>{return D(298);};
let P9=B(Ku);
let Qa=null;
let F7=()=>{F7=N(P9);AUa();};
let Bgz=a=>{F7();T9(a,D(299),Bt(BG,0));},
BfP=()=>{let a=new P9();Bgz(a);return a;},
BaJ=a=>{return A$N(a);},
AUa=()=>{Qa=BfP();};
let DR=B(0);
let XQ=B(0);
let IV=B();
let A9w=null,A90=null;
let US=()=>{US=N(IV);AVQ();};
let AVQ=()=>{A9w=BF();A90=BF();};
function QM(){Bw.call(this);this.yp=0;}
let AIH=(a,b)=>{Cd(a);a.yp=b;},
AK9=a=>{let b=new QM();AIH(b,a);return b;},
AZE=(a,b,c,d)=>{let e,f,g;e=!d.ia()?c.bb()-b|0:d.bq()-b|0;if(!e){d.c7(a.yp,0);return a.vN.br(b,c,d);}if(e<2){f=c.bc(b);g=97;}else{f=c.bc(b);g=c.bc(b+1|0);}switch(f){case 10:case 133:case 8232:case 8233:d.c7(a.yp,0);return a.vN.br(b,c,d);case 13:if(g!=10){d.c7(a.yp,0);return a.vN.br(b,c,d);}d.c7(a.yp,0);return a.vN.br(b,c,d);default:}return (-1);},
AQ2=(a,b)=>{let c;c=!b.bS(a.yp)?0:1;b.c7(a.yp,(-1));return c;};
let J4=B(0);
let A6Y=B(DA);
let HA=B(D1);
let BiC=B(0);
let BeF=b=>{let c;c=(Bby(b)).ic();if(AOY(c)){CM();return DP;}if(A2B(c)){CM();return Dz;}if(!AZg(c)){CM();return DJ;}CM();return DS;},
Bby=b=>{let c;c=b.eF(46);if(c==(-1))return D(37);return b.eG(c+1|0);},
AOY=b=>{return !b.bi(D(300))&&!b.bi(D(301))&&!b.bi(D(302))&&!b.bi(D(303))&&!b.bi(D(304))?0:1;},
AZg=b=>{let c;d:{b:{if(b.bi(D(305)))break b;if(b.bi(D(306)))break b;if(b.bi(D(307)))break b;if(b.bi(D(308)))break b;if(b.bi(D(309)))break b;if(b.bi(D(310)))break b;if(b.bi(D(311)))break b;if(b.bi(D(312)))break b;if(!b.bi(D(313))){c=0;break d;}}c=1;}return c;},
A2B=b=>{return !b.bi(D(314))&&!b.bi(D(315))&&!b.bi(D(316))?0:1;};
let A2W=B();
let AL8=B(Ct);
function Up(){let a=this;A.call(a);a.wW=null;a.AI=null;a.wt=null;a.wB=0;}
let AID=a=>{L(a);a.wt=C2();},
A0E=()=>{let a=new Up();AID(a);return a;};
function T$(){let a=this;A.call(a);a.xq=null;a.xh=null;a.wS=null;a.Dq=0;a.DG=0;a.GG=0;a.Bw=0;a.zv=0;a.Ad=0;}
let AAX=(a,b,c,d)=>{L(a);a.zv=0;a.Ad=0;a.GG=b;a.xq=d;a.wS=Ut(CW(a.xq.w6,c));a.DG=1;a.Bw=!b?35048:35044;a.xh=a.wS.ii();a.Dq=Bhr(a);a.xh.gF();a.wS.gF();},
Bfw=(a,b,c)=>{let d=new T$();AAX(d,a,b,c);return d;},
Bhr=a=>{let b;b=Y.fK();Y.gp(34962,b);Y.f6(34962,DL(a.wS),null,a.Bw);Y.gp(34962,0);return b;},
A6o=a=>{if(a.Ad){Y.ik(34962,0,BI(a.wS),a.wS);a.zv=0;}},
AOr=(a,b,c,d)=>{a.zv=1;if(a.DG){Pg(b,a.wS,d,c);a.xh.dX(0);a.xh.g7(d);}else{a.xh.dW();a.xh.im(b,c,d);a.xh.gF();a.wS.dX(0);a.wS.g7(BI(a.xh)<<2);}A6o(a);},
A5_=(a,b,c)=>{let d,e,f,g,h,i;d=Y;d.gp(34962,a.Dq);if(a.zv){a.wS.g7(BI(a.xh)*4|0);d.f6(34962,BI(a.wS),a.wS,a.Bw);a.zv=0;}a:{e=De(a.xq);if(c!==null){f=0;while(true){if(f>=e)break a;g=c.data;h=CQ(a.xq,f);i=g[f];if(i>=0){b.gs(i);b.gt(i,h.xd,h.xC,h.xU,a.xq.w6,h.x$);}f=f+1|0;}}f=0;while(f<e){h=CQ(a.xq,f);i=b.gr(h.xs);if(i>=0){b.gs(i);b.gt(i,h.xd,h.xC,h.xU,a.xq.w6,h.x$);}f=f+1|0;}}a.Ad=1;},
AUQ=(a,b,c)=>{let d,e,f,g;d:{d=Y;e=De(a.xq);if(c===null){f=0;while(f<e){b.gu((CQ(a.xq,f)).xs);f=f+1|0;}}else{f=0;while(true){if(f>=e)break d;g=c.data[f];if(g>=0)b.ip(g);f=f+1|0;}}}d.gp(34962,0);a.Ad=0;};
let A4U=B();
let FC=B();
let BbY=B();
function Uj(){Cb.call(this);this.Dh=null;}
let AHt=(a,b,c,d)=>{Qk(a,c,d);a.Dh=ARZ(a,b);if(a.Dh!==null)return;I(ARL((((O()).O(D(317))).O(b.T())).y()));},
Bhw=(a,b,c)=>{let d=new Uj();AHt(d,a,b,c);return d;},
ARZ=(a,b)=>{let c,d,$$je;d:{try{c=A6f(b,null);}catch($$e){$$je=Bb($$e);if($$je instanceof B8){break d;}else{throw $$e;}}return c;}a:{try{d=ATK(b,null);ADI(d,1);}catch($$e){$$je=Bb($$e);if($$je instanceof D8){break a;}else{throw $$e;}}return d;}return null;};
let AFe=B();
let ASO=null,AMc=null,Bie=null;
let AGw=()=>{AGw=N(AFe);Bad();};
let Bad=()=>{ASO=Dx();AMc=X();Bie=Qi();};
let XT=B();
let AKo=null;
let ABb=()=>{ABb=N(XT);A1o();};
let A1o=()=>{AKo=A3f();};
let A_w=B();
let ZM=b=>{i:{switch(b){case 8:break;case 9:return 61;case 10:case 11:case 12:case 14:case 15:case 21:case 22:case 23:case 24:case 25:case 26:case 28:case 29:case 30:case 31:case 41:case 42:case 43:case 44:case 47:case 58:case 59:case 60:case 61:case 62:case 63:case 64:case 93:case 94:case 95:case 108:case 124:case 125:case 126:case 127:case 128:case 129:case 130:case 131:case 132:case 133:case 134:case 135:case 136:case 137:case 138:case 139:case 140:case 141:case 142:case 143:case 146:case 147:case 148:case 149:case 150:case 151:case 152:case 153:case 154:case 155:case 156:case 157:case 158:case 159:case 160:case 161:case 162:case 163:case 164:case 165:case 166:case 167:case 168:case 169:case 170:case 171:case 172:case 173:case 174:case 175:case 176:case 177:case 178:case 179:case 180:case 181:case 182:case 183:case 184:case 185:case 193:case 194:case 195:case 196:case 197:case 198:case 199:case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 207:case 208:case 209:case 210:case 211:case 212:case 213:case 214:case 215:case 216:case 217:case 218:break i;case 13:return 66;case 16:return 59;case 17:return 129;case 18:return 57;case 19:return 0;case 20:return 0;case 27:return 111;case 32:return 62;case 33:return 92;case 34:return 93;case 35:return 123;case 36:return 3;case 37:return 21;case 38:return 19;case 39:return 22;case 40:return 20;case 45:return 124;case 46:return 112;case 48:return 7;case 49:return 8;case 50:return 9;case 51:return 10;case 52:return 11;case 53:return 12;case 54:return 13;case 55:return 14;case 56:return 15;case 57:return 16;case 65:return 29;case 66:return 30;case 67:return 31;case 68:return 32;case 69:return 33;case 70:return 34;case 71:return 35;case 72:return 36;case 73:return 37;case 74:return 38;case 75:return 39;case 76:return 40;case 77:return 41;case 78:return 42;case 79:return 43;case 80:return 44;case 81:return 45;case 82:return 46;case 83:return 47;case 84:return 48;case 85:return 49;case 86:return 50;case 87:return 51;case 88:return 52;case 89:return 53;case 90:return 54;case 91:return 0;case 92:return 0;case 96:return 144;case 97:return 145;case 98:return 146;case 99:return 147;case 100:return 148;case 101:return 149;case 102:return 150;case 103:return 151;case 104:return 152;case 105:return 153;case 106:return 0;case 107:return 81;case 109:return 69;case 110:return 56;case 111:return 0;case 112:return 131;case 113:return 132;case 114:return 133;case 115:return 134;case 116:return 135;case 117:return 136;case 118:return 137;case 119:return 138;case 120:return 139;case 121:return 140;case 122:return 141;case 123:return 142;case 144:return 78;case 145:return 0;case 186:return 74;case 187:return 70;case 188:return 55;case 189:return 69;case 190:return 56;case 191:return 76;case 192:return 0;case 219:return 71;case 220:return 73;case 221:return 72;case 222:return 75;default:break i;}return 67;}return 0;},
Jl=b=>{if(!b)return 0;if(b==2)return 1;if(b!=1)return 0;return 2;};
let BP=B(Bz);
let Hs=null,ABW=null,UF=null,UE=null,TW=null,TB=null,SY=null,Ux=null,SG=null,A1t=null;
let Ht=()=>{Ht=N(BP);ALQ();};
let Dk=(a,b,c)=>{Ht();Ce(a,b,c);},
ALQ=()=>{Hs=A6v(D(318),0);ABW=A2o(D(319),1);UF=Bal(D(320),2);UE=Bah(D(321),3);TW=ALF(D(322),4);TB=BjB(D(323),5);SY=AZj(D(324),6);Ux=ARb(D(325),7);SG=Bdj(D(326),8);A1t=H(BP,[Hs,ABW,UF,UE,TW,TB,SY,Ux,SG]);};
let AFk=B(BP);
let AZb=(a,b,c)=>{Dk(a,b,c);},
ARb=(a,b)=>{let c=new AFk();AZb(c,a,b);return c;};
let Ir=B(0);
let AFi=B(BP);
let Bba=(a,b,c)=>{Dk(a,b,c);},
Bdj=(a,b)=>{let c=new AFi();Bba(c,a,b);return c;};
let Hj=B(0);
let Zz=B(0);
let Q7=B(0);
let AFp=B(BP);
let AXQ=(a,b,c)=>{Dk(a,b,c);},
BjB=(a,b)=>{let c=new AFp();AXQ(c,a,b);return c;};
let AFj=B(BP);
let BjE=(a,b,c)=>{Dk(a,b,c);},
AZj=(a,b)=>{let c=new AFj();BjE(c,a,b);return c;};
let XA=B();
let AQZ=0,A_S=0,Bi5=0,NP=0,AUN=0,A0V=0,A1c=0;
let Il=()=>{Il=N(XA);Bfy();};
let Bfy=()=>{AQZ=imgui.ImGuiDockNodeFlags_None;A_S=imgui.ImGuiDockNodeFlags_KeepAliveOnly;Bi5=imgui.ImGuiDockNodeFlags_NoDockingInCentralNode;NP=imgui.ImGuiDockNodeFlags_PassthruCentralNode;AUN=imgui.ImGuiDockNodeFlags_NoSplit;A0V=imgui.ImGuiDockNodeFlags_NoResize;A1c=imgui.ImGuiDockNodeFlags_AutoHideTabBar;};
let H4=B(Bz);
let UT=null,W3=null,AET=null,A5l=null;
let OH=()=>{OH=N(H4);Bfz();};
let AMI=(a,b,c)=>{OH();Ce(a,b,c);},
KM=(a,b)=>{let c=new H4();AMI(c,a,b);return c;},
Bfz=()=>{UT=KM(D(327),0);W3=KM(D(328),1);AET=KM(D(329),2);A5l=H(H4,[UT,W3,AET]);};
let AFl=B(BP);
let AJJ=(a,b,c)=>{Dk(a,b,c);},
A6v=(a,b)=>{let c=new AFl();AJJ(c,a,b);return c;},
Bf_=a=>{return D(330);};
let AFs=B(BP);
let ANb=(a,b,c)=>{Dk(a,b,c);},
Bah=(a,b)=>{let c=new AFs();ANb(c,a,b);return c;};
let AFo=B(BP);
let A_M=(a,b,c)=>{Dk(a,b,c);},
ALF=(a,b)=>{let c=new AFo();A_M(c,a,b);return c;};
let AFm=B(BP);
let BdL=(a,b,c)=>{Dk(a,b,c);},
A2o=(a,b)=>{let c=new AFm();BdL(c,a,b);return c;};
let AFr=B(BP);
let A1Q=(a,b,c)=>{Dk(a,b,c);},
Bal=(a,b)=>{let c=new AFr();A1Q(c,a,b);return c;};
let WD=B();
let ACE=0,ZW=0;
let GY=()=>{GY=N(WD);AYq();};
let HO=()=>{GY();return ACE;},
F5=()=>{GY();return ZW;},
A5U=b=>{GY();ZW=b;},
AYq=()=>{ACE=1;};
function LT(){let a=this;A.call(a);a.C8=0;a.Cw=0;a.CJ=0;a.GC=null;a.Hu=null;a.xf=null;a.Gq=D(331);}
let MZ=(a,b,c,d,e)=>{let f;L(a);a.Gq=D(331);D3();if(b===PX){C4();a.xf=GB;}else if(b===Oz){C4();a.xf=GB;}else if(b===OJ){C4();a.xf=GK;}else if(b===Oc){C4();a.xf=GK;}else if(b!==ET){C4();a.xf=M$;}else{C4();a.xf=H3;}f=a.xf;C4();if(f===GB)Mk(a,D(332),c);else if(a.xf===H3)Mk(a,D(333),c);else if(a.xf===GK)Mk(a,D(334),c);else{a.C8=(-1);a.Cw=(-1);a.CJ=(-1);d=D(37);e=D(37);}a.GC=d;a.Hu=e;},
Blo=(a,b,c,d)=>{let e=new LT();MZ(e,a,b,c,d);return e;},
Mk=(a,b,c)=>{let d,e,f,g,h,i,j;d=UO(b);e=Mm(d,c);f=Ml(e);if(!f){C6.fr(D(331),(((O()).O(D(335))).O(c)).y());a.C8=2;a.Cw=0;a.CJ=0;}else{g=ABc(e,1);h=g.d_(D(336));i=h.data;a.C8=LX(a,i[0],2);j=i.length;a.Cw=j<2?0:LX(a,i[1],0);a.CJ=j<3?0:LX(a,i[2],0);}},
LX=(a,b,c)=>{let d,$$je;d:{try{d=ASv(b);}catch($$e){$$je=Bb($$e);if($$je instanceof B$){break d;}else{throw $$e;}}return d;}C6.e_(D(337),(((((O()).O(D(338))).O(b)).O(D(339))).P(c)).y());return c;};
let Xe=B(Bi);
let Wv=a=>{B9(a);},
FR=()=>{let a=new Xe();Wv(a);return a;};
let Gs=B();
let Pz=a=>{L(a);},
AT$=(a,b)=>{let c,d,e,f;c=b.data;d=a.bV();e=c.length;if(e<d)b=On((Do(b)).eB(),d);else while(d<e){c[d]=null;d=d+1|0;}d=0;f=a.bY();while(f.bZ()){c=b.data;e=d+1|0;c[d]=f.b0();d=e;}return b;};
let T_=B(0);
let LU=B(Gs);
let ADz=a=>{Pz(a);};
let FW=B(CZ);
let SF=(a,b,c,d)=>{Fj(a,b);a.vU=c;a.v4=d;},
AVl=(b,c,d)=>{return A7$(0,b.data.length,b,c,c+d|0,0);},
A4D=b=>{return AVl(b,0,b.data.length);},
BcN=(a,b,c,d)=>{let e,f,g,h,i,j,k,l;if(a.d1())I(D2());if(Bk(a)<d)I(FR());if(c>=0){e=b.data;f=e.length;if(c<=f){g=c+d|0;if(g>f){h=new Bv;i=O();V(K(V(K(i,D(340)),g),D(260)),f);BB(h,S(i));I(h);}if(d<0){i=new Bv;h=O();K(V(K(h,D(261)),d),D(262));BB(i,S(h));I(i);}j=a.vU;k=0;while(k<d){g=j+1|0;l=c+1|0;a.iB(j,e[c]);k=k+1|0;j=g;c=l;}a.vU=a.vU+d|0;return a;}}e=b.data;i=new Bv;f=e.length;h=O();BA(V(K(V(K(h,D(263)),c),D(35)),f),41);BB(i,S(h));I(i);},
PH=a=>{FP(a);return a;},
GP=a=>{GT(a);return a;},
A_k=(a,b)=>{HR(a,b);return a;},
Bar=(a,b)=>{ER(a,b);return a;},
Bc_=a=>{return GP(a);},
BiD=a=>{return PH(a);},
A33=(a,b)=>{return a.iE(b);},
ALw=(a,b)=>{return a.iF(b);};
let BbO=B(Dq);
let Rw=B();
let AJa=0,Bf$=0,AFK=0,ANl=0,A7W=0,A8q=0,A4b=0,Bg4=0,AVm=0,ALP=0,A_r=0,ALs=0,A1e=0,APR=0,ATs=0,Bhk=0,A9c=0,A9S=0,Bkf=0,A8T=0,Bir=0,A3Y=0,AKG=0,A4Z=0,A2U=0,AST=0,A$2=0,BfV=0,APW=0;
let MX=()=>{MX=N(Rw);AXI();};
let AXI=()=>{AJa=imgui.ImGuiStyleVar_Alpha;Bf$=imgui.ImGuiStyleVar_DisabledAlpha;AFK=imgui.ImGuiStyleVar_WindowPadding;ANl=imgui.ImGuiStyleVar_WindowRounding;A7W=imgui.ImGuiStyleVar_WindowBorderSize;A8q=imgui.ImGuiStyleVar_WindowMinSize;A4b=imgui.ImGuiStyleVar_WindowTitleAlign;Bg4=imgui.ImGuiStyleVar_ChildRounding;AVm=imgui.ImGuiStyleVar_ChildBorderSize;ALP=imgui.ImGuiStyleVar_PopupRounding;A_r=imgui.ImGuiStyleVar_PopupBorderSize;ALs=imgui.ImGuiStyleVar_FramePadding;A1e=imgui.ImGuiStyleVar_FrameRounding;APR
=imgui.ImGuiStyleVar_FrameBorderSize;ATs=imgui.ImGuiStyleVar_ItemSpacing;Bhk=imgui.ImGuiStyleVar_ItemInnerSpacing;A9c=imgui.ImGuiStyleVar_IndentSpacing;A9S=imgui.ImGuiStyleVar_CellPadding;Bkf=imgui.ImGuiStyleVar_ScrollbarSize;A8T=imgui.ImGuiStyleVar_ScrollbarRounding;Bir=imgui.ImGuiStyleVar_GrabMinSize;A3Y=imgui.ImGuiStyleVar_GrabRounding;AKG=imgui.ImGuiStyleVar_TabRounding;A4Z=imgui.ImGuiStyleVar_ButtonTextAlign;A2U=imgui.ImGuiStyleVar_SelectableTextAlign;AST=imgui.ImGuiStyleVar_SeparatorTextBorderSize;A$2
=imgui.ImGuiStyleVar_SeparatorTextAlign;BfV=imgui.ImGuiStyleVar_SeparatorTextPadding;APW=imgui.ImGuiStyleVar_DockingSeparatorSize;};
let Wx=B();
let AFB=0,W9=0,AIK=0,AIu=0,V8=0,AAQ=0,V$=0,AHk=0,ABY=0,AAK=0,RU=0,AH4=0,AGZ=0,R1=0,Vw=0,AGK=0,VM=0,ADB=0,AEW=0,ABU=0,AA4=0,Rj=0,ACi=0,Bgi=0,ACg=0,Y3=0,Y2=0,Y1=0,Y0=0,YZ=0,YY=0,YX=0,YW=0,YV=0,YT=0,YS=0,YR=0,YP=0,YO=0,YN=0,YM=0,YL=0,YK=0,YJ=0,YI=0,YH=0,YG=0,YF=0,YE=0,Zp=0,Zo=0,Zn=0,Zm=0,Zl=0,Zk=0,Zj=0,Zi=0,Zh=0,Zg=0,Zf=0,Ze=0,AIy=0,AIx=0,AIA=0,AIz=0,AIC=0,AIB=0,AIq=0,AIp=0,AIs=0,Xq=0,Xp=0,Xt=0,ZN=0,SH=0,Vz=0,AFD=0,AB4=0,Vk=0,U7=0,Q4=0,XV=0,Yy=0,SK=0,Uy=0,ADX=0,AHC=0,AHp=0,ADG=0,AAd=0,AAe=0,AAf=0,Z_=0,AAa=0,AAb
=0,AAc=0,Z8=0,Z9=0,Z$=0,AGs=0,Um=0,ADZ=0,Sq=0,AG2=0,QS=0,Se=0,AKN=0,Bbk=0,A7s=0,Bj3=0,AKC=0,BhK=0,AR_=0,A9P=0,AOp=0,BdM=0,BaE=0,BdR=0,Baz=0,BdS=0,BaA=0,BdT=0,ARz=0,APZ=0,AMw=0,Bgy=0,A77=0,Be7=0,AKP=0,A4Q=0,BfQ=0,A1N=0,A5a=0,A7h=0,A7k=0,AV0=0,AV2=0,A$q=0,Pk=0,Km=0,P5=0,KF=0,AYY=0,Be1=0;
let P=()=>{P=N(Wx);AUF();};
let AUF=()=>{AFB=imgui.ImGuiKey_None;W9=imgui.ImGuiKey_Tab;AIK=imgui.ImGuiKey_LeftArrow;AIu=imgui.ImGuiKey_RightArrow;V8=imgui.ImGuiKey_UpArrow;AAQ=imgui.ImGuiKey_DownArrow;V$=imgui.ImGuiKey_PageUp;AHk=imgui.ImGuiKey_PageDown;ABY=imgui.ImGuiKey_Home;AAK=imgui.ImGuiKey_End;RU=imgui.ImGuiKey_Insert;AH4=imgui.ImGuiKey_Delete;AGZ=imgui.ImGuiKey_Backspace;R1=imgui.ImGuiKey_Space;Vw=imgui.ImGuiKey_Enter;AGK=imgui.ImGuiKey_Escape;VM=imgui.ImGuiKey_LeftCtrl;ADB=imgui.ImGuiKey_LeftShift;AEW=imgui.ImGuiKey_LeftAlt;ABU
=imgui.ImGuiKey_LeftSuper;AA4=imgui.ImGuiKey_RightCtrl;Rj=imgui.ImGuiKey_RightShift;ACi=imgui.ImGuiKey_RightAlt;Bgi=imgui.ImGuiKey_RightSuper;ACg=imgui.ImGuiKey_Menu;Y3=imgui.ImGuiKey_0;Y2=imgui.ImGuiKey_1;Y1=imgui.ImGuiKey_2;Y0=imgui.ImGuiKey_3;YZ=imgui.ImGuiKey_4;YY=imgui.ImGuiKey_5;YX=imgui.ImGuiKey_6;YW=imgui.ImGuiKey_7;YV=imgui.ImGuiKey_8;YT=imgui.ImGuiKey_9;YS=imgui.ImGuiKey_A;YR=imgui.ImGuiKey_B;YP=imgui.ImGuiKey_C;YO=imgui.ImGuiKey_D;YN=imgui.ImGuiKey_E;YM=imgui.ImGuiKey_F;YL=imgui.ImGuiKey_G;YK=imgui.ImGuiKey_H;YJ
=imgui.ImGuiKey_I;YI=imgui.ImGuiKey_J;YH=imgui.ImGuiKey_K;YG=imgui.ImGuiKey_L;YF=imgui.ImGuiKey_M;YE=imgui.ImGuiKey_N;Zp=imgui.ImGuiKey_O;Zo=imgui.ImGuiKey_P;Zn=imgui.ImGuiKey_Q;Zm=imgui.ImGuiKey_R;Zl=imgui.ImGuiKey_S;Zk=imgui.ImGuiKey_T;Zj=imgui.ImGuiKey_U;Zi=imgui.ImGuiKey_V;Zh=imgui.ImGuiKey_W;Zg=imgui.ImGuiKey_X;Zf=imgui.ImGuiKey_Y;Ze=imgui.ImGuiKey_Z;AIy=imgui.ImGuiKey_F1;AIx=imgui.ImGuiKey_F2;AIA=imgui.ImGuiKey_F3;AIz=imgui.ImGuiKey_F4;AIC=imgui.ImGuiKey_F5;AIB=imgui.ImGuiKey_F6;AIq=imgui.ImGuiKey_F7;AIp
=imgui.ImGuiKey_F8;AIs=imgui.ImGuiKey_F9;Xq=imgui.ImGuiKey_F10;Xp=imgui.ImGuiKey_F11;Xt=imgui.ImGuiKey_F12;ZN=imgui.ImGuiKey_Apostrophe;SH=imgui.ImGuiKey_Comma;Vz=imgui.ImGuiKey_Minus;AFD=imgui.ImGuiKey_Period;AB4=imgui.ImGuiKey_Slash;Vk=imgui.ImGuiKey_Semicolon;U7=imgui.ImGuiKey_Equal;Q4=imgui.ImGuiKey_LeftBracket;XV=imgui.ImGuiKey_Backslash;Yy=imgui.ImGuiKey_RightBracket;SK=imgui.ImGuiKey_GraveAccent;Uy=imgui.ImGuiKey_CapsLock;ADX=imgui.ImGuiKey_ScrollLock;AHC=imgui.ImGuiKey_NumLock;AHp=imgui.ImGuiKey_PrintScreen;ADG
=imgui.ImGuiKey_Pause;AAd=imgui.ImGuiKey_Keypad0;AAe=imgui.ImGuiKey_Keypad1;AAf=imgui.ImGuiKey_Keypad2;Z_=imgui.ImGuiKey_Keypad3;AAa=imgui.ImGuiKey_Keypad4;AAb=imgui.ImGuiKey_Keypad5;AAc=imgui.ImGuiKey_Keypad6;Z8=imgui.ImGuiKey_Keypad7;Z9=imgui.ImGuiKey_Keypad8;Z$=imgui.ImGuiKey_Keypad9;AGs=imgui.ImGuiKey_KeypadDecimal;Um=imgui.ImGuiKey_KeypadDivide;ADZ=imgui.ImGuiKey_KeypadMultiply;Sq=imgui.ImGuiKey_KeypadSubtract;AG2=imgui.ImGuiKey_KeypadAdd;QS=imgui.ImGuiKey_KeypadEnter;Se=imgui.ImGuiKey_KeypadEqual;AKN=
imgui.ImGuiKey_GamepadStart;Bbk=imgui.ImGuiKey_GamepadBack;A7s=imgui.ImGuiKey_GamepadFaceLeft;Bj3=imgui.ImGuiKey_GamepadFaceRight;AKC=imgui.ImGuiKey_GamepadFaceUp;BhK=imgui.ImGuiKey_GamepadFaceDown;AR_=imgui.ImGuiKey_GamepadDpadLeft;A9P=imgui.ImGuiKey_GamepadDpadRight;AOp=imgui.ImGuiKey_GamepadDpadUp;BdM=imgui.ImGuiKey_GamepadDpadDown;BaE=imgui.ImGuiKey_GamepadL1;BdR=imgui.ImGuiKey_GamepadR1;Baz=imgui.ImGuiKey_GamepadL2;BdS=imgui.ImGuiKey_GamepadR2;BaA=imgui.ImGuiKey_GamepadL3;BdT=imgui.ImGuiKey_GamepadR3;ARz
=imgui.ImGuiKey_GamepadLStickLeft;APZ=imgui.ImGuiKey_GamepadLStickRight;AMw=imgui.ImGuiKey_GamepadLStickUp;Bgy=imgui.ImGuiKey_GamepadLStickDown;A77=imgui.ImGuiKey_GamepadRStickLeft;Be7=imgui.ImGuiKey_GamepadRStickRight;AKP=imgui.ImGuiKey_GamepadRStickUp;A4Q=imgui.ImGuiKey_GamepadRStickDown;BfQ=imgui.ImGuiKey_MouseLeft;A1N=imgui.ImGuiKey_MouseRight;A5a=imgui.ImGuiKey_MouseMiddle;A7h=imgui.ImGuiKey_MouseX1;A7k=imgui.ImGuiKey_MouseX2;AV0=imgui.ImGuiKey_MouseWheelX;AV2=imgui.ImGuiKey_MouseWheelY;A$q=imgui.ImGuiMod_None;Pk
=imgui.ImGuiMod_Ctrl;Km=imgui.ImGuiMod_Shift;P5=imgui.ImGuiMod_Alt;KF=imgui.ImGuiMod_Super;AYY=imgui.ImGuiMod_Shortcut;Be1=imgui.ImGuiMod_Mask_;};
let AHF=B(W);
let ZR=a=>{Bn(a);},
Bbs=()=>{let a=new AHF();ZR(a);return a;},
A2r=a=>{let b;b=Bg6(a);b.v3=1;return b;};
function KB(){let a=this;A.call(a);a.BX=0;a.EY=0;a.Ei=null;}
let AFd=(a,b,c,d)=>{L(a);a.BX=b;a.EY=c;a.Ei=d;},
V7=(a,b,c)=>{let d=new KB();AFd(d,a,b,c);return d;};
let Gl=B();
let Ij=null,Hx=null;
let Lq=a=>{L(a);},
LB=b=>{if(!(b&1)){if(Hx!==null)return Hx;Hx=BcG();return Hx;}if(Ij!==null)return Ij;Ij=A9N();return Ij;};
let AEg=B(Gl);
let Xh=a=>{Lq(a);},
BcG=()=>{let a=new AEg();Xh(a);return a;},
Ba$=(a,b)=>{return b!=10&&b!=13&&b!=133&&(b|1)!=8233?0:1;},
BgS=(a,b,c)=>{let d;d:{a:{if(b!=10&&b!=133&&(b|1)!=8233){if(b!=13)break a;if(c==10)break a;}d=1;break d;}d=0;}return d;};
function AER(){let a=this;A.call(a);a.EQ=null;a.Cm=null;}
let ADT=(a,b,c)=>{L(a);a.EQ=b;a.Cm=c;},
A0S=(a,b)=>{let c=new AER();ADT(c,a,b);return c;};
let AEe=B(Gl);
let SD=a=>{Lq(a);},
A9N=()=>{let a=new AEe();SD(a);return a;},
AP4=(a,b)=>{return b!=10?0:1;},
A_b=(a,b,c)=>{return b!=10?0:1;};
let AYB=B(Fz);
let AIQ=B(W);
let Xv=a=>{Bn(a);},
A$X=()=>{let a=new AIQ();Xv(a);return a;},
A_Q=a=>{let b;b=A2y(a);b.v3=1;return b;};
let AWg=B();
let Oy=B(Cc);
function AD3(){let a=this;A.call(a);a.DL=null;a.Ey=0;}
let UU=(a,b)=>{L(a);a.DL=b;},
AEt=a=>{let b=new AD3();UU(b,a);return b;};
function Di(){let a=this;BM.call(a);a.x2=null;a.HT=0;}
let ADa=(a,b)=>{CO(a);a.x2=b.b4();a.HT=b.wa;},
AFY=a=>{let b=new Di();ADa(b,a);return b;},
AI8=(a,b,c)=>{return !a.x2.b6(c.bc(b))?(-1):1;},
A8z=(a,b)=>{if(b instanceof Dr)return Mg(a.x2,b.e5());if(b instanceof Di)return IQ(a.x2,b.x2);if(b instanceof CP)return IQ(a.x2,b.hE());if(!(b instanceof Df))return 1;return 0;},
A70=a=>{return a.x2;};
function Jm(){let a=this;A.call(a);a.C3=null;a.Ek=null;a.zP=0;a.Gm=null;a.IM=0.0;a.GJ=0.0;a.Bd=0;a.FG=null;a.AR=null;a.AW=null;a.Fz=0;a.CG=0;a.D7=0;a.Ee=0;a.Df=0;a.y4=null;a.yw=null;a.GH=0;a.HP=null;a.Ir=0.0;a.BQ=0;a.B3=0;a.C0=0;}
let AHW=null;
let GG=()=>{GG=N(Jm);A5e();};
let AFq=a=>{GG();Lj(a,1000,null);},
AKy=()=>{let a=new Jm();AFq(a);return a;},
Lj=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m;GG();L(a);a.zP=0;a.Gm=null;a.IM=0.0;a.GJ=0.0;a.Bd=0;a.FG=C0();a.AR=C0();a.AW=C0();a.Fz=0;a.CG=770;a.D7=771;a.Ee=770;a.Df=771;a.yw=null;a.HP=CE(1.0,1.0,1.0,1.0);a.Ir=AB3;a.BQ=0;a.B3=0;a.C0=0;if(b>8191)I(B3((((O()).O(D(341))).P(b)).y()));if(Ek===null)d=AHW;else{ES();d=H9;}e=new Gt;f=b*4|0;g=b*6|0;Mz(e,d,0,f,g,H(DY,[OA(1,2,D(342)),OA(4,4,D(343)),OA(16,2,D(344))]));a.C3=e;a.AR.iL(0.0,0.0,B5.fM(),B5.fN());a.Ek=Cq(b*20|0);h=AT7(g);i=0;j=0;while(j<g){k=h.data;k[j]=i;k[j+1|0]=(i
+1|0)<<16>>16;l=j+2|0;m=(i+2|0)<<16>>16;k[l]=m;k[j+3|0]=m;k[j+4|0]=(i+3|0)<<16>>16;k[j+5|0]=i;j=j+6|0;i=(i+4|0)<<16>>16;}a.C3.iM(h);if(c!==null)a.y4=c;else{a.y4=A9T();a.GH=1;}},
BkW=(a,b)=>{let c=new Jm();Lj(c,a,b);return c;},
A9T=()=>{let b,c,d;GG();b=D(345);c=D(346);d=Wt(b,c);if(d.fq())return d;I(B3((((O()).O(D(347))).O(d.fs())).y()));},
AZI=a=>{let b,c,d,e;if(!a.zP)return;a.BQ=a.BQ+1|0;a.B3=a.B3+1|0;b=a.zP/20|0;if(b>a.C0)a.C0=b;c=b*6|0;a.Gm.gm();d=a.C3;d.iO(a.Ek,0,a.zP);e=d.iP(1);e.dX(0);e.g7(c);if(a.Fz)Bc.gi(3042);else{Bc.gj(3042);if(a.CG!=(-1))Bc.gl(a.CG,a.D7,a.Ee,a.Df);}d.iQ(a.yw===null?a.y4:a.yw,4,0,c);a.zP=0;},
AW0=(a,b)=>{if(a.Bd)a.iR();a.AR.iS(b);if(a.Bd)a.iT();},
AS7=a=>{(a.AW.iS(a.AR)).iU(a.FG);if(a.yw===null){a.y4.go(D(348),a.AW);a.y4.gn(D(349),0);}else{a.yw.go(D(348),a.AW);a.yw.gn(D(349),0);}},
A5e=()=>{ES();AHW=HU;};
let AIM=B();
let E7=null;
let N4=()=>{N4=N(AIM);A_U();};
let A_U=()=>{E7=Bp((Bg7()).data.length);E7.data[Bl(KI)]=1;E7.data[Bl(Nd)]=2;E7.data[Bl(H9)]=3;E7.data[Bl(HU)]=4;};
let ATe=B(CC);
let AMS=B(Bm);
let IF=null,JC=null,G0=null,Jh=null;
let AOk=(b,c,d,e,f)=>{AL9(b,c,d,e,f);},
ARh=()=>{APF();A$j();Bb7();AUB();},
Bbl=()=>{imgui.ImGui.prototype.DestroyContext();},
CX=()=>{let b;b=Q(BcM());if(BS(b,Bg))return null;if(IF===null)IF=BiQ(1);IF.i0(b);return IF;},
AS6=()=>{imgui.ImGui.prototype.Render();},
A6s=()=>{let b;b=Q(Bc2());if(BS(b,Bg))return null;if(JC===null)JC=Be2(1);JC.i0(b);return JC;},
UG=()=>{imgui.ImGui.prototype.ShowDemoWindow();},
AX7=(b,c,d)=>{let e;e=c===null?0:U((c.i2()));return A9e(Be(b),e,d)?1:0;},
Ea=b=>{return Bcm(Be(b))?1:0;},
DK=()=>{imgui.ImGui.prototype.End();},
Pl=b=>{return AKx(b)?1:0;},
AZG=b=>{imgui.ImGui.prototype.SetNextWindowPos(b===null?0:U((b.fg())));},
AUJ=(b,c)=>{imgui.ImGui.prototype.SetNextWindowSize(b===null?0:U((b.fg())),c);},
A3q=b=>{imgui.ImGui.prototype.SetNextWindowSize(b===null?0:U((b.fg())));},
Rv=b=>{imgui.ImGui.prototype.SetWindowFocus(Be(b));},
AZ6=(b,c)=>{let d;d=c===null?0:U((c.fg()));imgui.ImGui.prototype.PushStyleVar_2(b,d);},
AOE=()=>{imgui.ImGui.prototype.PopStyleVar();},
AWO=b=>{return A_O(Be(b));},
AAI=b=>{imgui.ImGui.prototype.Text(Be(b));},
Bdg=(b,c)=>{return A1H(Be(b),Be(c))?1:0;},
A3w=()=>{imgui.ImGui.prototype.EndCombo();},
A_C=(b,c)=>{let d;d=c===null?0:U((c.i2()));return ATY(Be(b),d)?1:0;},
ATv=(b,c)=>{let d;d=c===null?0:U((c.i2()));return Bcf(Be(b),d)?1:0;},
Bfc=(b,c)=>{let d;d=c===null?0:U((c.i2()));return A$H(Be(b),d)?1:0;},
AKn=(b,c,d,e,f)=>{let g;g=c===null?0:U((c.i2()));return Bkj(Be(b),g,d,e,f)?1:0;},
WN=(b,c,d)=>{let e;e=c===null?0:U((c.i2()));return AWh(Be(b),e,d)?1:0;},
AQQ=(b,c)=>{let d;d=c===null?0:U((c.i2()));return A9s(Be(b),d)?1:0;},
BiZ=(b,c)=>{let d;d=c===null?0:U((c.i2()));return AV_(Be(b),d)?1:0;},
Bj0=(b,c)=>{return Bgf(Be(b),!!c)?1:0;},
A0x=()=>{return A8V()?1:0;},
A67=()=>{imgui.ImGui.prototype.EndMainMenuBar();},
MR=b=>{return Bd1(Be(b))?1:0;},
Qb=()=>{imgui.ImGui.prototype.EndMenu();},
Hr=b=>{return AZc(Be(b))?1:0;},
Bge=(b,c)=>{return AYU(Be(b),c)?1:0;},
ASY=()=>{imgui.ImGui.prototype.EndTabBar();},
Bd5=b=>{return Bam(Be(b))?1:0;},
A$Q=()=>{imgui.ImGui.prototype.EndTabItem();},
BgH=(b,c,d)=>{let e;e=c===null?0:U((c.fg()));return ATC(b,e,d);},
A2n=()=>{return AI2()?1:0;},
Bgb=(b,c)=>{return AYz(Be(b),c)?1:0;},
Bgv=()=>{imgui.ImGui.prototype.EndDragDropSource();},
BjD=()=>{return AVM()?1:0;},
A8c=b=>{let c;c=Q(AJx(Be(b)));if(BS(c,Bg))return null;if(G0===null)G0=AYg(1);G0.i0(c);return G0;},
AXr=()=>{imgui.ImGui.prototype.EndDragDropTarget();},
ACV=()=>{let b;b=Q(AOL());if(BS(b,Bg))return null;if(Jh===null)Jh=I5(1);Jh.i0(b);return Jh;},
AL9=(b,c,d,e,f)=>{var io=imgui.ImGui.prototype.GetIO();(io.get_DisplaySize()).set_x(c);(io.get_DisplaySize()).set_y(d);if(c>0&&d>0){(io.get_DisplayFramebufferScale()).set_x(e/c);(io.get_DisplayFramebufferScale()).set_y(f/d);}io.set_DeltaTime=b;imgui.ImGui.prototype.NewFrame();},
BcM=()=>{var returnedJSObj=imgui.ImGui.prototype.GetIO();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);},
Bc2=()=>{var returnedJSObj=imgui.ImGui.prototype.GetDrawData();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);},
A9e=(b,c,d)=>{var returnedJSObj=imgui.ImGui.prototype.Begin(b,c,d);return returnedJSObj;},
Bcm=b=>{var returnedJSObj=imgui.ImGui.prototype.Begin(b);return returnedJSObj;},
AKx=b=>{var returnedJSObj=imgui.ImGui.prototype.IsWindowFocused(b);return returnedJSObj;},
A_O=b=>{var returnedJSObj=imgui.ImGui.prototype.GetID(b);return returnedJSObj;},
A1H=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.BeginCombo(b,c);return returnedJSObj;},
ATY=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.DragFloat(b,c);return returnedJSObj;},
Bcf=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.DragFloat2(b,c);return returnedJSObj;},
A$H=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.DragFloat3(b,c);return returnedJSObj;},
Bkj=(b,c,d,e,f)=>{var returnedJSObj=imgui.ImGui.prototype.DragFloat4(b,c,d,e,f);return returnedJSObj;},
AWh=(b,c,d)=>{var returnedJSObj=imgui.ImGui.prototype.InputText(b,c,d);return returnedJSObj;},
A9s=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.ColorEdit3(b,c);return returnedJSObj;},
AV_=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.ColorEdit4(b,c);return returnedJSObj;},
Bgf=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.Selectable(b,c);return returnedJSObj;},
A8V=()=>{var returnedJSObj=imgui.ImGui.prototype.BeginMainMenuBar();return returnedJSObj;},
Bd1=b=>{var returnedJSObj=imgui.ImGui.prototype.BeginMenu(b);return returnedJSObj;},
AZc=b=>{var returnedJSObj=imgui.ImGui.prototype.MenuItem(b);return returnedJSObj;},
AYU=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.BeginTabBar(b,c);return returnedJSObj;},
Bam=b=>{var returnedJSObj=imgui.ImGui.prototype.BeginTabItem(b);return returnedJSObj;},
ATC=(b,c,d)=>{var returnedJSObj=imgui.ImGui.prototype.DockSpace(b,c,d);return returnedJSObj;},
AI2=()=>{var returnedJSObj=imgui.ImGui.prototype.BeginDragDropSource();return returnedJSObj;},
AYz=(b,c)=>{var returnedJSObj=imgui.ImGui.prototype.SetDragDropPayload(b,c);return returnedJSObj;},
AVM=()=>{var returnedJSObj=imgui.ImGui.prototype.BeginDragDropTarget();return returnedJSObj;},
AJx=b=>{var returnedJSObj=imgui.ImGui.prototype.AcceptDragDropPayload(b);if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);},
AOL=()=>{var returnedJSObj=imgui.ImGui.prototype.GetMainViewport();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);};
function Hu(){let a=this;T.call(a);a.Co=0;a.Dr=0;a.AL=0;a.B9=0;a.xa=0;a.yh=0;a.vX=null;a.wb=null;}
let AIl=a=>{Bh(a);a.vX=AIO();},
Cy=()=>{let a=new Hu();AIl(a);return a;},
Lr=(a,b,c)=>{Bh(a);a.vX=AIO();a.Co=b;a.Dr=c;},
Bez=(a,b)=>{let c=new Hu();Lr(c,a,b);return c;},
Rf=(a,b,c,d)=>{Lr(a,c,d);a.E(b);},
Bci=(a,b,c)=>{let d=new Hu();Rf(d,a,b,c);return d;},
AIZ=(a,b)=>{d:{if(a.Co){b:{if(!(b>=97&&b<=122)){if(b<65)break b;if(b>90)break b;}if(a.xa){a.vX.jq(FS(b&65535));break d;}a.vX.jr(FS(b&65535));break d;}if(a.Dr&&b>128){a.AL=1;b=Gu(Gp(b));}}}if(!(!Nb(b)&&!Ln(b))){if(a.B9)a.wd.jq(b-55296|0);else a.wd.jr(b-55296|0);}if(a.xa)a.vX.jq(b);else a.vX.jr(b);if(!a.v3&&PA(b))a.v3=1;return a;},
BjL=(a,b)=>{let c,d;if(!a.v3&&b.v3)a.v3=1;if(a.B9){if(!b.wl)a.wd.jx(b.cI());else a.wd.jy(b.cI());}else if(!b.wl)a.wd.jz(b.cI());else{a.wd.jA(b.cI());a.wd.jy(b.cI());a.wl=a.wl?0:1;a.B9=1;}if(!a.yh&&b.cM()!==null){if(a.xa){if(!b.cL())a.vX.jx(b.cM());else a.vX.jy(b.cM());}else if(!b.cL())a.vX.jz(b.cM());else{a.vX.jA(b.cM());a.vX.jy(b.cM());a.wa=a.wa?0:1;a.xa=1;}}else{c=a.wa;if(a.wb!==null){d=a.wb;if(!c)a.wb=BdV(a,c,d,b);else a.wb=BjV(a,c,d,b);}else{if(c&&!a.xa&&a.vX.cd())a.wb=AUW(a,b);else if(!c)a.wb=AJn(a,c,b);else a.wb
=ASS(a,c,b);a.yh=1;}}return a;},
Bd3=(a,b,c)=>{if(b>c)I(CF());a:{b:{if(!a.Co){if(c<55296)break b;if(b>57343)break b;}while(true){if(b>=(c+1|0))break a;a.F(b);b=b+1|0;}}if(a.xa)a.vX.jE(b,c+1|0);else a.vX.bN(b,c+1|0);}return a;},
AJL=(a,b)=>{let c,d;if(!a.v3&&b.v3)a.v3=1;if(b.jF())a.AL=1;if(!(a.wl^b.wl)){if(!a.wl)a.wd.jz(b.cI());else a.wd.jy(b.cI());}else if(a.wl)a.wd.jx(b.cI());else{a.wd.jA(b.cI());a.wd.jy(b.cI());a.wl=1;}if(!a.yh&&b.cM()!==null){if(!(a.wa^b.cL())){if(!a.wa)a.vX.jz(b.cM());else a.vX.jy(b.cM());}else if(a.wa)a.vX.jx(b.cM());else{a.vX.jA(b.cM());a.vX.jy(b.cM());a.wa=1;}}else{c=a.wa;if(a.wb!==null){d=a.wb;if(!c)a.wb=Bbo(a,c,d,b);else a.wb=BjI(a,c,d,b);}else{if(!a.xa&&a.vX.cd()){if(!c)a.wb=AUj(a,b);else a.wb=BeW(a,b);}
else if(!c)a.wb=AON(a,b,c);else a.wb=ALG(a,b,c);a.yh=1;}}},
BeB=(a,b)=>{let c,d;if(!a.v3&&b.v3)a.v3=1;if(b.jF())a.AL=1;if(!(a.wl^b.wl)){if(!a.wl)a.wd.jy(b.cI());else a.wd.jz(b.cI());}else if(!a.wl)a.wd.jx(b.cI());else{a.wd.jA(b.cI());a.wd.jy(b.cI());a.wl=0;}if(!a.yh&&b.cM()!==null){if(!(a.wa^b.cL())){if(!a.wa)a.vX.jy(b.cM());else a.vX.jz(b.cM());}else if(!a.wa)a.vX.jx(b.cM());else{a.vX.jA(b.cM());a.vX.jy(b.cM());a.wa=0;}}else{c=a.wa;if(a.wb!==null){d=a.wb;if(!c)a.wb=Bi6(a,c,d,b);else a.wb=BaX(a,c,d,b);}else{if(!a.xa&&a.vX.cd()){if(!c)a.wb=A6Z(a,b);else a.wb=A9n(a,b);}
else if(!c)a.wb=AOi(a,b,c);else a.wb=BiW(a,b,c);a.yh=1;}}},
AQP=(a,b)=>{if(a.wb!==null)return a.wa^a.wb.b6(b);return a.wa^a.vX.jH(b);},
BjO=a=>{if(!a.yh)return a.vX;return null;},
AUu=a=>{return a.wd;},
BdA=a=>{let b,c;if(a.wb!==null)return a;b=a.cM();c=AUT(a,b);return c.E(a.cL());},
A6c=a=>{let b,c;b=O();c=a.vX.cG(0);while(c>=0){b.dN(Gf(c));b.cF(124);c=a.vX.cG(c+1|0);}if(b.bb()>0)b.jJ(b.bb()-1|0);return b.y();},
AVt=a=>{return a.AL;};
let AFP=B(Bi);
let AG0=a=>{B9(a);},
PO=()=>{let a=new AFP();AG0(a);return a;};
let Gw=B(BX);
let RZ=B(F8);
let AA7=(a,b,c,d,e,f,g)=>{PD(a,b,c,d,e,f,g);},
Bbe=(a,b,c,d,e,f)=>{let g=new RZ();AA7(g,a,b,c,d,e,f);return g;},
A2Q=(a,b)=>{let c,d,e,f;c=a.wo.vS.data;d=a.wq;e=b*4|0;f=(c[d+e|0]&255)<<24|(a.wo.vS.data[(a.wq+e|0)+1|0]&255)<<16|(a.wo.vS.data[(a.wq+e|0)+2|0]&255)<<8|a.wo.vS.data[(a.wq+e|0)+3|0]&255;return VF(f);},
A$x=(a,b,c)=>{let d,e,f,g;d=Pi(c);e=a.wo.vS.data;f=a.wq;g=b*4|0;e[f+g|0]=d>>24<<24>>24;a.wo.vS.data[(a.wq+g|0)+1|0]=d>>16<<24>>24;a.wo.vS.data[(a.wq+g|0)+2|0]=d>>8<<24>>24;a.wo.vS.data[(a.wq+g|0)+3|0]=d<<24>>24;};
let A6O=B();
let AKl=B();
let Pe=B(Cc);
let Bfm=B(Pe);
let Bfj=B(Bo);
let I2=B(B8);
let KJ=a=>{Ff(a);},
Blf=()=>{let a=new I2();KJ(a);return a;};
let Ew=B(I2);
let Hz=a=>{KJ(a);},
BkK=()=>{let a=new Ew();Hz(a);return a;};
function AD8(){Ew.call(this);this.F9=0;}
let ACc=(a,b)=>{Hz(a);a.F9=b;},
AQk=a=>{let b=new AD8();ACc(b,a);return b;},
AUG=a=>{let b,c;b=a.F9;c=O();V(K(c,D(350)),b);return S(c);};
let XX=B(0);
let Fl=B();
let IE=a=>{L(a);},
BkQ=()=>{let a=new Fl();IE(a);return a;},
ALN=(a,b,c)=>{return;},
AWW=a=>{return;},
AVs=a=>{return;},
AW1=a=>{return;};
function L8(){let a=this;Fl.call(a);a.CV=null;a.Fd=null;}
let AFZ=a=>{IE(a);},
AB$=a=>{let b,c;b=C6.jL();D3();if(b!==ET)imgui.ImGui.prototype.CreateContext();else imgui.ImGui.prototype.CreateContext();c=CX();N5();c.jM(S5);a.Fd=A2t();a.CV=A7p();Vl.jN(a.Fd);},
Bi2=(a,b)=>{let c;Bc.jO(0.30000001192092896,0.30000001192092896,0.30000001192092896,1.0);Bc.jP(16384);a.CV.cX();a.jQ();AS6();c=A6s();a.CV.jT(c);},
Bjq=(a,b,c)=>{return;},
AZ7=a=>{return;},
A6_=a=>{return;},
Bg3=a=>{ARh();Bbl();};
function Oh(){let a=this;L8.call(a);a.A5=null;a.Em=null;a.C7=0;a.yF=null;a.Ik=null;a.z6=0;a.xF=0;}
let KD=0;
let Mu=()=>{Mu=N(Oh);BcR();};
let ABq=a=>{Mu();AFZ(a);a.C7=0;a.yF=Dx();a.Ik=O();Il();a.z6=NP;},
Bfq=()=>{let a=new Oh();ABq(a);return a;},
AJS=a=>{AB$(a);a.yF.eg(AMv());a.yF.eg(A8U());a.yF.eg(BjP());a.yF.eg(A8L());a.A5=A1A();a.A5.jX(1);a.Em=AKy();},
A8C=a=>{let b;a.A5.cX();a.Em.jY(a.A5.zC);b=1;if(b)BfN(a);else{UG();if(!a.C7){a.C7=1;AUJ(A50(400.0,400.0),2);}Ea(D(351));QA(a);DK();}},
QA=a=>{let b,c;Ne();if(Bge(D(352),VG|Sz)){b=a.yF.hv();while(b.bZ()){c=b.b0();if(Bd5(c.T())){c.j7();A$Q();}}ASY();}},
BfN=a=>{let b,c,d,e;M3();b=Vb|S1;c=b|AAS|Vv|Zx|VT;c=c|WG|UX;d=a.z6;Il();if((d&NP)>0)c=c|ZZ;e=ACV();AZG(e.ka());A3q(e.kc());MX();d=AFK;EC();AZ6(d,Ou.ke(0.0,0.0));AX7(D(353),null,c);AOE();a.xF=AWO(D(354));BgH(a.xF,Ou.ke(0.0,0.0),a.z6);DK();ANi(a);UG();Ea(D(355));DK();Ea(D(356));DK();Ea(D(357));DK();Ea(D(358));DK();if(Ea(D(359)))QA(a);DK();Ea(D(360));DK();if(!KD){KD=1;JV(a,0);}},
JV=(a,b)=>{let c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t;c=ACV();Rv(null);A8E(a.xF);Bc6(a.xF,a.z6|1024);BeP(a.xF,c.kc());if(b){d=a.xF;Jp();e=Qe;f=null;EQ();g=C3(d,e,0.20000000298023224,f,BO);h=BO.kq();i=C3(h,L9,0.20000000298023224,null,BO);j=BO.kq();k=C3(j,GD,0.20000000298023224,null,BO);l=BO.kq();m=C3(l,GD,0.5,null,BO);d=BO.kq();n=C3(g,OM,0.5,null,BO);o=BO.kq();Cg(D(359),d);Cg(D(360),d);Cg(D(355),m);Cg(D(361),o);Cg(D(356),k);Cg(D(358),n);Cg(D(357),i);}else{d=a.xF;Jp();e=Qe;f=null;EQ();g=C3(d,e,0.20000000298023224,
f,BO);h=BO.kq();i=C3(h,L9,0.30000001192092896,null,BO);j=BO.kq();p=C3(j,GD,0.4000000059604645,null,BO);d=BO.kq();n=C3(g,OM,0.5,null,BO);o=BO.kq();q=C3(i,GD,0.4000000059604645,null,BO);r=BO.kq();Cg(D(359),d);Cg(D(360),d);Cg(D(355),p);Cg(D(361),r);Cg(D(356),n);Cg(D(358),o);Cg(D(357),q);}s=Bic(d);t=ACF(D(362),0,ACF(D(359),0,0));s.ku(t);Bi4(a.xF);},
ANi=a=>{if(A0x()){if(MR(D(363))){Hr(D(364));Hr(D(365));Qb();}if(MR(D(366))){if(MR(D(367))){if(Hr(D(368)))JV(a,0);if(Hr(D(369)))JV(a,1);Qb();}Qb();}A67();}},
BcR=()=>{KD=0;};
let AEG=B(B8);
let X7=a=>{Ff(a);},
A5I=()=>{let a=new AEG();X7(a);return a;};
let GJ=B(FW);
let Oi=(a,b,c,d)=>{SF(a,b,c,d);},
A$O=(a,b)=>{let c,d,e;if(b>=0&&b<a.v4)return a.kB(b);c=new Bv;d=a.v4;e=O();BA(V(K(V(K(e,D(233)),b),D(35)),d),41);BB(c,S(e));I(c);},
A1M=a=>{return a.d3();};
function FN(){let a=this;GJ.call(a);a.xb=null;a.D0=0;a.xm=0;}
let Ol=(a,b,c,d,e,f,g)=>{Oi(a,c,e,f);a.xm=b;a.xb=d;a.D0=g;},
AYh=a=>{return a.D0;},
A_z=a=>{let b;b=a.xb;return b.hb();};
let ADc=B(E8);
let TG=(a,b)=>{IA(a,b);},
IR=a=>{let b=new ADc();TG(b,a);return b;};
let TL=B(0);
let IH=B();
let J_=a=>{L(a);},
Bfb=()=>{let a=new IH();J_(a);return a;},
ASN=a=>{return 4.294967296E9*a.kC()+(-2.147483648E9)|0;},
AKr=a=>{return AUm(Ef(Q(a.kD()),32),Q(a.kD()));},
AUP=a=>{return Math.random();};
function ABo(){let a=this;IH.call(a);a.Gw=Bg;a.Gx=Bg;}
let Xs=a=>{J_(a);a.kE((Bfb()).kF());},
A9Y=()=>{let a=new ABo();Xs(a);return a;},
AYk=(a,b)=>{let c;if(BS(b,Bg))b=C(0, 2147483648);c=AFT(b);a.kH(c,AFT(c));},
A_R=(a,b,c)=>{a.Gw=b;a.Gx=c;},
AFT=b=>{let c;c=AF5(b,BV(b,33));c=Bx(c,C(3981806797, 4283543511));c=AF5(c,BV(c,33));c=Bx(c,C(444984403, 3301882366));c=AF5(c,BV(c,33));return c;};
let Lo=B(0);
let Wn=B();
let BiS=(a,b)=>{return AFF(a.bW(b));},
AQb=a=>{return a.kJ();};
let BjU=B(B6);
let VH=B(HD);
let Zr=a=>{O9(a);},
AWU=()=>{let a=new VH();Zr(a);return a;},
AXG=a=>{let b;b=(AAw(a)).E(1);b.v3=1;return b;};
let WU=B();
let A0$=B();
function Fo(){let a=this;BD.call(a);a.Dp=0;a.y2=0;}
let Hv=(a,b,c)=>{Cu(a);a.Dp=b;a.y2=c;},
Bii=(a,b)=>{let c=new Fo();Hv(c,a,b);return c;},
AMB=(a,b,c,d)=>{let e,f,g,h;e=a.kK(d);if(e!==null&&(b+e.bb()|0)<=d.bq()){f=0;while(true){if(f>=e.bb()){d.c7(a.y2,e.bb());return a.vN.br(b+e.bb()|0,c,d);}g=e.bc(f);h=b+f|0;if(g!=c.bc(h)&&FS(e.bc(f))!=c.bc(h))break;f=f+1|0;}return (-1);}return (-1);},
A$y=(a,b)=>{a.vN=b;},
ARC=(a,b)=>{let c;c=b.kL(a.Dp);return c;},
A_o=(a,b)=>{let c;c=!b.bS(a.y2)?0:1;b.c7(a.y2,(-1));return c;};
function AF0(){let a=this;T.call(a);a.DD=null;a.Ip=null;}
let AIt=(a,b,c)=>{a.Ip=b;a.DD=c;Bh(a);},
Bkb=(a,b)=>{let c=new AF0();AIt(c,a,b);return c;},
AUo=(a,b)=>{let c;c=b-55296|0;return c>=0&&c<2048?a.wl^a.DD.jH(c):0;};
function AFS(){let a=this;T.call(a);a.FJ=null;a.FZ=null;a.Ia=null;}
let ABV=(a,b,c,d)=>{a.Ia=b;a.FJ=c;a.FZ=d;Bh(a);},
A2A=(a,b,c)=>{let d=new AFS();ABV(d,a,b,c);return d;},
AKS=(a,b)=>{let c,d;c=b-55296|0;d=c>=0&&c<2048?a.wl^a.FJ.jH(c):0;return a.FZ.b6(b)&&!d?1:0;};
let Ue=B(D6);
let AA$=(a,b,c,d,e)=>{Im(a,b,c,d,e);},
BeK=(a,b,c,d)=>{let e=new Ue();AA$(e,a,b,c,d);return e;},
Bat=(a,b,c,d)=>{let e,f,g,h;e=a.yo.hy();f=a.yo.hz();g=0;while(true){if(g>=e){f:{while(true){if(g>=f)break f;if((b+a.v9.bw()|0)>d.bq())break f;h=a.v9.bx(b,c);if(h<1)break;b=b+h|0;g=g+1|0;}}return a.vN.br(b,c,d);}if((b+a.v9.bw()|0)>d.bq()){d.wZ=1;return (-1);}h=a.v9.bx(b,c);if(h<1)break;b=b+h|0;g=g+1|0;}return (-1);};
let Ey=B(DC);
let ABK=B(0);
let AEm=B(0);
let AC1=B(0);
function V4(){A.call(this);this.FC=null;}
let SN=a=>{L(a);a.FC=null;a.FC=BeH();},
BhY=()=>{let a=new V4();SN(a);return a;};
let AKj=B(Cb);
let AO8=B();
let RR=B(Bm);
let AKU=a=>{return A_K(U((a.fg())));},
Yl=(a,b)=>{BR(a);},
AYg=a=>{let b=new RR();Yl(b,a);return b;},
A_K=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImGuiPayload);return imgui.ImHelper.prototype.getImGuiPayloadData(nativeObject);};
let AHD=B(0);
let ABd=B();
let AFt=a=>{L(a);},
A0i=()=>{let a=new ABd();AFt(a);return a;};
let AXY=B();
let Hq=b=>{let c,d,e,f,g,h;c=0;d=1;while(true){e=b.DL.data;f=b.Ey;b.Ey=f+1|0;g=A7D(e[f]);h=(g%2|0)!=1?0:1;c=c+CW(d,g/2|0)|0;d=d*46|0;if(!h)break;}return c;},
Ko=b=>{let c,d;c=Hq(b);d=c/2|0;if(c%2|0)d= -d|0;return d;},
A7D=b=>{if(b<34)return b-32|0;if(b>=92)return (b-32|0)-2|0;return (b-32|0)-1|0;};
function QK(){BM.call(this);this.AC=null;}
let AF8=(a,b)=>{let c,d;CO(a);c=O();d=0;while(d<b.bb()){c.cF(Et(D4(b.bc(d))));d=d+1|0;}a.AC=c.y();a.wj=c.bb();},
Bi$=a=>{let b=new QK();AF8(b,a);return b;},
A3R=(a,b,c)=>{let d;d=0;while(true){if(d>=a.AC.bb())return a.AC.bb();if(a.AC.bc(d)!=Et(D4(c.bc(b+d|0))))break;d=d+1|0;}return (-1);};
function AGB(){T.call(this);this.Il=null;}
let Qr=(a,b)=>{a.Il=b;Bh(a);},
BiG=a=>{let b=new AGB();Qr(b,a);return b;},
A0j=(a,b)=>{return A2D(b);};
let A6n=B(CC);
let Bfg=B(Bo);
let Bfk=B(CI);
function Wk(){let a=this;BD.call(a);a.CW=null;a.CA=null;}
let AHN=(a,b,c)=>{Cu(a);a.CW=b;a.CA=c;},
I0=(a,b)=>{let c=new Wk();AHN(c,a,b);return c;},
ANk=(a,b,c,d)=>{let e;e=a.CW.br(b,c,d);if(e<0)e=a.CA.br(b,c,d);if(e>=0)return e;return (-1);},
A7Q=(a,b)=>{a.vN=b;a.CA.bX(b);a.CW.bX(b);},
APz=(a,b)=>{return 1;},
AOz=(a,b)=>{return 1;};
let Qy=B(0);
function EZ(){let a=this;A.call(a);a.ze=null;a.yH=null;}
let JQ=(a,b,c)=>{L(a);a.ze=b;a.yH=c;},
BlD=(a,b)=>{let c=new EZ();JQ(c,a,b);return c;};
function LG(){let a=this;EZ.call(a);a.AN=null;a.Ff=0;}
let AC5=(a,b,c)=>{JQ(a,b,c);a.Ff=b.hY();},
A8$=(a,b)=>{let c=new LG();AC5(c,a,b);return c;},
AOc=a=>{return a.ze.hY();},
Bea=(a,b,c)=>{return a.Ff==b.hY()&&a.ze.bi(b)?1:0;};
let BfH=B(B0);
let E9=B(Cj);
let AF9=a=>{Ed(a,0);},
AYN=()=>{let a=new E9();AF9(a);return a;},
Be0=(a,b,c,d)=>{if(d.kR()!=1&&b!=d.bq())return (-1);d.kS();d.bQ(0,b);return b;};
let Ot=B(Ex);
let AJl=B(Ot);
let AFh=B(BM);
let AAW=(a,b)=>{RN(a,b);a.wj=0;},
En=a=>{let b=new AFh();AAW(b,a);return b;},
BaU=(a,b,c)=>{return 0;},
AU8=(a,b,c,d)=>{let e,f,g,h,i;e=d.bq();f=d.b5();while(true){g=CA(b,e);if(g>0)return (-1);if(g<0){h=c.bc(b);if(CU(h)&&b>f){i=c.bc(b-1|0);if(Cs(i)){b=b+1|0;continue;}}}if(a.vN.br(b,c,d)>=0)break;b=b+1|0;}return b;},
AQH=(a,b,c,d,e)=>{let f,g,h,i;f=e.bq();g=e.b5();while(true){if(c<b)return (-1);if(c<f){h=d.bc(c);if(CU(h)&&c>g){i=d.bc(c-1|0);if(Cs(i)){c=c+(-1)|0;continue;}}}if(a.vN.br(c,d,e)>=0)break;c=c+(-1)|0;}return c;},
ALM=(a,b)=>{return 0;};
let Mn=B(Ey);
let ASr=B(Mn);
let VY=B(0);
function O_(){let a=this;A.call(a);a.Ez=null;a.Cx=null;a.IL=null;}
let X1=(a,b,c,d)=>{a.IL=b;a.Ez=c;a.Cx=d;L(a);},
APc=(a,b,c)=>{let d=new O_();X1(d,a,b,c);return d;},
A5N=(a,b)=>{GM();NM.kT(a.Ez);if(a.Cx!==null)a.Cx.s();},
AVU=(a,b)=>{a.kU(b);};
let Xr=B(F8);
let Rz=(a,b,c,d,e,f,g)=>{PD(a,b,c,d,e,f,g);},
AJV=(a,b,c,d,e,f)=>{let g=new Xr();Rz(g,a,b,c,d,e,f);return g;},
AJM=(a,b)=>{let c,d,e,f;c=a.wo.vS.data;d=a.wq;e=b*4|0;f=c[d+e|0]&255|(a.wo.vS.data[(a.wq+e|0)+1|0]&255)<<8|(a.wo.vS.data[(a.wq+e|0)+2|0]&255)<<16|(a.wo.vS.data[(a.wq+e|0)+3|0]&255)<<24;return VF(f);},
A2s=(a,b,c)=>{let d,e,f,g;d=Pi(c);e=a.wo.vS.data;f=a.wq;g=b*4|0;e[f+g|0]=d<<24>>24;a.wo.vS.data[(a.wq+g|0)+1|0]=d>>8<<24>>24;a.wo.vS.data[(a.wq+g|0)+2|0]=d>>16<<24>>24;a.wo.vS.data[(a.wq+g|0)+3|0]=d>>24<<24>>24;};
let ACD=B(0);
function KS(){let a=this;A.call(a);a.x0=null;a.wO=null;a.FR=null;a.yP=null;a.Cs=null;a.GX=null;a.Gn=0.0;a.Bf=Bg;a.zO=Bg;a.Az=0.0;a.zL=0.0;a.A8=0;}
let BfR=0,AEf=null;
let IZ=()=>{IZ=N(KS);ANY();};
let AAl=(a,b)=>{let c,d,e,f,g,h,i,j,k,l,m,n,o;IZ();L(a);a.Gn=0.0;a.Bf=OO();a.zO=Q(-1);a.Az=0.0;a.zL=0.0;a.FR=b;c=Vu();d=c.gV();e=b.Gk;f=d.getElementById(Be(e));a.wO=f;g=ATl();e=!!b.FF;g.alpha=e;e=!!b.D8;g.antialias=e;e=!!b.Ev;g.stencil=e;e=!!b.E1;g.premultipliedAlpha=e;e=!!b.E9;g.preserveDrawingBuffer=e;h=a.wO;if(b.A9)a.x0=h.getContext("webgl2",g);if(b.A9&&a.x0!==null){e=!b.A2?Bft(a.x0):AM5(a.x0);a.Cs=e;a.yP=a.Cs;}else{a.x0=h.getContext("webgl",g);a.yP=!b.A2?Bdn(a.x0):AK1(a.x0);}i=a.yP.kY(7938);j=a.yP.kY(7936);k
=a.yP.kY(7937);e=new LT;D3();MZ(e,ET,i,j,k);a.GX=e;if(!(b.yx<0&&b.yy<0)){if(b.k0())a.k1(b.yx,b.yy);else{l=Jq();m=l.k2()-b.BJ|0;n=l.k3()-b.C$|0;o=!b.AH?1.0:a.k4();a.k1(o*m|0,o*n|0);}}ALB(a.wO,Bu(BcU(a),"fullscreenChanged"));},
A95=a=>{let b=new KS();AAl(b,a);return b;},
ARP=a=>{let b;b=OO();a.Az=BkZ(AZq(b,a.Bf))/1000.0;a.Bf=b;a.zL=a.zL+a.Az;a.A8=a.A8+1|0;if(a.zL>1.0){a.Gn=a.A8;a.zL=0.0;a.A8=0;}},
A89=a=>{return a.yP;},
AM1=a=>{return a.Cs;},
BgA=a=>{return a.wO.width;},
Bj4=a=>{return a.wO.height;},
ART=a=>{return a.wO.width;},
A7y=a=>{return a.wO.height;},
Bdr=a=>{return a.Az;},
AKp=(a,b,c)=>{let d,e,f,g,h,i,j;d=a.wO;e=b;d.width=e;d=a.wO;e=c;d.height=e;if(a.FR.AH){f=a.k4();g=a.wO.style;h=b/f;Ht();i=Hs.k7();e=O();K(LD(e,h),i);e=S(e);g.setProperty("width",Be(e));h=c/f;j=Hs.k7();d=O();K(LD(d,h),j);j=S(d);g.setProperty("height",Be(j));}},
BbN=a=>{return devicePixelRatio||1;},
ANY=()=>{BfR=0;AEf=Cw();},
ALB=(b,c)=>{if(b.requestFullscreen){document.addEventListener("fullscreenchange",c,false);}if(b.webkitRequestFullScreen){document.addEventListener("webkitfullscreenchange",c,false);}if(b.mozRequestFullScreen){document.addEventListener("mozfullscreenchange",c,false);}if(b.msRequestFullscreen){document.addEventListener("msfullscreenchange",c,false);}};
let WE=B(Fn);
let Ua=(a,b)=>{HZ(a,b);},
Blv=a=>{let b=new WE();Ua(b,a);return b;};
let AOX=B();
let Jg=B(0);
function R5(){let a=this;A.call(a);a.A3=0;a.F1=0;a.Eo=0;a.E3=0;a.zc=null;}
let ACS=(a,b)=>{a.zc=b;L(a);a.F1=a.zc.xJ;a.Eo=a.zc.bV();a.E3=(-1);},
AM8=a=>{let b=new R5();ACS(b,a);return b;},
A5O=a=>{return a.A3>=a.Eo?0:1;},
BdI=a=>{let b,c;ARf(a);a.E3=a.A3;b=a.zc;c=a.A3;a.A3=c+1|0;return b.bW(c);},
ARf=a=>{if(a.F1>=a.zc.xJ)return;I(APp());};
let ARD=B();
let Xx=B();
let Kg=null;
let AIR=()=>{AIR=N(Xx);A3A();};
let A3A=()=>{Kg=Bp((AJt()).data.length);Kg.data[Bl(Nv)]=1;Kg.data[Bl(PP)]=2;};
let ADl=B(0);
let Ix=B(DC);
let A8N=null,A9j=null;
let Qu=()=>{Qu=N(Ix);AQC();};
let AQC=()=>{A8N=BF();A9j=BF();};
let Bac=B(Ix);
function Py(){let a=this;A.call(a);a.Hd=null;a.Dd=0.0;a.Hv=0.0;a.x4=null;a.yC=null;a.AV=null;a.w8=0;}
let AIh=(a,b,c,d)=>{let e,f;L(a);a.x4=D(370);DZ();a.yC=EG;a.AV=EG;if(c<=0.0){e=new Ca;f=O();CR(K(f,D(371)),c);Dy(e,S(f));I(e);}if(d>0.0){a.Hd=b;a.Dd=c;a.Hv=d;return;}e=new Ca;f=O();CR(K(f,D(372)),d);Dy(e,S(f));I(e);},
AGg=(a,b)=>{if(b!==null){a.yC=b;a.k$(b);return a;}I(B3(D(373)));},
Ber=(a,b)=>{return;},
ABJ=(a,b)=>{if(b!==null){a.AV=b;a.k_(b);return a;}I(B3(D(373)));},
AX8=(a,b)=>{return;},
L1=(a,b,c,d)=>{let e,f,g,$$je;if(!(a.w8==2&&!d)&&a.w8!=3){a.w8=d?2:1;while(true){try{e=a.la(b,c);}catch($$e){$$je=Bb($$e);if($$je instanceof Bi){f=$$je;I(ASk(f));}else{throw $$e;}}if(e.lb())return e;if(e.lc()){if(d&&GL(b)){g=a.yC;DZ();if(g===EG)return E_(Bk(b));if(Bk(c)<=a.x4.bb())return EM;b.fC(BY(b)+Bk(b)|0);if(a.yC===ED)HH(c,a.x4);}return e;}if(e.lg()){g=a.yC;DZ();if(g===EG)return e;if(a.yC===ED){if(Bk(c)<a.x4.bb())return EM;HH(c,a.x4);}b.fC(BY(b)+e.bb()|0);}else if(e.lh()){g=a.AV;DZ();if(g===EG)break;if
(a.AV===ED){if(Bk(c)<a.x4.bb())return EM;HH(c,a.x4);}b.fC(BY(b)+e.bb()|0);}}return e;}I(IW());},
Y8=(a,b)=>{if(a.w8!=3&&a.w8!=2)I(IW());a.w8=3;return a.li(b);},
AGP=a=>{a.w8=0;a.lj();return a;},
TX=(a,b)=>{let c,d,e;if(a.w8&&a.w8!=3)I(IW());if(!Bk(b))return AHQ(0);if(a.w8)AGP(a);c=AHQ(BT(8,Bk(b)*a.Dd|0));while(true){d=L1(a,b,c,0);if(d.lc())break;if(d.lb())c=AAB(a,c);if(!d.lo())continue;d.lp();}e=L1(a,b,c,1);if(e.lo())e.lp();while(true){e=Y8(a,c);if(e.lc())break;c=AAB(a,c);}AA5(c);return c;},
AAB=(a,b)=>{let c,d,e;c=Om(b);d=c.data;d=Sb(c,BT(8,d.length*2|0));e=A5A(d);e.lt(BY(b));return e;},
A5F=(a,b)=>{CJ();return Eu;},
ATO=a=>{return;};
function MC(){let a=this;Py.call(a);a.DI=null;a.Fl=null;}
let SB=(a,b,c,d)=>{AIh(a,b,c,d);a.DI=EL(512);a.Fl=Cr(512);},
Bd2=(a,b,c)=>{let d,e,f,g,h,i,j,k,l,m,n;d=a.DI;e=0;f=0;g=a.Fl;d:{while(true){if((e+32|0)>f&&GL(b)){h=e;while(h<f){i=d.data;i[h-e|0]=i[h];h=h+1|0;}i=d.data;j=f-e|0;f=B7(Bk(b)+j|0,i.length);b.lv(d,j,f-j|0);e=0;}if(!GL(c)){if(!GL(b)&&e>=f){CJ();k=Eu;}else{CJ();k=EM;}break d;}i=g.data;l=0;m=B7(Bk(c),i.length);n=A9t(b,c);k=a.lx(d,e,f,g,l,m,n);e=n.Ga;if(k===null&&l==n.BB){CJ();k=Eu;}j=n.BB;c.ly(g,0,j);if(k!==null)break;}}b.fC(BY(b)-(f-e|0)|0);return k;};
let ABF=B(MC);
let ZJ=(a,b)=>{SB(a,b,0.3333333432674408,0.5);},
A$N=a=>{let b=new ABF();ZJ(b,a);return b;},
BgB=(a,b,c,d,e,f,g,h)=>{let i,j,k,l,m,n,o,p,q,r,s;i=null;d:{e:{j:{while(c<d){if(f>=g)break d;j=b.data;k=c+1|0;l=j[c]&255;if(!(l&128)){j=e.data;m=f+1|0;j[f]=l&65535;}else if((l&224)==192){if(k>=d){c=k+(-1)|0;if(h.lz(2))break d;CJ();i=Eu;break d;}n=k+1|0;o=j[k];if(!Fk(a,o)){c=n+(-2)|0;i=E_(1);break d;}j=e.data;m=f+1|0;j[f]=((l&31)<<6|o&63)&65535;k=n;}else if((l&240)==224){if((k+2|0)>d){c=k+(-1)|0;if(h.lz(3))break d;CJ();i=Eu;break d;}n=k+1|0;o=j[k];k=n+1|0;p=j[n];if(!Fk(a,o))break e;if(!Fk(a,p))break e;q=((l&
15)<<12|(o&63)<<6|p&63)&65535;if(AHi(q)){c=k+(-3)|0;i=E_(3);break d;}j=e.data;m=f+1|0;j[f]=q;}else{if((l&248)!=240){c=k+(-1)|0;i=E_(1);break d;}if((k+3|0)>d){c=k+(-1)|0;if(h.lz(4))break d;CJ();i=Eu;break d;}if((f+2|0)>g){c=k+(-1)|0;if(h.lC(2))break d;CJ();i=EM;break d;}n=k+1|0;o=j[k];m=n+1|0;p=j[n];k=m+1|0;r=j[m];if(!Fk(a,o))break j;if(!Fk(a,p))break j;if(!Fk(a,r))break j;j=e.data;s=(l&7)<<18|(o&63)<<12|(p&63)<<6|r&63;n=f+1|0;j[f]=Iq(s);m=n+1|0;j[n]=Jx(s);}c=k;f=m;}break d;}c=k+(-3)|0;i=E_(1);break d;}c=k+(-3)
|0;i=E_(1);}h.lD(c);h.lE(f);return i;},
Fk=(a,b)=>{return (b&192)!=128?0:1;};
let OK=B();
let AIX=B(Cv);
let ADK=(a,b,c,d)=>{Em(a,b,c,d);},
Baj=(a,b,c)=>{let d=new AIX();ADK(d,a,b,c);return d;},
AMq=(a,b,c,d)=>{let e;d:{while(true){if((b+a.v9.bw()|0)>d.bq())break d;e=a.v9.bx(b,c);if(e<1)break;b=b+e|0;}}return a.vN.br(b,c,d);};
function ADW(){let a=this;A.call(a);a.EW=null;a.FK=null;a.Ga=0;a.BB=0;}
let ABs=(a,b,c)=>{L(a);a.EW=b;a.FK=c;},
A9t=(a,b)=>{let c=new ADW();ABs(c,a,b);return c;},
AZu=(a,b)=>{return Bk(a.EW)<b?0:1;},
AOJ=(a,b)=>{return Bk(a.FK)<b?0:1;},
Bec=(a,b)=>{a.Ga=b;},
A$9=(a,b)=>{a.BB=b;};
let RM=B(0);
let ZK=B();
let SS=a=>{L(a);},
Bc$=()=>{let a=new ZK();SS(a);return a;},
AMK=(a,b,c)=>{c.lF();};
let A2H=B(EA);
function Sx(){T.call(this);this.Ij=null;}
let AH9=(a,b)=>{a.Ij=b;Bh(a);},
ASR=a=>{let b=new Sx();AH9(b,a);return b;},
BfW=(a,b)=>{return Bew(b);};
let Rk=B(0);
function IL(){let a=this;A.call(a);a.yK=null;a.BC=null;}
let TZ=null;
let H0=()=>{H0=N(IL);AXe();};
let Jq=()=>{H0();return TZ;},
Xg=a=>{H0();L(a);a.yK=window;},
Vu=()=>{let a=new IL();Xg(a);return a;},
AYv=a=>{let b;b=a.yK.document;return b;},
Bb4=(a,b)=>{a.BC=b;requestAnimationFrame(Bu(a,"onAnimationFrame"));},
AVw=(a,b)=>{let c;c=a.BC;a.BC=null;c.s();},
A3a=a=>{let b;b=a.yK.location;return b;},
ATn=a=>{return a.yK.document.documentElement.clientWidth;},
APu=a=>{return a.yK.document.documentElement.clientHeight;},
AQ9=(a,b,c)=>{let d;d=Cl(c,"handleEvent");a.yK.addEventListener(Be(b),Bu(d,"handleEvent"));},
AXe=()=>{TZ=Vu();},
A8F=(a,b)=>{a.lH(b);};
let AC3=B(0);
let MH=B(BC);
let A1L=B(MH);
let ARa=B();
let Ox=B(Bm);
let AR4=null,AR3=null,AR2=null;
let Np=()=>{Np=N(Ox);AN0();};
let UR=(a,b)=>{Np();BR(a);},
JS=a=>{let b=new Ox();UR(b,a);return b;},
BgM=(a,b)=>{A8u(U((a.fg())),b);},
AN0=()=>{AR4=JS(1);AR3=JS(1);AR2=JS(1);},
A8u=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.ImGuiDockNode);jsObj.set_SelectedTabId(c);};
function Ny(){let a=this;EZ.call(a);a.Cq=0;a.zE=null;}
let AC7=(a,b,c)=>{JQ(a,b,null);a.Cq=c;},
Bbw=(a,b)=>{let c=new Ny();AC7(c,a,b);return c;};
let EV=B(0);
let A3B=B(Dq);
let Bgl=B();
let AEx=B(W);
let YD=a=>{Bn(a);},
AKi=()=>{let a=new AEx();YD(a);return a;},
Bc0=a=>{return (Cy()).G(65,90);};
function Jf(){A.call(this);this.Fn=null;}
let A9o=null,Jb=null,FZ=null,GX=null,AG3=null,TJ=null;
let CT=()=>{CT=N(Jf);AQD();};
let A4N=(a,b)=>{CT();L(a);a.Fn=b;},
G8=a=>{let b=new Jf();A4N(b,a);return b;},
DQ=b=>{let c,d,e,f,g,h,i,j;CT();if(b===null)return null;b:{c=b;if(Jb!==null){d=Ba(typeof c);if(!d.bi(D(374))&&!d.bi(D(375))){if(d.bi(D(376))){e=c;f=FZ.get(e);g=(typeof f==='undefined'?1:0)?void 0:f.deref();if(!(typeof g==='undefined'?1:0))return g;h=G8(c);i=h;FZ.set(e,new WeakRef(i));R_(AG3,i,e);return h;}if(!d.bi(D(377)))break b;else{j=c;f=GX.get(j);g=(typeof f==='undefined'?1:0)?void 0:f.deref();if(!(typeof g==='undefined'?1:0))return g;h=G8(c);i=h;GX.set(j,new WeakRef(i));R_(TJ,i,j);return h;}}f=Jb.get(c);g
=(typeof f==='undefined'?1:0)?void 0:f.deref();if(!(typeof g==='undefined'?1:0))return g;h=G8(c);Jb.set(c,new WeakRef(h));return h;}}return G8(c);},
AJm=b=>{CT();if(b!==null&&!(b instanceof Of()))b=DQ(b);return b;},
BL=b=>{CT();if(b===null)return null;return b.Fn;},
AMb=b=>{CT();if(b===null)return null;return !(b instanceof Of())?b:BL(b);},
AFF=b=>{CT();if(b===null)return null;return b instanceof Of()&&b instanceof Jf?BL(b):b;},
AAL=b=>{CT();if(b===null)return null;return b instanceof Of()?b:DQ(b);},
ATh=b=>{let c,d;CT();c=GX;d=BL(b);c.delete(d);},
A8h=b=>{let c,d;CT();c=FZ;d=BL(b);c.delete(d);},
AQD=()=>{let b;A9o=new WeakMap();b=!(typeof WeakRef!=='undefined'?1:0)?null:new WeakMap();Jb=b;b=!(typeof WeakRef!=='undefined'?1:0)?null:new Map();FZ=b;b=!(typeof WeakRef!=='undefined'?1:0)?null:new Map();GX=b;b=FZ===null?null:new FinalizationRegistry(Bu(Bcj(),"accept"));AG3=b;b=GX===null?null:new FinalizationRegistry(Bu(BaR(),"accept"));TJ=b;},
R_=(b,c,d)=>{return b.register(c,d);};
let HI=B(Bz);
let AGz=null,AH1=null,WI=null,AKu=null;
let L0=()=>{L0=N(HI);Bax();};
let Bb9=(a,b,c)=>{L0();Ce(a,b,c);},
J6=(a,b)=>{let c=new HI();Bb9(c,a,b);return c;},
Bax=()=>{AGz=J6(D(378),0);AH1=J6(D(379),1);WI=J6(D(380),2);AKu=H(HI,[AGz,AH1,WI]);};
function OU(){LU.call(this);this.BU=null;}
let AFL=a=>{Pm(a,M8());},
Bij=()=>{let a=new OU();AFL(a);return a;},
Pm=(a,b)=>{ADz(a);a.BU=b;},
Bku=a=>{let b=new OU();Pm(b,a);return b;},
BhC=(a,b)=>{return a.BU.bL(b,a)!==null?0:1;},
BaP=(a,b)=>{return a.BU.lO(b);};
let ATr=B(B6);
function RS(){Bw.call(this);this.ES=null;}
let ADm=(a,b)=>{Cd(a);a.ES=b;},
Bdi=a=>{let b=new RS();ADm(b,a);return b;},
AQt=(a,b,c,d)=>{let e,f;d:{if(b!=d.bq()){if(!b)break d;if(d.ia()&&b==d.b5())break d;e=a.ES;f=b-1|0;if(e.lP(c.bc(f),c.bc(b)))break d;}return (-1);}return a.vN.br(b,c,d);},
AWJ=(a,b)=>{return 0;};
let AWB=B(BC);
function Id(){let a=this;A.call(a);a.xu=null;a.xt=null;a.EZ=0;a.Iw=0;a.B8=0;a.zI=0;a.z5=0;}
let NJ=(a,b,c,d)=>{L(a);a.zI=0;a.z5=0;a.Iw=b;a.xu=d;a.xt=NK(CW(a.xu.w6/4|0,c));Hm(a.xt);a.EZ=Y.fK();a.B8=!b?35048:35044;},
A3r=(a,b,c)=>{let d=new Id();NJ(d,a,b,c);return d;},
Bjf=a=>{if(a.z5){Y.f6(34962,BI(a.xt),a.xt,a.B8);a.zI=0;}},
A7c=(a,b,c,d)=>{a.zI=1;Pg(b,a.xt,d,c);a.xt.g_(0);a.xt.g$(d);Bjf(a);},
AUO=(a,b,c)=>{let d,e,f,g,h,i;d=Y;d.gp(34962,a.EZ);if(a.zI){d.f6(34962,BI(a.xt),a.xt,a.B8);a.zI=0;}a:{e=De(a.xu);if(c!==null){f=0;while(true){if(f>=e)break a;g=c.data;h=CQ(a.xu,f);i=g[f];if(i>=0){b.gs(i);b.gt(i,h.xd,h.xC,h.xU,a.xu.w6,h.x$);}f=f+1|0;}}f=0;while(f<e){h=CQ(a.xu,f);i=b.gr(h.xs);if(i>=0){b.gs(i);b.gt(i,h.xd,h.xC,h.xU,a.xu.w6,h.x$);}f=f+1|0;}}a.z5=1;},
ANo=(a,b,c)=>{let d,e,f,g;d:{d=Y;e=De(a.xu);if(c===null){f=0;while(f<e){b.gu((CQ(a.xu,f)).xs);f=f+1|0;}}else{f=0;while(true){if(f>=e)break d;g=c.data[f];if(g>=0)b.ip(g);f=f+1|0;}}}d.gp(34962,0);a.z5=0;};
let SL=B(Id);
let AEk=(a,b,c)=>{NJ(a,0,b,c);},
BdF=(a,b)=>{let c=new SL();AEk(c,a,b);return c;};
let AGT=B(0);
function NQ(){A.call(this);this.wy=null;}
let Yq=a=>{L(a);},
A78=a=>{if(a.wy!==null)a.wy.lS();},
A4V=a=>{if(a.wy!==null)a.wy.lT();},
A0k=a=>{if(a.wy!==null)a.wy.lU();},
A0h=a=>{if(a.wy!==null)a.wy.lV(B5.fL());},
ANt=(a,b,c)=>{if(a.wy!==null)a.wy.lW(b,c);},
Bf2=(a,b)=>{if(a.wy!==null)a.wy.lS();a.wy=b;if(a.wy!==null){a.wy.jW();a.wy.lW(B5.fM(),B5.fN());}};
let ADk=B(W);
let W0=a=>{Bn(a);},
Bih=()=>{let a=new ADk();W0(a);return a;},
A_6=a=>{return (Cy()).G(97,122);};
let A0J=B(CI);
let OF=B(FC);
let A0F=B(OF);
let A4u=B(Cx);
let P6=B(BC);
let ARj=B(P6);
let Nc=B(0);
function Fy(){let a=this;A.call(a);a.vR=null;a.BK=0;a.Bj=0;a.Bk=0;a.G0=0;a.G7=0;a.BL=0;a.Cg=0;a.wQ=null;a.xQ=null;a.Bl=null;a.HR=null;a.Hb=null;a.BA=null;a.As=null;a.Bx=0;a.zM=null;a.zi=null;a.za=null;a.zX=null;a.GK=null;}
let II=(a,b)=>{L(a);a.BK=1;a.Bj=1;a.Bk=1;a.G0=1;a.G7=1;a.BL=1;a.Cg=1;a.wQ=Cw();a.xQ=Cw();a.Bl=Cw();a.HR=Cw();a.Hb=Cw();a.BA=Cw();a.As=Cw();a.Bx=0;a.zM=new Float32Array(40000);a.zi=new Int32Array(12000);a.za=new Int16Array(12000);a.zX=new Int8Array(12000);a.GK=new Uint8Array(240000);a.vR=b;a.vR.pixelStorei(37441,0);},
Bdn=a=>{let b=new Fy();II(b,a);return b;},
ATJ=(a,b)=>{let c;c=a.BK;a.BK=c+1|0;a.wQ.lX(c,DQ(b));return c;},
API=(a,b)=>{let c;c=a.Bj;a.Bj=c+1|0;a.xQ.lX(c,DQ(b));return c;},
AKO=(a,b)=>{let c;c=a.Bk;a.Bk=c+1|0;a.Bl.lX(c,DQ(b));return c;},
ARs=(a,b)=>{let c;c=a.BL;a.BL=c+1|0;a.BA.lX(c,DQ(b));return c;},
AV6=(a,b,c)=>{let d,e;d=a.As.bW(b);if(d===null){d=Cw();a.As.lX(b,d);}e=a.Cg;a.Cg=e+1|0;d.lX(e,DQ(c));return e;},
BiX=(a,b)=>{let c,d,e,f,g,h;if(F5()){c=FG(b);return Z6(c.buffer,BY(b),Bk(b));}A2a(a,b);d=BY(b);e=0;while(d<BI(b)){f=a.zM;g=b.l2(d);e;f[e]=g;d=d+1|0;e=e+1|0;}f=a.zM;h=Bk(b);return f.subarray(0,h);},
A2P=(a,b)=>{let c,d,e,f,g,h;if(F5()){c=FG(b);return AJf(c.buffer,BY(b),Bk(b));}AVW(a,b);d=BY(b);e=0;while(d<BI(b)){f=a.za;g=b.l5(d);e;f[e]=g;d=d+1|0;e=e+1|0;}f=a.za;h=Bk(b);return f.subarray(0,h);},
Bff=(a,b)=>{let c,d,e,f,g,h;if(F5()){c=FG(b);return A6N(c.buffer,BY(b),Bk(b));}a.l7(b);d=BY(b);e=0;while(d<BI(b)){f=a.zi;g=b.l8(d);e;f[e]=g;d=d+1|0;e=e+1|0;}f=a.zi;h=Bk(b);return f.subarray(0,h);},
A5t=(a,b)=>{let c,d,e,f,g;if(F5())return FG(b);ARY(a,b);c=BY(b);d=0;while(c<BI(b)){e=a.zX;f=b.l$(c);d;e[d]=f;c=c+1|0;d=d+1|0;}e=a.zX;g=Bk(b);return e.subarray(0,g);},
A2a=(a,b)=>{if(Bk(b)>a.zM.length)a.zM=AOb(Bk(b));},
AVW=(a,b)=>{if(Bk(b)>a.za.length)a.za=AZ4(Bk(b));},
Bfo=(a,b)=>{if(Bk(b)>a.zi.length)a.zi=AMr(Bk(b));},
ARY=(a,b)=>{if(Bk(b)>a.zX.length)a.zX=A_F(Bk(b));},
AJz=(a,b)=>{return BL((a.As.bW(a.Bx)).bW(b));},
Mq=(a,b,c)=>{let d,e;d=BL(a.wQ.bW(b));e=BL(a.xQ.bW(c));a.vR.attachShader(d,e);},
PQ=(a,b,c)=>{let d,e;d=a.vR;e=BL(a.Bl.bW(c));d.bindBuffer(b,e);},
Le=(a,b,c)=>{let d,e;d=a.vR;e=BL(a.BA.bW(c));d.bindTexture(b,e);},
NW=(a,b)=>{a.vR.blendEquation(b);},
Mj=(a,b,c,d,e)=>{a.vR.blendFuncSeparate(b,c,d,e);},
LW=(a,b,c,d,e)=>{let f,g,h;if(d instanceof DV){f=a.vR;g=a.md(d);f.bufferData(b,g,e);}else if(d instanceof FQ){f=a.vR;g=a.me(d);f.bufferData(b,g,e);}else if(d instanceof FW){g=a.vR;h=a.mf(d);g.bufferData(b,h,e);}else if(d instanceof D9){f=a.vR;g=a.mg(d);f.bufferData(b,g,e);}else{if(d!==null)I(DF(D(381)));a.vR.bufferData(b,c,e);}},
LV=(a,b,c,d,e)=>{let f,g;if(e instanceof DV){f=a.vR;g=a.md(e);f.bufferSubData(b,c,g);}else if(e instanceof FQ){f=a.vR;g=a.me(e);f.bufferSubData(b,c,g);}else if(e instanceof FW){f=a.vR;g=a.mf(e);f.bufferSubData(b,c,g);}else{if(!(e instanceof D9))I(DF(D(381)));f=a.vR;g=a.mg(e);f.bufferSubData(b,c,g);}},
O6=(a,b)=>{a.vR.clear(b);},
Lm=(a,b,c,d,e)=>{a.vR.clearColor(b,c,d,e);},
MF=(a,b)=>{let c;c=BL(a.xQ.bW(b));a.vR.compileShader(c);},
P4=a=>{let b;b=a.vR.createProgram();return ATJ(a,b);},
N9=(a,b)=>{let c;c=a.vR.createShader(b);return API(a,c);},
N2=(a,b)=>{a.vR.disable(b);},
NH=(a,b)=>{a.vR.disableVertexAttribArray(b);},
Lw=(a,b,c,d)=>{a.vR.drawArrays(b,c,d);},
MN=(a,b,c,d,e)=>{let f,g;f=a.vR;g=BY(e);f.drawElements(b,c,d,g);},
Ns=(a,b,c,d,e)=>{a.vR.drawElements(b,c,d,e);},
PI=(a,b)=>{a.vR.enable(b);},
Pf=(a,b)=>{a.vR.enableVertexAttribArray(b);},
OT=a=>{a.vR.flush();},
AZV=a=>{let b;b=a.vR.createBuffer();return AKO(a,b);},
BgE=a=>{let b;b=a.vR.createTexture();return ARs(a,b);},
KE=(a,b,c,d,e)=>{let f,g,h;f=a.vR;g=BL(a.wQ.bW(b));h=f.getActiveAttrib(g,c);d.ml(h.size);e.ml(h.type);Dv(d);Dv(e);return Ba(h.name);},
MV=(a,b,c,d,e)=>{let f,g,h;f=a.vR;g=BL(a.wQ.bW(b));h=f.getActiveUniform(g,c);d.ml(h.size);e.ml(h.type);Dv(d);Dv(e);return Ba(h.name);},
LS=(a,b,c)=>{let d;d=BL(a.wQ.bW(b));return a.vR.getAttribLocation(d,Be(c));},
PZ=(a,b)=>{let c,d;c=a.vR;d=BL(a.wQ.bW(b));return Ba(c.getProgramInfoLog(d));},
NF=(a,b,c,d)=>{let e,f,g,h;if(c!=35712&&c!=35714&&c!=35715){e=a.vR;f=BL(a.wQ.bW(b));d.ml(e.getProgramParameter(f,c));}else{f=a.vR;g=BL(a.wQ.bW(b));h=f.getProgramParameter(g,c)?1:0;d.ml(!h?0:1);}Dv(d);},
M0=(a,b)=>{let c,d;c=a.vR;d=BL(a.xQ.bW(b));return Ba(c.getShaderInfoLog(d));},
Ls=(a,b,c,d)=>{let e,f,g,h;if(c!=35713&&c!=35712){e=a.vR;f=BL(a.xQ.bW(b));g=e.getShaderParameter(f,c);d.ml(g);}else{h=a.vR;e=BL(a.xQ.bW(b));g=h.getShaderParameter(e,c)?1:0;d.ml(!g?0:1);}Dv(d);},
L7=(a,b)=>{return Ba(a.vR.getParameter(b));},
L5=(a,b,c)=>{let d,e,f;d=a.vR;e=BL(a.wQ.bW(b));f=d.getUniformLocation(e,Be(c));if(f!==null)return AV6(a,b,f);return (-1);},
Nz=(a,b)=>{return a.vR.isEnabled(b)?1:0;},
KQ=(a,b)=>{let c,d;c=a.vR;d=BL(a.wQ.bW(b));c.linkProgram(d);},
Lv=(a,b,c)=>{a.vR.pixelStorei(b,c);},
K4=(a,b,c,d,e)=>{a.vR.scissor(b,c,d,e);},
JX=(a,b,c)=>{let d,e;d=a.vR;e=BL(a.xQ.bW(b));d.shaderSource(e,Be(c));},
NS=(a,b,c,d,e,f,g,h,i,j)=>{let k,l,m,n,o,p,q,r,s,t,u;if(j===null){k=a.vR;l=null;k.texImage2D(b,c,d,e,f,g,h,i,l);}else if(BI(j)<=4){m=j.mn(0);IZ();n=AEf.bW(m);if(n.mo()){o=a.vR;p=n.mp();o.texImage2D(b,c,d,e,f,g,h,i,p);}else if(n.mq()){k=a.vR;l=n.mr();k.texImage2D(b,c,d,h,i,l);}else if(!n.ms()){k=a.vR;l=n.mt();k.texImage2D(b,c,d,h,i,l);}else{k=a.vR;l=n.mu();k.texImage2D(b,c,d,h,i,l);}}else{if(!F5()){if(!(j instanceof DV)){q=a.mg(j);r=Uint8Array.from(q);}else r=a.md(j);}else{s=FG(j);if(!(j instanceof DV)){t=Bk(j);u
=s.byteOffset+BY(j)|0;r=AQj(s.buffer,u,t);}else{t=Bk(j);u=s.byteOffset+BY(j)|0;r=Z6(s.buffer,u,t);}}a.vR.texImage2D(b,c,d,e,f,g,h,i,r);}},
NX=(a,b,c,d)=>{let e,f;e=a.vR;f=d;e.texParameterf(b,c,f);},
N1=(a,b,c)=>{let d;d=a.mw(b);a.vR.uniform1i(d,c);},
AVO=(a,b,c,d,e,f)=>{let g;g=a.mw(b);a.vR.uniformMatrix4fv(g,!!d,A2G(e));},
KT=(a,b)=>{let c,d;a.Bx=b;c=a.vR;d=BL(a.wQ.bW(b));c.useProgram(d);},
M7=(a,b,c,d,e,f,g)=>{a.vR.vertexAttribPointer(b,c,d,!!e,f,g);},
Ka=(a,b,c,d,e)=>{a.vR.viewport(b,c,d,e);};
let AAq=B(0);
function JN(){let a=this;Fy.call(a);a.yB=null;a.Iy=null;a.Ic=0;a.GR=null;a.G5=0;a.Ht=null;a.Gt=0;a.CK=null;a.Ct=0;a.HV=null;}
let JY=(a,b)=>{II(a,b);a.Iy=Cw();a.Ic=1;a.GR=Cw();a.G5=1;a.Ht=Cw();a.Gt=1;a.CK=Cw();a.Ct=1;a.HV=ASI(12000);a.yB=b;},
Bft=a=>{let b=new JN();JY(b,a);return b;},
AYa=(a,b)=>{let c;c=a.Ct;a.Ct=c+1|0;a.CK.lX(c,DQ(b));return c;},
WH=(a,b)=>{let c,d;c=a.yB;d=BL(a.CK.bW(b));c.bindVertexArray(d);},
ABf=(a,b,c,d,e)=>{a.yB.drawArraysInstanced(b,c,d,e);},
AIk=(a,b,c,d,e,f)=>{a.yB.drawElementsInstanced(b,c,d,e,f);},
ABH=(a,b,c)=>{let d,e,f,g;d=BY(c);e=0;while(e<b){f=a.yB.createVertexArray();g=AYa(a,f);c.ml(g);e=e+1|0;}c.mA(d);};
let Sw=B(JN);
let Zv=(a,b)=>{JY(a,b);},
AM5=a=>{let b=new Sw();Zv(b,a);return b;},
Bf=a=>{let b,c,d,e;b=a.yB.getError();if(!b)return;c=new EU;d=P_(b);e=O();K(K(V(K(e,D(382)),b),D(383)),d);EO(c,S(e));I(c);},
AUb=(a,b)=>{WH(a,b);Bf(a);},
AOS=(a,b,c,d,e)=>{ABf(a,b,c,d,e);Bf(a);},
Bgw=(a,b,c,d,e,f)=>{AIk(a,b,c,d,e,f);Bf(a);},
ANf=(a,b,c)=>{ABH(a,b,c);Bf(a);},
AOK=(a,b,c)=>{Le(a,b,c);Bf(a);},
Bcl=(a,b)=>{O6(a,b);Bf(a);},
A3M=(a,b,c,d,e)=>{Lm(a,b,c,d,e);Bf(a);},
Bdw=(a,b)=>{N2(a,b);Bf(a);},
ASU=(a,b,c,d)=>{Lw(a,b,c,d);Bf(a);},
A82=(a,b,c,d,e)=>{MN(a,b,c,d,e);Bf(a);},
A_G=(a,b)=>{PI(a,b);Bf(a);},
A72=a=>{OT(a);Bf(a);},
AJb=(a,b)=>{return L7(a,b);},
ALi=(a,b,c)=>{Lv(a,b,c);Bf(a);},
A3e=(a,b,c,d,e)=>{K4(a,b,c,d,e);Bf(a);},
A4v=(a,b,c,d,e,f,g,h,i,j)=>{NS(a,b,c,d,e,f,g,h,i,j);Bf(a);},
AWE=(a,b,c,d,e)=>{Ka(a,b,c,d,e);Bf(a);},
A2p=(a,b,c)=>{Mq(a,b,c);Bf(a);},
Be_=(a,b,c)=>{PQ(a,b,c);Bf(a);},
AJy=(a,b)=>{NW(a,b);Bf(a);},
AUd=(a,b,c,d,e)=>{Mj(a,b,c,d,e);Bf(a);},
A32=(a,b,c,d,e)=>{LW(a,b,c,d,e);Bf(a);},
BeZ=(a,b,c,d,e)=>{LV(a,b,c,d,e);Bf(a);},
A6k=(a,b)=>{MF(a,b);Bf(a);},
BhX=a=>{let b;b=P4(a);Bf(a);return b;},
A9B=(a,b)=>{let c;c=N9(a,b);Bf(a);return c;},
BhE=(a,b)=>{NH(a,b);Bf(a);},
AN3=(a,b,c,d,e)=>{Ns(a,b,c,d,e);Bf(a);},
A9O=(a,b)=>{Pf(a,b);Bf(a);},
AY7=(a,b,c,d,e)=>{let f;f=KE(a,b,c,d,e);Bf(a);return f;},
Bcg=(a,b,c,d,e)=>{let f;f=MV(a,b,c,d,e);Bf(a);return f;},
A48=(a,b,c)=>{let d;d=LS(a,b,c);Bf(a);return d;},
AQA=(a,b,c,d)=>{NF(a,b,c,d);Bf(a);},
ALd=(a,b)=>{let c;c=PZ(a,b);Bf(a);return c;},
BhU=(a,b,c,d)=>{Ls(a,b,c,d);Bf(a);},
AMJ=(a,b)=>{let c;c=M0(a,b);Bf(a);return c;},
ALj=(a,b,c)=>{let d;d=L5(a,b,c);Bf(a);return d;},
Beb=(a,b)=>{let c;c=Nz(a,b);Bf(a);return c;},
Bf5=(a,b)=>{KQ(a,b);Bf(a);},
ALa=(a,b,c)=>{JX(a,b,c);Bf(a);},
ANw=(a,b,c,d)=>{NX(a,b,c,d);Bf(a);},
APt=(a,b,c)=>{N1(a,b,c);Bf(a);},
Bjj=(a,b)=>{KT(a,b);Bf(a);},
A$$=(a,b,c,d,e,f,g)=>{M7(a,b,c,d,e,f,g);Bf(a);};
let Xo=B(W);
let TO=a=>{Bn(a);},
Bfs=()=>{let a=new Xo();TO(a);return a;},
A9X=a=>{return BhP(a);};
function ZC(){let a=this;A.call(a);a.xr=null;a.wT=null;a.Cn=0;a.Hw=0;a.ys=0;a.Ae=0;a.Fu=0;}
let Vo=(a,b,c)=>{L(a);a.ys=1;a.Ae=0;a.wT=Ut(c*2|0);a.Hw=1;a.Fu=!b?35048:35044;a.xr=a.wT.m3();a.xr.gF();a.wT.gF();a.Cn=BhJ(a);},
AIa=(a,b)=>{let c=new ZC();Vo(c,a,b);return c;},
BhJ=a=>{let b;b=Y.fK();Y.gp(34963,b);Y.f6(34963,DL(a.wT),null,a.Fu);Y.gp(34963,0);return b;},
A$n=a=>{return BI(a.xr);},
AJN=a=>{return DL(a.xr);},
AZM=(a,b,c,d)=>{a.ys=1;a.xr.dW();a.xr.m4(b,c,d);a.xr.gF();a.wT.dX(0);a.wT.g7(d<<1);if(a.Ae){Y.ik(34963,0,BI(a.wT),a.wT);a.ys=0;}},
Bc9=(a,b)=>{a.ys=a.ys|b;return a.xr;},
A1m=a=>{if(!a.Cn)I(DF(D(384)));Y.gp(34963,a.Cn);if(a.ys){a.wT.g7(BI(a.xr)*2|0);Y.ik(34963,0,BI(a.wT),a.wT);a.ys=0;}a.Ae=1;},
APw=a=>{Y.gp(34963,0);a.Ae=0;};
let S6=B(Bw);
let AFb=a=>{Cd(a);},
ATS=()=>{let a=new S6();AFb(a);return a;},
A0K=(a,b,c,d)=>{if(b!=d.m5())return (-1);return a.vN.br(b,c,d);},
Bjt=(a,b)=>{return 0;};
let AQ3=B();
let MQ=B(Cj);
let Nx=(a,b)=>{Ed(a,b);},
BlN=a=>{let b=new MQ();Nx(b,a);return b;},
ALv=(a,b,c,d)=>{let e;e=a.bR();d.c7(e,b-d.bS(e)|0);return a.vN.br(b,c,d);},
A_9=(a,b)=>{return 0;};
let Bkl=B(Ey);
let Bgg=B(GR);
let A7Y=B(K7);
let ACQ=B();
let AYW=null;
let NV=()=>{NV=N(ACQ);A00();};
let AU2=b=>{let c,d;NV();if(!b)return 1;c=b+(-1)|0;d=c|c>>1;d=d|d>>2;d=d|d>>4;d=d|d>>8;d=d|d>>16;return d+1|0;},
A00=()=>{AYW=A9Y();};
function QG(){BM.call(this);this.EB=0;}
let AE_=(a,b)=>{CO(a);a.wj=2;a.EB=Gu(Gp(b));},
A7M=a=>{let b=new QG();AE_(b,a);return b;},
BaC=(a,b,c)=>{let d,e,f;d=b+1|0;e=c.bc(b);f=c.bc(d);return a.EB!=Gu(Gp(Ev(e,f)))?(-1):2;};
let A0W=B(CG);
function UD(){let a=this;W.call(a);a.Ew=0;a.EO=0;}
let AHo=(a,b,c)=>{Bn(a);a.Ew=b;a.EO=c;},
M=(a,b)=>{let c=new UD();AHo(c,a,b);return c;},
A2$=a=>{let b;b=(Cy()).G(a.Ew,a.EO);return b;};
let D5=B(Cv);
let Iv=(a,b,c,d)=>{Em(a,b,c,d);},
A4L=(a,b,c)=>{let d=new D5();Iv(d,a,b,c);return d;},
A3Z=(a,b,c,d)=>{let e;e=a.vY.br(b,c,d);if(e<0)e=a.vN.br(b,c,d);return e;},
Bj6=(a,b)=>{Po(a,b);a.vY.bX(b);};
let ZY=B(Fm);
let ABi=(a,b,c)=>{IT(a,b,c);},
VP=(a,b)=>{let c=new ZY();ABi(c,a,b);return c;};
let AHl=B(F1);
let A3b=null;
let AHy=()=>{AHy=N(AHl);A2g();};
let A2g=()=>{A3b=BF();};
function AA9(){T.call(this);this.HE=null;}
let AEU=(a,b)=>{a.HE=b;Bh(a);},
A$J=a=>{let b=new AA9();AEU(b,a);return b;},
BeX=(a,b)=>{return BeN(b);};
function AH2(){A.call(this);this.Eq=null;}
let XD=(a,b)=>{L(a);a.Eq=b;},
AUi=a=>{let b=new AH2();XD(b,a);return b;},
Bei=a=>{A1O(a.Eq);};
let Q5=B(CP);
let UN=(a,b)=>{Og(a,b);},
ABv=a=>{let b=new Q5();UN(b,a);return b;},
A0B=(a,b)=>{return a.xk.b6(Gu(Gp(b)));};
let Ty=B(0);
let Js=B(Bz);
let Nv=null,PP=null,AEL=null;
let JB=()=>{JB=N(Js);AMF();};
let AJt=()=>{JB();return AEL.b$();},
A8i=(a,b,c)=>{JB();Ce(a,b,c);},
Qv=(a,b)=>{let c=new Js();A8i(c,a,b);return c;},
AMF=()=>{Nv=Qv(D(385),0);PP=Qv(D(386),1);AEL=H(Js,[Nv,PP]);};
let AIF=B(W);
let ABg=a=>{Bn(a);},
A0Z=()=>{let a=new AIF();ABg(a);return a;},
AX9=a=>{return (((Cy()).G(33,64)).G(91,96)).G(123,126);};
function L4(){let a=this;A.call(a);a.xT=null;a.w3=null;a.Cz=0;a.Iz=0;a.Cl=0;a.zB=0;a.Ba=0;a.BP=0;a.wY=null;}
let IM=null;
let HL=()=>{HL=N(L4);Bjc();};
let UJ=(a,b,c,d)=>{HL();L(a);a.zB=0;a.Ba=0;a.BP=(-1);a.wY=AIS();a.Iz=b;a.xT=d;a.w3=NK(CW(a.xT.w6/4|0,c));Hm(a.w3);a.Cz=Y.fK();a.Cl=!b?35048:35044;AV8(a);},
A1Y=(a,b,c)=>{let d=new L4();UJ(d,a,b,c);return d;},
AOy=a=>{if(a.Ba){Y.f6(34962,BI(a.w3),a.w3,a.Cl);a.zB=0;}},
AOh=(a,b,c,d)=>{a.zB=1;Pg(b,a.w3,d,c);a.w3.g_(0);a.w3.g$(d);AOy(a);},
Bcv=(a,b,c)=>{let d;d=Ek;d.mB(a.BP);Ba0(a,b,c);Bbc(a,d);a.Ba=1;},
Ba0=(a,b,c)=>{let d,e,f,g,h,i;d=!a.wY.wk?0:1;b:{e=De(a.xT);if(d){if(c===null){f=0;while(d&&f<e){g=CQ(a.xT,f);h=b.gr(g.xs);d=h!=a.wY.l8(f)?0:1;f=f+1|0;}}else{i=c.data;d=i.length!=a.wY.wk?0:1;f=0;while(d){if(f>=e)break b;d=i[f]!=a.wY.l8(f)?0:1;f=f+1|0;}}}}g:{if(!d){Bc.gp(34962,a.Cz);Bib(a,b);a.wY.nb();f=0;while(true){if(f>=e)break g;g=CQ(a.xT,f);if(c!==null){i=c.data;a.wY.nc(i[f]);}else a.wY.nc(b.gr(g.xs));h=a.wY.l8(f);if(h>=0){b.gs(h);b.gt(h,g.xd,g.xC,g.xU,a.xT.w6,g.x$);}f=f+1|0;}}}},
Bib=(a,b)=>{let c,d,e;if(!a.wY.wk)return;c=De(a.xT);d=0;while(d<c){e=a.wY.l8(d);if(e>=0)b.ip(e);d=d+1|0;}},
Bbc=(a,b)=>{if(a.zB){b.gp(34962,a.Cz);a.w3.g$(BI(a.w3));b.f6(34962,BI(a.w3),a.w3,a.Cl);a.zB=0;}},
ATd=(a,b,c)=>{let d;d=Ek;d.mB(0);a.Ba=0;},
AV8=a=>{HL();Dv(IM);Ek.mF(1,IM);a.BP=IM.nd();},
Bjc=()=>{IM=GO(1);};
let AMu=B(B0);
let A65=B(B6);
let AGM=B(Fy);
let AHJ=(a,b)=>{II(a,b);},
AK1=a=>{let b=new AGM();AHJ(b,a);return b;},
Bj=a=>{let b,c,d,e;b=a.vR.getError();if(!b)return;c=new EU;d=P_(b);e=O();K(K(V(K(e,D(382)),b),D(383)),d);EO(c,S(e));I(c);},
Bg$=(a,b,c)=>{Le(a,b,c);Bj(a);},
AQI=(a,b)=>{O6(a,b);Bj(a);},
ASl=(a,b,c,d,e)=>{Lm(a,b,c,d,e);Bj(a);},
Biy=(a,b)=>{N2(a,b);Bj(a);},
AZx=(a,b,c,d)=>{Lw(a,b,c,d);Bj(a);},
Bhn=(a,b,c,d,e)=>{MN(a,b,c,d,e);Bj(a);},
AOd=(a,b)=>{PI(a,b);Bj(a);},
AV$=a=>{OT(a);Bj(a);},
A1S=(a,b)=>{return L7(a,b);},
A6x=(a,b,c)=>{Lv(a,b,c);Bj(a);},
BcY=(a,b,c,d,e)=>{K4(a,b,c,d,e);Bj(a);},
AUH=(a,b,c,d,e,f,g,h,i,j)=>{NS(a,b,c,d,e,f,g,h,i,j);Bj(a);},
BhL=(a,b,c,d,e)=>{Ka(a,b,c,d,e);Bj(a);},
AK$=(a,b,c)=>{Mq(a,b,c);Bj(a);},
AI9=(a,b,c)=>{PQ(a,b,c);Bj(a);},
AUR=(a,b)=>{NW(a,b);Bj(a);},
AI4=(a,b,c,d,e)=>{Mj(a,b,c,d,e);Bj(a);},
A04=(a,b,c,d,e)=>{LW(a,b,c,d,e);Bj(a);},
AWX=(a,b,c,d,e)=>{LV(a,b,c,d,e);Bj(a);},
BiO=(a,b)=>{MF(a,b);Bj(a);},
A7g=a=>{let b;b=P4(a);Bj(a);return b;},
Bh$=(a,b)=>{let c;c=N9(a,b);Bj(a);return c;},
A7a=(a,b)=>{NH(a,b);Bj(a);},
AXl=(a,b,c,d,e)=>{Ns(a,b,c,d,e);Bj(a);},
Biz=(a,b)=>{Pf(a,b);Bj(a);},
A08=(a,b,c,d,e)=>{let f;f=KE(a,b,c,d,e);Bj(a);return f;},
AOR=(a,b,c,d,e)=>{let f;f=MV(a,b,c,d,e);Bj(a);return f;},
AXx=(a,b,c)=>{let d;d=LS(a,b,c);Bj(a);return d;},
AUV=(a,b,c,d)=>{NF(a,b,c,d);Bj(a);},
AU$=(a,b)=>{let c;c=PZ(a,b);Bj(a);return c;},
ALy=(a,b,c,d)=>{Ls(a,b,c,d);Bj(a);},
A_g=(a,b)=>{let c;c=M0(a,b);Bj(a);return c;},
BcV=(a,b,c)=>{let d;d=L5(a,b,c);Bj(a);return d;},
ARd=(a,b)=>{let c;c=Nz(a,b);Bj(a);return c;},
A26=(a,b)=>{KQ(a,b);Bj(a);},
Bhi=(a,b,c)=>{JX(a,b,c);Bj(a);},
BcH=(a,b,c,d)=>{NX(a,b,c,d);Bj(a);},
BhV=(a,b,c)=>{N1(a,b,c);Bj(a);},
ALz=(a,b)=>{KT(a,b);Bj(a);},
AQe=(a,b,c,d,e,f,g)=>{M7(a,b,c,d,e,f,g);Bj(a);};
let Bif=B(CI);
let IG=B(Bm);
let PF=(a,b)=>{let c;BR(a);c=Q(A1w(b));a.fe(c,1);},
OI=a=>{let b=new IG();PF(b,a);return b;},
AZ9=(a,b)=>{return AN8(U((a.fg())),b);},
Bdf=a=>{return Q(ASf(U((a.fg()))));},
A1w=b=>{var jsObj=new imgui.IDLIntArray(b);return imgui.getPointer(jsObj);},
AN8=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.IDLIntArray);var returnedJSObj=jsObj.getValue(c);return returnedJSObj;},
ASf=b=>{var jsObj=imgui.wrapPointer(b,imgui.IDLIntArray);var returnedJSObj=jsObj.getPointer();return returnedJSObj;};
let K$=B(IG);
let BO=null,AEb=null;
let EQ=()=>{EQ=N(K$);A2_();};
let Bb7=()=>{EQ();BO.fh();AEb.fh();},
AHR=a=>{EQ();PF(a,1);},
S$=()=>{let a=new K$();AHR(a);return a;},
Bgc=a=>{return a.fz(0);},
A$P=a=>{return IP(a.kq());},
A2_=()=>{BO=S$();AEb=S$();};
let Big=B(FC);
let Go=B(Bm);
let Ou=null,A$T=null,A$U=null,A$R=null;
let EC=()=>{EC=N(Go);BiY();};
let AE3=a=>{let b;EC();BR(a);b=Q(A5S());a.fe(b,1);},
IK=()=>{let a=new Go();AE3(a);return a;},
Wl=(a,b)=>{EC();BR(a);},
ADF=a=>{let b=new Go();Wl(b,a);return b;},
A5Y=(a,b,c)=>{a.nh(b);a.ni(c);return a;},
Zy=(a,b,c)=>{let d;EC();BR(a);d=Q(APG(b,c));a.fe(d,1);},
A50=(a,b)=>{let c=new Go();Zy(c,a,b);return c;},
Bae=(a,b)=>{A43(U((a.fg())),b);},
BaN=(a,b)=>{ASd(U((a.fg())),b);},
BiY=()=>{Ou=IK();A$T=IK();A$U=IK();A$R=IK();},
A5S=()=>{var jsObj=new imgui.ImVec2();return imgui.getPointer(jsObj);},
APG=(b,c)=>{var jsObj=new imgui.ImVec2(b,c);return imgui.getPointer(jsObj);},
A43=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec2);jsObj.set_x(c);},
ASd=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec2);jsObj.set_y(c);};
function AFN(){let a=this;A.call(a);a.xR=null;a.AU=0;}
let Sn=a=>{L(a);a.AU=0;a.xR=Dx();a.xR.eg(D(387));a.xR.eg(D(388));a.xR.eg(D(389));a.xR.eg(D(390));},
A8U=()=>{let a=new AFN();Sn(a);return a;},
ASC=a=>{let b,c,d,e;b=a.xR.bW(a.AU);if(Bdg(D(391),b)){c=0;while(c<a.xR.v2){d=a.xR.bW(c);e=c!=a.AU?0:1;if(Bj0(d,e))a.AU=c;c=c+1|0;}A3w();}},
A02=a=>{return D(392);};
let Io=B(Bm);
let APn=null,APm=null,APl=null,APS=null;
let G4=()=>{G4=N(Io);A8_();};
let Yz=a=>{let b;G4();BR(a);b=Q(A6R());a.fe(b,1);},
HX=()=>{let a=new Io();Yz(a);return a;},
Q9=(a,b)=>{G4();BR(a);},
A6m=a=>{let b=new Io();Q9(b,a);return b;},
BbU=a=>{return A9y(U((a.fg())));},
AMm=a=>{return A7z(U((a.fg())));},
A06=a=>{return Bcr(U((a.fg())));},
AZB=a=>{return BjR(U((a.fg())));},
A8_=()=>{APn=HX();APm=HX();APl=HX();APS=HX();},
A6R=()=>{var jsObj=new imgui.ImVec4();return imgui.getPointer(jsObj);},
A9y=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec4);return jsObj.get_x();},
A7z=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec4);return jsObj.get_y();},
Bcr=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec4);return jsObj.get_z();},
BjR=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImVec4);return jsObj.get_w();};
let It=B(W);
let ME=a=>{Bn(a);},
Bca=()=>{let a=new It();ME(a);return a;},
XN=a=>{return ((Cy()).G(9,13)).F(32);};
let A9J=B();
let ACp=B();
let Bjh=null,Bjm=null,Bjl=null;
let VA=()=>{VA=N(ACp);ARU();};
let ARU=()=>{Bjh=BF();Bjm=BF();Bjl=BF();};
let Ug=B();
let AZ_=null;
let ABx=()=>{ABx=N(Ug);Bip();};
let Bip=()=>{AZ_=H(Jv,[Br(WU),Br(EB),Br(AAD),Br(AB2),Br(AHs),Br(HA),Br(AG7),Br(E1),Br(Y9),Br(AFg),Br(ADP),Br(Xy),Br(AGG),Br(JL),Br(AG5),Br(AB8),Br(R7),Br(AGl),Br(Fq),Br(AAo),Br(AE2),Br(AAg),Br(XR),Br(S0)]);};
let UK=B(0);
let X9=B(0);
let AHg=B(0);
let ADx=B(0);
let A88=B();
let ACR=B(0);
let AXn=B();
function Mp(){A.call(this);this.vL=null;}
let B2=null,A34=null,Bdq=null,EY=null,Eg=null,Gg=null,Pu=null,TS=null,A6X=null,BjX=null,A63=null;
let Cz=()=>{Cz=N(Mp);ALX();};
let AD1=a=>{Cz();L(a);a.vL=Cq(16);a.vL.data[0]=1.0;a.vL.data[5]=1.0;a.vL.data[10]=1.0;a.vL.data[15]=1.0;},
C0=()=>{let a=new Mp();AD1(a);return a;},
BjN=(a,b)=>{return a.nu(b.vL);},
APf=(a,b)=>{let c;c=b.data;a.vL.data[0]=c[0];a.vL.data[1]=c[1];a.vL.data[2]=c[2];a.vL.data[3]=c[3];a.vL.data[4]=c[4];a.vL.data[5]=c[5];a.vL.data[6]=c[6];a.vL.data[7]=c[7];a.vL.data[8]=c[8];a.vL.data[9]=c[9];a.vL.data[10]=c[10];a.vL.data[11]=c[11];a.vL.data[12]=c[12];a.vL.data[13]=c[13];a.vL.data[14]=c[14];a.vL.data[15]=c[15];return a;},
A4_=(a,b)=>{Cz();B2.data[0]=a.vL.data[0]*b.vL.data[0]+a.vL.data[4]*b.vL.data[1]+a.vL.data[8]*b.vL.data[2]+a.vL.data[12]*b.vL.data[3];B2.data[4]=a.vL.data[0]*b.vL.data[4]+a.vL.data[4]*b.vL.data[5]+a.vL.data[8]*b.vL.data[6]+a.vL.data[12]*b.vL.data[7];B2.data[8]=a.vL.data[0]*b.vL.data[8]+a.vL.data[4]*b.vL.data[9]+a.vL.data[8]*b.vL.data[10]+a.vL.data[12]*b.vL.data[11];B2.data[12]=a.vL.data[0]*b.vL.data[12]+a.vL.data[4]*b.vL.data[13]+a.vL.data[8]*b.vL.data[14]+a.vL.data[12]*b.vL.data[15];B2.data[1]=a.vL.data[1]*
b.vL.data[0]+a.vL.data[5]*b.vL.data[1]+a.vL.data[9]*b.vL.data[2]+a.vL.data[13]*b.vL.data[3];B2.data[5]=a.vL.data[1]*b.vL.data[4]+a.vL.data[5]*b.vL.data[5]+a.vL.data[9]*b.vL.data[6]+a.vL.data[13]*b.vL.data[7];B2.data[9]=a.vL.data[1]*b.vL.data[8]+a.vL.data[5]*b.vL.data[9]+a.vL.data[9]*b.vL.data[10]+a.vL.data[13]*b.vL.data[11];B2.data[13]=a.vL.data[1]*b.vL.data[12]+a.vL.data[5]*b.vL.data[13]+a.vL.data[9]*b.vL.data[14]+a.vL.data[13]*b.vL.data[15];B2.data[2]=a.vL.data[2]*b.vL.data[0]+a.vL.data[6]*b.vL.data[1]+a.vL.data[10]
*b.vL.data[2]+a.vL.data[14]*b.vL.data[3];B2.data[6]=a.vL.data[2]*b.vL.data[4]+a.vL.data[6]*b.vL.data[5]+a.vL.data[10]*b.vL.data[6]+a.vL.data[14]*b.vL.data[7];B2.data[10]=a.vL.data[2]*b.vL.data[8]+a.vL.data[6]*b.vL.data[9]+a.vL.data[10]*b.vL.data[10]+a.vL.data[14]*b.vL.data[11];B2.data[14]=a.vL.data[2]*b.vL.data[12]+a.vL.data[6]*b.vL.data[13]+a.vL.data[10]*b.vL.data[14]+a.vL.data[14]*b.vL.data[15];B2.data[3]=a.vL.data[3]*b.vL.data[0]+a.vL.data[7]*b.vL.data[1]+a.vL.data[11]*b.vL.data[2]+a.vL.data[15]*b.vL.data[3];B2.data[7]
=a.vL.data[3]*b.vL.data[4]+a.vL.data[7]*b.vL.data[5]+a.vL.data[11]*b.vL.data[6]+a.vL.data[15]*b.vL.data[7];B2.data[11]=a.vL.data[3]*b.vL.data[8]+a.vL.data[7]*b.vL.data[9]+a.vL.data[11]*b.vL.data[10]+a.vL.data[15]*b.vL.data[11];B2.data[15]=a.vL.data[3]*b.vL.data[12]+a.vL.data[7]*b.vL.data[13]+a.vL.data[11]*b.vL.data[14]+a.vL.data[15]*b.vL.data[15];return a.nu(B2);},
ATx=a=>{a.vL.data[0]=1.0;a.vL.data[4]=0.0;a.vL.data[8]=0.0;a.vL.data[12]=0.0;a.vL.data[1]=0.0;a.vL.data[5]=1.0;a.vL.data[9]=0.0;a.vL.data[13]=0.0;a.vL.data[2]=0.0;a.vL.data[6]=0.0;a.vL.data[10]=1.0;a.vL.data[14]=0.0;a.vL.data[3]=0.0;a.vL.data[7]=0.0;a.vL.data[11]=0.0;a.vL.data[15]=1.0;return a;},
A4X=(a,b,c,d,e)=>{a.nv(b,b+d,c,c+e,0.0,1.0);return a;},
A58=(a,b,c,d,e,f,g)=>{let h,i,j,k,l,m,n,o,p;a.nw();h=c-b;i=2.0/h;j=e-d;k=2.0/j;l=g-f;m=(-2.0)/l;n= -(c+b)/h;o= -(e+d)/j;p= -(g+f)/l;a.vL.data[0]=i;a.vL.data[1]=0.0;a.vL.data[2]=0.0;a.vL.data[3]=0.0;a.vL.data[4]=0.0;a.vL.data[5]=k;a.vL.data[6]=0.0;a.vL.data[7]=0.0;a.vL.data[8]=0.0;a.vL.data[9]=0.0;a.vL.data[10]=m;a.vL.data[11]=0.0;a.vL.data[12]=n;a.vL.data[13]=o;a.vL.data[14]=p;a.vL.data[15]=1.0;return a;},
AP7=(a,b,c,d)=>{a.nw();a.vL.data[12]=b;a.vL.data[13]=c;a.vL.data[14]=d;return a;},
AUK=(a,b,c)=>{Cz();(EY.cY(b)).nx();(Eg.cY(b)).nx();(Eg.ny(c)).nx();((Gg.cY(Eg)).ny(EY)).nx();a.nw();a.vL.data[0]=Eg.vZ;a.vL.data[4]=Eg.v1;a.vL.data[8]=Eg.v0;a.vL.data[1]=Gg.vZ;a.vL.data[5]=Gg.v1;a.vL.data[9]=Gg.v0;a.vL.data[2]= -EY.vZ;a.vL.data[6]= -EY.v1;a.vL.data[10]= -EY.v0;return a;},
AU7=(a,b,c,d)=>{Cz();(Pu.cY(c)).c1(b);a.nz(Pu,d);a.iU(TS.nA( -b.vZ, -b.v1, -b.v0));return a;},
AK2=(b,c)=>{let d,e,f,g;Cz();d=b.data;e=c.data;f=Cq(16);g=f.data;g[0]=d[0]*e[0]+d[4]*e[1]+d[8]*e[2]+d[12]*e[3];g[4]=d[0]*e[4]+d[4]*e[5]+d[8]*e[6]+d[12]*e[7];g[8]=d[0]*e[8]+d[4]*e[9]+d[8]*e[10]+d[12]*e[11];g[12]=d[0]*e[12]+d[4]*e[13]+d[8]*e[14]+d[12]*e[15];g[1]=d[1]*e[0]+d[5]*e[1]+d[9]*e[2]+d[13]*e[3];g[5]=d[1]*e[4]+d[5]*e[5]+d[9]*e[6]+d[13]*e[7];g[9]=d[1]*e[8]+d[5]*e[9]+d[9]*e[10]+d[13]*e[11];g[13]=d[1]*e[12]+d[5]*e[13]+d[9]*e[14]+d[13]*e[15];g[2]=d[2]*e[0]+d[6]*e[1]+d[10]*e[2]+d[14]*e[3];g[6]=d[2]*e[4]+d[6]
*e[5]+d[10]*e[6]+d[14]*e[7];g[10]=d[2]*e[8]+d[6]*e[9]+d[10]*e[10]+d[14]*e[11];g[14]=d[2]*e[12]+d[6]*e[13]+d[10]*e[14]+d[14]*e[15];g[3]=d[3]*e[0]+d[7]*e[1]+d[11]*e[2]+d[15]*e[3];g[7]=d[3]*e[4]+d[7]*e[5]+d[11]*e[6]+d[15]*e[7];g[11]=d[3]*e[8]+d[7]*e[9]+d[11]*e[10]+d[15]*e[11];g[15]=d[3]*e[12]+d[7]*e[13]+d[11]*e[14]+d[15]*e[15];C5(f,0,b,0,16);},
Be5=b=>{let c;Cz();c=b.data;return c[3]*c[6]*c[9]*c[12]-c[2]*c[7]*c[9]*c[12]-c[3]*c[5]*c[10]*c[12]+c[1]*c[7]*c[10]*c[12]+c[2]*c[5]*c[11]*c[12]-c[1]*c[6]*c[11]*c[12]-c[3]*c[6]*c[8]*c[13]+c[2]*c[7]*c[8]*c[13]+c[3]*c[4]*c[10]*c[13]-c[0]*c[7]*c[10]*c[13]-c[2]*c[4]*c[11]*c[13]+c[0]*c[6]*c[11]*c[13]+c[3]*c[5]*c[8]*c[14]-c[1]*c[7]*c[8]*c[14]-c[3]*c[4]*c[9]*c[14]+c[0]*c[7]*c[9]*c[14]+c[1]*c[4]*c[11]*c[14]-c[0]*c[5]*c[11]*c[14]-c[2]*c[5]*c[8]*c[15]+c[1]*c[6]*c[8]*c[15]+c[2]*c[4]*c[9]*c[15]-c[0]*c[6]*c[9]*c[15]-c[1]*
c[4]*c[10]*c[15]+c[0]*c[5]*c[10]*c[15];},
AVA=b=>{let c,d,e,f,g;Cz();c=Cq(16);d=Be5(b);if(d===0.0)return 0;e=c.data;f=b.data;e[0]=f[9]*f[14]*f[7]-f[13]*f[10]*f[7]+f[13]*f[6]*f[11]-f[5]*f[14]*f[11]-f[9]*f[6]*f[15]+f[5]*f[10]*f[15];e[4]=f[12]*f[10]*f[7]-f[8]*f[14]*f[7]-f[12]*f[6]*f[11]+f[4]*f[14]*f[11]+f[8]*f[6]*f[15]-f[4]*f[10]*f[15];e[8]=f[8]*f[13]*f[7]-f[12]*f[9]*f[7]+f[12]*f[5]*f[11]-f[4]*f[13]*f[11]-f[8]*f[5]*f[15]+f[4]*f[9]*f[15];e[12]=f[12]*f[9]*f[6]-f[8]*f[13]*f[6]-f[12]*f[5]*f[10]+f[4]*f[13]*f[10]+f[8]*f[5]*f[14]-f[4]*f[9]*f[14];e[1]=f[13]*f[10]
*f[3]-f[9]*f[14]*f[3]-f[13]*f[2]*f[11]+f[1]*f[14]*f[11]+f[9]*f[2]*f[15]-f[1]*f[10]*f[15];e[5]=f[8]*f[14]*f[3]-f[12]*f[10]*f[3]+f[12]*f[2]*f[11]-f[0]*f[14]*f[11]-f[8]*f[2]*f[15]+f[0]*f[10]*f[15];e[9]=f[12]*f[9]*f[3]-f[8]*f[13]*f[3]-f[12]*f[1]*f[11]+f[0]*f[13]*f[11]+f[8]*f[1]*f[15]-f[0]*f[9]*f[15];e[13]=f[8]*f[13]*f[2]-f[12]*f[9]*f[2]+f[12]*f[1]*f[10]-f[0]*f[13]*f[10]-f[8]*f[1]*f[14]+f[0]*f[9]*f[14];e[2]=f[5]*f[14]*f[3]-f[13]*f[6]*f[3]+f[13]*f[2]*f[7]-f[1]*f[14]*f[7]-f[5]*f[2]*f[15]+f[1]*f[6]*f[15];e[6]=f[12]
*f[6]*f[3]-f[4]*f[14]*f[3]-f[12]*f[2]*f[7]+f[0]*f[14]*f[7]+f[4]*f[2]*f[15]-f[0]*f[6]*f[15];e[10]=f[4]*f[13]*f[3]-f[12]*f[5]*f[3]+f[12]*f[1]*f[7]-f[0]*f[13]*f[7]-f[4]*f[1]*f[15]+f[0]*f[5]*f[15];e[14]=f[12]*f[5]*f[2]-f[4]*f[13]*f[2]-f[12]*f[1]*f[6]+f[0]*f[13]*f[6]+f[4]*f[1]*f[14]-f[0]*f[5]*f[14];e[3]=f[9]*f[6]*f[3]-f[5]*f[10]*f[3]-f[9]*f[2]*f[7]+f[1]*f[10]*f[7]+f[5]*f[2]*f[11]-f[1]*f[6]*f[11];e[7]=f[4]*f[10]*f[3]-f[8]*f[6]*f[3]+f[8]*f[2]*f[7]-f[0]*f[10]*f[7]-f[4]*f[2]*f[11]+f[0]*f[6]*f[11];e[11]=f[8]*f[5]*f[3]
-f[4]*f[9]*f[3]-f[8]*f[1]*f[7]+f[0]*f[9]*f[7]+f[4]*f[1]*f[11]-f[0]*f[5]*f[11];e[15]=f[4]*f[9]*f[2]-f[8]*f[5]*f[2]+f[8]*f[1]*f[6]-f[0]*f[9]*f[6]-f[4]*f[1]*f[10]+f[0]*f[5]*f[10];g=1.0/d;f[0]=e[0]*g;f[4]=e[4]*g;f[8]=e[8]*g;f[12]=e[12]*g;f[1]=e[1]*g;f[5]=e[5]*g;f[9]=e[9]*g;f[13]=e[13]*g;f[2]=e[2]*g;f[6]=e[6]*g;f[10]=e[10]*g;f[14]=e[14]*g;f[3]=e[3]*g;f[7]=e[7]*g;f[11]=e[11]*g;f[15]=e[15]*g;return 1;},
AZs=(b,c,d)=>{let e,f,g,h,i,j,k,l,m,n,o;Cz();e=b.data;f=c.data;g=d+0|0;h=f[g]*e[3];i=d+1|0;j=h+f[i]*e[7];k=d+2|0;l=1.0/(j+f[k]*e[11]+e[15]);m=(f[g]*e[0]+f[i]*e[4]+f[k]*e[8]+e[12])*l;n=(f[g]*e[1]+f[i]*e[5]+f[k]*e[9]+e[13])*l;o=(f[g]*e[2]+f[i]*e[6]+f[k]*e[10]+e[14])*l;f[g]=m;f[i]=n;f[k]=o;},
Bix=(b,c)=>{Cz();AK2(b,c);},
Bc8=(b,c,d,e,f)=>{let g;Cz();g=0;while(g<e){AZs(b,c,d);d=d+f|0;g=g+1|0;}},
AUI=b=>{Cz();return AVA(b);},
ALX=()=>{B2=Cq(16);A34=FI();Bdq=FI();EY=X();Eg=X();Gg=X();Pu=X();TS=C0();A6X=X();BjX=X();A63=X();};
let Qn=B();
let CN=null;
let Z7=()=>{Z7=N(Qn);Bem();};
let Bem=()=>{CN=Bp((Sa()).data.length);CN.data[Bl(K3)]=1;CN.data[Bl(Ng)]=2;CN.data[Bl(Pa)]=3;CN.data[Bl(HE)]=4;CN.data[Bl(Hf)]=5;CN.data[Bl(HY)]=6;CN.data[Bl(Ly)]=7;CN.data[Bl(L$)]=8;CN.data[Bl(OL)]=9;CN.data[Bl(Mo)]=10;};
let AIU=B(Bi);
let ACL=a=>{B9(a);},
AGU=()=>{let a=new AIU();ACL(a);return a;};
let AXg=B(BC);
let Wy=B(Fx);
let ABe=(a,b)=>{HP(a,b);},
AZv=a=>{let b=new Wy();ABe(b,a);return b;};
let AK6=B(Ds);
function XK(){Bd.call(this);this.GZ=0.0;}
let SO=(a,b)=>{BN(a);a.GZ=b*2.0;},
AWT=a=>{let b=new XK();SO(b,a);return b;};
function K5(){let a=this;A.call(a);a.Ao=null;a.A1=0;a.yj=null;a.zw=null;}
let ADe=(a,b)=>{Qd(a,b,1);},
Bi9=a=>{let b=new K5();ADe(b,a);return b;},
Qd=(a,b,c)=>{L(a);a.Ao=b;a.A1=c;},
BkV=(a,b)=>{let c=new K5();Qd(c,a,b);return c;},
AY1=a=>{if(Rr)return Iu(a.Ao,a.A1);if(a.yj===null){a.yj=Iu(a.Ao,a.A1);a.zw=Iu(a.Ao,a.A1);}if(a.yj.xy){a.zw.xX=0;a.zw.xy=1;a.yj.xy=0;return a.zw;}a.yj.xX=0;a.yj.xy=1;a.zw.xy=0;return a.yj;};
let NE=B(Bi);
let AE1=a=>{B9(a);},
IW=()=>{let a=new NE();AE1(a);return a;},
ACz=(a,b)=>{Dw(a,b);},
WM=a=>{let b=new NE();ACz(b,a);return b;};
let Vs=B();
let Bgo=(a,b,c)=>{a.nG(Ba(b),Cl(c,"handleEvent"));},
A62=(a,b)=>{return !!a.nH(b);},
APO=(a,b,c)=>{a.nI(Ba(b),Cl(c,"handleEvent"));},
A1n=(a,b,c,d)=>{a.nJ(Ba(b),Cl(c,"handleEvent"),d?1:0);},
Bbu=(a,b,c,d)=>{a.nK(Ba(b),Cl(c,"handleEvent"),d?1:0);};
let BhT=B();
function K1(){Gs.call(this);this.xJ=0;}
let X8=a=>{Pz(a);},
AUz=a=>{return AM8(a);};
let XM=B(D6);
let AC0=(a,b,c,d,e)=>{Im(a,b,c,d,e);},
AY8=(a,b,c,d)=>{let e=new XM();AC0(e,a,b,c,d);return e;},
Ba2=(a,b,c,d)=>{let e,f,g,h,i;e=a.yo.hy();f=a.yo.hz();g=0;while(true){if(g>=e){f:{while(true){h=a.vN.br(b,c,d);if(h>=0)break;if((b+a.v9.bw()|0)<=d.bq()){h=a.v9.bx(b,c);b=b+h|0;g=g+1|0;}if(h<1)break f;if(g>f)break f;}return h;}return (-1);}if((b+a.v9.bw()|0)>d.bq()){d.wZ=1;return (-1);}i=a.v9.bx(b,c);if(i<1)break;b=b+i|0;g=g+1|0;}return (-1);};
let A10=B(Ct);
function D9(){let a=this;CZ.call(a);a.wH=0;a.vS=null;a.yN=null;}
let R9=(a,b,c,d,e,f)=>{Fj(a,c);Dj();a.yN=Fu;a.wH=b;a.vS=d;a.vU=e;a.v4=f;},
DH=b=>{let c,d;if(b>=0)return A2C(b,1);c=new Ca;d=O();V(K(d,D(258)),b);Dy(c,S(d));I(c);},
Yg=(b,c,d)=>{let e;e=b.data.length;AIe(c,d,e);return AU6(0,e,b,c,c+d|0,0,0);},
ATu=b=>{return Yg(b,0,b.data.length);},
ARR=(a,b,c,d)=>{let e,f,g,h,i,j,k,l,m;if(c>=0){e=b.data;f=e.length;if(c<=f){g=c+d|0;if(g>f){h=new Bv;i=O();V(K(V(K(i,D(393)),g),D(260)),f);BB(h,S(i));I(h);}if(Bk(a)<d)I(PO());if(d<0){j=new Bv;h=O();K(V(K(h,D(261)),d),D(262));BB(j,S(h));I(j);}k=a.vU+a.wH|0;l=0;while(l<d){g=c+1|0;m=a.vS.data;f=k+1|0;e[c]=m[k];l=l+1|0;c=g;k=f;}a.vU=a.vU+d|0;return a;}}e=b.data;j=new Bv;f=e.length;h=O();BA(V(K(V(K(h,D(263)),c),D(35)),f),41);BB(j,S(h));I(j);},
Yf=a=>{return a.vS;},
DX=(a,b)=>{a.yN=b;return a;},
K2=a=>{FP(a);return a;},
AFX=a=>{GT(a);return a;},
AT8=(a,b)=>{HR(a,b);return a;},
Bcn=(a,b)=>{ER(a,b);return a;},
APU=a=>{return AFX(a);},
A8R=(a,b)=>{return a.fD(b);},
ALD=(a,b)=>{return a.fC(b);};
let XP=B(Bw);
let UV=a=>{Cd(a);},
AGc=()=>{let a=new XP();UV(a);return a;},
A2X=(a,b,c,d)=>{if(b&&!(d.ia()&&b==d.b5()))return (-1);return a.vN.br(b,c,d);},
AZ0=(a,b)=>{return 0;};
function Dd(){let a=this;A.call(a);a.vZ=0.0;a.v1=0.0;a.v0=0.0;}
let AQm=null,AQn=null,AQl=null,A44=null,BgK=null;
let IY=()=>{IY=N(Dd);ANa();};
let AAO=a=>{IY();L(a);},
X=()=>{let a=new Dd();AAO(a);return a;},
X2=(a,b,c,d)=>{IY();L(a);a.cW(b,c,d);},
Co=(a,b,c)=>{let d=new Dd();X2(d,a,b,c);return d;},
A3i=(a,b,c,d)=>{a.vZ=b;a.v1=c;a.v0=d;return a;},
ASt=(a,b)=>{return a.cW(b.vZ,b.v1,b.v0);},
Bdv=(a,b)=>{return a.nO(b.vZ,b.v1,b.v0);},
A16=(a,b,c,d)=>{return a.cW(a.vZ+b,a.v1+c,a.v0+d);},
A5G=(a,b)=>{return a.nP(b.vZ,b.v1,b.v0);},
Bb2=(a,b,c,d)=>{return a.cW(a.vZ-b,a.v1-c,a.v0-d);},
BaT=(a,b)=>{return a.cW(a.vZ*b,a.v1*b,a.v0*b);},
AQ4=a=>{return a.vZ*a.vZ+a.v1*a.v1+a.v0*a.v0;},
Bkm=a=>{let b;b=a.nQ();if(b!==0.0&&b!==1.0)return a.c0(1.0/BiN(b));return a;},
Bd6=(a,b)=>{return a.vZ*b.vZ+a.v1*b.v1+a.v0*b.v0;},
ASh=(a,b)=>{return a.cW(a.v1*b.v0-a.v0*b.v1,a.v0*b.vZ-a.vZ*b.v0,a.vZ*b.v1-a.v1*b.vZ);},
A4n=(a,b,c,d)=>{return a.cW(a.v1*d-a.v0*c,a.v0*b-a.vZ*d,a.vZ*c-a.v1*b);},
ANa=()=>{AQm=Co(1.0,0.0,0.0);AQn=Co(0.0,1.0,0.0);AQl=Co(0.0,0.0,1.0);A44=Co(0.0,0.0,0.0);BgK=C0();};
function Hg(){let a=this;A.call(a);a.GM=0.0;a.GL=0.0;}
let AMA=null,AMz=null,AXR=null;
let IX=()=>{IX=N(Hg);AQR();};
let AAT=a=>{IX();L(a);},
BF=()=>{let a=new Hg();AAT(a);return a;},
AEp=(a,b,c)=>{IX();L(a);a.GM=b;a.GL=c;},
KW=(a,b)=>{let c=new Hg();AEp(c,a,b);return c;},
AQR=()=>{AMA=KW(1.0,0.0);AMz=KW(0.0,1.0);AXR=KW(0.0,0.0);};
let AF1=B(0);
function KL(){let a=this;A.call(a);a.Hl=0.0;a.Hk=0.0;a.Hm=0.0;a.Hj=0.0;}
let Bdd=null,Bda=null,Bdb=null,Bdc=null,AQJ=null;
let N$=()=>{N$=N(KL);Bik();};
let AAU=(a,b,c,d,e)=>{N$();L(a);a.nT(b,c,d,e);},
F_=(a,b,c,d)=>{let e=new KL();AAU(e,a,b,c,d);return e;},
A7K=(a,b,c,d,e)=>{a.Hl=b;a.Hk=c;a.Hm=d;a.Hj=e;return a;},
Bik=()=>{Bdd=F_(1.0,0.0,0.0,0.0);Bda=F_(0.0,1.0,0.0,0.0);Bdb=F_(0.0,0.0,1.0,0.0);Bdc=F_(0.0,0.0,0.0,1.0);AQJ=F_(0.0,0.0,0.0,0.0);};
let BbP=B(BX);
function AEq(){let a=this;Fb.call(a);a.x1=null;a.xP=null;a.zf=0;}
let Uc=(a,b)=>{PK(a,b);},
A7q=a=>{let b=new AEq();Uc(b,a);return b;},
AVP=a=>{ALm(a);a.x1=a.wn;a.zf=a.zf+1|0;return a.wn;},
AQB=a=>{let b,c;a.zf=BT(0,a.zf-1|0);if(a.x1===null)return;a:{if(a.x1!==a.wn&&!a.zf){a.xP=a.x1;b=0;c=a.xP.data.length;while(true){if(b>=c)break a;a.xP.data[b]=null;b=b+1|0;}}}a.x1=null;},
ALm=a=>{if(a.x1!==null&&a.x1===a.wn){if(a.xP!==null&&a.xP.data.length>=a.v2){C5(a.wn,0,a.xP,0,a.v2);a.wn=a.xP;a.xP=null;}else a.hp(a.wn.data.length);return;}};
let AWV=B(DA);
function TV(){A.call(this);this.Fe=null;}
let AGu=(a,b)=>{L(a);a.Fe=b;},
K8=a=>{let b=new TV();AGu(b,a);return b;},
ADI=(a,b)=>{a.Fe.it(b);};
let ATk=B();
function AGv(){let a=this;GJ.call(a);a.De=0;a.CH=0;a.B5=null;}
let AIr=(a,b,c,d,e,f,g)=>{Oi(a,c,e,f);a.CH=b;a.De=g;a.B5=d;},
A7$=(a,b,c,d,e,f)=>{let g=new AGv();AIr(g,a,b,c,d,e,f);return g;},
AWl=(a,b)=>{return a.B5.data[b+a.CH|0];},
A0G=(a,b,c)=>{a.B5.data[b+a.CH|0]=c;},
AR6=a=>{return a.De;};
let AVo=B();
let XZ=B();
let AOG=null;
let OE=()=>{OE=N(XZ);ALJ();};
let UP=b=>{OE();return !(b&1)?0:1;},
ALJ=()=>{AOG=FM([1,4,2,1024,8,16,128,64,32,256,2048,512]);};
let AHG=B(0);
let FE=B(Gh);
let A3o=B(FE);
let Rx=B(W);
let AAz=a=>{Bn(a);},
A3O=()=>{let a=new Rx();AAz(a);return a;},
BgG=a=>{let b;b=AVv(a);b.v3=1;return b;};
let Li=B();
let U$=a=>{L(a);};
function If(){let a=this;Li.call(a);a.y$=0;a.wL=null;a.A7=0;a.Gi=0.0;a.B7=0;}
let AXu=(a,b)=>{return Bt(Ny,b);},
Vj=a=>{J0(a,16);},
M8=()=>{let a=new If();Vj(a);return a;},
J0=(a,b)=>{PS(a,b,0.75);},
AO6=a=>{let b=new If();J0(b,a);return b;},
AHc=b=>{let c,d;if(b>=1073741824)return 1073741824;if(!b)return 16;c=b-1|0;d=c|c>>1;d=d|d>>2;d=d|d>>4;d=d|d>>8;d=d|d>>16;return d+1|0;},
PS=(a,b,c)=>{let d;U$(a);if(b>=0&&c>0.0){d=AHc(b);a.y$=0;a.wL=a.nY(d);a.Gi=c;ADC(a);return;}I(CF());},
Blt=(a,b)=>{let c=new If();PS(c,a,b);return c;},
ADC=a=>{a.B7=a.wL.data.length*a.Gi|0;},
ANH=(a,b)=>{let c;c=MT(a,b);return c===null?0:1;},
BeI=(a,b)=>{let c;c=MT(a,b);if(c===null)return null;return c.yH;},
MT=(a,b)=>{let c,d,e;if(b===null)c=M4(a);else{d=b.hY();e=d&(a.wL.data.length-1|0);c=L6(a,b,e,d);}return c;},
L6=(a,b,c,d)=>{let e;e=a.wL.data[c];while(e!==null&&!(e.Cq==d&&ANh(b,e.ze))){e=e.zE;}return e;},
M4=a=>{let b;b=a.wL.data[0];while(b!==null&&b.ze!==null){b=b.zE;}return b;},
A5X=(a,b,c)=>{return BdU(a,b,c);},
BdU=(a,b,c)=>{let d,e,f,g,h;if(b===null){d=M4(a);if(d===null){a.A7=a.A7+1|0;d=ADg(a,null,0,0);e=a.y$+1|0;a.y$=e;if(e>a.B7)a.h0();}}else{f=b.hY();g=f&(a.wL.data.length-1|0);d=L6(a,b,g,f);if(d===null){a.A7=a.A7+1|0;d=ADg(a,b,g,f);e=a.y$+1|0;a.y$=e;if(e>a.B7)a.h0();}}h=d.yH;d.yH=c;return h;},
ADg=(a,b,c,d)=>{let e;e=Bbw(b,d);e.zE=a.wL.data[c];a.wL.data[c]=e;return e;},
AWL=(a,b)=>{let c,d,e,f,g,h,i;c=AHc(!b?1:b<<1);d=a.nY(c);e=0;while(e<a.wL.data.length){f=a.wL.data[e];a.wL.data[e]=null;while(f!==null){g=d.data;h=f.Cq&(c-1|0);i=f.zE;f.zE=g[h];g[h]=f;f=i;}e=e+1|0;}a.wL=d;ADC(a);},
A$3=a=>{a.n7(a.wL.data.length);},
ANh=(b,c)=>{return b!==c&&!b.bi(c)?0:1;};
function O1(){let a=this;A.call(a);a.IR=null;a.II=0;}
let AC_=a=>{Pq(a,1,16);},
AB6=()=>{let a=new O1();AC_(a);return a;},
Pq=(a,b,c)=>{L(a);a.II=b;a.IR=Cq(c);},
Bks=(a,b)=>{let c=new O1();Pq(c,a,b);return c;};
let BiK=B(Ju);
let BaV=B(Ey);
let Bcy=B(Ds);
function Q$(){let a=this;A.call(a);a.Cv=null;a.Cb=null;a.Cp=null;a.CF=null;a.CL=null;a.Eh=null;a.zg=null;a.B_=0;a.Ec=null;}
let Zt=(a,b,c,d)=>{L(a);a.Cv=Dl();a.Cb=Dl();a.Cp=Dl();a.CF=Dl();a.CL=Dl();a.Eh=Dl();a.zg=Dx();a.B_=(-1);a.Ec=b;BaS(a,c,d);},
A5z=(a,b,c)=>{let d=new Q$();Zt(d,a,b,c);return d;},
BaS=(a,b,c)=>{let d,e,f;d=c.n9();if(d.DQ!==null){e=b.ownerDocument;f=A9v(a);e.addEventListener("dragenter",Bu(f,"handleEvent"),!!0);f=AX4(a);e.addEventListener("dragover",Bu(f,"handleEvent"),!!0);f=AY_(a,c,d);e.addEventListener("drop",Bu(f,"handleEvent"));}},
AXU=a=>{let b,c;b=a.Ec;c=O();K(K(c,b),D(243));return S(c);},
A8H=(a,b,c)=>{let d,e,f;d=EE();e=a.oa();f=O();K(K(f,e),c);d.hh(1,S(f),A1G(a,c,b));},
AY0=(a,b)=>{if(a.oc(b.zj)){b.En=b.FX;b.CB=1;b.BZ=0;b.zs=0;return 0;}if(b.zs)return 0;b.BZ=0;b.CB=0;b.zs=1;a.od(1,b.zj,b.D5,b.DR,A_n(a,b));return 1;},
AYP=(a,b,c,d,e,f)=>{let g,h,i;g=EE();h=a.oa();i=O();K(K(i,h),c);g.of(b,S(i),d,e,AS5(a,f,d,c));},
ALW=(a,b,c,d)=>{let e,f,g;e=EE();f=a.oa();g=O();K(K(g,f),c);e.gT(b,S(g),d);},
AKZ=(a,b,c,d)=>{d:{Pw();switch(D7.data[Bl(b)]){case 1:break;case 2:a.Cb.bL(c,d);break d;case 3:a.CL.bL(c,d);break d;case 4:a.Cp.bL(c,d);break d;case 5:a.Cv.bL(c,null);break d;default:break d;}a.CF.bL(c,d);}},
AZo=(a,b)=>{let c,d;d:{if(!a.CF.lO(b)&&!a.Cb.lO(b)&&!a.CL.lO(b)&&!a.Cp.lO(b)){c=a.Cv;if(!c.lO(b)){d=0;break d;}}d=1;}return d;};
let ADn=B();
let Lf=Bg,Gv=null,G7=null;
let E6=()=>{E6=N(ADn);AXT();};
let AZX=(b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u;E6();d=APT(b);c.Dv=BS(Cp(d,C(0, 2147483648)),Bg)?0:1;e=Cp(d,C(4294967295, 1048575));f=U(BkY(d,52))&2047;if(BS(e,Bg)&&!f){c.Cj=Bg;c.By=0;return;}if(f)g=AUm(e,C(0, 1048576));else{g=Ef(e,1);while(BS(Cp(g,C(0, 1048576)),Bg)){g=Ef(g,1);f=f+(-1)|0;}}h=ANI(G7,f<<16>>16);if(h<0)h= -h|0;i=G7.data;j=h+1|0;k=f-i[j]|0;l=12+k|0;m=Ib(g,Gv.data[j],l);if(ATF(m,Lf)){while(CV(m,Lf)<=0){h=h+(-1)|0;m=B1(Bx(m,Q(10)),Q(9));}i=G7.data;j=h+1|0;n=f-i[j]|0;l=12+n|0;m=Ib(g,Gv.data[j],
l);}o=Ef(g,1);g=B1(o,Q(1));i=Gv.data;n=h+1|0;p=i[n];j=l-1|0;q=Ib(g,p,j);r=Ib(AZq(o,Q(1)),Gv.data[n],j);s=A9k(m,r);t=AN5(m,q);u=CV(s,t);g=u>0?Bx(CK(m,s),s):u<0?B1(Bx(CK(m,t),t),t):Bx(CK(B1(m,Ow(t,Q(2))),t),t);if(CV(g,C(2808348672, 232830643))>=0)while(true){h=h+1|0;g=CK(g,Q(10));if(CV(g,C(2808348672, 232830643))<0)break;}else if(CV(g,C(1569325056, 23283064))<0){h=h+(-1)|0;g=Bx(g,Q(10));}c.Cj=g;c.By=h-330|0;},
A9k=(b,c)=>{let d,e,f,g;E6();d=Q(1);while(true){e=Bx(d,Q(10));f=CK(b,e);g=CK(c,e);if(CV(f,g)<=0)break;d=e;}return d;},
AN5=(b,c)=>{let d,e,f,g;E6();d=Q(1);while(true){e=Bx(d,Q(10));f=CK(b,e);g=CK(c,e);if(CV(f,g)>=0)break;d=e;}return d;},
Ib=(b,c,d)=>{let e,f,g,h,i,j,k,l,m,n,o,p,q,r,s;E6();e=Cp(b,Q(65535));f=Cp(BV(b,16),Q(65535));g=Cp(BV(b,32),Q(65535));h=Cp(BV(b,48),Q(65535));i=Cp(c,Q(65535));j=Cp(BV(c,16),Q(65535));k=Cp(BV(c,32),Q(65535));l=Cp(BV(c,48),Q(65535));m=B1(B1(Bx(k,e),Bx(j,f)),Bx(i,g));n=B1(B1(B1(Bx(l,e),Bx(k,f)),Bx(j,g)),Bx(i,h));o=B1(B1(Bx(l,f),Bx(k,g)),Bx(j,h));p=B1(Bx(l,g),Bx(k,h));q=Bx(l,h);r=B1(B1(Ef(q,32+d|0),Ef(p,16+d|0)),Ef(o,d));s=B1(m,Ef(n,16));s=B1(r,BV(s,32-d|0));return s;},
AXT=()=>{Lf=CK(Q(-1),Q(10));Gv=TQ([C(3251292512, 2194092222),C(1766094183, 3510547556),C(553881887, 2808438045),C(443105509, 2246750436),C(3285949193, 3594800697),C(910772436, 2875840558),C(2446604867, 2300672446),C(2196580869, 3681075914),C(2616258154, 2944860731),C(1234013064, 2355888585),C(1974420903, 3769421736),C(720543263, 3015537389),C(1435428070, 2412429911),C(578697993, 3859887858),C(2180945313, 3087910286),C(885762791, 2470328229),C(3135207384, 3952525166),C(1649172448, 3162020133),C(3037324877, 2529616106),
C(3141732885, 4047385770),C(2513386308, 3237908616),C(1151715587, 2590326893),C(983751480, 4144523029),C(1645994643, 3315618423),C(3034782633, 2652494738),C(3996658754, 4243991581),C(2338333544, 3395193265),C(1870666835, 2716154612),C(4073513845, 2172923689),C(3940641775, 3476677903),C(575533043, 2781342323),C(2178413352, 2225073858),C(2626467905, 3560118173),C(3819161242, 2848094538),C(478348616, 2278475631),C(3342338164, 3645561009),C(3532863990, 2916448807),C(1108304273, 2333159046),C(55299919, 3733054474),
C(903233395, 2986443579),C(1581580175, 2389154863),C(1671534821, 3822647781),C(478234397, 3058118225),C(382587518, 2446494580),C(612140029, 3914391328),C(2207698941, 3131513062),C(48172235, 2505210450),C(77075576, 4008336720),C(61660460, 3206669376),C(3485302205, 2565335500),C(1281516232, 4104536801),C(166219527, 3283629441),C(3568949458, 2626903552),C(2274345296, 4203045684),C(2678469696, 3362436547),C(424788838, 2689949238),C(2057817989, 2151959390),C(3292508783, 3443135024),C(3493000485, 2754508019),C(3653393847, 2203606415),
C(1550462860, 3525770265),C(1240370288, 2820616212),C(3569276608, 2256492969),C(3133862195, 3610388751),C(1648096297, 2888311001),C(459483578, 2310648801),C(3312154103, 3697038081),C(1790729823, 2957630465),C(1432583858, 2366104372),C(3151127633, 3785766995),C(2520902106, 3028613596),C(1157728226, 2422890877),C(2711358621, 3876625403),C(3887073815, 3101300322),C(1391672133, 2481040258),C(1367681954, 3969664413),C(2812132482, 3175731530),C(2249705985, 2540585224),C(1022549199, 4064936359),C(1677032818, 3251949087),
C(3918606632, 2601559269),C(3692790234, 4162494831),C(2095238728, 3329995865),C(1676190982, 2663996692),C(3540899031, 4262394707),C(1114732307, 3409915766),C(32792386, 2727932613),C(1744220827, 2182346090),C(2790753324, 3491753744),C(3091596118, 2793402995),C(2473276894, 2234722396),C(2239256113, 3575555834),C(2650398349, 2860444667),C(402331761, 2288355734),C(2361717736, 3661369174),C(2748367648, 2929095339),C(3057687578, 2343276271),C(3174313206, 3749242034),C(3398444024, 2999393627),C(1000768301, 2399514902),
C(2460222741, 3839223843),C(3686165111, 3071379074),C(3807925548, 2457103259),C(3515700499, 3931365215),C(2812560399, 3145092172),C(532061401, 2516073738),C(4287272078, 4025717980),C(3429817663, 3220574384),C(3602847589, 2576459507),C(2328582306, 4122335212),C(144878926, 3297868170),C(115903141, 2638294536),C(2762425404, 4221271257),C(491953404, 3377017006),C(3829536560, 2701613604),C(3922622707, 2161290883),C(1122235577, 3458065414),C(1756781920, 2766452331),C(546432077, 2213161865),C(874291324, 3541058984),
C(1558426518, 2832847187),C(3823721592, 2266277749),C(3540974170, 3626044399),C(3691772795, 2900835519),C(3812411695, 2320668415),C(1804891416, 3713069465),C(1443913133, 2970455572),C(3732110884, 2376364457),C(2535403578, 3802183132),C(310335944, 3041746506),C(3684242592, 2433397204),C(3317807769, 3893435527),C(936259297, 3114748422),C(3325987815, 2491798737),C(1885606668, 3986877980),C(1508485334, 3189502384),C(2065781726, 2551601907),C(4164244222, 4082563051),C(2472401918, 3266050441),C(1118928075, 2612840353),
C(931291461, 4180544565),C(745033169, 3344435652),C(3173006913, 2675548521),C(3358824142, 4280877634),C(3546052773, 3424702107),C(1118855300, 2739761686),C(36090780, 2191809349),C(1775732167, 3506894958),C(3138572652, 2805515966),C(1651864662, 2244412773),C(1783990001, 3591060437),C(4004172378, 2872848349),C(4062331362, 2298278679),C(3922749802, 3677245887),C(1420212923, 2941796710),C(1136170338, 2353437368),C(958879082, 3765499789),C(1626096725, 3012399831),C(441883920, 2409919865),C(707014273, 3855871784),
C(1424604878, 3084697427),C(3716664280, 2467757941),C(4228675929, 3948412706),C(2523947284, 3158730165),C(2019157827, 2526984132),C(4089645983, 4043174611),C(2412723327, 3234539689),C(2789172121, 2587631751),C(2744688475, 4140210802),C(477763862, 3312168642),C(2959191467, 2649734913),C(3875712888, 4239575861),C(2241576851, 3391660689),C(2652254940, 2713328551),C(1262810493, 2170662841),C(302509870, 3473060546),C(3677981733, 2778448436),C(2083391927, 2222758749),C(756446706, 3556413999),C(1464150824, 2845131199),
C(2030314118, 2276104959),C(671522212, 3641767935),C(537217769, 2913414348),C(2147761134, 2330731478),C(2577424355, 3729170365),C(2061939484, 2983336292),C(4226531965, 2386669033),C(1608490388, 3818670454),C(2145785770, 3054936363),C(3434615534, 2443949090),C(1200417559, 3910318545),C(960334047, 3128254836),C(4204241074, 2502603868),C(1572824964, 4004166190),C(1258259971, 3203332952),C(3583588354, 2562666361),C(4015754449, 4100266178),C(635623181, 3280212943),C(2226485463, 2624170354),C(985396364, 4198672567),
C(3365297469, 3358938053),C(115257597, 2687150443),C(1810192996, 2149720354),C(319328417, 3439552567),C(2832443111, 2751642053),C(3983941407, 2201313642),C(2938332415, 3522101828),C(4068652850, 2817681462),C(1536935362, 2254145170),C(2459096579, 3606632272),C(249290345, 2885305818),C(1917419194, 2308244654),C(490890333, 3693191447),C(2969692644, 2954553157),C(657767197, 2363642526),C(3629407892, 3781828041),C(2044532855, 3025462433),C(3353613202, 2420369946),C(3647794205, 3872591914),C(3777228823, 3098073531),
C(2162789599, 2478458825),C(3460463359, 3965534120),C(2768370687, 3172427296),C(1355703090, 2537941837),C(3028118404, 4060706939),C(3281488183, 3248565551),C(1766197087, 2598852441),C(1107928421, 4158163906),C(27349277, 3326531125),C(21879422, 2661224900),C(35007075, 4257959840),C(28005660, 3406367872),C(2599384905, 2725094297),C(361521006, 2180075438),C(4014407446, 3488120700),C(3211525957, 2790496560),C(2569220766, 2232397248),C(3251759766, 3571835597),C(883420894, 2857468478),C(2424723634, 2285974782),C(443583977, 3657559652),
C(2931847559, 2926047721),C(1486484588, 2340838177),C(3237368801, 3745341083),C(12914663, 2996272867),C(2587312108, 2397018293),C(3280705914, 3835229269),C(3483558190, 3068183415),C(2786846552, 2454546732),C(1022980646, 3927274772),C(3395364895, 3141819817),C(998304997, 2513455854),C(3315274914, 4021529366),C(1793226472, 3217223493),C(3152568096, 2573778794),C(2467128576, 4118046071),C(1114709402, 3294436857),C(3468747899, 2635549485),C(1255029343, 4216879177),C(3581003852, 3373503341),C(2005809622, 2698802673),
C(3322634616, 2159042138),C(162254630, 3454467422),C(2706784082, 2763573937),C(447440347, 2210859150),C(715904555, 3537374640),C(572723644, 2829899712),C(3035159293, 2263919769),C(2279274491, 3622271631),C(964426134, 2897817305),C(771540907, 2318253844),C(2952452370, 3709206150),C(2361961896, 2967364920),C(1889569516, 2373891936),C(1305324308, 3798227098),C(2762246365, 3038581678),C(3927784010, 2430865342),C(2848480580, 3889384548),C(3996771382, 3111507638),C(620436728, 2489206111),C(3569679143, 3982729777),
C(1137756396, 3186183822),C(3487185494, 2548947057),C(2143522954, 4078315292),C(4291798741, 3262652233),C(856458615, 2610121787),C(2229327243, 4176194859),C(2642455254, 3340955887),C(395977285, 2672764710),C(633563656, 4276423536),C(3942824761, 3421138828),C(577279431, 2736911063),C(2179810463, 2189528850),C(3487696741, 3503246160),C(2790157393, 2802596928),C(3950112833, 2242077542),C(2884206696, 3587324068),C(4025352275, 2869859254),C(4079275279, 2295887403),C(1372879692, 3673419846),C(239310294, 2938735877),
C(2768428613, 2350988701),C(2711498862, 3761581922),C(451212171, 3009265538),C(2078956655, 2407412430),C(3326330649, 3851859888),C(84084141, 3081487911),C(3503241150, 2465190328),C(451225085, 3944304526),C(3796953905, 3155443620),C(3037563124, 2524354896),C(3142114080, 4038967834),C(3372684723, 3231174267),C(980160860, 2584939414),C(3286244294, 4135903062),C(911008517, 3308722450),C(728806813, 2646977960),C(1166090902, 4235164736),C(73879262, 3388131789),C(918096869, 2710505431),C(4170451332, 2168404344),C(4095741754, 3469446951),
C(2417599944, 2775557561),C(1075086496, 2220446049),C(3438125312, 3552713678),C(173519872, 2842170943),C(1856802816, 2273736754),C(393904128, 3637978807),C(2892103680, 2910383045),C(2313682944, 2328306436),C(1983905792, 3725290298),C(3305111552, 2980232238),C(67108864, 2384185791),C(2684354560, 3814697265),C(2147483648, 3051757812),C(0, 2441406250),C(0, 3906250000),C(0, 3125000000),C(0, 2500000000),C(0, 4000000000),C(0, 3200000000),C(0, 2560000000),C(0, 4096000000),C(0, 3276800000),C(0, 2621440000),C(0, 4194304000),
C(0, 3355443200),C(0, 2684354560),C(0, 2147483648),C(3435973836, 3435973836),C(1889785610, 2748779069),C(2370821947, 2199023255),C(3793315115, 3518437208),C(457671715, 2814749767),C(2943117749, 2251799813),C(3849994940, 3602879701),C(2221002492, 2882303761),C(917808535, 2305843009),C(3186480574, 3689348814),C(3408177918, 2951479051),C(1867548875, 2361183241),C(1270091283, 3777893186),C(157079567, 3022314549),C(984657113, 2417851639),C(3293438299, 3868562622),C(916763721, 3094850098),C(2451397895, 2475880078),
C(3063243173, 3961408125),C(2450594538, 3169126500),C(1960475630, 2535301200),C(3136761009, 4056481920),C(2509408807, 3245185536),C(1148533586, 2596148429),C(3555640657, 4153837486),C(1985519066, 3323069989),C(2447408712, 2658455991),C(2197867021, 4253529586),C(899300158, 3402823669),C(1578433585, 2722258935),C(1262746868, 2177807148),C(1161401530, 3484491437),C(3506101601, 2787593149),C(3663874740, 2230074519),C(3285219207, 3568119231),C(1769181906, 2854495385),C(1415345525, 2283596308),C(1405559381, 3653754093),
C(2842434423, 2923003274),C(3132940998, 2338402619),C(2435725219, 3741444191),C(1089586716, 2993155353),C(2589656291, 2394524282),C(707476229, 3831238852),C(3142961361, 3064991081),C(1655375629, 2451992865),C(2648601007, 3923188584),C(2977874265, 3138550867),C(664312493, 2510840694),C(2780886908, 4017345110),C(2224709526, 3213876088),C(3497754539, 2571100870),C(1301439967, 4113761393),C(2759138892, 3291009114),C(3066304573, 2632807291),C(3188100398, 4212491666),C(1691486859, 3369993333),C(3071176406, 2695994666),
C(1597947665, 2156795733),C(1697722806, 3450873173),C(3076165163, 2760698538),C(4178919049, 2208558830),C(2391303182, 3533694129),C(2772036005, 2826955303),C(3935615722, 2261564242),C(2861011319, 3618502788),C(4006795973, 2894802230),C(3205436779, 2315841784),C(2551718468, 3705346855),C(2041374775, 2964277484),C(2492093279, 2371421987),C(551375410, 3794275180),C(441100328, 3035420144),C(1211873721, 2428336115),C(1938997954, 3885337784),C(2410191822, 3108270227),C(210166539, 2486616182),C(1195259923, 3978585891),
C(97214479, 3182868713),C(1795758501, 2546294970),C(2873213602, 4074071952),C(580583963, 3259257562),C(3041447548, 2607406049),C(2289335700, 4171849679),C(2690462019, 3337479743),C(3870356534, 2669983794),C(3615590076, 4271974071),C(2033478602, 3417579257),C(4203763259, 2734063405),C(3363010607, 2187250724),C(2803836594, 3499601159),C(3102062734, 2799680927),C(763663269, 2239744742),C(2080854690, 3583591587),C(4241664129, 2866873269),C(4252324763, 2293498615),C(2508752324, 3669597785),C(2007001859, 2935678228),
C(3323588406, 2348542582),C(1881767613, 3757668132),C(4082394468, 3006134505),C(3265915574, 2404907604),C(2648484541, 3847852167),C(400800715, 3078281734),C(1179634031, 2462625387),C(2746407909, 3940200619),C(3056119786, 3152160495),C(2444895829, 2521728396),C(2193846408, 4034765434),C(2614070585, 3227812347),C(373269550, 2582249878),C(4033205117, 4131599804),C(4085557553, 3305279843),C(691465664, 2644223875),C(1106345063, 4230758200),C(885076050, 3384606560),C(708060840, 2707685248),C(2284435591, 2166148198),
C(2796103486, 3465837117),C(518895870, 2772669694),C(1274110155, 2218135755),C(2038576249, 3549017208),C(3348847917, 2839213766),C(1820084875, 2271371013),C(2053142340, 3634193621),C(783520413, 2907354897),C(3203796708, 2325883917),C(1690100896, 3721414268),C(3070067635, 2977131414),C(3315047567, 2381705131),C(3586089190, 3810728210),C(2868871352, 3048582568),C(4013084000, 2438866054),C(3843954022, 3902185687),C(1357176299, 3121748550),C(1085741039, 2497398840),C(1737185663, 3995838144),C(2248741989, 3196670515),
C(1798993591, 2557336412),C(3737383206, 4091738259),C(3848900024, 3273390607),C(1361133101, 2618712486),C(459826043, 4189939978),C(2085847752, 3351951982),C(4245658579, 2681561585),C(2498086431, 4290498537),C(280482227, 3432398830),C(224385781, 2745919064),C(1038502084, 2196735251),C(4238583712, 3514776401),C(2531873511, 2811821121),C(1166505349, 2249456897),C(2725402018, 3599131035),C(2180321615, 2879304828),C(3462244210, 2303443862),C(2103616899, 3685510180),C(1682893519, 2948408144),C(2205308275, 2358726515),
C(3528493240, 3773962424),C(3681788051, 3019169939),C(3804423900, 2415335951),C(74124026, 3864537523),C(1777286139, 3091630018),C(3139815829, 2473304014),C(2446724950, 3957286423),C(3675366878, 3165829138),C(363313125, 2532663311),C(3158281377, 4052261297),C(808638183, 3241809038),C(2364897465, 2593447230),C(3783835944, 4149515568),C(450088378, 3319612455),C(360070702, 2655689964),C(2294100042, 4249103942),C(117293115, 3399283154),C(952827951, 2719426523),C(2480249279, 2175541218),C(3109405388, 3480865949),
C(3346517769, 2784692759),C(3536207675, 2227754207),C(2221958443, 3564406732),C(59579836, 2851525386),C(3483637705, 2281220308),C(419859574, 3649952494),C(1194881118, 2919961995),C(955904894, 2335969596),C(4106428209, 3737551353),C(708162189, 2990041083),C(2284516670, 2392032866),C(1937239754, 3827252586),C(690798344, 3061802069),C(1411632134, 2449441655),C(2258611415, 3919106648),C(3524876050, 3135285318),C(242920462, 2508228255),C(388672740, 4013165208),C(2028925110, 3210532166),C(764146629, 2568425733),C(363641147, 4109481173),
C(2008899836, 3287584938),C(3325106787, 2630067950),C(1025203564, 4208108721),C(4256136688, 3366486976),C(2545915891, 2693189581),C(1177739254, 2154551665),C(1884382806, 3447282664),C(2366499704, 2757826131),C(1034206304, 2206260905),C(1654730086, 3530017448),C(3041770987, 2824013958),C(4151403708, 2259211166),C(629291719, 3614737867),C(3080413753, 2891790293),C(4182317920, 2313432234),C(4114728295, 3701491575),C(3291782636, 2961193260),C(2633426109, 2368954608),C(3354488315, 3790327373),C(106610275, 3032261899),
C(944281679, 2425809519),C(3228837605, 3881295230),C(2583070084, 3105036184),C(2925449526, 2484028947),C(1244745405, 3974446316),C(136802865, 3179557053),C(1827429210, 2543645642),C(3782880196, 4069833027),C(1308317238, 3255866422),C(3623634168, 2604693137),C(2361840832, 4167509020),C(1889472666, 3334007216),C(652584673, 2667205773),C(185142018, 4267529237),C(2725093992, 3414023389),C(3039068653, 2731218711),C(1572261463, 2184974969),C(4233605259, 3495959950),C(3386884207, 2796767960),C(2709507366, 2237414368),
C(3476218326, 3579862989),C(3639968120, 2863890391),C(2052981037, 2291112313),C(2425776200, 3665779701),C(1081627501, 2932623761),C(6308541, 2346099009),C(1728080585, 3753758414),C(2241457927, 3003006731),C(934172882, 2402405385),C(1494676612, 3843848616),C(336747830, 3075078893),C(1987385183, 2460063114),C(602835915, 3936100983),C(2200255650, 3148880786),C(901211061, 2519104629),C(3159924616, 4030567406),C(1668946233, 3224453925),C(1335156987, 2579563140),C(2136251179, 4127301024),C(2567994402, 3301840819),
C(2913388981, 2641472655),C(366455074, 4226356249),C(1152157518, 3381084999),C(1780719474, 2704867999),C(2283569038, 2163894399),C(1076730083, 3462231039),C(1720377526, 2769784831),C(517308561, 2215827865),C(827693699, 3545324584),C(1521148418, 2836259667),C(3793899112, 2269007733),C(916277824, 3630412374),C(1592015718, 2904329899),C(2132606034, 2323463919),C(835189277, 3717542271),C(4104125258, 2974033816),C(2424306747, 2379227053),C(3019897337, 3806763285),C(2415917869, 3045410628),C(3650721214, 2436328502),
C(2405180105, 3898125604),C(2783137543, 3118500483),C(3944496953, 2494800386),C(298240911, 3991680619),C(1097586188, 3193344495),C(878068950, 2554675596),C(3981890698, 4087480953),C(608532181, 3269984763),C(2204812663, 2615987810),C(3527700261, 4185580496),C(1963166749, 3348464397),C(4147513777, 2678771517),C(3200048207, 4286034428),C(4278025484, 3428827542),C(1704433468, 2743062034),C(2222540234, 2194449627),C(120090538, 3511119404),C(955065889, 2808895523),C(2482039630, 2247116418),C(3112269949, 3595386269),
C(3348809418, 2876309015),C(2679047534, 2301047212),C(850502218, 3681675540),C(680401775, 2945340432),C(3121301797, 2356272345),C(699115580, 3770035753),C(2277279382, 3016028602),C(103836587, 2412822882),C(1025131999, 3860516611),C(4256079436, 3088413288),C(827883168, 2470730631),C(3901593088, 3953169009)]);G7=BlL([(-70),(-66),(-63),(-60),(-56),(-53),(-50),(-46),(-43),(-40),(-36),(-33),(-30),(-26),(-23),(-20),(-16),(-13),(-10),(-6),(-3),0,4,7,10,14,17,20,23,27,30,33,37,40,43,47,50,53,57,60,63,67,70,73,77,80,
83,87,90,93,97,100,103,107,110,113,116,120,123,126,130,133,136,140,143,146,150,153,156,160,163,166,170,173,176,180,183,186,190,193,196,200,203,206,210,213,216,219,223,226,229,233,236,239,243,246,249,253,256,259,263,266,269,273,276,279,283,286,289,293,296,299,303,306,309,312,316,319,322,326,329,332,336,339,342,346,349,352,356,359,362,366,369,372,376,379,382,386,389,392,396,399,402,406,409,412,415,419,422,425,429,432,435,439,442,445,449,452,455,459,462,465,469,472,475,479,482,485,489,492,495,499,502,505,508,512,
515,518,522,525,528,532,535,538,542,545,548,552,555,558,562,565,568,572,575,578,582,585,588,592,595,598,601,605,608,611,615,618,621,625,628,631,635,638,641,645,648,651,655,658,661,665,668,671,675,678,681,685,688,691,695,698,701,704,708,711,714,718,721,724,728,731,734,738,741,744,748,751,754,758,761,764,768,771,774,778,781,784,788,791,794,797,801,804,807,811,814,817,821,824,827,831,834,837,841,844,847,851,854,857,861,864,867,871,874,877,881,884,887,891,894,897,900,904,907,910,914,917,920,924,927,930,934,937,
940,944,947,950,954,957,960,964,967,970,974,977,980,984,987,990,993,997,1000,1003,1007,1010,1013,1017,1020,1023,1027,1030,1033,1037,1040,1043,1047,1050,1053,1057,1060,1063,1067,1070,1073,1077,1080,1083,1086,1090,1093,1096,1100,1103,1106,1110,1113,1116,1120,1123,1126,1130,1133,1136,1140,1143,1146,1150,1153,1156,1160,1163,1166,1170,1173,1176,1180,1183,1186,1189,1193,1196,1199,1203,1206,1209,1213,1216,1219,1223,1226,1229,1233,1236,1239,1243,1246,1249,1253,1256,1259,1263,1266,1269,1273,1276,1279,1282,1286,1289,
1292,1296,1299,1302,1306,1309,1312,1316,1319,1322,1326,1329,1332,1336,1339,1342,1346,1349,1352,1356,1359,1362,1366,1369,1372,1376,1379,1382,1385,1389,1392,1395,1399,1402,1405,1409,1412,1415,1419,1422,1425,1429,1432,1435,1439,1442,1445,1449,1452,1455,1459,1462,1465,1469,1472,1475,1478,1482,1485,1488,1492,1495,1498,1502,1505,1508,1512,1515,1518,1522,1525,1528,1532,1535,1538,1542,1545,1548,1552,1555,1558,1562,1565,1568,1572,1575,1578,1581,1585,1588,1591,1595,1598,1601,1605,1608,1611,1615,1618,1621,1625,1628,1631,
1635,1638,1641,1645,1648,1651,1655,1658,1661,1665,1668,1671,1674,1678,1681,1684,1688,1691,1694,1698,1701,1704,1708,1711,1714,1718,1721,1724,1728,1731,1734,1738,1741,1744,1748,1751,1754,1758,1761,1764,1767,1771,1774,1777,1781,1784,1787,1791,1794,1797,1801,1804,1807,1811,1814,1817,1821,1824,1827,1831,1834,1837,1841,1844,1847,1851,1854,1857,1861,1864,1867,1870,1874,1877,1880,1884,1887,1890,1894,1897,1900,1904,1907,1910,1914,1917,1920,1924,1927,1930,1934,1937,1940,1944,1947,1950,1954,1957,1960,1963,1967,1970,1973,
1977,1980,1983,1987,1990,1993,1997,2000,2003,2007,2010,2013,2017,2020,2023,2027,2030,2033,2037,2040,2043,2047,2050,2053,2057,2060,2063,2066,2070,2073,2076,2080,2083,2086,2090,2093,2096,2100,2103,2106,2110,2113,2116,2120]);};
function OW(){let a=this;A.call(a);a.yZ=0;a.z_=0;}
let Eu=null,EM=null;
let CJ=()=>{CJ=N(OW);ATU();};
let UC=(a,b,c)=>{CJ();L(a);a.yZ=b;a.z_=c;},
K6=(a,b)=>{let c=new OW();UC(c,a,b);return c;},
A5y=a=>{return a.yZ?0:1;},
Bex=a=>{return a.yZ!=1?0:1;},
A17=a=>{return !a.lg()&&!a.lh()?0:1;},
AXJ=a=>{return a.yZ!=2?0:1;},
Be3=a=>{return a.yZ!=3?0:1;},
AU3=a=>{if(a.lo())return a.z_;I(BdX());},
E_=b=>{CJ();return K6(2,b);},
A__=a=>{switch(a.yZ){case 0:I(AVa());case 1:I(BhW());case 2:I(AQk(a.z_));case 3:I(AVd(a.z_));default:}},
ATU=()=>{Eu=K6(0,0);EM=K6(1,0);};
function PG(){Bw.call(this);this.yJ=0;}
let O8=(a,b)=>{Cd(a);a.yJ=b;},
Ba7=a=>{let b=new PG();O8(b,a);return b;},
A99=(a,b,c,d)=>{let e,f,g,h;e=!d.ia()?c.bb():d.bq();if(b>=e){d.c7(a.yJ,0);return a.vN.br(b,c,d);}f=e-b|0;if(f==2&&c.bc(b)==13){g=b+1|0;if(c.bc(g)==10){d.c7(a.yJ,0);return a.vN.br(b,c,d);}}f:{if(f==1){h=c.bc(b);if(h==10)break f;if(h==13)break f;if(h==133)break f;if((h|1)==8233)break f;}return (-1);}d.c7(a.yJ,0);return a.vN.br(b,c,d);},
AQU=(a,b)=>{let c;c=!b.bS(a.yJ)?0:1;b.c7(a.yJ,(-1));return c;};
function JI(){A.call(this);this.vW=null;}
let Nk=a=>{L(a);a.vW=A7q(4);},
BkP=()=>{let a=new JI();Nk(a);return a;},
X_=(a,b)=>{let c,d,e,f,$$je;c=a.vW.on();d:{try{d=0;e=a.vW.v2;}catch($$e){$$je=Bb($$e);f=$$je;break d;}a:{try{while(d<e){if(c.data[d].oo(b))break a;d=d+1|0;}}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(f);},
Qg=(a,b)=>{let c,d,e,f,$$je;c=a.vW.on();d:{try{d=0;e=a.vW.v2;}catch($$e){$$je=Bb($$e);f=$$je;break d;}a:{try{while(d<e){if(c.data[d].oq(b))break a;d=d+1|0;}}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(f);},
Qq=(a,b)=>{let c,d,e,f,$$je;c=a.vW.on();d:{try{d=0;e=a.vW.v2;}catch($$e){$$je=Bb($$e);f=$$je;break d;}a:{try{while(d<e){if(c.data[d].or(b))break a;d=d+1|0;}}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);f=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(f);},
R3=(a,b,c,d,e)=>{let f,g,h,i,$$je;f=a.vW.on();d:{try{g=0;h=a.vW.v2;}catch($$e){$$je=Bb($$e);i=$$je;break d;}a:{try{while(g<h){if(f.data[g].os(b,c,d,e))break a;g=g+1|0;}}catch($$e){$$je=Bb($$e);i=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);i=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(i);},
AEE=(a,b,c,d,e)=>{let f,g,h,i,$$je;f=a.vW.on();d:{try{g=0;h=a.vW.v2;}catch($$e){$$je=Bb($$e);i=$$je;break d;}a:{try{while(g<h){if(f.data[g].ot(b,c,d,e))break a;g=g+1|0;}}catch($$e){$$je=Bb($$e);i=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);i=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(i);},
Wd=(a,b,c,d)=>{let e,f,g,h,$$je;e=a.vW.on();d:{try{f=0;g=a.vW.v2;}catch($$e){$$je=Bb($$e);h=$$je;break d;}a:{try{while(f<g){if(e.data[f].ou(b,c,d))break a;f=f+1|0;}}catch($$e){$$je=Bb($$e);h=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);h=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(h);},
AGr=(a,b,c)=>{let d,e,f,g,$$je;d=a.vW.on();d:{try{e=0;f=a.vW.v2;}catch($$e){$$je=Bb($$e);g=$$je;break d;}a:{try{while(e<f){if(d.data[e].ov(b,c))break a;e=e+1|0;}}catch($$e){$$je=Bb($$e);g=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);g=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(g);},
AA8=(a,b,c)=>{let d,e,f,g,$$je;d=a.vW.on();d:{try{e=0;f=a.vW.v2;}catch($$e){$$je=Bb($$e);g=$$je;break d;}a:{try{while(e<f){if(d.data[e].ow(b,c))break a;e=e+1|0;}}catch($$e){$$je=Bb($$e);g=$$je;break d;}a.vW.op();return 0;}try{}catch($$e){$$je=Bb($$e);g=$$je;break d;}a.vW.op();return 1;}a.vW.op();I(g);};
function AGN(){let a=this;JI.call(a);a.xg=null;a.yi=null;}
let W5=a=>{Nk(a);a.yi=AIS();a.xg=A1X();},
A2t=()=>{let a=new AGN();W5(a);return a;},
A6Q=(a,b,c,d,e)=>{if(a.xg.os(b,c,d,e)){R3(a,b,c,d,e);return 1;}if(a.yi.wk>0)A0m(a);return 0;},
AQi=(a,b,c,d)=>{if(!a.xg.ou(b,c,d))return 0;Wd(a,b,c,d);return 1;},
AXv=(a,b,c,d,e)=>{a.xg.ot(b,c,d,e);AEE(a,b,c,d,e);return 0;},
AXb=(a,b)=>{if(!a.xg.or(b))return 0;Qq(a,b);return 1;},
A5w=(a,b)=>{if(!a.xg.oo(b))return 0;a.yi.nc(b);X_(a,b);return 1;},
BeY=(a,b)=>{if(!a.xg.oq(b))return 0;a.yi.oy(b);Qg(a,b);return 1;},
ASL=(a,b,c)=>{if(!a.xg.ow(b,c))return 0;AA8(a,b,c);return 1;},
ANz=(a,b,c)=>{a.xg.ov(b,c);AGr(a,b,c);return 0;},
A0m=a=>{let b;b=0;while(b<a.yi.wk){Qg(a,a.yi.l8(b));b=b+1|0;}a.yi.nb();};
function ACa(){let a=this;A.call(a);a.vV=null;a.yI=0;a.w$=0;a.FV=0;a.BW=0;a.w4=0;a.vP=0;a.E2=0;a.yX=null;a.xD=null;a.vQ=0;a.zU=0;a.zY=0;a.zm=0;a.DJ=null;}
let AUA=null,AOF=null,BaD=0;
let AGp=(a,b,c)=>{L(a);a.w$=1;a.DJ=b;if((c&16)>0)b=A1x(b);else if((c&128)>0)b=ARO(b);a.vV=Cr(b.bb()+2|0);C5(b.dg(),0,a.vV,0,b.bb());a.vV.data[a.vV.data.length-1|0]=0;a.vV.data[a.vV.data.length-2|0]=0;a.E2=a.vV.data.length;a.yI=c;EF(a);EF(a);},
AUY=(a,b)=>{let c=new ACa();AGp(c,a,b);return c;},
A2i=a=>{return a.w4;},
AP_=(a,b)=>{if(b>0&&b<3)a.w$=b;if(b==1)AXH(a);},
APs=(a,b)=>{a.yI=b;a.vP=a.w4;a.xD=a.yX;a.vQ=a.zY+1|0;a.zm=a.zY;EF(a);},
ASB=a=>{return a.yX;},
A9G=a=>{return a.yX===null?0:1;},
APk=a=>{return a.xD===null?0:1;},
A_y=a=>{EF(a);return a.BW;},
AQ8=a=>{let b;b=a.yX;EF(a);return b;},
AM$=a=>{return a.vP;},
AU1=a=>{return a.BW;},
ARO=b=>{return b;},
AXH=a=>{a.vP=a.w4;a.xD=a.yX;a.vQ=a.zm;a.zm=a.zY;EF(a);},
EF=a=>{let b,c,d,e,f,g,h,$$je;a.BW=a.w4;a.w4=a.vP;a.yX=a.xD;a.zY=a.zm;a.zm=a.vQ;while(true){b=0;a.vP=a.vQ>=a.vV.data.length?0:OG(a);a.xD=null;if(a.w$==4){if(a.vP!=92)return;a.vP=a.vQ>=a.vV.data.length?0:a.vV.data[BK(a)];switch(a.vP){case 69:break;default:a.vP=92;a.vQ=a.zU;return;}a.w$=a.FV;a.vP=a.vQ>(a.vV.data.length-2|0)?0:OG(a);}k:{if(a.vP!=92){if(a.w$==1)switch(a.vP){case 36:a.vP=(-536870876);break k;case 40:if(a.vV.data[a.vQ]!=63){a.vP=(-2147483608);break k;}BK(a);c=a.vV.data[a.vQ];d=0;while(true){l:{if
(d){d=0;switch(c){case 33:break;case 61:a.vP=(-134217688);BK(a);break l;default:I(BJ(D(37),a.y(),a.vQ));}a.vP=(-67108824);BK(a);}else{switch(c){case 33:break;case 60:BK(a);c=a.vV.data[a.vQ];d=1;break l;case 61:a.vP=(-536870872);BK(a);break l;case 62:a.vP=(-33554392);BK(a);break l;default:a.vP=BiJ(a);if(a.vP<256){a.yI=a.vP;a.vP=a.vP<<16;a.vP=(-1073741784)|a.vP;break l;}a.vP=a.vP&255;a.yI=a.vP;a.vP=a.vP<<16;a.vP=(-16777176)|a.vP;break l;}a.vP=(-268435416);BK(a);}}if(!d)break;}break k;case 41:a.vP=(-536870871);break k;case 42:case 43:case 63:e
=a.vQ>=a.vV.data.length?42:a.vV.data[a.vQ];switch(e){case 43:a.vP=a.vP|(-2147483648);BK(a);break k;case 63:a.vP=a.vP|(-1073741824);BK(a);break k;default:}a.vP=a.vP|(-536870912);break k;case 46:a.vP=(-536870866);break k;case 91:a.vP=(-536870821);a.oH(2);break k;case 93:if(a.w$!=2)break k;a.vP=(-536870819);break k;case 94:a.vP=(-536870818);break k;case 123:a.xD=BeJ(a,a.vP);break k;case 124:a.vP=(-536870788);break k;default:}else if(a.w$==2)switch(a.vP){case 38:a.vP=(-536870874);break k;case 45:a.vP=(-536870867);break k;case 91:a.vP
=(-536870821);break k;case 93:a.vP=(-536870819);break k;case 94:a.vP=(-536870818);break k;default:}}else{f=a.vQ>=(a.vV.data.length-2|0)?(-1):OG(a);m:{a.vP=f;switch(a.vP){case -1:I(BJ(D(37),a.y(),a.vQ));case 0:case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:case 10:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:case 21:case 22:case 23:case 24:case 25:case 26:case 27:case 28:case 29:case 30:case 31:case 32:case 33:case 34:case 35:case 36:case 37:case 38:case 39:case 40:case 41:case 42:case 43:case 44:case 45:case 46:case 47:case 58:case 59:case 60:case 61:case 62:case 63:case 64:case 91:case 92:case 93:case 94:case 95:case 96:case 118:break;case 48:a.vP
=A7e(a);break k;case 49:case 50:case 51:case 52:case 53:case 54:case 55:case 56:case 57:if(a.w$!=1)break k;a.vP=(-2147483648)|a.vP;break k;case 65:a.vP=(-2147483583);break k;case 66:a.vP=(-2147483582);break k;case 67:case 69:case 70:case 72:case 73:case 74:case 75:case 76:case 77:case 78:case 79:case 82:case 84:case 85:case 86:case 88:case 89:case 103:case 104:case 105:case 106:case 107:case 108:case 109:case 111:case 113:case 121:I(BJ(D(37),a.y(),a.vQ));case 68:case 83:case 87:case 100:case 115:case 119:a.xD
=ZL(Lg(a.vV,a.zU,1),0);a.vP=0;break k;case 71:a.vP=(-2147483577);break k;case 80:case 112:break m;case 81:a.FV=a.w$;a.w$=4;b=1;break k;case 90:a.vP=(-2147483558);break k;case 97:a.vP=7;break k;case 98:a.vP=(-2147483550);break k;case 99:if(a.vQ>=(a.vV.data.length-2|0))I(BJ(D(37),a.y(),a.vQ));a.vP=a.vV.data[BK(a)]&31;break k;case 101:a.vP=27;break k;case 102:a.vP=12;break k;case 110:a.vP=10;break k;case 114:a.vP=13;break k;case 116:a.vP=9;break k;case 117:a.vP=Ve(a,4);break k;case 120:a.vP=Ve(a,2);break k;case 122:a.vP
=(-2147483526);break k;default:}break k;}g=A53(a);h=0;if(a.vP==80)h=1;try{a.xD=ZL(g,h);}catch($$e){$$je=Bb($$e);if($$je instanceof Kj){I(BJ(D(37),a.y(),a.vQ));}else{throw $$e;}}a.vP=0;}}if(b)continue;else break;}},
A53=a=>{let b,c,d,e,f;b=Iy(10);if(a.vQ<(a.vV.data.length-2|0)){if(a.vV.data[a.vQ]!=123){c=Lg(a.vV,BK(a),1);d=O();K(K(d,D(394)),c);return S(d);}BK(a);e=0;b:{while(a.vQ<(a.vV.data.length-2|0)){e=a.vV.data[BK(a)];if(e==125)break b;b.cF(e);}}if(e!=125)I(BJ(D(37),a.y(),a.vQ));}if(!b.bb())I(BJ(D(37),a.y(),a.vQ));f=b.y();if(f.bb()==1){c=O();K(K(c,D(394)),f);return S(c);}n:{o:{if(f.bb()>3){if(f.oN(D(394)))break o;if(f.oN(D(395)))break o;}break n;}f=f.eG(2);}return f;},
BeJ=(a,b)=>{let c,d,e,f,$$je;c=Iy(4);d=(-1);e=2147483647;d:{while(true){if(a.vQ>=a.vV.data.length)break d;b=a.vV.data[BK(a)];if(b==125)break d;if(b==44&&d<0)try{d=Hh(c.y(),10);c.oO(0,c.bb());continue;}catch($$e){$$je=Bb($$e);if($$je instanceof B$){break;}else{throw $$e;}}c.cF(b&65535);}I(BJ(D(37),a.y(),a.vQ));}if(b!=125)I(BJ(D(37),a.y(),a.vQ));if(c.bb()>0)p:{try{e=Hh(c.y(),10);if(d>=0)break p;d=e;break p;}catch($$e){$$je=Bb($$e);if($$je instanceof B$){}else{throw $$e;}}I(BJ(D(37),a.y(),a.vQ));}else if(d<0)I(BJ(D(37),
a.y(),a.vQ));if((d|e|(e-d|0))<0)I(BJ(D(37),a.y(),a.vQ));f=a.vQ>=a.vV.data.length?42:a.vV.data[a.vQ];q:{switch(f){case 43:a.vP=(-2147483525);BK(a);break q;case 63:a.vP=(-1073741701);BK(a);break q;default:}a.vP=(-536870789);}return A9A(d,e);},
AWm=a=>{return a.DJ;},
AY9=a=>{return !a.w4&&!a.vP&&a.vQ==a.E2&&!a.oP()?1:0;},
H1=b=>{return b<0?0:1;},
Bhf=a=>{return !a.cd()&&!a.oP()&&H1(a.w4)?1:0;},
AOH=a=>{return a.w4<=56319&&a.w4>=55296?1:0;},
A_s=a=>{return a.w4<=57343&&a.w4>=56320?1:0;},
Nb=b=>{return b<=56319&&b>=55296?1:0;},
Ln=b=>{return b<=57343&&b>=56320?1:0;},
Ve=(a,b)=>{let c,d,e,f,$$je;c=Iy(b);d=a.vV.data.length-2|0;e=0;while(true){f=CA(e,b);if(f>=0)break;if(a.vQ>=d)break;c.cF(a.vV.data[BK(a)]);e=e+1|0;}if(!f)b:{try{f=Hh(c.y(),16);}catch($$e){$$je=Bb($$e);if($$je instanceof B$){break b;}else{throw $$e;}}return f;}I(BJ(D(37),a.y(),a.vQ));},
A7e=a=>{let b,c,d,e,f;b=3;c=1;d=a.vV.data.length-2|0;e=ADw(a.vV.data[a.vQ],8);switch(e){case -1:break;default:if(e>3)b=2;BK(a);c:{while(true){if(c>=b)break c;if(a.vQ>=d)break c;f=ADw(a.vV.data[a.vQ],8);if(f<0)break;e=(e*8|0)+f|0;BK(a);c=c+1|0;}}return e;}I(BJ(D(37),a.y(),a.vQ));},
BiJ=a=>{let b,c,d;b=1;c=a.yI;c:while(true){if(a.vQ>=a.vV.data.length)I(BJ(D(37),a.y(),a.vQ));h:{p:{d=a.vV.data[a.vQ];switch(d){case 41:BK(a);return c|256;case 45:if(!b)I(BJ(D(37),a.y(),a.vQ));b=0;break h;case 58:break c;case 100:break p;case 105:c=b?c|2:(c^2)&c;break h;case 109:c=b?c|8:(c^8)&c;break h;case 115:c=b?c|32:(c^32)&c;break h;case 117:c=b?c|64:(c^64)&c;break h;case 120:c=b?c|4:(c^4)&c;break h;default:}break h;}c=b?c|1:(c^1)&c;}BK(a);}BK(a);return c;},
BK=a=>{a.zU=a.vQ;if(a.yI&4)AMs(a);else a.vQ=a.vQ+1|0;return a.zU;},
AMs=a=>{let b;b=a.vV.data.length-2|0;a.vQ=a.vQ+1|0;d:while(true){if(a.vQ<b&&A$o(a.vV.data[a.vQ])){a.vQ=a.vQ+1|0;continue;}if(a.vQ>=b)break;if(a.vV.data[a.vQ]!=35)break;a.vQ=a.vQ+1|0;while(true){if(a.vQ>=b)continue d;if(AWQ(a,a.vV.data[a.vQ]))continue d;a.vQ=a.vQ+1|0;}}return a.vQ;},
AWQ=(a,b)=>{return b!=10&&b!=13&&b!=133&&(b|1)!=8233?0:1;},
AF3=b=>{return AUA.oU(b);},
ASn=b=>{let c,d,e,f,g,h;c=b-44032|0;if(c>=0&&c<11172){d=4352+(c/588|0)|0;e=4449+((c%588|0)/28|0)|0;f=c%28|0;if(!f)g=FM([d,e]);else{h=4519+f|0;g=FM([d,e,h]);}return g;}return null;},
A3j=b=>{let c;c=AOF.l8(b);return c==BaD?0:1;},
A8M=b=>{return (b!=832?0:1)|(b!=833?0:1)|(b!=835?0:1)|(b!=836?0:1);},
OG=a=>{let b,c,d;b=a.vV.data[BK(a)];if(Cs(b)){c=a.zU+1|0;if(c<a.vV.data.length){d=a.vV.data[c];if(CU(d)){BK(a);return Ev(b,d);}}}return b;},
AOB=a=>{return a.zY;};
let YQ=B(It);
let AGQ=a=>{ME(a);},
AI7=()=>{let a=new YQ();AGQ(a);return a;},
AN4=a=>{let b;b=(XN(a)).E(1);b.v3=1;return b;};
let ARE=B(CC);
let AYT=B(Dh);
let VB=B(FN);
let RT=(a,b,c,d,e,f,g)=>{Ol(a,b,c,d,e,f,g);},
AJw=(a,b,c,d,e,f)=>{let g=new VB();RT(g,a,b,c,d,e,f);return g;},
A6E=(a,b)=>{let c,d,e,f;c=a.xb.vS.data;d=a.xm;e=b*2|0;f=(c[d+e|0]&255)<<8|a.xb.vS.data[(a.xm+e|0)+1|0]&255;return f<<16>>16;},
ARu=(a,b,c)=>{let d,e,f;d=a.xb.vS.data;e=a.xm;f=b*2|0;d[e+f|0]=c>>8<<24>>24;a.xb.vS.data[(a.xm+f|0)+1|0]=c<<24>>24;};
let AB2=B(D1);
let AHw=B(0);
function AHX(){let a=this;A.call(a);a.yn=null;a.AY=null;a.Ie=null;}
let ABz=0;
let AGo=a=>{let b;L(a);a.yn=APL();a.AY=A66(a.yn);a.Ie=A68(a.yn,a.AY);C6.oY(a);if(!(a.yn.state!=='running'?1:0))a.oZ();else{b=AJ0(a);AQa(a.yn,Bu(b,"unlockFunction"));}},
BeH=()=>{let a=new AHX();AGo(a);return a;},
AN_=a=>{if(!ABz)C6.fr(D(396),D(397));ABz=1;},
BaZ=a=>{a.AY.disconnect(a.yn.destination);},
A5P=a=>{a.AY.connect(a.yn.destination);},
AQa=(b,c)=>{var userInputEventNames=['click','contextmenu','auxclick','dblclick','mousedown','mouseup','pointerup','touchend','keydown','keyup','touchstart'];var unlock=function(e){b.resume();c();userInputEventNames.forEach(function(eventName){document.removeEventListener(eventName,unlock);});};userInputEventNames.forEach(function(eventName){document.addEventListener(eventName,unlock);});},
APL=()=>{var AudioContext=window.AudioContext||window.webkitAudioContext;if(AudioContext){var audioContext=new AudioContext();return audioContext;}return null;},
A66=b=>{var gainNode=null;if(b.createGain)gainNode=b.createGain();else gainNode=b.createGainNode();gainNode.gain.value=1.0;gainNode.connect(b.destination);return gainNode;};
let W1=B(0);
let I3=B(Bz);
let GK=null,GB=null,H3=null,M$=null,A$s=null;
let C4=()=>{C4=N(I3);A3_();};
let BjS=(a,b,c)=>{C4();Ce(a,b,c);},
HS=(a,b)=>{let c=new I3();BjS(c,a,b);return c;},
A3_=()=>{GK=HS(D(398),0);GB=HS(D(399),1);H3=HS(D(27),2);M$=HS(D(400),3);A$s=H(I3,[GK,GB,H3,M$]);};
let Wu=B(NQ);
let AGV=a=>{Yq(a);},
A9R=()=>{let a=new Wu();AGV(a);return a;},
A6j=a=>{a.o2(A3z(a));};
let ACM=B();
let AKR=null,ALk=null,G3=null,Vt=null,W7=null;
let FX=()=>{FX=N(ACM);A0q();};
let A0q=()=>{AKR=FM([1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000]);ALk=TQ([Q(1),Q(10),Q(100),Q(1000),Q(10000),Q(100000),Q(1000000),Q(10000000),Q(100000000),Q(1000000000),C(1410065408, 2),C(1215752192, 23),C(3567587328, 232),C(1316134912, 2328),C(276447232, 23283),C(2764472320, 232830),C(1874919424, 2328306),C(1569325056, 23283064),C(2808348672, 232830643)]);G3=TQ([Q(1),Q(10),Q(100),Q(10000),Q(100000000),C(1874919424, 2328306)]);Vt=A6W();W7=AWR();};
let EP=B(Bm);
let GW=(a,b)=>{let c;BR(a);c=Q(BbQ(b));a.fe(c,1);},
Biu=a=>{let b=new EP();GW(b,a);return b;},
Bgp=(a,b)=>{return ALt(U((a.fg())),b);},
A5v=a=>{return Q(A86(U((a.fg()))));},
AQY=a=>{return AYl(U((a.fg())));},
BbQ=b=>{var jsObj=new imgui.IDLByteArray(b);return imgui.getPointer(jsObj);},
ALt=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.IDLByteArray);var returnedJSObj=jsObj.getValue(c);return returnedJSObj;},
A86=b=>{var jsObj=imgui.wrapPointer(b,imgui.IDLByteArray);var returnedJSObj=jsObj.getPointer();return returnedJSObj;},
AYl=b=>{var jsObj=imgui.wrapPointer(b,imgui.IDLByteArray);var returnedJSObj=jsObj.getSize();return returnedJSObj;};
function E0(){BD.call(this);this.wE=null;}
let Lz=(a,b,c)=>{Cu(a);a.wE=b;a.wM=c;a.v8=c.bR();},
A8s=(a,b)=>{let c=new E0();Lz(c,a,b);return c;},
AKY=(a,b,c,d)=>{let e,f;e=d.bT(a.v8);d.bU(a.v8,b);f=a.wE.br(b,c,d);if(f>=0)return f;d.bU(a.v8,e);return (-1);},
A3N=(a,b,c,d)=>{let e;e=a.wE.ev(b,c,d);if(e>=0)d.bU(a.v8,e);return e;},
Bai=(a,b,c,d,e)=>{let f;f=a.wE.dt(b,c,d,e);if(f>=0)e.bU(a.v8,f);return f;},
A2R=(a,b)=>{return a.wE.b1(b);},
A8A=a=>{let b;b=A79(a);a.vN=b;return b;},
Bhm=a=>{let b;a.ww=1;if(a.wM!==null&&!a.wM.ww)a.wM.bt();if(a.wE!==null&&!a.wE.ww){b=a.wE.bs();if(b!==null){a.wE.ww=1;a.wE=b;}a.wE.bt();}};
let AJc=B();
let RC=B(E0);
let ADV=(a,b)=>{Lz(a,b.wE,b.wM);},
A79=a=>{let b=new RC();ADV(b,a);return b;},
AVH=(a,b,c,d)=>{let e,f,g;e=0;f=d.bq();d:{while(true){if(b>f){b=e;break d;}g=d.bT(a.v8);d.bU(a.v8,b);e=a.wE.br(b,c,d);if(e>=0)break;d.bU(a.v8,g);b=b+1|0;}}return b;},
BjC=(a,b,c,d,e)=>{let f,g;f=0;d:{while(true){if(c<b){c=f;break d;}g=e.bT(a.v8);e.bU(a.v8,c);f=a.wE.br(c,d,e);if(f>=0)break;e.bU(a.v8,g);c=c+(-1)|0;}}return c;},
AQS=a=>{return null;};
let AHh=B(Bi);
let ABw=a=>{B9(a);},
BhW=()=>{let a=new AHh();ABw(a);return a;};
let ALo=B();
let A5B=b=>{return b;},
GC=b=>{return b.length?0:1;},
A4x=(b,c)=>{let d;d=A5B(c);b.push(d);},
ACr=b=>{return AJm(b.shift());};
let AP8=B();
function MY(){let a=this;A.call(a);a.w5=0;a.xn=null;a.zz=0;a.Gd=0.0;a.Bz=0;a.BO=0;a.ya=0;}
let U5=a=>{LL(a,51,0.800000011920929);},
AGe=()=>{let a=new MY();U5(a);return a;},
LL=(a,b,c)=>{let d;L(a);if(c>0.0&&c<1.0){a.Gd=c;d=Jn(b,c);a.Bz=d*c|0;a.ya=d-1|0;a.BO=DU(Q(a.ya));a.xn=Bp(d);return;}I(B3((((O()).O(D(401))).hR(c)).y()));},
Bkx=(a,b)=>{let c=new MY();LL(c,a,b);return c;},
Bd$=(a,b)=>{return U(BV(Bx(Q(b),C(2135587861, 2654435769)),a.BO));},
LR=(a,b)=>{let c,d,e;c=a.xn;d=a.pc(b);while(true){e=c.data[d];if(!e)return  -(d+1|0)|0;if(e==b)break;d=(d+1|0)&a.ya;}return d;},
ARS=(a,b)=>{let c,d;if(!b){if(a.zz)return 0;a.zz=1;a.w5=a.w5+1|0;return 1;}c=LR(a,b);if(c>=0)return 0;d= -(c+1|0)|0;a.xn.data[d]=b;d=a.w5+1|0;a.w5=d;if(d>=a.Bz)ASi(a,a.xn.data.length<<1);return 1;},
AUC=(a,b)=>{let c,d,e;c=a.xn;d=a.pc(b);while(true){e=c.data;if(!e[d])break;d=(d+1|0)&a.ya;}e[d]=b;},
Bey=(a,b)=>{let c,d,e,f,g,h,i;if(!b){if(!a.zz)return 0;a.zz=0;a.w5=a.w5-1|0;return 1;}c=LR(a,b);if(c<0)return 0;d=a.xn;e=a.ya;f=(c+1|0)&e;while(true){g=d.data;h=g[f];if(!h)break;i=a.pc(h);if(((f-i|0)&e)>((c-i|0)&e)){g[c]=h;c=f;}f=(f+1|0)&e;}g[c]=0;a.w5=a.w5-1|0;return 1;},
Bkc=(a,b)=>{if(!b)return a.zz;return LR(a,b)<0?0:1;},
ASi=(a,b)=>{let c,d,e,f;d:{c=a.xn.data.length;a.Bz=b*a.Gd|0;a.ya=b-1|0;a.BO=DU(Q(a.ya));d=a.xn;a.xn=Bp(b);if(a.w5>0){e=0;while(true){if(e>=c)break d;f=d.data[e];if(f)AUC(a,f);e=e+1|0;}}}};
function Kj(){let a=this;Bi.call(a);a.ID=null;a.Iu=null;}
let VW=(a,b,c,d)=>{Dw(a,b);a.ID=c;a.Iu=d;},
A5x=(a,b,c)=>{let d=new Kj();VW(d,a,b,c);return d;};
let Bv=B(Bi);
let Lb=a=>{B9(a);},
Ch=()=>{let a=new Bv();Lb(a);return a;},
BB=(a,b)=>{Dw(a,b);},
GF=a=>{let b=new Bv();BB(b,a);return b;};
let AHE=B(Bv);
let AFC=a=>{Lb(a);},
FT=()=>{let a=new AHE();AFC(a);return a;};
function AH7(){Bm.call(this);this.At=null;}
let AEQ=(a,b)=>{BR(a);},
A6q=a=>{let b=new AH7();AEQ(b,a);return b;},
ASV=a=>{return ATp(U((a.fg())));},
ARN=a=>{return ANK(U((a.fg())));},
A2k=a=>{return A5Q(U((a.fg())));},
BdW=a=>{let b;b=Q(AYA(U((a.fg()))));if(BS(b,Bg))return null;if(a.At===null)a.At=A6m(1);a.At.i0(b);return a.At;},
ATp=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawCmd);var textureId=imgui.ImHelper.prototype.getTextureId(nativeObject);return textureId;},
ANK=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawCmd);var jsObj=nativeObject.get_IdxOffset();return jsObj;},
A5Q=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawCmd);var jsObj=nativeObject.get_ElemCount();return jsObj;},
AYA=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImDrawCmd);var returnedJSObj=jsObj.get_ClipRect();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);};
let Xz=B(Fo);
let Wr=(a,b,c)=>{Hv(a,b,c);},
AYJ=(a,b)=>{let c=new Xz();Wr(c,a,b);return c;},
A3F=(a,b,c,d)=>{let e,f,g,h;e=a.kK(d);if(e!==null&&(b+e.bb()|0)<=d.bq()){f=0;while(true){if(f>=e.bb()){d.c7(a.y2,e.bb());return a.vN.br(b+e.bb()|0,c,d);}g=Et(D4(e.bc(f)));h=b+f|0;h=D4(c.bc(h));if(g!=Et(h))break;f=f+1|0;}return (-1);}return (-1);};
function Mw(){A.call(this);this.H0=null;}
let Fu=null,P7=null,Ni=null;
let Dj=()=>{Dj=N(Mw);Bjd();};
let AJh=(a,b)=>{Dj();L(a);a.H0=b;},
Vq=a=>{let b=new Mw();AJh(b,a);return b;},
Ej=()=>{let b,c,d;Dj();if(Ni===null){b=new ArrayBuffer(2);c=new Int16Array(b);0;c[0]=1;d=new Int8Array(b);Ni=d[0]?P7:Fu;}return Ni;},
Bjd=()=>{Fu=Vq(D(402));P7=Vq(D(403));};
function N0(){let a=this;A.call(a);a.yG=null;a.C9=null;a.Aa=null;a.Dc=0;a.AS=null;}
let U9=(a,b,c,d,e,f)=>{a.AS=b;a.yG=c;a.C9=d;a.Aa=e;a.Dc=f;L(a);},
Bds=(a,b,c,d,e)=>{let f=new N0();U9(f,a,b,c,d,e);return f;},
A7f=(a,b)=>{let c,d,e,f,g,h,i;c=b.target;d=null;e=a.yG;CM();if(e!==DJ&&a.yG!==Dz){if(a.yG===DP){e=window.document;f=e.createElement("img");g=Ba(c.result);e=Be(g);f.src=e;h=c.result;i=LO(h);d=Mr(h,i);KR(d,f);}else if(a.yG===DS)d=Ba(c.result);}else{h=c.result;i=LO(h);d=Mr(h,i);}if(d!==null){a.AS.DW.en(a.yG,a.C9,d);a.Aa.eg(a.C9);if(a.Aa.v2==a.Dc)a.AS.DA.pm(A0D(a));}},
A35=(a,b)=>{a.bn(b);};
let Yr=B(Dp);
let R4=(a,b,c,d)=>{FL(a,b,c,d);},
AWp=(a,b,c)=>{let d=new Yr();R4(d,a,b,c);return d;},
Bi3=(a,b,c,d)=>{let e;e=d.bq();if(e>b)return a.vN.dt(b,e,c,d);return a.vN.br(b,c,d);},
Bcb=(a,b,c,d)=>{let e;e=d.bq();if(a.vN.dt(b,e,c,d)>=0)return b;return (-1);};
let Jy=B(Bz);
let AIi=null,AGH=null,AWu=null;
let Nn=()=>{Nn=N(Jy);AYc();};
let A$a=(a,b,c)=>{Nn();Ce(a,b,c);},
So=(a,b)=>{let c=new Jy();A$a(c,a,b);return c;},
AYc=()=>{AIi=So(D(404),0);AGH=So(D(405),1);AWu=H(Jy,[AIi,AGH]);};
let Yn=B(CB);
let TN=(a,b,c,d)=>{Es(a,b,c,d);},
AVy=(a,b,c)=>{let d=new Yn();TN(d,a,b,c);return d;},
BhI=(a,b,c,d)=>{let e;if(!a.vY.ca(d))return a.vN.br(b,c,d);e=a.vN.br(b,c,d);if(e>=0)return e;return a.vY.br(b,c,d);};
let Bhs=B(Gw);
let Us=B(0);
let Ic=B(B8);
let Pc=a=>{Ff(a);},
Blb=()=>{let a=new Ic();Pc(a);return a;};
let ACw=B(C7);
let AAY=(a,b)=>{N8(a,b);},
ASk=a=>{let b=new ACw();AAY(b,a);return b;};
let AE4=B(0);
function Kv(){A.call(this);this.Fx=null;}
let QN=(a,b)=>{a.Fx=b;L(a);},
AJ0=a=>{let b=new Kv();QN(b,a);return b;},
ANN=a=>{a.Fx.oZ();},
ATL=a=>{a.po();};
function Iz(){Bq.call(this);this.HD=0.0;}
let APg=null;
let Op=()=>{Op=N(Iz);Bes();};
let AHB=(a,b)=>{Op();CH(a);a.HD=b;},
A4A=a=>{let b=new Iz();AHB(b,a);return b;},
Bes=()=>{APg=Bt(Iz,111);};
let ACs=B(D_);
let Tl=(a,b,c)=>{Hk(a,b,c);},
A2h=(a,b)=>{let c=new ACs();Tl(c,a,b);return c;};
let A1I=B();
let ATl=()=>{return {};};
let A5W=B();
function KO(){let a=this;A.call(a);a.yv=null;a.wv=null;}
let AIf=(a,b,c)=>{a.wv=b;a.yv=c;L(a);},
AKv=(a,b)=>{let c=new KO();AIf(c,a,b);return c;},
A3E=(a,b)=>{let c,d,e,f,g,h,$$je,$p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();h=$T.l();g=$T.l();f=$T.l();e=$T.l();d=$T.l();c=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:if(a.yv.readyState==4){a:{if(a.yv.status==200){if(a.wv.ye.xM){c=Ci();d=a.wv.x3;e=O();K(K(e,D(406)),d);c.d$(S(e));}f=a.yv.response;g=LO(f);a.wv.yM.bl(a.wv.x3,Mr(f,g));}else{if(a.yv.status!=404){c=a.yv;if(c.status!=403){try{h=Q(100);$p=1;continue _;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}a.wv.ye.hf(a.wv.zK,
a.wv.x3,a.wv.yM);break a;}}a.wv.yM.bj(a.wv.x3);}}a.wv.ye.bm();}return;case 1:d:{try{LK(h);if(DM()){break _;}break d;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}}a.wv.ye.hf(a.wv.zK,a.wv.x3,a.wv.yM);a.wv.ye.bm();return;default:DB();}}BZ().s(a,b,c,d,e,f,g,h,$p);},
Bhg=(a,b)=>{let $p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:$p=1;case 1:a.bn(b);if(DM()){break _;}return;default:DB();}}BZ().s(a,b,$p);};
let AA_=B();
let AW6=null;
let Nu=()=>{Nu=N(AA_);A15();};
let A9U=(b,c,d,e)=>{let f;Nu();f=O();BA(CR(BA(V(BA(V(BA(V(K(f,D(407)),b),44),c),44),d),44),e),41);return S(f);},
A15=()=>{AW6=A9U(255,255,255,1.0);};
let Fq=B(E1);
let BcA=B();
let Bcz=B();
let A8d=B();
function ZS(){let a=this;Cb.call(a);a.GY=null;a.G$=null;}
let Q1=(a,b,c)=>{O4(a);a.GY=b;a.G$=c;},
A68=(a,b)=>{let c=new ZS();Q1(c,a,b);return c;};
let AND=B(Cx);
let ANF=B(Cx);
let ABr=B(E8);
let V5=(a,b)=>{IA(a,b);},
JD=a=>{let b=new ABr();V5(b,a);return b;};
let ARv=B();
let AAp=null;
let EE=()=>{return AAp;},
A3G=b=>{AAp=b;};
function ACN(){let a=this;A.call(a);a.Cj=Bg;a.By=0;a.Dv=0;}
let Ta=a=>{L(a);},
A6W=()=>{let a=new ACN();Ta(a);return a;};
let Ry=B(0);
function PB(){A.call(this);this.Eb=null;}
let V2=(a,b)=>{a.Eb=b;L(a);},
BgY=a=>{let b=new PB();V2(b,a);return b;},
Bep=a=>{a.Eb.s();},
AN9=a=>{a.pr();};
let SP=B(Cc);
let AMT=null,AT1=null;
let AEr=()=>{AEr=N(SP);AMg();};
let AMg=()=>{AMT=SW();AT1=A91();};
let A_V=B();
let AKd=(b,c)=>{let d,e,f,g,h,i,j,k;if(!b)return D(408);d=1<<c;e=d-1|0;f=(((32-Sl(b)|0)+c|0)-1|0)/c|0;g=Cr(f);h=CW(f-1|0,c);i=0;while(h>=0){j=g.data;k=i+1|0;j[i]=GV((b>>>h|0)&e,d);h=h-c|0;i=k;}return J2(g);};
let AFO=B(D5);
let AHS=(a,b,c,d)=>{Iv(a,b,c,d);},
ALn=(a,b,c)=>{let d=new AFO();AHS(d,a,b,c);return d;},
A5j=(a,b,c,d)=>{let e;if((b+a.v9.bw()|0)<=d.bq()){e=a.v9.bx(b,c);if(e>=1)b=b+e|0;}return a.vN.br(b,c,d);};
let A_2=B();
let KZ=B(Bi);
let A8O=B(F0);
let Bj_=B();
let A0s=B(Bo);
let A0r=B(IV);
function Tr(){Bd.call(this);this.IB=0.0;}
let V3=(a,b)=>{BN(a);a.IB=b;},
BgF=a=>{let b=new Tr();V3(b,a);return b;};
let A0u=B(Bo);
let BcW=B();
let A7X=(b,c)=>{if(b===c)return 1;return b!==null?b.bi(c):c!==null?0:1;},
A83=b=>{return A$E(b,D(31));},
A$E=(b,c)=>{if(b!==null)c=b.y();return c;},
AIe=(b,c,d)=>{if(b>=0&&c>=0&&c<=(d-b|0))return b;I(Ch());};
let ABa=B(0);
function YC(){let a=this;BM.call(a);a.wA=null;a.BR=null;a.Ck=null;}
let UM=(a,b)=>{let c;CO(a);a.wA=b.y();a.wj=b.bb();a.BR=ABQ(a.wj);a.Ck=ABQ(a.wj);c=0;while(c<(a.wj-1|0)){a.BR.pt(a.wA.bc(c),(a.wj-c|0)-1|0);a.Ck.pt(a.wA.bc((a.wj-c|0)-1|0),(a.wj-c|0)-1|0);c=c+1|0;}},
AZQ=a=>{let b=new YC();UM(b,a);return b;},
ASq=(a,b,c)=>{return !a.pu(c,b)?(-1):a.wj;},
AOe=(a,b,c,d)=>{let e,f;e=d.bq();while(true){if(b>e)return (-1);f=a.pv(c,b,e);if(f<0)return (-1);if(a.vN.br(f+a.wj|0,c,d)>=0)break;b=f+1|0;}return f;},
AWA=(a,b,c,d,e)=>{let f;while(true){if(c<b)return (-1);f=a.pw(d,b,c);if(f<0)return (-1);if(a.vN.br(f+a.wj|0,d,e)>=0)break;c=f+(-1)|0;}return f;},
AYj=(a,b)=>{let c,d,e,f,g;if(b instanceof Dr)return b.e5()!=a.wA.bc(0)?0:1;if(b instanceof Di)return b.bx(0,a.wA.hQ(0,1))<=0?0:1;if(!(b instanceof CP)){if(!(b instanceof Df))return 1;o:{if(a.wA.bb()>1){c=b;d=c.hC();e=a.wA.bc(0);c=a.wA;f=c.bc(1);if(d==Ev(e,f)){e=1;break o;}}e=0;}return e;}p:{r:{c=b;if(!c.b6(a.wA.bc(0))){g=a.wA;if(g.bb()<=1)break r;g=a.wA;e=Ev(g.bc(0),a.wA.bc(1));if(!c.b6(e))break r;}e=1;break p;}e=0;}return e;},
Bet=(a,b,c,d)=>{let e,f;e=a.wA.bc(a.wj-1|0);while(true){if(c>(d-a.wj|0))return (-1);f=b.bc((c+a.wj|0)-1|0);if(f==e&&a.pu(b,c))break;c=c+a.BR.l8(f)|0;}return c;},
Bck=(a,b,c,d)=>{let e,f,g,h;e=a.wA.bc(0);f=b.bb();g=(f-d|0)-a.wj|0;if(g<=0)d=d+g|0;while(true){if(d<c)return (-1);h=b.bc(d);if(h==e&&a.pu(b,d))break;d=d-a.Ck.l8(h)|0;}return d;},
AYX=(a,b,c)=>{let d;d=0;while(d<a.wj){if(b.bc(d+c|0)!=a.wA.bc(d))return 0;d=d+1|0;}return 1;};
let KP=B(B6);
let AW_=B(KP);
let D8=B(B8);
let Fh=(a,b,c)=>{KG(a,b,c);},
Bk9=(a,b)=>{let c=new D8();Fh(c,a,b);return c;};
let Fw=B(CB);
let G5=(a,b,c,d)=>{Es(a,b,c,d);},
Bhz=(a,b,c)=>{let d=new Fw();G5(d,a,b,c);return d;},
BbF=(a,b,c,d)=>{let e;if(!a.vY.ca(d))return a.vN.br(b,c,d);e=a.vY.br(b,c,d);if(e>=0)return e;return a.vN.br(b,c,d);},
Bfe=(a,b)=>{Po(a,b);a.vY.bX(b);};
let A_B=B(Dq);
let Lt=B(0);
function TF(){let a=this;BM.call(a);a.Er=null;a.Hp=0;}
let ABR=(a,b)=>{CO(a);a.Er=b.b4();a.Hp=b.wa;},
Xb=a=>{let b=new TF();ABR(b,a);return b;},
A1D=(a,b,c)=>{let d,e;d=a.Er;e=D4(c.bc(b));return !d.b6(Et(e))?(-1):1;};
let Ga=B(F9);
let P1=a=>{Ob(a,A4y());},
AVS=(a,b)=>{a.bD(b);a.bD(D(235));},
AOw=a=>{a.bD(D(235));},
AMi=(a,b)=>{a.d$(A83(b));};
let Rh=B(Ga);
let AEI=a=>{P1(a);},
A51=()=>{let a=new Rh();AEI(a);return a;},
A0R=(a,b)=>{Bli(Be(b));};
let A$5=B();
let AY2=B();
let AW8=B();
let A0p=B(B0);
let BjW=B();
let AHs=B(D1);
let A0O=B(Bo);
let A0N=B(Bo);
let APC=B();
let AKa=b=>{let copy=new b.constructor();for(let field in b){if(b.hasOwnProperty(field)){copy[field]=b[field];}}return copy;},
A6p=(b,c)=>{return b!==null&&!(typeof b.constructor.$meta==='undefined'?1:0)&&AB1(b.constructor,c)?1:0;},
AB1=(b,c)=>{let d,e;if(b===c)return 1;d=b.$meta.supertypes;e=0;while(e<d.length){if(AB1(d[e],c))return 1;e=e+1|0;}return 0;},
A$b=b=>{setTimeout(()=>{Blr(Su)(b);},0);},
Su=b=>{b.s();},
AAF=b=>{AEY(b,0);},
AEY=(b,c)=>{setTimeout(()=>{Su(b);},c);},
AJD=()=>{return A1p();},
Bbt=b=>{return b.$meta.primitive?1:0;},
AHM=b=>{return b.$meta.item;},
AEV=b=>{return Ba(b.$meta.name);},
BeV=b=>{return Ba(b.$meta.simpleName);},
Bd7=b=>{return b.$meta.enclosingClass;},
A1p=()=>{return [];};
function LJ(){A.call(this);this.Is=null;}
let BcI=null,ED=null,EG=null;
let DZ=()=>{DZ=N(LJ);A4g();};
let AD0=(a,b)=>{DZ();L(a);a.Is=b;},
PJ=a=>{let b=new LJ();AD0(b,a);return b;},
A4g=()=>{BcI=PJ(D(409));ED=PJ(D(410));EG=PJ(D(411));};
let A0a=B();
let AIv=B(Bi);
let YA=(a,b)=>{Dw(a,b);},
AJY=a=>{let b=new AIv();YA(b,a);return b;};
let BbC=B(B0);
let A5K=B(0);
let AF_=B(Fo);
let AGC=(a,b,c)=>{Hv(a,b,c);},
AMG=(a,b)=>{let c=new AF_();AGC(c,a,b);return c;},
ARc=(a,b,c,d)=>{let e,f;e=a.kK(d);if(e!==null&&(b+e.bb()|0)<=d.bq()){f=!(c.y()).hN(e,b)?(-1):e.bb();if(f<0)return (-1);d.c7(a.y2,f);return a.vN.br(b+f|0,c,d);}return (-1);},
Bd_=(a,b,c,d)=>{let e,f,g,h;e=a.kK(d);f=d.b5();if(e!==null&&(b+e.bb()|0)<=f){g=c.y();while(true){if(b>f)return (-1);h=g.pA(e,b);if(h<0)return (-1);if(a.vN.br(h+e.bb()|0,c,d)>=0)break;b=h+1|0;}return h;}return (-1);},
ALC=(a,b,c,d,e)=>{let f,g,h;f=a.kK(e);if(f===null)return (-1);g=d.y();a:{while(true){if(c<b)return (-1);h=g.pB(f,c);if(h<0)break a;if(h<b)break a;if(a.vN.br(h+f.bb()|0,d,e)>=0)break;c=h+(-1)|0;}return h;}return (-1);},
A40=(a,b)=>{return 1;};
function Tc(){Dp.call(this);this.BV=null;}
let AC8=(a,b,c,d,e)=>{FL(a,b,c,d);a.BV=e;},
AOZ=(a,b,c,d)=>{let e=new Tc();AC8(e,a,b,c,d);return e;},
A8B=(a,b,c,d)=>{let e,f;e=d.bq();f=ADH(a,b,e,c);if(f>=0)e=f;if(e>b)return a.vN.dt(b,e,c,d);return a.vN.br(b,c,d);},
AJP=(a,b,c,d)=>{let e,f,g,h,i;e=d.bq();f=a.vN.ev(b,c,d);if(f<0)return (-1);g=ADH(a,f,e,c);if(g>=0)e=g;h=a.vN.dt(f,e,c,d);h=BT(f,h);i=h>0?BdH(a,b,h-1|0,c):h?(-1):0;if(i>=b)b=i>=h?i:i+1|0;return b;},
ADH=(a,b,c,d)=>{while(true){if(b>=c)return (-1);if(a.BV.pE(d.bc(b)))break;b=b+1|0;}return b;},
BdH=(a,b,c,d)=>{while(true){if(c<b)return (-1);if(a.BV.pE(d.bc(c)))break;c=c+(-1)|0;}return c;};
let A3v=B(FE);
let AYu=B();
function AFc(){let a=this;Bm.call(a);a.G9=0;a.y5=null;a.zD=null;a.wV=null;a.w0=null;a.CT=null;}
let VK=(a,b)=>{BR(a);a.G9=0;a.CT=A6q(0);},
AP1=a=>{let b=new AFc();VK(b,a);return b;},
Bfh=(a,b)=>{let c;c=Q(BgI(U((a.fg())),b));a.CT.i0(c);return a.CT;},
A_4=a=>{return Bht(U((a.fg())));},
ANX=a=>{let b,c,d,e,f,g;b=AKI(U((a.fg())));c=b*2|0;if(!(a.w0!==null&&DL(a.w0)>=c)){if(a.w0!==null)K2(a.w0);if(a.zD!==null)a.zD.fh();d=new EP;e=c+5000|0;GW(d,e);a.zD=d;a.w0=DX(DH(e),Ej());}e=U((a.fg()));f=U((a.zD.fg()));A28(e,f,c);a.w0.fC(0);a.w0.fD(c);g=0;while(g<c){a.w0.fA(g,a.zD.fB(g));g=g+1|0;}a.w0.fC(0);a.w0.fD(c);return a.w0;},
AJv=a=>{let b,c,d,e,f,g;b=Bf7(U((a.fg())));c=b*20|0;if(!(a.wV!==null&&DL(a.wV)>=c)){if(a.wV!==null)K2(a.wV);if(a.y5!==null)a.y5.fh();d=new EP;e=c+5000|0;GW(d,e);a.y5=d;a.wV=DX(DH(e),Ej());}e=U((a.fg()));f=U((a.y5.fg()));Bgr(e,f,c);a.wV.fC(0);a.wV.fD(c);g=0;while(g<c){a.wV.fA(g,a.y5.fB(g));g=g+1|0;}a.wV.fC(0);a.wV.fD(c);return a.wV;},
BgI=(b,c)=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);var cmdBuffer=nativeObject.get_CmdBuffer();var drawCmd=cmdBuffer.getData(c);return imgui.getPointer(drawCmd);},
Bht=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);return nativeObject.CmdBuffer.size();},
A28=(b,c,d)=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);var charArray=imgui.wrapPointer(c,imgui.IDLByteArray);var charArrayPtr=charArray.getPointer();imgui.ImHelper.prototype.memcpyIdx(charArrayPtr,nativeObject,d);},
AKI=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);return nativeObject.IdxBuffer.size();},
Bgr=(b,c,d)=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);var charArray=imgui.wrapPointer(c,imgui.IDLByteArray);var charArrayPtr=charArray.getPointer();imgui.ImHelper.prototype.memcpyVtx(charArrayPtr,nativeObject,d);},
Bf7=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawList);return nativeObject.VtxBuffer.size();};
let Vr=B();
let MU=0,Gr=null,Ip=null;
let Fv=()=>{Fv=N(Vr);AUS();};
let A5n=(b,c)=>{let d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u;Fv();d=Pi(b);c.DF=!(d&(-2147483648))?0:1;e=d&8388607;f=d>>23&255;if(!e&&!f){c.B2=0;c.BI=0;return;}if(f)g=e|8388608;else{g=e<<1;while(BS(Cp(Q(g),Q(8388608)),Bg)){g=g<<1;f=f+(-1)|0;}}h=A6i(Ip,f);if(h<0)h= -h|0;i=Ip.data;j=h+1|0;k=f-i[j]|0;l=9+k|0;m=HB(g,Gr.data[j],l);if(m<MU){while(DD(m,MU)<=0){h=h+(-1)|0;m=(m*10|0)+9|0;}i=Ip.data;j=h+1|0;n=f-i[j]|0;l=9+n|0;m=HB(g,Gr.data[j],l);}j=g<<1;g=j+1|0;i=Gr.data;n=h+1|0;o=i[n];p=l-1|0;q=HB(g,o,p);r=HB(j-1|0,Gr.data[n],
p);s=AXD(m,r);t=Bfv(m,q);u=DD(s,t);j=u>0?CW(CS(m,s),s):u<0?CW(CS(m,t),t)+t|0:CW(CS((m+(t/2|0)|0),t),t);if(CV(Q(j),Q(1000000000))>=0)while(true){h=h+1|0;j=CS(j,10);if(DD(j,1000000000)<0)break;}else if(DD(j,100000000)<0){h=h+(-1)|0;j=j*10|0;}c.B2=j;c.BI=h-50|0;},
AXD=(b,c)=>{let d,e,f,g;Fv();d=1;while(true){e=d*10|0;f=CS(b,e);g=CS(c,e);if(DD(f,g)<=0)break;d=e;}return d;},
Bfv=(b,c)=>{let d,e,f,g;Fv();d=1;while(true){e=d*10|0;f=CS(b,e);g=CS(c,e);if(DD(f,g)>=0)break;d=e;}return d;},
HB=(b,c,d)=>{let e;Fv();e=Bx(Cp(Q(b),C(4294967295, 0)),Cp(Q(c),C(4294967295, 0)));return U(BV(e,32-d|0));},
AUS=()=>{MU=CS((-1),10);Gr=FM([(-18543760),(-873828468),(-1558056233),(-2105438446),(-791721136),(-1492370368),(-2052889754),(-707643228),(-1425108042),(-1999079893),(-621547450),(-1356231419),(-1943978595),(-533385374),(-1285701758),(-1887554866),(-443107408),(-1213479385),(-1829776968),(-350662770),(-1139523676),(-1770612400),(-255999462),(-1063793029),(-1710027882),(-159064234),(-986244846),(-1647989336),(-59802560),(-906835507),(-1584461865),(-2126562952),(-825520345),(-1519409735),(-2074521247),(-742253618),
(-1452796353),(-2021230542),(-656988489),(-1384584251),(-1966660860),(-569676998),(-1314735058),(-1910781505),(-480270031),(-1243209484),(-1853561046),(-388717296),(-1169967296),(-1794967296),(-294967296),(-1094967296),(-1734967296),(-198967296),(-1018167296),(-1673527296),(-100663296),(-939524096),(-1610612736),(-2147483648),(-858993460),(-1546188227),(-2095944041),(-776530088),(-1480217529),(-2043167483),(-692087595),(-1412663535),(-1989124287),(-605618482),(-1343488245),(-1933784055),(-517074110),(-1272652747),
(-1877115657),(-426404674),(-1200117198),(-1819087218),(-333559171),(-1125840796),(-1759666096),(-238485376),(-1049781760),(-1698818867),(-141129810),(-971897307),(-1636511305),(-41437710),(-892143627),(-1572708361),(-2117160148),(-810475859),(-1507374147),(-2064892777),(-726848065),(-1440471911),(-2011370988),(-641213203),(-1371964022),(-1956564688)]);Ip=FM([(-37),(-34),(-31),(-28),(-24),(-21),(-18),(-14),(-11),(-8),(-4),(-1),2,6,9,12,16,19,22,26,29,32,36,39,42,46,49,52,56,59,62,65,69,72,75,79,82,85,89,92,
95,99,102,105,109,112,115,119,122,125,129,132,135,139,142,145,149,152,155,158,162,165,168,172,175,178,182,185,188,192,195,198,202,205,208,212,215,218,222,225,228,232,235,238,242,245,248,252,255,258,261,265,268,271,275,278,281,285,288,291]);};
let A4C=B();
let H6=B(Bz);
let Z4=null,ACq=null,Wb=null,AQV=null;
let Mi=()=>{Mi=N(H6);A6C();};
let ASM=(a,b,c)=>{Mi();Ce(a,b,c);},
Mv=(a,b)=>{let c=new H6();ASM(c,a,b);return c;},
A6C=()=>{Z4=Mv(D(412),0);ACq=Mv(D(413),1);Wb=Mv(D(414),2);AQV=H(H6,[Z4,ACq,Wb]);};
let A$7=B(Fi);
function M9(){let a=this;A.call(a);a.xl=null;a.y1=0;a.z0=null;a.Eu=null;a.Fq=null;a.ER=null;a.zN=null;a.EP=null;a.FE=null;a.D$=null;a.wR=0;a.BT=0;a.Bi=0;a.IA=null;a.DE=null;a.DY=null;a.Fk=0;a.Io=0;a.wz=null;a.xW=null;}
let ACd=0,JA=null,In=null,O$=null,BaO=null;
let GU=()=>{GU=N(M9);A$0();};
let AH$=(a,b,c)=>{GU();L(a);a.xl=D(37);a.z0=Fg();a.Eu=Fg();a.Fq=Fg();a.zN=Fg();a.EP=Fg();a.FE=Fg();a.Io=0;a.wz=GO(1);a.xW=GO(1);if(b===null)I(B3(D(415)));if(c===null)I(B3(D(416)));if(JA!==null&&JA.bb()>0)b=(((O()).O(JA)).O(b)).y();if(In!==null&&In.bb()>0)c=(((O()).O(In)).O(c)).y();a.DE=b;a.DY=c;a.IA=NK(16);Vd(a,b,c);if(a.fq()){AVB(a);A4o(a);A8l(a,C6,a);}},
Wt=(a,b)=>{let c=new M9();AH$(c,a,b);return c;},
Vd=(a,b,c)=>{a.BT=AIN(a,35633,b);a.Bi=AIN(a,35632,c);if(a.BT!=(-1)&&a.Bi!=(-1)){a.wR=BcB(a,a.pZ());if(a.wR!=(-1)){a.y1=1;return;}a.y1=0;return;}a.y1=0;},
AIN=(a,b,c)=>{let d,e,f,g,h;d=Y;e=GO(1);f=d.mM(b);if(!f)return (-1);d.mY(f,c);d.mK(f);d.mU(f,35713,e);g=e.l8(0);if(g)return f;h=d.mV(f);a.xl=(((O()).O(a.xl)).O(b!=35633?D(417):D(418))).y();a.xl=(((O()).O(a.xl)).O(h)).y();return (-1);},
AZ1=a=>{let b,c;b=Y;c=b.mL();if(!c)c=(-1);return c;},
BcB=(a,b)=>{let c,d,e,f;c=Y;if(b==(-1))return (-1);c.mJ(b,a.BT);c.mJ(b,a.Bi);c.mX(b);d=DH(4);DX(d,Ej());e=d.p0();c.mS(b,35714,e);f=e.l8(0);if(f)return b;a.xl=Y.mT(b);return (-1);},
Bcd=a=>{if(!a.y1)return a.xl;a.xl=Y.mT(a.wR);return a.xl;},
BeO=a=>{return a.y1;},
AY$=(a,b)=>{let c,d;c=Y;d=a.zN.p1(b,(-2));if(d==(-2)){d=c.mR(a.wR,b);a.zN.p2(b,d);}return d;},
R8=(a,b)=>{GU();return a.p3(b,ACd);},
A27=(a,b,c)=>{let d;d=a.z0.p1(b,(-2));if(d==(-2)){d=Y.mW(a.wR,b);if(d==(-1)&&c){if(!a.y1)I(WM((((O()).O(D(419))).O(a.fs())).y()));I(B3(((((O()).O(D(420))).O(b)).O(D(421))).y()));}a.z0.p2(b,d);}return d;},
AZd=(a,b,c)=>{let d,e;d=Y;Ee(a);e=R8(a,b);d.mZ(e,c);},
AUq=(a,b,c)=>{a.p6(b,c,0);},
AMh=(a,b,c,d)=>{a.p7(R8(a,b),c,d);},
A5d=(a,b,c,d)=>{let e;e=Y;Ee(a);e.p8(b,1,d,c.vL,0);},
Bia=(a,b,c,d,e,f,g)=>{let h;h=Y;Ee(a);h.m1(b,c,d,e,f,g);},
AMO=a=>{let b;b=Y;Ee(a);b.m0(a.wR);},
AOj=(a,b)=>{let c,d;c=Y;Ee(a);d=AY$(a,b);if(d==(-1))return;c.mN(d);},
A2T=(a,b)=>{let c;c=Y;Ee(a);c.mN(b);},
A9F=(a,b)=>{let c;c=Y;Ee(a);c.mO(b);},
Ee=a=>{if(a.Fk){Vd(a,a.DE,a.DY);a.Fk=0;}},
A8l=(a,b,c)=>{let d;GU();d=O$.bJ(b);if(d===null)d=Dx();d.eg(c);O$.bL(b,d);},
A4o=a=>{let b,c,d,e;a.wz.dW();Y.mS(a.wR,35718,a.wz);b=a.wz.l8(0);a.ER=Bt(BG,b);c=0;while(c<b){a.wz.dW();a.wz.p$(0,1);a.xW.dW();d=Y.mQ(a.wR,c,a.wz,a.xW);e=Y.mW(a.wR,d);a.z0.p2(d,e);a.Eu.p2(d,a.xW.l8(0));a.Fq.p2(d,a.wz.l8(0));a.ER.data[c]=d;c=c+1|0;}},
AVB=a=>{let b,c,d,e;a.wz.dW();Y.mS(a.wR,35721,a.wz);b=a.wz.l8(0);a.D$=Bt(BG,b);c=0;while(c<b){a.wz.dW();a.wz.p$(0,1);a.xW.dW();d=Y.mP(a.wR,c,a.wz,a.xW);e=Y.mR(a.wR,d);a.zN.p2(d,e);a.EP.p2(d,a.xW.l8(0));a.FE.p2(d,a.wz.l8(0));a.D$.data[c]=d;c=c+1|0;}},
AN7=(a,b)=>{return a.zN.p1(b,(-1));},
A$0=()=>{ACd=1;JA=D(37);In=D(37);O$=Dl();BaO=GO(1);};
function QX(){T.call(this);this.HW=null;}
let AIm=(a,b)=>{a.HW=b;Bh(a);},
ATc=a=>{let b=new QX();AIm(b,a);return b;},
ASJ=(a,b)=>{return A0b(b);};
function PM(){let a=this;A.call(a);a.AD=null;a.Ay=null;a.AP=null;a.B0=null;a.CM=null;a.zC=null;a.Ap=null;a.CY=0.0;a.Fg=0.0;a.Ai=0.0;a.AE=0.0;a.Fa=null;a.G1=null;a.GI=null;}
let ADA=a=>{L(a);a.AD=X();a.Ay=Co(0.0,0.0,(-1.0));a.AP=Co(0.0,1.0,0.0);a.B0=C0();a.CM=C0();a.zC=C0();a.Ap=C0();a.CY=1.0;a.Fg=100.0;a.Ai=0.0;a.AE=0.0;a.Fa=A9E();a.G1=X();a.GI=ANy(X(),X());};
function VJ(){let a=this;PM.call(a);a.xY=0.0;a.Ft=null;}
let TP=a=>{ADA(a);a.xY=1.0;a.Ft=X();a.CY=0.0;},
A1A=()=>{let a=new VJ();TP(a);return a;},
ARK=a=>{a.qb(1);},
BjG=(a,b)=>{a.B0.nv(a.xY* -a.Ai/2.0,a.xY*a.Ai/2.0,a.xY* -(a.AE/2.0),a.xY*a.AE/2.0,a.CY,a.Fg);a.CM.qc(a.AD,(a.Ft.cY(a.AD)).cZ(a.Ay),a.AP);a.zC.iS(a.B0);Bix(a.zC.vL,a.CM.vL);if(b){a.Ap.iS(a.zC);AUI(a.Ap.vL);a.Fa.qf(a.Ap);}},
A3n=(a,b)=>{a.qg(b,B5.fM(),B5.fN());},
AKD=(a,b,c,d)=>{if(!b){a.AP.cW(0.0,1.0,0.0);a.Ay.cW(0.0,0.0,(-1.0));}else{a.AP.cW(0.0,(-1.0),0.0);a.Ay.cW(0.0,0.0,1.0);}a.AD.cW(a.xY*c/2.0,a.xY*d/2.0,0.0);a.Ai=c;a.AE=d;a.cX();};
function Gj(){let a=this;A.call(a);a.wF=null;a.Ab=0;a.D_=0;a.xO=0;a.zk=0;a.AG=0;}
let Uz=(a,b,c)=>{L(a);a.xO=1;a.zk=0;a.D_=1;a.wF=AD5(c);GP(a.wF);a.Ab=Y.fK();a.AG=!b?35048:35044;},
AXj=(a,b)=>{let c=new Gj();Uz(c,a,b);return c;},
O5=(a,b)=>{L(a);a.xO=1;a.zk=0;a.D_=1;a.wF=AD5(b);GP(a.wF);a.Ab=Y.fK();a.AG=35044;},
Bly=a=>{let b=new Gj();O5(b,a);return b;},
AYt=a=>{return BI(a.wF);},
ALp=a=>{return DL(a.wF);},
A6t=(a,b,c,d)=>{a.xO=1;PH(a.wF);a.wF.m4(b,c,d);GP(a.wF);if(a.zk){Y.f6(34963,BI(a.wF),a.wF,a.AG);a.xO=0;}},
AMW=(a,b)=>{a.xO=a.xO|b;return a.wF;},
BfO=a=>{if(!a.Ab)I(DF(D(422)));Y.gp(34963,a.Ab);if(a.xO){Y.f6(34963,BI(a.wF),a.wF,a.AG);a.xO=0;}a.zk=1;},
A_A=a=>{Y.gp(34963,0);a.zk=0;};
let U8=B(Gj);
let ACb=(a,b)=>{O5(a,b);},
BfU=a=>{let b=new U8();ACb(b,a);return b;};
let A7_=B(BX);
let ANJ=B();
let Sb=(b,c)=>{let d,e,f,g;d=b.data;e=Cr(c);f=B7(c,d.length);g=0;while(g<f){e.data[g]=d[g];g=g+1|0;}return e;},
AGF=(b,c)=>{let d,e,f,g;d=b.data;e=EL(c);f=B7(c,d.length);g=0;while(g<f){e.data[g]=d[g];g=g+1|0;}return e;},
BhQ=(b,c)=>{let d,e,f,g;d=b.data;e=Bp(c);f=B7(c,d.length);g=0;while(g<f){e.data[g]=d[g];g=g+1|0;}return e;},
H8=(b,c)=>{let d,e,f,g;d=b.data;e=On((Do(b)).eB(),c);f=B7(c,d.length);g=0;while(g<f){e.data[g]=d[g];g=g+1|0;}return e;},
VQ=(b,c,d,e)=>{let f,g;if(c>d)I(CF());while(c<d){f=b.data;g=c+1|0;f[c]=e;c=g;}},
Hl=(b,c)=>{VQ(b,0,b.data.length,c);},
Bbq=(b,c,d,e)=>{let f,g;if(c>d)I(CF());while(c<d){f=b.data;g=c+1|0;f[c]=e;c=g;}},
A9$=(b,c)=>{Bbq(b,0,b.data.length,c);},
AP$=(b,c,d,e)=>{let f,g;if(c>d)I(CF());while(c<d){f=b.data;g=c+1|0;f[c]=e;c=g;}},
A6i=(b,c)=>{return A8p(b,0,b.data.length,c);},
A8p=(b,c,d,e)=>{let f,g,h,i;if(c>d)I(CF());f=d-1|0;while(true){if(c>f)return ( -c|0)-1|0;g=b.data;h=(c+f|0)/2|0;i=g[h];if(i==e)break;if(e>=i)c=h+1|0;else f=h-1|0;}return h;},
ANI=(b,c)=>{return A_l(b,0,b.data.length,c);},
A_l=(b,c,d,e)=>{let f,g,h,i,j;if(c>d)I(CF());f=d-1|0;while(true){if(c>f)return ( -c|0)-1|0;g=b.data;h=(c+f|0)/2|0;i=g[h];j=CA(i,e);if(!j)break;if(j<=0)c=h+1|0;else f=h-1|0;}return h;},
Bf8=(b,c,d,e,f)=>{let g,h;g=0;while(true){if(g>=f)return (-1);h=d.data;if(!A7X(b.data[g+c|0],h[g+e|0]))break;g=g+1|0;}return g;},
AEP=(b,c)=>{let d,e;if(b===c)return 1;if(b!==null&&c!==null){d=c.data;e=b.data.length;if(e==d.length)return Bf8(b,0,c,0,e)>=0?0:1;}return 0;};
function Tn(){let a=this;T.call(a);a.Be=0;a.DS=null;a.B4=null;}
let AHT=(a,b,c,d)=>{a.B4=b;a.Be=c;a.DS=d;Bh(a);},
AJn=(a,b,c)=>{let d=new Tn();AHT(d,a,b,c);return d;},
BaB=(a,b)=>{return !(a.Be^a.B4.vX.jH(b))&&!(a.Be^a.B4.xa^a.DS.b6(b))?0:1;};
function Tv(){let a=this;T.call(a);a.EL=0;a.ED=null;a.Ep=null;a.IK=null;}
let V_=(a,b,c,d,e)=>{a.IK=b;a.EL=c;a.ED=d;a.Ep=e;Bh(a);},
BjV=(a,b,c,d)=>{let e=new Tv();V_(e,a,b,c,d);return e;},
AI0=(a,b)=>{return a.EL^(!a.ED.b6(b)&&!a.Ep.b6(b)?0:1)?0:1;};
function Tq(){let a=this;T.call(a);a.EF=null;a.HM=null;}
let QH=(a,b,c)=>{a.HM=b;a.EF=c;Bh(a);},
AUW=(a,b)=>{let c=new Tq();QH(c,a,b);return c;},
A_t=(a,b)=>{return a.EF.b6(b);};
function To(){let a=this;T.call(a);a.Bn=0;a.FP=null;a.Cy=null;}
let QW=(a,b,c,d)=>{a.Cy=b;a.Bn=c;a.FP=d;Bh(a);},
ASS=(a,b,c)=>{let d=new To();QW(d,a,b,c);return d;},
A3Q=(a,b)=>{return !(a.Bn^a.Cy.vX.jH(b))&&!(a.Bn^a.Cy.xa^a.FP.b6(b))?1:0;};
function Ts(){let a=this;T.call(a);a.El=null;a.IP=null;}
let QQ=(a,b,c)=>{a.IP=b;a.El=c;Bh(a);},
AUj=(a,b)=>{let c=new Ts();QQ(c,a,b);return c;},
AXp=(a,b)=>{return a.El.b6(b);};
let AG5=B();
function Tx(){let a=this;T.call(a);a.E_=null;a.Fh=0;a.E4=null;}
let UQ=(a,b,c,d)=>{a.E4=b;a.E_=c;a.Fh=d;Bh(a);},
ALG=(a,b,c)=>{let d=new Tx();UQ(d,a,b,c);return d;},
ARt=(a,b)=>{return !a.E_.b6(b)&&!(a.Fh^a.E4.vX.jH(b))?1:0;};
function Tu(){let a=this;T.call(a);a.F$=0;a.FS=null;a.FN=null;a.GV=null;}
let Re=(a,b,c,d,e)=>{a.GV=b;a.F$=c;a.FS=d;a.FN=e;Bh(a);},
BdV=(a,b,c,d)=>{let e=new Tu();Re(e,a,b,c,d);return e;},
ATf=(a,b)=>{return a.F$^(!a.FS.b6(b)&&!a.FN.b6(b)?0:1);};
function Tt(){let a=this;T.call(a);a.FW=null;a.G8=null;}
let QT=(a,b,c)=>{a.G8=b;a.FW=c;Bh(a);},
BeW=(a,b)=>{let c=new Tt();QT(c,a,b);return c;},
A3S=(a,b)=>{return a.FW.b6(b)?0:1;};
let ADb=B(0);
function T1(){BD.call(this);this.Cd=null;}
let Uf=(a,b)=>{Cu(a);a.Cd=b;},
A_e=a=>{let b=new T1();Uf(b,a);return b;},
A7l=(a,b,c,d)=>{let e,f,g,h,i;e=d.bq();f=b+1|0;if(f>e){d.wZ=1;return (-1);}g=c.bc(b);if(Cs(g)){h=b+2|0;if(h<=e){i=c.bc(f);if(G_(g,i))return a.Cd.pE(Ev(g,i))?(-1):a.vN.br(h,c,d);}}return a.Cd.pE(g)?(-1):a.vN.br(f,c,d);},
A_Z=(a,b)=>{a.vN=b;},
AIY=a=>{return (-2147483602);},
BiL=(a,b)=>{return 1;};
function Tw(){let a=this;T.call(a);a.EV=null;a.EE=0;a.Fy=null;}
let WW=(a,b,c,d)=>{a.Fy=b;a.EV=c;a.EE=d;Bh(a);},
AON=(a,b,c)=>{let d=new Tw();WW(d,a,b,c);return d;},
Beg=(a,b)=>{return !a.EV.b6(b)&&!(a.EE^a.Fy.vX.jH(b))?0:1;};
let Ok=B();
let AKE=null,LZ=null,Ld=null,Mh=null,Oa=null,A9W=null,OY=null,OX=null,OZ=null,O0=null;
let Z=()=>{Z=N(Ok);AMn();};
let AGR=b=>{let c,d;Z();c=new BG;d=Cr(1);d.data[0]=b;Kt(c,d);return c;},
A2E=b=>{Z();return b>=0&&b<=1114111?1:0;},
AKJ=b=>{Z();return b>0&&b<=65535?1:0;},
PA=b=>{Z();return b>=65536&&b<=1114111?1:0;},
Cs=b=>{Z();return (b&64512)!=55296?0:1;},
CU=b=>{Z();return (b&64512)!=56320?0:1;},
AHi=b=>{Z();return !Cs(b)&&!CU(b)?0:1;},
G_=(b,c)=>{Z();return Cs(b)&&CU(c)?1:0;},
Ev=(b,c)=>{Z();return ((b&1023)<<10|c&1023)+65536|0;},
A9p=(b,c)=>{Z();return APy(b,c,b.data.length);},
APy=(b,c,d)=>{let e,f;Z();if(c<d&&c>=0){e=b.data;if(d<=e.length){if(c<(d-1|0)&&Cs(e[c])){f=c+1|0;if(CU(e[f]))return Ev(e[c],e[f]);}return e[c];}}I(Ch());},
Iq=b=>{let c;Z();c=b-65536|0;return (55296|c>>10&1023)&65535;},
Jx=b=>{Z();return (56320|b&1023)&65535;},
Et=b=>{Z();return Gu(b)&65535;},
Gu=b=>{Z();return VU(AZS(),b);},
AZS=()=>{let b;Z();if(Mh===null){b=Xi(((AEi()).value!==null?Ba((AEi()).value):null));Mh=QU(b);}return Mh;},
AEi=()=>{Z();if(OY===null)OY=A9C();return OY;},
D4=b=>{Z();return Gp(b)&65535;},
Gp=b=>{Z();return VU(ALK(),b);},
ALK=()=>{let b;Z();if(Ld===null){b=Xi(((AGy()).value!==null?Ba((AGy()).value):null));Ld=QU(b);}return Ld;},
AGy=()=>{Z();if(OX===null)OX=BbG();return OX;},
VU=(b,c)=>{let d,e,f,g;Z();if(c<b.Cm.data.length)return c+b.Cm.data[c]|0;d=b.EQ;e=Bb5(d,c);if(e>=0){f=d.data;g=e*2|0;if(g<f.length)return c+f[g+1|0]|0;}return 0;},
Bb5=(b,c)=>{let d,e,f,g,h,i;Z();d=b.data;e=0;f=(d.length/2|0)-1|0;while(true){g=(e+f|0)/2|0;h=d[g*2|0];i=CA(h,c);if(!i)break;if(i<=0){e=g+1|0;if(e>f)return g;}else{f=g-1|0;if(f<e)return f;}}return g;},
ADw=(b,c)=>{Z();return BaM(b,c);},
BaM=(b,c)=>{let d;Z();if(c>=2&&c<=36){d=AQL(b);if(d>=c)d=(-1);return d;}return (-1);},
AQL=b=>{let c,d,e,f,g,h,i,j;Z();c=AKh();d=c.data;e=0;f=(d.length/2|0)-1|0;while(f>=e){g=(e+f|0)/2|0;h=g*2|0;i=d[h];j=CA(b,i);if(j>0)e=g+1|0;else{if(j>=0)return d[h+1|0];f=g-1|0;}}return (-1);},
GV=(b,c)=>{Z();if(c>=2&&c<=36&&b>=0&&b<c)return b<10?(48+b|0)&65535:((97+b|0)-10|0)&65535;return 0;},
Bh4=b=>{Z();return Cm(b)!=9?0:1;},
AKh=()=>{Z();if(LZ===null)LZ=Bhh(((AAG()).value!==null?Ba((AAG()).value):null));return LZ;},
AAG=()=>{Z();if(OZ===null)OZ=AYI();return OZ;},
AYQ=()=>{Z();if(Oa===null)Oa=Bj2(((Wa()).value!==null?Ba((Wa()).value):null));return Oa;},
Wa=()=>{Z();if(O0===null)O0=Bje();return O0;},
Gf=b=>{let c;Z();if(!A2E(b))I(CF());if(b<65536){c=Cr(1);c.data[0]=b&65535;return c;}return AY4([Iq(b),Jx(b)]);},
AXf=b=>{let c;Z();d:{a:{if(!(b>=0&&b<=31)){if(b<127)break a;if(b>159)break a;}c=1;break d;}c=0;}return c;},
HQ=b=>{Z();return Cm(b);},
Cm=b=>{let c,d,e,f,g,h;Z();if(AKJ(b)&&AHi(b&65535))return 19;c=AYQ();d=c.data;e=0;f=d.length-1|0;while(e<=f){g=(e+f|0)/2|0;h=d[g];if(b>=h.EY)e=g+1|0;else{if(b>=h.BX)return h.Ei.data[b-h.BX|0];f=g-1|0;}}return 0;},
BeN=b=>{Z();return Cm(b)!=2?0:1;},
AJp=b=>{Z();return Cm(b)!=1?0:1;},
ALh=b=>{Z();return Cm(b)!=3?0:1;},
A2D=b=>{Z();return !Cm(b)?0:1;},
Bew=b=>{Z();switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:break;default:return 0;}return 1;},
X3=b=>{Z();return Sk(b);},
Sk=b=>{Z();d:{switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:case 9:break;case 6:case 7:case 8:break d;default:break d;}return 1;}return 0;},
A0b=b=>{Z();d:{switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:case 10:case 23:case 26:break;case 6:case 7:case 8:case 9:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:case 21:case 22:case 24:case 25:break d;default:break d;}return 1;}return Gb(b);},
Bio=b=>{Z();d:{switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:case 6:case 8:case 9:case 10:case 23:case 26:break;case 7:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:case 21:case 22:case 24:case 25:break d;default:break d;}return 1;}return Gb(b);},
Bgh=b=>{Z();d:{switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:case 10:break;case 6:case 7:case 8:case 9:break d;default:break d;}return 1;}return Gb(b);},
AVX=b=>{Z();d:{switch(Cm(b)){case 1:case 2:case 3:case 4:case 5:case 6:case 8:case 9:case 10:case 23:break;case 7:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:case 21:case 22:break d;default:break d;}return 1;}return Gb(b);},
Gb=b=>{Z();d:{if(!(b>=0&&b<=8)&&!(b>=14&&b<=27)){if(b<127)break d;if(b>159)break d;}return 1;}return Cm(b)!=16?0:1;},
UZ=b=>{Z();switch(Cm(b)){case 12:case 13:case 14:break;default:return 0;}return 1;},
A$o=b=>{Z();return XI(b);},
XI=b=>{Z();switch(b){case 9:case 10:case 11:case 12:case 13:case 28:case 29:case 30:case 31:break;case 160:case 8199:case 8239:return 0;default:return UZ(b);}return 1;},
AMn=()=>{AKE=Br(BkA);A9W=Bt(Ok,128);},
A9C=()=>{return {"value":">W  H#F#U 4%F#O #F#/ d%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #a1# #%# #%# #%# %%# #%# #%# #%# #%# #%# #%# #%# %%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #<+#%# #%# #%# \'.3#%# #%# #{1#%# #w1%%# %J\'#k1#o1#%# #w1#!3# #23#*3#%# \'23#:3# #>3#%# #%# #%# #N3#%# #N3# %%# #N3#%# #J3%%# #%# #R3#%# \'%# /)#%# #)#%# #)#%# #%# #%# #%# #%# #%# #%# #%# #%# %%# #%# #%# #%# #%# #%# #%# #%# #%# %)#%# #%# #8)#L%#%# #%# #%# #"
+"%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #a+# #%# #%# #%# #%# #%# #%# #%# #%# #%# /B45#%# #,/#645# %%# #P1#!\'#*\'#%# #%# #%# #%# #%# <-%# #%# \'%# 1&++ %_## #Z#)k%%g%% #F#W hA# 1%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# +]%# %%# #?#%# %a+\'N\'AF#b &#%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# 3%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #^#%# #%# #%# #%# #%# #%# #%# %%# #%# #%# #%# #%# #%# #%# #%"
+"# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# %*%r iB#oq-&# _?gejg#A1 o$#mo%&# {-%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# 3,4/# #%# #%# #%"
+"# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# 3C1 1C1 1C1 1C1 1C1 3C/ 1C1 QC1 1C1 1C1 1C%8\'%G# 7i\')G# 7C%D)\' 7C%u)%?# 7X+%P+%G# L-q*/# \'Pw/#8m/# -6## |bA G%# kC.#U !r*%&# &#%# #,05#qX\'#H.5# %%# #%# #%# #e25#D05#q25#m25# #%# %%# 1865%%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# "
+"#%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# 1%# #%# )%# (a=%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# G%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# y%%# #%# #%# #%# #%# #%# #%# \'%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #%# 5%# #%# #4Fd#%# #%# #%# #%# #%# )%# #<{p# %%# #%# \'%# #%# #%# #%# #%# #%# #%# #%# #%# #%# #P}p#}}p#m}p#D}p#P}p# #@yp#D{p#Lyp#Br#%# #%# #%# #%"
+"# #%# #%# #%# #%# #,%#L}p#LJd#%# #%# -%# +%# #%# Y%# ,T5F#U TUg#r {%g#r >\'c#p Lnk%F# *J#F#b o@5F#b Jo=N#f "};},
BbG=()=>{return {"value":"<Y  ,%H#U :#>b# vH#O #H#/:+# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #,5# #\'# #\'# #\'# %\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# %\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# %\'# #\'# #\'#(;#N1# %\'# #\'# %\'# \'\'# +\'# %6)# \'\'#*/# \'_+# %\'# #\'# #\'# %\'# )\'# %\'# \'\'# #\'# %\'# \'\'# #J%# +\'#+# #\'#+# #\'#+# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'#L\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# %\'#+# #\'# \'\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'#"
+" #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# \'\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# 1\'# %665% #\'# )\'# #\'# #\'# #\'# #\'#o25#c25#k25#03#}1# #y1% #m1# #q1#{}p# \'y1#k}p# #$3# #:{p#N}p# #,3#43#N}p#*05#B}p# %43# #B05#<3# %@3# /F.5# %P3# #J}p#P3# \'B{p#P3#$\'#L3%,\'# +T3# 5Jyp#>yp# Z\'_\'# x\'# #\'# \'\'\' #_+\' !#a##]#\' #H#CD##H#3m%#i%% #e%#P%# \'(%#D%#C# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'#i\'#P\'#=#(+# #4)# %\'# %\'# .#H#bP\'A #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# 3\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# "
+"#\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# %\'# #\'# #\'# #\'# #\'# #\'# #\'#`# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'% &#,%n mB#ko%x %ko%\' RAC1 >$#yu+#uu+#Pu+#Hu+%Lu+#0u+#io+#>@d1 (+2Fd# \'oX\'# AJJd# N%\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #"
+"\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# +X%# +\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'#A1 1A1 1A1 1A1 1A1 3A# #A# #A# #A% /A1 16\'%g\')B)%V+%s)%N+)A1 1A1 1A1 1A% #E# 5<m-# )E# 9A% =A% \'=# ;E# R/8## ddA )\'# @E0#U Nr,%&# #\'# \'D45#845# #\'# #\'# #\'# -"
+"\'# %\'# 5\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# 1\'# #\'# )\'- /qq-&# i]=\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# G\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# y%\'# #\'# #\'# #\'# #\'# #\'# #\'# \'\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'#"
+" #\'# #\'# #\'# #\'# 5\'# #\'# %\'# #\'# #\'# #\'# #\'# )\'# )\'# #\'#*%# %\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# 7\'# #\'# #\'# #\'# #\'# #\'# #\'# #\'# )\'# #\'- #\'% )\'# #\'S )\'# cEDr# Yiejg# e*5H#U eUi#r {%i#r <\'e#<% Vlm%:# RH#H#b o@5H#b No=P#f "};},
AYI=()=>{return {"value":"&C*% %%%%%%%%%%%%%%%%%%A%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%=,#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%_H#T#%%%%%%%%%%%%%%%%%%s+G%%%%%%%%%%%%%%%%%%_1G%%%%%%%%%%%%%%%%%%{CG%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%6)G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%*\'G%%%%%%%%%%%%%%%%%%.9G%%%%%%%%%%%%%%%%%%*\'G%%%%%%%%%%%%%%%%%%!i#G"
+"%%%%%%%%%%%%%%%%%%c#G%%%%%%%%%%%%%%%%%%*;G%%%%%%%%%%%%%%%%%%Z+G%%%%%%%%%%%%%%%%%%:/G%%%%%%%%%%%%%%%%%%=G%%%%%%%%%%%%%%%%%%{/G%%%%%%%%%%%%%%%%%%k\'G%%%%%%%%%%%%%%%%%%s+G%%%%%%%%%%%%%%%%%%=G%%%%%%%%%%%%%%%%%%R@dG%%%%%%%%%%%%%%%%%%R[G%%%%%%%%%%%%%%%%%%c#G%%%%%%%%%%%%%%%%%%_1G%%%%%%%%%%%%%%%%%%!#G%%%%%%%%%%%%%%%%%%k\'G%%%%%%%%%%%%%%%%%%cCG%%%%%%%%%%%%%%%%%%o*IG%%%%%%%%%%%%%%%%%%A%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%=,#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%c:#T#%%%%%%%%%%%%%%%%%%w&%G%%%%%"
+"%%%%%%%%%%%%%BhG%%%%%%%%%%%%%%%%%%Z+G%%%%%%%%%%%%%%%%%%_%G%%%%%%%%%%%%%%%%%%>-G%%%%%%%%%%%%%%%%%%.9G%%%%%%%%%%%%%%%%%%w=G%%%%%%%%%%%%%%%%%%2+G%%%%%%%%%%%%%%%%%%>AG%%%%%%%%%%%%%%%%%%N)G%%%%%%%%%%%%%%%%%%N)G%%%%%%%%%%%%%%%%%%FEG%%%%%%%%%%%%%%%%%%N)G%%%%%%%%%%%%%%%%%%!dG%%%%%%%%%%%%%%%%%%g5G%%%%%%%%%%%%%%%%%%*\'G%%%%%%%%%%%%%%%%%%FEG%%%%%%%%%%%%%%%%%%*0EG%%%%%%%%%%%%%%%%%%k\'G%%%%%%%%%%%%%%%%%%s+G%%%%%%%%%%%%%%%%%%28UG%%%%%%%%%%%%%%%%%%%G%%%%%%%%%%%%%%%%%%%G%%%%%%%%%%%%%%%%%%%G%%%%%%%%%%%%%%%%%%%G%%%%%%%%%%%%%%%"
+"%%%!8%G%%%%%%%%%%%%%%%%%%FEG%%%%%%%%%%%%%%%%%%sKG%%%%%%%%%%%%%%%%%%>&#G%%%%%%%%%%%%%%%%%%wN)G%%%%%%%%%%%%%%%%%%"};},
Bje=()=>{return {"value":"PA-Y$;Y$679:95Y#J+Y#Z$Y#B;697<8<C;6:7:PB-9[%=9<=&>:1=<=:L#<#Y#<,&?L$9B8:B(C9:C)!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!C#!#!#!#!#!#!#!#!C#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#B##!#!C$B##!#B##B$C#B%#B##B$C$B##B##!#!#B##!C#!#B##B$#!#B#C#&!C$F%!$#!$#!$#!#!#!#!#!#!#!#!C#!#!#!#!#!#!#!#!#!C#!$#!#B$#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!C(B##B#C#!#B%#!#!#!#!Cg&C<E3]%E-]/E&](%<%]2b\'Q! !#!#%<!#A#%C$9!A%]#!9B$ ! B##B2 B*CD!C#B$C$!#!#!#!#!#!#!#!#!#!#!#!C&!#:!#B#C#BTCQ!#!#!#!#"
+"!#!#!#!#!#!#!#!#!#!#!#!#!#=G&H#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#B##!#!#!#!#!#!C#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!# BGA#%Y\'CJ95A#^#; GN5\'9G#9G#9\'A)F<A%F%Y#A,Q\'Z$Y#;Y#^#G,91Y$FA%F+G6J+Y%F#\'b&D! 9&G(1=G\'E#G#=G%F#J+F$^#&Y/ 1&\'F?G<A#b&:! G,&A/J+FBG*E#=Y$%A#\'[#F7G%%G*%G$%G&A#Y0 F:G$A#9 F,A&F9<F\' Q#A\'G)FJ%G91GA)FW\')\'&I$G)I%\'I#&G(F+G#Y#J+9%F0\'I# F)A#F#A#F7 F( &A$F%A#\'&I$G%A#I#A#I#\'&A))A%F# F$G#A#J+F#[#L\'=;&9\'A#G#) F\'A%F#A#F7 F( F# F#"
+" F#A#\' I$G#A%G#A#G$A$\'A(F% &A(J+G#F$\'9A+G#) F* F$ F7 F( F# F&A#\'&I$G& G#) I#\'A#&A0F#G#A#J+9;A(&G\' \'I# F)A#F#A#F7 F( F# F&A#\'&)\')G%A#I#A#I#\'A(G#)A%F# F$G#A#J+=&L\'A+\'& F\'A$F$ F%A$F# & F#A$F#A$F$A$F-A%I#\'I#A$I$ I$\'A#&A\')A/J+L$^\';=A&\'I$\'F) F$ F8 F1A#\'&G$I% G$ G%A(G# F$A#&A#F#G#A#J+A(9L(=&\'I#9F) F$ F8 F+ F&A#\'&)\'I& \'I# I#G#A(I#A\'F# F#G#A#J+ F#)A-G#I#F* F$ FJG#&I$G% I$ I$\'&=A%F$)L(F$G#A#J+L*=F\' \'I# F3A$F9 F* &A#F(A$\'A%I$G$ \' I)A\'J+A#I#9A-FQ\'F#G(A%;F\'%G)9J+Y#AFF# & F& F9 & F+\'F#G*&A#F& % G( J+A#F%AA&^$Y0=9^$G#^\'J+"
+"L+=\'=\'=\'6767I#F) FEA%G/)G&9G#F&G, GE ^)\'^\' ^#Y&^%Y#AFFLI#G%)G\')G#I#G#&J+Y\'F\'I#G#F%G$&I$F#I(F$G%F.\'I#G#I\'\'&)J+I$\'^#BG !A&!A#CL9%C$b&*&  F%A#F( & F%A#FJ F%A#FB F%A#F( & F%A#F0 FZ F%A#FeA#G$Y*L5A$F1^+A\'b!7! A#C\'A#5b&M* =9F2-F;67A$FmY$K$F)A(F3G$)A*F4G#)Y#A*F3G#A-F. F$ G#A-FUG#)G(I)\'I#G,Y$%Y$;&\'A#J+A\'L+A\'Y\'5Y%G$1\'J+A\'FD%FVA(F&G#FC\'&A&FhA+F@ G$I%G#I$A%I#\'I\'G$A%=A$Y#J+F?A#F&A,FMA%F;A\'J+,A$^CF8G#I#\'A#Y#FV)\')G( \')\'I#G)I\'G+A#\'J+A\'J+A\'Y(%Y\'A#G/(G1ARG%)FP\')G&)\'I&\'I#F)A$J+Y(^+G*^*Y# G#)F?)G%I#G#)G$F#J+FM\')G#I$\')G$I#A)Y%"
+"FEI)G)I#G#A$Y&J+A$F$J+F?E\'Y#C*A(BLA#B$Y)A)G$9G.)G(F%\'F\'\'F#)G#&A&CMEaC.%CCEFGb!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!C*!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!C*B)C\'A#B\'A#C)B)C)B)C\'A#B\'A#C) ! ! ! !C)B)C/A#C)D)C)D)C)D)C& C#B%$<#]$C$ C#B%$]$C%A#C#B% ]$C)B&]$A#C$ C#B%$]# M,Q&U\'Y#>?6_#?6>Y)./Q&-Y*>?Y%X#Y$:67Y,:98Y+-Q& Q+,%A#L\'Z$67%L+Z$67 E.A$[BA0G."
+"H%\'H$G-A0^#!^%!^##B$C#B$#=!^#:B&^\'!=!=!=B%=#B%#F%#^#C#B#Z&!C%=:^##=L1KD!#K%,^#A%Z&^&Z#^%:^#:^#:^(:^@Z#^#:=:^@b:-% ^)6767^5Z#^(67b=2! :^?Z:^IZ\'^gA:^,A6L^^pL7b=X# :^*:^WZ)b=P! :b=Y$ 67676767676767L?^MZ&67Z@6767676767Z1b= % b:$# 6767676767676767676767Za6767ZA67b:#% ^QZ6^#Z\'^HA#^A b=J! BQCQ!#B$C#!#!#!#B%#!C#!C\'E#B$#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!C#^\'!#!#G$!#A&Y%,Y#CG #A&#A#FYA(%9A/\'F8A*F( F( F( F( F( F( F( F( GAY#>?>?Y$>?9>?Y*5Y#59>?Y#>?67676767Y"
+"&%Y+U#Y%596Y.^#Y$676767675AC^; b=:! A-b=7$ A;^1-Y$=%&+6767676767^#6767676756W#=K*G%I#5E&^#K$%&9^# b&7! A#G#]#E#&5b&;! 9E$&A&FL b&?!  ^#L%^+FA^EA,=F1^@ L+^?L)=L0^AL+^HL0b= & &b `G!&^b&b   %b `(!F7%b&X2 A$^XA*FIE\'Y#b&-% %Y$F1J+F#A5!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#&\'H$9G+9%!#!#!#!#!#!#!#!#!#!#!#!#!#!#E#G#FhK+G#Y\'A)]8E*]#!#!#!#!#!#!#!C$!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#!#%C)!#!#B##!#!#!#!#%]#!#!#&!#!C$!#!#!#!#!#!#!#!#!#!#B&#B&#!#!#!#!#!#!#!#B%#!#A&!# # #!#!#A9E$!#&E##F(\'F$"
+"\'F%\'F8I#G#)^%\'A$L\'^#;=A\'FUY%A)I#FSI1G#A)Y#J+A\'G3F\'Y$&9F#\'J+F=G)Y#F8G,I#A,9F>A$G$)FP\'I#G%I#G#I$Y. %J+A%Y#F&\'%F*J+F& FJG\'I#G#I#G#A*F$\'F)\')A#J+A#Y%F1%F\'^$&)\')FS\'&G$F#G#F&G#&\'&A9F#%Y#F,)G#I#Y#&E#)\'A+F\'A#F\'A#F\'A*F( F( CL<E%C*%]#A%b#1! FDI#\'I#\'I#9)\'A#J+A\'&b CO#&A-F8A%FRA%4b `. T#b `! T#b `0 43b `D!3b&O& A#b&K! AGC(A-C&A&&\'F+:F. F& & F# F# b&M! ]2A1b&L& 76^1FbA#FWA(=AAF-;^$G1Y(679A\'G19U#X#6767676767676767Y#67Y%X$Y$ Y%5676767Y$:5Z$ 9;Y#A%F& b&(# A#1 Y$;Y$679:95Y#J+Y#Z$Y#B;697<8<C;6:7:67967Y#F+%FNE#F@A$F\'A#F\'A#F\'A#F"
+"$A$[#:<=[# =Z%^#A+Q$^#A#F- F; F4 F# F0A#F/ACb&]! A&Y$A%LNA$^*KVL%^2L#^$ ^.A$=AP^N\'b ## F>A$FRA0\'L<A%FAL%A*F5+F)+A&FGG&A&F? 9FEA%F)9K&AKBICIFpA#J+A\'BEA%CEA%FIA)FUA,9B, B0 B( B# C, C0 C( C#Aeb&X% A*F7A+F)A9E\' EK E*AgF\'A#& FM F#A$&A#F8 9L)F8^#L(F@A)L*AQF4 F#A&L&F7L\'A$9F;A&9AbFYA%L#F#L1A#LO&G$ G#A&G%F% F$ F>A#G$A%\'L*A(Y*A(F>L#9F>L$AAF)=F=G#A%L&Y(A*FWA$Y(F7A#L)F4A&L)F3A(Y%A-L(b 1! FkAXBTA.CTA(L\'FEG%A)J+b G% L@ FK G#5A#F#AmG$F>L+&A)F7G,L%Y&A7F3G%Y%AGF6L(A5F8A*)\')FVG0Y(A%L5J+\'F#G#&A*G$)FNI$G%I#G#Y#1Y%\'A+1A#F:A(J+A"
+"\'G$FEG&)G) J+Y%&I#&A)FD\'Y#&A*G#)FQI$G*I#F%Y%G%9)\'J+&9&Y$ L5A,F3 F:I$G$I#\')G#Y\'\'F#\'A`F( & F% F0 F+9A\'FP\'I$G)A&J+A\'G#I# F)A#F#A#F7 F( F# F& G#&I#\'I%A#I#A#I$A#&A\')A&F&I#A#G(A$G&b ,# FVI$G)I#G$)\'F%Y&J+Y# 9\'F$A?FQI$G\')\'I%G#)G#F#9&A)J+b G# FPI$G%A#I%G#)G#Y8F%G#ACFQI$G)I#\')G#Y$&A,J+A\'Y.A4FL\')\'I#G\')\'&9A\'J+AWF<A#G$I#G%)G&A%J+L#Y$=F(b Z# FMI$G*)G#9b E! BACAJ+L*A-F)A#&A#F) F# F9I\' I#A#G#)\'&)&)\'Y$A*J+AhF)A#FHI$G%A#G#I%\'&9&)A<&G+FIG\')&G%Y)\'A)&G\'I#G$FOG.)G#Y$&Y&A.FkA(Y+b W$ F* FF)G( G\')\'&Y&A+J+L4A$Y#F?A#G7 )G()G#)G#AkF( "
+"F# FGG\'A$\' G# G(&\'A)J+A\'F\' F# FAI& G# I#\')\'&A(J+b W% F4G#I#Y#A(G#&)F. FCI#G&A$I#\')\'Y.J+b 7! &A0L6^)[%^2A.9b&;/ b G! b+P!  Y&A,b&%$ b -J b&B! Y#A.b&Q1 Q1\'F\'G0b K` b&(* b Z\'#b&Z) A(F@ J+A%Y#Fq J+A\'F?A#G&9A+FQG(Y&^%E%9=A+J+ L( F6A&F4b Q+ BACAL8Y%b F! FmA%\'&IXA(G%E.AbE#9%\'A,I#A/&b W@!&A)b&74 AK&A(&b H,#E% E( E# b&D% A0&A>F$A#&A/F%A)b&-\' b %E b&L! A&F.A$F*A(F+A#=G#9Q%b =*!GOA#G8A*b=U! A^b=W$ A+^HA#^^I#G$^$I\'Q)G)^#G(^?G%^_A6^dG$=b [! L5A-L5A-b=8! A*L:b (# B;C;B;C( C3B;C;! B#A#!A#B#A#B% B)C% # C( C,B;C;B# B%A#B) B"
+"( C;B# B% B& !A$B( C;B;C;B;C;B;C;B;C;B;C;B;C=A#B::C::C\'B::C::C\'B::C::C\'B::C::C\'B::C::C\'!#A#JSb= ) GX^%GS^)\'^/\'^#Y&A0G& G0b 12 C+&C5A\'C\'b 6$ G( G2A#G( G# G&A&E`AB\'b Q! FNA$G(E(A#J+A%&=b  & F?\'A2FMG%J+A&;b 1( F<%G%J+b G, F( F% F# F0 b&&$ A#L*G(AJBCCCG(%A%J+A%Y#b 2- L]=L$;L%AnLN=L0b #$ F% F< F# &A#& F+ F% & &A\'&A%& & & F$ F# &A#& & & & & F# &A#F% F( F% F% & F+ F2A&F$ F& F2AUZ#b /% ^MA%b=E! A-^0A#^0 ^0 ^FA+L.b=B# AY^>A.^MA%^*A(^#A/^\'b ;# b=]$ ]&b=9, A%^2A$^.A$b=X! A%b=@! A\'^-A%=A0^-A%^YA)^+A\'^IA)^?A#^#Apb=5& A-"
+"^/A#^.A$^*A(^O ^(A)^/A%^*A(^*A(b=4#  ^XAFJ+b \'1 &b   %b   %b ?<#&AA&b Y !&A\'&b =$ &A#&b  ;!&A/&b PU!&A0&b M* &b CG b&?) b C8 &b *.!&A&&b ?!!&b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b   %b 2R!1A?b1A! b  # b\'Q$ b   %b   %b   %b 1Y$3b   %b   %b   %b ^a$3A#3b   %b   %b   %b ^a$3"};};
function QV(){let a=this;BM.call(a);a.F4=0;a.Dz=0;}
let AD_=(a,b)=>{CO(a);a.F4=b;a.Dz=FS(b);},
TR=a=>{let b=new QV();AD_(b,a);return b;},
AKA=(a,b,c)=>{return a.F4!=c.bc(b)&&a.Dz!=c.bc(b)?(-1):1;};
function Df(){let a=this;BM.call(a);a.A$=0;a.Af=0;a.z9=0;}
let AIb=(a,b)=>{let c,d;CO(a);a.wj=2;a.z9=b;c=Gf(b);d=c.data;a.A$=d[0];a.Af=d[1];},
AOa=a=>{let b=new Df();AIb(b,a);return b;},
A_p=(a,b,c)=>{let d,e,f;d=b+1|0;e=c.bc(b);f=c.bc(d);return a.A$==e&&a.Af==f?2:(-1);},
A6g=(a,b,c,d)=>{let e,f,g,h;if(!(c instanceof BG))return FY(a,b,c,d);e=c;f=d.bq();while(b<f){g=e.e3(a.A$,b);if(g<0)return (-1);b=g+1|0;if(b>=f)continue;h=e.bc(b);if(a.Af==h&&a.vN.br(b+1|0,c,d)>=0)return b+(-1)|0;b=b+1|0;}return (-1);},
APK=(a,b,c,d,e)=>{let f,g,h;if(!(d instanceof BG))return F$(a,b,c,d,e);f=d;a:{while(true){if(c<b)return (-1);g=f.e4(a.Af,c);h=g+(-1)|0;if(h<0)break a;if(h<b)break a;if(a.A$==f.bc(h)&&a.vN.br(h+2|0,d,e)>=0)break;c=h+(-1)|0;}return h;}return (-1);},
AJ7=a=>{return a.z9;},
A$Z=(a,b)=>{if(b instanceof Df)return b.hC()!=a.z9?0:1;if(b instanceof CP)return b.b6(a.z9);if(b instanceof Dr)return 0;if(!(b instanceof Di))return 1;return 0;};
let A6M=B();
let Ben=B(B0);
let A4Y=B();
let BhR=B();
let A96=B();
let Jw=B(Bm);
let AS2=null;
let Jc=()=>{Jc=N(Jw);ARp();};
let ADj=(a,b)=>{Jc();BR(a);},
A4B=a=>{let b=new Jw();ADj(b,a);return b;},
ACh=(a,b)=>{Jc();BR(a);},
BiQ=a=>{let b=new Jw();ACh(b,a);return b;},
AZz=(a,b)=>{AZW(U((a.fg())),b);},
A3m=a=>{return A1B(U((a.fg())))?1:0;},
Bf1=(a,b,c,d,e)=>{let f,g,h,i,j;f=U((a.fg()));g=U((b.fg()));h=U((c.fg()));i=U((d.fg()));j=U((e.fg()));AV7(f,g,h,i,j);},
A0z=(a,b)=>{Baf(U((a.fg())),b);},
A4P=(a,b)=>{AXW(U((a.fg())),b);},
BhM=(a,b,c)=>{A3t(U((a.fg())),b,!!c);},
AZZ=(a,b,c)=>{A8I(U((a.fg())),b,c);},
A73=(a,b,c)=>{A6L(U((a.fg())),b,!!c);},
ARo=(a,b,c)=>{A9H(U((a.fg())),b,c);},
ARp=()=>{AS2=A4B(0);},
AZW=(b,c)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);io.set_ConfigFlags(c);},
A1B=b=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);return io.get_WantCaptureMouse();},
AV7=(b,c,d,e,f)=>{var io=imgui.wrapPointer(b,imgui.IDLImGuiIO);var widthIntArray=imgui.wrapPointer(d,imgui.IDLIntArray);var heightIntArray=imgui.wrapPointer(e,imgui.IDLIntArray);var bytesPerPixelArray=imgui.wrapPointer(f,imgui.IDLIntArray);var pixelBufferArray=imgui.wrapPointer(c,imgui.IDLByteArray);var widthArr=widthIntArray.getPointer();var heightArr=heightIntArray.getPointer();var bytesPerPixelArr=bytesPerPixelArray.getPointer();var pixelBufferArr=pixelBufferArray.getPointer();imgui.ImHelper.prototype.memcpyFont(io,
pixelBufferArr,widthArr,heightArr,bytesPerPixelArr);},
Baf=(b,c)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);(io.get_Fonts()).set_TexID(c);},
AXW=(b,c)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);if(c>0&&c<0x10000)io.AddInputCharacter(c);},
A3t=(b,c,d)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);io.AddKeyEvent(c,d);},
A8I=(b,c,d)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);io.AddMousePosEvent(c,d);},
A6L=(b,c,d)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);io.AddMouseButtonEvent(c,d);},
A9H=(b,c,d)=>{var io=imgui.wrapPointer(b,imgui.ImGuiIO);io.AddMouseWheelEvent(c,d);};
function I9(){let a=this;A.call(a);a.xp=0;a.w_=null;a.xc=null;a.xL=null;a.yt=0;a.Ej=0.0;a.Bh=0;a.BS=0;a.yk=0;}
let AHU=a=>{HT(a,51,0.800000011920929);},
Cw=()=>{let a=new I9();AHU(a);return a;},
AEB=(a,b)=>{HT(a,b,0.800000011920929);},
AOV=a=>{let b=new I9();AEB(b,a);return b;},
HT=(a,b,c)=>{let d;L(a);if(c>0.0&&c<1.0){a.Ej=c;d=Jn(b,c);a.Bh=d*c|0;a.yk=d-1|0;a.BS=DU(Q(a.yk));a.w_=Bp(d);a.xc=Bt(A,d);return;}I(B3((((O()).O(D(401))).hR(c)).y()));},
BlJ=(a,b)=>{let c=new I9();HT(c,a,b);return c;},
AW9=(a,b)=>{return U(BV(Bx(Q(b),C(2135587861, 2654435769)),a.BS));},
Lx=(a,b)=>{let c,d,e;c=a.w_;d=a.pc(b);while(true){e=c.data[d];if(!e)return  -(d+1|0)|0;if(e==b)break;d=(d+1|0)&a.yk;}return d;},
AXB=(a,b,c)=>{let d,e,f;if(!b){d=a.xL;a.xL=c;if(!a.yt){a.yt=1;a.xp=a.xp+1|0;}return d;}e=Lx(a,b);if(e>=0){d=a.xc.data[e];a.xc.data[e]=c;return d;}f= -(e+1|0)|0;a.w_.data[f]=b;a.xc.data[f]=c;f=a.xp+1|0;a.xp=f;if(f>=a.Bh)Bbg(a,a.w_.data.length<<1);return null;},
ARm=(a,b,c)=>{let d,e,f;d=a.w_;e=a.pc(b);while(true){f=d.data;if(!f[e])break;e=(e+1|0)&a.yk;}f[e]=b;a.xc.data[e]=c;},
Bju=(a,b)=>{let c;if(!b)return !a.yt?null:a.xL;c=Lx(a,b);return c<0?null:a.xc.data[c];},
Bfi=(a,b)=>{let c,d,e,f,g,h,i,j,k,l;if(!b){if(!a.yt)return null;a.yt=0;c=a.xL;a.xL=null;a.xp=a.xp-1|0;return c;}d=Lx(a,b);if(d<0)return null;e=a.w_;f=a.xc;g=f.data;c=g[d];h=a.yk;i=(d+1|0)&h;while(true){j=e.data;k=j[i];if(!k)break;l=a.pc(k);if(((i-l|0)&h)>((d-l|0)&h)){j[d]=k;g[d]=g[i];d=i;}i=(i+1|0)&h;}j[d]=0;g[d]=null;a.xp=a.xp-1|0;return c;},
Bim=(a,b,c)=>{let d,e,f,g;a:{d=a.xc;if(b===null){if(a.yt&&a.xL===null)return 1;e=d.data;f=a.w_;g=e.length-1|0;while(true){if(g<0)break a;if(f.data[g]&&e[g]===null)break;g=g+(-1)|0;}return 1;}if(c){if(b===a.xL)return 1;e=d.data;g=e.length-1|0;while(true){if(g<0)break a;if(e[g]===b)break;g=g+(-1)|0;}return 1;}if(a.yt&&b.bi(a.xL))return 1;e=d.data;g=e.length-1|0;while(true){if(g<0)break a;if(b.bi(e[g]))return 1;g=g+(-1)|0;}}return 0;},
Bbg=(a,b)=>{let c,d,e,f,g;d:{c=a.w_.data.length;a.Bh=b*a.Ej|0;a.yk=b-1|0;a.BS=DU(Q(a.yk));d=a.w_;e=a.xc;a.w_=Bp(b);a.xc=Bt(A,b);if(a.xp>0){f=0;while(true){if(f>=c)break d;g=d.data[f];if(g)ARm(a,g,e.data[f]);f=f+1|0;}}}};
function JP(){let a=this;A.call(a);a.H_=0.0;a.H7=0.0;a.H8=0.0;a.H$=0.0;}
let AYG=null,AYF=null;
let Je=()=>{Je=N(JP);AYs();};
let V0=(a,b,c,d,e)=>{Je();L(a);a.qZ(b,c,d,e);},
ADM=(a,b,c,d)=>{let e=new JP();V0(e,a,b,c,d);return e;},
XW=a=>{Je();L(a);a.q0();},
FI=()=>{let a=new JP();XW(a);return a;},
ATW=(a,b,c,d,e)=>{a.H_=b;a.H7=c;a.H8=d;a.H$=e;return a;},
Bh1=a=>{return a.qZ(0.0,0.0,0.0,1.0);},
AYs=()=>{AYG=ADM(0.0,0.0,0.0,0.0);AYF=ADM(0.0,0.0,0.0,0.0);};
let AHd=B(Dt);
let AY5=null;
let X$=()=>{X$=N(AHd);AVD();};
let AVD=()=>{AY5=Cq(3);};
let A4r=B(Eb);
function ZE(){T.call(this);this.Ha=null;}
let Wc=(a,b)=>{a.Ha=b;Bh(a);},
A8K=a=>{let b=new ZE();Wc(b,a);return b;},
AVz=(a,b)=>{return 0;};
let RL=B(FN);
let AAj=(a,b,c,d,e,f,g)=>{Ol(a,b,c,d,e,f,g);},
Bed=(a,b,c,d,e,f)=>{let g=new RL();AAj(g,a,b,c,d,e,f);return g;},
ARr=(a,b)=>{let c,d,e,f;c=a.xb.vS.data;d=a.xm;e=b*2|0;f=c[d+e|0]&255|(a.xb.vS.data[(a.xm+e|0)+1|0]&255)<<8;return f<<16>>16;},
AP9=(a,b,c)=>{let d,e,f;d=a.xb.vS.data;e=a.xm;f=b*2|0;d[e+f|0]=c<<24>>24;a.xb.vS.data[(a.xm+f|0)+1|0]=c>>8<<24>>24;};
function AFQ(){Bw.call(this);this.zp=0;}
let Ww=(a,b)=>{Cd(a);a.zp=b;},
A3u=a=>{let b=new AFQ();Ww(b,a);return b;},
A1V=(a,b,c,d)=>{let e;e=!d.ia()?c.bb():d.bq();if(b>=e){d.c7(a.zp,0);return a.vN.br(b,c,d);}if((e-b|0)==1&&c.bc(b)==10){d.c7(a.zp,1);return a.vN.br(b+1|0,c,d);}return (-1);},
AWi=(a,b)=>{let c;c=!b.bS(a.zp)?0:1;b.c7(a.zp,(-1));return c;};
function HF(){Bz.call(this);this.H5=null;}
let DP=null,Dz=null,DS=null,DJ=null,GQ=null,AH0=null;
let CM=()=>{CM=N(HF);A7u();};
let T3=()=>{CM();return AH0.b$();},
AYH=(a,b,c,d)=>{CM();Ce(a,b,c);a.H5=d;},
F6=(a,b,c)=>{let d=new HF();AYH(d,a,b,c);return d;},
A7u=()=>{DP=F6(D(423),0,D(237));Dz=F6(D(424),1,D(239));DS=F6(D(425),2,D(426));DJ=F6(D(427),3,D(238));GQ=F6(D(428),4,D(71));AH0=H(HF,[DP,Dz,DS,DJ,GQ]);};
let ACf=B();
let GZ=null;
let Zd=()=>{Zd=N(ACf);AQF();};
let AQF=()=>{GZ=Bp((Sa()).data.length);GZ.data[Bl(HE)]=1;GZ.data[Bl(Hf)]=2;GZ.data[Bl(HY)]=3;};
let BfX=B(BC);
function AG6(){BM.call(this);this.Db=0;}
let ABl=(a,b)=>{CO(a);a.Db=Et(D4(b));},
ADJ=a=>{let b=new AG6();ABl(b,a);return b;},
AJg=(a,b,c)=>{return a.Db!=Et(D4(c.bc(b)))?(-1):1;};
let Mx=B();
let A7A=B(Mx);
let AYD=B(Oy);
function D$(){let a=this;CB.call(a);a.x_=null;a.w1=0;}
let FD=(a,b,c,d,e,f)=>{Es(a,c,d,e);a.x_=b;a.w1=f;},
Bk2=(a,b,c,d,e)=>{let f=new D$();FD(f,a,b,c,d,e);return f;},
BjF=(a,b,c,d)=>{let e,f,g,h;e=d.q2(a.w1);if(!a.vY.ca(d))return a.vN.br(b,c,d);if(e>=a.x_.hz())return a.vN.br(b,c,d);f=a.w1;g=e+1|0;d.q3(f,g);h=a.vY.br(b,c,d);if(h>=0){d.q3(a.w1,0);return h;}f=a.w1;g=g+(-1)|0;d.q3(f,g);if(g>=a.x_.hy())return a.vN.br(b,c,d);d.q3(a.w1,0);return (-1);};
let Os=B(D$);
let NL=(a,b,c,d,e,f)=>{FD(a,b,c,d,e,f);},
BkF=(a,b,c,d,e)=>{let f=new Os();NL(f,a,b,c,d,e);return f;},
AMd=(a,b,c,d)=>{let e,f;e=d.q2(a.w1);if(!a.vY.ca(d))return a.vN.br(b,c,d);if(e>=a.x_.hz()){d.q3(a.w1,0);return a.vN.br(b,c,d);}if(e<a.x_.hy()){d.q3(a.w1,e+1|0);f=a.vY.br(b,c,d);}else{f=a.vN.br(b,c,d);if(f>=0){d.q3(a.w1,0);return f;}d.q3(a.w1,e+1|0);f=a.vY.br(b,c,d);}return f;};
function KX(){let a=this;K1.call(a);a.wD=null;a.wG=0;}
let Wg=a=>{J9(a,10);},
ACv=()=>{let a=new KX();Wg(a);return a;},
J9=(a,b)=>{X8(a);if(b>=0){a.wD=Bt(A,b);return;}I(CF());},
BlB=a=>{let b=new KX();J9(b,a);return b;},
AMl=(a,b)=>{let c;if(a.wD.data.length<b){c=a.wD.data.length>=1073741823?2147483647:BT(b,BT(a.wD.data.length*2|0,5));a.wD=H8(a.wD,c);}},
A_i=(a,b)=>{Q3(a,b);return a.wD.data[b];},
A8j=a=>{return a.wG;},
Bfp=(a,b)=>{let c,d;a.ce(a.wG+1|0);c=a.wD.data;d=a.wG;a.wG=d+1|0;c[d]=b;a.xJ=a.xJ+1|0;return 1;},
A0n=(a,b,c)=>{let d;ASo(a,b);a.ce(a.wG+1|0);d=a.wG;while(d>b){a.wD.data[d]=a.wD.data[d-1|0];d=d+(-1)|0;}a.wD.data[b]=c;a.wG=a.wG+1|0;a.xJ=a.xJ+1|0;},
A_P=(a,b)=>{let c,d,e,f;Q3(a,b);c=a.wD.data[b];a.wG=a.wG-1|0;while(b<a.wG){d=a.wD.data;e=a.wD.data;f=b+1|0;d[b]=e[f];b=f;}a.wD.data[a.wG]=null;a.xJ=a.xJ+1|0;return c;},
Q3=(a,b)=>{if(b>=0&&b<a.wG)return;I(Ch());},
ASo=(a,b)=>{if(b>=0&&b<=a.wG)return;I(Ch());};
let Rb=B();
let I$=null;
let NR=()=>{NR=N(Rb);Baq();};
let Baq=()=>{I$=Bp((AVk()).data.length);I$.data[Bl(JE)]=1;I$.data[Bl(Gq)]=2;};
let WT=B(Bi);
let AAm=a=>{B9(a);},
ON=()=>{let a=new WT();AAm(a);return a;};
let A7H=B(Bq);
function Kc(){A.call(this);this.xS=null;}
let T2=(a,b)=>{a.xS=b;L(a);},
Baw=a=>{let b=new Kc();T2(b,a);return b;},
AUx=(a,b)=>{let c,d,e,f,$$je;c=Ba((a.xS.xG.gV()).visibilityState);if(!D(429).bi(c)){d=a.xS.xV;Eo(d);b:{try{e=a.xS.xV.hv();while(e.bZ()){f=e.b0();f.lU();}CD(d);break b;}catch($$e){$$je=Bb($$e);e=$$je;}CD(d);I(e);}a.xS.x9.lU();}else{d=a.xS.xV;Eo(d);h:{try{e=a.xS.xV.hv();while(e.bZ()){f=e.b0();f.lT();}CD(d);break h;}catch($$e){$$je=Bb($$e);e=$$je;}CD(d);I(e);}a.xS.x9.lT();}},
A$i=(a,b)=>{a.bn(b);};
function Kd(){A.call(this);this.xj=null;}
let SA=(a,b)=>{a.xj=b;L(a);},
AQd=a=>{let b=new Kd();SA(b,a);return b;},
Bjo=(a,b)=>{let c,d,e;c=a.xj.xG.k2()-a.xj.wX.BJ|0;d=a.xj.xG.k3()-a.xj.wX.C$|0;if(c>0&&d>0){if(a.xj.wJ!==null){if(a.xj.wX.AH){e=a.xj.wJ.k4();c=c*e|0;d=d*e|0;}a.xj.wJ.k1(c,d);}return;}},
BgW=(a,b)=>{a.bn(b);};
function Q_(){Cn.call(this);this.GA=null;}
let RG=(a,b)=>{a.GA=b;DT(a);},
ANU=a=>{let b=new Q_();RG(b,a);return b;},
BaW=(a,b,c)=>{return 1;};
let AX0=B();
let AOb=b=>{let c;c=new Float32Array(b);return c;},
Z6=(b,c,d)=>{let e;e=new Float32Array(b,c,d);return e;},
AMr=b=>{let c;c=new Int32Array(b);return c;},
A6N=(b,c,d)=>{let e;e=new Int32Array(b,c,d);return e;},
AZ4=b=>{let c;c=new Int16Array(b);return c;},
AJf=(b,c,d)=>{let e;e=new Int16Array(b,c,d);return e;},
A_F=b=>{let c;c=new Int8Array(b);return c;},
LO=b=>{let c;c=new Int8Array(b);return c;},
AQj=(b,c,d)=>{return new Uint8Array(b,c,d);},
ASI=b=>{return new Uint32Array(b);};
let WK=B(Fw);
let ACP=(a,b,c,d)=>{G5(a,b,c,d);},
AUf=(a,b,c)=>{let d=new WK();ACP(d,a,b,c);return d;},
APB=(a,b,c,d)=>{let e;if(!a.vY.ca(d))return a.vN.br(b,c,d);e=a.vN.br(b,c,d);if(e<0)e=a.vY.br(b,c,d);return e;};
let ACj=B(Bq);
let SQ=a=>{CH(a);},
AOg=()=>{let a=new ACj();SQ(a);return a;};
let ASw=B();
let ATH=(b,c)=>{let d,e,f;d:{d=0;switch(c){case 1:d=2;break d;case 2:d=4;break d;case 3:d=1;break d;default:}}e=b>>>6|0;f=d|e&8;f=f|b<<2&16;e=f|e&32;e=e|(b>>>8|0)&64;e=e|(b>>>5|0)&128;e=e|b&256;e=e|b<<8&512;e=e|b<<10&1024;e=e|b<<1&2048;return e;};
let ACm=B(Bq);
let AFa=a=>{CH(a);},
ALx=()=>{let a=new ACm();AFa(a);return a;};
let A7J=B(Bq);
let A7E=B(Bq);
let ACl=B(Bq);
let AC$=a=>{CH(a);},
AYb=()=>{let a=new ACl();AC$(a);return a;};
let ACo=B(Bq);
let AAM=a=>{CH(a);},
BeA=()=>{let a=new ACo();AAM(a);return a;};
let A4d=B(CG);
let ACn=B(Bq);
let AFx=a=>{CH(a);},
AJe=()=>{let a=new ACn();AFx(a);return a;};
let ACk=B(Bq);
let Yw=a=>{CH(a);},
ALV=()=>{let a=new ACk();Yw(a);return a;};
let ACG=B(0);
let Xd=B();
let X5=a=>{L(a);},
ANe=()=>{let a=new Xd();X5(a);return a;},
AO_=(a,b,c)=>{let d,e;d=Ci();e=O();K(K(K(e,b),D(11)),c);d.d$(S(e));},
A5D=(a,b,c)=>{let d,e;d=AEH();e=O();K(K(K(e,b),D(11)),c);d.d$(S(e));};
let SZ=B(Bw);
let AIj=a=>{Cd(a);},
AQr=()=>{let a=new SZ();AIj(a);return a;},
A1z=(a,b,c,d)=>{return b;},
A8v=(a,b)=>{return 0;};
let AHY=B(Fm);
let Xw=(a,b,c)=>{IT(a,b,c);},
ABy=(a,b)=>{let c=new AHY();Xw(c,a,b);return c;};
let Kp=B(D$);
let NN=(a,b,c,d,e,f)=>{FD(a,b,c,d,e,f);Ez();c.bX(GI);},
Blu=(a,b,c,d,e)=>{let f=new Kp();NN(f,a,b,c,d,e);return f;},
AZw=(a,b,c,d)=>{let e,f,g;e=0;f=a.x_.hz();d:{while(true){g=a.vY.br(b,c,d);if(g<=b)break d;if(e>=f)break;e=e+1|0;b=g;}}if(g<0&&e<a.x_.hy())return (-1);return a.vN.br(b,c,d);};
let AZ2=B(Ei);
function T8(){T.call(this);this.HU=null;}
let AAu=(a,b)=>{a.HU=b;Bh(a);},
A7d=a=>{let b=new T8();AAu(b,a);return b;},
Be4=(a,b)=>{return Bh4(b);};
let A25=B(Ei);
let HV=B(Ic);
let Yi=a=>{Pc(a);},
AHj=()=>{let a=new HV();Yi(a);return a;};
let ABk=B(GE);
let Vp=(a,b,c,d,e,f,g)=>{Ke(a,b,c,d,e,f,g);},
ANM=(a,b,c,d,e,f)=>{let g=new ABk();Vp(g,a,b,c,d,e,f);return g;},
Bct=(a,b)=>{let c,d,e;c=a.wr.vS.data;d=a.ws;e=b*4|0;return (c[d+e|0]&255)<<24|(a.wr.vS.data[(a.ws+e|0)+1|0]&255)<<16|(a.wr.vS.data[(a.ws+e|0)+2|0]&255)<<8|a.wr.vS.data[(a.ws+e|0)+3|0]&255;},
ANr=(a,b,c)=>{let d,e,f;d=a.wr.vS.data;e=a.ws;f=b*4|0;d[e+f|0]=c>>24<<24>>24;a.wr.vS.data[(a.ws+f|0)+1|0]=c>>16<<24>>24;a.wr.vS.data[(a.ws+f|0)+2|0]=c>>8<<24>>24;a.wr.vS.data[(a.ws+f|0)+3|0]=c<<24>>24;};
let Nl=B(Bi);
let AE9=(a,b)=>{Dw(a,b);},
ADL=a=>{let b=new Nl();AE9(b,a);return b;},
T4=a=>{B9(a);},
S8=()=>{let a=new Nl();T4(a);return a;};
function UY(){T.call(this);this.Hn=null;}
let WA=(a,b)=>{a.Hn=b;Bh(a);},
Bfu=a=>{let b=new UY();WA(b,a);return b;},
A$w=(a,b)=>{return UZ(b);};
let AFg=B(E1);
let O2=B(0);
let AZa=B();
let BcL=b=>{return Math.sin(b);},
BiN=b=>{return Math.sqrt(b);},
ASE=b=>{return Math.ceil(b);},
Bj9=(b,c)=>{return A4t(b,c);},
A4t=(b,c)=>{return Math.pow(b,c);},
Jo=b=>{return b+A1W(b)*0.5|0;},
B7=(b,c)=>{if(b<c)c=b;return c;},
BT=(b,c)=>{if(b>c)c=b;return c;},
ANA=b=>{return Math.abs(b);},
A75=b=>{return ANA(b);},
A$I=b=>{return Math.sign(b);},
A1W=b=>{return A$I(b);};
let VR=B(W);
let AD$=a=>{Bn(a);},
AO1=()=>{let a=new VR();AD$(a);return a;},
A6l=a=>{let b;b=A5h(a);b.v3=1;return b;};
function Pt(){let a=this;Ca.call(a);a.Fs=null;a.AB=null;a.zl=0;}
let KC=(a,b,c,d)=>{FO(a);a.zl=(-1);a.Fs=b;a.AB=c;a.zl=d;},
BJ=(a,b,c)=>{let d=new Pt();KC(d,a,b,c);return d;},
BgZ=a=>{let b,c,d,e,f,g;b=D(37);if(a.zl>=1){c=Cr(a.zl);A9$(c,32);b=J2(c);}d=a.Fs;if(a.AB!==null&&a.AB.bb()){e=a.zl;f=a.AB;g=O();K(K(K(K(V(g,e),D(383)),f),D(383)),b);f=S(g);}else f=D(37);g=O();K(K(g,d),f);return S(g);};
let Jr=B(Bm);
let Ma=(a,b)=>{let c;BR(a);c=Q(AZt(b));a.fe(c,1);},
Bls=a=>{let b=new Jr();Ma(b,a);return b;},
Bhy=(a,b)=>{return APh(U((a.fg())),b)?1:0;},
AZt=b=>{var jsObj=new imgui.IDLBoolArray(b);return imgui.getPointer(jsObj);},
APh=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.IDLBoolArray);var returnedJSObj=jsObj.getValue(c);return returnedJSObj;};
let AFy=B(W);
let Uo=a=>{Bn(a);},
A3L=()=>{let a=new AFy();Uo(a);return a;},
AR8=a=>{let b;b=BiG(a);b.wd.bN(0,2048);b.v3=1;return b;};
let BdD=B();
let A$W=b=>{let c,d;c=AQX();d=BgY(b);window.imguiOnInit=Bu(d,"onInit");c.rf(D(430));};
let AA0=B();
let A9m=0,A2b=0,A2J=0,BgV=0,A3V=0,Bc1=0,ANO=0,S5=0,ATV=0,A_5=0,A_3=0;
let N5=()=>{N5=N(AA0);A84();};
let A84=()=>{A9m=imgui.ImGuiConfigFlags_None;A2b=imgui.ImGuiConfigFlags_NavEnableKeyboard;A2J=imgui.ImGuiConfigFlags_NavEnableGamepad;BgV=imgui.ImGuiConfigFlags_NavEnableSetMousePos;A3V=imgui.ImGuiConfigFlags_NavNoCaptureKeyboard;Bc1=imgui.ImGuiConfigFlags_NoMouse;ANO=imgui.ImGuiConfigFlags_NoMouseCursorChange;S5=imgui.ImGuiConfigFlags_DockingEnable;ATV=imgui.ImGuiConfigFlags_ViewportsEnable;A_5=imgui.ImGuiConfigFlags_DpiEnableScaleViewports;A_3=imgui.ImGuiConfigFlags_DpiEnableScaleFonts;};
let JF=B(Bz);
let HU=null,KI=null,Nd=null,H9=null,AEX=null;
let ES=()=>{ES=N(JF);BfZ();};
let Bg7=()=>{ES();return AEX.b$();},
ANS=(a,b,c)=>{ES();Ce(a,b,c);},
G9=(a,b)=>{let c=new JF();ANS(c,a,b);return c;},
BfZ=()=>{HU=G9(D(431),0);KI=G9(D(432),1);Nd=G9(D(433),2);H9=G9(D(434),3);AEX=H(JF,[HU,KI,Nd,H9]);};
let AAo=B();
let A07=B(EA);
let A7V=B(Dt);
function FA(){let a=this;A.call(a);a.Cu=0;a.xz=null;a.xE=null;a.EA=0.0;a.C_=0;a.CU=0;a.yU=0;}
let AUL=null;
let Jj=()=>{Jj=N(FA);ATA();};
let AFu=a=>{Jj();Nq(a,51,0.800000011920929);},
Dl=()=>{let a=new FA();AFu(a);return a;},
Nq=(a,b,c)=>{let d;Jj();L(a);if(c>0.0&&c<1.0){a.EA=c;d=Jn(b,c);a.C_=d*c|0;a.yU=d-1|0;a.CU=DU(Q(a.yU));a.xz=Bt(A,d);a.xE=Bt(A,d);return;}I(B3((((O()).O(D(401))).hR(c)).y()));},
BlF=(a,b)=>{let c=new FA();Nq(c,a,b);return c;},
AP5=(a,b)=>{return U(BV(Bx(Q(b.hY()),C(2135587861, 2654435769)),a.CU));},
AXS=(a,b)=>{let c,d,e;if(b===null)I(B3(D(435)));c=a.xz;d=a.rg(b);while(true){e=c.data[d];if(e===null)return  -(d+1|0)|0;if(e.bi(b))break;d=(d+1|0)&a.yU;}return d;},
Ba3=(a,b,c)=>{let d,e,f;d=a.rh(b);if(d>=0){e=a.xE.data[d];a.xE.data[d]=c;return e;}f= -(d+1|0)|0;a.xz.data[f]=b;a.xE.data[f]=c;f=a.Cu+1|0;a.Cu=f;if(f>=a.C_)Ui(a,a.xz.data.length<<1);return null;},
ASD=(a,b,c)=>{let d,e,f;d=a.xz;e=a.rg(b);while(true){f=d.data;if(f[e]===null)break;e=(e+1|0)&a.yU;}f[e]=b;a.xE.data[e]=c;},
AOA=(a,b)=>{let c;c=a.rh(b);return c<0?null:a.xE.data[c];},
Be8=(a,b)=>{return a.rh(b)<0?0:1;},
Ui=(a,b)=>{let c,d,e,f,g;d:{c=a.xz.data.length;a.C_=b*a.EA|0;a.yU=b-1|0;a.CU=DU(Q(a.yU));d=a.xz;e=a.xE;a.xz=Bt(A,b);a.xE=Bt(A,b);if(a.Cu>0){f=0;while(true){if(f>=c)break d;g=d.data[f];if(g!==null)ASD(a,g,e.data[f]);f=f+1|0;}}}},
ATA=()=>{AUL=UW();};
function XF(){let a=this;A.call(a);a.vM=null;a.wI=0;a.BF=null;a.Dw=0;a.xo=0;a.xH=0;a.wi=0;a.Ch=null;}
let Mm=(a,b)=>{return AVu(a,b);},
RW=(a,b,c)=>{let d,e,f,g,h,i;d=ACv();e=Mm(a,b);f=0;g=0;if(!b.bb()){h=Bt(BG,1);h.data[0]=D(37);return h;}while(Ml(e)){i=f+1|0;if(i>=c&&c>0)break;d.kT((b.be(g,AHA(e))).y());g=VI(e);f=i;}c:{d.kT((b.be(g,b.bb())).y());i=f+1|0;if(!c)while(true){i=i+(-1)|0;if(i<0)break;if(((d.bW(i)).y()).bb())break c;d.b2(i);}}if(i<0)i=0;return d.rl(Bt(BG,i));},
RV=(a,b)=>{return RW(a,b,0);},
HC=a=>{return a.vM.y();},
ATz=(b,c)=>{if(b===null)I(ADL(D(436)));if(c&&(c|255)!=255)I(B3(D(37)));FU();Fa=1;return AVE(ALb(),b,c);},
AVE=(a,b,c)=>{a.vM=AUY(b,c);a.wI=c;a.Ch=AH_(a,(-1),a.wI,null);if(a.vM.cd()){AUD(a);return a;}I(BJ(D(37),a.vM.y(),a.vM.c8()));},
Bgs=(a,b)=>{let c,d,e;c=Bez(BQ(a,2),BQ(a,64));while(!a.vM.cd()){d=a.vM;if(!d.rr())break;d=a.vM;if(d.rs()&&a.vM.rs()!=(-536870788)){d=a.vM;if(d.rs()!=(-536870871))break;}c.F(a.vM.rt());if(a.vM.ru()!=(-536870788))continue;a.vM.rt();}e=M6(a,c);e.bX(b);return e;},
AH_=(a,b,c,d)=>{let e,f,g,h,i,j;e=ACv();f=a.wI;g=0;if(c!=a.wI)a.wI=c;a:{switch(b){case -1073741784:h=new MQ;i=a.wi+1|0;a.wi=i;Nx(h,i);break a;case -536870872:case -268435416:break;case -134217688:case -67108824:h=new LP;i=a.wi+1|0;a.wi=i;Ps(h,i);break a;case -33554392:h=new No;i=a.wi+1|0;a.wi=i;PY(h,i);break a;default:a.xo=a.xo+1|0;if(d!==null)h=A_W(a.xo);else{h=AYN();g=1;}if(a.xo<=(-1))break a;if(a.xo>=10)break a;a.BF.data[a.xo]=h;break a;}h=AKm();}while(true){if(a.vM.rr()&&a.vM.rs()==(-536870788))j=Bgs(a,
h);else if(a.vM.ru()==(-536870788)){j=En(h);a.vM.rt();}else{j=Uh(a,h);if(a.vM.ru()==(-536870788))a.vM.rt();}if(j!==null)e.kT(j);if(a.vM.cd())break;if(a.vM.ru()==(-536870871))break;}if(a.vM.ry()==(-536870788))e.kT(En(h));if(a.wI!=f&&!g){a.wI=f;a.vM.rz(a.wI);}switch(b){case -1073741784:break;case -536870872:return ASX(e,h);case -268435416:return AJO(e,h);case -134217688:return ARH(e,h);case -67108824:return AV3(e,h);case -33554392:return AML(e,h);default:switch(e.bV()){case 0:break;case 1:return A8s(e.bW(0),h);default:return A12(e,
h);}return En(h);}return BgX(e,h);},
A_H=a=>{let b,c,d;b=A$1();while(!a.vM.cd()){c=a.vM;if(!c.rr())break;c=a.vM;if(c.rA())break;c=a.vM;if(c.rB())break;c=a.vM;if(!(!c.rC()&&!a.vM.rs())){c=a.vM;if(!(!c.rC()&&H1(a.vM.rs()))){c=a.vM;if(c.rs()!=(-536870871)){c=a.vM;if((c.rs()&(-2147418113))!=(-2147483608)){c=a.vM;if(c.rs()!=(-536870788)){c=a.vM;if(c.rs()!=(-536870876))break;}}}}}d=a.vM.rt();if(!PA(d))b.rD(d&65535);else b.rE(Gf(d));}if(!BQ(a,2))return AZQ(b);if(BQ(a,64))return Bi$(b);return Bki(b);},
A_8=a=>{let b,c,d,e,f,g,h,i,j,k;b=Bp(4);c=0;d=(-1);e=(-1);if(!a.vM.cd()&&a.vM.rr()){f=b.data;d=a.vM.rt();f[c]=d;e=d-4352|0;}if(e>=0&&e<19){g=Cr(3);f=g.data;f[c]=d&65535;h=a.vM.ru();i=h-4449|0;if(i>=0&&i<21){f[1]=h&65535;a.vM.rt();j=a.vM.ru();h=j-4519|0;if(h>=0&&h<28){f[2]=j&65535;a.vM.rt();return AGi(g,3);}return AGi(g,2);}if(!BQ(a,2))return LF(f[0]);if(BQ(a,64))return ADJ(f[0]);return TR(f[0]);}k=1;while(k<4&&!a.vM.cd()&&a.vM.rr()){f=b.data;j=k+1|0;f[k]=a.vM.rt();k=j;}if(k==1){f=b.data;if(!A3j(f[0]))return AHV(a,
f[0]);}if(!BQ(a,2))return BjH(b,k);if(BQ(a,64))return BeT(b,k);return A2h(b,k);},
Uh=(a,b)=>{let c,d,e,f;if(a.vM.rr()&&!a.vM.rC()&&H1(a.vM.rs())){if(!BQ(a,128)){if(!a.vM.rA()&&!a.vM.rB())c=A_H(a);else{d=AHv(a,b);c=PV(a,b,d);}}else{c=A_8(a);if(!a.vM.cd()){e=a.vM;if(!(e.ru()==(-536870871)&&!(b instanceof E9))){e=a.vM;if(e.ru()!=(-536870788)&&!a.vM.rr())c=PV(a,b,c);}}}}else if(a.vM.ru()!=(-536870871)){d=AHv(a,b);c=PV(a,b,d);}else{if(b instanceof E9)I(BJ(D(37),a.vM.y(),a.vM.c8()));c=En(b);}p:{if(!a.vM.cd()){e=a.vM;if(!(e.ru()==(-536870871)&&!(b instanceof E9))){e=a.vM;if(e.ru()!=(-536870788))
{f=Uh(a,b);if(c instanceof Cv&&!(c instanceof D6)&&!(c instanceof CB)&&!(c instanceof D5)){e=c;if(!f.b1(e.es()))c=AQp(e);}if((f.eu()&65535)!=43)c.bX(f);else c.bX(f.es());break p;}}}if(c===null)return null;c.bX(b);}if((c.eu()&65535)!=43)return c;return c.es();},
PV=(a,b,c)=>{let d,e,f,g,h,i,j;d=a.vM.ru();if(c!==null&&!(c instanceof BM)){switch(d){case -2147483606:a.vM.rt();return Bbb(c,b,d);case -2147483605:a.vM.rt();return A5p(c,b,(-2147483606));case -2147483585:a.vM.rt();return A7B(c,b,(-536870849));case -2147483525:e=new Kp;f=a.vM.rP();g=a.xH+1|0;a.xH=g;NN(e,f,c,b,(-536870849),g);return e;case -1073741782:case -1073741781:a.vM.rt();h=AVy(c,b,d);c.bX(h);return h;case -1073741761:a.vM.rt();h=AUf(c,b,(-536870849));c.bX(b);return h;case -1073741701:h=new Os;e=a.vM;e
=e.rP();i=a.xH+1|0;a.xH=i;NL(h,e,c,b,(-536870849),i);c.bX(h);return h;case -536870870:case -536870869:a.vM.rt();h=c.eu()!=(-2147483602)?AQf(c,b,d):BQ(a,32)?AWp(c,b,d):AOZ(c,b,d,LB(a.wI));c.bX(h);return h;case -536870849:a.vM.rt();h=Bhz(c,b,(-536870849));c.bX(b);return h;case -536870789:h=new D$;e=a.vM;e=e.rP();g=a.xH+1|0;a.xH=g;FD(h,e,c,b,(-536870849),g);c.bX(h);return h;default:}return c;}j=null;if(c!==null)j=c;switch(d){case -2147483606:case -2147483605:a.vM.rt();h=Baj(j,b,d);j.bX(h);return h;case -2147483585:a.vM.rt();return ALn(j,
b,(-2147483585));case -2147483525:return BeK(a.vM.rP(),j,b,(-2147483525));case -1073741782:case -1073741781:a.vM.rt();h=Bdt(j,b,d);j.bX(h);return h;case -1073741761:a.vM.rt();return Bbp(j,b,(-1073741761));case -1073741701:return AY8(a.vM.rP(),j,b,(-1073741701));case -536870870:case -536870869:a.vM.rt();h=A9V(j,b,d);j.bX(h);return h;case -536870849:a.vM.rt();return A4L(j,b,(-536870849));case -536870789:return ATR(a.vM.rP(),j,b,(-536870789));default:}return c;},
AHv=(a,b)=>{let c,d,e,f,g,h,i,j,k,l;c=null;while(true){e:{d=a.vM.ru();if((d&(-2147418113))==(-2147483608)){a.vM.rt();e=(d&16711680)>>16;d=d&(-16711681);if(d==(-16777176))a.wI=e;else{if(d!=(-1073741784))e=a.wI;c=AH_(a,d,e,b);if(a.vM.ru()!=(-536870871))I(BJ(D(37),a.vM.y(),a.vM.c8()));a.vM.rt();}}else{r:{s:{switch(d){case -2147483599:case -2147483598:case -2147483597:case -2147483596:case -2147483595:case -2147483594:case -2147483593:case -2147483592:case -2147483591:break s;case -2147483583:break;case -2147483582:a.vM.rt();c
=AFV(0);break e;case -2147483577:a.vM.rt();c=ATS();break e;case -2147483558:a.vM.rt();c=new PG;f=a.wi+1|0;a.wi=f;O8(c,f);break e;case -2147483550:a.vM.rt();c=AFV(1);break e;case -2147483526:a.vM.rt();c=BcZ();break e;case -536870876:a.vM.rt();a.wi=a.wi+1|0;if(BQ(a,8)){if(BQ(a,1)){c=AYK(a.wi);break e;}c=AK9(a.wi);break e;}if(BQ(a,1)){c=A3u(a.wi);break e;}c=Ba7(a.wi);break e;case -536870866:a.vM.rt();if(BQ(a,32)){c=Bf4();break e;}c=A_e(LB(a.wI));break e;case -536870821:a.vM.rt();g=0;if(a.vM.ru()==(-536870818))
{g=1;a.vM.rt();}c=A6D(a,g,b);if(a.vM.ru()!=(-536870819))I(BJ(D(37),a.vM.y(),a.vM.c8()));a.vM.oH(1);a.vM.rt();break e;case -536870818:a.vM.rt();a.wi=a.wi+1|0;if(!BQ(a,8)){c=AGc();break e;}c=Bdi(LB(a.wI));break e;case 0:h=a.vM.rU();if(h!==null)c=M6(a,h);else{if(a.vM.cd()){c=En(b);break e;}c=LF(d&65535);}a.vM.rt();break e;default:break r;}a.vM.rt();c=AGc();break e;}i=(d&2147483647)-48|0;if(a.xo<i)I(BJ(D(37),a.vM.y(),a.vM.c8()));a.vM.rt();a.wi=a.wi+1|0;c=!BQ(a,2)?AMG(i,a.wi):BQ(a,64)?AYJ(i,a.wi):Bii(i,a.wi);a.BF.data[i].BE
=1;a.Dw=1;break e;}if(d>=0&&!a.vM.oP()){c=AHV(a,d);a.vM.rt();}else if(d==(-536870788))c=En(b);else{if(d!=(-536870871)){j=new Pt;k=!a.vM.oP()?AGR(d&65535):(a.vM.rU()).y();l=a.vM;KC(j,k,l.y(),a.vM.c8());I(j);}if(b instanceof E9)I(BJ(D(37),a.vM.y(),a.vM.c8()));c=En(b);}}}if(d!=(-16777176))break;}return c;},
A6D=(a,b,c)=>{let d,e;d=FJ(a,b);e=M6(a,d);e.bX(c);return e;},
FJ=(a,b)=>{let c,d,e,f,g,h,i,j,k,$$je;c=Bci(b,BQ(a,2),BQ(a,64));d=(-1);e=0;f=0;g=1;d:{c:{f:while(true){if(a.vM.cd())break d;f=a.vM.ru()==(-536870819)&&!g?0:1;if(!f)break d;j:{switch(a.vM.ru()){case -536870874:if(d>=0)c.F(d);d=a.vM.rt();if(a.vM.ru()!=(-536870874)){d=38;break j;}if(a.vM.rs()==(-536870821)){a.vM.rt();e=1;d=(-1);break j;}a.vM.rt();if(g){c=FJ(a,0);break j;}if(a.vM.ru()==(-536870819))break j;c.rX(FJ(a,0));break j;case -536870867:if(!g&&a.vM.rs()!=(-536870819)){h=a.vM;if(h.rs()!=(-536870821)&&d>=0)
{a.vM.rt();i=a.vM.ru();if(a.vM.oP())break f;if(i<0){h=a.vM;if(h.rs()!=(-536870819)){h=a.vM;if(h.rs()!=(-536870821)&&d>=0)break f;}}t:{try{if(H1(i))break t;i=i&65535;break t;}catch($$e){$$je=Bb($$e);if($$je instanceof B8){break c;}else{throw $$e;}}}try{c.G(d,i);}catch($$e){$$je=Bb($$e);if($$je instanceof B8){break c;}else{throw $$e;}}a.vM.rt();d=(-1);break j;}}if(d>=0)c.F(d);d=45;a.vM.rt();break j;case -536870821:if(d>=0){c.F(d);d=(-1);}a.vM.rt();j=0;if(a.vM.ru()==(-536870818)){a.vM.rt();j=1;}if(!e)c.rY(FJ(a,
j));else c.rX(FJ(a,j));e=0;a.vM.rt();break j;case -536870819:if(d>=0)c.F(d);d=93;a.vM.rt();break j;case -536870818:if(d>=0)c.F(d);d=94;a.vM.rt();break j;case 0:if(d>=0)c.F(d);k=a.vM.rU();if(k===null)d=0;else{c.rZ(k);d=(-1);}a.vM.rt();break j;default:}if(d>=0)c.F(d);d=a.vM.rt();}g=0;}I(BJ(D(37),HC(a),a.vM.c8()));}I(BJ(D(37),HC(a),a.vM.c8()));}if(!f){if(d>=0)c.F(d);return c;}I(BJ(D(37),HC(a),a.vM.c8()-1|0));},
AHV=(a,b)=>{let c;c=PA(b);if(BQ(a,2)){b:{if(!(b>=97&&b<=122)){if(b<65)break b;if(b>90)break b;}return TR(b&65535);}if(BQ(a,64)&&b>128){if(c)return A7M(b);if(Ln(b))return ABX(b&65535);if(!Nb(b))return ADJ(b&65535);return X6(b&65535);}}if(c)return AOa(b);if(Ln(b))return ABX(b&65535);if(!Nb(b))return LF(b&65535);return X6(b&65535);},
M6=(a,b)=>{let c,d;if(!b.r1()){if(!b.r2()){if(b.jF())return Xb(b);return AFY(b);}if(b.jF())return ABv(b);return Zb(b);}c=b.r3();d=AJ1(c);if(!b.r2()){if(b.jF())return I0(Xb(b.r5()),d);return I0(AFY(b.r5()),d);}if(b.jF())return I0(ABv(b.r5()),d);return I0(Zb(b.r5()),d);},
UO=b=>{return ATz(b,0);},
AUD=a=>{if(a.Dw)a.Ch.bt();},
A1x=b=>{let c,d,e,f;c=(O()).O(D(437));d=0;while(true){e=b.pA(D(438),d);if(e<0)break;f=e+2|0;(c.O(b.hQ(d,f))).O(D(439));d=f;}return ((c.O(b.eG(d))).O(D(438))).y();},
Rs=a=>{return a.xo;},
AGb=a=>{return a.xH+1|0;},
ACA=a=>{return a.wi+1|0;},
FS=b=>{if(b>=97&&b<=122)b=(b-32|0)&65535;else if(b>=65&&b<=90)b=(b+32|0)&65535;return b;},
BQ=(a,b)=>{return (a.wI&b)!=b?0:1;},
AKk=a=>{L(a);a.BF=Bt(Cj,10);a.xo=(-1);a.xH=(-1);a.wi=(-1);},
ALb=()=>{let a=new XF();AKk(a);return a;};
let UA=B(Fw);
let AFU=(a,b,c,d)=>{G5(a,b,c,d);Ez();b.bX(GI);},
A7B=(a,b,c)=>{let d=new UA();AFU(d,a,b,c);return d;},
A0_=(a,b,c,d)=>{let e;e=a.vY.br(b,c,d);if(e<=0)e=b;return a.vN.br(e,c,d);},
A6y=(a,b)=>{a.vN=b;};
let ABN=B(Bd);
let AGW=a=>{BN(a);},
AYx=()=>{let a=new ABN();AGW(a);return a;};
let A1F=B(Bo);
let ABO=B(Bd);
let ABC=a=>{BN(a);},
AVL=()=>{let a=new ABO();ABC(a);return a;};
let Gy=B();
let ATT=null,A6I=null;
let OQ=()=>{OQ=N(Gy);Bas();};
let We=a=>{OQ();L(a);},
Qi=()=>{let a=new Gy();We(a);return a;},
Bas=()=>{ATT=Qi();A6I=Qi();};
let ABP=B(Bd);
let AAh=a=>{BN(a);},
BaI=()=>{let a=new ABP();AAh(a);return a;};
let ABL=B(Bd);
let Xl=a=>{BN(a);},
ALl=()=>{let a=new ABL();Xl(a);return a;};
let ABM=B(Bd);
let AGA=a=>{BN(a);},
ALT=()=>{let a=new ABM();AGA(a);return a;};
let AQo=B();
function N7(){A.call(this);this.GF=null;}
let ACK=(a,b)=>{a.GF=b;L(a);},
BcU=a=>{let b=new N7();ACK(b,a);return b;},
Bfa=a=>{return;},
ASx=a=>{a.r7();};
let Bb1=B();
let ALS=B();
let A5m=B();
let Rr=0;
let BeC=B(Ep);
let A56=B(GR);
let E5=B();
let P$=a=>{L(a);},
BkS=()=>{let a=new E5();P$(a);return a;};
function JJ(){T.call(this);this.Cr=0;}
let NT=(a,b)=>{Bh(a);a.Cr=b;},
Bhd=a=>{let b=new JJ();NT(b,a);return b;},
A8a=(a,b)=>{return a.wa^(a.Cr!=HQ(b&65535)?0:1);};
let Zc=B(JJ);
let ABj=(a,b)=>{NT(a,b);},
ANn=a=>{let b=new Zc();ABj(b,a);return b;},
BbT=(a,b)=>{return a.wa^(!(a.Cr>>HQ(b&65535)&1)?0:1);};
function RH(){let a=this;A.call(a);a.HS=null;a.xI=null;a.H6=null;}
let YU=(a,b,c)=>{L(a);a.xI=c;a.HS=b;},
Mr=(a,b)=>{let c=new RH();YU(c,a,b);return c;},
KR=(a,b)=>{a.H6=b;},
AD7=a=>{let b,c,d,e,f,g;b=a.xI.length;c=D(440);d=Iy(((b*4|0)/3|0)+2|0);e=0;while(e<b){f=b-e|0;if(f>=3){g=(((a.xI[e]&255)<<16)+((a.xI[e+1|0]&255)<<8)|0)+(a.xI[e+2|0]&255)|0;d.cF(c.bc(g>>18&63));d.cF(c.bc(g>>12&63));d.cF(c.bc(g>>6&63));d.cF(c.bc(g&63));}else if(f<2){g=(a.xI[e]&255)<<16;d.cF(c.bc(g>>18&63));d.cF(c.bc(g>>12&63));d.O(D(441));}else{g=((a.xI[e]&255)<<16)+((a.xI[e+1|0]&255)<<8)|0;d.cF(c.bc(g>>18&63));d.cF(c.bc(g>>12&63));d.cF(c.bc(g>>6&63));d.O(D(442));}e=e+3|0;}return d.y();};
function VO(){Ew.call(this);this.F0=0;}
let X4=(a,b)=>{Hz(a);a.F0=b;},
AVd=a=>{let b=new VO();X4(b,a);return b;},
ASK=a=>{let b,c;b=a.F0;c=O();V(K(c,D(443)),b);return S(c);};
function AEw(){let a=this;A.call(a);a.B2=0;a.BI=0;a.DF=0;}
let Qz=a=>{L(a);},
AWR=()=>{let a=new AEw();Qz(a);return a;};
let AHx=B(D_);
let XH=(a,b,c)=>{Hk(a,b,c);},
BeT=(a,b)=>{let c=new AHx();XH(c,a,b);return c;};
let AG7=B(HA);
let AP0=B(Dh);
function ZF(){T.call(this);this.Hi=null;}
let RI=(a,b)=>{a.Hi=b;Bh(a);},
AR7=a=>{let b=new ZF();RI(b,a);return b;},
AMM=(a,b)=>{return XI(b);};
let VS=B(W);
let RK=a=>{Bn(a);},
AQ7=()=>{let a=new VS();RK(a);return a;},
ATt=a=>{let b;b=ATc(a);b.v3=1;return b;};
let Jt=B(Bz);
let JE=null,G$=null,Gq=null,AE$=null;
let DN=()=>{DN=N(Jt);A3g();};
let AVk=()=>{DN();return AE$.b$();},
Bi0=(a,b,c)=>{DN();Ce(a,b,c);},
Kz=(a,b)=>{let c=new Jt();Bi0(c,a,b);return c;},
A3g=()=>{JE=Kz(D(444),0);G$=Kz(D(445),1);Gq=Kz(D(446),2);AE$=H(Jt,[JE,G$,Gq]);};
let AYL=B(CC);
let ZO=B(Dg);
let AQE=null;
let Er=()=>{Er=N(ZO);AXK();};
let Bg9=(b,c)=>{Er();if(b!==null)return BcP(b,0,b.bb(),c);I(E4(D(7)));},
BcP=(b,c,d,e)=>{let f,g,h,i,j,k,l,m,n,o;Er();if(e>=2&&e<=36){if(c==d)I(E4(D(8)));c:{f=0;switch(b.bc(c)){case 43:g=c+1|0;break c;case 45:f=1;g=c+1|0;break c;default:}g=c;}h=Bg;i=Q(e);j=B1(Q(1),Ow(C(4294967295, 2147483647),i));if(g==d)I(AIE());while(true){if(g>=d){if(f)h=A5i(h);return h;}k=g+1|0;l=AZi(b.bc(g));if(l<0){m=new B$;n=b.be(c,d);o=O();K(K(o,D(9)),n);C9(m,S(o));I(m);}if(l>=e){m=new B$;n=b.be(c,d);o=O();K(K(V(K(o,D(10)),e),D(11)),n);C9(m,S(o));I(m);}if(ASZ(h,j))break;h=B1(Bx(i,h),Q(l));if(ATB(h,Bg)){if
(k==d&&BS(h,C(0, 2147483648))&&f)return C(0, 2147483648);m=new B$;n=b.be(c,d);o=O();K(K(o,D(447)),n);C9(m,S(o));I(m);}g=k;}I(E4(D(448)));}o=new B$;m=O();V(K(m,D(14)),e);C9(o,S(m));I(o);},
Bfr=b=>{Er();return Bg9(b,10);},
AZi=b=>{Er();if(b>=48&&b<=57)return b-48|0;if(b>=97&&b<=122)return (b-97|0)+10|0;if(b>=65&&b<=90)return (b-65|0)+10|0;return (-1);},
DU=b=>{let c,d,e;Er();if(BS(b,Bg))return 64;c=0;d=BV(b,32);if(AUp(d,Bg))c=32;else d=b;e=BV(d,16);if(BS(e,Bg))e=d;else c=c|16;d=BV(e,8);if(BS(d,Bg))d=e;else c=c|8;e=BV(d,4);if(BS(e,Bg))e=d;else c=c|4;d=BV(e,2);if(BS(d,Bg))d=e;else c=c|2;if(AUp(BV(d,1),Bg))c=c|1;return (64-c|0)-1|0;},
CK=(b,c)=>{return Ble(b,c);},
AMx=(b,c)=>{return BkB(b,c);},
CV=(b,c)=>{return Blc(b,c);},
AXK=()=>{AQE=Br(Bk_);};
function ADD(){let a=this;A.call(a);a.zV=null;a.Bm=null;a.wK=0;a.Gg=0;}
let Yv=(a,b)=>{L(a);while(b>=a.wK){a.wK=a.wK<<1|1;}a.wK=a.wK<<1|1;a.zV=Bp(a.wK+1|0);a.Bm=Bp(a.wK+1|0);a.Gg=b;},
ABQ=a=>{let b=new ADD();Yv(b,a);return b;},
AZk=(a,b,c)=>{let d,e,f;d=0;e=b&a.wK;while(a.zV.data[e]&&a.zV.data[e]!=b){f=d+1|0;d=f&a.wK;f=e+d|0;e=f&a.wK;}a.zV.data[e]=b;a.Bm.data[e]=c;},
A36=(a,b)=>{let c,d,e,f;c=b&a.wK;d=0;while(true){e=a.zV.data[c];if(!e)break;if(e==b)return a.Bm.data[c];f=d+1|0;d=f&a.wK;f=c+d|0;c=f&a.wK;}return a.Gg;};
let Pv=B();
let A4J=B(Cc);
let AEM=B(W);
let St=a=>{Bn(a);},
A9I=()=>{let a=new AEM();St(a);return a;},
A6F=a=>{let b;b=A$J(a);b.v3=1;return b;};
let AOq=B(Eb);
function Xm(){let a=this;A.call(a);a.A9=0;a.C4=0;a.Fp=0;a.DQ=null;a.F5=0;a.IJ=null;a.Di=0;a.Gk=null;a.yx=0;a.yy=0;a.BJ=0;a.C$=0;a.Ev=0;a.D8=0;a.FF=0;a.E1=0;a.E9=0;a.A2=0;a.AH=0;}
let A$_=a=>{return a.yx&&a.yy?1:0;},
A_f=a=>{return !a.yx&&!a.yy?1:0;},
R6=(a,b)=>{L(a);a.A9=0;a.C4=1;a.Fp=0;a.F5=1;a.IJ=D(37);a.Di=0;a.yx=(-1);a.yy=(-1);a.BJ=0;a.C$=0;a.Ev=0;a.D8=0;a.FF=0;a.E1=0;a.E9=0;a.A2=0;a.AH=1;a.Gk=b;},
Biv=a=>{let b=new Xm();R6(b,a);return b;};
function UL(){T.call(this);this.Ix=null;}
let AHn=(a,b)=>{a.Ix=b;Bh(a);},
Bg6=a=>{let b=new UL();AHn(b,a);return b;},
A4w=(a,b)=>{return Sk(b);};
function Th(){let a=this;T.call(a);a.Aj=null;a.Gz=null;}
let AHu=(a,b,c)=>{a.Gz=b;a.Aj=c;Bh(a);},
AUT=(a,b)=>{let c=new Th();AHu(c,a,b);return c;},
A2N=(a,b)=>{return a.wa^a.Aj.jH(b);},
AXa=a=>{let b,c;b=O();c=a.Aj.cG(0);while(c>=0){b.dN(Gf(c));b.cF(124);c=a.Aj.cG(c+1|0);}if(b.bb()>0)b.jJ(b.bb()-1|0);return b.y();};
let AIV=B(CB);
let AFR=(a,b,c,d)=>{Es(a,b,c,d);Ez();b.bX(GI);},
Bbb=(a,b,c)=>{let d=new AIV();AFR(d,a,b,c);return d;},
ARe=(a,b,c,d)=>{let e;while(true){e=a.vY.br(b,c,d);if(e<=0)break;b=e;}return a.vN.br(b,c,d);};
let AL$=B(Ct);
function Te(){let a=this;T.call(a);a.Ea=null;a.G_=null;}
let AEh=(a,b,c)=>{a.G_=b;a.Ea=c;Bh(a);},
A6Z=(a,b)=>{let c=new Te();AEh(c,a,b);return c;},
ARn=(a,b)=>{return a.Ea.b6(b);};
function Tf(){let a=this;T.call(a);a.Ed=null;a.IG=null;}
let AA3=(a,b,c)=>{a.IG=b;a.Ed=c;Bh(a);},
A9n=(a,b)=>{let c=new Tf();AA3(c,a,b);return c;},
AWa=(a,b)=>{return a.Ed.b6(b)?0:1;};
function Tg(){let a=this;T.call(a);a.Fw=0;a.FO=null;a.F3=null;a.GE=null;}
let UB=(a,b,c,d,e)=>{a.GE=b;a.Fw=c;a.FO=d;a.F3=e;Bh(a);},
Bbo=(a,b,c,d)=>{let e=new Tg();UB(e,a,b,c,d);return e;},
Bke=(a,b)=>{return !(a.Fw^a.FO.b6(b))&&!a.F3.b6(b)?0:1;};
function Ul(){let a=this;T.call(a);a.F2=0;a.Dj=null;a.Du=null;a.G4=null;}
let Wi=(a,b,c,d,e)=>{a.G4=b;a.F2=c;a.Dj=d;a.Du=e;Bh(a);},
BjI=(a,b,c,d)=>{let e=new Ul();Wi(e,a,b,c,d);return e;},
AXz=(a,b)=>{return !(a.F2^a.Dj.b6(b))&&!a.Du.b6(b)?1:0;};
function Ti(){let a=this;T.call(a);a.FB=0;a.DC=null;a.EJ=null;a.GU=null;}
let Vi=(a,b,c,d,e)=>{a.GU=b;a.FB=c;a.DC=d;a.EJ=e;Bh(a);},
Bi6=(a,b,c,d)=>{let e=new Ti();Vi(e,a,b,c,d);return e;},
AOP=(a,b)=>{return a.FB^a.DC.b6(b)&&a.EJ.b6(b)?1:0;};
function Tj(){let a=this;T.call(a);a.Fo=0;a.Dg=null;a.Fv=null;a.Hc=null;}
let RE=(a,b,c,d,e)=>{a.Hc=b;a.Fo=c;a.Dg=d;a.Fv=e;Bh(a);},
BaX=(a,b,c,d)=>{let e=new Tj();RE(e,a,b,c,d);return e;},
A9u=(a,b)=>{return a.Fo^a.Dg.b6(b)&&a.Fv.b6(b)?0:1;};
function Tk(){let a=this;T.call(a);a.F7=null;a.E7=0;a.Go=null;}
let AB5=(a,b,c,d)=>{a.Go=b;a.F7=c;a.E7=d;Bh(a);},
AOi=(a,b,c)=>{let d=new Tk();AB5(d,a,b,c);return d;},
A0P=(a,b)=>{return a.F7.b6(b)&&a.E7^a.Go.vX.jH(b)?1:0;};
function Td(){let a=this;T.call(a);a.Fr=null;a.EM=0;a.E6=null;}
let AAE=(a,b,c,d)=>{a.E6=b;a.Fr=c;a.EM=d;Bh(a);},
BiW=(a,b,c)=>{let d=new Td();AAE(d,a,b,c);return d;},
Bdk=(a,b)=>{return a.Fr.b6(b)&&a.EM^a.E6.vX.jH(b)?0:1;};
let Y9=B(Fq);
let Nm=B(Ec);
let Y$=(a,b)=>{Ha(a,b);},
Iy=a=>{let b=new Nm();Y$(b,a);return b;},
AHI=a=>{Hn(a);},
O=()=>{let a=new Nm();AHI(a);return a;},
K=(a,b)=>{X0(a,b);return a;},
AKL=(a,b)=>{ACt(a,b);return a;},
V=(a,b)=>{SV(a,b);return a;},
W4=(a,b)=>{AGY(a,b);return a;},
CR=(a,b)=>{AE0(a,b);return a;},
LD=(a,b)=>{V1(a,b);return a;},
BA=(a,b)=>{MO(a,b);return a;},
ARV=(a,b,c,d)=>{PL(a,b,c,d);return a;},
Bbv=(a,b)=>{N6(a,b);return a;},
SI=(a,b)=>{ADY(a,b);return a;},
AVr=(a,b,c)=>{ZP(a,b,c);return a;},
Bb_=(a,b,c)=>{ABu(a,b,c);return a;},
AZR=(a,b,c)=>{U2(a,b,c);return a;},
A$6=(a,b,c,d,e)=>{Kk(a,b,c,d,e);return a;},
Bh5=(a,b,c)=>{VN(a,b,c);return a;},
A6d=(a,b,c)=>{Qt(a,b,c);return a;},
A60=(a,b,c)=>{PT(a,b,c);return a;},
BfB=(a,b,c)=>{AGX(a,b,c);return a;},
BcF=(a,b)=>{AGk(a,b);return a;},
A1Z=(a,b,c)=>{AEz(a,b,c);return a;},
A1K=(a,b,c,d,e)=>{return a.sk(b,c,d,e);},
AS9=(a,b,c,d)=>{return a.sl(b,c,d);},
AOm=a=>{return Mt(a);},
S=a=>{return NB(a);},
A2m=(a,b)=>{K0(a,b);},
A2K=(a,b,c)=>{return a.sm(b,c);},
A41=(a,b,c)=>{return a.sn(b,c);},
A3K=(a,b,c)=>{return a.so(b,c);},
Bbf=(a,b,c)=>{return a.sp(b,c);},
AXP=(a,b,c)=>{return a.sq(b,c);},
AQv=(a,b,c)=>{return a.sr(b,c);},
BjK=(a,b,c)=>{return a.ss(b,c);};
let AF7=B(Bi);
let AIc=a=>{B9(a);},
APp=()=>{let a=new AF7();AIc(a);return a;};
let L2=B(Jr);
let AE6=null,AE7=null;
let Hc=()=>{Hc=N(L2);ASj();};
let AUB=()=>{Hc();AE6.fh();AE7.fh();},
W2=a=>{Hc();Ma(a,1);},
AHH=()=>{let a=new L2();W2(a);return a;},
BdC=a=>{return a.st(0);},
A8x=a=>{return A6e(a.sv());},
ASj=()=>{AE6=AHH();AE7=AHH();};
let RB=B();
let ZG=a=>{L(a);},
A$h=()=>{let a=new RB();ZG(a);return a;};
let A9x=B(Eh);
let RA=B();
let S9=a=>{L(a);},
A0I=()=>{let a=new RA();S9(a);return a;};
function ACX(){A.call(this);this.Hx=null;}
let ZV=a=>{L(a);a.Hx=AO6(16);},
AYw=()=>{let a=new ACX();ZV(a);return a;};
let ALI=B(L3);
let A8b=B(BC);
let Bjz=B(Gw);
function S7(){let a=this;A.call(a);a.zb=null;a.w6=0;a.GO=Bg;a.HB=0;a.Ib=0;}
let AAN=(a,b)=>{let c,d,e,f;c=b.data;L(a);a.GO=Q(-1);a.HB=(-1);a.Ib=(-1);d=c.length;if(!d)I(B3(D(449)));e=Bt(DY,d);f=0;while(f<d){e.data[f]=c[f];f=f+1|0;}a.zb=e;a.w6=ANc(a);},
W8=a=>{let b=new S7();AAN(b,a);return b;},
ANc=a=>{let b,c,d;b=0;c=0;while(c<a.zb.data.length){d=a.zb.data[c];d.x$=b;b=b+VD(d)|0;c=c+1|0;}return b;},
De=a=>{return a.zb.data.length;},
CQ=(a,b)=>{return a.zb.data[b];};
let AOM=B();
let ALu=B();
let AB8=B();
let AED=B(W);
let SM=a=>{Bn(a);},
BbI=()=>{let a=new AED();SM(a);return a;},
AT9=a=>{return (Cy()).G(0,127);};
function Kw(){let a=this;A.call(a);a.Hs=null;a.GD=null;}
let AMU=null,BgR=null;
let ND=()=>{ND=N(Kw);ASg();};
let AHb=a=>{ND();L(a);a.Hs=ADh(1);a.GD=XO(2);},
A91=()=>{let a=new Kw();AHb(a);return a;},
ASg=()=>{AMU=AC6(Br(Ho));BgR=XO(4);};
let JH=B(EP);
let Lc=null;
let HK=()=>{HK=N(JH);AX2();};
let AAy=a=>{HK();P3(a,256);},
TA=()=>{let a=new JH();AAy(a);return a;},
P3=(a,b)=>{HK();GW(a,b);},
BkI=a=>{let b=new JH();P3(b,a);return b;},
A4T=a=>{let b,c,d,e;b=a.h8();c=0;d=0;d:{while(true){if(d>=b){d=c;break d;}e=a.fB(d);if(!e)break;if(e==3)break;Lc.data[d]=e;d=d+1|0;}}return BjZ(Lc,0,d);},
AX2=()=>{Lc=EL(1000);};
let A8t=B(F1);
let Xy=B();
let Biq=B();
let ATG=B(Cb);
let ASF=B();
let A94=()=>{let b;b=A5C();return b;},
A5C=()=>{var userAgent=navigator.userAgent.toLowerCase();return {firefox:userAgent.indexOf('firefox')!= -1,chrome:userAgent.indexOf('chrome')!= -1,safari:userAgent.indexOf('safari')!= -1,opera:userAgent.indexOf('opera')!= -1,IE:userAgent.indexOf('msie')!= -1,macOS:userAgent.indexOf('mac')!= -1,linux:userAgent.indexOf('linux')!= -1,windows:userAgent.indexOf('win')!= -1,userAgent:userAgent};};
let AJ6=B();
function Rt(){let a=this;GA.call(a);a.Ce=0;a.Ar=0;}
let Yb=(a,b,c)=>{J3(a);a.Ce=b;a.Ar=c;},
A9A=(a,b)=>{let c=new Rt();Yb(c,a,b);return c;},
AW7=a=>{return a.Ce;},
Beh=a=>{return a.Ar;},
A6u=a=>{let b,c,d;b=a.Ce;c=a.Ar==2147483647?D(37):Od(a.Ar);d=O();BA(K(BA(V(BA(d,123),b),44),c),125);return S(d);};
function QY(){T.call(this);this.HN=null;}
let AE5=(a,b)=>{a.HN=b;Bh(a);},
AMP=a=>{let b=new QY();AE5(b,a);return b;},
ANT=(a,b)=>{return AJp(b);};
let ASu=B();
function MD(){let a=this;A.call(a);a.wJ=null;a.zq=null;a.Et=null;a.E5=null;a.EK=null;a.wX=null;a.Ac=null;a.x9=null;a.xV=null;a.xG=null;a.y0=null;a.Bs=0;a.C1=0;a.Dy=null;a.CD=0;a.y8=null;a.G3=null;a.GQ=null;a.zH=null;a.zZ=null;a.xe=null;}
let FB=null;
let ASe=()=>{return FB;},
LE=(a,b,c)=>{L(a);a.xV=ADh(4);DN();a.y0=JE;a.Bs=(-1);a.C1=1;a.CD=1;a.G3=Dl();a.zH=Dx();a.zZ=Dx();a.xG=Jq();a.wX=c;a.sC(b);Baa(a);},
Bkr=(a,b)=>{let c=new MD();LE(c,a,b);return c;},
Baa=a=>{let b,c,d,e,f;FB=A94();Fe(D(450),D(37));Fe(D(451),Ba(FB.userAgent));if(FB.windows?1:0)Fe(D(452),D(453));else if(FB.macOS?1:0)Fe(D(452),D(454));else if(!(FB.linux?1:0))Fe(D(452),D(455));else Fe(D(452),D(18));A3G(AYE(a.wX.Di));b=EE();a.xe=b.sH();if(a.xe.bh(D(456))){a.xe=a.xe.sI(D(457),D(37));a.xe=a.xe.sI(D(458),D(37));}c=a.xe.sJ(63);if(c>=0)a.xe=a.xe.hQ(0,c);A5U(a.wX.C4);a.wJ=A95(a.wX);a.y8=A5z(a.xe,a.wJ.wO,a);d=Ba5();a.y8.sN(a.wX.F5,D(459));a.zq=AOQ(a.wJ.wO);a.Et=AQs(a.y8);a.E5=AYw();a.Dy=ANe();a.GQ=
A5T();if(a.wX.Fp)A3C(a);C6=a;B5=a.wJ;Bc=a.wJ.sQ();Y=a.wJ.sQ();Ek=a.wJ.sR();Vl=a.zq;A2c=a.Et;A$p=a.E5;a.EK=BhY();A24=a.EK;e=a.xG.gV();f=Baw(a);e.addEventListener("visibilitychange",Bu(f,"handleEvent"));a.xG.sT(a);if(a.wX.sU())a.xG.nI(D(460),AQd(a));},
AZy=a=>{let b,c,d,e,f,g,h,i,j,k,l,$$je;b=a.y0;d:{try{a:{NR();switch(I$.data[Bl(b)]){case 1:c=(EE()).sV();if(!c){DN();a.y0=Gq;d=window.document.getElementById("progress");if(d!==null)d.style.setProperty("display","none");break a;}e=a.y8.B_;if(e>0){f=25;g=f+((75*(e-c|0)|0)/e|0)|0;h=window.document.getElementById("progress-bar");if(h!==null){i=h.style;j=O();BA(V(j,g),37);k=S(j);i.setProperty("width",Be(k));}}break a;case 2:break;default:break a;}if(a.Ac!==null){if(a.x9!==null){a.x9.lT();a.x9.fh();}a.zq.jN(null);a.zq.sW();a.zH.nb();a.x9
=a.Ac;a.Ac=null;DN();a.y0=G$;a.wJ.zO=Bg;}AMf(a,a.x9);}}catch($$e){$$je=Bb($$e);if($$je instanceof B4){l=$$je;break d;}else{throw $$e;}}a.xG.sT(a);return;}l.lF();I(l);},
AMf=(a,b)=>{let c,d,e,f,g,h;a.wJ.cX();c=B5.fM();d=B5.fN();e=0;f=a.y0;DN();if(f===G$){a.y0=Gq;b.sY();b.lU();e=1;}if(!(c==a.Bs&&d==a.C1&&!e)){a.Bs=c;a.C1=d;Bc.mI(0,0,c,d);b.lW(c,d);}a.zZ.sZ(a.zH);a.zH.nb();g=0;while(g<a.zZ.v2){(a.zZ.bW(g)).s();g=g+1|0;}a.zZ.nb();h=a.wJ;h.zO=B1(h.zO,Q(1));if(ASZ(a.wJ.zO,Q(60)))b.j7();a.zq.sW();},
A0d=(a,b)=>{a.Ac=b;},
A4H=a=>{return a.wX;},
A6T=(a,b,c)=>{if(a.CD>=2)(a.s0()).fr(b,c);},
Bhq=(a,b,c)=>{if(a.CD>=1)(a.s0()).e_(b,c);},
BdQ=a=>{return a.Dy;},
BgJ=a=>{D3();return ET;},
APM=(a,b)=>{a.zH.eg(b);},
Bh2=a=>{return;},
Bin=(a,b)=>{let c,d,$$je;c=a.xV;Eo(c);d:{try{a.xV.eg(b);CD(c);}catch($$e){$$je=Bb($$e);d=$$je;break d;}return;}CD(c);I(d);},
A3C=a=>{a.y8.gT(1,D(461),ANU(a));};
let A8S=B(Ds);
function ST(){T.call(this);this.IE=null;}
let AAJ=(a,b)=>{a.IE=b;Bh(a);},
AVv=a=>{let b=new ST();AAJ(b,a);return b;},
A74=(a,b)=>{return Gb(b);};
let BgN=B();
function AGS(){let a=this;E5.call(a);a.Fi=0;a.Fj=0;a.Fm=0;a.AF=0;}
let AGj=a=>{P$(a);},
A1X=()=>{let a=new AGS();AGj(a);return a;},
Bdu=(a,b,c,d,e)=>{let f,g,h;f=CX();if(!e)a.Fi=1;g=CA(e,1);if(!g)a.Fj=1;if(e==2)a.Fm=1;h=CX();a.AF=h.s1();f.s2(e,1);if(a.AF)return 1;if(!g)Rv(null);return 0;},
A0y=(a,b,c,d)=>{let e;e=CX();e.s3(b,c);if(!a.AF)return 0;return 1;},
Ba4=(a,b,c,d,e)=>{let f;f=CX();if(!e)a.Fi=0;if(e==1)a.Fj=0;if(e==2)a.Fm=0;f.s2(e,0);a.AF=0;return 0;},
APo=(a,b)=>{let c;c=CX();if(b!=127)c.s4(b);GS();if(!Pl(Jk))return 0;return 1;},
A$u=(a,b)=>{let c,d,e,f,g,h;c=CX();d=0;e=0;f=0;g=0;if(!(b!=129&&b!=130))d=1;if(!(b!=59&&b!=60))e=1;if(!(b!=57&&b!=58))f=1;if(b==63)g=1;h=Zw(b);if(g){P();c.s7(KF,1);}else if(d){P();c.s7(Pk,1);}else if(e){P();c.s7(Km,1);}else if(f){P();c.s7(P5,1);}c.s7(h,1);GS();if(!Pl(Jk))return 0;return 1;},
AXX=(a,b)=>{let c,d,e,f,g,h;c=CX();d=0;e=0;f=0;g=0;if(!(b!=129&&b!=130))d=1;if(!(b!=59&&b!=60))e=1;if(!(b!=57&&b!=58))f=1;if(b==63)g=1;h=Zw(b);if(g){P();c.s7(KF,0);}else if(d){P();c.s7(Pk,0);}else if(e){P();c.s7(Km,0);}else if(f){P();c.s7(P5,0);}c.s7(h,0);GS();if(!Pl(Jk))return 0;return 1;},
AU4=(a,b,c)=>{let d;d=CX();d.s3(b,c);return 0;},
Bdz=(a,b,c)=>{let d;d=CX();d.s8(b, -c);if(!d.s1())return 0;return 1;},
Zw=b=>{u:{switch(b){case 3:break;case 4:case 5:case 6:case 17:case 18:case 23:case 24:case 25:case 26:case 27:case 28:case 64:case 65:case 77:case 78:case 79:case 80:case 81:case 83:case 84:case 85:case 86:case 87:case 88:case 89:case 90:case 91:case 94:case 95:case 96:case 97:case 98:case 99:case 100:case 101:case 102:case 103:case 104:case 105:case 106:case 107:case 108:case 109:case 110:case 113:case 114:case 117:case 118:case 119:case 122:case 125:case 126:case 127:case 128:case 159:break u;case 7:P();return Y3;case 8:P();return Y2;case 9:P();return Y1;case 10:P();return Y0;case 11:P();return YZ;case 12:P();return YY;case 13:P();return YX;case 14:P();return YW;case 15:P();return YV;case 16:P();return YT;case 19:P();return V8;case 20:P();return AAQ;case 21:P();return AIK;case 22:P();return AIu;case 29:P();return YS;case 30:P();return YR;case 31:P();return YP;case 32:P();return YO;case 33:P();return YN;case 34:P();return YM;case 35:P();return YL;case 36:P();return YK;case 37:P();return YJ;case 38:P();return YI;case 39:P();return YH;case 40:P();return YG;case 41:P();return YF;case 42:P();return YE;case 43:P();return Zp;case 44:P();return Zo;case 45:P();return Zn;case 46:P();return Zm;case 47:P();return Zl;case 48:P();return Zk;case 49:P();return Zj;case 50:P();return Zi;case 51:P();return Zh;case 52:P();return Zg;case 53:P();return Zf;case 54:P();return Ze;case 55:P();return SH;case 56:P();return AFD;case 57:P();return AEW;case 58:P();return ACi;case 59:P();return ADB;case 60:P();return Rj;case 61:P();return W9;case 62:P();return R1;case 63:P();return ABU;case 66:P();return Vw;case 67:P();return AGZ;case 68:P();return SK;case 69:P();return Vz;case 70:P();return U7;case 71:P();return Q4;case 72:P();return Yy;case 73:P();return XV;case 74:P();return Vk;case 75:P();return ZN;case 76:P();return AB4;case 82:P();return ACg;case 92:P();return V$;case 93:P();return AHk;case 111:P();return AGK;case 112:P();return AH4;case 115:P();return Uy;case 116:P();return ADX;case 120:P();return AHp;case 121:P();return ADG;case 123:P();return AAK;case 124:P();return RU;case 129:P();return VM;case 130:P();return AA4;case 131:P();return AIy;case 132:P();return AIx;case 133:P();return AIA;case 134:P();return AIz;case 135:P();return AIC;case 136:P();return AIB;case 137:P();return AIq;case 138:P();return AIp;case 139:P();return AIs;case 140:P();return Xq;case 141:P();return Xp;case 142:P();return Xt;case 143:P();return AHC;case 144:P();return AAd;case 145:P();return AAe;case 146:P();return AAf;case 147:P();return Z_;case 148:P();return AAa;case 149:P();return AAb;case 150:P();return AAc;case 151:P();return Z8;case 152:P();return Z9;case 153:P();return Z$;case 154:P();return Um;case 155:P();return ADZ;case 156:P();return Sq;case 157:P();return AG2;case 158:P();return AGs;case 160:P();return QS;case 161:P();return Se;default:break u;}P();return ABY;}P();return AFB;};
let WB=B(Cv);
let AIT=(a,b,c,d)=>{Em(a,b,c,d);},
Bdt=(a,b,c)=>{let d=new WB();AIT(d,a,b,c);return d;},
A8k=(a,b,c,d)=>{let e;while(true){e=a.vN.br(b,c,d);if(e>=0)break;if((b+a.v9.bw()|0)<=d.bq()){e=a.v9.bx(b,c);b=b+e|0;}if(e<1)return (-1);}return e;};
let A3D=B();
let AUZ=B();
let AAn=(b,c)=>{return On(b,c);};
let Si=B();
let A0f=0,AAS=0,Zx=0,VT=0,A7L=0,A7N=0,Vv=0,A8X=0,ZZ=0,A9Z=0,BbH=0,Vb=0,A$c=0,AO4=0,WG=0,Bb0=0,AYo=0,ASp=0,AM4=0,UX=0,A9D=0,S1=0,A8Q=0,AT_=0,AR0=0;
let M3=()=>{M3=N(Si);Bjy();};
let Bjy=()=>{A0f=imgui.ImGuiWindowFlags_None;AAS=imgui.ImGuiWindowFlags_NoTitleBar;Zx=imgui.ImGuiWindowFlags_NoResize;VT=imgui.ImGuiWindowFlags_NoMove;A7L=imgui.ImGuiWindowFlags_NoScrollbar;A7N=imgui.ImGuiWindowFlags_NoScrollWithMouse;Vv=imgui.ImGuiWindowFlags_NoCollapse;A8X=imgui.ImGuiWindowFlags_AlwaysAutoResize;ZZ=imgui.ImGuiWindowFlags_NoBackground;A9Z=imgui.ImGuiWindowFlags_NoSavedSettings;BbH=imgui.ImGuiWindowFlags_NoMouseInputs;Vb=imgui.ImGuiWindowFlags_MenuBar;A$c=imgui.ImGuiWindowFlags_HorizontalScrollbar;AO4
=imgui.ImGuiWindowFlags_NoFocusOnAppearing;WG=imgui.ImGuiWindowFlags_NoBringToFrontOnFocus;Bb0=imgui.ImGuiWindowFlags_AlwaysVerticalScrollbar;AYo=imgui.ImGuiWindowFlags_AlwaysHorizontalScrollbar;ASp=imgui.ImGuiWindowFlags_AlwaysUseWindowPadding;AM4=imgui.ImGuiWindowFlags_NoNavInputs;UX=imgui.ImGuiWindowFlags_NoNavFocus;A9D=imgui.ImGuiWindowFlags_UnsavedDocument;S1=imgui.ImGuiWindowFlags_NoDocking;A8Q=imgui.ImGuiWindowFlags_NoNav;AT_=imgui.ImGuiWindowFlags_NoDecoration;AR0=imgui.ImGuiWindowFlags_NoInputs;};
let A0X=B();
let A9L=b=>{let c;c=Biv(D(462));c.A2=0;c.yx=0;c.yy=0;c.A9=0;c.C4=1;LE(new MD,A9R(),c);};
let Bjs=B();
let BbW=B(CG);
function Gt(){let a=this;A.call(a);a.yq=null;a.wC=null;a.DU=0;a.zF=0;a.yd=null;a.AX=0;a.H9=null;}
let OS=null;
let FV=()=>{FV=N(Gt);BiH();};
let Mz=(a,b,c,d,e,f)=>{FV();PE(a,b,c,d,e,W8(f));},
Bkn=(a,b,c,d,e)=>{let f=new Gt();Mz(f,a,b,c,d,e);return f;},
PE=(a,b,c,d,e,f)=>{FV();d:{a:{L(a);a.DU=1;a.AX=0;a.H9=X();N4();switch(E7.data[Bl(b)]){case 1:break;case 2:a.yq=Bfw(c,d,f);a.wC=AIa(c,e);a.zF=0;break d;case 3:a.yq=A1Y(c,d,f);a.wC=AIa(c,e);a.zF=0;break d;case 4:break a;default:break a;}a.yq=A3r(c,d,f);a.wC=AXj(c,e);a.zF=0;break d;}a.yq=BdF(d,f);a.wC=BfU(e);a.zF=1;}A1d(C6,a);},
Bk7=(a,b,c,d,e)=>{let f=new Gt();PE(f,a,b,c,d,e);return f;},
A$Y=(a,b,c,d)=>{a.yq.tb(b,c,d);return a;},
AQO=(a,b)=>{let c;c=b.data;a.wC.tc(b,0,c.length);return a;},
ASG=(a,b)=>{a.td(b,null,null);},
Bbd=(a,b,c,d)=>{a.yq.te(b,c);if(a.yd!==null&&a.yd.tf()>0)a.yd.te(b,d);if(a.wC.tg()>0)a.wC.gm();},
Ba_=(a,b)=>{a.th(b,null,null);},
A2q=(a,b,c,d)=>{a.yq.ti(b,c);if(a.yd!==null&&a.yd.tf()>0)a.yd.ti(b,d);if(a.wC.tg()>0)a.wC.gh();},
Bj7=(a,b,c,d,e)=>{a.tj(b,c,d,e,a.DU);},
A42=(a,b,c,d,e,f)=>{let g,h,i,j,k,l;if(!e)return;if(f)a.tk(b);if(a.zF){if(a.wC.tg()<=0)Y.mG(c,d,e);else{g=a.wC.tl(0);h=BY(g);BI(g);g.dX(d);Y.mH(c,e,5123,g);g.dX(h);}}else{i=0;if(a.AX)i=a.yd.tf();if(a.wC.tg()<=0){if(a.AX&&i>0)Ek.mD(c,d,e,i);else Y.mG(c,d,e);}else{if((e+d|0)>a.wC.tm()){j=new EU;k=(((((O()).O(D(463))).P(e)).O(D(464))).P(d)).O(D(465));l=a.wC;EO(j,((k.P(l.tm())).O(D(466))).y());I(j);}if(a.AX&&i>0)Ek.mE(c,e,5123,d*2|0,i);else Y.gg(c,e,5123,d*2|0);}}if(f)a.tn(b);},
AV5=(a,b)=>{return a.wC.tl(b);},
A1d=(b,c)=>{let d;FV();d=OS.bJ(b);if(d===null)d=Dx();d.eg(c);OS.bL(b,d);},
BiH=()=>{OS=M8();};
let AOt=B();
let Jn=(b,c)=>{let d;if(b<0)I(B3((((O()).O(D(467))).P(b)).y()));d=AU2(BT(2,ASE(b/c)|0));if(d<=1073741824)return d;I(B3((((O()).O(D(468))).P(b)).y()));};
let AWM=B();
let AGq=B(Bw);
let Yh=a=>{Cd(a);},
BcZ=()=>{let a=new AGq();Yh(a);return a;},
A7x=(a,b,c,d)=>{let e;e=!d.ds()?d.bq():c.bb();if(b<e)return (-1);d.wZ=1;d.Ii=1;return a.vN.br(b,c,d);},
AJd=(a,b)=>{return 0;};
function Ov(){let a=this;A.call(a);a.Bv=0;a.xx=null;a.yr=null;a.D9=0.0;a.BH=0;a.CZ=0;a.yV=0;}
let ZX=a=>{Ms(a,51,0.800000011920929);},
Fg=()=>{let a=new Ov();ZX(a);return a;},
Ms=(a,b,c)=>{let d;L(a);if(c>0.0&&c<1.0){a.D9=c;d=Jn(b,c);a.BH=d*c|0;a.yV=d-1|0;a.CZ=DU(Q(a.yV));a.xx=Bt(A,d);a.yr=Bp(d);return;}I(B3((((O()).O(D(401))).hR(c)).y()));},
Bk0=(a,b)=>{let c=new Ov();Ms(c,a,b);return c;},
A39=(a,b)=>{return U(BV(Bx(Q(b.hY()),C(2135587861, 2654435769)),a.CZ));},
ARl=(a,b)=>{let c,d,e;if(b===null)I(B3(D(435)));c=a.xx;d=a.rg(b);while(true){e=c.data[d];if(e===null)return  -(d+1|0)|0;if(e.bi(b))break;d=(d+1|0)&a.yV;}return d;},
Bbj=(a,b,c)=>{let d,e;d=a.rh(b);if(d>=0){a.yr.data[d]=c;return;}e= -(d+1|0)|0;a.xx.data[e]=b;a.yr.data[e]=c;e=a.Bv+1|0;a.Bv=e;if(e>=a.BH)AFE(a,a.xx.data.length<<1);},
AZT=(a,b,c)=>{let d,e,f;d=a.xx;e=a.rg(b);while(true){f=d.data;if(f[e]===null)break;e=(e+1|0)&a.yV;}f[e]=b;a.yr.data[e]=c;},
APE=(a,b,c)=>{let d;d=a.rh(b);if(d>=0)c=a.yr.data[d];return c;},
AFE=(a,b)=>{let c,d,e,f,g;d:{c=a.xx.data.length;a.BH=b*a.D9|0;a.yV=b-1|0;a.CZ=DU(Q(a.yV));d=a.xx;e=a.yr;a.xx=Bt(A,b);a.yr=Bp(b);if(a.Bv>0){f=0;while(true){if(f>=c)break d;g=d.data[f];if(g!==null)AZT(a,g,e.data[f]);f=f+1|0;}}}};
function Px(){let a=this;D9.call(a);a.HL=0;a.Bp=0;}
let XJ=(a,b,c)=>{Kl(a,0,b,EL(b),0,b,c,0);},
A2C=(a,b)=>{let c=new Px();XJ(c,a,b);return c;},
Kl=(a,b,c,d,e,f,g,h)=>{R9(a,b,c,d,e,f);a.HL=g;a.Bp=h;},
AU6=(a,b,c,d,e,f,g)=>{let h=new Px();Kl(h,a,b,c,d,e,f,g);return h;},
AJC=(a,b)=>{let c,d,e;if(b>=0&&b<a.v4)return a.vS.data[a.wH+b|0];c=new Bv;d=a.v4;e=O();BA(V(K(V(K(e,D(233)),b),D(35)),d),41);BB(c,S(e));I(c);},
ARF=(a,b,c)=>{let d,e,f;if(a.Bp)I(D2());if(b>=0&&b<a.v4){a.vS.data[a.wH+b|0]=c;return a;}d=new Bv;e=a.v4;f=O();BA(V(K(V(K(f,D(233)),b),D(35)),e),41);BB(d,S(f));I(d);},
Bev=a=>{return a.Bp;},
BiR=a=>{let b,c;b=Bk(a)/2|0;c=a.yN;Dj();if(c!==Fu)return Bed(a.wH+a.vU|0,b,a,0,b,a.d1());return AJw(a.wH+a.vU|0,b,a,0,b,a.d1());},
Bco=(a,b)=>{let c,d,e,f,g,h,i;if(b>=0&&(b+3|0)<a.v4){c=a.vS.data[a.wH+b|0]&255;d=a.vS.data[(a.wH+b|0)+1|0]&255;e=a.vS.data[(a.wH+b|0)+2|0]&255;f=a.vS.data[(a.wH+b|0)+3|0]&255;g=a.yN;Dj();if(g!==Fu)return f<<24|e<<16|d<<8|c;return c<<24|d<<16|e<<8|f;}g=new Bv;h=a.v4-3|0;i=O();BA(V(K(V(K(i,D(233)),b),D(35)),h),41);BB(g,S(i));I(g);},
Bi_=a=>{let b,c;b=Bk(a)/4|0;c=a.yN;Dj();if(c!==Fu)return A8Z(a.wH+a.vU|0,b,a,0,b,a.d1());return ANM(a.wH+a.vU|0,b,a,0,b,a.d1());},
A5L=a=>{let b,c;b=Bk(a)/4|0;c=a.yN;Dj();if(c!==P7)return Bbe(a.wH+a.vU|0,b,a,0,b,a.d1());return AJV(a.wH+a.vU|0,b,a,0,b,a.d1());},
Bj5=a=>{let b;b=Yf(a);return b.data;};
function SU(){let a=this;A.call(a);a.Da=null;a.FM=null;a.HC=0;a.Iq=0;}
let ACH=(a,b,c)=>{L(a);a.Da=b;a.FM=c;},
ASH=(a,b)=>{let c=new SU();ACH(c,a,b);return c;},
A$g=a=>{if(!a.HC){a.Da.D6=null;DW(a.Da);a.FM.j(null);}};
function Pr(){let a=this;A.call(a);a.z$=null;a.Bt=0.0;}
let WF=(a,b,c)=>{L(a);a.z$=X();a.Bt=0.0;(a.z$.cY(b)).nx();a.Bt=c;},
ADN=(a,b)=>{let c=new Pr();WF(c,a,b);return c;},
A22=(a,b,c,d)=>{(((a.z$.cY(b)).c1(c)).tt(c.vZ-d.vZ,c.v1-d.v1,c.v0-d.v0)).nx();a.Bt= -b.tu(a.z$);};
let ZD=B(0);
function OD(){let a=this;A.call(a);a.xN=null;a.wm=null;a.yY=null;}
let AIG=null,Fp=null,A6a=null;
let Ie=()=>{Ie=N(OD);A18();};
let RJ=a=>{let b;Ie();L(a);a.xN=Bt(Pr,6);a.wm=H(Dd,[X(),X(),X(),X(),X(),X(),X(),X()]);a.yY=Cq(24);b=0;while(b<6){a.xN.data[b]=ADN(X(),0.0);b=b+1|0;}},
A9E=()=>{let a=new OD();RJ(a);return a;},
A7m=(a,b)=>{let c,d,e,f,g,h;Ie();C5(Fp,0,a.yY,0,Fp.data.length);Bc8(b.vL,a.yY,0,8,3);c=0;d=0;while(c<8){e=a.wm.data[c];f=a.yY.data;g=d+1|0;e.vZ=f[d];f=a.yY.data;h=g+1|0;e.v1=f[g];f=a.yY.data;d=h+1|0;e.v0=f[h];c=c+1|0;}a.xN.data[0].tw(a.wm.data[1],a.wm.data[0],a.wm.data[2]);a.xN.data[1].tw(a.wm.data[4],a.wm.data[5],a.wm.data[7]);a.xN.data[2].tw(a.wm.data[0],a.wm.data[4],a.wm.data[3]);a.xN.data[3].tw(a.wm.data[5],a.wm.data[1],a.wm.data[6]);a.xN.data[4].tw(a.wm.data[2],a.wm.data[3],a.wm.data[6]);a.xN.data[5].tw(a.wm.data[4],
a.wm.data[0],a.wm.data[1]);},
A18=()=>{let b,c,d,e,f,g,h,i;AIG=H(Dd,[Co((-1.0),(-1.0),(-1.0)),Co(1.0,(-1.0),(-1.0)),Co(1.0,1.0,(-1.0)),Co((-1.0),1.0,(-1.0)),Co((-1.0),(-1.0),1.0),Co(1.0,(-1.0),1.0),Co(1.0,1.0,1.0),Co((-1.0),1.0,1.0)]);Fp=Cq(24);b=0;c=AIG.data;d=c.length;e=0;while(e<d){f=c[e];g=Fp.data;h=b+1|0;g[b]=f.vZ;g=Fp.data;i=h+1|0;g[h]=f.v1;g=Fp.data;b=i+1|0;g[i]=f.v0;e=e+1|0;}A6a=X();};
function ML(){let a=this;A.call(a);a.DM=null;a.FD=null;}
let AK3=null;
let NG=()=>{NG=N(ML);BaF();};
let AGJ=(a,b,c)=>{NG();L(a);a.DM=X();a.FD=X();a.DM.cY(b);(a.FD.cY(c)).nx();},
ANy=(a,b)=>{let c=new ML();AGJ(c,a,b);return c;},
BaF=()=>{AK3=X();};
let BbJ=B(Cx);
function Nt(){let a=this;A.call(a);a.v$=null;a.y7=0;a.xB=null;a.w9=null;a.wf=null;a.we=null;a.Ag=null;a.Ah=null;a.AQ=null;a.zh=0;a.y_=null;a.AM=0;a.Aw=null;a.A4=null;a.EC=null;a.v_=null;a.xK=Bg;a.yS=0;}
let Bh7=b=>{let c,d,e,f,g;c=ASe();d=0.0;e=b.detail;f=b.wheelDelta;if(c.firefox?1:0)d=(c.macOS?1:0)?1.0*e:1.0*e/3.0;else if(c.opera?1:0)d=!(c.linux?1:0)?(-1.0)*f/40.0:(-1.0)*f/80.0;else if(!(!(c.chrome?1:0)&&!(c.safari?1:0)&&!(c.IE?1:0))){d=(-1.0)*f;g=d/120.0;if(A75(g)>=1.0)d=g;else if(!(c.windows?1:0))d=!(c.macOS?1:0)?g:d/3.0;}return d;},
ACW=(a,b)=>{L(a);a.y7=0;a.xB=AOV(20);a.w9=Qh(20);a.wf=Bp(20);a.we=Bp(20);a.Ag=Bp(20);a.Ah=Bp(20);a.AQ=AGe();a.zh=0;a.y_=Qh(256);a.AM=0;a.Aw=Qh(256);a.A4=Qh(5);a.EC=AGe();a.yS=1;a.v$=b;A4R(a);},
AOQ=a=>{let b=new Nt();ACW(b,a);return b;},
A4R=a=>{let b;b=a.v$.ownerDocument;b.addEventListener("mousedown",Bu(a,"handleEvent"),!!0);b.addEventListener("mouseup",Bu(a,"handleEvent"),!!0);b.addEventListener("mousemove",Bu(a,"handleEvent"),!!0);b.addEventListener("wheel",Bu(a,"handleEvent"),!!0);b.addEventListener("keydown",Bu(a,"handleEvent"),!!0);b.addEventListener("keyup",Bu(a,"handleEvent"),!!0);b.addEventListener("keypress",Bu(a,"handleEvent"),!!0);a.v$.addEventListener("touchstart",Bu(a,"handleEvent"),!!1);a.v$.addEventListener("touchmove",Bu(a,
"handleEvent"),!!1);a.v$.addEventListener("touchcancel",Bu(a,"handleEvent"),!!1);a.v$.addEventListener("touchend",Bu(a,"handleEvent"),!!1);},
Bcx=(a,b)=>{A5J(a,b);AKT(a,b);},
A5J=(a,b)=>{let c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x;d:{c=Ba(b.type);if(c.bi(D(469))){window.focus();d=b;e=b.target;f=a.v$;g=e!==f?0:1;if(g&&!a.w9.data[0]){a.yS=1;a.y7=1;a.w9.data[0]=1;h=Jl(d.button);a.AQ.tD(h);a.A4.data[h]=1;a.Ag.data[0]=0;a.Ah.data[0]=0;if(!a.tE()){i=a.tF(d,a.v$);j=a.tG(d,a.v$);a.wf.data[0]=i;a.we.data[0]=j;}else{k=a.wf.data;k[0]=k[0]+d.movementX|0;k=a.we.data;k[0]=k[0]+d.movementY|0;}a.xK=DI();if(a.v_!==null)a.v_.os(a.wf.data[0],a.we.data[0],0,Jl(d.button));b.preventDefault();b.stopPropagation();break d;}l
=a.tF(d,a.v$);m=a.tG(d,a.v$);if(!(l>=0.0&&l<=B5.fM()&&m>=0.0&&m<=B5.fN()))a.yS=0;return;}if(c.bi(D(470))){d=b;if(!a.w9.data[0])return;a.AQ.tH(Jl(d.button));k=a.w9;k.data[0]=a.AQ.w5<=0?0:1;if(!a.tE()){a.tI(0,a.tF(d,a.v$)-a.wf.data[0]|0,a.tG(d,a.v$)-a.we.data[0]|0);a.wf.data[0]=a.tF(d,a.v$);a.we.data[0]=a.tG(d,a.v$);}else{a.tI(0,d.movementX|0,d.movementY|0);k=a.wf.data;k[0]=k[0]+d.movementX|0;k=a.we.data;k[0]=k[0]+d.movementY|0;}a.xK=DI();a.w9.data[0]=0;if(a.v_!==null)a.v_.ot(a.wf.data[0],a.we.data[0],0,Jl(d.button));}
else if(!c.bi(D(471))){if(c.bi(D(472))){n=b;if(a.v_!==null){o=Bh7(n);a.v_.ow(0.0,o|0);}a.xK=DI();}else if(c.bi(D(473))){a.y7=1;p=b;q=p.changedTouches;r=0;s=q.length;while(r<s){t=q.item(r);u=t.identifier;v=a.xB;w=BdP(a);v.lX(u,DG(w));a.w9.data[w]=1;a.wf.data[w]=a.tM(t,a.v$);a.we.data[w]=a.tN(t,a.v$);a.Ag.data[w]=0;a.Ah.data[w]=0;if(a.v_!==null)a.v_.os(a.wf.data[w],a.we.data[w],w,0);r=r+1|0;}a.xK=DI();b.preventDefault();}}else{d=b;if(!a.tE()){i=a.tF(d,a.v$);j=a.tG(d,a.v$);a.tI(0,i-a.wf.data[0]|0,j-a.we.data[0]
|0);a.wf.data[0]=i;a.we.data[0]=j;}else{a.tI(0,d.movementX|0,d.movementY|0);k=a.wf.data;k[0]=k[0]+d.movementX|0;k=a.we.data;k[0]=k[0]+d.movementY|0;}a.xK=DI();if(a.v_!==null){if(!a.w9.data[0])a.v_.ov(a.wf.data[0],a.we.data[0]);else a.v_.ou(a.wf.data[0],a.we.data[0],0);}}}if(c.bi(D(474))){p=b;q=p.changedTouches;r=0;s=q.length;while(r<s){t=q.item(r);u=t.identifier;x=(a.xB.bW(u)).tO();a.tI(x,a.tM(t,a.v$)-a.wf.data[x]|0,a.tN(t,a.v$)-a.we.data[x]|0);a.wf.data[x]=a.tM(t,a.v$);a.we.data[x]=a.tN(t,a.v$);if(a.v_!==null)a.v_.ou(a.wf.data[x],
a.we.data[x],x);r=r+1|0;}a.xK=DI();b.preventDefault();}if(c.bi(D(475))){p=b;q=p.changedTouches;r=0;s=q.length;while(r<s){t=q.item(r);u=t.identifier;x=(a.xB.bW(u)).tO();a.xB.b2(u);a.w9.data[x]=0;i=a.tM(t,a.v$);j=a.tN(t,a.v$);a.tI(x,i-a.wf.data[x]|0,j-a.we.data[x]|0);a.wf.data[x]=i;a.we.data[x]=j;if(a.v_!==null)a.v_.ot(a.wf.data[x],a.we.data[x],x,0);r=r+1|0;}a.xK=DI();b.preventDefault();}if(c.bi(D(476))){p=b;q=p.changedTouches;r=0;s=q.length;while(r<s){t=q.item(r);u=t.identifier;x=(a.xB.bW(u)).tO();a.xB.b2(u);a.w9.data[x]
=0;i=a.tM(t,a.v$);j=a.tN(t,a.v$);a.tI(x,i-a.wf.data[x]|0,j-a.we.data[x]|0);a.wf.data[x]=i;a.we.data[x]=j;if(a.v_!==null)a.v_.ot(a.wf.data[x],a.we.data[x],x,0);r=r+1|0;}a.xK=DI();b.preventDefault();}},
AKT=(a,b)=>{let c,d,e,f,g;c=Ba(b.type);if(!(c.bi(D(477))&&a.yS)){if(c.bi(D(478))&&a.yS){d=b;e=d.charCode&65535;if(a.v_!==null)a.v_.or(e);if(e==9){b.preventDefault();b.stopPropagation();}}else if(c.bi(D(479))&&a.yS){d=b;f=ZM(d.keyCode);if(a.tQ(f))b.preventDefault();if(a.y_.data[f]){a.zh=a.zh-1|0;a.y_.data[f]=0;}if(a.v_!==null)a.v_.oq(f);if(f==61){b.preventDefault();b.stopPropagation();}}}else{j:{d=b;f=ZM(d.keyCode);g=0;switch(f){case 67:g=8;break j;case 112:g=127;break j;default:}}if(a.tQ(f))b.preventDefault();if
(!(f!=67&&f!=112)){b.preventDefault();if(a.v_!==null){a.v_.oo(f);a.v_.or(g);}}else if(!a.y_.data[f]){a.zh=a.zh+1|0;a.y_.data[f]=1;a.AM=1;a.Aw.data[f]=1;if(a.v_!==null)a.v_.oo(f);}if(f==61){b.preventDefault();b.stopPropagation();}}},
BdP=a=>{let b;b=0;while(true){if(b>=20)return (-1);if(!a.xB.tR(DG(b),0))break;b=b+1|0;}return b;},
AZL=a=>{let b;d:{if(a.y7){a.y7=0;b=0;while(true){if(b>=a.A4.data.length)break d;a.A4.data[b]=0;b=b+1|0;}}}b:{if(a.AM){a.AM=0;b=0;while(true){if(b>=a.Aw.data.length)break b;a.Aw.data[b]=0;b=b+1|0;}}}},
AYR=(a,b,c,d)=>{a.Ag.data[b]=c;a.Ah.data[b]=d;},
Vh=(a,b)=>{let c,d;c=Ba(b.compatMode);d=c.bi(D(480));if(d)b=b.documentElement;return b;},
Lh=(a,b)=>{let c;c=b.scrollTop;return Ia(c);},
AC2=(a,b)=>{let c;c=Vh(a,b);return Lh(a,c);},
KA=(a,b)=>{let c;c=b.scrollLeft;return Ia(c);},
WX=(a,b)=>{let c;c=Vh(a,b);return KA(a,c);},
Bjp=(a,b,c)=>{let d;d=(c.clientX-AB_(a,b)|0)+KA(a,b)|0;d=d+WX(a,b.ownerDocument)|0;return d;},
A6U=(a,b,c)=>{let d;d=(c.clientY-AH6(a,b)|0)+Lh(a,b)|0;d=d+AC2(a,b.ownerDocument)|0;return d;},
A2M=(a,b,c)=>{let d,e;d=c.width*1.0/T5(a,c);e=d*(((b.clientX-AB_(a,c)|0)+KA(a,c)|0)+WX(a,c.ownerDocument)|0);return Jo(e);},
BaQ=(a,b,c)=>{let d,e;d=c.height*1.0/AFW(a,c);e=d*(((b.clientY-AH6(a,c)|0)+Lh(a,c)|0)+AC2(a,c.ownerDocument)|0);return Jo(e);},
AXN=(a,b,c)=>{let d;d=c.width*1.0/T5(a,c);return Jo(d*Bjp(a,c,b));},
A_N=(a,b,c)=>{let d;d=c.height*1.0/AFW(a,c);return Jo(d*A6U(a,c,b));},
T5=(a,b)=>{return b.clientWidth;},
AFW=(a,b)=>{return b.clientHeight;},
AH6=(a,b)=>{return Ia(A8J(a,b));},
A8J=(a,b)=>{let c,d;c=0.0;d=b;while(d.offsetParent!==null){c=c-d.scrollTop;d=d.parentNode;}while(b!==null){c=c+b.offsetTop;b=d.offsetParent;}return c;},
AB_=(a,b)=>{return Ia(AMe(a,b));},
AMe=(a,b)=>{let c,d;c=0.0;d=b;while(d.offsetParent!==null){c=c-d.scrollLeft;d=d.parentNode;}while(b!==null){c=c+b.offsetLeft;b=d.offsetParent;}return c;},
Ia=b=>{return b|0;},
A_T=(a,b)=>{return a.EC.b6(b);},
AT2=(a,b)=>{a.v_=b;},
A6S=a=>{return Bdh(a.v$)?1:0;},
Bdh=b=>{if(document.pointerLockElement===canvas||document.mozPointerLockElement===canvas){return true;}return false;},
ALR=(a,b)=>{a.bn(b);};
let BbK=B(Cx);
let V9=B(Bi);
let AHr=a=>{B9(a);},
AVa=()=>{let a=new V9();AHr(a);return a;};
let A9K=B();
let AG8=B(Bq);
let RO=a=>{CH(a);},
AWf=()=>{let a=new AG8();RO(a);return a;};
let AG9=B(Bq);
let Xa=a=>{CH(a);},
AYM=()=>{let a=new AG9();Xa(a);return a;};
let AG$=B(Bq);
let AGE=a=>{CH(a);},
ALO=()=>{let a=new AG$();AGE(a);return a;};
let AA1=B(Ga);
let ADO=a=>{P1(a);},
AJQ=()=>{let a=new AA1();ADO(a);return a;},
AWP=(a,b)=>{BkJ(Be(b));};
let AG_=B(Bq);
let AEJ=a=>{CH(a);},
AI6=()=>{let a=new AG_();AEJ(a);return a;};
let A$d=B(Bo);
let AHa=B(Cb);
let WJ=a=>{O4(a);},
AQG=()=>{let a=new AHa();WJ(a);return a;};
let Ya=B(0);
let AFI=B();
let A2Z=(a,b,c)=>{a.t8(Ba(b),Cl(c,"handleEvent"));},
A4E=(a,b,c)=>{a.t9(Ba(b),Cl(c,"handleEvent"));},
AJ8=(a,b,c,d)=>{a.t$(Ba(b),Cl(c,"handleEvent"),d?1:0);},
AKs=(a,b)=>{return !!a.t_(b);},
AXs=(a,b,c,d)=>{a.ua(Ba(b),Cl(c,"handleEvent"),d?1:0);};
let S0=B();
function AHm(){A.call(this);this.Cc=null;}
let Yo=a=>{L(a);a.Cc=TA();},
A8L=()=>{let a=new AHm();Yo(a);return a;},
APJ=a=>{let b,c,d,e;WN(D(481),a.Cc,a.Cc.h8());if(A2n()){Bgb(D(482),3);AAI(D(483));Bgv();}AAI(D(484));if(BjD()){b=A8c(D(482));if(b!==null){(Ci()).d$(D(485));c=b.uh();d=Ci();e=O();V(K(e,D(486)),c);d.d$(S(e));}AXr();}},
A3p=a=>{return D(487);};
let Lk=B();
let QF=a=>{L(a);},
Bcj=()=>{let a=new Lk();QF(a);return a;},
Bc7=(a,b)=>{A8h(b);},
AP6=(a,b)=>{a.uk(AAL(b));};
let Ll=B();
let TY=a=>{L(a);},
BaR=()=>{let a=new Ll();TY(a);return a;},
AKK=(a,b)=>{ATh(b);},
AKe=(a,b)=>{a.uk(AAL(b));};
let A80=B();
let NU=null,JW=null,N_=null;
let Ci=()=>{if(NU===null)NU=A51();return NU;},
AEH=()=>{if(JW===null)JW=AJQ();return JW;},
Bk6=(b,c,d,e,f)=>{let g,h,i,j,k,l,m,n;if(b!==null&&d!==null){if(c>=0&&e>=0&&f>=0&&(c+f|0)<=I4(b)){g=e+f|0;if(g<=I4(d)){h:{e:{if(b!==d){h=(Do(b)).eB();i=(Do(d)).eB();if(h!==null&&i!==null){if(h===i)break e;if(!h.eL()&&!i.eL()){j=b;k=0;g=c;while(k<f){l=j.data;m=g+1|0;n=l[g];if(!i.uo(n)){Ii(b,c,d,e,k);I(LM());}k=k+1|0;g=m;}Ii(b,c,d,e,f);return;}if(!h.eL())break h;if(i.eL())break e;else break h;}I(LM());}}Ii(b,c,d,e,f);return;}I(LM());}}I(Ch());}I(ADL(D(488)));},
C5=(b,c,d,e,f)=>{let g;if(c>=0&&e>=0&&f>=0&&(c+f|0)<=I4(b)){g=e+f|0;if(g<=I4(d)){Ii(b,c,d,e,f);return;}}I(Ch());},
Ii=(b,c,d,e,f)=>{if(f!==0){if(typeof b.data.buffer!=='undefined'){d.data.set(b.data.subarray(c,c+f),e);}else if(b!==d||e<c){for(let i=0;i<f;i=i+1|0){d.data[e++]=b.data[c++];}}else {c=c+f|0;e=e+f|0;for(let i=0;i<f;i=i+1|0){d.data[ --e]=b.data[ --c];}}}},
OO=()=>{return Xu((new Date()).getTime());},
AUE=()=>{let b;if(N_===null){b=A2v();b.bL(D(489),D(490));b.bL(D(452),D(491));b.bL(D(492),D(493));b.bL(D(494),D(236));b.bL(D(495),AUv());b.bL(D(496),Bc4());b.bL(D(497),D(490));b.bL(D(498),Bh0());N_=A21(b);}},
Bc4=()=>{return D(499);},
Bh0=()=>{return D(493);},
Fe=(b,c)=>{AUE();return N_.bL(b,c);},
A$t=()=>{return Xu(performance.now()*1000000.0);},
AUv=()=>{return D(235);};
let Uv=B(W);
let S3=a=>{Bn(a);},
ANQ=()=>{let a=new Uv();S3(a);return a;},
Bg0=a=>{return (((Cy()).G(48,57)).G(97,102)).G(65,70);};
function AAs(){let a=this;A.call(a);a.G2=null;a.FQ=null;a.zn=null;a.wh=null;a.Ak=0;a.Am=0;}
let ABc=(a,b)=>{return a.wh.ix(b);},
J7=(a,b)=>{let c,d;c=a.zn.bb();if(b>=0&&b<=c){d=A_j(a,b);if(d>=0&&a.wh.uw()){a.wh.ux();return 1;}a.wh.w2=(-1);return 0;}I(GF(IP(b)));},
A_j=(a,b)=>{let c;a.wh.sW();a.wh.oH(1);a.wh.uy(b);c=a.FQ.ev(b,a.zn,a.wh);if(c==(-1))a.wh.wZ=1;return c;},
Ml=a=>{let b,c;b=a.zn.bb();if(!RY(a))b=a.Am;if(a.wh.w2>=0&&a.wh.kR()==1){a.wh.w2=a.wh.dz();if(a.wh.dz()==a.wh.rk()){c=a.wh;c.w2=c.w2+1|0;}return a.wh.w2<=b&&J7(a,a.wh.w2)?1:0;}return J7(a,a.Ak);},
AIw=(a,b)=>{return a.wh.dy(b);},
RF=(a,b)=>{return a.wh.dw(b);},
AHA=a=>{return AIw(a,0);},
VI=a=>{return RF(a,0);},
RY=a=>{return a.wh.ds();},
Qx=(a,b,c)=>{let d,e,f,g,h;L(a);a.Ak=(-1);a.Am=(-1);a.G2=b;a.FQ=b.Ch;a.zn=c;a.Ak=0;a.Am=a.zn.bb();d=new OC;e=a.Ak;f=a.Am;g=Rs(b);h=AGb(b);NI(d,c,e,f,g,h,ACA(b));a.wh=d;a.wh.uE(1);},
AVu=(a,b)=>{let c=new AAs();Qx(c,a,b);return c;};
let AGh=B(BD);
let ABZ=a=>{Cu(a);},
Bf4=()=>{let a=new AGh();ABZ(a);return a;},
BhS=(a,b,c,d)=>{let e,f,g,h,i;e=d.bq();f=b+1|0;if(f>e){d.wZ=1;return (-1);}g=c.bc(b);if(Cs(g)){h=b+2|0;if(h<=e){i=c.bc(f);if(G_(g,i))return a.vN.br(h,c,d);}}return a.vN.br(f,c,d);},
APe=(a,b)=>{a.vN=b;},
A6K=a=>{return (-2147483602);},
APa=(a,b)=>{return 1;};
let ARq=B();
let AIW=B(W);
let ADR=a=>{Bn(a);},
AJE=()=>{let a=new AIW();ADR(a);return a;},
AJH=a=>{let b;b=AMP(a);b.v3=1;return b;};
function J1(){let a=this;Bm.call(a);a.AK=null;a.AJ=null;}
let Bkk=null,Bkh=null,Bkg=null;
let M5=()=>{M5=N(J1);AK7();};
let Rq=(a,b)=>{M5();BR(a);},
I5=a=>{let b=new J1();Rq(b,a);return b;},
A85=a=>{let b;b=Q(BcE(U((a.fg()))));if(BS(b,Bg))return null;if(a.AK===null)a.AK=ADF(1);a.AK.i0(b);return a.AK;},
Biw=a=>{let b;b=Q(A5Z(U((a.fg()))));if(BS(b,Bg))return null;if(a.AJ===null)a.AJ=ADF(1);a.AJ.i0(b);return a.AJ;},
AK7=()=>{Bkk=I5(1);Bkh=I5(1);Bkg=I5(1);},
BcE=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImGuiViewport);var returnedJSObj=jsObj.get_Pos();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);},
A5Z=b=>{var jsObj=imgui.wrapPointer(b,imgui.ImGuiViewport);var returnedJSObj=jsObj.get_Size();if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);};
function K_(){let a=this;BD.call(a);a.xv=null;a.CO=null;a.zG=0;}
let Ri=(a,b,c)=>{Cu(a);a.xv=b;a.zG=c;},
AGi=(a,b)=>{let c=new K_();Ri(c,a,b);return c;},
A3W=(a,b)=>{a.vN=b;},
WL=a=>{if(a.CO===null)a.CO=J2(a.xv);return a.CO;},
AJB=(a,b,c,d)=>{let e,f,g,h,i,j,k,l,m,n,o,p,q,r;e=d.bq();f=0;g=Bp(3);h=(-1);i=(-1);if(b>=e)return (-1);j=b+1|0;k=c.bc(b);l=ASn(k);if(l!==null){m=l.data;n=0;if(m.length!=a.zG)return (-1);while(true){if(n>=a.zG)return a.vN.br(j,c,d);if(m[n]!=a.xv.data[n])break;n=n+1|0;}return (-1);}o=g.data;o[f]=k;p=k-4352|0;if(p>=0&&p<19){if(j<e){k=c.bc(j);h=k-4449|0;}if(h>=0&&h<21){q=j+1|0;o[1]=k;if(q<e){k=c.bc(q);i=k-4519|0;}if(i>=0&&i<28){r=q+1|0;o[2]=k;r=a.zG==3&&o[0]==a.xv.data[0]&&o[1]==a.xv.data[1]&&o[2]==a.xv.data[2]
?a.vN.br(r,c,d):(-1);return r;}r=a.zG==2&&o[0]==a.xv.data[0]&&o[1]==a.xv.data[1]?a.vN.br(q,c,d):(-1);return r;}return (-1);}return (-1);},
APb=(a,b)=>{let c,d;d:{if(b instanceof K_){c=b;if(!(WL(c)).bi(WL(a))){d=0;break d;}}d=1;}return d;},
BdK=(a,b)=>{return 1;};
let XR=B();
let AO3=B(B0);
function Y4(){A.call(this);this.Gc=null;}
let WC=(a,b)=>{L(a);a.Gc=b;},
AZ3=a=>{let b=new Y4();WC(b,a);return b;},
AUe=a=>{ATI(a.Gc);};
function QE(){let a=this;Fl.call(a);a.E8=null;a.An=0;}
let AFG=(a,b)=>{IE(a);a.An=0;a.E8=b;},
A3z=a=>{let b=new QE();AFG(b,a);return b;},
AX1=a=>{A$W(AZ3(a));},
AWI=(a,b)=>{if(a.An){a.An=0;a.E8.o2(Bfq());}},
ATI=a=>{a.An=1;};
function OB(){let a=this;A.call(a);a.yQ=null;a.wu=null;}
let QB=(a,b,c)=>{a.wu=b;a.yQ=c;L(a);},
BhH=(a,b)=>{let c=new OB();QB(c,a,b);return c;},
BdE=(a,b)=>{let c,d,e,f,$$je,$p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();f=$T.l();e=$T.l();d=$T.l();c=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:if(a.yQ.readyState==4){a:{if(a.yQ.status==200){if(a.wu.yl.xM){c=Ci();d=a.wu.yc;e=O();K(K(e,D(406)),d);c.d$(S(e));}a.wu.yu.bl(a.wu.yc,Ba(a.yQ.responseText));}else{if(a.yQ.status!=404){c=a.yQ;if(c.status!=403){try{f=Q(100);$p=1;continue _;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}a.wu.yl.hh(a.wu.z2,a.wu.yc,a.wu.yu);break a;}}a.wu.yu.bj(a.wu.yc);}}a.wu.yl.bm();}return;case 1:d:
{try{LK(f);if(DM()){break _;}break d;}catch($$e){$$je=Bb($$e);if($$je instanceof B4){}else{throw $$e;}}}a.wu.yl.hh(a.wu.z2,a.wu.yc,a.wu.yu);a.wu.yl.bm();return;default:DB();}}BZ().s(a,b,c,d,e,f,$p);},
AYS=(a,b)=>{let $p,$z;$p=0;if(DO()){let $T=BZ();$p=$T.l();b=$T.l();a=$T.l();}_:while(true){switch($p){case 0:$p=1;case 1:a.bn(b);if(DM()){break _;}return;default:DB();}}BZ().s(a,b,$p);};
let Ho=B();
let ADP=B(Fq);
let IJ=B(Bz);
let AGD=null,AG1=null,Qm=null,BgD=null;
let MW=()=>{MW=N(IJ);AZY();};
let ASA=(a,b,c)=>{MW();Ce(a,b,c);},
O3=(a,b)=>{let c=new IJ();ASA(c,a,b);return c;},
AZY=()=>{AGD=O3(D(500),0);AG1=O3(D(501),1);Qm=O3(D(502),2);BgD=H(IJ,[AGD,AG1,Qm]);};
let A97=B(0);
function Vf(){Bw.call(this);this.FU=0;}
let Yx=(a,b)=>{Cd(a);a.FU=b;},
AFV=a=>{let b=new Vf();Yx(b,a);return b;},
AOu=(a,b,c,d)=>{let e,f,g,h,i;e=b<d.bq()?c.bc(b):32;f=!b?32:c.bc(b-1|0);g=!d.ds()?d.b5():0;h=e!=32&&!WV(a,e,b,g,c)?0:1;i=f!=32&&!WV(a,f,b-1|0,g,c)?0:1;return h^i^a.FU?(-1):a.vN.br(b,c,d);},
AO5=(a,b)=>{return 0;},
WV=(a,b,c,d,e)=>{let f;if(!X3(b)&&b!=95){f:{if(HQ(b)==6)while(true){c=c+(-1)|0;if(c<d)break f;f=e.bc(c);if(X3(f))return 0;if(HQ(f)!=6)return 1;}}return 1;}return 0;};
let AW$=B();
let A$M=B();
let Pg=(b,c,d,e)=>{let f;f=BaK(c);Nf(f);c.dX(0);f.im(b,e,d);c.dX(0);if(!(c instanceof D9))c.g7(d);else c.g7(d<<2);},
BaK=b=>{let c;c=null;if(b instanceof D9)c=b.ii();else if(b instanceof DV)c=b;if(c!==null)return c;I(DF(D(503)));},
NK=b=>{let c;if(!HO())return ALg(Cq(b));c=DH(b*4|0);DX(c,Ej());return c.ii();},
Ut=b=>{let c;if(!HO())return ATu(EL(b));c=DH(b);DX(c,Ej());return c;},
AD5=b=>{let c;if(!HO())return A4D(AT7(b));c=DH(b*2|0);DX(c,Ej());return c.m3();},
GO=b=>{let c;if(!HO())return AXd(Bp(b));c=DH(b*4|0);DX(c,Ej());return c.p0();};
let U6=B(Dg);
let Bka=null;
let Mf=()=>{Mf=N(U6);AQN();};
let APT=b=>{Mf();if(!(isNaN(b)?1:0))return BlK(b);return C(0, 2146959360);},
AQN=()=>{Bka=Br(BkG);};
let Dm=B();
let AWw=B(Dm);
let AWq=B(OK);
let AWr=B(Dm);
let AWs=B(Dm);
let AWv=B(Dm);
let A5g=B(Bo);
let TH=B(0);
let R0=B();
let A71=(a,b)=>{return AFF(a.bW(b));},
BbM=(a,b,c)=>{a.t8(Ba(b),Cl(c,"handleEvent"));},
Bag=(a,b,c)=>{a.t9(Ba(b),Cl(c,"handleEvent"));},
A7I=(a,b,c,d)=>{a.t$(Ba(b),Cl(c,"handleEvent"),d?1:0);},
BfE=(a,b)=>{return !!a.t_(b);},
AQg=a=>{return a.kJ();},
AJ$=(a,b,c,d)=>{a.ua(Ba(b),Cl(c,"handleEvent"),d?1:0);};
let RX=B();
let AWZ=null,A6h=null,AWY=null,ABt=null,AJu=null,APP=null,A5q=null,AKf=null,A92=null;
let ADQ=()=>{ADQ=N(RX);AQ1();};
let AQ1=()=>{AWZ=Zq(0.0);A6h=Zq(1.0);AWY=DG(0);ABt=DG(1);AJu=ABt;APP=DG(2);A5q=DG(4);AKf=DG(8);A92=DG(16);};
let AL5=B();
let A$S=B(BC);
let Bcu=B(E5);
let ACJ=B(D5);
let V6=(a,b,c,d)=>{Iv(a,b,c,d);},
Bbp=(a,b,c)=>{let d=new ACJ();V6(d,a,b,c);return d;},
AMN=(a,b,c,d)=>{let e;e=a.vN.br(b,c,d);if(e>=0)return e;return a.vY.br(b,c,d);};
let ADE=B(W);
let SR=a=>{Bn(a);},
BdG=()=>{let a=new ADE();SR(a);return a;},
AZO=a=>{return AR7(a);};
let BiM=B(N3);
let AVF=B(BC);
let H7=B(Bm);
let LA=(a,b)=>{let c;BR(a);c=Q(AZf(b));a.fe(c,1);},
Fr=a=>{let b=new H7();LA(b,a);return b;},
A1$=(a,b)=>{return A_$(U((a.fg())),b);},
A61=a=>{return Q(Bde(U((a.fg()))));},
AZf=b=>{var jsObj=new imgui.IDLFloatArray(b);return imgui.getPointer(jsObj);},
A_$=(b,c)=>{var jsObj=imgui.wrapPointer(b,imgui.IDLFloatArray);var returnedJSObj=jsObj.getValue(c);return returnedJSObj;},
Bde=b=>{var jsObj=imgui.wrapPointer(b,imgui.IDLFloatArray);var returnedJSObj=jsObj.getPointer();return returnedJSObj;};
let My=B(H7);
let ABD=null,ABE=null;
let HM=()=>{HM=N(My);AKg();};
let APF=()=>{HM();ABD.fh();ABE.fh();},
VL=a=>{HM();LA(a,1);},
Yj=()=>{let a=new My();VL(a);return a;},
BeE=a=>{return a.uW(0);},
BhZ=a=>{return AWt(a.uY());},
AKg=()=>{ABD=Yj();ABE=Yj();};
let B$=B(Ca);
let R$=a=>{FO(a);},
AIE=()=>{let a=new B$();R$(a);return a;},
C9=(a,b)=>{Dy(a,b);},
E4=a=>{let b=new B$();C9(b,a);return b;};
function AAx(){let a=this;A.call(a);a.CB=0;a.BZ=0;a.zs=0;a.En=Bg;a.zj=null;a.D5=null;a.FX=Bg;a.DR=null;}
let YB=(a,b,c,d,e)=>{L(a);a.zj=b;a.D5=c;a.FX=d;a.DR=e;},
APY=(a,b,c,d)=>{let e=new AAx();YB(e,a,b,c,d);return e;};
function ACO(){let a=this;A.call(a);a.Hy=0;a.Aq=0;a.GW=null;a.Ci=null;}
let Vn=a=>{L(a);a.Hy=0;a.Aq=1;a.GW=A1j(a);a.Ci=D(37);},
A5T=()=>{let a=new ACO();Vn(a);return a;},
AEy=b=>{if("clipboard" in navigator){navigator.clipboard.writeText(b);}};
let Bhj=B(CI);
let A03=B(B0);
function VC(){let a=this;A.call(a);a.AZ=null;a.HK=0;a.xX=0;a.xy=0;}
let ABn=(a,b,c)=>{L(a);a.xy=1;a.AZ=b;a.HK=c;},
Iu=(a,b)=>{let c=new VC();ABn(c,a,b);return c;},
A05=a=>{if(!a.xy)I(DF(D(504)));return a.xX>=a.AZ.v2?0:1;},
AQW=a=>{let b,c;if(a.xX>=a.AZ.v2)I(AJY(IP(a.xX)));if(!a.xy)I(DF(D(504)));b=a.AZ.wn.data;c=a.xX;a.xX=c+1|0;return b[c];};
let AOn=B();
let AC4=B(W);
let AAP=a=>{Bn(a);},
AT0=()=>{let a=new AC4();AAP(a);return a;},
A_u=a=>{return A8K(a);};
let ADS=B(W);
let ABh=a=>{Bn(a);},
APj=()=>{let a=new ADS();ABh(a);return a;},
AJi=a=>{return ARJ(a);};
let A6H=B();
let AS4=B(CG);
let AL0=B(Eb);
function IS(){BD.call(this);this.yD=0;}
let AB7=(a,b)=>{Cu(a);a.yD=b;},
X6=a=>{let b=new IS();AB7(b,a);return b;},
APN=(a,b)=>{a.vN=b;},
AJ3=(a,b,c,d)=>{let e,f,g,h,i;e=d.bq();f=b+1|0;g=CA(f,e);if(g>0){d.wZ=1;return (-1);}h=c.bc(b);if(g<0){i=c.bc(f);if(CU(i))return (-1);}if(a.yD!=h)return (-1);return a.vN.br(f,c,d);},
A9b=(a,b,c,d)=>{let e,f,g;if(!(c instanceof BG))return FY(a,b,c,d);e=c;f=d.bq();while(true){if(b>=f)return (-1);g=e.e3(a.yD,b);if(g<0)return (-1);b=g+1|0;if(b<f&&CU(e.bc(b))){b=g+2|0;continue;}if(a.vN.br(b,c,d)>=0)break;}return g;},
Bau=(a,b,c,d,e)=>{let f,g,h,i;if(!(d instanceof BG))return F$(a,b,c,d,e);f=d;g=e.bq();a:{while(true){if(c<b)return (-1);h=f.e4(a.yD,c);if(h<0)break a;if(h<b)break a;i=h+1|0;if(i<g&&CU(f.bc(i))){c=h+(-1)|0;continue;}if(a.vN.br(i,d,e)>=0)break;c=h+(-1)|0;}return h;}return (-1);},
ASs=(a,b)=>{if(b instanceof Dr)return 0;if(b instanceof Di)return 0;if(b instanceof CP)return 0;if(b instanceof Df)return 0;if(b instanceof Iw)return 0;if(!(b instanceof IS))return 1;return b.yD!=a.yD?0:1;},
A9z=(a,b)=>{return 1;};
let Hy=B(Gy);
let AI1=null;
let AH5=()=>{AH5=N(Hy);ALY();};
let ALY=()=>{AI1=AC6(Br(Hy));};
function Sy(){let a=this;A.call(a);a.yA=null;a.zd=null;}
let ZU=a=>{L(a);a.yA=Fr(3);a.zd=Fr(4);},
BjP=()=>{let a=new Sy();ZU(a);return a;},
AM0=a=>{let b,c,d,e,f,g,h;if(AQQ(D(505),a.yA)){b=a.yA.uW(0);c=a.yA.uW(1);d=a.yA.uW(2);e=Ci();f=O();CR(K(CR(K(CR(K(f,D(506)),b),D(507)),c),D(508)),d);e.d$(S(f));}if(BiZ(D(509),a.zd)){b=a.yA.uW(0);c=a.zd.uW(1);d=a.zd.uW(2);g=a.zd.uW(3);e=Ci();h=O();CR(K(CR(K(CR(K(CR(K(h,D(506)),b),D(507)),c),D(508)),d),D(510)),g);e.d$(S(h));}},
AX$=a=>{return D(254);};
let Sm=B(E$);
let RQ=(a,b,c,d,e)=>{Ih(a,b,c,d,e);},
ATE=(a,b,c,d)=>{let e=new Sm();RQ(e,a,b,c,d);return e;};
function XB(){A.call(this);this.C6=null;}
let AHf=(a,b)=>{L(a);a.C6=b;},
BfF=a=>{let b=new XB();AHf(b,a);return b;},
Z1=b=>{return BfF(b);},
A1y=(a,b)=>{a.C6.j(b);},
BhA=(a,b)=>{a.C6.u5(b);};
function IU(){let a=this;A.call(a);a.yf=null;a.wk=0;a.DN=0;}
let Xk=a=>{Jz(a,1,16);},
AIS=()=>{let a=new IU();Xk(a);return a;},
AIo=(a,b)=>{Jz(a,1,b);},
XO=a=>{let b=new IU();AIo(b,a);return b;},
Jz=(a,b,c)=>{L(a);a.DN=b;a.yf=Bp(c);},
Bkt=(a,b)=>{let c=new IU();Jz(c,a,b);return c;},
A0U=(a,b)=>{let c,d,e;c=a.yf;d=c.data;if(a.wk==d.length)c=a.u6(BT(8,a.wk*1.75|0));d=c.data;e=a.wk;a.wk=e+1|0;d[e]=b;},
BbL=(a,b)=>{if(b<a.wk)return a.yf.data[b];I(GF((((((O()).O(D(276))).P(b)).O(D(277))).P(a.wk)).y()));},
BaG=(a,b)=>{let c,d,e;c=a.yf;d=0;e=a.wk;while(d<e){if(c.data[d]==b){a.u7(d);return 1;}d=d+1|0;}return 0;},
Bd8=(a,b)=>{let c,d,e;if(b>=a.wk)I(GF((((((O()).O(D(276))).P(b)).O(D(277))).P(a.wk)).y()));c=a.yf;d=c.data;e=d[b];a.wk=a.wk-1|0;if(!a.DN)d[b]=d[a.wk];else C5(c,b+1|0,c,b,a.wk-b|0);return e;},
AUy=a=>{a.wk=0;},
AN1=(a,b)=>{let c,d,e;c=Bp(b);d=c.data;e=a.yf;C5(e,0,c,0,B7(a.wk,d.length));a.yf=c;return c;};
let AYp=B(FA);
let A49=B();
let ZQ=B(Cc);
let Ba9=null;
let AAH=()=>{AAH=N(ZQ);Bfl();};
let Bfl=()=>{Ba9=BF();};
let BbZ=B(Eh);
let AAg=B();
let AY6=B(Cb);
let A1q=B(BC);
let ANs=B(0);
let A6G=B(Pv);
let A_7=B();
let AO$=b=>{return VF(b&(-16777217));};
let AAv=B();
let BfS=null;
let ZB=()=>{ZB=N(AAv);A1R();};
let A1R=()=>{BfS=X();};
let AZl=B();
function AAV(){Bw.call(this);this.zt=0;}
let Xc=(a,b)=>{Cd(a);a.zt=b;},
AYK=a=>{let b=new AAV();Xc(b,a);return b;},
A7t=(a,b,c,d)=>{let e;e=!d.ia()?c.bb()-b|0:d.bq()-b|0;if(e<=0){d.c7(a.zt,0);return a.vN.br(b,c,d);}if(c.bc(b)!=10)return (-1);d.c7(a.zt,1);return a.vN.br(b+1|0,c,d);},
AVK=(a,b)=>{let c;c=!b.bS(a.zt)?0:1;b.c7(a.zt,(-1));return c;};
function AEv(){A.call(this);this.Eg=null;}
let Yp=(a,b)=>{L(a);a.Eg=b;},
BhB=a=>{let b=new AEv();Yp(b,a);return b;},
AM_=a=>{A2L(a.Eg);};
let A1T=B(DA);
let ANm=B();
function Un(){Bm.call(this);this.Bo=null;}
let Qw=(a,b)=>{BR(a);a.Bo=AP1(0);},
Be2=a=>{let b=new Un();Qw(b,a);return b;},
UH=a=>{return A_a(U((a.fg())));},
AEl=(a,b)=>{let c;c=Q(Bhx(U((a.fg())),b));a.Bo.i0(c);return a.Bo;},
Ik=a=>{return AMj(U((a.fg())));},
Hb=a=>{return A1l(U((a.fg())));},
KY=a=>{return AI3(U((a.fg())));},
NZ=a=>{return A7n(U((a.fg())));},
L_=a=>{return A7v(U((a.fg())));},
Nw=a=>{return AR9(U((a.fg())));},
A_a=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.get_CmdListsCount();},
Bhx=(b,c)=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);var cmdList=nativeObject.get_CmdLists(c);return imgui.getPointer(cmdList);},
AMj=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.DisplayPos.get_x();},
A1l=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.DisplayPos.get_y();},
AI3=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.DisplaySize.get_x();},
A7n=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.DisplaySize.get_y();},
A7v=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.FramebufferScale.get_x();},
AR9=b=>{var nativeObject=imgui.wrapPointer(b,imgui.ImDrawData);return nativeObject.FramebufferScale.get_y();};
let NO=B(Bm);
let A46=null,A45=null,A47=null,G6=null;
let CY=()=>{CY=N(NO);BjA();};
let Z0=(a,b)=>{CY();BR(a);},
LC=a=>{let b=new NO();Z0(b,a);return b;},
ACF=(b,c,d)=>{CY();return BiF(Be(b),c,d);},
Cg=(b,c)=>{CY();imgui.ImGuiInternal.prototype.DockBuilderDockWindow(Be(b),c);},
Bic=b=>{let c;CY();c=Q(AMV(b));if(BS(c,Bg))return null;if(G6===null)G6=JS(1);G6.i0(c);return G6;},
Bc6=(b,c)=>{CY();return AVN(b,c);},
A8E=b=>{CY();imgui.ImGuiInternal.prototype.DockBuilderRemoveNode(b);},
BeP=(b,c)=>{let d;CY();d=c===null?0:U((c.fg()));imgui.ImGuiInternal.prototype.DockBuilderSetNodeSize(b,d);},
C3=(b,c,d,e,f)=>{let g,h;CY();g=e===null?0:U((e.i2()));h=f===null?0:U((f.i2()));return AQw(b,c,d,g,h);},
Bi4=b=>{CY();imgui.ImGuiInternal.prototype.DockBuilderFinish(b);},
BjA=()=>{A46=LC(1);A45=LC(1);A47=LC(1);},
BiF=(b,c,d)=>{var returnedJSObj=imgui.ImGuiInternal.prototype.ImHashStr_1(b,c,d);return returnedJSObj;},
AMV=b=>{var returnedJSObj=imgui.ImGuiInternal.prototype.DockBuilderGetNode(b);if(!returnedJSObj.hasOwnProperty('ptr'))return 0;return imgui.getPointer(returnedJSObj);},
AVN=(b,c)=>{var returnedJSObj=imgui.ImGuiInternal.prototype.DockBuilderAddNode(b,c);return returnedJSObj;},
AQw=(b,c,d,e,f)=>{var returnedJSObj=imgui.ImGuiInternal.prototype.DockBuilderSplitNode(b,c,d,e,f);return returnedJSObj;};
let BcK=B();
let AHO=B();
let D7=null;
let Pw=()=>{Pw=N(AHO);Bbr();};
let Bbr=()=>{D7=Bp((T3()).data.length);D7.data[Bl(DS)]=1;D7.data[Bl(DP)]=2;D7.data[Bl(DJ)]=3;D7.data[Bl(Dz)]=4;D7.data[Bl(GQ)]=5;};
let A2S=B(BC);
let Vx=B(W);
let AHK=a=>{Bn(a);},
ANV=()=>{let a=new Vx();AHK(a);return a;},
Bf6=a=>{return ((Cy()).G(65279,65279)).G(65520,65533);};
let AX3=B();
let AGG=B();
Bkv([-1,"com",0,"badlogic",1,"gdx",2,"utils",3,"reflect",2,"scenes",5,"scene2d",6,"ui",2,"graphics",8,"g2d",-1,"java",10,"util",11,"regex",10,"nio",13,"charset",10,"lang",-1,"imgui",16,"idl",17,"helper"]);
BW([A,0,0,[],0,3,0,0,["d",F(EN),"bE",F(Do),"hY",F(AR$),"bi",E(A4k),"y",F(TD),"v",F(J5),"b$",F(A2w),"gK",F(JK)],W,0,A,[],1,0,0,0,["e",F(Bn),"cP",E(A_v)],Z2,0,W,[],0,0,0,0,["e",F(AEA),"D",F(ASc)],U1,0,W,[],0,0,0,0,["e",F(AHe),"D",F(A4F)],El,0,A,[],3,3,0,0,0,Rg,0,A,[El],0,0,0,0,["pn",E(Qp),"s",F(AJR)],Ep,0,A,[],0,3,0,0,0,NC,0,A,[],3,3,0,0,0,HW,0,Ep,[NC],0,3,0,AB0,0,KN,0,A,[],3,3,0,0,0,B6,0,HW,[KN],0,3,0,0,0,DC,0,B6,[],0,3,0,Wz,0,Bd,0,A,[],1,3,0,Pd,["e",F(BN)],Fx,0,Bd,[],0,3,0,0,["K",E(HP)],A0C,0,A,[],0,3,0,0,0,AO2,
0,A,[],4,3,0,0,0,Pb,0,A,[],3,3,0,0,0,D1,0,A,[Pb],0,3,0,0,0,Bs,0,A,[],3,3,0,0,0,Dg,0,A,[Bs],1,3,0,0,["e",F(PN)],Cf,0,A,[],3,3,0,0,0,F4,0,Dg,[Cf],0,3,0,B_,["K",E(U4),"tO",F(AM2),"bi",E(BhO)],AGl,0,A,[],0,3,0,0,0,Ck,0,A,[],3,3,0,0,0,D0,0,A,[],3,3,0,0,0,Gk,0,A,[],3,3,0,0,0,Ex,0,A,[Ck,D0,Gk],1,3,0,0,0,BX,0,Ex,[],1,3,0,0,0,GR,0,BX,[],1,3,0,0,0,Is,0,W,[],0,0,0,0,["e",F(Lu),"D",F(Ud)],AH3,0,A,[],4,3,0,AD2,0,DE,0,A,[],3,3,0,0,0,BC,0,A,[DE],1,3,0,0,0,DA,0,BC,[],1,3,0,0,0,AZe,0,DA,[],0,3,0,0,0,Hd,0,W,[],0,0,0,0,["e",F(LQ),
"D",F(Z5)],AFH,0,Hd,[],0,0,0,0,["e",F(XE),"D",F(A5E)],Dc,0,A,[],3,3,0,0,0,Sd,0,A,[Dc],0,3,0,Jp,0,BE,0,A,[],3,3,0,0,0,Db,0,A,[BE],3,3,0,0,0,LH,0,A,[Db],0,0,0,0,["g2",R(ACy),"bn",E(AW5),"vj",E(AUr)],Bz,0,A,[Cf,Bs],1,3,0,0,["bo",G(Ce),"hd",F(Bl),"y",F(AXL)],Hi,0,Bz,[],12,3,0,D3,0,Bw,0,A,[],1,0,0,FU,["e",F(Cd),"bu",E(M2),"ev",J(FY),"dt",R(F$),"bv",E(AQ$),"eu",F(APr),"et",F(Bbh),"bX",E(Po),"b1",E(Bd4),"bs",F(Bha),"bt",F(QP)],BM,0,Bw,[],1,0,0,0,["bu",E(RN),"e",F(CO),"br",J(BiP),"bw",F(Bcp),"ca",E(A0A)],RP,0,BM,[],
0,0,0,0,["rF",E(W_),"bx",G(Bav)],JG,0,A,[],3,3,0,0,0,B4,0,A,[],0,3,0,0,["bz",F(AVe),"bA",F(A_Y),"bF",F(AW3),"vk",F(Bab),"lF",F(AYm),"bB",E(BiB)],C7,0,B4,[],0,3,0,0,["U",G(Oj),"c",E(LI),"bI",E(N8)]]);
BW([Fz,0,C7,[],0,3,0,0,["c",E(Kb)],WY,0,A,[],0,3,0,HJ,0,AAD,0,A,[],0,3,0,0,0,AGI,0,Bd,[],0,3,0,0,["N",E(ZT)],MG,0,W,[],0,0,0,0,["cT",G(Uk),"cU",J(AHq),"D",F(AVC)],Fm,0,Bd,[],0,3,0,0,["L",G(IT)],AW2,0,A,[DE],0,3,0,0,0,Cj,0,Bw,[],0,0,0,Ez,["K",E(Ed),"br",J(ANu),"bR",F(A4q),"ca",E(AOO)],LP,0,Cj,[],0,0,0,0,["K",E(Ps),"br",J(APi)],I6,0,A,[],3,3,0,0,0,A7O,0,A,[I6],0,3,0,0,0,BD,0,Bw,[],0,0,0,0,["e",F(Cu),"c6",G(NY),"br",J(AXm),"bX",E(A8y),"b1",E(A23),"ca",E(A$r),"bt",F(AQu)],Q2,0,BD,[],0,0,0,0,["m8",E(AGf),"bX",E(AU9),
"br",J(AYV)],AH8,0,A,[],3,3,0,0,0,ABp,0,A,[AH8],3,3,0,0,0,ADi,0,A,[],3,3,0,0,0,Ge,0,A,[ABp,ADi],1,3,0,0,["e",F(JU)],P2,0,Ge,[],0,3,0,0,["e",F(ZI),"K",E(KV)],AIJ,0,A,[Bs],0,3,0,UI,0,Vc,0,A,[],3,3,0,0,0,A6b,0,A,[],0,3,0,0,0,B8,0,B4,[],0,3,0,0,["e",F(Ff),"U",G(KG),"c",E(J$)],Bi,"RuntimeException",15,B8,[],0,3,0,0,["e",F(B9),"c",E(Dw)],A0M,"ClassCastException",15,Bi,[],0,3,0,0,0,Kn,0,A,[],3,3,0,0,0,I7,0,A,[Kn],0,3,0,0,["e",F(LY),"it",E(ALe)],Yd,0,A,[],3,3,0,0,0,E2,0,I7,[Yd],0,3,0,0,["eO",function(b,c,d,e,f,g){Or(this,
b,c,d,e,f,g);},"eS",F(A8P),"eU",F(AXO)],Dp,0,Bw,[],1,0,0,0,["b_",J(FL),"es",F(Bja),"b1",E(Ban),"ca",E(BeM),"bt",F(A4O)],CB,0,Dp,[],0,0,0,0,["b_",J(Es),"br",J(AKW)],Va,0,CB,[],0,0,0,0,["b_",J(Za),"br",J(A5o)],Ec,0,A,[Bs,JG],0,0,0,0,["e",F(Hn),"K",E(Ha),"sb",E(X0),"sc",E(ACt),"cc",G(AEz),"sd",E(SV),"X",G(AMD),"cf",J(AZC),"se",E(AGY),"ci",G(ZP),"cj",J(A4G),"sf",E(AE0),"cn",G(ABu),"sg",E(V1),"cr",G(U2),"cA",E(MO),"cu",G(PT),"cb",G(VN),"sh",E(ADY),"cv",G(Qt),"ce",E(K0),"y",F(NB),"bb",F(Mt),"bc",E(Ru),"cz",J(PL),
"cy",R(Kk),"cB",E(N6),"sj",E(AGk),"si",G(AGX)],H2,0,A,[],3,3,0,0,0,SX,0,Ec,[H2],0,3,0,0,["e",F(Xj),"rD",E(Bce),"cD",J(BhF),"rE",E(ATM),"cC",R(A4K),"cE",G(Bfx),"cy",R(AVx),"cz",J(AOI),"bc",E(AJX),"bb",F(BiV),"y",F(APd),"ce",E(APQ),"cu",G(Bch)],Wf,0,A,[],0,3,0,ABG,0,CZ,0,A,[],1,3,0,0,["K",E(Fj),"hK",F(DL),"hJ",F(BY),"dX",E(ER),"f5",F(BI),"g7",E(HR),"dW",F(FP),"gF",F(GT),"gy",F(Bk),"ld",F(GL)],BeL,0,A,[],0,3,0,0,0,N3,0,B6,[],0,3,0,0,0,GA,0,A,[],1,0,0,0,["e",F(J3)],T,0,GA,[],1,0,0,EJ,["e",F(Bh),"cM",F(AOC),"cI",
F(AMH),"r1",F(A4m),"r2",F(AXZ),"b4",F(Bb6),"r3",F(ANg),"r5",F(AOT),"jF",F(Bg1),"E",E(BdZ),"cL",F(AVp)],AAt,0,T,[],0,0,0,0,["rb",E(Y5),"b6",E(Bhp)],Dt,0,A,[D0],0,3,0,0,0,Gh,0,Dt,[Gk,D0],1,3,0,0,0,CG,0,Gh,[],1,3,0,WR,0,Pn,0,A,[],4,0,0,Ji,["e",F(AFM),"cO",E(AGO)],ABT,0,A,[],3,3,0,0,0,KK,0,A,[Bs],0,3,0,Qj,["e",F(U3),"c2",G(A7T),"cX",F(A93),"cV",F(BbV)],Fi,0,BX,[],1,3,0,AEs,0,Dh,0,Fi,[],1,3,0,0,0,AU0,0,Dh,[],0,3,0,0,0]);
BW([HD,0,W,[],0,0,0,0,["e",F(O9),"D",F(AAw)],AAk,0,W,[],0,0,0,0,["e",F(T0),"D",F(AWS)],AFn,0,A,[],4,3,0,Ws,0,Ct,0,A,[],0,3,0,0,0,ATo,0,Ct,[],0,3,0,0,0,ADy,0,Bd,[],0,0,0,0,["e",F(AAi)],AWj,0,A,[],4,3,0,0,0,ADp,0,Bd,[],0,0,0,0,["e",F(Y6)],Dq,0,Ex,[],1,3,0,0,0,AUl,0,Dq,[],0,3,0,0,0,Cx,0,A,[El],1,3,0,0,0,AZ8,0,Cx,[],0,0,0,0,0,ADq,0,Bd,[],0,0,0,0,["e",F(AES)],AHZ,0,Cj,[],0,0,0,0,["e",F(Qs),"br",J(AQ5)],E8,0,Bd,[],0,3,0,0,["K",E(IA)],ADt,0,Bd,[],0,0,0,0,["e",F(ZA)],ADo,0,Bd,[],0,0,0,0,["e",F(AEu)],MS,0,Ct,[],0,3,
0,0,0,AS$,0,MS,[],0,3,0,0,0,ADr,0,Bd,[],0,0,0,0,["e",F(AII)],ADu,0,Bd,[],0,0,0,0,["e",F(Q0)],ADs,0,Bd,[],0,0,0,0,["e",F(Tm)],ADv,0,Bd,[],0,0,0,0,["e",F(QZ)],JM,0,BD,[],0,0,0,0,["c6",G(KH),"br",J(A7U),"ca",E(A_m)],C_,0,JM,[],0,0,0,0,["c6",G(EW),"br",J(ASz),"bX",E(A$C)],QR,0,C_,[],0,0,0,0,["c6",G(WO),"br",J(A8f),"ca",E(Bee)],AFz,0,C_,[],0,0,0,0,["c6",G(VV),"br",J(AOv),"ca",E(BcO)],Bq,0,A,[],1,3,0,J8,["e",F(CH)],Bit,0,Bq,[],0,0,0,0,0,EA,0,Dh,[],1,3,0,0,0,AVh,0,EA,[],0,3,0,0,0,HN,"UnsupportedOperationException",
15,Bi,[],0,3,0,0,["e",F(Nj)],AId,"ReadOnlyBufferException",13,HN,[],0,3,0,0,["e",F(Yu)],AEO,0,A,[BE],3,3,0,0,0,Nh,0,A,[AEO],0,0,0,0,["c$",F(Bhl),"da",F(AWc),"c_",F(AVG),"vl",F(AKX),"vm",F(ARB),"vn",F(AJ_)],Fd,0,A,[],3,3,0,0,0,Bo,0,A,[Fd],0,3,0,R2,0,CI,0,Bo,[],0,3,0,T7,0,Ky,0,CI,[],0,3,0,0,0,A55,0,A,[],4,3,0,0,0,L3,0,Dt,[],0,3,0,0,0,AAr,0,A,[],3,3,0,0,0,AEd,0,A,[AAr],0,3,0,0,["n$",E(AD6)],Cc,0,Ep,[KN],0,3,0,0,0,AM3,0,Cc,[],0,3,0,0,0,Fn,0,Fz,[],0,3,0,0,["c",E(HZ)],ACe,0,Fn,[],0,3,0,0,["c",E(TK)],H_,0,A,[Pb],3,
3,0,0,0,Sr,0,W,[],0,0,0,0,["e",F(TM),"D",F(AS_)],A1C,0,Ky,[],0,3,0,0,0]);
BW([AL3,0,Bo,[],0,0,0,0,0,AL1,0,Bo,[],0,0,0,0,0,AC9,0,B6,[],0,3,0,QI,0,ARk,0,A,[],4,0,0,0,0,Ra,0,T,[],0,0,0,0,["iH",E(AD4),"b6",E(ASa)],JL,0,A,[],0,3,0,0,0,R7,0,JL,[],0,3,0,0,0,AL4,0,DC,[],0,0,0,0,0,Eb,0,BX,[],1,3,0,0,0,APA,0,A,[],4,3,0,0,0,EK,0,A,[],3,3,0,0,0,AA6,0,A,[EK],0,3,0,0,["m",R(Wm),"s",F(AZJ)],BbB,0,Bo,[],0,0,0,0,0,MP,0,A,[Fd],1,3,0,0,0,BbA,0,MP,[],0,0,0,0,0,OP,0,A,[Fd],1,3,0,0,0,BbE,0,OP,[],0,0,0,0,0,I8,0,Is,[],0,0,0,0,["e",F(MI),"D",F(Wj)],JT,0,I8,[],0,0,0,0,["e",F(Oo),"D",F(QD)],Yt,0,JT,[],0,0,
0,0,["e",F(AFf),"D",F(A4S)],AEc,0,W,[],0,0,0,0,["e",F(ABA),"D",F(BdY)],BbD,0,Bo,[],0,0,0,0,0,XL,0,C_,[],0,0,0,0,["c6",G(AFA),"br",J(AQh),"ca",E(BjY)],A7P,0,BX,[],0,3,0,0,0,AGt,"ArrayStoreException",15,Bi,[],0,3,0,0,["e",F(VZ)],AF6,0,A,[Bs],0,3,0,AF$,0,CC,0,A,[BE],1,3,0,0,0,ARg,0,CC,[],1,3,0,0,0,A0Q,0,CG,[],4,3,0,0,0,BeD,0,A,[D0],0,3,0,0,0,Ph,0,A,[],3,3,0,0,0,OC,0,A,[Ph],0,0,0,0,["uC",function(b,c,d,e,f,g){NI(this,b,c,d,e,f,g);},"c7",G(BeS),"bS",E(A3d),"dz",F(AJF),"dw",E(A2e),"bU",G(ARy),"bQ",G(AOf),"bT",E(A9_),
"bP",E(A$A),"ix",E(AM7),"kL",E(A1u),"rk",F(A$e),"dy",E(AQM),"ux",F(A31),"q2",E(AKH),"q3",G(AQq),"kS",F(BfG),"uw",F(BfK),"dv",J(BhN),"sW",F(ASb),"uy",E(A_X),"b5",F(APq),"bq",F(A3X),"oH",E(ATj),"kR",F(AWk),"uE",E(AVc),"ia",F(AYe),"ds",F(AKB),"m5",F(AMQ)],AO0,0,A,[Fd],0,0,0,0,0,E1,0,A,[],0,3,0,0,0,A98,0,Ct,[],0,3,0,0,0,ABS,0,A,[Dc],0,3,0,GS,0,QO,0,T,[],0,0,0,0,["d5",E(Y7),"b6",E(BiA)],JR,0,A,[Ck],1,3,0,AEK,0,AEF,0,JR,[],0,3,0,Tb,0,EU,"GdxRuntimeException",3,Bi,[],0,3,0,0,["c",E(EO)],A6V,0,B6,[],0,3,0,0,0,Ku,0,
A,[Cf],1,3,0,0,["h$",G(T9),"dI",E(AAR)],D_,0,BD,[],0,0,0,0,["pp",G(Hk),"bX",E(Bhe),"br",J(A7R),"dJ",J(AZ5),"b1",E(A1E),"ca",E(A$L)],Ca,"IllegalArgumentException",15,Bi,[],0,3,0,0,["e",F(FO),"c",E(Dy)],AEn,"IllegalCharsetNameException",14,Ca,[],0,3,0,0,["c",E(AFJ)],Ju,0,Bo,[],0,3,0,AEN,0,A3$,0,A,[],0,3,0,0,0,He,0,Ge,[],0,3,0,0,["dS",E(Ki)],F9,0,He,[],0,3,0,0,["dT",G(Pp),"dS",E(Ob)],ABI,0,C_,[],0,0,0,0,["c6",G(RD),"br",J(AJ2),"ca",E(A_I)]]);
BW([FQ,0,CZ,[Cf],1,3,0,0,["dZ",J(ACx),"dY",F(Dv),"mA",E(AJG),"dW",F(A52)],Gd,0,FQ,[],1,0,0,0,["dZ",J(Lp),"nd",F(Bdl),"ml",E(A5H),"l8",E(A37),"p$",G(BdO),"d1",F(A29)],E3,0,A,[],3,3,0,0,0,GE,0,Gd,[E3],1,0,0,0,["d4",function(b,c,d,e,f,g){Ke(this,b,c,d,e,f,g);},"d3",F(A2F)],SE,0,GE,[],0,0,0,0,["d4",function(b,c,d,e,f,g){Vy(this,b,c,d,e,f,g);},"d0",E(AV9),"d2",G(AJo)],Md,0,A,[Db],0,0,0,0,["n$",E(S2),"bn",E(A5b),"vj",E(A0t)],Me,0,A,[Db],0,0,0,0,["n$",E(AIg),"bn",E(BjT),"vj",E(Bho)],AEj,0,W,[],0,0,0,0,["e",F(XC),"D",
F(A2f)],Mc,0,A,[Db],0,0,0,0,["n_",J(Xf),"bn",E(A4$),"vj",E(A9i)],Cn,0,A,[],0,3,0,0,["e",F(DT),"em",E(A4z),"bj",E(AX6)],Wp,0,Cn,[],0,0,0,0,["ob",J(TT),"em",E(Bcc),"bj",E(ATD),"eh",G(AMt),"bl",G(A59)],Wq,0,Cn,[],0,0,0,0,["oe",G(AAA),"em",E(Bgn),"bj",E(A3h),"bl",G(AUh)],EB,0,A,[],0,3,0,EH,["e",F(AIn),"K",E(AGd),"J",R(ACC),"ej",F(BaL),"el",F(Beq)],Wo,0,Cn,[],0,0,0,0,["og",R(Ym),"em",E(ANL),"bj",E(AJ4),"bl",G(A38)],Eh,0,A,[],1,3,0,0,0,Bdx,0,Eh,[],0,3,0,0,0,DY,0,A,[],4,3,0,0,["iK",J(ABm),"eo",R(P0),"fm",function(b,
c,d,e,f){U_(this,b,c,d,e,f);},"ep",function(b,c,d,e,f,g){Ja(this,b,c,d,e,f,g);},"sx",F(VD)],F1,0,Bo,[],0,3,0,0,0,Cv,0,Dp,[],0,0,0,0,["er",J(Em),"br",J(AJ5)],AF4,0,Cv,[],0,0,0,0,["rO",E(Yk),"br",J(Bis),"ev",J(A54)],QJ,0,A,[],3,3,0,0,0,Jv,0,A,[Kn,QJ],0,3,0,0,["dc",F(AN6),"uo",E(ATa),"T",F(A11),"eC",F(AQy),"eL",F(AXo),"eA",F(Bgq),"eB",F(A4c),"eQ",F(Bjn),"Q",F(BgL),"W",E(Ba8),"S",E(Ba1),"eD",F(AUU)],A1k,0,CC,[],1,3,0,0,0,Du,0,A,[],3,3,0,0,0,PC,0,A,[Du,Bs],0,3,0,0,["e",F(TI),"K",E(Rd),"jr",E(A$l),"bN",G(AYn),"jq",
E(Bj1),"jE",G(ALr),"jH",E(ALE),"cG",E(Bid),"cH",E(A9q),"cN",E(A8n),"jy",E(Bf9),"jx",E(BiT),"jz",E(BfI),"jA",E(A2l),"cd",F(Bgu)],PR,0,Dg,[Cf],0,3,0,F2,["N",E(Sh)],ACU,0,A,[Dc],0,3,0,Ne,0,Dr,0,BM,[],0,0,0,0,["rH",E(ADf),"bw",F(A01),"bx",G(AXV),"ev",J(ATX),"dt",R(A1g),"e5",F(AOx),"b1",E(Bdo)],K7,0,BX,[],1,3,0,0,0,Cb,0,A,[],1,3,0,0,["e",F(O4),"cS",G(Qk)],APv,0,Cb,[],0,0,0,0,0,XS,0,A,[BE],3,3,0,0,0,IO,0,A,[Ck],3,3,0,0,0,ANP,0,A,[],4,3,0,0,0,La,0,A,[],0,3,0,GM,["e",F(TC),"rf",E(BeU),"e8",J(AOs)],B0,0,BC,[],1,3,0,
0,0,ASy,0,B0,[],0,3,0,0,0,MM,0,W,[],0,0,0,0,["cT",G(Vm),"cU",J(QC),"D",F(AJj)],Bm,0,A,[],1,3,0,Gx,["e",F(BR),"fe",G(Bb$),"i0",E(BgC),"fg",F(ANv),"fa",F(Bhb),"fh",F(AJr),"y",F(A1h)],Hp,0,Bm,[],0,3,0,0,["K",E(O7),"fi",E(AXi)],KU,"IDLDouble",18,Hp,[],0,3,[0,0,0],IC,["e",F(AHL),"fk",F(ARw),"y",F(AZr)],ACZ,0,A,[],0,3,0,Qo,0,AGL,0,A,[],0,3,0,0,["e",F(AE8),"cX",F(A8W),"fQ",function(b,c,d,e,f){AZm(this,b,c,d,e,f);},"jT",E(A4p),"fS",G(A0v),"gh",F(A7w)],EX,0,A,[],3,3,0,0,0,I_,0,Cc,[EX],0,3,0,W6,0,ASW,0,I_,[],0,3,0,0,
0,Z3,0,A,[],3,3,0,0,0,NA,0,CZ,[Cf,H2,JG,Z3],1,3,0,0,["dZ",J(AAC),"gA",J(AME),"hM",E(A$F),"ly",J(Bjr),"gC",J(ANR),"lf",E(HH),"hI",F(Tz),"hL",F(Om),"lr",F(AA5),"lt",E(A3s)],LN,0,NA,[],1,0,0,0,["dZ",J(Uu),"d1",F(Bh6)],MB,0,LN,[],0,0,0,0,["K",E(ACY),"gw",function(b,c,d,e,f,g){Qc(this,b,c,d,e,f,g);},"gz",E(A7r),"gB",G(A3k),"gD",F(A7i),"gE",F(AWb),"d3",F(Bhv)]]);
BW([AE2,0,A,[],0,3,0,0,0,AB9,0,T,[],0,0,0,0,["m2",E(QL),"b6",E(Bef)],Dn,0,A,[El],0,3,0,C1,["e",F(JO),"c",E(S_),"gH",G(Jd),"hj",F(AK5),"gL",F(AYi)],Rl,0,Dn,[],0,0,0,0,["hi",R(AHz),"s",F(A8r)],FF,0,A,[BE],3,3,0,0,0,Kf,0,A,[FF],0,0,0,0,["hk",function(b,c,d,e,f){AFw(this,b,c,d,e,f);},"bn",E(BhG),"vj",E(A0w)],Rm,0,Cn,[],0,0,0,0,["hl",G(AGn),"em",E(AP3),"bj",E(A5f),"gX",G(Bg2),"bl",G(ANj)],Rn,0,Dn,[],0,0,0,0,["hi",R(XU),"s",F(APX)],W$,0,T,[],0,0,0,0,["u1",E(Wh),"b6",E(A_E)],Ro,0,Cn,[],0,0,0,0,["hn",R(AHP),"em",E(AWx),
"bj",E(AK_),"gX",G(ALf),"bl",G(AXy)],Kh,0,A,[FF],0,0,0,0,["hl",G(XY),"bn",E(AQz),"vj",E(A69)],DV,0,CZ,[Cf],1,3,0,0,["dZ",J(ADd),"im",J(A5V),"g9",F(Nf),"g8",F(Hm),"g$",E(AW4),"g_",E(A6z),"gF",F(AXE),"dW",F(Bjg),"g7",E(A87),"dX",E(BgO)],F3,0,DV,[],1,0,0,0,["dZ",J(M_),"l2",E(A0L),"d1",F(ASm)],F8,0,F3,[E3],1,0,0,0,["d4",function(b,c,d,e,f,g){PD(this,b,c,d,e,f,g);},"d3",F(A8g),"hb",F(A$G)],Ql,0,A,[],3,3,0,0,0,Sv,0,A,[Ql],0,3,0,0,["pF",E(AEZ),"ee",F(AJZ),"sH",F(A6$),"sV",F(AZ$),"bm",F(Bdp),"g0",F(A4l),"of",function(b,
c,d,e,f){AQK(this,b,c,d,e,f);},"hh",J(ALL),"gT",J(Bji),"hg",J(AXw),"hf",J(ARi),"he",R(A5s),"hm",function(b,c,d,e,f){AJk(this,b,c,d,e,f);}],Rp,0,A,[],32,0,0,OV,0,A5$,0,BC,[],0,3,0,0,0,F0,0,BX,[],1,3,0,0,0,A$z,0,F0,[],0,3,0,0,0,Ys,0,Fx,[],0,3,0,0,["K",E(Zs)],CL,0,A,[],3,3,0,0,0,Fb,0,A,[CL],0,3,0,0,["e",F(Tp),"K",E(PK),"e7",G(Hw),"eg",E(A_J),"sZ",E(AYy),"hq",J(AO7),"bW",E(Bf3),"nb",F(AUt),"hp",E(AS3),"hv",F(AZN),"H",F(ALA),"hw",E(AOW)],No,0,Cj,[],0,0,0,0,["K",E(PY),"br",J(AL2),"c8",F(APx),"ca",E(A8G)],Kx,0,A,[Ck],
3,3,0,0,0,Iw,0,BD,[],0,0,0,0,["rH",E(TE),"bX",E(A8e),"br",J(AQT),"ev",J(AX_),"dt",R(ASP),"b1",E(ALq),"ca",E(BcX)],AG4,"AssertionError",15,C7,[],0,3,0,0,["U",G(U0)],ADU,0,A,[],0,0,0,AFv,0,Uw,0,A,[Ck],3,3,0,0,0,D6,0,Cv,[],0,0,0,0,["kM",R(Im),"br",J(ANx)],CP,0,BD,[],0,0,0,0,["m8",E(Og),"br",J(AT6),"b6",E(AVZ),"b1",E(AMZ),"hE",F(A1b),"bX",E(BbS),"ca",E(AUM)],Ei,0,A,[DE],0,3,0,0,0,AQ0,0,Ei,[],0,3,0,0,0,BG,0,A,[Bs,Cf,JG],0,3,0,C8,["e",F(Rc),"df",E(Kt),"q",E(WQ),"cx",J(AIP),"sz",J(SC),"bc",E(ANq),"bb",F(AWe),"cd",
F(A0Y),"hN",G(A9l),"oN",E(A1a),"e3",G(A6P),"sJ",E(AT3),"e4",G(ANG),"eF",E(AZA),"pA",G(ATg),"pB",G(ATN),"hQ",G(AK0),"eG",E(AZF),"be",G(AUn),"bh",E(AI5),"sI",G(A_h),"eb",F(A1U),"y",F(APD),"dg",F(A09),"bi",E(Be9),"hY",F(A7b),"ic",F(ARW),"d_",E(A2z)],Q6,0,A,[],0,3,0,AA2,0,ATQ,0,A,[],0,3,0,0,0,WP,0,Gd,[],0,0,0,0,["dU",function(b,c,d,e,f,g){Xn(this,b,c,d,e,f,g);},"d0",E(A64),"d2",G(A3y),"d3",F(AJq)],G1,0,Bz,[],12,3,0,IB,0,MA,0,A,[],1,3,0,0,["e",F(VE)],Nr,0,A,[],3,3,0,0,0,Ft,0,MA,[Nr,Du,Bs],0,3,0,GH,["e",F(H$),"K",
E(K9),"bL",G(A9h),"h0",F(A30)],Oq,0,Ft,[],0,3,0,0,["e",F(ACu),"ut",E(Yc)],AGa,0,F3,[],0,0,0,0,["g4",function(b,c,d,e,f,g){Ub(this,b,c,d,e,f,g);},"ha",E(A9r),"g6",G(A7o),"d3",F(A7Z)],A4h,0,A,[],1,3,0,0,0,AXk,0,A,[],0,3,0,0,0,Ds,0,B0,[],1,3,0,0,0,A7j,0,Ds,[],0,3,0,0,0,E$,0,Bd,[],0,3,0,0,["M",R(Ih)],XG,0,E$,[],0,3,0,0,["M",R(Ur)],H5,0,Bz,[],12,3,0,Pj,0]);
BW([Gi,0,A,[],3,3,0,0,0,Ss,0,A,[Gi],0,3,0,0,["e",F(ABB),"j7",F(BiU),"T",F(ATw)],P9,0,Ku,[],0,3,0,F7,["dF",F(BaJ)],DR,0,A,[BE],3,3,0,0,0,XQ,0,A,[DR],3,3,0,0,0,IV,0,A,[Fd],0,3,0,US,0,QM,0,Bw,[],0,0,0,0,["K",E(AIH),"br",J(AZE),"ca",E(AQ2)],J4,0,A,[],3,3,0,0,0,A6Y,0,DA,[],0,3,0,0,0,HA,0,D1,[H_],0,3,0,0,0,BiC,0,A,[],3,3,0,0,0,A2W,0,A,[],0,3,0,0,0,AL8,0,Ct,[],0,3,0,0,0,Up,0,A,[],0,0,0,0,["e",F(AID)],T$,0,A,[IO],0,3,0,0,["lR",J(AAX),"tb",J(AOr),"te",G(A5_),"ti",G(AUQ)],A4U,0,A,[],0,3,0,0,0,FC,0,A,[EX,CL],0,3,0,0,0,BbY,
0,A,[],0,3,0,0,0,Uj,0,Cb,[],0,3,0,0,["bK",J(AHt)],AFe,0,A,[],0,3,0,AGw,0,XT,0,A,[],0,3,0,ABb,0,A_w,0,A,[],0,3,0,0,0,BP,0,Bz,[],9,3,0,Ht,0,AFk,0,BP,[],12,0,0,0,0,Ir,0,A,[],3,3,0,0,0,AFi,0,BP,[],12,0,0,0,0,Hj,0,A,[CL],3,3,0,0,0,Zz,0,A,[Hj],3,3,0,0,0,Q7,0,A,[Zz],3,3,0,0,0,AFp,0,BP,[],12,0,0,0,0,AFj,0,BP,[],12,0,0,0,0,XA,0,A,[Dc],0,3,0,Il,0,H4,0,Bz,[],12,3,0,OH,0,AFl,0,BP,[],12,0,0,0,["k7",F(Bf_)],AFs,0,BP,[],12,0,0,0,0,AFo,0,BP,[],12,0,0,0,0,AFm,0,BP,[],12,0,0,0,0,AFr,0,BP,[],12,0,0,0,0,WD,0,A,[],0,3,0,GY,0,LT,
0,A,[],0,3,0,0,["kZ",R(MZ)],Xe,"BufferOverflowException",13,Bi,[],0,3,0,0,["e",F(Wv)],Gs,0,A,[Hj],1,3,0,0,["e",F(Pz),"rl",E(AT$)],T_,0,A,[Hj],3,3,0,0,0,LU,0,Gs,[T_],1,3,0,0,["e",F(ADz)],FW,0,CZ,[Cf],1,3,0,0,["dZ",J(SF),"m4",J(BcN),"iD",F(PH),"iC",F(GP),"iE",E(A_k),"iF",E(Bar),"gF",F(Bc_),"dW",F(BiD),"g7",E(A33),"dX",E(ALw)],BbO,0,Dq,[],0,3,0,0,0,Rw,0,A,[Dc],0,3,0,MX,0,Wx,0,A,[Dc],0,3,0,P,0,AHF,0,W,[],0,0,0,0,["e",F(ZR),"D",F(A2r)],KB,0,A,[],0,3,0,0,["dm",J(AFd)]]);
BW([Gl,0,A,[],1,0,0,0,["e",F(Lq)],AEg,0,Gl,[],0,0,0,0,["e",F(Xh),"pE",E(Ba$),"lP",G(BgS)],AER,0,A,[],0,3,0,0,["dk",G(ADT)],AEe,0,Gl,[],0,0,0,0,["e",F(SD),"pE",E(AP4),"lP",G(A_b)],AYB,0,Fz,[],0,3,0,0,0,AIQ,0,W,[],0,0,0,0,["e",F(Xv),"D",F(A_Q)],AWg,0,A,[BE],1,3,0,0,0,Oy,0,Cc,[EX],0,3,0,0,0,AD3,0,A,[],0,3,0,0,["df",E(UU)],Di,0,BM,[],0,0,0,0,["m8",E(ADa),"bx",G(AI8),"b1",E(A8z),"hE",F(A70)],Jm,0,A,[Uw],0,3,0,GG,["e",F(AFq),"iI",G(Lj),"iR",F(AZI),"jY",E(AW0),"iT",F(AS7)],AIM,0,A,[],32,0,0,N4,0,ATe,0,CC,[],1,3,0,
0,0,AMS,0,Bm,[],0,3,0,0,0,Hu,0,T,[],0,0,0,0,["e",F(AIl),"jp",G(Lr),"rW",J(Rf),"F",E(AIZ),"rZ",E(BjL),"G",G(Bd3),"rY",E(AJL),"rX",E(BeB),"b6",E(AQP),"cM",F(BjO),"cI",F(AUu),"b4",F(BdA),"y",F(A6c),"jF",F(AVt)],AFP,"BufferUnderflowException",13,Bi,[],0,3,0,0,["e",F(AG0)],Gw,0,BX,[],1,3,0,0,0,RZ,0,F8,[],0,0,0,0,["d4",function(b,c,d,e,f,g){AA7(this,b,c,d,e,f,g);},"ha",E(A2Q),"g6",G(A$x)],A6O,0,A,[],0,3,0,0,0,AKl,0,A,[],0,3,0,0,0,Pe,0,Cc,[NC],0,3,0,0,0,Bfm,0,Pe,[],0,0,0,0,0,Bfj,0,Bo,[],0,0,0,0,0,I2,0,B8,[],0,3,0,
0,["e",F(KJ)],Ew,0,I2,[],0,3,0,0,["e",F(Hz)],AD8,"MalformedInputException",14,Ew,[],0,3,0,0,["K",E(ACc),"bA",F(AUG)],XX,0,A,[],3,3,0,0,0,Fl,0,A,[XX],0,3,0,0,["e",F(IE),"lW",G(ALN),"lS",F(AWW),"lT",F(AVs),"lU",F(AW1)],L8,0,Fl,[],1,3,0,0,["e",F(AFZ),"jW",F(AB$),"lV",E(Bi2),"lW",G(Bjq),"lT",F(AZ7),"lU",F(A6_),"lS",F(Bg3)],Oh,0,L8,[],0,3,0,Mu,["e",F(ABq),"jW",F(AJS),"jQ",F(A8C)],AEG,"CloneNotSupportedException",15,B8,[],0,3,0,0,["e",F(X7)],GJ,0,FW,[],1,0,0,0,["dZ",J(Oi),"l5",E(A$O),"d1",F(A1M)],FN,0,GJ,[E3],1,0,
0,0,["d4",function(b,c,d,e,f,g){Ol(this,b,c,d,e,f,g);},"d3",F(AYh),"hb",F(A_z)],ADc,0,E8,[],0,3,0,0,["K",E(TG)],TL,0,A,[],3,3,0,0,0,IH,0,A,[TL,Bs],0,3,0,0,["e",F(J_),"kD",F(ASN),"kF",F(AKr),"kC",F(AUP)],ABo,0,IH,[],0,3,0,0,["e",F(Xs),"kE",E(AYk),"kH",G(A_R)],Lo,0,A,[BE],3,3,0,0,0,Wn,0,A,[Lo],1,3,0,0,["vo",E(BiS),"vp",F(AQb)],BjU,0,B6,[],0,3,0,0,0,VH,0,HD,[],0,0,0,0,["e",F(Zr),"D",F(AXG)],WU,0,A,[Ck],0,3,0,0,0,A0$,0,A,[],0,3,0,0,0,Fo,0,BD,[],0,0,0,0,["cS",G(Hv),"br",J(AMB),"bX",E(A$y),"kK",E(ARC),"ca",E(A_o)],AF0,
0,T,[],0,0,0,0,["cJ",G(AIt),"b6",E(AUo)],AFS,0,T,[],0,0,0,0,["cK",J(ABV),"b6",E(AKS)],Ue,0,D6,[],0,0,0,0,["kM",R(AA$),"br",J(Bat)],Ey,0,DC,[EX],0,3,0,0,0,ABK,0,A,[DR],3,3,0,0,0,AEm,0,A,[],3,3,0,0,0]);
BW([AC1,0,A,[AEm],3,3,0,0,0,V4,0,A,[AC1],0,3,0,0,["e",F(SN)],AKj,0,Cb,[],0,0,0,0,0,AO8,0,A,[],0,3,0,0,0,RR,0,Bm,[],0,3,0,0,["uh",F(AKU),"iZ",E(Yl)],AHD,0,A,[],3,3,0,0,0,ABd,0,A,[AHD],0,3,0,0,["e",F(AFt)],AXY,0,A,[],4,3,0,0,0,QK,0,BM,[],0,0,0,0,["rF",E(AF8),"bx",G(A3R)],AGB,0,T,[],0,0,0,0,["rd",E(Qr),"b6",E(A0j)],A6n,0,CC,[],1,3,0,0,0,Bfg,0,Bo,[],0,0,0,0,0,Bfk,0,CI,[],0,0,0,0,0,Wk,0,BD,[],0,0,0,0,["r4",G(AHN),"br",J(ANk),"bX",E(A7Q),"ca",E(APz),"b1",E(AOz)],Qy,0,A,[],3,3,0,0,0,EZ,0,A,[Qy,Du],0,0,0,0,["hV",G(JQ)],LG,
0,EZ,[],0,0,0,0,["hV",G(AC5),"h2",F(AOc),"hZ",G(Bea)],BfH,0,B0,[],0,3,0,0,0,E9,0,Cj,[],0,0,0,0,["e",F(AF9),"br",J(Be0)],Ot,0,Ex,[D0],1,3,0,0,0,AJl,0,Ot,[D0],0,3,0,0,0,AFh,0,BM,[],0,0,0,0,["bu",E(AAW),"bx",G(BaU),"ev",J(AU8),"dt",R(AQH),"ca",E(ALM)],Mn,0,Ey,[],0,3,0,0,0,ASr,0,Mn,[],0,3,0,0,0,VY,0,A,[BE],3,3,0,0,0,O_,0,A,[VY],0,0,0,0,["e$",J(X1),"kU",E(A5N),"vj",E(AVU)],Xr,0,F8,[],0,0,0,0,["d4",function(b,c,d,e,f,g){Rz(this,b,c,d,e,f,g);},"ha",E(AJM),"g6",G(A2s)],ACD,0,A,[],3,3,0,0,0,KS,0,A,[ACD],0,3,0,IZ,["sL",
E(AAl),"cX",F(ARP),"sQ",F(A89),"sR",F(AM1),"fM",F(BgA),"fN",F(Bj4),"fO",F(ART),"fP",F(A7y),"fL",F(Bdr),"k1",G(AKp),"k4",F(BbN)],WE,0,Fn,[],0,3,0,0,["c",E(Ua)],AOX,0,A,[],0,3,0,0,0,Jg,0,A,[],3,3,0,0,0,R5,0,A,[Jg],0,0,0,0,["nL",E(ACS),"bZ",F(A5O),"b0",F(BdI)],ARD,0,A,[Bs],0,3,0,0,0,Xx,0,A,[],32,0,0,AIR,0,ADl,0,A,[BE],3,3,0,0,0,Ix,0,DC,[],0,3,0,Qu,0,Bac,0,Ix,[],0,3,0,0,0,Py,0,A,[],1,3,0,0,["lu",J(AIh),"dG",E(AGg),"k$",E(Ber),"dH",E(ABJ),"k_",E(AX8),"lm",J(L1),"lq",E(Y8),"ll",F(AGP),"dI",E(TX),"li",E(A5F),"lj",
F(ATO)],MC,0,Py,[],1,3,0,0,["lu",J(SB),"la",G(Bd2)],ABF,0,MC,[],0,3,0,0,["h_",E(ZJ),"lx",function(b,c,d,e,f,g,h){return BgB(this,b,c,d,e,f,g,h);}],OK,0,A,[],0,3,0,0,0,AIX,0,Cv,[],0,0,0,0,["er",J(ADK),"br",J(AMq)],ADW,0,A,[],0,3,0,0,["lw",G(ABs),"lz",E(AZu),"lC",E(AOJ),"lD",E(Bec),"lE",E(A$9)],RM,0,A,[],3,3,0,0,0,ZK,0,A,[RM],0,3,0,0,["e",F(SS),"gM",G(AMK)],A2H,0,EA,[],0,3,0,0,0,Sx,0,T,[],0,0,0,0,["c3",E(AH9),"b6",E(BfW)],Rk,0,A,[],3,3,0,0,0,IL,0,A,[Rk,XS],0,3,0,H0,["e",F(Xg),"gV",F(AYv),"sT",E(Bb4),"lH",E(AVw),
"hc",F(A3a),"k2",F(ATn),"k3",F(APu),"nI",G(AQ9),"vq",E(A8F)]]);
BW([AC3,0,A,[],3,3,0,0,0,MH,0,BC,[],1,3,0,0,0,A1L,0,MH,[],0,3,0,0,0,ARa,0,A,[],0,3,0,0,0,Ox,0,Bm,[],0,3,0,Np,["iZ",E(UR),"ku",E(BgM)],Ny,0,EZ,[],0,0,0,0,["n6",G(AC7)],EV,0,A,[],3,3,0,0,0,A3B,0,Dq,[],0,3,0,0,0,Bgl,0,A,[],0,3,0,0,0,AEx,0,W,[],0,0,0,0,["e",F(YD),"D",F(Bc0)],Jf,0,A,[],4,3,0,CT,0,HI,0,Bz,[],12,3,0,L0,0,OU,0,LU,[Du,Bs],0,3,0,0,["e",F(AFL),"lN",E(Pm),"kT",E(BhC),"e9",E(BaP)],ATr,0,B6,[],0,3,0,0,0,RS,0,Bw,[],0,0,0,0,["rS",E(ADm),"br",J(AQt),"ca",E(AWJ)],AWB,0,BC,[],0,3,0,0,0,Id,0,A,[IO],0,3,0,0,["lR",
J(NJ),"tb",J(A7c),"te",G(AUO),"ti",G(ANo)],SL,0,Id,[],0,3,0,0,["s_",G(AEk)],AGT,0,A,[],3,3,0,0,0,NQ,0,A,[AGT],1,3,0,0,["e",F(Yq),"fh",F(A78),"lT",F(A4V),"lU",F(A0k),"j7",F(A0h),"lW",G(ANt),"o2",E(Bf2)],ADk,0,W,[],0,0,0,0,["e",F(W0),"D",F(A_6)],A0J,0,CI,[],0,0,0,0,0,OF,0,FC,[],0,3,0,0,0,A0F,0,OF,[],0,0,0,0,0,A4u,0,Cx,[],0,0,0,0,0,P6,0,BC,[],0,3,0,0,0,ARj,0,P6,[],0,3,0,0,0,Nc,0,A,[],3,3,0,0,0,Fy,0,A,[Nc],0,3,0,0,["kX",E(II),"md",E(BiX),"mf",E(A2P),"me",E(Bff),"mg",E(A5t),"l7",E(Bfo),"mw",E(AJz),"mJ",G(Mq),"gp",
G(PQ),"fF",G(Le),"gk",E(NW),"gl",R(Mj),"f6",R(LW),"ik",R(LV),"jP",E(O6),"jO",R(Lm),"mK",E(MF),"mL",F(P4),"mM",E(N9),"gi",E(N2),"mN",E(NH),"mG",J(Lw),"mH",R(MN),"gg",R(Ns),"gj",E(PI),"mO",E(Pf),"gv",F(OT),"fK",F(AZV),"fE",F(BgE),"mP",R(KE),"mQ",R(MV),"mR",G(LS),"mT",E(PZ),"mS",J(NF),"mV",E(M0),"mU",J(Ls),"kY",E(L7),"mW",G(L5),"fU",E(Nz),"mX",E(KQ),"fH",G(Lv),"gc",R(K4),"mY",G(JX),"fI",function(b,c,d,e,f,g,h,i,j){NS(this,b,c,d,e,f,g,h,i,j);},"fG",J(NX),"mZ",G(N1),"p8",function(b,c,d,e,f){AVO(this,b,c,d,e,f);},
"m0",E(KT),"m1",function(b,c,d,e,f,g){M7(this,b,c,d,e,f,g);},"mI",R(Ka)],AAq,0,A,[Nc],3,3,0,0,0,JN,0,Fy,[AAq],0,3,0,0,["kW",E(JY),"mB",E(WH),"mD",R(ABf),"mE",function(b,c,d,e,f){AIk(this,b,c,d,e,f);},"mF",G(ABH)],Sw,0,JN,[],0,3,0,0,["kW",E(Zv),"mB",E(AUb),"mD",R(AOS),"mE",function(b,c,d,e,f){Bgw(this,b,c,d,e,f);},"mF",G(ANf),"fF",G(AOK),"jP",E(Bcl),"jO",R(A3M),"gi",E(Bdw),"mG",J(ASU),"mH",R(A82),"gj",E(A_G),"gv",F(A72),"kY",E(AJb),"fH",G(ALi),"gc",R(A3e),"fI",function(b,c,d,e,f,g,h,i,j){A4v(this,b,c,d,e,f,g,
h,i,j);},"mI",R(AWE),"mJ",G(A2p),"gp",G(Be_),"gk",E(AJy),"gl",R(AUd),"f6",R(A32),"ik",R(BeZ),"mK",E(A6k),"mL",F(BhX),"mM",E(A9B),"mN",E(BhE),"gg",R(AN3),"mO",E(A9O),"mP",R(AY7),"mQ",R(Bcg),"mR",G(A48),"mS",J(AQA),"mT",E(ALd),"mU",J(BhU),"mV",E(AMJ),"mW",G(ALj),"fU",E(Beb),"mX",E(Bf5),"mY",G(ALa),"fG",J(ANw),"mZ",G(APt),"m0",E(Bjj),"m1",function(b,c,d,e,f,g){A$$(this,b,c,d,e,f,g);}],Xo,0,W,[],0,0,0,0,["e",F(TO),"D",F(A9X)],ZC,0,A,[Kx],0,3,0,0,["e7",G(Vo),"tg",F(A$n),"tm",F(AJN),"tc",J(AZM),"tl",E(Bc9),"gm",F(A1m),
"gh",F(APw)],S6,0,Bw,[],0,0,0,0,["e",F(AFb),"br",J(A0K),"ca",E(Bjt)],AQ3,0,A,[],0,3,0,0,0,MQ,0,Cj,[],0,0,0,0,["K",E(Nx),"br",J(ALv),"ca",E(A_9)],Bkl,0,Ey,[],0,3,0,0,0,Bgg,0,GR,[],0,3,0,0,0,A7Y,0,K7,[],0,3,0,0,0,ACQ,0,A,[],4,3,0,NV,0,QG,0,BM,[],0,0,0,0,["K",E(AE_),"bx",G(BaC)],A0W,0,CG,[],4,3,0,0,0,UD,0,W,[],0,0,0,0,["cS",G(AHo),"D",F(A2$)],D5,0,Cv,[],0,0,0,0,["er",J(Iv),"br",J(A3Z),"bX",E(Bj6)],ZY,0,Fm,[],0,3,0,0,["L",G(ABi)],AHl,0,F1,[],0,3,0,AHy,0,AA9,0,T,[],0,0,0,0,["sa",E(AEU),"b6",E(BeX)],AH2,0,A,[EK],
0,3,0,0,["q",E(XD),"s",F(Bei)],Q5,0,CP,[],0,0,0,0,["m8",E(UN),"b6",E(A0B)]]);
BW([Ty,0,A,[],3,3,0,0,0,Js,0,Bz,[],12,3,0,JB,0,AIF,0,W,[],0,0,0,0,["e",F(ABg),"D",F(AX9)],L4,0,A,[IO],0,3,0,HL,["lR",J(UJ),"tb",J(AOh),"te",G(Bcv),"ti",G(ATd)],AMu,0,B0,[],0,3,0,0,0,A65,0,B6,[],0,3,0,0,0,AGM,0,Fy,[],0,3,0,0,["kX",E(AHJ),"fF",G(Bg$),"jP",E(AQI),"jO",R(ASl),"gi",E(Biy),"mG",J(AZx),"mH",R(Bhn),"gj",E(AOd),"gv",F(AV$),"kY",E(A1S),"fH",G(A6x),"gc",R(BcY),"fI",function(b,c,d,e,f,g,h,i,j){AUH(this,b,c,d,e,f,g,h,i,j);},"mI",R(BhL),"mJ",G(AK$),"gp",G(AI9),"gk",E(AUR),"gl",R(AI4),"f6",R(A04),"ik",R(AWX),
"mK",E(BiO),"mL",F(A7g),"mM",E(Bh$),"mN",E(A7a),"gg",R(AXl),"mO",E(Biz),"mP",R(A08),"mQ",R(AOR),"mR",G(AXx),"mS",J(AUV),"mT",E(AU$),"mU",J(ALy),"mV",E(A_g),"mW",G(BcV),"fU",E(ARd),"mX",E(A26),"mY",G(Bhi),"fG",J(BcH),"mZ",G(BhV),"m0",E(ALz),"m1",function(b,c,d,e,f,g){AQe(this,b,c,d,e,f,g);}],Bif,0,CI,[],0,0,0,0,0,IG,0,Bm,[],0,3,0,0,["K",E(PF),"fz",E(AZ9),"i2",F(Bdf)],K$,"IDLInt",18,IG,[],0,3,[0,0,0],EQ,["e",F(AHR),"kq",F(Bgc),"y",F(A$P)],Big,0,FC,[],0,0,0,0,0,Go,0,Bm,[],0,3,0,EC,["e",F(AE3),"iZ",E(Wl),"ke",G(A5Y),
"L",G(Zy),"nh",E(Bae),"ni",E(BaN)],AFN,0,A,[Gi],0,3,0,0,["e",F(Sn),"j7",F(ASC),"T",F(A02)],Io,0,Bm,[],0,3,0,G4,["e",F(Yz),"iZ",E(Q9),"f$",F(BbU),"f_",F(AMm),"ga",F(A06),"gb",F(AZB)],It,0,W,[],0,0,0,0,["e",F(ME),"D",F(XN)],A9J,0,A,[D0,Gk],0,3,0,0,0,ACp,0,A,[],4,3,0,VA,0,Ug,0,A,[Ck],0,3,0,ABx,0,UK,0,A,[DR],3,3,0,0,0,X9,0,A,[DR],3,3,0,0,0,AHg,0,A,[DR],3,3,0,0,0,ADx,0,A,[DR,UK,X9,XQ,ABK,AHg],3,3,0,0,0,A88,0,A,[],0,3,0,0,0,ACR,0,A,[],3,3,0,0,0,AXn,0,A,[Bs],0,3,0,0,0,Mp,0,A,[Bs],0,3,0,Cz,["e",F(AD1),"iS",E(BjN),"nu",
E(APf),"iU",E(A4_),"nw",F(ATx),"iL",R(A4X),"nv",function(b,c,d,e,f,g){return A58(this,b,c,d,e,f,g);},"nA",J(AP7),"nz",G(AUK),"qc",J(AU7)],Qn,0,A,[],32,0,0,Z7,0,AIU,"NegativeArraySizeException",15,Bi,[],0,3,0,0,["e",F(ACL)],AXg,0,BC,[],0,3,0,0,0,Wy,0,Fx,[],0,3,0,0,["K",E(ABe)],AK6,0,Ds,[],0,3,0,0,0,XK,0,Bd,[],0,3,0,0,["N",E(SO)],K5,0,A,[CL],0,3,0,0,["hu",E(ADe),"ht",G(Qd),"hv",F(AY1)],NE,"IllegalStateException",15,Bi,[],0,3,0,0,["e",F(AE1),"c",E(ACz)],Vs,0,A,[ADl,BE],1,3,0,0,["vr",G(Bgo),"vs",E(A62),"vt",G(APO),
"vu",J(A1n),"vv",J(Bbu)],BhT,0,A,[],0,3,0,0,0,K1,0,Gs,[Q7],1,3,0,0,["e",F(X8),"bY",F(AUz)],XM,0,D6,[],0,0,0,0,["kM",R(AC0),"br",J(Ba2)],A10,0,Ct,[],0,3,0,0,0,D9,0,CZ,[Cf],1,3,0,0,["tr",function(b,c,d,e,f){R9(this,b,c,d,e,f);},"lv",J(ARR),"ts",F(Yf),"pK",E(DX),"pJ",F(K2),"nN",F(AFX),"fD",E(AT8),"fC",E(Bcn),"gF",F(APU),"g7",E(A8R),"dX",E(ALD)],XP,0,Bw,[],4,0,0,0,["e",F(UV),"br",J(A2X),"ca",E(AZ0)],Dd,0,A,[Bs,Ir],0,3,0,IY,["e",F(AAO),"nS",J(X2),"cW",J(A3i),"cY",E(ASt),"cZ",E(Bdv),"nO",J(A16),"c1",E(A5G),"nP",J(Bb2),
"c0",E(BaT),"nQ",F(AQ4),"nx",F(Bkm),"tu",E(Bd6),"ny",E(ASh),"tt",J(A4n)],Hg,0,A,[Bs,Ir],0,3,0,IX,["e",F(AAT),"L",G(AEp)],AF1,0,A,[],3,3,0,0,0,KL,0,A,[Bs,Ir],0,3,0,N$,["J",R(AAU),"nT",R(A7K)],BbP,0,BX,[],0,3,0,0,0,AEq,0,Fb,[],0,3,0,0,["K",E(Uc),"on",F(AVP),"op",F(AQB)],AWV,0,DA,[],0,3,0,0,0,TV,0,A,[],4,3,0,0,["R",E(AGu),"it",E(ADI)],ATk,0,A,[],1,3,0,0,0]);
BW([AGv,0,GJ,[],0,0,0,0,["iz",function(b,c,d,e,f,g){AIr(this,b,c,d,e,f,g);},"kB",E(AWl),"iB",G(A0G),"d3",F(AR6)],AVo,0,A,[Ck,Gk],0,3,0,0,0,XZ,0,A,[],0,3,0,OE,0,AHG,0,A,[],3,3,0,0,0,FE,0,Gh,[],1,3,0,0,0,A3o,0,FE,[],4,3,0,0,0,Rx,0,W,[],0,0,0,0,["e",F(AAz),"D",F(BgG)],Li,0,A,[Nr],1,3,0,0,["e",F(U$)],If,0,Li,[Du,Bs],0,3,0,0,["nY",E(AXu),"e",F(Vj),"K",E(J0),"nW",G(PS),"lO",E(ANH),"bJ",E(BeI),"n0",E(MT),"n2",J(L6),"n1",F(M4),"bL",G(A5X),"n7",E(AWL),"h0",F(A$3)],O1,0,A,[],0,3,0,0,["e",F(AC_),"e7",G(Pq)],BiK,0,Ju,[],
0,3,0,0,0,BaV,0,Ey,[],0,3,0,0,0,Bcy,0,Ds,[],0,3,0,0,0,Q$,0,A,[],0,3,0,0,["sM",J(Zt),"oa",F(AXU),"sN",G(A8H),"ea",E(AY0),"od",function(b,c,d,e,f){AYP(this,b,c,d,e,f);},"gT",J(ALW),"en",J(AKZ),"oc",E(AZo)],ADn,0,A,[],4,3,0,E6,0,OW,0,A,[],0,3,0,CJ,["om",G(UC),"lc",F(A5y),"lb",F(Bex),"lo",F(A17),"lg",F(AXJ),"lh",F(Be3),"bb",F(AU3),"lp",F(A__)],PG,0,Bw,[],4,0,0,0,["K",E(O8),"br",J(A99),"ca",E(AQU)],JI,0,A,[J4],0,3,0,0,["e",F(Nk),"oo",E(X_),"oq",E(Qg),"or",E(Qq),"os",R(R3),"ot",R(AEE),"ou",J(Wd),"ov",G(AGr),"ow",
G(AA8)],AGN,0,JI,[],0,3,0,0,["e",F(W5),"os",R(A6Q),"ou",J(AQi),"ot",R(AXv),"or",E(AXb),"oo",E(A5w),"oq",E(BeY),"ow",G(ASL),"ov",G(ANz)],ACa,0,A,[],0,0,0,0,["bo",G(AGp),"ru",F(A2i),"oH",E(AP_),"rz",E(APs),"rU",F(ASB),"oP",F(A9G),"rC",F(APk),"rt",F(A_y),"rP",F(AQ8),"rs",F(AM$),"ry",F(AU1),"y",F(AWm),"cd",F(AY9),"rr",F(Bhf),"rA",F(AOH),"rB",F(A_s),"c8",F(AOB)],YQ,0,It,[],0,0,0,0,["e",F(AGQ),"D",F(AN4)],ARE,0,CC,[],1,3,0,0,0,AYT,0,Dh,[],0,3,0,0,0,VB,0,FN,[],0,0,0,0,["d4",function(b,c,d,e,f,g){RT(this,b,c,d,e,f,
g);},"kB",E(A6E),"iB",G(ARu)],AB2,0,D1,[H_],0,3,0,0,0,AHw,0,A,[],3,3,0,0,0,AHX,0,A,[AHw],0,3,0,0,["e",F(AGo),"oZ",F(AN_),"lT",F(BaZ),"lU",F(A5P)],W1,0,A,[],3,3,0,0,0,I3,0,Bz,[],12,3,0,C4,0,Wu,0,NQ,[],0,3,0,0,["e",F(AGV),"sY",F(A6j)],ACM,0,A,[],0,0,0,FX,0,EP,"IDLByteArray",18,Bm,[],0,3,[0,0,0],0,["K",E(GW),"fB",E(Bgp),"i2",F(A5v),"h8",F(AQY)],E0,0,BD,[],0,0,0,0,["o9",G(Lz),"br",J(AKY),"ev",J(A3N),"dt",R(Bai),"b1",E(A2R),"bs",F(A8A),"bt",F(Bhm)],AJc,0,A,[],1,3,0,0,0,RC,0,E0,[],0,0,0,0,["o8",E(ADV),"ev",J(AVH),
"dt",R(BjC),"bs",F(AQS)],AHh,"BufferOverflowException",14,Bi,[],0,3,0,0,["e",F(ABw)],ALo,0,A,[BE],1,3,0,0,0,AP8,0,A,[],0,3,0,0,0,MY,0,A,[],0,3,0,0,["e",F(U5),"nW",G(LL),"pc",E(Bd$),"tD",E(ARS),"tH",E(Bey),"b6",E(Bkc)],Kj,"MissingResourceException",11,Bi,[],0,3,0,0,["cR",J(VW)],Bv,"IndexOutOfBoundsException",15,Bi,[],0,3,0,0,["e",F(Lb),"c",E(BB)],AHE,"StringIndexOutOfBoundsException",15,Bv,[],0,3,0,0,["e",F(AFC)],AH7,0,Bm,[],0,3,0,0,["pF",E(AEQ),"gd",F(ASV),"ge",F(ARN),"gf",F(A2k),"f9",F(BdW)],Xz,0,Fo,[],0,0,
0,0,["cS",G(Wr),"br",J(A3F)],Mw,0,A,[],4,3,0,Dj,0,N0,0,A,[Db],0,0,0,0,["d7",function(b,c,d,e,f){U9(this,b,c,d,e,f);},"bn",E(A7f),"vj",E(A35)],Yr,0,Dp,[],0,0,0,0,["b_",J(R4),"br",J(Bi3),"ev",J(Bcb)],Jy,0,Bz,[],12,3,0,Nn,0,Yn,0,CB,[],0,0,0,0,["b_",J(TN),"br",J(BhI)],Bhs,0,Gw,[],0,3,0,0,0]);
BW([Us,0,A,[],3,3,0,0,0,Ic,0,B8,[],0,3,0,0,["e",F(Pc)],ACw,"CoderMalfunctionError",14,C7,[],0,3,0,0,["bI",E(AAY)],AE4,0,A,[BE],3,3,0,0,0,Kv,0,A,[AE4],0,0,0,0,["o0",E(QN),"po",F(ANN),"vw",F(ATL)],Iz,0,Bq,[],0,3,0,Op,["N",E(AHB)],ACs,0,D_,[],0,0,0,0,["pp",G(Tl)],A1I,0,A,[BE],1,3,0,0,0,A5W,0,A,[Bs],4,3,0,0,0,KO,0,A,[FF],0,0,0,0,["gY",G(AIf),"bn",E(A3E),"vj",E(Bhg)],AA_,0,A,[Ck],0,3,0,Nu,0,Fq,0,E1,[],0,3,0,0,0,BcA,0,A,[Bs],0,3,0,0,0,Bcz,0,A,[Bs],0,3,0,0,0,A8d,0,A,[],0,3,0,0,0,ZS,0,Cb,[],0,3,0,0,["oX",G(Q1)],AND,
0,Cx,[],0,0,0,0,0,ANF,0,Cx,[],0,0,0,0,0,ABr,0,E8,[],0,3,0,0,["K",E(V5)],ARv,0,A,[],0,3,0,0,0,ACN,0,A,[],0,3,0,0,["e",F(Ta)],Ry,0,A,[BE],3,3,0,0,0,PB,0,A,[Ry],0,0,0,0,["re",E(V2),"pr",F(Bep),"vx",F(AN9)],SP,0,Cc,[],0,3,0,AEr,0,A_V,0,A,[],4,3,0,0,0,AFO,0,D5,[],0,0,0,0,["er",J(AHS),"br",J(A5j)],A_2,0,A,[],0,3,0,0,0,KZ,0,Bi,[],0,3,0,0,0,A8O,0,F0,[],0,3,0,0,0,Bj_,0,A,[],4,3,0,0,0,A0s,0,Bo,[],0,0,0,0,0,A0r,0,IV,[],0,0,0,0,0,Tr,0,Bd,[],0,3,0,0,["N",E(V3)],A0u,0,Bo,[],0,0,0,0,0,BcW,0,A,[],4,3,0,0,0,ABa,0,A,[],3,3,0,
0,0,YC,0,BM,[],0,0,0,0,["rF",E(UM),"bx",G(ASq),"ev",J(AOe),"dt",R(AWA),"b1",E(AYj),"pv",J(Bet),"pw",J(Bck),"pu",G(AYX)],KP,0,B6,[],0,3,0,0,0,AW_,0,KP,[],0,3,0,0,0,D8,"ReflectionException",4,B8,[],0,3,0,0,["U",G(Fh)],Fw,0,CB,[],0,0,0,0,["b_",J(G5),"br",J(BbF),"bX",E(Bfe)],A_B,0,Dq,[],0,3,0,0,0,Lt,0,A,[BE],3,3,0,0,0,TF,0,BM,[],0,0,0,0,["m8",E(ABR),"bx",G(A1D)],Ga,0,F9,[],1,3,0,0,["e",F(P1),"d$",E(AVS),"bG",F(AOw),"bH",E(AMi)],Rh,0,Ga,[],0,3,0,0,["e",F(AEI),"bD",E(A0R)],A$5,0,A,[Vc],0,3,0,0,0,AY2,0,A,[I6],0,3,
0,0,0,AW8,0,A,[Bs,EV],0,3,0,0,0,A0p,0,B0,[],0,3,0,0,0]);
BW([BjW,0,A,[BE],1,3,0,0,0,AHs,0,D1,[H_],0,3,0,0,0,A0O,0,Bo,[],0,0,0,0,0,A0N,0,Bo,[],0,0,0,0,0,APC,0,A,[],4,3,0,0,0,LJ,0,A,[],0,3,0,DZ,["c",E(AD0)],A0a,0,A,[],0,3,0,0,0,AIv,"NoSuchElementException",11,Bi,[],0,3,0,0,["c",E(YA)],BbC,0,B0,[],0,3,0,0,0,A5K,0,A,[],3,3,0,0,0,AF_,0,Fo,[],0,0,0,0,["cS",G(AGC),"br",J(ARc),"ev",J(Bd_),"dt",R(ALC),"b1",E(A40)],Tc,0,Dp,[],0,0,0,0,["rQ",R(AC8),"br",J(A8B),"ev",J(AJP)],A3v,0,FE,[],4,3,0,0,0,AYu,0,A,[BE],1,3,0,0,0,AFc,0,Bm,[],0,3,0,0,["pF",E(VK),"f8",E(Bfh),"f7",F(A_4),"f4",
F(ANX),"f3",F(AJv)],Vr,0,A,[],4,3,0,Fv,0,A4C,0,A,[],0,3,0,0,0,H6,0,Bz,[],12,3,0,Mi,0,A$7,0,Fi,[],0,3,0,0,0,M9,0,A,[Ck],0,3,0,GU,["fp",G(AH$),"pZ",F(AZ1),"fs",F(Bcd),"fq",F(BeO),"p3",G(A27),"gn",G(AZd),"go",G(AUq),"p6",J(AMh),"p7",J(A5d),"gt",function(b,c,d,e,f,g){Bia(this,b,c,d,e,f,g);},"gm",F(AMO),"gu",E(AOj),"ip",E(A2T),"gs",E(A9F),"gr",E(AN7)],QX,0,T,[],0,0,0,0,["r9",E(AIm),"b6",E(ASJ)],PM,0,A,[],1,3,0,0,["e",F(ADA)],VJ,0,PM,[],0,3,0,0,["e",F(TP),"cX",F(ARK),"qb",E(BjG),"jX",E(A3n),"qg",J(AKD)],Gj,0,A,[Kx],
0,3,0,0,["e7",G(Uz),"K",E(O5),"tg",F(AYt),"tm",F(ALp),"tc",J(A6t),"tl",E(AMW),"gm",F(BfO),"gh",F(A_A)],U8,0,Gj,[],0,3,0,0,["K",E(ACb)],A7_,0,BX,[],0,3,0,0,0,ANJ,0,A,[],0,3,0,0,0,Tn,0,T,[],0,0,0,0,["jD",J(AHT),"b6",E(BaB)],Tv,0,T,[],0,0,0,0,["jB",R(V_),"b6",E(AI0)],Tq,0,T,[],0,0,0,0,["jC",G(QH),"b6",E(A_t)],To,0,T,[],0,0,0,0,["jD",J(QW),"b6",E(A3Q)],Ts,0,T,[],0,0,0,0,["jC",G(QQ),"b6",E(AXp)],AG5,0,A,[],0,3,0,0,0,Tx,0,T,[],0,0,0,0,["jG",J(UQ),"b6",E(ARt)],Tu,0,T,[],0,0,0,0,["jB",R(Re),"b6",E(ATf)],Tt,0,T,[],0,
0,0,0,["jC",G(QT),"b6",E(A3S)],ADb,0,A,[BE],3,3,0,0,0,T1,0,BD,[],4,0,0,0,["rS",E(Uf),"br",J(A7l),"bX",E(A_Z),"eu",F(AIY),"ca",E(BiL)],Tw,0,T,[],0,0,0,0,["jG",J(WW),"b6",E(Beg)],Ok,0,A,[Cf],0,3,0,Z,0,QV,0,BM,[],0,0,0,0,["rH",E(AD_),"bx",G(AKA)],Df,0,BM,[],0,0,0,0,["K",E(AIb),"bx",G(A_p),"ev",J(A6g),"dt",R(APK),"hC",F(AJ7),"b1",E(A$Z)],A6M,0,A,[BE],1,3,0,0,0,Ben,0,B0,[],0,3,0,0,0,A4Y,0,A,[],0,3,0,0,0,BhR,0,A,[CL],0,3,0,0,0,A96,0,A,[Bs,EV],0,3,0,0,0,Jw,0,Bm,[],0,3,0,Jc,["pF",E(ADj),"iZ",E(ACh),"jM",E(AZz),"s1",
F(A3m),"fy",R(Bf1),"fJ",E(A0z),"s4",E(A4P),"s7",G(BhM),"s3",G(AZZ),"s2",G(A73),"s8",G(ARo)],I9,0,A,[CL],0,3,0,0,["e",F(AHU),"K",E(AEB),"nW",G(HT),"pc",E(AW9),"lX",G(AXB),"bW",E(Bju),"b2",E(Bfi),"tR",G(Bim)],JP,0,A,[Bs],0,3,0,Je,["J",R(V0),"e",F(XW),"qZ",R(ATW),"q0",F(Bh1)]]);
BW([AHd,0,Dt,[],0,3,0,X$,0,A4r,0,Eb,[],0,3,0,0,0,ZE,0,T,[],0,0,0,0,["u0",E(Wc),"b6",E(AVz)],RL,0,FN,[],0,0,0,0,["d4",function(b,c,d,e,f,g){AAj(this,b,c,d,e,f,g);},"kB",E(ARr),"iB",G(AP9)],AFQ,0,Bw,[],4,0,0,0,["K",E(Ww),"br",J(A1V),"ca",E(AWi)],HF,0,Bz,[],12,3,0,CM,0,ACf,0,A,[],32,0,0,Zd,0,BfX,0,BC,[],0,3,0,0,0,AG6,0,BM,[],0,0,0,0,["rH",E(ABl),"bx",G(AJg)],Mx,0,A,[AHG],0,3,0,0,0,A7A,0,Mx,[],0,0,0,0,0,AYD,0,Oy,[],0,3,0,0,0,D$,0,CB,[],0,0,0,0,["q4",function(b,c,d,e,f){FD(this,b,c,d,e,f);},"br",J(BjF)],Os,0,D$,
[],0,0,0,0,["q4",function(b,c,d,e,f){NL(this,b,c,d,e,f);},"br",J(AMd)],KX,0,K1,[Du,Bs,ACR],0,3,0,0,["e",F(Wg),"K",E(J9),"ce",E(AMl),"bW",E(A_i),"bV",F(A8j),"kT",E(Bfp),"b3",G(A0n),"b2",E(A_P)],Rb,0,A,[],32,0,0,NR,0,WT,"IllegalMonitorStateException",15,Bi,[],0,3,0,0,["e",F(AAm)],A7H,0,Bq,[],0,0,0,0,0,Kc,0,A,[Db],0,0,0,0,["sS",E(T2),"bn",E(AUx),"vj",E(A$i)],Kd,0,A,[Db],0,0,0,0,["sS",E(SA),"bn",E(Bjo),"vj",E(BgW)],Q_,0,Cn,[],0,0,0,0,["sS",E(RG),"bl",G(BaW)],AX0,0,A,[],0,3,0,0,0,WK,0,Fw,[],0,0,0,0,["b_",J(ACP),
"br",J(APB)],ACj,0,Bq,[],0,0,0,0,["e",F(SQ)],ASw,0,A,[],4,3,0,0,0,ACm,0,Bq,[],0,0,0,0,["e",F(AFa)],A7J,0,Bq,[],0,0,0,0,0,A7E,0,Bq,[],0,0,0,0,0,ACl,0,Bq,[],0,0,0,0,["e",F(AC$)],ACo,0,Bq,[],0,0,0,0,["e",F(AAM)],A4d,0,CG,[],4,3,0,0,0,ACn,0,Bq,[],0,0,0,0,["e",F(AFx)],ACk,0,Bq,[],0,0,0,0,["e",F(Yw)],ACG,0,A,[],3,3,0,0,0,Xd,0,A,[ACG],0,3,0,0,["e",F(X5),"fr",G(AO_),"e_",G(A5D)],SZ,0,Bw,[],0,0,0,0,["e",F(AIj),"br",J(A1z),"ca",E(A8v)],AHY,0,Fm,[],0,3,0,0,["L",G(Xw)],Kp,0,D$,[],0,0,0,0,["q4",function(b,c,d,e,f){NN(this,
b,c,d,e,f);},"br",J(AZw)],AZ2,0,Ei,[],0,3,0,0,0,T8,0,T,[],0,0,0,0,["dd",E(AAu),"b6",E(Be4)],A25,0,Ei,[],0,3,0,0,0,HV,"NoSuchMethodException",15,Ic,[],0,3,0,0,["e",F(Yi)],ABk,0,GE,[],0,0,0,0,["d4",function(b,c,d,e,f,g){Vp(this,b,c,d,e,f,g);},"d0",E(Bct),"d2",G(ANr)],Nl,"NullPointerException",15,Bi,[],0,3,0,0,["c",E(AE9),"e",F(T4)],UY,0,T,[],0,0,0,0,["dr",E(WA),"b6",E(A$w)],AFg,0,E1,[],0,3,0,0,0,O2,0,A,[],3,3,0,0,0,AZa,0,A,[],4,3,0,0,0,VR,0,W,[],0,0,0,0,["e",F(AD$),"D",F(A6l)],Pt,"PatternSyntaxException",12,Ca,
[],0,3,0,0,["oF",J(KC),"bA",F(BgZ)]]);
BW([Jr,0,Bm,[],0,3,0,0,["K",E(Ma),"st",E(Bhy)],AFy,0,W,[],0,0,0,0,["e",F(Uo),"D",F(AR8)],BdD,0,A,[],0,3,0,0,0,AA0,0,A,[Dc],0,3,0,N5,0,JF,0,Bz,[],12,3,0,ES,0,AAo,0,A,[],0,3,0,0,0,A07,0,EA,[],0,3,0,0,0,A7V,0,Dt,[],0,3,0,0,0,FA,0,A,[CL],0,3,0,Jj,["e",F(AFu),"nW",G(Nq),"rg",E(AP5),"rh",E(AXS),"bL",G(Ba3),"bJ",E(AOA),"lO",E(Be8),"pe",E(Ui)],XF,0,A,[Bs],4,3,0,0,["iv",E(Mm),"rm",G(RW),"hT",E(RV),"r0",F(HC),"uA",F(Rs),"uB",F(AGb),"uD",F(ACA)],UA,0,Fw,[],0,0,0,0,["b_",J(AFU),"br",J(A0_),"bX",E(A6y)],ABN,0,Bd,[],0,0,
0,0,["e",F(AGW)],A1F,0,Bo,[],0,0,0,0,0,ABO,0,Bd,[],0,0,0,0,["e",F(ABC)],Gy,0,A,[Bs,EV],0,3,0,OQ,["e",F(We)],ABP,0,Bd,[],0,0,0,0,["e",F(AAh)],ABL,0,Bd,[],0,0,0,0,["e",F(Xl)],ABM,0,Bd,[],0,0,0,0,["e",F(AGA)],AQo,0,A,[],0,3,0,0,0,N7,0,A,[ADb],0,0,0,0,["k6",E(ACK),"r7",F(Bfa),"vy",F(ASx)],Bb1,0,A,[EV],0,3,0,0,0,ALS,0,A,[],0,3,0,0,0,A5m,0,A,[],0,3,0,0,0,BeC,0,Ep,[Ck],0,3,0,0,0,A56,0,GR,[],0,3,0,0,0,E5,0,A,[J4],0,3,0,0,["e",F(P$)],JJ,0,T,[],0,0,0,0,["K",E(NT),"b6",E(A8a)],Zc,0,JJ,[],0,0,0,0,["K",E(ABj),"b6",E(BbT)],RH,
0,A,[],4,3,0,0,["pl",G(YU),"bk",E(KR),"g3",F(AD7)],VO,"UnmappableCharacterException",14,Ew,[],0,3,0,0,["K",E(X4),"bA",F(ASK)],AEw,0,A,[],0,3,0,0,["e",F(Qz)],AHx,0,D_,[],0,0,0,0,["pp",G(XH)],AG7,0,HA,[],0,3,0,0,0,AP0,0,Dh,[],0,3,0,0,0,ZF,0,T,[],0,0,0,0,["uV",E(RI),"b6",E(AMM)],VS,0,W,[],0,0,0,0,["e",F(RK),"D",F(ATt)],Jt,0,Bz,[],12,3,0,DN,0,AYL,0,CC,[],1,3,0,0,0,ZO,0,Dg,[Cf],0,3,0,Er,0,ADD,0,A,[],0,0,0,0,["K",E(Yv),"pt",G(AZk),"l8",E(A36)],Pv,0,A,[],0,3,0,0,0,A4J,0,Cc,[],0,3,0,0,0,AEM,0,W,[],0,0,0,0,["e",F(St),
"D",F(A6F)],AOq,0,Eb,[],0,3,0,0,0,Xm,0,A,[],0,3,0,0,["k0",F(A$_),"sU",F(A_f),"c",E(R6)],UL,0,T,[],0,0,0,0,["iG",E(AHn),"b6",E(A4w)],Th,0,T,[],0,0,0,0,["jI",G(AHu),"b6",E(A2N),"y",F(AXa)],AIV,0,CB,[],0,0,0,0,["b_",J(AFR),"br",J(ARe)],AL$,0,Ct,[],0,3,0,0,0,Te,0,T,[],0,0,0,0,["jC",G(AEh),"b6",E(ARn)]]);
BW([Tf,0,T,[],0,0,0,0,["jC",G(AA3),"b6",E(AWa)],Tg,0,T,[],0,0,0,0,["jB",R(UB),"b6",E(Bke)],Ul,0,T,[],0,0,0,0,["jB",R(Wi),"b6",E(AXz)],Ti,0,T,[],0,0,0,0,["jB",R(Vi),"b6",E(AOP)],Tj,0,T,[],0,0,0,0,["jB",R(RE),"b6",E(A9u)],Tk,0,T,[],0,0,0,0,["jG",J(AB5),"b6",E(A0P)],Td,0,T,[],0,0,0,0,["jG",J(AAE),"b6",E(Bdk)],Y9,0,Fq,[],0,3,0,0,0,Nm,0,Ec,[H2],0,3,0,0,["K",E(Y$),"e",F(AHI),"x",E(K),"O",E(AKL),"P",E(V),"fc",E(W4),"hR",E(CR),"hS",E(LD),"cF",E(BA),"sl",J(ARV),"dN",E(Bbv),"fb",E(SI),"sr",G(AVr),"sq",G(Bb_),"sp",G(AZR),
"sk",R(A$6),"sn",G(Bh5),"sm",G(A6d),"so",G(A60),"oO",G(BfB),"jJ",E(BcF),"ss",G(A1Z),"cy",R(A1K),"cz",J(AS9),"bb",F(AOm),"y",F(S),"ce",E(A2m),"cv",G(A2K),"cb",G(A41),"cu",G(A3K),"cr",G(Bbf),"cn",G(AXP),"ci",G(AQv),"cc",G(BjK)],AF7,"ConcurrentModificationException",11,Bi,[],0,3,0,0,["e",F(AIc)],L2,"IDLBool",18,Jr,[],0,3,[0,0,0],Hc,["e",F(W2),"sv",F(BdC),"y",F(A8x)],RB,0,A,[W1],0,0,0,0,["e",F(ZG)],A9x,0,Eh,[],0,3,0,0,0,RA,0,A,[Jg],0,0,0,0,["e",F(S9)],ACX,0,A,[AC3],0,3,0,0,["e",F(ZV)],ALI,0,L3,[],0,3,0,0,0,A8b,
0,BC,[],0,3,0,0,0,Bjz,0,Gw,[],0,3,0,0,0,S7,0,A,[CL,Cf],4,3,0,0,["fl",E(AAN),"bV",F(De),"gq",E(CQ)],AOM,0,A,[],0,3,0,0,0,ALu,0,A,[Bs],0,3,0,0,0,AB8,0,A,[],0,3,0,0,0,AED,0,W,[],0,0,0,0,["e",F(SM),"D",F(AT9)],Kw,0,A,[DE],0,3,0,ND,["e",F(AHb)],JH,0,EP,[],0,3,0,HK,["e",F(AAy),"K",E(P3),"h9",F(A4T)],A8t,0,F1,[],0,0,0,0,0,Xy,0,A,[],0,3,0,0,0,Biq,0,A,[],0,3,0,0,0,ATG,0,Cb,[],0,0,0,0,0,ASF,0,A,[],0,3,0,0,0,AJ6,0,A,[],0,3,0,0,0,Rt,0,GA,[Du],0,0,0,0,["cS",G(Yb),"hy",F(AW7),"hz",F(Beh),"y",F(A6u)],QY,0,T,[],0,0,0,0,["uF",
E(AE5),"b6",E(ANT)],ASu,0,A,[],4,0,0,0,0,MD,0,A,[Us,El],0,3,0,0,["s9",G(LE),"s",F(AZy),"sC",E(A0d),"n9",F(A4H),"fr",G(A6T),"e_",G(Bhq),"s0",F(BdQ),"jL",F(BgJ),"pm",E(APM),"ft",F(Bh2),"oY",E(Bin)],A8S,0,Ds,[],0,3,0,0,0,ST,0,T,[],0,0,0,0,["nV",E(AAJ),"b6",E(A74)],BgN,0,A,[BE],1,3,0,0,0,AGS,0,E5,[],0,3,0,0,["e",F(AGj),"os",R(Bdu),"ou",J(A0y),"ot",R(Ba4),"or",E(APo),"oo",E(A$u),"oq",E(AXX),"ov",G(AU4),"ow",G(Bdz)],WB,0,Cv,[],0,0,0,0,["er",J(AIT),"br",J(A8k)],A3D,0,A,[],0,3,0,0,0,AUZ,0,A,[],4,3,0,0,0,Si,0,A,[Dc],
0,3,0,M3,0,A0X,0,A,[],0,3,0,0,0,Bjs,0,A,[EV],0,3,0,0,0,BbW,0,CG,[],4,3,0,0,0,Gt,0,A,[Ck],0,3,0,FV,["iJ",function(b,c,d,e,f){Mz(this,b,c,d,e,f);},"s$",function(b,c,d,e,f){PE(this,b,c,d,e,f);},"iO",J(A$Y),"iM",E(AQO),"tk",E(ASG),"td",J(Bbd),"tn",E(Ba_),"th",J(A2q),"iQ",R(Bj7),"tj",function(b,c,d,e,f){A42(this,b,c,d,e,f);},"iP",E(AV5)],AOt,0,A,[CL],0,3,0,0,0,AWM,0,A,[BE],4,3,0,0,0,AGq,0,Bw,[],0,0,0,0,["e",F(Yh),"br",J(A7x),"ca",E(AJd)]]);
BW([Ov,0,A,[CL],0,3,0,0,["e",F(ZX),"nW",G(Ms),"rg",E(A39),"rh",E(ARl),"p2",G(Bbj),"p1",G(APE),"pe",E(AFE)],Px,0,D9,[E3],0,0,0,0,["cT",G(XJ),"nM",function(b,c,d,e,f,g,h){Kl(this,b,c,d,e,f,g,h);},"l$",E(AJC),"fA",G(ARF),"d1",F(Bev),"m3",F(BiR),"mn",E(Bco),"p0",F(Bi_),"ii",F(A5L),"hb",F(Bj5)],SU,0,A,[EK,O2,AF1],0,0,0,0,["gP",G(ACH),"s",F(A$g)],Pr,0,A,[Bs],0,3,0,0,["c4",G(WF),"tw",J(A22)],ZD,0,A,[],3,3,0,0,0,OD,0,A,[],0,3,0,Ie,["e",F(RJ),"qf",E(A7m)],ML,0,A,[Bs],0,3,0,NG,["qa",G(AGJ)],BbJ,0,Cx,[],0,0,0,0,0,Nt,0,
A,[ABT,Db],0,3,0,0,["sO",E(ACW),"bn",E(Bcx),"sW",F(AZL),"tI",J(AYR),"tF",G(A2M),"tG",G(BaQ),"tM",G(AXN),"tN",G(A_N),"tQ",E(A_T),"jN",E(AT2),"tE",F(A6S),"vj",E(ALR)],BbK,0,Cx,[],0,0,0,0,0,V9,"BufferUnderflowException",14,Bi,[],0,3,0,0,["e",F(AHr)],A9K,0,A,[],0,3,0,0,0,AG8,0,Bq,[],0,0,0,0,["e",F(RO)],AG9,0,Bq,[],0,0,0,0,["e",F(Xa)],AG$,0,Bq,[],0,0,0,0,["e",F(AGE)],AA1,0,Ga,[],0,3,0,0,["e",F(ADO),"bD",E(AWP)],AG_,0,Bq,[],0,0,0,0,["e",F(AEJ)],A$d,0,Bo,[],0,0,0,0,0,AHa,0,Cb,[],0,0,0,0,["e",F(WJ)],Ya,0,A,[],3,3,0,
0,0,AFI,0,A,[BE,DR],1,3,0,0,["vz",G(A2Z),"vA",G(A4E),"vB",J(AJ8),"vC",E(AKs),"vD",J(AXs)],S0,0,A,[],0,3,0,0,0,AHm,0,A,[Gi],0,3,0,0,["e",F(Yo),"j7",F(APJ),"T",F(A3p)],Lk,0,A,[Lt],0,3,0,0,["e",F(QF),"uk",E(Bc7),"vE",E(AP6)],Ll,0,A,[Lt],0,3,0,0,["e",F(TY),"uk",E(AKK),"vE",E(AKe)],A80,0,A,[],4,3,0,0,0,Uv,0,W,[],0,0,0,0,["e",F(S3),"D",F(Bg0)],AAs,0,A,[Ph],4,3,0,0,["ix",E(ABc),"uz",E(J7),"iw",F(Ml),"dy",E(AIw),"dw",E(RF),"rk",F(AHA),"dz",F(VI),"ds",F(RY),"rj",G(Qx)],AGh,0,BD,[],0,0,0,0,["e",F(ABZ),"br",J(BhS),"bX",
E(APe),"eu",F(A6K),"ca",E(APa)],ARq,0,A,[I6],0,3,0,0,0,AIW,0,W,[],0,0,0,0,["e",F(ADR),"D",F(AJH)],J1,0,Bm,[],0,3,0,M5,["iZ",E(Rq),"ka",F(A85),"kc",F(Biw)],K_,0,BD,[],0,0,0,0,["rG",G(Ri),"bX",E(A3W),"br",J(AJB),"b1",E(APb),"ca",E(BdK)],XR,0,A,[],0,3,0,0,0,AO3,0,B0,[],0,3,0,0,0,Y4,0,A,[El],0,3,0,0,["uL",E(WC),"s",F(AUe)],QE,0,Fl,[],0,3,0,0,["o3",E(AFG),"jW",F(AX1),"lV",E(AWI)],OB,0,A,[FF],0,0,0,0,["gR",G(QB),"bn",E(BdE),"vj",E(AYS)],Ho,"GlyphLayout$GlyphRun",9,A,[DE],0,3,0,0,0,ADP,0,Fq,[],0,3,0,0,0,IJ,0,Bz,[],
12,3,0,MW,0,A97,0,A,[EK,O2],3,0,0,0,0,Vf,0,Bw,[],0,0,0,0,["pF",E(Yx),"br",J(AOu),"ca",E(AO5)],AW$,0,A,[El],0,0,0,0,0,A$M,0,A,[],4,3,0,0,0,U6,0,Dg,[Cf],0,3,0,Mf,0,Dm,0,A,[ZD],1,3,0,0,0,AWw,0,Dm,[],0,0,0,0,0,AWq,0,OK,[],0,0,0,0,0,AWr,0,Dm,[],0,0,0,0,0]);
BW([AWs,0,Dm,[],0,0,0,0,0,AWv,0,Dm,[],0,0,0,0,0,A5g,0,Bo,[],0,0,0,0,0,TH,0,A,[],3,3,0,0,0,R0,0,A,[BE,ADx,TH,Lo],1,3,0,0,["vo",E(A71),"vF",G(BbM),"vG",G(Bag),"vH",J(A7I),"vI",E(BfE),"vJ",F(AQg),"vK",J(AJ$)],RX,0,A,[DE],0,3,0,ADQ,0,AL5,0,A,[],0,0,0,0,0,A$S,0,BC,[],0,3,0,0,0,Bcu,0,E5,[Ck],0,3,0,0,0,ACJ,0,D5,[],0,0,0,0,["er",J(V6),"br",J(AMN)],ADE,0,W,[],0,0,0,0,["e",F(SR),"D",F(AZO)],BiM,0,N3,[],0,0,0,0,0,AVF,0,BC,[],0,3,0,0,0,H7,0,Bm,[],0,3,0,0,["K",E(LA),"uW",E(A1$),"i2",F(A61)],My,"IDLFloat",18,H7,[],0,3,[0,0,0],
HM,["e",F(VL),"uY",F(BeE),"y",F(BhZ)],B$,"NumberFormatException",15,Ca,[],0,3,0,0,["e",F(R$),"c",E(C9)],AAx,0,A,[],0,3,0,0,["ef",R(YB)],ACO,0,A,[Ty],0,3,0,0,["e",F(Vn)],Bhj,0,CI,[],0,0,0,0,0,A03,0,B0,[],0,3,0,0,0,VC,0,A,[Jg,CL],0,3,0,0,["ht",G(ABn),"bZ",F(A05),"b0",F(AQW)],AOn,0,A,[],0,0,0,0,0,AC4,0,W,[],0,0,0,0,["e",F(AAP),"D",F(A_u)],ADS,0,W,[],0,0,0,0,["e",F(ABh),"D",F(AJi)],A6H,0,A,[],0,3,0,0,0,AS4,0,CG,[],4,3,0,0,0,AL0,0,Eb,[],0,3,0,0,0,IS,0,BD,[],0,0,0,0,["rH",E(AB7),"bX",E(APN),"br",J(AJ3),"ev",J(A9b),
"dt",R(Bau),"b1",E(ASs),"ca",E(A9z)],Hy,"Table$DebugRect",7,Gy,[],0,3,0,AH5,0,Sy,0,A,[Gi],0,3,0,0,["e",F(ZU),"j7",F(AM0),"T",F(AX$)],Sm,0,E$,[],0,3,0,0,["M",R(RQ)],XB,0,A,[Ya],0,0,0,0,["u4",E(AHf),"j",E(A1y),"u5",E(BhA)],IU,0,A,[],0,3,0,0,["e",F(Xk),"K",E(AIo),"e7",G(Jz),"nc",E(A0U),"l8",E(BbL),"oy",E(BaG),"u7",E(Bd8),"nb",F(AUy),"u6",E(AN1)],AYp,0,FA,[],0,3,0,0,0,A49,0,A,[BE],1,3,0,0,0,ZQ,0,Cc,[EX],0,3,0,AAH,0,BbZ,0,Eh,[],0,3,0,0,0,AAg,0,A,[],0,3,0,0,0,AY6,0,Cb,[],0,0,0,0,0,A1q,0,BC,[],0,3,0,0,0,ANs,0,A,[],
3,3,0,0,0,A6G,0,Pv,[],0,3,0,0,0,A_7,0,A,[],4,3,0,0,0,AAv,0,A,[],0,3,0,ZB,0,AZl,0,A,[],0,3,0,0,0,AAV,0,Bw,[],0,0,0,0,["K",E(Xc),"br",J(A7t),"ca",E(AVK)],AEv,0,A,[EK],0,3,0,0,["gJ",E(Yp),"s",F(AM_)],A1T,0,DA,[],0,3,0,0,0,ANm,0,A,[ABa],0,3,0,0,0,Un,0,Bm,[],4,3,0,0,["iZ",E(Qw),"fT",F(UH),"f2",E(AEl),"f0",F(Ik),"f1",F(Hb),"fV",F(KY),"fX",F(NZ),"fW",F(L_),"fY",F(Nw)]]);
BW([NO,0,Bm,[],0,3,0,CY,["iZ",E(Z0)],BcK,0,A,[],0,3,0,0,0,AHO,0,A,[],32,0,0,Pw,0,A2S,0,BC,[],0,3,0,0,0,Vx,0,W,[],0,0,0,0,["e",F(AHK),"D",F(Bf6)],AX3,0,A,[DE],4,3,0,0,0,AGG,0,A,[],0,3,0,0,0]);
let Bmc=BkX(BlS),Bl$=BkX(BkA),Bl_=BkX(BlT),Bma=BkX(BlU),Bmb=BkX(Bla),Bl9=BkX(Bk_),Bmd=BkX(Blj);BkH(["Can\'t enter monitor from another thread synchronously","<java_object>@","bounces cannot be < 2 or > 5: ","Constructor not found for class: ","Security violation occurred while getting constructor for class: \'","\'.","Security violation while getting constructor for class: ","String is null","String is empty","String contains invalid digits: ","String contains digits out of radix ",": ","The value is too big for int type: ",
"The value is too big for integer type","Illegal radix: ","Android","Mac","Win","Linux","FreeBSD","iPhone","iPod","iPad","error","Desktop","HeadlessDesktop","Applet","WebGL","iOS","\tat ","Caused by: ","null","false","true","New position "," is outside of range [0;","New limit ","","Lower","Upper","ASCII","Alpha","Digit","Alnum","Punct","Graph","Print","Blank","Cntrl","XDigit","javaLowerCase","javaUpperCase","javaWhitespace","javaMirrored","javaDefined","javaDigit","javaIdentifierIgnorable","javaISOControl",
"javaJavaIdentifierPart","javaJavaIdentifierStart","javaLetter","javaLetterOrDigit","javaSpaceChar","javaTitleCase","javaUnicodeIdentifierPart","javaUnicodeIdentifierStart","Space","w","W","s","S","d","D","BasicLatin","Latin-1Supplement","LatinExtended-A","LatinExtended-B","IPAExtensions","SpacingModifierLetters","CombiningDiacriticalMarks","Greek","Cyrillic","CyrillicSupplement","Armenian","Hebrew","Arabic","Syriac","ArabicSupplement","Thaana","Devanagari","Bengali","Gurmukhi","Gujarati","Oriya","Tamil","Telugu",
"Kannada","Malayalam","Sinhala","Thai","Lao","Tibetan","Myanmar","Georgian","HangulJamo","Ethiopic","EthiopicSupplement","Cherokee","UnifiedCanadianAboriginalSyllabics","Ogham","Runic","Tagalog","Hanunoo","Buhid","Tagbanwa","Khmer","Mongolian","Limbu","TaiLe","NewTaiLue","KhmerSymbols","Buginese","PhoneticExtensions","PhoneticExtensionsSupplement","CombiningDiacriticalMarksSupplement","LatinExtendedAdditional","GreekExtended","GeneralPunctuation","SuperscriptsandSubscripts","CurrencySymbols","CombiningMarksforSymbols",
"LetterlikeSymbols","NumberForms","Arrows","MathematicalOperators","MiscellaneousTechnical","ControlPictures","OpticalCharacterRecognition","EnclosedAlphanumerics","BoxDrawing","BlockElements","GeometricShapes","MiscellaneousSymbols","Dingbats","MiscellaneousMathematicalSymbols-A","SupplementalArrows-A","BraillePatterns","SupplementalArrows-B","MiscellaneousMathematicalSymbols-B","SupplementalMathematicalOperators","MiscellaneousSymbolsandArrows","Glagolitic","Coptic","GeorgianSupplement","Tifinagh","EthiopicExtended",
"SupplementalPunctuation","CJKRadicalsSupplement","KangxiRadicals","IdeographicDescriptionCharacters","CJKSymbolsandPunctuation","Hiragana","Katakana","Bopomofo","HangulCompatibilityJamo","Kanbun","BopomofoExtended","CJKStrokes","KatakanaPhoneticExtensions","EnclosedCJKLettersandMonths","CJKCompatibility","CJKUnifiedIdeographsExtensionA","YijingHexagramSymbols","CJKUnifiedIdeographs","YiSyllables","YiRadicals","ModifierToneLetters","SylotiNagri","HangulSyllables","HighSurrogates","HighPrivateUseSurrogates",
"LowSurrogates","PrivateUseArea","CJKCompatibilityIdeographs","AlphabeticPresentationForms","ArabicPresentationForms-A","VariationSelectors","VerticalForms","CombiningHalfMarks","CJKCompatibilityForms","SmallFormVariants","ArabicPresentationForms-B","HalfwidthandFullwidthForms","all","Specials","Cn","IsL","Lu","Ll","Lt","Lm","Lo","IsM","Mn","Me","Mc","N","Nd","Nl","No","IsZ","Zs","Zl","Zp","IsC","Cc","Cf","Co","Cs","IsP","Pd","Ps","Pe","Pc","Po","IsS","Sm","Sc","Sk","So","Pi","Pf","Should never been thrown",
"Index ","ErrorLoading: ","\n",":","i","b","a","Invalid assets description file.","[]","<init>","assets/",".js","Loading JS script: ","Disposing "," while it still has "," references.","IDL","uniform mat4 ProjMtx;\nattribute vec2 Position;\nattribute vec2 UV;\nattribute vec4 Color;\nvarying vec2 Frag_UV;\nvarying vec4 Frag_Color;\nvoid main()\n{\n    Frag_UV = UV;\n    Frag_Color = Color;\n    gl_Position = ProjMtx * vec4(Position.xy,0,1);\n}\n","#ifdef GL_ES\n    precision mediump float;\n#endif\nuniform sampler2D Texture;\nvarying vec2 Frag_UV;\nvarying vec4 Frag_Color;\nvoid main()\n{\n    gl_FragColor = Frag_Color * texture2D(Texture, Frag_UV.st);\n}\n",
"Position","UV","Color","ShaderTest","Texture","ProjMtx","Capacity is negative: ","The last char in dst "," is outside of array of size ","Length "," must be non-negative","Offset ","The last char in src "," is outside of string of size ","Start "," must be before end ","main","Script loaded: ","data:",";base64,","The last float in src ","Unsupported asset type ","Loading asset : ","Loading script : ","index can\'t be >= size: "," >= ","touchDown","touchUp","touchDragged","mouseMoved","enter","exit","scrolled",
"keyDown","keyUp","keyTyped","none","table","cell","actor","TestFloat","TestFloat2","TestFloat3","TestFloat4","TestString2","value: ","EditText","UTF-8","jpg","jpeg","png","bmp","gif","json","xml","txt","glsl","fnt","pack","obj","atlas","g3dj","mp3","ogg","wav","Class cannot be created (missing no-arg constructor): ","PX","PCT","EM","EX","PT","PC","IN","CM","MM","OnPlane","Back","Front","px","GLVersion","OpenGL ES (\\d(\\.\\d){0,2})","WebGL (\\d(\\.\\d){0,2})","(\\d(\\.\\d){0,2})","Invalid version string: ",
"\\.","libGDX GL","Error parsing number: ",", assuming: ","The last short in src ","Can\'t have more than 8191 sprites per batch: ","a_position","a_color","a_texCoord0","attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projTrans * a_position;\n}\n","#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}",
"Error compiling shader: ","u_projTrans","u_texture","Malformed input of length ","Hello World","##Renderer","DockSpace111","MyDockSpace","Game Window","Hierarchy","Assets","Inspector","Game Editor","GUI Editor","Dear ImGui Demo","#TAB","File","Save","Load","View","Layout","Layout 01","Layout 02","�","averageCharsPerByte must be positive. Actual value is ","maxCharsPerByte must be positive. Actual value is ","newAction must be non-null","object","function","string","number","enabled","disabled","childrenOnly",
"Can only cope with FloatBuffer and ShortBuffer at the moment","GL error: ",", ","IndexBufferObject cannot be used after it has been disposed.","keyboard","scroll","Item01","Item02","Item03","Item04","##selectListId","SelectList","The last byte in dst ","Is","In","Webaudio","Audiocontext unlocked","OpenGL","GLES","NONE","loadFactor must be > 0 and < 1: ","BIG_ENDIAN","LITTLE_ENDIAN","Lambert","Phong","Asset loaded: ","rgba(","0","IGNORE","REPLACE","REPORT","both","top","bottom","vertex shader must not be null",
"fragment shader must not be null","Fragment shader:\n","Vertex shader\n","An attempted fetch uniform from uncompiled shader \n","No uniform with name \'","\' in shader","No buffer allocated!","Image","Audio","Text","t","Binary","Directory","hidden","imgui.wasm","VertexArray","VertexBufferObject","VertexBufferObjectSubData","VertexBufferObjectWithVAO","key cannot be null.","Patter is null","\\Q","\\E","\\\\E\\Q","ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/","==","=","Unmappable characters of length ",
"LOAD_ASSETS","APP_CREATE","APP_LOOP","The value is too big for long type: ","The value is too big for long type","attributes must be >= 1","java.runtime.name","userAgent","os.name","Windows","OS X","no OS",".html","index.html","index-debug.html","assets.txt","resize","gdx.wasm.js","canvas","Mesh attempting to access memory outside of the index buffer (count: ",", offset: ",", max: ",")","capacity must be >= 0: ","The required capacity is too large: ","mousedown","mouseup","mousemove","wheel","touchstart","touchmove",
"touchcancel","touchend","keydown","keypress","keyup","CSS1Compat","##test","DRAG_ENTITY_ID","Dragging: entityName","Drag here","dragDropPayload","Value: ","Drag&Drop","Either src or dest is null","java.version","1.8","TeaVM","file.separator","/","path.separator","line.separator","java.io.tmpdir","java.vm.version","user.home","/tmp","Enabled","EnabledUntilCycleEnd","Disabled","data must be a ByteBuffer or FloatBuffer","#iterator() cannot be used nested.","color 01","Red: "," Green: "," Blue: ","color 02"," Alpha: "]);
BG.prototype.toString=function(){return Be(this);};
BG.prototype.valueOf=BG.prototype.toString;A.prototype.toString=function(){return Be(TD(this));};
A.prototype.__teavm_class__=function(){return BkC(this);};
Bga.main=Bk4(A9L);
Bga.main.javaException=BkT;
(function(){var c;c=LH.prototype;c.handleEvent=c.vj;c=Nh.prototype;c.denied=c.vn;c.prompt=c.vm;c.granted=c.vl;c=Md.prototype;c.handleEvent=c.vj;c=Me.prototype;c.handleEvent=c.vj;c=Mc.prototype;c.handleEvent=c.vj;c=Kf.prototype;c.handleEvent=c.vj;c=Kh.prototype;c.handleEvent=c.vj;c=Wn.prototype;c.get=c.vo;Object.defineProperty(c,"length",{get:c.vp});c=O_.prototype;c.handleEvent=c.vj;c=IL.prototype;c.onAnimationFrame=c.vq;c=Vs.prototype;c.removeEventListener=c.vv;c.dispatchEvent=c.vs;c.addEventListener=c.vu;c
=N0.prototype;c.handleEvent=c.vj;c=Kv.prototype;c.unlockFunction=c.vw;c=KO.prototype;c.handleEvent=c.vj;c=PB.prototype;c.onInit=c.vx;c=Kc.prototype;c.handleEvent=c.vj;c=Kd.prototype;c.handleEvent=c.vj;c=N7.prototype;c.fullscreenChanged=c.vy;c=Nt.prototype;c.handleEvent=c.vj;c=AFI.prototype;c.removeEventListener=c.vB;c.dispatchEvent=c.vC;c.addEventListener=c.vD;c=Lk.prototype;c.accept=c.vE;c=Ll.prototype;c.accept=c.vE;c=OB.prototype;c.handleEvent=c.vj;c=R0.prototype;c.removeEventListener=c.vH;c.dispatchEvent
=c.vI;c.get=c.vo;c.addEventListener=c.vK;Object.defineProperty(c,"length",{get:c.vJ});})();
}));
