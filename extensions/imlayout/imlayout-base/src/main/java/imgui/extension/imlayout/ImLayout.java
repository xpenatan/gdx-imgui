package imgui.extension.imlayout;

public class ImLayout {
    /*[-JNI;-NATIVE]
        #include "imgui_layout.h"
    */

    public static final int WRAP_PARENT = WRAP_PARENT();
    public static final int MATCH_PARENT = MATCH_PARENT();
    public static final int MATCH_WRAP_PARENT = MATCH_WRAP_PARENT();

    public static native int WRAP_PARENT();
    public static native int MATCH_PARENT();
    public static native int MATCH_WRAP_PARENT();
}