package imgui;

import com.github.xpenatan.jparser.loader.JParserLibraryLoader;

/**
 * @author xpenatan
 */
public class ImGuiLoader {

    /*[-C++;-NATIVE]
        #include "ImGuiWrapper.h"
    */

    /*[-teaVM;-ADD]
        @org.teavm.jso.JSFunctor
        public interface OnInitFunction extends org.teavm.jso.JSObject {
            void onInit();
        }
    */

    /*[-teaVM;-REPLACE]
     public static void init(Runnable run) {
        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
        OnInitFunction onInitFunction = new OnInitFunction() {
            @Override
            public void onInit() {
                run.run();
            }
        };
        setOnLoadInit(onInitFunction);
        libraryLoader.load("imgui.wasm");
    }
    */
    public static void init(Runnable run) {
        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
        libraryLoader.load("imgui");
        run.run();
    }

    /*[-teaVM;-REPLACE]
        @org.teavm.jso.JSBody(params = { "onInitFunction" }, script = "window.imguiOnInit = onInitFunction;")
        private static native void setOnLoadInit(OnInitFunction onInitFunction);
    */
    /*[-C++;-REMOVE] */
    public static native void setOnLoadInit();

}