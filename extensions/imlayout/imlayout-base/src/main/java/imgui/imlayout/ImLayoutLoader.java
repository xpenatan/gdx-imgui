package imgui.imlayout;

import com.github.xpenatan.jparser.loader.JParserLibraryLoader;

/**
 * @author xpenatan
 */
public class ImLayoutLoader {

    /*[-teaVM;-ADD]
        @org.teavm.jso.JSFunctor
        public interface OnInitFunction extends org.teavm.jso.JSObject {
            void onInit();
        }
    */

    /*[-teaVM;-REPLACE]
    public static void init(Runnable run) {
        run.run();
//        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
//        OnInitFunction onInitFunction = new OnInitFunction() {
//            @Override
//            public void onInit() {
//                run.run();
//            }
//        };
//        setOnLoadInit(onInitFunction);
//        libraryLoader.load("imlayout.wasm");
    }
    */
    public static void init(Runnable run) {
        JParserLibraryLoader libraryLoader = new JParserLibraryLoader();
        libraryLoader.load("imlayout");
        run.run();
    }

    /*[-teaVM;-REPLACE]
        @org.teavm.jso.JSBody(params = { "onInitFunction" }, script = "window.imlayoutOnInit = onInitFunction;")
        private static native void setOnLoadInit(OnInitFunction onInitFunction);
    */
    /*[-C++;-REMOVE] */
    public static native void setOnLoadInit();

}