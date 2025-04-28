package imgui;

import idl.IDLBase;
import idl.IDLEnum;

public class ImGuiStyle extends IDLBase {

    private static ImVec4 tmp = new ImVec4(false);

    /*[-IDL_SKIP]*/
    public native void Colors(ImVec4[] Colors);

    /*[-IDL_SKIP]*/
    public native ImVec4[] Colors();

    public void Colors(IDLEnum index, float r, float g, float b, float a) {
        Colors(index, ImVec4.TMP_INTERNAL_1.set(r, g, b, a));
    }

    public void Colors(IDLEnum index, int r, int g, int b, int a) {
        Colors(index, ImVec4.TMP_INTERNAL_1.set(r / 255f, g / 255f, b / 255f, a / 255f));
    }

    public void Colors(IDLEnum index, ImVec4 color) {
        set_ColorsNATIVE(getNativeData().getCPointer(), index.getValue(), color.getNativeData().getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImGuiStyle);
        var vec4 = [MODULE].wrapPointer(vec4Addr, [MODULE].ImVec4);
        nativeObject.set_Colors(index, vec4);
    */
    /*[-JNI;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        ImVec4* vec4 = (ImVec4*)vec4Addr;
        nativeObject->Colors[index] = *vec4;
    */
    private static native void set_ColorsNATIVE(long addr, long index, long vec4Addr);

    /**
     * Return a temp ImVec4 object. Don't keep reference.
     */
    public ImVec4 Colors(IDLEnum index) {
        tmp.getNativeData().reset((get_ColorsNATIVE(getNativeData().getCPointer(), index.getValue())), false);
        return tmp;
    }

    /*[-TEAVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImGuiStyle);
        var vec4 = nativeObject.get_Colors(index);
        return [MODULE].getPointer(vec4);
    */
    /*[-JNI;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        ImVec4* vec4 = &nativeObject->Colors[index];
        return (jlong)vec4;
    */
    private static native long get_ColorsNATIVE(long addr, long index);

}