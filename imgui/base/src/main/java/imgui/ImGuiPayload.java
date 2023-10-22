package imgui;

import idl.IDLBase;

public class ImGuiPayload extends IDLBase {

    public int get_Data() {
        return getDataNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = [MODULE].wrapPointer(addr, [MODULE].ImGuiPayload);
        return [MODULE].ImHelper.prototype.getImGuiPayloadData(nativeObject);
    */
    /*[-C++;-NATIVE]
        ImGuiPayload* nativeObject = (ImGuiPayload*)addr;
        return *(const int*)nativeObject->Data;
    */
    private static native int getDataNATIVE(long addr);
}
