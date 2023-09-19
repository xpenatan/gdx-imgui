package imgui;

import idl.IDLBase;

public class ImGuiPayload extends IDLBase {

    public int get_Data() {
        return getDataNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImGuiPayload);
        return imgui.ImHelper.prototype.getImGuiPayloadData(nativeObject);
    */
    /*[-C++;-NATIVE]
        ImGuiPayload* nativeObject = (ImGuiPayload*)addr;
        return *(const int*)nativeObject->Data;
    */
    private static native int getDataNATIVE(long addr);
}
