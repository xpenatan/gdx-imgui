#include "imgui_helper.h"
#include <cstring>
#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
#include <stddef.h>     // intptr_t
#else
#include <stdint.h>     // intptr_t
#endif

static JavaVM *jvm;

// Java ImVec2
//static jfieldID fid_ImVec2_x;
//static jfieldID fid_ImVec2_y;

// Java ImGuiViewport
static jclass cls_viewport;
static jmethodID mid_viewport_init;
static jfieldID fid_ImGuiViewport_platformUserData;
static jfieldID fid_ImGuiViewport_platformHandle;
static jfieldID fid_ImGuiViewport_flags;
static jfieldID fid_ImGuiViewport_sizeX;
static jfieldID fid_ImGuiViewport_sizeY;
static jfieldID fid_ImGuiViewport_posX;
static jfieldID fid_ImGuiViewport_posY;
static jfieldID fid_ImGuiViewport_drawData;

static jfieldID fid_ImDrawData_vByteBuffer;
static jfieldID fid_ImDrawData_iByteBuffer;
static jfieldID fid_ImDrawData_cmdByteBuffer;
static jfieldID fid_ImDrawData_totalVtxCount;
static jfieldID fid_ImDrawData_totalIdxCount;
static jfieldID fid_ImDrawData_totalCmdCount;
static jfieldID fid_ImDrawData_CmdListsCount;
static jfieldID fid_ImDrawData_displayPosX;
static jfieldID fid_ImDrawData_displayPosY;
static jfieldID fid_ImDrawData_displaySizeX;
static jfieldID fid_ImDrawData_displaySizeY;
static jfieldID fid_ImDrawData_framebufferScaleX;
static jfieldID fid_ImDrawData_framebufferScaleY;

void ImGuiHelper::Init(JNIEnv* env) {
    jint rs = env->GetJavaVM(&jvm);
    assert (rs == JNI_OK);

    jclass cls_tmp_viewport = env->FindClass("com/github/xpenatan/imgui/core/ImGuiViewport");
    cls_viewport = (jclass)env->NewGlobalRef(cls_tmp_viewport);
    mid_viewport_init = env->GetMethodID(cls_viewport, "<init>", "()V");
    fid_ImGuiViewport_platformUserData = env->GetFieldID(cls_viewport, "platformUserData", "I");
    fid_ImGuiViewport_platformHandle = env->GetFieldID(cls_viewport, "platformHandle", "J");
    fid_ImGuiViewport_flags = env->GetFieldID(cls_viewport, "flags", "I");
    fid_ImGuiViewport_sizeX = env->GetFieldID(cls_viewport, "sizeX", "F");
    fid_ImGuiViewport_sizeY = env->GetFieldID(cls_viewport, "sizeY", "F");
    fid_ImGuiViewport_posX = env->GetFieldID(cls_viewport, "posX", "F");
    fid_ImGuiViewport_posY = env->GetFieldID(cls_viewport, "posY", "F");
    fid_ImGuiViewport_drawData = env->GetFieldID(cls_viewport, "drawData", "Lcom/github/xpenatan/imgui/core/ImDrawData;");

//    jclass cls_jDrawData = env->FindClass("com/github/xpenatan/imgui/core/ImDrawData");
//    fid_ImDrawData_vByteBuffer = env->GetFieldID(cls_jDrawData, "vByteBuffer", "Ljava/nio/ByteBuffer;");
//    fid_ImDrawData_iByteBuffer = env->GetFieldID(cls_jDrawData, "iByteBuffer", "Ljava/nio/ByteBuffer;");
//    fid_ImDrawData_cmdByteBuffer = env->GetFieldID(cls_jDrawData, "cmdByteBuffer", "Ljava/nio/ByteBuffer;");
//    fid_ImDrawData_totalVtxCount = env->GetFieldID(cls_jDrawData, "totalVtxCount", "I");
//    fid_ImDrawData_totalIdxCount = env->GetFieldID(cls_jDrawData, "totalIdxCount", "I");
//    fid_ImDrawData_totalCmdCount = env->GetFieldID(cls_jDrawData, "totalCmdCount", "I");
//    fid_ImDrawData_CmdListsCount = env->GetFieldID(cls_jDrawData, "cmdListsCount", "I");
//    fid_ImDrawData_displayPosX = env->GetFieldID(cls_jDrawData, "displayPosX", "F");
//    fid_ImDrawData_displayPosY = env->GetFieldID(cls_jDrawData, "displayPosY", "F");
//    fid_ImDrawData_displaySizeX = env->GetFieldID(cls_jDrawData, "displaySizeX", "F");
//    fid_ImDrawData_displaySizeY = env->GetFieldID(cls_jDrawData, "displaySizeY", "F");
//    fid_ImDrawData_framebufferScaleX = env->GetFieldID(cls_jDrawData, "framebufferScaleX", "F");
//    fid_ImDrawData_framebufferScaleY = env->GetFieldID(cls_jDrawData, "framebufferScaleY", "F");
}

JNIEnv* ImGuiHelper::GetEnv() {
    JNIEnv *env;
    jint rs = jvm->AttachCurrentThread((void **)&env, NULL);
    assert (rs == JNI_OK);
    return env;
}

jobject ImGuiHelper::CreateJImGuiViewport(JNIEnv* env) {
    return env->NewObject(cls_viewport, mid_viewport_init);
}

void ImGuiHelper::SetImGuiViewport(JNIEnv* env, jobject in, ImGuiViewport* out) {
    float value = 0;
    int userData = env->GetIntField(in, fid_ImGuiViewport_platformUserData);
    int64_t platformHandle = env->GetLongField(in, fid_ImGuiViewport_platformHandle);
    out->PlatformUserData = (void*)userData;
    int64_t * handler = (int64_t*)out->PlatformHandle;
    *handler = platformHandle;
    out->Flags = env->GetIntField(in, fid_ImGuiViewport_flags);
    value = env->GetFloatField(in, fid_ImGuiViewport_sizeX);
    out->Size.x = value;
    value = env->GetFloatField(in, fid_ImGuiViewport_sizeY);
    out->Size.y = value;
    value = env->GetFloatField(in, fid_ImGuiViewport_posX);
    out->Pos.x = value;
    value = env->GetFloatField(in, fid_ImGuiViewport_posY);
    out->Pos.y = value;
}

void ImGuiHelper::SetImGuiViewport(JNIEnv* env, ImGuiViewport* in, jobject out, bool updateDrawData) {
    if(in->PlatformUserData != NULL) {
        intptr_t value = reinterpret_cast<intptr_t>(in->PlatformUserData);
        int platformUserData = static_cast<int>(value);
        env->SetIntField (out, fid_ImGuiViewport_platformUserData, platformUserData);
    }
    if(in->PlatformHandle != NULL) {
        int64_t * value = (int64_t*)in->PlatformHandle;
        env->SetLongField (out, fid_ImGuiViewport_platformHandle, *value);
    }
    env->SetIntField (out, fid_ImGuiViewport_flags, in->Flags);
    env->SetFloatField (out, fid_ImGuiViewport_sizeX, in->Size.x);
    env->SetFloatField (out, fid_ImGuiViewport_sizeY, in->Size.y);
    env->SetFloatField (out, fid_ImGuiViewport_posX, in->Pos.x);
    env->SetFloatField (out, fid_ImGuiViewport_posY, in->Pos.y);
    if(updateDrawData) {
        jobject obj_drawData = env->GetObjectField(out, fid_ImGuiViewport_drawData);
        ImGuiHelper::SetImDrawData(env, in->DrawData, obj_drawData);
    }
}

void ImGuiHelper::SetImDrawData(JNIEnv* env, ImDrawData* drawData, jobject jDrawData) {
    if(drawData != NULL) {
//        jobject obj_vertexBuffer = env->GetObjectField(jDrawData, fid_ImDrawData_vByteBuffer);
//        jobject obj_indexBuffer = env->GetObjectField(jDrawData, fid_ImDrawData_iByteBuffer);
//        jobject obj_cmdBuffer = env->GetObjectField(jDrawData, fid_ImDrawData_cmdByteBuffer);
//        unsigned char* indexBuffer = (unsigned char*)(obj_indexBuffer?env->GetDirectBufferAddress(obj_indexBuffer):0);
//        unsigned char* vertexBuffer = (unsigned char*)(obj_vertexBuffer?env->GetDirectBufferAddress(obj_vertexBuffer):0);
//        unsigned char* cmdBuffer = (unsigned char*)(obj_cmdBuffer?env->GetDirectBufferAddress(obj_cmdBuffer):0);
//        int cmdListsCount = drawData->CmdListsCount;
//
//        // Set values
//        env->SetIntField (jDrawData, fid_ImDrawData_totalVtxCount, drawData->TotalVtxCount);
//        env->SetIntField (jDrawData, fid_ImDrawData_totalIdxCount, drawData->TotalIdxCount);
//        env->SetIntField (jDrawData, fid_ImDrawData_CmdListsCount, cmdListsCount);
//
//        env->SetFloatField (jDrawData, fid_ImDrawData_displayPosX, drawData->DisplayPos.x);
//        env->SetFloatField (jDrawData, fid_ImDrawData_displayPosY, drawData->DisplayPos.y);
//
//        env->SetFloatField (jDrawData, fid_ImDrawData_displaySizeX, drawData->DisplaySize.x);
//        env->SetFloatField (jDrawData, fid_ImDrawData_displaySizeY, drawData->DisplaySize.y);
//
//        env->SetFloatField (jDrawData, fid_ImDrawData_framebufferScaleX, drawData->FramebufferScale.x);
//        env->SetFloatField (jDrawData, fid_ImDrawData_framebufferScaleY, drawData->FramebufferScale.y);
//
//        ImDrawList** drawLists = drawData->CmdLists;
//
//        int verticesOffset = 0;
//        int indicesOffset = 0;
//        int cmdOffset = 0;
//        int cmdCount = 0;
//
//        for(int i = 0; i < cmdListsCount; i++) {
//            ImDrawList & drawList = *drawLists[i];
//            ImVector<ImDrawCmd> & imDrawCmdList = drawList.CmdBuffer;
//            ImVector<ImDrawIdx> & idxBuffer = drawList.IdxBuffer;
//            ImVector<ImDrawVert> & vtxBuffer = drawList.VtxBuffer;
//
//            int verticeSize = sizeof(ImDrawVert);
//            int indicesSize = sizeof(ImDrawIdx);
//
//            float * vertexArrayDest = (float *)vertexBuffer;
//            short * indexArrayDest = (short *)indexBuffer;
//
//            int colorSize = 1;
//
//            vertexArrayDest[verticesOffset] = vtxBuffer.Size;
//            verticesOffset++;
//            // copy vertices to Destination buffer
//            for(int j = 0; j < vtxBuffer.Size; j++) {
//                ImDrawVert v = vtxBuffer[j];
//                float posX = v.pos.x;
//                float posY = v.pos.y;
//                float uvX = v.uv.x;
//                float uvY = v.uv.y;
//
//                float color = 0;
//                memcpy(&color, &v.col, 4); // move unsigned int color to float
//
//                vertexArrayDest[verticesOffset++] = posX;
//                vertexArrayDest[verticesOffset++] = posY;
//                vertexArrayDest[verticesOffset++] = uvX;
//                vertexArrayDest[verticesOffset++] = uvY;
//                vertexArrayDest[verticesOffset++] = color;
//            }
//
//            // copy index to destination buffer
//            indexArrayDest[indicesOffset] = idxBuffer.Size;
//            indicesOffset++;
//            for(int j = 0; j < idxBuffer.Size; j++) {
//                indexArrayDest[indicesOffset++] = idxBuffer[j];
//            }
//
//            float * cmdArrayDest = (float *)cmdBuffer;
//
//            cmdArrayDest[cmdOffset] = imDrawCmdList.Size;
//            cmdOffset++;
//            for (int cmd_i = 0; cmd_i < imDrawCmdList.Size; cmd_i++) {
//                const ImDrawCmd * pcmd = &imDrawCmdList[cmd_i];
//                float  textureID = (float)(intptr_t)pcmd->TextureId;
//                cmdArrayDest[cmdOffset++] = pcmd->ClipRect.x;
//                cmdArrayDest[cmdOffset++] = pcmd->ClipRect.y;
//                cmdArrayDest[cmdOffset++] = pcmd->ClipRect.z;
//                cmdArrayDest[cmdOffset++] = pcmd->ClipRect.w;
//                cmdArrayDest[cmdOffset++] = textureID;
//                cmdArrayDest[cmdOffset++] = pcmd->VtxOffset;
//                cmdArrayDest[cmdOffset++] = pcmd->IdxOffset;
//                cmdArrayDest[cmdOffset++] = pcmd->ElemCount;
//            }
//            cmdCount +=  imDrawCmdList.Size;
//        }
//        env->SetIntField (jDrawData, fid_ImDrawData_totalCmdCount, cmdCount);
    }
}
