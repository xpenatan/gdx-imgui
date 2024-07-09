package imgui;

import com.github.xpenatan.jparser.loader.JParserLibraryLoader;

/**
 * @author xpenatan
 */
public class ImGuiLoader {

    /*[-JNI;-NATIVE]
        #include "ImGuiCustom.h"
    */

    /*[-TEAVM;-ADD]
        @org.teavm.jso.JSFunctor
        public interface OnInitFunction extends org.teavm.jso.JSObject {
            void onInit();
        }
    */

    /*[-TEAVM;-REPLACE]
     public static void init(Runnable onSuccess) {
        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
        OnInitFunction onInitFunction = onSuccess::run;
        setOnLoadInit(onInitFunction);
        libraryLoader.load("[MODULE].wasm", isSuccess -> {});
    }
    */
    public static void init(Runnable onSuccess) {
        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
        libraryLoader.load("imgui", isSuccess -> {
            if(isSuccess) {
                onSuccess.run();
            }
        });
    }

    /*[-TEAVM;-REPLACE]
        @org.teavm.jso.JSBody(params = { "onInitFunction" }, script = "window.[MODULE]OnInit = onInitFunction;")
        private static native void setOnLoadInit(OnInitFunction onInitFunction);
    */
    /*[-JNI;-REMOVE] */
    public static native void setOnLoadInit();

}