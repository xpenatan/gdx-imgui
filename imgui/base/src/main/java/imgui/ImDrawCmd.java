package imgui;

import idl.IDLBase;

public class ImDrawCmd extends IDLBase {

    /*[-C++;-NATIVE]
        #if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
        #include <stddef.h>     // intptr_t
        #else
        #include <stdint.h>     // intptr_t
        #endif
    */

    public ImDrawCmd(boolean cMemoryOwn) {
    }

    public int getTextureId() {
        return getTextureIdNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawCmd);
        var textureId = imgui.ImHelper.prototype.getTextureId(nativeObject);
        return textureId;
    */
    /*[-C++;-NATIVE]
        ImDrawCmd* nativeObject = (ImDrawCmd*)addr;
        int textureId = ImHelper::getTextureId(nativeObject);
        return textureId;
    */
    private static native int getTextureIdNATIVE(long addr);

    public int getIdxOffset() {
        return getIdxOffsetNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawCmd);
        var jsObj = nativeObject.get_IdxOffset();
        return jsObj;
    */
    /*[-C++;-NATIVE]
        ImDrawCmd* nativeObject = (ImDrawCmd*)addr;
        return nativeObject->IdxOffset;
    */
    private static native int getIdxOffsetNATIVE(long addr);

    public int getVtxOffset() {
        return getVtxOffsetNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawCmd);
        var jsObj = nativeObject.get_VtxOffset();
        return jsObj;
    */
    /*[-C++;-NATIVE]
        ImDrawCmd* nativeObject = (ImDrawCmd*)addr;
        return nativeObject->VtxOffset;
    */
    private static native int getVtxOffsetNATIVE(long addr);

    public int getElemCount() {
        return getElemCountNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawCmd);
        var jsObj = nativeObject.get_ElemCount();
        return jsObj;
    */
    /*[-C++;-NATIVE]
        ImDrawCmd* nativeObject = (ImDrawCmd*)addr;
        return nativeObject->ElemCount;
    */
    private static native int getElemCountNATIVE(long addr);
}
