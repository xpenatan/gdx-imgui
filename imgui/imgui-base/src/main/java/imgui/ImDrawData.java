package imgui;

import idl.IDLBase;

/*[-IDL_SKIP]*/
public final class ImDrawData extends IDLBase {

    private ImDrawList imDrawList = new ImDrawList(false);

    public ImDrawData(boolean cMemoryOwn) {
    }

    public ImDrawData(byte b, char c) {
    }

    public int getCmdListsCount() {
        return getCmdListsCountNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.get_CmdListsCount();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->CmdListsCount;
    */
    private static native int getCmdListsCountNATIVE(long addr);

    public ImDrawList getCmdLists(int index) {
        long pointer = getCmdListsNATIVE(getCPointer(), index);
        imDrawList.setCPointer(pointer);
        return imDrawList;
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        var cmdList = nativeObject.get_CmdLists(index);
        return [MODULE].getPointer(cmdList);
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return (jlong)nativeObject->CmdLists[index];
    */
    private static native long getCmdListsNATIVE(long addr, int index);

    public float getDisplayPosX() {
        return getDisplayPosXNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.DisplayPos.get_x();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplayPos.x;
    */
    private static native int getDisplayPosXNATIVE(long addr);

    public float getDisplayPosY() {
        return getDisplayPosYNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.DisplayPos.get_y();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplayPos.y;
    */
    private static native int getDisplayPosYNATIVE(long addr);

    public float getDisplaySizeX() {
        return getDisplaySizeXNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.DisplaySize.get_x();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplaySize.x;
    */
    private static native int getDisplaySizeXNATIVE(long addr);

    public float getDisplaySizeY() {
        return getDisplaySizeYNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.DisplaySize.get_y();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplaySize.y;
    */
    private static native int getDisplaySizeYNATIVE(long addr);

    public float getFramebufferScaleX() {
        return getFramebufferScaleXNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.FramebufferScale.get_x();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->FramebufferScale.x;
    */
    private static native int getFramebufferScaleXNATIVE(long addr);

    public float getFramebufferScaleY() {
        return getFramebufferScaleYNATIVE(getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImDrawData);
        return nativeObject.FramebufferScale.get_y();
    */
    /*[-JNI;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->FramebufferScale.y;
    */
    private static native int getFramebufferScaleYNATIVE(long addr);
}
