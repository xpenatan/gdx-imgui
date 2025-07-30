package imgui;

import idl.IDLBase;

public class ImFont extends IDLBase {

    public native ImFontConfig get_ConfigData();

    public void setName(String name) {
        updateNameNATIVE(native_address, name, get_ConfigData().get_SizePixels());
    }

    /*[-TEAVM;-NATIVE]
        var font = [MODULE].wrapPointer(addr, [MODULE].ImFont);
        [MODULE].ImHelper.prototype.updateFontName(font, name, size);
    */
    /*[-JNI;-NATIVE]
        ImFont* font = (ImFont*)addr;
        ImHelper::updateFontName(font, name, size);
    */
    private static native void updateNameNATIVE(long addr, String name, float size);
}