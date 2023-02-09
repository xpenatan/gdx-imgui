#include <emscripten.h>
#include <imgui.h>

typedef ImVector<ImDrawCmd> VecCmdBuffer;
typedef ImVector<ImDrawIdx> VecIdxBuffer;
typedef ImVector<ImDrawVert> VecVtxBuffer;

class Im {
    public:
        static ImGuiContext* CreateContext() { return ImGui::CreateContext(); }
        static bool Begin(const char* name) { return ImGui::Begin(name); }
        static void End() { ImGui::End(); }
        static void Render() { ImGui::Render(); }
        static void NewFrame() { ImGui::NewFrame(); }
        static ImGuiIO& GetIO() { return ImGui::GetIO(); }
        static ImDrawData* GetDrawData() { return ImGui::GetDrawData(); }
        static void SetNextWindowSize(const ImVec2& size, ImGuiCond cond = 0) { ImGui::SetNextWindowSize(size, cond); }
        static void ShowDemoWindow(bool* p_open = NULL) { ImGui::ShowDemoWindow(p_open); }
        static bool Checkbox(const char* label, bool* v) { return ImGui::Checkbox(label, v); }
};