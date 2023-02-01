#include <emscripten.h>
#include <imgui.h>

class Im {
    public:
        static bool Begin(const char* name, bool* p_open = NULL, ImGuiWindowFlags flags = 0) {
            return ImGui::Begin(name, p_open, flags);
        }
        static void End() {
            ImGui::End();
        }
};