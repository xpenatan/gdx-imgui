#pragma once

#include "imgui.h"
#include "imgui_internal.h"
#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
#include <stddef.h>     // intptr_t
#else
#include <stdint.h>     // intptr_t
#endif

class ImHelper {
    public:
        static void memcpyIdx(intptr_t destination, ImDrawList * drawList, int num) {
            void * dest = (void*)destination;
            memcpy(dest, drawList->IdxBuffer.Data, num);
        }

        static void memcpyVtx(intptr_t destination, ImDrawList * drawList, int num) {
            void * dest = (void*)destination;
            memcpy(dest, drawList->VtxBuffer.Data, num);
        }

        static void memcpyFont(ImGuiIO * io, intptr_t pixelBuff, int * width, int * height, int * bytesPerPixel) {
            void * pixelBuffer = (void *)pixelBuff;
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