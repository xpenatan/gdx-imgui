package imgui;

import com.github.xpenatan.jparser.loader.JParserLibraryLoader;
import com.github.xpenatan.jparser.loader.JParserLibraryLoaderListener;

/**
 * @author xpenatan
 */
public class ImGuiLoader {

    /*[-JNI;-NATIVE]
        #include "ImGuiCustom.h"
    */

    public static void init(JParserLibraryLoaderListener listener) {
        JParserLibraryLoader.load("imgui", listener);
    }
}