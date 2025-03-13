package imgui;

import idl.IDLBase;
import idl.helper.IDLByteArray;
import idl.helper.IDLIntArray;

public class ImFontAtlas extends IDLBase {

    public ImFont AddFontFromMemoryTTF(byte[] fontData, int font_size) {
        IDLByteArray byteArray = new IDLByteArray(fontData.length);
        byteArray.copy(fontData);
        return AddFontFromMemoryTTF(byteArray.getPointer(), byteArray.getSize(), font_size);
    }

    public void GetTexDataAsRGBA32(IDLByteArray pixelBuffer, IDLIntArray outWidth, IDLIntArray outHeight) {
        GetTexDataAsRGBA32NATIVE(getNativeData().getCPointer(), pixelBuffer.getNativeData().getCPointer(), outWidth.getNativeData().getCPointer(), outHeight.getNativeData().getCPointer());
    }

    /*[-TEAVM;-NATIVE]
        var fontAtlas = [MODULE].wrapPointer(addr, [MODULE].ImFontAtlas);
        var pixelBufferArray = [MODULE].wrapPointer(pixelBufferAddr, [MODULE].IDLByteArray);
        var widthIntArray = [MODULE].wrapPointer(widthAddr, [MODULE].IDLIntArray);
        var heightIntArray = [MODULE].wrapPointer(heightAddr, [MODULE].IDLIntArray);
        var widthArr = widthIntArray.getPointer();
        var heightArr = heightIntArray.getPointer();
        [MODULE].ImHelper.prototype.memcpyFont(fontAtlas, pixelBufferArray, widthArr, heightArr);
    */
    /*[-JNI;-NATIVE]
        ImFontAtlas* fontAtlas = (ImFontAtlas*)addr;
        IDLByteArray* pixelBuffer = (IDLByteArray*)pixelBufferAddr;
        IDLIntArray* widthIntArray = (IDLIntArray*)widthAddr;
        IDLIntArray* heightIntArray = (IDLIntArray*)heightAddr;
        ImHelper::memcpyFont(fontAtlas, pixelBuffer, (int*)widthIntArray->getData(), (int*)heightIntArray->getData());
    */
    private static native void GetTexDataAsRGBA32NATIVE(long addr, long pixelBufferAddr, long widthAddr, long heightAddr);

    public native ImFont AddFontFromMemoryTTF(long font_data, int font_data_size, int size_pixels);
}