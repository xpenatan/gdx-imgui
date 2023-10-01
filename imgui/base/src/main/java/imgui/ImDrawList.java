package imgui;

import idl.IDLBase;
import idl.helper.ByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ImDrawList extends IDLBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
        #include "imgui_custom.h"
    */

    /*[-C++;-NATIVE]
        static int DRAWLIST_TYPE_DEFAULT = 0;
        static int DRAWLIST_TYPE_BACKGROUND = 1;
        static int DRAWLIST_TYPE_FOREGROUND = 2;

        ImDrawList * getDrawList(int type) {
            ImDrawList* drawList = NULL;
            if(type == DRAWLIST_TYPE_DEFAULT)
                drawList = ImGui::GetWindowDrawList();
            else if(type == DRAWLIST_TYPE_BACKGROUND)
                drawList = ImGui::GetBackgroundDrawList();
            else if(type == DRAWLIST_TYPE_FOREGROUND)
                drawList = ImGui::GetForegroundDrawList();
            return drawList;
        }
    */

    public final static int VTX_BUFFER_SIZE = 8+8+4;// = ImVec2 + ImVec2 + ImU32;
    public final static int IDX_BUFFER_SIZE = 2; // short
    public final static int cmdBufferSize = (1 + 4 + 1) * 4; // = ImVec4 + ImTextureID + int + int + int
    private static final int RESIZE_FACTOR = 5_000;

    public final static int TYPE_DEFAULT = 0;
    public final static int TYPE_BACKGROUND = 1;
    public final static int TYPE_FOREGROUND = 2;

    private int type = TYPE_DEFAULT;

    ByteArray vtxBuffer;
    ByteArray idxBuffer;

    public ByteBuffer vtxByteBuffer;
    public ByteBuffer idxByteBuffer;


    private ImDrawCmd imDrawCmd = new ImDrawCmd(false);

    public ImDrawList(int type) {
        this.type = type;
    }

    public ImDrawList(boolean cMemoryOwn) {
    }

    public int getFlags() {
        return getFlagsNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        return nativeObject.get_Flags();
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return nativeObject->Flags;
    */
    private static native int getFlagsNATIVE(long addr);

    public ImDrawCmd getCmdBuffer(int index) {
        long pointer = getCmdBufferNATIVE(getCPointer(), index);
        imDrawCmd.setPointer(pointer);
        return imDrawCmd;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        var cmdBuffer = nativeObject.get_CmdBuffer();
        var drawCmd = cmdBuffer.getData(index);
        return imgui.getPointer(drawCmd);
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return (jlong)&nativeObject->CmdBuffer.Data[index];
    */
    private static native long getCmdBufferNATIVE(long addr, int index);

    public int getCmdBufferSize() {
        return getCmdBufferSizeNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        return nativeObject.CmdBuffer.size();
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return nativeObject->CmdBuffer.size();
    */
    private static native int getCmdBufferSizeNATIVE(long addr);

    public ByteBuffer getIdxBufferData() {
        int idxBufferSize = getIdxBufferSizeNATIVE(getCPointer());
        int idxBufferCapacity = idxBufferSize * IDX_BUFFER_SIZE;
        if (idxByteBuffer == null || idxByteBuffer.capacity() < idxBufferCapacity) {
            if(idxByteBuffer != null) {
                idxByteBuffer.clear();
            }
            if(idxBuffer != null) {
                idxBuffer.dispose();
            }
            idxBuffer = new ByteArray(idxBufferCapacity + RESIZE_FACTOR);
            idxByteBuffer = ByteBuffer.allocateDirect(idxBufferCapacity + RESIZE_FACTOR).order(ByteOrder.nativeOrder());
        }
        getIdxBufferDataNATIVE(getCPointer(), idxBuffer.getCPointer(), idxBufferCapacity);
        idxByteBuffer.position(0);
        idxByteBuffer.limit(idxBufferCapacity);
        for(int i = 0; i < idxBufferCapacity; i++) {
            idxByteBuffer.put(i, idxBuffer.getValue(i));
        }
        idxByteBuffer.position(0);
        idxByteBuffer.limit(idxBufferCapacity);
        return idxByteBuffer;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        var charArray = imgui.wrapPointer(bufferAddr, imgui.ByteArray);
        var charArrayPtr = charArray.getPointer();
        imgui.ImHelper.prototype.memcpyIdx(charArrayPtr, nativeObject, bufferCapacity);
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        ByteArray* charArray = (ByteArray*)bufferAddr;
        ImHelper::memcpyIdx(charArray->getPointer(), nativeObject, bufferCapacity);
    */
    private static native void getIdxBufferDataNATIVE(long addr, long bufferAddr, int bufferCapacity);

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        return nativeObject.IdxBuffer.size();
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return nativeObject->IdxBuffer.size();
    */
    private static native int getIdxBufferSizeNATIVE(long addr);

    public ByteBuffer getVtxBufferData() {
        int vtxBufferSize = getVtxBufferSizeNATIVE(getCPointer());
        int vtxBufferCapacity = vtxBufferSize * VTX_BUFFER_SIZE;
        if (vtxByteBuffer == null || vtxByteBuffer.capacity() < vtxBufferCapacity) {
            if(vtxByteBuffer != null) {
                vtxByteBuffer.clear();
            }
            if(vtxBuffer != null) {
                vtxBuffer.dispose();
            }
            vtxBuffer = new ByteArray(vtxBufferCapacity + RESIZE_FACTOR);
            vtxByteBuffer = ByteBuffer.allocateDirect(vtxBufferCapacity + RESIZE_FACTOR).order(ByteOrder.nativeOrder());
        }
        // TODO find a better way to get native byte buffer for c++ and teavm
        getVtxBufferDataNATIVE(getCPointer(), vtxBuffer.getCPointer(), vtxBufferCapacity);
        vtxByteBuffer.position(0);
        vtxByteBuffer.limit(vtxBufferCapacity);
        for(int i = 0; i < vtxBufferCapacity; i++) {
            vtxByteBuffer.put(i, vtxBuffer.getValue(i));
        }
        vtxByteBuffer.position(0);
        vtxByteBuffer.limit(vtxBufferCapacity);
        return vtxByteBuffer;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        var charArray = imgui.wrapPointer(bufferAddr, imgui.ByteArray);
        var charArrayPtr = charArray.getPointer();
        imgui.ImHelper.prototype.memcpyVtx(charArrayPtr, nativeObject, bufferCapacity);
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        ByteArray* charArray = (ByteArray*)bufferAddr;
        ImHelper::memcpyVtx(charArray->getPointer(), nativeObject, bufferCapacity);
    */
    private static native void getVtxBufferDataNATIVE(long addr, long bufferAddr, int bufferCapacity);

    /*[-teaVM;-NATIVE]
        var nativeObject = imgui.wrapPointer(addr, imgui.ImDrawList);
        return nativeObject.VtxBuffer.size();
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return nativeObject->VtxBuffer.size();
    */
    private static native int getVtxBufferSizeNATIVE(long addr);

}