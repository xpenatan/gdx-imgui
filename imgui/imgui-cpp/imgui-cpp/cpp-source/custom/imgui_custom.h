#pragma once

#include "imgui.h"
#include "imgui_internal.h"

class BoolArray {
    public:
        bool * data;
        int size;

        BoolArray(int size) { data = NULL; resize(size); }
        ~BoolArray() { if(data != NULL) { deleteData(); } }
        void resize(int newSize) {
            if(this->data != NULL) {
                deleteData();
            }
            bool * newData = new bool[newSize];
            for(int i = 0; i < newSize; i++) {
                newData[i] = 0;
            }
            this->data = newData;
            size = newSize;
        }
        void deleteData() { delete data; }
        bool getValue(int index) { return data[index]; }
        void setValue(int index, bool value) { data[index] = value; }
        void* getPointer() { return (void*)data; }
};

class IntArray {
    public:
        int * data;
        int size;

        IntArray(int size) { data = NULL; resize(size); }
        ~IntArray() { if(data != NULL) { deleteData(); } }
        void resize(int newSize) {
            if(this->data != NULL) {
                deleteData();
            }
            int * newData = new int[newSize];
            for(int i = 0; i < newSize; i++) {
                newData[i] = 0;
            }
            this->data = newData;
            size = newSize;
        }
        void deleteData() { delete data; }
        int getValue(int index) { return data[index]; }
        void setValue(int index, int value) { data[index] = value; }
        void* getPointer() { return (void*)data; }
};

class FloatArray {
    public:
        float * data;
        int size;

        FloatArray(int size) { data = NULL; resize(size); }
        ~FloatArray() { if(data != NULL) { deleteData(); } }
        void resize(int newSize) {
            if(this->data != NULL) {
                deleteData();
            }
            float * newData = new float[newSize];
            for(int i = 0; i < newSize; i++) {
                newData[i] = 0;
            }
            this->data = newData;
            size = newSize;
        }
        void deleteData() { delete data; }
        float getValue(int index) { return data[index]; }
        void setValue(int index, float value) { data[index] = value; }
        void* getPointer() { return (void*)data; }
};

class DoubleArray {
    public:
        double * data;
        int size;

        DoubleArray(int size) { data = NULL; resize(size); }
        ~DoubleArray() { if(data != NULL) { deleteData(); } }
        void resize(int newSize) {
            if(this->data != NULL) {
                deleteData();
            }
            double * newData = new double[newSize];
            for(int i = 0; i < newSize; i++) {
                newData[i] = 0;
            }
            this->data = newData;
            size = newSize;
        }
        void deleteData() { delete data; }
        double getValue(int index) { return data[index]; }
        void setValue(int index, double value) { data[index] = value; }
        void* getPointer() { return (void*)data; }
};

class CharArray {
    public:
        char * data;
        int size;

        CharArray(int size) { data = NULL; resize(size); }
        ~CharArray() { if(data != NULL) { deleteData(); } }
        void resize(int newSize) {
            if(this->data != NULL) {
                deleteData();
            }
            char * newData = new char[newSize];
            for(int i = 0; i < newSize; i++) {
                newData[i] = 0;
            }
            this->data = newData;
            size = newSize;
        }
        void deleteData() { delete data; }
        char getValue(int index) { return data[index]; }
        void setValue(int index, char value) { data[index] = value; }
        void* getPointer() { return (void*)data; }
};

class ImHelper {
    public:
        static void memcpyIdx(void * destination, ImDrawList * drawList, int num) {
            memcpy(destination, drawList->IdxBuffer.Data, num);
        }

        static void memcpyVtx(void * destination, ImDrawList * drawList, int num) {
            memcpy(destination, drawList->VtxBuffer.Data, num);
        }

        static void memcpyFont(ImGuiIO * io, void * pixelBuffer, int * width, int * height, int * bytesPerPixel) {
            unsigned char* pixels;
            io->Fonts->GetTexDataAsRGBA32(&pixels, width, height, bytesPerPixel);
            int size = (*width) * (*height) * (*bytesPerPixel);
            memcpy(pixelBuffer, pixels, size);
        }

        static int getTextureId(ImDrawCmd* nativeObject) {
            int textureId = (int)(intptr_t)nativeObject->TextureId;
            return textureId;
        }

        static void setIniFilename(ImGuiIO * io, char* fileName) {
            // not possible to change a readonly attribute in webidl file.
            io->IniFilename = fileName;
        }

        static void removeIniFilename(ImGuiIO * io) {
            // not possible to change a readonly attribute in webidl file.
            ImGui::GetIO().IniFilename = NULL;
        }
};