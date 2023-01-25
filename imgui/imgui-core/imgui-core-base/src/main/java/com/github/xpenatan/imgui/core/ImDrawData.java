package com.github.xpenatan.imgui.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ImDrawData {

    public static int MAX_VERTICES = 100000;
    public static int MAX_INDICES = 100000;
    public static int MAX_CMD = 1000;

    private int cmdListsCount; // Number of ImDrawList* to render
    private int totalIdxCount; // For convenience, sum of all ImDrawList's IdxBuffer.Size
    private int totalVtxCount;
    private int totalCmdCount;

    private float displayPosX;
    private float displayPosY;

    private float displaySizeX;
    private float displaySizeY;

    private float framebufferScaleX;
    private float framebufferScaleY;

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

    public int getCmdListsCount() {
        return cmdListsCount;
    }

    public float getDisplayPosX() {
        return displayPosX;
    }

    public float getDisplayPosY() {
        return displayPosY;
    }

    public float getDisplaySizeX() {
        return displaySizeX;
    }

    public float getDisplaySizeY() {
        return displaySizeY;
    }

    public float getFramebufferScaleX() {
        return framebufferScaleX;
    }

    public float getFramebufferScaleY() {
        return framebufferScaleY;
    }
}
