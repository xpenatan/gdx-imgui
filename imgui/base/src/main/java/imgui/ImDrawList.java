package imgui;

import idl.IDLBase;
import idl.helper.ByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/*[-IDL_SKIP]*/
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
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
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
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
        var cmdBuffer = nativeObject.get_CmdBuffer();
        var drawCmd = cmdBuffer.getData(index);
        return ImGui.getPointer(drawCmd);
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
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
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
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
        var charArray = ImGui.wrapPointer(bufferAddr, ImGui.CharArray);
        var charArrayPtr = charArray.getPointer();
        ImGui.ImHelper.prototype.memcpyIdx(charArrayPtr, nativeObject, bufferCapacity);
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        CharArray* charArray = (CharArray*)bufferAddr;
        ImHelper::memcpyIdx(charArray->getPointer(), nativeObject, bufferCapacity);
    */
    private static native void getIdxBufferDataNATIVE(long addr, long bufferAddr, int bufferCapacity);

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
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
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
        var charArray = ImGui.wrapPointer(bufferAddr, ImGui.CharArray);
        var charArrayPtr = charArray.getPointer();
        ImGui.ImHelper.prototype.memcpyVtx(charArrayPtr, nativeObject, bufferCapacity);
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        CharArray* charArray = (CharArray*)bufferAddr;
        ImHelper::memcpyVtx(charArray->getPointer(), nativeObject, bufferCapacity);
    */
    private static native void getVtxBufferDataNATIVE(long addr, long bufferAddr, int bufferCapacity);

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawList);
        return nativeObject.VtxBuffer.size();
    */
    /*[-C++;-NATIVE]
        ImDrawList* nativeObject = (ImDrawList*)addr;
        return nativeObject->VtxBuffer.size();
    */
    private static native int getVtxBufferSizeNATIVE(long addr);

    // Stateful path API, add points then finish with PathFillConvex() or PathStroke()

    public void AddLine(float a_x, float a_y, float b_x, float b_y, int col) {
        AddLineNATIVE(type, a_x, a_y, b_x, b_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddLine(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    private static native void AddLineNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col);

    public void AddLine(float a_x, float a_y, float b_x, float b_y, int col, float thinkness) {
        AddLineNATIVE(type, a_x, a_y, b_x, b_y, col, thinkness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddLine(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, thinkness);
    */
    private static native void AddLineNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float thinkness);

    public void AddRect(float a_x, float a_y, float b_x, float b_y, int col) {
        AddRectNATIVE(type, a_x, a_y, b_x, b_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    private static native void AddRectNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col);

    public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding) {
        AddRectNATIVE(type, a_x, a_y, b_x, b_y, col, rounding);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding);
    */
    private static native void AddRectNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding);

    public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags) {
        AddRectNATIVE(type, a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags);
    */
    private static native void AddRectNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags);

    public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags, float thickness) {
        AddRectNATIVE(type, a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags, thickness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags, thickness);
    */
    private static native void AddRectNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags, float thickness);

    public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col) {
        AddRectFilledNATIVE(type, a_x, a_y, b_x, b_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    private static native void AddRectFilledNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col);

    public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col, float rounding) {
        AddRectFilledNATIVE(type, a_x, a_y, b_x, b_y, col, rounding);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding);
    */
    private static native void AddRectFilledNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding);

    public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags) {
        AddRectFilledNATIVE(type, a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags);
    */
    private static native void AddRectFilledNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags);

    public void AddRectFilledMultiColor(float a_x, float a_y, float b_x, float b_y, int col_upr_left, float col_upr_right, int col_bot_right, int col_bot_left) {
        AddRectFilledMultiColorNATIVE(type, a_x, a_y, b_x, b_y, col_upr_left, col_upr_right, col_bot_right, col_bot_left);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilledMultiColor(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col_upr_left, col_upr_right, col_bot_right, col_bot_left);
    */
    private static native void AddRectFilledMultiColorNATIVE(int type, float a_x, float a_y, float b_x, float b_y, int col_upr_left, float col_upr_right, int col_bot_right, int col_bot_left);

    public void AddQuad(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col) {
        AddQuadNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuad(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col);
    */
    private static native void AddQuadNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col);

    public void AddQuad(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col, float thickness) {
        AddQuadNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col, thickness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuad(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col, thickness);
    */
    private static native void AddQuadNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col, float thickness);

    public void AddQuadFilled(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col) {
        AddQuadFilledNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuadFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col);
    */
    private static native void AddQuadFilledNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col);

    public void AddTriangle(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col) {
        AddTriangleNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangle(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col);
    */
    private static native void AddTriangleNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col);

    public void AddTriangle(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col, float thickness) {
        AddTriangleNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, col, thickness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangle(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col, thickness);
    */
    private static native void AddTriangleNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col, float thickness);

    public void AddTriangleFilled(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col) {
        AddTriangleFilledNATIVE(type, a_x, a_y, b_x, b_y, c_x, c_y, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangleFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col);
    */
    private static native void AddTriangleFilledNATIVE(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircle(ImVec2(centre_x, centre_y), radius, col);
    */
    private static native void AddCircleNATIVE(int type, float centre_x, float centre_y, float radius, float col);

    public void AddCircle(float centre_x, float centre_y, float radius, float col, int num_segments, float thickness) {
        AddCircleNATIVE(type, centre_x, centre_y, radius, col, num_segments, thickness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircle(ImVec2(centre_x, centre_y), radius, col, num_segments, thickness);
    */
    private static native void AddCircleNATIVE(int type, float centre_x, float centre_y, float radius, float col, int num_segments, float thickness);

    public void AddCircleFilled(float centre_x, float centre_y, float radius, float col) {
        AddCircleFilledNATIVE(type, centre_x, centre_y, radius, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircleFilled(ImVec2(centre_x, centre_y), radius, col);
    */
    private static native void AddCircleFilledNATIVE(int type, float centre_x, float centre_y, float radius, float col);

    public void AddCircleFilled(float centre_x, float centre_y, float radius, float col, int num_segments) {
        AddCircleFilledNATIVE(type, centre_x, centre_y, radius, col, num_segments);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircleFilled(ImVec2(centre_x, centre_y), radius, col, num_segments);
    */
    private static native void AddCircleFilledNATIVE(int type, float centre_x, float centre_y, float radius, float col, int num_segments);

    public void AddText(float pos_x, float pos_y, int col, String text_begin) {
        AddTextNATIVE(type, pos_x, pos_y, col, text_begin);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddText(ImVec2(pos_x, pos_y), col, text_begin);
    */
    private static native void AddTextNATIVE(int type, float pos_x, float pos_y, int col, String text_begin);

    public void AddText(float pos_x, float pos_y, int col, String text_begin, String text_end) {
        AddTextNATIVE(type, pos_x, pos_y, col, text_begin, text_end);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddText(ImVec2(pos_x, pos_y), col, text_begin, text_end);
    */
    private static native void AddTextNATIVE(int type, float pos_x, float pos_y, int col, String text_begin, String text_end);

    public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y) {
        AddImageNATIVE(type, textureID, a_x, a_y, b_x, b_y);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddImage((void *)textureID, ImVec2(a_x, a_y), ImVec2(b_x, b_y));
    */
    private static native void AddImageNATIVE(int type, int textureID, float a_x, float a_y, float b_x, float b_y);

    public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y, float uv_a_x, float uv_a_y, float uv_b_x, float uv_b_y) {
        ImVec2.TMP.set(a_x, a_y);
        ImVec2.TMP_2.set(b_x, b_y);
        ImVec2.TMP_3.set(uv_a_x, uv_a_y);
        ImVec2.TMP_4.set(uv_b_x, uv_b_y);
        AddImageNATIVE(getCPointer(), textureID, ImVec2.TMP.getCPointer(), ImVec2.TMP_2.getCPointer(), ImVec2.TMP_3.getCPointer(), ImVec2.TMP_4.getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var drawList = ImGui.wrapPointer(addr, ImGui.ImDrawList);
        drawList.AddImage(textureID, p_minAddr, p_maxAddr, uv_minAddr, uv_maxAddr);
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = (ImDrawList*)addr;
        ImVec2 * p_min = (ImVec2*)p_minAddr;
        ImVec2 * p_max = (ImVec2*)p_maxAddr;
        ImVec2 * uv_min = (ImVec2*)uv_minAddr;
        ImVec2 * uv_max = (ImVec2*)uv_maxAddr;
        drawList->AddImage((ImTextureID)textureID, *p_min, *p_max, *uv_min, *uv_max);
    */
    private static native void AddImageNATIVE(long addr, int textureID, long p_minAddr, long p_maxAddr, long uv_minAddr, long uv_maxAddr);

    public void PathClear() {
        PathClearNATIVE(type);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathClear();
    */
    private static native void PathClearNATIVE(int type);

    public void PathLineTo(float pos_x, float pos_y) {
        PathLineToNATIVE(type, pos_x, pos_y);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathLineTo(ImVec2(pos_x, pos_y));
    */
    private static native void PathLineToNATIVE(int type, float pos_x, float pos_y);

    public void PathStroke(int col) {
        PathStrokeNATIVE(type, col);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col);
    */
    private static native void PathStrokeNATIVE(int type, int col);

    public void PathStroke(int col, int flags) {
        PathStrokeNATIVE(type, col, flags);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col, flags);
    */
    private static native void PathStrokeNATIVE(int type, int col, int flags);

    public void PathStroke(int col, int flags, float thickness) {
        PathStrokeNATIVE(type, col, flags, thickness);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col, flags, thickness);
    */
    private static native void PathStrokeNATIVE(int type, int col, int flags, float thickness);

    public void ChannelsSplit(int count) {
        ChannelsSplitNATIVE(type, count);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsSplit(count);
    */
    private static native void ChannelsSplitNATIVE(int type, int count);

    public void ChannelsMerge() {
        ChannelsMergeNATIVE(type);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsMerge();
    */
    private static native void ChannelsMergeNATIVE(int type);

    public void ChannelsSetCurrent(int n) {
        ChannelsSetCurrentNATIVE(type, n);
    }

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsSetCurrent(n);
    */
    private static native void ChannelsSetCurrentNATIVE(int type, int n);

}
