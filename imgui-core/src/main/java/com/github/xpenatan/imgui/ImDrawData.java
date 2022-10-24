package com.github.xpenatan.imgui;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ImDrawData {

    public static int MAX_VERTICES = 100000;
    public static int MAX_INDICES = 100000;
    public static int MAX_CMD = 1000;

    public int cmdListsCount; // Number of ImDrawList* to render
    public int totalIdxCount; // For convenience, sum of all ImDrawList's IdxBuffer.Size
    public int totalVtxCount;
    public int totalCmdCount;

    public float displayPosX;
    public float displayPosY;

    public float displaySizeX;
    public float displaySizeY;

    public float framebufferScaleX;
    public float framebufferScaleY;

    public final static int vBufferSize = (2 + 2 + 1) * 4;
    public final static int iBufferSize = 2;
    public final static int cmdBufferSize = (1 + 4 + 1) * 4;

    public ByteBuffer vByteBuffer;
    public ByteBuffer iByteBuffer;
    public ByteBuffer cmdByteBuffer;

    public ImDrawData() {
        this(MAX_VERTICES, MAX_INDICES, MAX_CMD);
    }

    public ImDrawData(int maxVertices, int maxIndices, int maxCmd) {
        this.vByteBuffer = ByteBuffer.allocateDirect(maxVertices * vBufferSize);
        this.iByteBuffer = ByteBuffer.allocateDirect(maxIndices * iBufferSize);
        this.cmdByteBuffer = ByteBuffer.allocateDirect(maxCmd * cmdBufferSize);
        vByteBuffer.order(ByteOrder.nativeOrder());
        iByteBuffer.order(ByteOrder.nativeOrder());
        cmdByteBuffer.order(ByteOrder.nativeOrder());
    }

    public ImDrawData(ByteBuffer vByteBuffer, ByteBuffer iByteBuffer, ByteBuffer cmdByteBuffer) {
        this.vByteBuffer = vByteBuffer;
        this.iByteBuffer = iByteBuffer;
        this.cmdByteBuffer = cmdByteBuffer;
    }
}
