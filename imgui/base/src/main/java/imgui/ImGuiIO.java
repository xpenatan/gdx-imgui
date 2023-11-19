package imgui;

import idl.IDLBase;
import idl.helper.IDLByteArray;
import idl.helper.IDLIntArray;

/*[-IDL_SKIP]*/
public class ImGuiIO extends IDLBase {

    public static ImGuiIO TMP_EMPTY = new ImGuiIO(false);

    public ImGuiIO(boolean cMemoryOwn) {
    }

    public ImGuiIO(byte value) {
    }

    public void set_ConfigFlags(int flags) {
        SetConfigFlagsNATIVE(getCPointer(), flags);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.set_ConfigFlags(flag);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->ConfigFlags = flag;
    */
    private static native void SetConfigFlagsNATIVE(long addr, int flag);

//    public boolean ContainsConfigFlags(ImGuiConfigFlags flags) {
//        return ContainsConfigFlagsNATIVE(getCPointer(), flags.getValue());
//    }
//
//    /*[-teaVM;-NATIVE]
//        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
//        var newFlag = io.get_ConfigFlags() & flag;
//        return newFlag == flag;
//    */
//    /*[-C++;-NATIVE]
//        ImGuiIO* io = (ImGuiIO*)addr;
//        int newFlag = io->ConfigFlags & flag;
//        return newFlag == flag;
//    */
//    private static native boolean ContainsConfigFlagsNATIVE(long addr, int flag);

    public void SetDockingFlags(boolean ConfigDockingNoSplit, boolean ConfigDockingWithShift, boolean ConfigDockingAlwaysTabBar, boolean ConfigDockingTransparentPayload) {
        SetDockingFlagsNATIVE(getCPointer(), ConfigDockingNoSplit, ConfigDockingWithShift, ConfigDockingAlwaysTabBar, ConfigDockingTransparentPayload);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.set_ConfigDockingNoSplit(ConfigDockingNoSplit);
        io.set_ConfigDockingWithShift(ConfigDockingWithShift);
        io.set_ConfigDockingAlwaysTabBar(ConfigDockingAlwaysTabBar);
        io.set_ConfigDockingTransparentPayload(ConfigDockingTransparentPayload);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->ConfigDockingNoSplit = ConfigDockingNoSplit;
        io->ConfigDockingWithShift = ConfigDockingWithShift;
        io->ConfigDockingAlwaysTabBar = ConfigDockingAlwaysTabBar;
        io->ConfigDockingTransparentPayload = ConfigDockingTransparentPayload;
    */
    private static native void SetDockingFlagsNATIVE(long addr, boolean ConfigDockingNoSplit, boolean ConfigDockingWithShift, boolean ConfigDockingAlwaysTabBar, boolean ConfigDockingTransparentPayload);

    public void SetFontGlobalScale(float scale) {
        SetFontGlobalScaleNATIVE(getCPointer(), scale);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.set_FontGlobalScale(scale);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->FontGlobalScale = scale;
    */
    private static native void SetFontGlobalScaleNATIVE(long addr, float scale);

    public boolean getWantCaptureMouse() {
        return getWantCaptureMouseNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        return io.get_WantCaptureMouse();
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        return io->WantCaptureMouse;
    */
    private static native boolean getWantCaptureMouseNATIVE(long addr);

    //TODO fix replace. generator not yet cast int on multiple methods.

//    /*[-teaVM;-REPLACE]
//    public void setIniFilename(String fileName) {
//        long cPointer1 = getCPointer();
//        if(fileName == null) {
//            removeIniFilenameNATIVE((int)cPointer1);
//        }else {
//            setIniFilenameNATIVE((int)cPointer1, fileName.getBytes());
//        }
//    }
//    */
//    public void setIniFilename(String fileName) {
//        long cPointer1 = getCPointer();
//        if(fileName == null) {
//            removeIniFilenameNATIVE(cPointer1);
//        }else {
//            setIniFilenameNATIVE(cPointer1, fileName.getBytes());
//        }
//    }
//
//    /*[-teaVM;-NATIVE]
//        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
//        [MODULE].ImHelper.prototype.setIniFilename(io, fileName);
//    */
//    /*[-C++;-NATIVE]
//        ImGuiIO* io = (ImGuiIO*)addr;
//        io->IniFilename = fileName.data;
//    */
//    private static native void setIniFilenameNATIVE(long addr, byte[] fileName);
//
//    /*[-teaVM;-NATIVE]
//        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
//        [MODULE].ImHelper.prototype.removeIniFilename(io);
//    */
//    /*[-C++;-NATIVE]
//        ImGuiIO* io = (ImGuiIO*)addr;
//        io->IniFilename = NULL;
//    */
//    private static native void removeIniFilenameNATIVE(long addr);

    public boolean containsIniFilename() {
        return containsIniFilenameNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        return [MODULE].ImHelper.prototype.containsIniFilename();
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        return io->IniFilename != NULL;
    */
    private static native boolean containsIniFilenameNATIVE(long addr);

    public void GetTexDataAsRGBA32(IDLByteArray pixelBuffer, IDLIntArray outWidth, IDLIntArray outHeight, IDLIntArray outBytesPerPixel) {
        GetTexDataAsRGBA32NATIVE(getCPointer(), pixelBuffer.getCPointer(), outWidth.getCPointer(), outHeight.getCPointer(), outBytesPerPixel.getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].IDLImGuiIO);
        var widthIntArray = [MODULE].wrapPointer(widthAddr, [MODULE].IDLIntArray);
        var heightIntArray = [MODULE].wrapPointer(heightAddr, [MODULE].IDLIntArray);
        var bytesPerPixelArray = [MODULE].wrapPointer(bytesPerPixelAddr, [MODULE].IDLIntArray);
        var pixelBufferArray = [MODULE].wrapPointer(pixelBufferAddr, [MODULE].IDLByteArray);
        var widthArr = widthIntArray.getPointer();
        var heightArr = heightIntArray.getPointer();
        var bytesPerPixelArr = bytesPerPixelArray.getPointer();
        var pixelBufferArr = pixelBufferArray.getPointer();
        [MODULE].ImHelper.prototype.memcpyFont(io, pixelBufferArr, widthArr, heightArr, bytesPerPixelArr);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        IDLIntArray* widthIntArray = (IDLIntArray*)widthAddr;
        IDLIntArray* heightIntArray = (IDLIntArray*)heightAddr;
        IDLIntArray* bytesPerPixel = (IDLIntArray*)bytesPerPixelAddr;
        IDLByteArray* pixelBuffer = (IDLByteArray*)pixelBufferAddr;
        ImHelper::memcpyFont(io, pixelBuffer->getPointer(), (int*)widthIntArray->data, (int*)heightIntArray->data, (int*)bytesPerPixel->data);
    */
    private static native void GetTexDataAsRGBA32NATIVE(long addr, long pixelBufferAddr, long widthAddr, long heightAddr, long bytesPerPixelAddr);

    public void SetFontTexID(int id) {
        SetFontTexIDNATIVE(getCPointer(), id);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.get_Fonts().set_TexID(id);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->Fonts->TexID = (ImTextureID)id;
    */
    private static native void SetFontTexIDNATIVE(long addr, int id);

    public void UpdateKeyTyped(int c) {
        updateKeyTyped(getCPointer(), c);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        if (c > 0 && c < 0x10000)
            io.AddInputCharacter(c);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        if (c > 0 && c < 0x10000)
            io->AddInputCharacter((unsigned short)c);
    */
    private static native void updateKeyTyped(long addr, int c);

    public void AddKeyEvent(int imGuiKey, boolean down) {
        AddKeyEventNATIVE(getCPointer(), imGuiKey, down);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.AddKeyEvent(imGuiKey, down);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddKeyEvent((ImGuiKey)imGuiKey, down);
    */
    private static native void AddKeyEventNATIVE(long addr, int imGuiKey, boolean down);

    public void AddMousePosEvent(float x, float y) {
        AddMousePosEventNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.AddMousePosEvent(x, y);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMousePosEvent(x, y);
    */
    private static native void AddMousePosEventNATIVE(long addr, float x, float y);

    public void AddMouseButtonEvent(int button, boolean down) {
        AddMouseButtonEventNATIVE(getCPointer(), button, down);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.AddMouseButtonEvent(button, down);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMouseButtonEvent(button, down);
    */
    private static native void AddMouseButtonEventNATIVE(long addr, int button, boolean down);

    public void AddMouseWheelEvent(float xOffset, float yOffset) {
        AddMouseWheelEventNATIVE(getCPointer(), xOffset, yOffset);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].wrapPointer(addr, [MODULE].ImGuiIO);
        io.AddMouseWheelEvent(xOffset, yOffset);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMouseWheelEvent(xOffset, yOffset);
    */
    private static native void AddMouseWheelEventNATIVE(long addr, float xOffset, float yOffset);
}
