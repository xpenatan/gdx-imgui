package imgui;

import idl.IDLBase;

public class ImGuiStyle extends IDLBase {

    private static ImVec4 tmp = new ImVec4(false);

    /*[-IDL_SKIP]*/
    public native void set_Colors(ImVec4[] Colors);

    /*[-IDL_SKIP]*/
    public native ImVec4[] get_Colors();

    public void set_Colors(int index, float r, float g, float b, float a) {
        set_Colors(index, ImVec4.TMP_INTERNAL_1.set(r, g, b, a));
    }

    public void set_Colors(int index, int r, int g, int b, int a) {
        set_Colors(index, ImVec4.TMP_INTERNAL_1.set(r / 255f, g / 255f, b / 255f, a / 255f));
    }

    public void set_Colors(int index, ImVec4 color) {
        set_ColorsNATIVE(getCPointer(), index, color.getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImGuiStyle);
        var vec4 = [MODULE].wrapPointer(vec4Addr, [MODULE].ImVec4);
        nativeObject.set_Colors(index, vec4);
    */
    /*[-C++;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        ImVec4* vec4 = (ImVec4*)vec4Addr;
        nativeObject->Colors[index] = *vec4;
    */
    private static native void set_ColorsNATIVE(long addr, int index, long vec4Addr);


    /**
     * Return a temp ImVec4 object. Don't keep reference.
     */
    public ImVec4 get_Colors(int index) {
        tmp.setPointer(get_ColorsNATIVE(getCPointer(), index));
        return tmp;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImGuiStyle);
        var vec4 = nativeObject.get_Colors(index);
        return [MODULE].getPointer(vec4);
    */
    /*[-C++;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        ImVec4* vec4 = &nativeObject->Colors[index];
        return (jlong)vec4;
    */
    private static native long get_ColorsNATIVE(long addr, int index);

}