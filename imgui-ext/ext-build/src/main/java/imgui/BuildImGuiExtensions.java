package imgui;

import com.github.xpenatan.jparser.builder.BuildConfig;
import com.github.xpenatan.jparser.builder.BuildMultiTarget;
import com.github.xpenatan.jparser.builder.BuildTarget;
import com.github.xpenatan.jparser.builder.JBuilder;
import com.github.xpenatan.jparser.builder.targets.EmscriptenTarget;
import com.github.xpenatan.jparser.builder.targets.WindowsTarget;
import com.github.xpenatan.jparser.idl.IDLReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BuildImGuiExtensions {

    public static void main(String[] args) throws Exception {
        build();
    }

    private static void build() throws IOException {
        String imguiPath = new File("./../../imgui").getCanonicalPath().replace("\\", "/");
        String extensionsPath = new File("./../../extensions").getCanonicalPath().replace("\\", "/");
        String idlPath = imguiPath + "/imgui-build/src/main/cpp/imgui.idl";
        IDLReader imguiIDLReader = IDLReader.readIDL(idlPath);
        ArrayList<BuildMultiTarget> targets = new ArrayList<>();

        if(BuildTarget.isWindows() || BuildTarget.isUnix()) {
            targets.add(getWindowBuildTarget(imguiPath, extensionsPath));
            targets.add(getEmscriptenBuildTarget(imguiPath, extensionsPath, idlPath));
//            targets.add(getAndroidBuildTarget());
        }

        String libName = "imgui";
        String basePackage = "imgui";

        String imguiBasePath = imguiPath + "/imgui-base";
        String imguiBuildPath = imguiPath + "/imgui-build";
        String imguiCorePath = imguiPath + "/imgui-core";
        String imguiTeavmPath = imguiPath + "/imgui-teavm";

        String buildCPPPath = imguiBuildPath + "/build/c++";
        String cppSourceDir = imguiBuildPath + "/build/imgui";
        String baseJavaDir = imguiBasePath + "/src/main/java";
        String libsDir = buildCPPPath + "/libs/";
        String cppDestinationPath = buildCPPPath + "/src";
        String libDestinationPath = cppDestinationPath + "/imgui";

        BuildConfig buildConfig = new BuildConfig(cppDestinationPath, buildCPPPath, libsDir, libName);
        JBuilder.build(buildConfig, targets);
    }

    private static BuildMultiTarget getWindowBuildTarget(String imguiPath, String extensionsPath) throws IOException {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";

        WindowsTarget glueTarget = new WindowsTarget();
        glueTarget.libDirSuffix += "ext/";
        glueTarget.addJNIHeaders();
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui/");
        glueTarget.headerDirs.add("-I" + imguiCppPath + "/src/jniglue");
        glueTarget.linkerFlags.add(imguiCppPath + "/libs/windows/imgui64.a");
        glueTarget.cppInclude.add(imguiCppPath + "/src/jniglue/JNIGlue.cpp");

        {
            String imlayoutCPPPath = extensionsPath + "/imlayout/imlayout-build/build/c++";
            // add library ImGuiColorTextEdit
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/imlayout/");
            glueTarget.headerDirs.add("-I" + imlayoutCPPPath + "/src/jniglue");
            glueTarget.linkerFlags.add(imlayoutCPPPath + "/libs/windows/imlayout64.a");
            glueTarget.headerDirs.add("-include" + imlayoutCPPPath + "/src/jniglue/JNIGlue.h");
        }
//        {
//            String textEditCPPPath = extensionsPath + "/ImGuiColorTextEdit/textedit-build/build/c++";
//            // add library ImGuiColorTextEdit
//            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/textedit/");
//            glueTarget.headerDirs.add("-I" + textEditCPPPath + "/src/jniglue");
//            glueTarget.linkerFlags.add(textEditCPPPath + "/libs/windows/textedit64.a");
//            glueTarget.headerDirs.add("-include" + textEditCPPPath + "/src/jniglue/JNIGlue.h");
//        }

        multiTarget.add(glueTarget);
        return multiTarget;
    }

    private static BuildMultiTarget getEmscriptenBuildTarget(String imguiPath, String extensionsPath, String imguiIDLReaderPath) {
        BuildMultiTarget multiTarget = new BuildMultiTarget();
        String imguiCppPath = imguiPath + "/imgui-build/build/c++";
        IDLReader idlReaderCombined = IDLReader.readIDL(imguiIDLReaderPath);

        // Compile glue code and link to make js file
        EmscriptenTarget linkTarget = new EmscriptenTarget(idlReaderCombined);
        linkTarget.libDirSuffix += "ext/";
        linkTarget.headerDirs.add("-I" + imguiCppPath + "/src/imgui");
        linkTarget.headerDirs.add("-include" + imguiCppPath + "/src/imgui/ImGuiCustom.h");
        linkTarget.linkerFlags.add(imguiCppPath + "/libs/emscripten/imgui.a");

        {
            String imlayoutCppPath = extensionsPath + "/imlayout/imlayout-build/build/c++";
            String imlayoutIdlPath = extensionsPath + "/imlayout/imlayout-build/src/main/cpp/imlayout.idl";
            IDLReader.addIDL(idlReaderCombined, imlayoutIdlPath);
            linkTarget.headerDirs.add("-I" + imlayoutCppPath + "/src/imlayout");
            linkTarget.headerDirs.add("-include" + imlayoutCppPath + "/src/imlayout/ImLayoutCustom.h");
            linkTarget.linkerFlags.add(imlayoutCppPath + "/libs/emscripten/imlayout.a");
        }
        multiTarget.add(linkTarget);

        return multiTarget;
    }
}
