package com.github.xpenatan.imgui.core;

public class ImGuiBase {

    protected long cPointer;
    protected boolean cMemOwn;
    private boolean disposed;

    public ImGuiBase() {
    }

    protected void initObject(long cPtr, boolean cMemoryOwn) {
        cMemOwn = cMemoryOwn;
        cPointer = cPtr;
    }

    public void setPointer(long cPtr) {
        if(!cMemOwn) {
            cPointer = cPtr;
        }
    }

    public long getCPointer() {
        return cPointer;
    }

    public boolean isDisposed() {
        return disposed;
    }

    protected void deleteNative() {
    }

    public void dispose() {
        if(cMemOwn && !disposed) {
            // Don't try to delete if this object did not create the pointer
            disposed = true;
            deleteNative();
            cPointer = 0;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }

}
