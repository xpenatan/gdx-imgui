package imgui;

import idl.IDLBase;

public class ImVectorInt extends IDLBase {

    public int getData(int index) {
        return getDataNATIVE(getNativeData().getCPointer(), index);
    }

    /*[-TEAVM;-NATIVE]
        var jsObj = [MODULE].wrapPointer(this_addr, [MODULE].ImVectorInt);
        return jsObj.getData(index);
    */
    /*[-JNI;-NATIVE]
        ImVectorInt* nativeObject = (ImVectorInt*)this_addr;
        unsigned int value = nativeObject->Data[index];
        return (jint)value;
    */
    private static native int getDataNATIVE(long this_addr, int index);
}