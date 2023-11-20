package imgui;

import idl.helper.IDLBool;
import idl.helper.IDLDouble;
import idl.helper.IDLFloat;
import idl.helper.IDLInt;

/**
 * @author xpenatan
 */
public class ImGui {

    public static void UpdateDisplayAndInputAndFrame(float deltaTime, int width, int height, int backBufferWidth, int backBufferHeight) {
        UpdateDisplayAndInputAndFrameNative(deltaTime, width, height, backBufferWidth, backBufferHeight);
    }

    /*[-teaVM;-NATIVE]
        var io = [MODULE].ImGui.prototype.GetIO();
        io.get_DisplaySize().set_x(width);
        io.get_DisplaySize().set_y(height);
        if (width > 0 && height > 0) {
            io.get_DisplayFramebufferScale().set_x(display_w / width);
            io.get_DisplayFramebufferScale().set_y(display_h / height);
        }
        io.set_DeltaTime = deltaTime;
        [MODULE].ImGui.prototype.NewFrame();
    */
    /*[-C++;-NATIVE]
        ImGuiIO * io = &ImGui::GetIO();

        io->DisplaySize = ImVec2(width, height);
        if (width > 0 && height > 0)
            io->DisplayFramebufferScale = ImVec2((float)display_w / width, (float)display_h / height);
        io->DeltaTime = deltaTime;

        ImGui::NewFrame();
    */
    public static native void UpdateDisplayAndInputAndFrameNative(float deltaTime, int width, int height, int display_w, int display_h);


    /*[-IDL_SKIP]*/
    public static void CreateContext() {
    }

    /*[-teaVM;-NATIVE]
        [MODULE].ImGui.prototype.CreateContext();
    */
    /*[-C++;-NATIVE]
        ImGui::CreateContext();
        if(saveIni == false) {
            ImGui::GetIO().IniFilename = NULL;
        }
        ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_HasMouseCursors;
    */
    public static native void CreateContext(boolean saveIni);

    /**
     * Dispose temp objects.
     */
    public static void disposeStatic() {
        IDLFloat.disposeTEMP();
        IDLDouble.disposeTEMP();
        IDLInt.disposeTEMP();
        IDLBool.disposeTEMP();
    }
}